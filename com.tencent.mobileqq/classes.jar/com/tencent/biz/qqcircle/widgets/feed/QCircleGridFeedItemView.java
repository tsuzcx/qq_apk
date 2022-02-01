package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimationInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleGridFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, EnhanceItemAnimationInterface
{
  public static final int GRID_FEED_ITEM_SIZE = (int)(ImmersiveUtils.b() * 1.0F / 3.0F);
  public static final int PIC_LOAD_SIZE;
  private static final String TAG = "QCircleGridFeedItemView";
  private Object mData;
  private ImageView mIvExtraInfo;
  private SquareImageView mIvFeedCover;
  private int mPosition;
  private TextView mTvExtraInfo;
  
  static
  {
    double d = ImmersiveUtils.b();
    Double.isNaN(d);
    PIC_LOAD_SIZE = (int)(d * 0.3D) * 2;
  }
  
  public QCircleGridFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void reportJumpContentPageIn5504()
  {
    Object localObject = QCirclePluginUtil.d(getContext());
    byte[] arrayOfByte = null;
    String str2;
    String str1;
    if (localObject != null)
    {
      str2 = ((FeedCloudMeta.StFeed)localObject).id.get();
      str1 = str2;
      if (((FeedCloudMeta.StFeed)localObject).busiReport.has())
      {
        arrayOfByte = ((FeedCloudMeta.StFeed)localObject).busiReport.get().toByteArray();
        str1 = str2;
      }
    }
    else
    {
      str1 = "";
    }
    localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePluginUtil.b(getContext())).setActionType(11).setSubActionType(19).setThrActionType(5);
    if (QCirclePluginUtil.e(getContext())) {
      str2 = "1";
    } else {
      str2 = "2";
    }
    QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1(str2).setExt9(str1).setFeedReportInfo(arrayOfByte).setPageId(getPageId()));
  }
  
  private void updateExtraIconVisibility()
  {
    Object localObject = this.mData;
    if ((localObject instanceof FeedBlockData))
    {
      localObject = ((FeedBlockData)localObject).b();
      if (((FeedCloudMeta.StFeed)localObject).type.get() == 3)
      {
        this.mIvExtraInfo.setVisibility(0);
        this.mTvExtraInfo.setVisibility(8);
        return;
      }
      if (((FeedCloudMeta.StFeed)localObject).type.get() == 2)
      {
        this.mIvExtraInfo.setVisibility(8);
        if (((FeedCloudMeta.StFeed)localObject).images.size() > 1)
        {
          this.mTvExtraInfo.setText(String.valueOf(((FeedCloudMeta.StFeed)localObject).images.size()));
          this.mTvExtraInfo.setVisibility(0);
          return;
        }
        this.mTvExtraInfo.setVisibility(8);
        return;
      }
      this.mIvExtraInfo.setVisibility(8);
      this.mTvExtraInfo.setVisibility(8);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPosition = paramInt;
    if (((this.mData instanceof FeedBlockData)) && (this.mIvFeedCover != null))
    {
      Object localObject = ((FeedBlockData)paramObject).b();
      paramObject = this.mIvFeedCover.getLayoutParams();
      int i = GRID_FEED_ITEM_SIZE;
      paramObject.height = i;
      paramObject.width = i;
      this.mIvFeedCover.setLayoutParams(paramObject);
      paramObject = URLDrawable.URLDrawableOptions.obtain();
      paramObject.mLoadingDrawable = this.mIvFeedCover.getContext().getResources().getDrawable(2130845089);
      paramObject.mFailedDrawable = this.mIvFeedCover.getContext().getResources().getDrawable(2130845199);
      if ((getTag(2131441759) instanceof String)) {
        paramObject = (String)getTag(2131441759);
      } else {
        paramObject = "";
      }
      localObject = ((FeedCloudMeta.StFeed)localObject).cover.picUrl.get();
      setTag(2131441759, localObject);
      if (!paramObject.equals(localObject))
      {
        paramObject = new Option().setUrl((String)localObject).setTargetView(this.mIvFeedCover).setFromPreLoad(false).setPredecode(true).setRequestWidth(PIC_LOAD_SIZE).setRequestHeight(PIC_LOAD_SIZE);
        QCircleFeedPicLoader.g().loadImage(paramObject, new QCircleGridFeedItemView.1(this, paramInt));
      }
      updateExtraIconVisibility();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626819;
  }
  
  protected String getLogTag()
  {
    return "QCircleGridFeedItemView";
  }
  
  public void onAddFinished() {}
  
  public void onAddStarting() {}
  
  public void onChangeFinished(boolean paramBoolean)
  {
    updateExtraIconVisibility();
  }
  
  public void onChangeStarting(boolean paramBoolean)
  {
    Object localObject = this.mIvExtraInfo;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(4);
    }
    localObject = this.mTvExtraInfo;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131448437) || (i == 2131436365) || (i == 2131436376))
    {
      reportJumpContentPageIn5504();
      if ((getExtraTypeInfo() != null) && ((getInteractor() instanceof QCircleInteractor)))
      {
        Object localObject1 = this.mData;
        if ((localObject1 instanceof FeedBlockData))
        {
          localObject1 = ((FeedBlockData)localObject1).b();
          if (QCircleFakeAdapter.a(localObject1))
          {
            QCircleToast.a(QCircleToast.b, 2131895871, 0);
          }
          else
          {
            Object localObject3 = (QCircleInteractor)getInteractor();
            Object localObject2 = new QQCircleFeedBase.StFeedListBusiReqData();
            ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tabAttachInfo.set(((QCircleInteractor)localObject3).a());
            localObject3 = ((QCircleInteractor)localObject3).c();
            if (localObject3 != null)
            {
              ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tagId.set(((QCircleInitBean)localObject3).getTagInfo().tagId.get());
              ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tagName.set(((QCircleInitBean)localObject3).getTagInfo().tagName.get());
            }
            localObject3 = new QCircleLayerBean();
            ((QCircleLayerBean)localObject3).setFeed((FeedCloudMeta.StFeed)localObject1);
            ((QCircleLayerBean)localObject3).setSourceType(getQCircleExtraTypeInfo().pageType);
            ((QCircleLayerBean)localObject3).setFeedListBusiReqData((QQCircleFeedBase.StFeedListBusiReqData)localObject2);
            ((QCircleLayerBean)localObject3).setDataPosInList(0);
            ((QCircleLayerBean)localObject3).setFromReportBean(getReportBean().clone());
            if (getExtraTypeInfo() != null) {
              ((QCircleLayerBean)localObject3).setGlobalViewModelKey(getQCircleExtraTypeInfo().mGlobalViewModelKey);
            }
            localObject2 = this.mIvFeedCover;
            QCircleTransitionAnimHelper.a((ImageView)localObject2, ((SquareImageView)localObject2).getWidth(), this.mIvFeedCover.getHeight(), (QCircleLayerBean)localObject3);
            QCircleLauncher.a(getContext(), (QCircleLayerBean)localObject3);
            localObject2 = new QCircleExtraTypeInfo();
            ((QCircleExtraTypeInfo)localObject2).mFeed = ((FeedCloudMeta.StFeed)localObject1);
            ((QCircleExtraTypeInfo)localObject2).mPlayScene = 1;
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(((QCircleExtraTypeInfo)localObject2).mFeed).setActionType(7).setSubActionType(2).setToUin(((QCircleExtraTypeInfo)localObject2).mFeed.poster.id.get()).setIndex(((QCircleExtraTypeInfo)localObject2).mDataPosition).setPageId(getPageId())));
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.mIvFeedCover = ((SquareImageView)paramView.findViewById(2131436376));
    this.mIvExtraInfo = ((ImageView)paramView.findViewById(2131436365));
    this.mTvExtraInfo = ((TextView)paramView.findViewById(2131448437));
    this.mIvFeedCover.setOnClickListener(this);
    this.mTvExtraInfo.setOnClickListener(this);
    this.mIvExtraInfo.setOnClickListener(this);
  }
  
  public void onMoveFinished() {}
  
  public void onMoveStarting() {}
  
  public void onRemoveFinished() {}
  
  public void onRemoveStarting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView
 * JD-Core Version:    0.7.0.1
 */