package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoDetailsFragmentExitEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleNewPolymerizeDetailFragment;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.biz.qqcircle.utils.QCircleStickUtils.StickArea;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QCircleFeedItemVideoPresenter
  extends QCircleFeedItemBaseVideoPresenter
  implements View.OnClickListener, LayoutPreLoader.RequestPreloadViewListener, SimpleEventReceiver
{
  private static final String TAG = "QCircleFeedItemVideoPresenter";
  float mClickPointX;
  float mClickPointY;
  private RelativeLayout mContainerRl;
  QCircleExpandStickView mExpandStickView;
  QCircleStickUtils.StickArea mStickArea;
  Rect mStickRect;
  
  static {}
  
  private void handleOnClickPlayer(String paramString)
  {
    if (this.mPlayerHelper != null)
    {
      if (!(this.mData instanceof FeedBlockData)) {
        return;
      }
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 50: 
        if (paramString.equals("2")) {
          i = 2;
        }
        break;
      case 49: 
        if (paramString.equals("1")) {
          i = 1;
        }
        break;
      case 48: 
        if (paramString.equals("0")) {
          i = 0;
        }
        break;
      }
      if ((i != 0) && (i != 1))
      {
        if (i != 2) {
          return;
        }
        this.mPlayerHelper.a(((FeedBlockData)this.mData).b(), this.mVoiceIcon, this.mPos);
        return;
      }
      this.mPlayerHelper.a(this, ((FeedBlockData)this.mData).b());
    }
  }
  
  private void handleOnClickPlayerContainer(View paramView)
  {
    if (this.mExpandStickView != null)
    {
      Point localPoint = new Point((int)this.mClickPointX, (int)this.mClickPointY);
      if (this.mExpandStickView.a(localPoint)) {
        return;
      }
    }
    if (((this.mData instanceof FeedBlockData)) && (this.mExtraTypeInfo != null) && (this.mIntercator != null))
    {
      launchContentLayerPage(paramView);
      SimpleEventBus.getInstance().registerReceiver(this);
    }
  }
  
  private void handlePaiTongKan()
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    try
    {
      QQCircleFeedBase.StVideoBusiData localStVideoBusiData = new QQCircleFeedBase.StVideoBusiData();
      localStVideoBusiData.mergeFrom(((FeedBlockData)this.mData).b().video.busiData.get().toByteArray());
      if ((localStVideoBusiData.simulate_date != null) && (localStVideoBusiData.simulate_date.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
      {
        this.mPaiTongKuanImg.setVisibility(0);
        this.mPaiTongKuanImg.setOnClickListener(new QCircleFeedItemVideoPresenter.1(this, localStVideoBusiData));
        reportClick(86, 1);
        return;
      }
      this.mPaiTongKuanImg.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", localException);
    }
  }
  
  private void handlerDownTouch(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      if (paramMotionEvent.getAction() != 0) {
        return;
      }
      this.mClickPointY = paramMotionEvent.getRawY();
      this.mClickPointX = paramMotionEvent.getRawX();
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("mCLickPointY:");
        paramMotionEvent.append(this.mClickPointX);
        paramMotionEvent.append(" mClickPointX:");
        paramMotionEvent.append(this.mClickPointY);
        QLog.e("QCircleFeedItemVideoPresenter", 1, paramMotionEvent.toString());
      }
      paramMotionEvent = this.mExpandStickView;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(new Point((int)this.mClickPointX, (int)this.mClickPointY));
      }
    }
  }
  
  private void launchContentLayerPage(View paramView)
  {
    if (paramView == null) {
      return;
    }
    QCircleLayerBean localQCircleLayerBean = getContentDetailQCircleInitBean();
    QCircleTransitionAnimHelper.a(this.mVideoCoverImg, ((FeedBlockData)this.mData).b().cover.width.get(), ((FeedBlockData)this.mData).b().cover.height.get(), localQCircleLayerBean);
    if ((getParentView() != null) && ((getParentView().getQCircleBaseFragment() instanceof QCircleNewPolymerizeDetailFragment))) {
      localQCircleLayerBean.setSingleFeed(true);
    }
    QCircleLauncher.a(paramView.getContext(), localQCircleLayerBean);
    reportClick(8, 2);
  }
  
  private void reportClick(int paramInt1, int paramInt2)
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
  
  private void saveFeedVideoCover()
  {
    if ((this.mPlayerContainer != null) && (this.mPlayerContainer.getChildCount() > 0) && ((this.mPlayerContainer.getChildAt(0) instanceof QCircleFeedCleanPlayView)))
    {
      Bitmap localBitmap = ((QCircleFeedCleanPlayView)this.mPlayerContainer.getChildAt(0)).y();
      if (localBitmap != null)
      {
        QCirclePluginGlobalInfo.a(((FeedBlockData)this.mData).b().id.get(), localBitmap);
        this.mVideoCoverImg.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData instanceof FeedBlockData))
    {
      this.mReportInfo.mDataPosition = this.mPos;
      this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
      this.mReportInfo.mPlayScene = 1;
      paramObject = ((FeedBlockData)this.mData).b();
      int j = paramObject.video.width.get();
      int k = paramObject.video.height.get();
      int m = ImmersiveUtils.b();
      int i = ImmersiveUtils.b();
      paramInt = i;
      if (j != 0)
      {
        paramInt = i;
        if (k != 0) {
          paramInt = ((Integer)QCirclePreLoadPicUtil.a(((FeedBlockData)this.mData).b(), j, k).second).intValue();
        }
      }
      this.mContainerRl.getLayoutParams().width = m;
      this.mContainerRl.getLayoutParams().height = paramInt;
      Object localObject = this.mContainerRl;
      ((RelativeLayout)localObject).setLayoutParams(((RelativeLayout)localObject).getLayoutParams());
      this.mVideoCoverImg.getLayoutParams().width = m;
      this.mVideoCoverImg.getLayoutParams().height = paramInt;
      this.mVideoCoverImg.setLayoutParams(this.mVideoCoverImg.getLayoutParams());
      if (!QCircleConfigHelper.q()) {
        this.mPlayIconImg.setVisibility(0);
      } else {
        this.mPlayIconImg.setVisibility(8);
      }
      bindCover(paramObject);
      if (this.mExpandStickView != null)
      {
        localObject = new Rect(0, 0, j, k);
        Rect localRect = new Rect(0, 0, DisplayUtil.d(), paramInt);
        this.mExpandStickView.a((FeedBlockData)this.mData, (Rect)localObject, localRect, false, ImageView.ScaleType.CENTER_CROP);
      }
      try
      {
        localObject = new QQCircleFeedBase.StVideoBusiData();
        ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(paramObject.video.busiData.get().toByteArray());
        if ((((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.get() != null) && (((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.is_show_button.get() == 1))
        {
          paramObject = ((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.simulate_name.get();
          if (paramObject.equals("")) {
            this.mPaiTongKuanImg.a();
          } else {
            this.mPaiTongKuanImg.setTongKuanText(paramObject);
          }
          this.mPaiTongKuanImg.setVisibility(0);
          this.mPaiTongKuanImg.setOnClickListener(this);
        }
        else
        {
          this.mPaiTongKuanImg.setVisibility(8);
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", paramObject);
      }
    }
    if (getParentView() != null)
    {
      QLog.d("QCircleFeedItemVideoPresenter", 1, "onDataBind");
      onDataBind(getParentView().getTag(), this.mData);
      return;
    }
    QLog.d("QCircleFeedItemVideoPresenter", 1, "parentView is null");
  }
  
  public QCircleLayerBean getContentDetailQCircleInitBean()
  {
    if (((this.mData instanceof FeedBlockData)) && (this.mExtraTypeInfo != null) && (this.mIntercator != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(this.mIntercator.a());
      Object localObject1 = null;
      if (this.mContainer != null) {
        localObject1 = QCirclePluginUtil.a(this.mContainer.getContext());
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.mIntercator.c();
      }
      localObject1 = new QCircleLayerBean();
      if (localObject2 != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
        if (((QCircleInitBean)localObject2).getUser() != null) {
          ((QCircleLayerBean)localObject1).setUin(((QCircleInitBean)localObject2).getUser().id.get());
        }
      }
      ((QCircleLayerBean)localObject1).setFeed(((FeedBlockData)this.mData).b());
      ((QCircleLayerBean)localObject1).setSourceType(this.mExtraTypeInfo.pageType);
      ((QCircleLayerBean)localObject1).setFeedListBusiReqData(localStFeedListBusiReqData);
      ((QCircleLayerBean)localObject1).setFromReportBean(getReportBean().clone());
      ((QCircleLayerBean)localObject1).setDataPosInList(getPos());
      ((QCircleLayerBean)localObject1).setGlobalViewModelKey(this.mExtraTypeInfo.mGlobalViewModelKey);
      if (this.mPlayerHelper != null)
      {
        ((QCircleLayerBean)localObject1).setPicPos(0);
        ((QCircleLayerBean)localObject1).setVideoCurrentPosition(this.mPlayerHelper.i());
      }
      return localObject1;
    }
    return new QCircleLayerBean();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVideoPositionLinkEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemVideoPresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440937), this);
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
  }
  
  public void onPreloadResult(View paramView)
  {
    QLog.d("QCircleFeedItemVideoPresenter", 1, "onPreloadItemVideoSuccess");
    this.mContainer = paramView;
    this.mContainerRl = ((RelativeLayout)this.mContainer.findViewById(2131441653));
    this.mPlayIconImg = ((ImageView)this.mContainer.findViewById(2131441644));
    this.mPlayerContainer = ((FrameLayout)this.mContainer.findViewById(2131441642));
    this.mPlayerContainer.setOnClickListener(this);
    this.mPlayerContainer.setOnTouchListener(new QCircleFeedItemVideoPresenter.2(this));
    this.mVideoCoverImg = ((URLImageView)this.mContainer.findViewById(2131441643));
    this.mPlayIconImg.setVisibility(0);
    this.mPlayIconImg.setOnClickListener(this);
    this.mVoiceIcon = ((ImageView)this.mContainer.findViewById(2131441645));
    this.mVoiceIcon.setOnClickListener(this);
    this.mPaiTongKuanImg = ((QCirclePaiTongKuanIconView)this.mContainer.findViewById(2131441762));
    this.mPaiTongKuanImg.setOnClickListener(this);
    this.mProgressText = ((TextView)this.mContainer.findViewById(2131441647));
    this.mProgressBar = ((SeekBar)this.mContainer.findViewById(2131441646));
    this.mLoadingProgressView = this.mContainer.findViewById(2131441639);
    this.mExpandStickView = ((QCircleExpandStickView)this.mContainer.findViewById(2131441621));
    if (this.mData != null)
    {
      QLog.d("QCircleFeedItemVideoPresenter", 1, "bindData");
      bindData(this.mData, this.mPos);
      return;
    }
    QLog.d("QCircleFeedItemVideoPresenter", 1, "not bind data");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent))
    {
      if (this.mPlayerHelper != null)
      {
        QCircleFeedPlayerScroller localQCircleFeedPlayerScroller = this.mPlayerHelper;
        paramSimpleBaseEvent = (QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent;
        localQCircleFeedPlayerScroller.a(paramSimpleBaseEvent.mFeedUrl, paramSimpleBaseEvent.mCurrentPlayPosition);
      }
    }
    else if (((paramSimpleBaseEvent instanceof QCircleVideoDetailsFragmentExitEvent)) && ((this.mPlayerContainer.getChildAt(0) instanceof QCircleFeedCleanPlayView)) && (getFeedData() != null))
    {
      paramSimpleBaseEvent = (QCircleFeedCleanPlayView)this.mPlayerContainer.getChildAt(0);
      paramSimpleBaseEvent = QCirclePluginGlobalInfo.f(getFeedData().id.get());
      if (paramSimpleBaseEvent != null) {
        this.mVideoCoverImg.setImageBitmap(paramSimpleBaseEvent);
      }
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    paramQCircleReportBean = this.mExpandStickView;
    if (paramQCircleReportBean != null) {
      paramQCircleReportBean.setReportBean(getReportBean());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemVideoPresenter
 * JD-Core Version:    0.7.0.1
 */