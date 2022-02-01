package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.events.QCircleFeedViewExportEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StSameTopicGuideInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;

public class QCircleFeedItemTagGuidePresenter
  extends QCircleBaseFeedChildPresenter
  implements SimpleEventReceiver, IQQFrontBackListener
{
  private static final long DEFAULT_GUIDE_TAG_DELAY_TIME = 3000L;
  private static final int IS_SAME_TOPIC_GUIDE = 1;
  private static final String KEY_YUHENG_CHANNEL_TRANSINFO = "YuhengChannelTransInfo";
  private static final String TAG = "QCircleFeedItemTagGuidePresenter";
  private ObjectAnimator mAppearAnimator;
  private View.OnAttachStateChangeListener mContainerAttachListener;
  private View mDividerPoint;
  private boolean mIsRunForeground = true;
  private ImageView mIvArrow;
  private QCircleFeedItemTagGuidePresenter.QCircleFeedGuideTagRunnable mQCircleFeedGuideTagRunnable = null;
  private TextView mTvContent;
  private TextView mTvHashTag;
  
  private void cancelDelayedTask()
  {
    if (this.mQCircleFeedGuideTagRunnable != null)
    {
      RFThreadManager.getUIHandler().removeCallbacks(this.mQCircleFeedGuideTagRunnable);
      this.mQCircleFeedGuideTagRunnable = null;
    }
  }
  
  private void clearOldAnimation()
  {
    ObjectAnimator localObjectAnimator = this.mAppearAnimator;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      this.mAppearAnimator.end();
    }
  }
  
  private FeedCloudMeta.StFeed obtainCurrentFeed()
  {
    if (!(this.mData instanceof FeedBlockData))
    {
      QLog.w("QCircleFeedItemTagGuidePresenter", 1, "[QCFE][obtainCurrentFeedId] updateBottomInputAndShareBox data type illegality.");
      return null;
    }
    return ((FeedBlockData)this.mData).b();
  }
  
  private String obtainCurrentFeedId()
  {
    FeedCloudMeta.StFeed localStFeed = obtainCurrentFeed();
    if (localStFeed == null) {
      return "";
    }
    return localStFeed.id.get();
  }
  
  private void reportTagGuideInfo(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("YuhengChannelTransInfo", paramStFeed.sameTopicGuideInfo.reportExt.get());
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramStFeed.poster.id.get()).setFeedId(paramStFeed.id.get()).setFeedTag(paramStFeed.sameTopicGuideInfo.hashTag.get()).setExtras(localHashMap).setPageId(getPageId())));
  }
  
  private void showAppearAnimation(View paramView)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      if (this.mAppearAnimator == null) {
        this.mAppearAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(400L);
      }
      this.mAppearAnimator.start();
    }
  }
  
  private void updateGuideTagView(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("QCircleFeedItemTagGuidePresenter", 1, "[QCFE][updateGuideTagView] current feed not is null.");
      return;
    }
    Object localObject = obtainCurrentFeed();
    if (localObject == null)
    {
      QLog.w("QCircleFeedItemTagGuidePresenter", 1, "[QCFE][updateGuideTagView] data type illegality.");
      return;
    }
    if (!this.mIsRunForeground)
    {
      QLog.d("QCircleFeedItemTagGuidePresenter", 1, "[QCFE][updateBottomInputAndShareBox] page not in foreground run.");
      return;
    }
    String str = paramStFeed.id.get();
    localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
    if (TextUtils.equals((CharSequence)localObject, str)) {
      if (!QCircleHostGlobalInfo.getExposedGuideFeedIdList().contains(localObject))
      {
        QCircleHostGlobalInfo.getExposedGuideFeedIdList().add(localObject);
        clearOldAnimation();
        showAppearAnimation(this.mContainer);
        if ((this.mContainer != null) && (ViewCompat.isAttachedToWindow(this.mContainer))) {
          reportTagGuideInfo(paramStFeed, 119, 1);
        }
      }
      else if (this.mContainer != null)
      {
        this.mContainer.setVisibility(0);
      }
    }
  }
  
  private void updateTagGuideView(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    if (paramStFeed.sameTopicGuideInfo.isSameTopicGuide.get() != 1) {
      return;
    }
    if ((this.mTvHashTag != null) && (this.mTvContent != null))
    {
      if (this.mContainer == null) {
        return;
      }
      this.mTvHashTag.setText(paramStFeed.sameTopicGuideInfo.hashTag.get());
      this.mTvContent.setText(paramStFeed.sameTopicGuideInfo.words.get());
      this.mContainer.setOnClickListener(new QCircleFeedItemTagGuidePresenter.2(this, paramStFeed));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedBlockData))
    {
      this.mData = paramObject;
      paramObject = ((FeedBlockData)paramObject).b();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindData:feedid = ");
      ((StringBuilder)localObject).append(paramObject.id.get());
      ((StringBuilder)localObject).append("feed.sameTopicGuideInfo.has() = ");
      ((StringBuilder)localObject).append(paramObject.sameTopicGuideInfo.has());
      ((StringBuilder)localObject).append("hashtag = ");
      ((StringBuilder)localObject).append(paramObject.sameTopicGuideInfo.hashTag.get());
      QLog.d("QCircleFeedItemTagGuidePresenter", 1, ((StringBuilder)localObject).toString());
      localObject = (FrameLayout.LayoutParams)this.mContainer.getLayoutParams();
      if (paramObject.type.get() == 2) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(10.0F);
      } else if (paramObject.type.get() == 3) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(34.0F);
      }
      this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((QCircleHostGlobalInfo.getExposedGuideFeedIdList().contains(paramObject.id.get())) && (paramObject.sameTopicGuideInfo.has()) && (paramObject.sameTopicGuideInfo.isSameTopicGuide.get() == 1)) {
        this.mContainer.setVisibility(0);
      } else {
        this.mContainer.setVisibility(8);
      }
      this.mContainerAttachListener = new QCircleFeedItemTagGuidePresenter.1(this, paramObject);
      this.mContainer.addOnAttachStateChangeListener(this.mContainerAttachListener);
      updateTagGuideView(paramObject);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedViewExportEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemTagGuidePresenter";
  }
  
  public void initView(View paramView)
  {
    this.mContainer = LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440936));
    this.mTvHashTag = ((TextView)this.mContainer.findViewById(2131441907));
    this.mTvContent = ((TextView)this.mContainer.findViewById(2131441905));
    this.mDividerPoint = this.mContainer.findViewById(2131441609);
    this.mDividerPoint.setBackgroundResource(2130845436);
    this.mIvArrow = ((ImageView)this.mContainer.findViewById(2131441700));
    this.mIvArrow.setImageResource(2130845350);
    this.mContainer.setVisibility(8);
  }
  
  public void onAttachedToWindow()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this);
  }
  
  public void onDetachedFromWindow()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    cancelDelayedTask();
    QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(this);
  }
  
  public void onQQEnterBackground()
  {
    this.mIsRunForeground = false;
  }
  
  public void onQQEnterForeground()
  {
    this.mIsRunForeground = true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedViewExportEvent)) {
      updateFeedExportStatus((QCircleFeedViewExportEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setReportBean(Object paramObject) {}
  
  public void updateFeedExportStatus(QCircleFeedViewExportEvent paramQCircleFeedViewExportEvent)
  {
    String str = obtainCurrentFeedId();
    if (!this.mIsRunForeground) {
      return;
    }
    if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(paramQCircleFeedViewExportEvent.getFeedId(), str)))
    {
      paramQCircleFeedViewExportEvent = obtainCurrentFeed();
      if ((paramQCircleFeedViewExportEvent != null) && (paramQCircleFeedViewExportEvent.sameTopicGuideInfo.has()))
      {
        int j = paramQCircleFeedViewExportEvent.sameTopicGuideInfo.isSameTopicGuide.get();
        int i = 1;
        if (j == 1)
        {
          if (this.mQCircleFeedGuideTagRunnable == null)
          {
            this.mQCircleFeedGuideTagRunnable = new QCircleFeedItemTagGuidePresenter.QCircleFeedGuideTagRunnable(this, paramQCircleFeedViewExportEvent);
            if (paramQCircleFeedViewExportEvent.sameTopicGuideInfo.stayShowTime.get() == 0L) {
              i = 0;
            }
            long l = paramQCircleFeedViewExportEvent.sameTopicGuideInfo.stayShowTime.get() * 1000L;
            if (i == 0) {
              l = 3000L;
            }
            RFThreadManager.getUIHandler().postDelayed(this.mQCircleFeedGuideTagRunnable, l);
          }
          return;
        }
      }
      cancelDelayedTask();
      return;
    }
    cancelDelayedTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemTagGuidePresenter
 * JD-Core Version:    0.7.0.1
 */