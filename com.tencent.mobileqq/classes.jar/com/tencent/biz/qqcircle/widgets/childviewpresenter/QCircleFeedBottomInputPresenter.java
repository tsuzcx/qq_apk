package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedViewExportEvent;
import com.tencent.biz.qqcircle.events.QCircleRelocationScrollEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.animation.interpolator.EaseCubicInterpolator;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleFeedBottomInputPresenter
  extends QCircleBaseFeedChildPresenter
  implements View.OnClickListener, LayoutPreLoader.RequestPreloadViewListener, SimpleEventReceiver, IQQFrontBackListener
{
  private static final long BOTTOM_DISPLAY_INPUT_ANIMATION_DURATION = 400L;
  private static final String TAG = "QCircleFeedBottomInputPresenter";
  private boolean isEnableBottomInput = false;
  private Activity mActivity;
  private ValueAnimator mBottomInputAnimator;
  private View mCommentInputBox;
  private TextView mCommentInputText;
  private ImageView mCommentShareIconView;
  private View mCommentShareView;
  private QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource mFeedBottomVisibleStateSource;
  private long mFeedExposeDelayed = 5000L;
  private View mInputAndShareView;
  private boolean mIsRunForeground = true;
  private Drawable mProfileDrawable = null;
  private SquareImageView mQCircleAvatarView;
  private QCircleFeedBottomInputPresenter.QCircleFeedBottomInputRunnable mQCircleFeedBottomInputRunnable = null;
  private RecyclerView mRecyclerView;
  
  static {}
  
  private void cancelDelayedTask()
  {
    if (this.mQCircleFeedBottomInputRunnable != null)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, new Object[] { "[QCFE][cancelDelayedTask] feed id: ", obtainCurrentFeedId() });
      RFThreadManager.getUIHandler().removeCallbacks(this.mQCircleFeedBottomInputRunnable);
      this.mQCircleFeedBottomInputRunnable = null;
    }
  }
  
  private boolean checkBottomInputAnimation()
  {
    ValueAnimator localValueAnimator = this.mBottomInputAnimator;
    return (localValueAnimator != null) && (localValueAnimator.isRunning());
  }
  
  private void handleInputAnimationRelocationScroll(QCircleRelocationScrollEvent paramQCircleRelocationScrollEvent)
  {
    if (this.mBottomInputAnimator == null) {
      return;
    }
    if (this.mInputAndShareView == null) {
      return;
    }
    QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][handleInputAnimationRelocationScroll] animation is running, cancel animation.");
    this.mBottomInputAnimator.cancel();
    this.mInputAndShareView.clearAnimation();
    setInputAndShareViewHeight(ViewUtils.a(48.0F));
    this.mInputAndShareView.post(new QCircleFeedBottomInputPresenter.1(this, paramQCircleRelocationScrollEvent));
  }
  
  private void initViewValue()
  {
    if (this.mCommentInputText == null)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][initViewValue] comment input text is null.");
      return;
    }
    String str = QCircleConfigHelper.a("qqcircle", "qcircle_comment_input_place_holder", QCircleApplication.APP.getResources().getString(2131895654));
    this.mCommentInputText.setText(str);
  }
  
  private FeedCloudMeta.StFeed obtainCurrentFeed()
  {
    if (!(this.mData instanceof FeedBlockData))
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][obtainCurrentFeedId] updateBottomInputAndShareBox data type illegality.");
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
  
  private void relocationRecyclerScroll(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > paramInt1) {
      i = paramInt2 - paramInt1;
    } else if (paramInt2 < paramInt1) {
      i = -(paramInt1 - paramInt2);
    } else {
      i = 0;
    }
    QLog.d("QCircleFeedBottomInputPresenter", 1, new Object[] { "[QCFE][relocationRecyclerScroll] displayY: ", Integer.valueOf(paramInt1), " | viewY: ", Integer.valueOf(paramInt2), " | offsetY: ", Integer.valueOf(i) });
    this.mRecyclerView.smoothScrollBy(0, i);
  }
  
  private void relocationScrollToFixationInput(QCircleRelocationScrollEvent paramQCircleRelocationScrollEvent)
  {
    if (this.mInputAndShareView == null)
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][relocationScrollToFixationInput] input share view not is null.");
      return;
    }
    QCircleInsFeedItemView localQCircleInsFeedItemView = getParentView();
    int[] arrayOfInt = new int[2];
    localQCircleInsFeedItemView.getLocationInWindow(arrayOfInt);
    int k = localQCircleInsFeedItemView.getHeight();
    int m = DisplayUtil.a(QCircleApplication.APP);
    int n = ViewUtils.a(48.0F);
    int j = ViewUtils.a(20.0F);
    int i1 = arrayOfInt[1];
    int i = j;
    if (this.mInputAndShareView.getVisibility() == 0) {
      i = j + n;
    }
    relocationRecyclerScroll(m - paramQCircleRelocationScrollEvent.mKeyboardHeight - n, k + i1 - i);
  }
  
  private void relocationScrollToInput(QCircleRelocationScrollEvent paramQCircleRelocationScrollEvent)
  {
    View localView = this.mInputAndShareView;
    if (localView == null)
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][relocationScrollToInput] input share view not is null.");
      return;
    }
    int[] arrayOfInt = new int[2];
    localView.getLocationInWindow(arrayOfInt);
    int i = this.mInputAndShareView.getHeight();
    relocationRecyclerScroll(DisplayUtil.a(this.mActivity) - paramQCircleRelocationScrollEvent.mKeyboardHeight - i, arrayOfInt[1]);
  }
  
  private void reportCommentInputAndShareAction(int paramInt1, int paramInt2)
  {
    if (this.mReportInfo != null) {
      localObject = this.mReportInfo.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(paramInt1).setSubActionType(paramInt2);
    if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
      localObject = this.mReportInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    if (this.mReportInfo != null) {
      paramInt1 = this.mReportInfo.mDataPosition;
    } else {
      paramInt1 = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(paramInt1).setPageId(getPageId())));
  }
  
  private void setInputAndShareViewHeight(int paramInt)
  {
    Object localObject = this.mInputAndShareView;
    if (localObject == null)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][setInputAndShareViewHeight] input and share view not is null.");
      return;
    }
    localObject = ((View)localObject).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = paramInt;
    this.mInputAndShareView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void setInputAndShareViewVisible()
  {
    if (!this.isEnableBottomInput) {
      return;
    }
    if (this.mQCircleAvatarView != null)
    {
      if (this.mProfileDrawable == null) {
        this.mProfileDrawable = QCirclePluginGlobalInfo.a(HostDataTransUtils.getAccount());
      }
      this.mQCircleAvatarView.setImageDrawable(this.mProfileDrawable);
    }
    if (this.mInputAndShareView.getVisibility() != 0)
    {
      this.mInputAndShareView.setVisibility(0);
      reportCommentInputAndShareAction(116, 1);
    }
  }
  
  private void setInputAndShareViewVisible(String paramString)
  {
    if (this.mInputAndShareView == null)
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][setInputAndShareViewVisible] input and share view not is null.");
      return;
    }
    QLog.d("QCircleFeedBottomInputPresenter", 1, new Object[] { "[QCFE][setInputAndShareViewVisible] feedId: ", paramString });
    Object localObject = new TranslateAnimation(0.0F, 0.0F, -ViewUtils.d(28.0F), 0.0F);
    ((Animation)localObject).setDuration(400L);
    ((Animation)localObject).setInterpolator(new EaseCubicInterpolator(0.0F, 0.0F, 0.58F, 1.0F));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setInterpolator(new EaseCubicInterpolator(0.0F, 0.0F, 1.0F, 1.0F));
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation((Animation)localObject);
    this.mInputAndShareView.startAnimation(localAnimationSet);
    setInputAndShareViewHeight(0);
    this.mBottomInputAnimator = ValueAnimator.ofInt(new int[] { 0, ViewUtils.a(48.0F) });
    this.mBottomInputAnimator.setInterpolator(new EaseCubicInterpolator(0.0F, 0.0F, 0.58F, 1.0F));
    this.mBottomInputAnimator.setDuration(400L);
    this.mBottomInputAnimator.addUpdateListener(new QCircleFeedBottomInputPresenter.2(this));
    this.mBottomInputAnimator.start();
    setInputAndShareViewVisible();
    localObject = this.mFeedBottomVisibleStateSource;
    if (localObject != null)
    {
      ((QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource)localObject).a(paramString, 0);
      return;
    }
    QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][setInputAndShareViewVisible] feed bottom visible state source not is null.");
  }
  
  private void setOnClick()
  {
    this.mCommentInputBox.setOnClickListener(this);
    this.mCommentShareView.setOnClickListener(this);
  }
  
  private void updateBottomInputAndShareBox(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputAndShareBox] feed not is null.");
      return;
    }
    Object localObject = obtainCurrentFeed();
    if (localObject == null)
    {
      QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputAndShareBox] current feed not is null.");
      return;
    }
    if (!this.mIsRunForeground)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputAndShareBox] page not in foreground run.");
      return;
    }
    View localView = this.mInputAndShareView;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputAndShareBox] current input share view is showing.");
      return;
    }
    paramStFeed = paramStFeed.id.get();
    localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
    if (TextUtils.equals((CharSequence)localObject, paramStFeed)) {
      setInputAndShareViewVisible((String)localObject);
    }
  }
  
  private void updateBottomInputBoxVisible(String paramString)
  {
    Object localObject = this.mInputAndShareView;
    int i = 1;
    if (localObject == null)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputBoxVisible] share view not is null.");
      return;
    }
    localObject = this.mFeedBottomVisibleStateSource;
    if (localObject == null)
    {
      QLog.d("QCircleFeedBottomInputPresenter", 1, "[QCFE][updateBottomInputBoxVisible] feed bottom visible state source not is null.");
      return;
    }
    if (((QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource)localObject).a(paramString) != 0) {
      i = 0;
    }
    if (i != 0)
    {
      if (this.mInputAndShareView.getVisibility() != 0) {
        setInputAndShareViewVisible();
      }
    }
    else {
      this.mInputAndShareView.setVisibility(8);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedBlockData)))
    {
      this.mReportInfo.mDataPosition = this.mPos;
      this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
      this.mReportInfo.mPlayScene = 1;
      paramObject = ((FeedBlockData)this.mData).b();
      if (paramObject.opMask2.get().contains(Integer.valueOf(14))) {
        setInputAndShareViewVisible();
      } else {
        updateBottomInputBoxVisible(paramObject.id.get());
      }
      if (QCircleConfigHelper.ao()) {
        this.mCommentShareView.setVisibility(8);
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedViewExportEvent.class);
    localArrayList.add(QCircleRelocationScrollEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedBottomInputPresenter";
  }
  
  public QCircleReportBean getReportBean()
  {
    return super.getReportBean();
  }
  
  public void initView(View paramView)
  {
    if ((paramView.getContext() instanceof Activity)) {
      this.mActivity = ((Activity)paramView.getContext());
    }
    this.mFeedExposeDelayed = QCircleConfigHelper.a("qqcircle", "qqcircle_feed_show_cmt_share_view_duration", Integer.valueOf(5000)).intValue();
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440925), this);
  }
  
  public void onAttachedToWindow()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    cancelDelayedTask();
    QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(this);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mInputAndShareView = this.mContainer.findViewById(2131441584);
    this.mCommentInputBox = this.mContainer.findViewById(2131441583);
    this.mCommentShareView = this.mContainer.findViewById(2131441586);
    this.mCommentShareIconView = ((ImageView)this.mContainer.findViewById(2131441585));
    this.mQCircleAvatarView = ((SquareImageView)this.mContainer.findViewById(2131441582));
    this.mCommentInputText = ((TextView)this.mContainer.findViewById(2131441628));
    setOnClick();
    initViewValue();
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
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
    if ((paramSimpleBaseEvent instanceof QCircleFeedViewExportEvent))
    {
      updateFeedExportStatus((QCircleFeedViewExportEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleRelocationScrollEvent)) {
      updateRelocationScroll((QCircleRelocationScrollEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setEnableBottomInput(boolean paramBoolean)
  {
    this.isEnableBottomInput = paramBoolean;
  }
  
  public void setFeedBottomVisibleStateSource(QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource paramFeedBottomVisibleStateSource)
  {
    this.mFeedBottomVisibleStateSource = paramFeedBottomVisibleStateSource;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(Object paramObject) {}
  
  public void updateFeedExportStatus(QCircleFeedViewExportEvent paramQCircleFeedViewExportEvent)
  {
    String str = obtainCurrentFeedId();
    boolean bool = paramQCircleFeedViewExportEvent.obtainBundle().getBoolean("is_enable_bottom_input", false);
    if ((this.mIsRunForeground) && (bool))
    {
      if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(paramQCircleFeedViewExportEvent.getFeedId(), str)))
      {
        paramQCircleFeedViewExportEvent = obtainCurrentFeed();
        if ((paramQCircleFeedViewExportEvent != null) && (paramQCircleFeedViewExportEvent.opMask2 != null) && (paramQCircleFeedViewExportEvent.opMask2.get().contains(Integer.valueOf(14))))
        {
          updateBottomInputAndShareBox(paramQCircleFeedViewExportEvent);
          return;
        }
        if (this.mQCircleFeedBottomInputRunnable == null)
        {
          QLog.d("QCircleFeedBottomInputPresenter", 1, new Object[] { "[QCFE][updateFeedExportStatus] start delayed task, feed id: ", str });
          this.mQCircleFeedBottomInputRunnable = new QCircleFeedBottomInputPresenter.QCircleFeedBottomInputRunnable(this, paramQCircleFeedViewExportEvent);
          RFThreadManager.getUIHandler().postDelayed(this.mQCircleFeedBottomInputRunnable, this.mFeedExposeDelayed);
        }
        return;
      }
      cancelDelayedTask();
      return;
    }
    cancelDelayedTask();
  }
  
  public void updateRelocationScroll(QCircleRelocationScrollEvent paramQCircleRelocationScrollEvent)
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    if (TextUtils.equals(((FeedBlockData)this.mData).b().id.get(), paramQCircleRelocationScrollEvent.mFeedId))
    {
      if (this.mRecyclerView == null) {
        return;
      }
      if (this.mInputAndShareView == null) {
        return;
      }
      if (paramQCircleRelocationScrollEvent.mRelocationType <= 100)
      {
        QLog.w("QCircleFeedBottomInputPresenter", 1, "[QCFE] [updateRelocationScroll] illegality type, not handle.");
        return;
      }
      if (checkBottomInputAnimation())
      {
        handleInputAnimationRelocationScroll(paramQCircleRelocationScrollEvent);
        return;
      }
      View localView = this.mInputAndShareView;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        relocationScrollToInput(paramQCircleRelocationScrollEvent);
        return;
      }
      relocationScrollToFixationInput(paramQCircleRelocationScrollEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedBottomInputPresenter
 * JD-Core Version:    0.7.0.1
 */