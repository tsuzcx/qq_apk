package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleActivityDestroyEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleNewPolymerizeDetailFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleFeedItemPicPresenter
  extends QCircleBaseFeedChildPresenter
  implements LayoutPreLoader.RequestPreloadViewListener, SimpleEventReceiver
{
  private static final String TAG = "QCircleFeedItemPicPresent";
  float mClickPointX;
  float mClickPointY;
  private QCircleBaseFragment mFragment;
  private int mImageHeight;
  private QCircleFeedItemPicPresenter.MultiPicAdapter mMultiPicPagerAdapter;
  private ViewPager mMultiPicViewPager;
  private int mPicPosition;
  private FrameLayout mProgressArea;
  private TextView mProgressTextView;
  private int mScreenWidth = ImmersiveUtils.b();
  
  private List<FeedCloudMeta.StImage> generateFeedImages(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (paramStFeed2 == null) {
      return null;
    }
    paramStFeed2 = paramStFeed2.images.get();
    if (paramStFeed1 == null) {
      return paramStFeed2;
    }
    paramStFeed1 = paramStFeed1.images.get();
    int i = 0;
    while (i < paramStFeed1.size())
    {
      if ((paramStFeed2.size() > i) && (paramStFeed2.get(i) != null)) {
        ((FeedCloudMeta.StImage)paramStFeed1.get(i)).busiData.set(((FeedCloudMeta.StImage)paramStFeed2.get(i)).busiData.get());
      }
      i += 1;
    }
    return paramStFeed1;
  }
  
  private void launcherContentLayerPage(int paramInt, View paramView, FeedCloudMeta.StImage paramStImage)
  {
    if (paramView != null)
    {
      if (paramStImage == null) {
        return;
      }
      QCircleLayerBean localQCircleLayerBean = getDetailInitBean(paramInt);
      QCircleTransitionAnimHelper.a((URLImageView)paramView, paramStImage.width.get(), paramStImage.height.get(), localQCircleLayerBean);
      if ((getParentView() != null) && ((getParentView().getQCircleBaseFragment() instanceof QCircleNewPolymerizeDetailFragment))) {
        localQCircleLayerBean.setSingleFeed(true);
      }
      QCircleLauncher.a(paramView.getContext(), localQCircleLayerBean);
      if (this.mReportInfo != null) {
        paramView = this.mReportInfo.mFeed;
      } else {
        paramView = null;
      }
      paramStImage = QCirclePluginReportUtil.b(paramView).setActionType(7).setSubActionType(2);
      if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
        paramView = this.mReportInfo.mFeed.poster.id.get();
      } else {
        paramView = "";
      }
      paramView = paramStImage.setToUin(paramView);
      if (this.mReportInfo != null) {
        paramInt = this.mReportInfo.mDataPosition;
      } else {
        paramInt = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramView.setIndex(paramInt).setPageId(getPageId())));
    }
  }
  
  private void observeFeedStateData(String paramString)
  {
    try
    {
      QCircleFeedDataCenter.a().a(paramString, new QCircleFeedItemPicPresenter.FeedStateObserver(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleFeedItemPicPresent", 1, paramString.getMessage());
    }
  }
  
  private void reportFeedExposeToDc05501(int paramInt)
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    Object localObject = ((FeedBlockData)this.mData).b();
    if (((FeedCloudMeta.StFeed)localObject).images.size() > 1)
    {
      localObject = new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject)).setActionType(100).setSubActionType(2).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setIndex(this.mPos);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      QCircleLpReportDc05501.report(((QCircleLpReportDc05501.DataBuilder)localObject).setExt2(localStringBuilder.toString()).setPageId(getPageId()));
    }
  }
  
  private void reportFeedExposeToDc05507(int paramInt)
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    Object localObject1;
    String str;
    if (localStFeed.images.size() > paramInt)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((FeedCloudMeta.StImage)localStFeed.images.get(paramInt)).picId.get());
      ((StringBuilder)localObject1).append("");
      str = ((StringBuilder)localObject1).toString();
    }
    else
    {
      str = "";
    }
    int i = this.mPicPosition;
    if (paramInt < i) {
      localObject1 = "1";
    } else if (paramInt > i) {
      localObject1 = "2";
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localStFeed.images.size());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed)).setActionType(2).setSubActionType(1).setToUin(localStFeed.poster.id.get()).setPosition(this.mPos).setPlayScene(1).setLloc(str).setExt1("1").setExt2((String)localObject1).setExt3((String)localObject2).setPageId(getPageId()));
    this.mPicPosition = paramInt;
  }
  
  private void setMultiContainerHeight(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f = Math.max(Math.min(paramStImage.height.get() / paramStImage.width.get(), 1.333333F), 0.5625F);
      this.mImageHeight = ((int)(this.mScreenWidth * f));
      updateLayoutHeight();
    }
  }
  
  private void updateLayoutHeight()
  {
    ViewPager localViewPager = this.mMultiPicViewPager;
    if ((localViewPager != null) && (localViewPager.getLayoutParams() != null))
    {
      this.mMultiPicViewPager.getLayoutParams().height = this.mImageHeight;
      this.mMultiPicViewPager.requestLayout();
    }
  }
  
  private void updatePageProgress(int paramInt)
  {
    Object localObject = this.mMultiPicPagerAdapter;
    if (localObject != null)
    {
      int i = ((QCircleFeedItemPicPresenter.MultiPicAdapter)localObject).a();
      if (i > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt % i + 1);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(i);
        updateProgressText(((StringBuilder)localObject).toString());
        return;
      }
      updateProgressText("");
    }
  }
  
  private void updateProgressText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.mProgressArea;
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() != 0)) {
        this.mProgressArea.setVisibility(0);
      }
      localObject = this.mProgressTextView;
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
    }
    else
    {
      paramString = this.mProgressArea;
      if (paramString != null) {
        paramString.setVisibility(8);
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
      String str = paramObject.id.get();
      if ((getContainerView().getContext() instanceof LifecycleOwner)) {
        observeFeedStateData(str);
      }
      List localList = generateFeedImages(QCirclePluginGlobalInfo.b(str), paramObject);
      if ((localList != null) && (localList.size() > 0))
      {
        setMultiContainerHeight((FeedCloudMeta.StImage)localList.get(0));
        this.mMultiPicPagerAdapter.a(localList);
        this.mMultiPicPagerAdapter.a((FeedBlockData)this.mData);
      }
      if (paramObject.images.get().size() > 1) {
        this.mProgressArea.setVisibility(0);
      } else {
        this.mProgressArea.setVisibility(8);
      }
      setInitialItemPos(QCircleFeedDataCenter.a().b(str));
    }
  }
  
  public ImageView getCurrentImageView()
  {
    Object localObject = this.mMultiPicViewPager;
    if (localObject != null)
    {
      localObject = ((ViewPager)localObject).getChildAt(((ViewPager)localObject).getCurrentItem());
      if ((localObject instanceof FrameLayout))
      {
        localObject = (FrameLayout)localObject;
        if ((((FrameLayout)localObject).getChildCount() > 0) && ((((FrameLayout)localObject).getChildAt(0) instanceof ImageView))) {
          return (ImageView)((FrameLayout)localObject).getChildAt(0);
        }
      }
    }
    return null;
  }
  
  public QCircleLayerBean getDetailInitBean(int paramInt)
  {
    if ((this.mExtraTypeInfo != null) && (this.mIntercator != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(this.mIntercator.a());
      Object localObject = this.mFragment;
      if (localObject != null) {
        localObject = QCirclePluginUtil.a(((QCircleBaseFragment)localObject).getActivity());
      } else {
        localObject = this.mIntercator.c();
      }
      QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
      if (localObject != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
        if (((QCircleInitBean)localObject).getUser() != null) {
          localQCircleLayerBean.setUin(((QCircleInitBean)localObject).getUser().id.get());
        }
      }
      if ((this.mData instanceof FeedBlockData)) {
        localQCircleLayerBean.setFeed(((FeedBlockData)this.mData).b());
      }
      localQCircleLayerBean.setSourceType(this.mExtraTypeInfo.pageType);
      localQCircleLayerBean.setFeedListBusiReqData(localStFeedListBusiReqData);
      localQCircleLayerBean.setDataPosInList(getPos());
      localQCircleLayerBean.setPicPos(paramInt);
      localQCircleLayerBean.setFromReportBean(getReportBean().clone());
      localQCircleLayerBean.setGlobalViewModelKey(this.mExtraTypeInfo.mGlobalViewModelKey);
      return localQCircleLayerBean;
    }
    return new QCircleLayerBean();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleActivityDestroyEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemPicPresent";
  }
  
  public int getPicPosition()
  {
    ViewPager localViewPager = this.mMultiPicViewPager;
    if (localViewPager != null) {
      return localViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440932), this);
  }
  
  public void onDetachedFromWindow()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetachedFromWindow:");
    localStringBuilder.append(hashCode());
    QLog.d("QCircleFeedItemPicPresenttest", 4, localStringBuilder.toString());
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mProgressArea = ((FrameLayout)this.mContainer.findViewById(2131441797));
    this.mProgressTextView = ((TextView)this.mContainer.findViewById(2131441798));
    this.mMultiPicViewPager = ((ViewPager)this.mContainer.findViewById(2131441759));
    this.mMultiPicPagerAdapter = new QCircleFeedItemPicPresenter.MultiPicAdapter(this);
    this.mMultiPicViewPager.setAdapter(this.mMultiPicPagerAdapter);
    this.mFragment = QCirclePluginUtil.f(this.mContainer.getContext());
    this.mMultiPicViewPager.setOnPageChangeListener(new QCircleFeedItemPicPresenter.1(this));
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (this.mMultiPicViewPager == null) {
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCircleActivityDestroyEvent)) && (((QCircleActivityDestroyEvent)paramSimpleBaseEvent).getContextHash() == this.mMultiPicViewPager.getContext().hashCode()))
    {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
      QLog.d("QCircleFeedItemPicPresent", 1, "Activity Destroy unRegister");
    }
  }
  
  public void setInitialItemPos(int paramInt)
  {
    this.mMultiPicViewPager.setCurrentItem(paramInt);
    updatePageProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter
 * JD-Core Version:    0.7.0.1
 */