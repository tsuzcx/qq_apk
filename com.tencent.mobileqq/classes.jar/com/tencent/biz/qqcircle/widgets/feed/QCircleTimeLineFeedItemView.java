package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleTimeLineAndGridFeedAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.part.list.divider.DividerGridItemDecoration;
import com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleTimeLineFeedItemVideoPresenter;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimationInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVisitor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleTimeLineFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, EnhanceItemAnimationInterface
{
  public static final int FEED_PIC_ITEM_SIZE;
  private static final int PIC_SIZE_BIG = 1002;
  private static final int PIC_SIZE_SMALL = 1001;
  private static final String TAG = "QCircleTimeLineFeedItemView";
  public Object mData;
  private GridLayoutManager mGridLayoutManager;
  private QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter mInnerPicAdapter;
  private View.OnAttachStateChangeListener mListener;
  private LinearLayout mLlLeftDescContainer;
  private View mLlRootContainer;
  private View mLlTopYear;
  private int mPosition;
  private RecyclerView mRvPic;
  private TextView mTvCreateDate;
  private QCircleAsyncTextView mTvFeedContent;
  private TextView mTvViewDesc;
  private TextView mTvYear;
  private QCircleTimeLineFeedItemVideoPresenter mVideoPresenter;
  private ViewStub mVsYear;
  
  static
  {
    ajc$preClinit();
    double d = ImmersiveUtils.b();
    Double.isNaN(d);
    FEED_PIC_ITEM_SIZE = (int)(d * 0.3D);
  }
  
  public QCircleTimeLineFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void bindPic(FeedCloudMeta.StFeed paramStFeed)
  {
    List localList = getFeedImage(paramStFeed);
    ViewGroup.LayoutParams localLayoutParams = this.mRvPic.getLayoutParams();
    int i;
    if (localList.size() == 1)
    {
      localLayoutParams.height = (FEED_PIC_ITEM_SIZE * 2);
      i = 1002;
    }
    else
    {
      if (localList.size() == 2) {
        localLayoutParams.height = FEED_PIC_ITEM_SIZE;
      } else {
        localLayoutParams.height = (FEED_PIC_ITEM_SIZE * 2);
      }
      i = 1001;
    }
    localLayoutParams.width = (FEED_PIC_ITEM_SIZE * 2);
    this.mRvPic.setLayoutParams(localLayoutParams);
    this.mRvPic.setVisibility(0);
    this.mInnerPicAdapter.setDatas(paramStFeed, this.mPosition, getInnerImageBean(localList, i, paramStFeed));
  }
  
  private void bindVideo(Object paramObject, int paramInt)
  {
    if (this.mVideoPresenter == null) {
      return;
    }
    if ((getInteractor() instanceof QCircleInteractor)) {
      this.mVideoPresenter.setFetchInfoObj((QCircleInteractor)getInteractor());
    }
    this.mVideoPresenter.getContainerView().setVisibility(0);
    this.mVideoPresenter.setExtraTypeInfo(getQCircleExtraTypeInfo());
    this.mVideoPresenter.bindData(paramObject, paramInt);
    this.mVideoPresenter.onDataBind(getTag(), paramObject);
  }
  
  private List<FeedCloudMeta.StImage> getFeedImage(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramStFeed.type.get() == 3)
    {
      localArrayList.add(paramStFeed.cover.get());
      return localArrayList;
    }
    int i = paramStFeed.images.size();
    int j = Math.min(4, i);
    if (i > 0) {
      localArrayList.addAll(paramStFeed.images.get().subList(0, j));
    }
    return localArrayList;
  }
  
  private List<QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean> getInnerImageBean(List<FeedCloudMeta.StImage> paramList, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramList.size();
    int i = 0;
    int m;
    int j;
    for (;;)
    {
      m = k - 1;
      j = -1;
      if (i >= m) {
        break;
      }
      localArrayList.add(new QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean((FeedCloudMeta.StImage)paramList.get(i), paramInt, paramStFeed.type.get(), -1));
      i += 1;
    }
    i = j;
    if (paramStFeed.images.size() > k) {
      i = paramStFeed.images.size();
    }
    if (k > 0) {
      localArrayList.add(new QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean((FeedCloudMeta.StImage)paramList.get(m), paramInt, paramStFeed.type.get(), i));
    }
    return localArrayList;
  }
  
  private void handleLaunchDetailPage(ImageView paramImageView, int paramInt)
  {
    if ((getExtraTypeInfo() != null) && ((getInteractor() instanceof QCircleInteractor)) && ((getData() instanceof FeedBlockData)))
    {
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
      if (QCircleFakeAdapter.a(localStFeed))
      {
        QCircleToast.a(QCircleToast.b, 2131895871, 0);
        return;
      }
      Object localObject = (QCircleInteractor)getInteractor();
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(((QCircleInteractor)localObject).a());
      localObject = ((QCircleInteractor)localObject).c();
      if (localObject != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
      }
      localObject = new QCircleLayerBean();
      ((QCircleLayerBean)localObject).setFeed(localStFeed);
      ((QCircleLayerBean)localObject).setSourceType(getQCircleExtraTypeInfo().pageType);
      ((QCircleLayerBean)localObject).setGlobalViewModelKey(getQCircleExtraTypeInfo().mGlobalViewModelKey);
      ((QCircleLayerBean)localObject).setFeedListBusiReqData(localStFeedListBusiReqData);
      ((QCircleLayerBean)localObject).setDataPosInList(getDataPosInList());
      ((QCircleLayerBean)localObject).setPicPos(paramInt);
      QCircleFeedDataCenter.a().a(localStFeed.id.get(), paramInt);
      ((QCircleLayerBean)localObject).setFromReportBean(getReportBean().clone());
      if (paramImageView != null)
      {
        QCircleTransitionAnimHelper.a(paramImageView, paramImageView.getWidth(), paramImageView.getHeight(), (QCircleLayerBean)localObject);
        QCircleLauncher.a(getContext(), (QCircleLayerBean)localObject);
      }
      else
      {
        QCircleLauncher.a(getContext(), (QCircleLayerBean)localObject);
      }
      paramImageView = new QCircleExtraTypeInfo();
      paramImageView.mFeed = localStFeed;
      paramImageView.mPlayScene = 1;
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramImageView.mFeed).setActionType(7).setSubActionType(2).setToUin(paramImageView.mFeed.poster.id.get()).setIndex(paramImageView.mDataPosition).setPageId(getPageId())));
    }
  }
  
  private void handleLaunchFeedDetailPage()
  {
    if ((getExtraTypeInfo() != null) && ((getInteractor() instanceof QCircleInteractor)))
    {
      Object localObject1 = this.mData;
      if ((localObject1 instanceof FeedBlockData))
      {
        localObject1 = ((FeedBlockData)localObject1).b();
        if (QCircleFakeAdapter.a(localObject1))
        {
          QCircleToast.a(QCircleToast.b, 2131895871, 0);
          return;
        }
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
        ((QCircleLayerBean)localObject3).setFromReportBean(getReportBean().clone());
        QCircleLauncher.a(getContext(), (QCircleInitBean)localObject3);
        localObject2 = new QCircleExtraTypeInfo();
        ((QCircleExtraTypeInfo)localObject2).mFeed = ((FeedCloudMeta.StFeed)localObject1);
        ((QCircleExtraTypeInfo)localObject2).mPlayScene = 1;
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(((QCircleExtraTypeInfo)localObject2).mFeed).setActionType(7).setSubActionType(2).setToUin(((QCircleExtraTypeInfo)localObject2).mFeed.poster.id.get()).setIndex(((QCircleExtraTypeInfo)localObject2).mDataPosition).setPageId(getPageId())));
      }
    }
  }
  
  private void initContentView(FeedCloudMeta.StFeed paramStFeed)
  {
    if (!TextUtils.isEmpty(paramStFeed.content.get()))
    {
      this.mTvFeedContent.setVisibility(0);
      this.mTvFeedContent.setOnClickHashTagTextListener(new QCircleTimeLineFeedItemView.2(this, paramStFeed));
      this.mTvFeedContent.setOnClickAtTextListener(new QCircleTimeLineFeedItemView.3(this));
      this.mTvFeedContent.setText(paramStFeed.content.get());
      if (this.mListener == null)
      {
        this.mListener = new QCircleTimeLineFeedItemView.4(this, paramStFeed);
        this.mTvFeedContent.addOnAttachStateChangeListener(this.mListener);
      }
    }
    else
    {
      this.mTvFeedContent.setVisibility(8);
    }
  }
  
  private void initCreateDateView(FeedCloudMeta.StFeed paramStFeed)
  {
    parseFeedCreateYear(paramStFeed.createTime.get() * 1000L);
    if ((getViewType() != 1001) && (getViewType() != 1002))
    {
      this.mTvCreateDate.setVisibility(8);
      return;
    }
    this.mTvCreateDate.setVisibility(0);
    parseFeedCreateDate(paramStFeed.createTime.get() * 1000L);
  }
  
  private void initViewDesc(FeedCloudMeta.StFeed paramStFeed)
  {
    if (TextUtils.isEmpty(paramStFeed.visitorInfo.viewDesc.get()))
    {
      this.mTvViewDesc.setVisibility(8);
      return;
    }
    this.mTvViewDesc.setVisibility(0);
    this.mTvViewDesc.setText(paramStFeed.visitorInfo.viewDesc.get());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mTvViewDesc.getLayoutParams();
    if ((this.mTvCreateDate.getVisibility() == 8) && (this.mTvFeedContent.getVisibility() == 8)) {
      localLayoutParams.topMargin = ViewUtils.a(10.0F);
    } else {
      localLayoutParams.topMargin = ViewUtils.a(12.0F);
    }
    this.mTvViewDesc.setLayoutParams(localLayoutParams);
    paramStFeed = getFeedImage(paramStFeed);
    if ((paramStFeed != null) && (paramStFeed.size() == 2))
    {
      this.mTvFeedContent.setMaxLines(1);
      return;
    }
    this.mTvFeedContent.setMaxLines(3);
  }
  
  private void parseFeedCreateDate(long paramLong)
  {
    if (this.mTvCreateDate != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(paramLong);
      Object localObject2 = Calendar.getInstance();
      if (((Calendar)localObject2).get(1) == ((Calendar)localObject1).get(1))
      {
        i = ((Calendar)localObject2).get(6);
        j = ((Calendar)localObject1).get(6);
        if (i == j)
        {
          localStringBuilder.append(HardCodeUtil.a(2131917319));
        }
        else if (i - 1 == j)
        {
          localStringBuilder.append(HardCodeUtil.a(2131918208));
        }
        else
        {
          if (i - 2 != j) {
            break label133;
          }
          localStringBuilder.append(HardCodeUtil.a(2131887542));
        }
        i = 0;
        break label192;
        label133:
        localStringBuilder.append(new SimpleDateFormat("dd").format(new Date(paramLong)));
      }
      else
      {
        localStringBuilder.append(new SimpleDateFormat("dd").format(new Date(paramLong)));
      }
      int i = 1;
      label192:
      int j = localStringBuilder.length();
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(((Calendar)localObject1).get(2) + 1);
        localStringBuilder.append(((StringBuilder)localObject2).toString());
        i = localStringBuilder.length();
        localStringBuilder.append(getResources().getString(2131886082));
        localObject1 = new SpannableString(localStringBuilder);
        ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(ViewUtils.a(26.0F)), 0, j, 33);
        ((SpannableString)localObject1).setSpan(new QCircleTimeLineFeedItemView.5(this, 1), 0, i, 33);
        ((SpannableString)localObject1).setSpan(new StyleSpan(1), i, localStringBuilder.length(), 33);
        this.mTvCreateDate.setText((CharSequence)localObject1);
        return;
      }
      this.mTvCreateDate.setText(localStringBuilder);
    }
  }
  
  private void parseFeedCreateYear(long paramLong)
  {
    Object localObject;
    if (getViewType() == 1001)
    {
      if (this.mLlTopYear == null)
      {
        localObject = this.mVsYear;
        if (localObject != null)
        {
          this.mLlTopYear = ((View)localObject);
          this.mTvYear = ((TextView)this.mLlTopYear.findViewById(2131448808));
        }
      }
      if ((this.mLlTopYear != null) && (this.mTvYear != null))
      {
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(paramLong);
        this.mTvYear.setText(String.valueOf(((Calendar)localObject).get(1)));
        this.mLlTopYear.setVisibility(0);
      }
    }
    else
    {
      localObject = this.mLlTopYear;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  private void reportHashTagInfo(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(paramStFeed).setActionType(paramInt1).setSubActionType(paramInt2).setExt1(paramString)).setPageId(getPageId()));
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPosition = paramInt;
    Object localObject1 = this.mData;
    if (!(localObject1 instanceof FeedBlockData)) {
      return;
    }
    localObject1 = ((FeedBlockData)localObject1).b();
    initCreateDateView((FeedCloudMeta.StFeed)localObject1);
    initContentView((FeedCloudMeta.StFeed)localObject1);
    initViewDesc((FeedCloudMeta.StFeed)localObject1);
    Object localObject2 = this.mRvPic;
    if (localObject2 != null) {
      ((RecyclerView)localObject2).setVisibility(8);
    }
    localObject2 = this.mVideoPresenter;
    if ((localObject2 != null) && (((QCircleTimeLineFeedItemVideoPresenter)localObject2).getContainerView() != null)) {
      this.mVideoPresenter.getContainerView().setVisibility(8);
    }
    if ((((FeedCloudMeta.StFeed)localObject1).type.get() == 3) && (QCircleTimeLineAndGridFeedAdapter.f))
    {
      bindVideo(paramObject, paramInt);
      return;
    }
    if (this.mRvPic != null) {
      bindPic((FeedCloudMeta.StFeed)localObject1);
    }
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    Object localObject = this.mData;
    if ((localObject instanceof FeedBlockData)) {
      return ((FeedBlockData)localObject).b();
    }
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131626820;
  }
  
  protected String getLogTag()
  {
    return "QCircleTimeLineFeedItemView";
  }
  
  public QCircleTimeLineFeedItemVideoPresenter getVideoPresenter()
  {
    return this.mVideoPresenter;
  }
  
  public void onAddFinished() {}
  
  public void onAddStarting() {}
  
  public void onChangeFinished(boolean paramBoolean) {}
  
  public void onChangeStarting(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = this.mRvPic;
      if (localObject != null) {
        ((RecyclerView)localObject).setVisibility(4);
      }
      localObject = this.mVideoPresenter;
      if ((localObject != null) && (((QCircleTimeLineFeedItemVideoPresenter)localObject).getContainerView() != null)) {
        this.mVideoPresenter.getContainerView().setVisibility(4);
      }
    }
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.mLlRootContainer = paramView.findViewById(2131437479);
    this.mTvCreateDate = ((TextView)paramView.findViewById(2131448807));
    this.mTvFeedContent = ((QCircleAsyncTextView)paramView.findViewById(2131448806));
    this.mRvPic = ((RecyclerView)paramView.findViewById(2131445217));
    this.mRvPic.addItemDecoration(new DividerGridItemDecoration(getContext(), ViewUtils.a(1.0F), 2131168376));
    this.mLlLeftDescContainer = ((LinearLayout)paramView.findViewById(2131437484));
    this.mVsYear = ((ViewStub)paramView.findViewById(2131450021));
    this.mTvViewDesc = ((TextView)paramView.findViewById(2131448871));
    this.mInnerPicAdapter = new QCircleTimeLineFeedItemView.QCircleTimeFlowFeedInnerImageAdapter(this);
    this.mInnerPicAdapter.setRecycleView(this.mRvPic);
    this.mInnerPicAdapter.setHasStableIds(true);
    this.mRvPic.setAdapter(this.mInnerPicAdapter);
    this.mRvPic.setHasFixedSize(true);
    this.mTvCreateDate.setOnClickListener(this);
    this.mTvFeedContent.setOnClickListener(this);
    this.mLlRootContainer.setOnClickListener(this);
    this.mGridLayoutManager = new GridLayoutManager(getContext(), 2);
    this.mGridLayoutManager.setSpanSizeLookup(new QCircleTimeLineFeedItemView.1(this));
    if (QCircleTimeLineAndGridFeedAdapter.f)
    {
      this.mVideoPresenter = new QCircleTimeLineFeedItemVideoPresenter();
      this.mVideoPresenter.initView(this);
    }
    this.mRvPic.setLayoutManager(this.mGridLayoutManager);
  }
  
  public void onMoveFinished() {}
  
  public void onMoveStarting() {}
  
  public void onRemoveFinished() {}
  
  public void onRemoveStarting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView
 * JD-Core Version:    0.7.0.1
 */