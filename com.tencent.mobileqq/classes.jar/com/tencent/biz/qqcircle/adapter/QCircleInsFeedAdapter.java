package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.events.QCircleActivityDestroyEvent;
import com.tencent.biz.qqcircle.events.QCirclePushBubbleEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedBaseScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedExportScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedGreyPicScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedVideoPreloadScroller;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleFatePersonView;
import com.tencent.biz.qqcircle.widgets.QCircleGroupMoreWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLastSeenDividerView;
import com.tencent.biz.qqcircle.widgets.QCirclePublishGuideView;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendDividerView;
import com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QCircleInsFeedAdapter
  extends QCircleFakeAdapter
{
  private static String f = "QCircleInsFeedAdapter";
  private static HashMap<Integer, Integer> j = new HashMap();
  private final RecyclerView.RecycledViewPool g = new RecyclerView.RecycledViewPool();
  private QCircleFeedPlayerScroller h;
  private QCircleFeedExportScroller i;
  private int k;
  private boolean l = false;
  private int m = -1;
  private int n;
  private QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource o;
  
  static
  {
    j.put(Integer.valueOf(1), Integer.valueOf(1001));
    j.put(Integer.valueOf(4), Integer.valueOf(1002));
    j.put(Integer.valueOf(7), Integer.valueOf(1006));
    j.put(Integer.valueOf(-1), Integer.valueOf(1003));
    j.put(Integer.valueOf(2), Integer.valueOf(1004));
    j.put(Integer.valueOf(6), Integer.valueOf(1005));
    j.put(Integer.valueOf(9), Integer.valueOf(1007));
    j.put(Integer.valueOf(11), Integer.valueOf(1009));
    j.put(Integer.valueOf(12), Integer.valueOf(1010));
    j.put(Integer.valueOf(13), Integer.valueOf(1011));
  }
  
  public QCircleInsFeedAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCircleGroupMoreWidget(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.k != 0) && (paramInt == 0) && ((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((FeedBlockData)this.mDataList.get(0)).b().type.get() == 2)) {
      ((QCircleInsFeedItemView)paramViewHolder.itemView).setPicInitialItemPos(this.k);
    }
  }
  
  private View b(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCirclePublishGuideView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private QCircleTagRecommendWidget b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleTagRecommendWidget(paramViewGroup.getContext(), paramInt);
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private int c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e(f, 1, "getItemViewType() input data is null!");
      return 0;
    }
    int i1 = paramStFeed.dittoFeed.dittoId.get();
    Object localObject;
    StringBuilder localStringBuilder;
    if (j.containsKey(Integer.valueOf(i1)))
    {
      if (this.m != i1)
      {
        localObject = f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemViewType() dittoId: ");
        localStringBuilder.append(i1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      localObject = (Integer)j.get(Integer.valueOf(i1));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    if (this.m != i1)
    {
      localObject = f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemViewType() data.type = ");
      localStringBuilder.append(paramStFeed.type.get());
      localStringBuilder.append(" | dittoId: ");
      localStringBuilder.append(i1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      this.m = i1;
    }
    return paramStFeed.type.get();
  }
  
  private View c(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCircleLastSeenDividerView(paramViewGroup.getContext());
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
    localMarginLayoutParams.topMargin = ViewUtils.a(-8.0F);
    paramViewGroup.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private QCirclePYMKRecommendView c(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup == null) {
      paramViewGroup = getParentFragment().getActivity();
    } else {
      paramViewGroup = paramViewGroup.getContext();
    }
    paramViewGroup = new QCirclePYMKRecommendView(paramViewGroup, Integer.valueOf(paramInt));
    paramViewGroup.setReportBean(getReportBean());
    paramViewGroup.setReportScroller(this.c);
    paramViewGroup.setPageId(getPageId());
    return paramViewGroup;
  }
  
  private QCircleFatePersonView d(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCircleFatePersonView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private QCirclePushRankTopView e(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCirclePushRankTopView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private QCircleInsFeedItemView e(int paramInt)
  {
    QCircleInsFeedItemView localQCircleInsFeedItemView = new QCircleInsFeedItemView(getParentFragment().getActivity(), paramInt);
    localQCircleInsFeedItemView.setRecyclerView(getParentRecyclerView());
    localQCircleInsFeedItemView.setReportBean(getReportBean());
    localQCircleInsFeedItemView.setShareRecyclerViewPool(this.g);
    localQCircleInsFeedItemView.setFeedBottomVisibleStateSource(this.o);
    localQCircleInsFeedItemView.setEnableBottomInput(this.l);
    return localQCircleInsFeedItemView;
  }
  
  private QCircleRecommendDividerView f(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCircleRecommendDividerView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    return paramViewGroup;
  }
  
  private LinearLayout i()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(54).setSubActionType(2).setThrActionType(1).setPageId(getReportBean().getPageId()).setfPageId(getReportBean().getFromPageId()));
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131626949, null, false);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }
  
  private void j()
  {
    if ((getDataList() != null) && (getDataList().size() != 0))
    {
      if (QCirclePluginConfig.a().A()) {
        return;
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext())
      {
        FeedBlockData localFeedBlockData = (FeedBlockData)localIterator.next();
        if (!localFeedBlockData.b().dittoFeed.has()) {
          SimpleEventBus.getInstance().dispatchEvent(new QCirclePushBubbleEvent(3, localFeedBlockData.b().id.get(), 1));
        }
      }
    }
  }
  
  public QCircleInsFeedAdapter.QCircleVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 3))
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          QLog.e(f, 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
          return new QCircleInsFeedAdapter.QCircleVH(new QCircleDefaultFeedItemView(getContext(), paramInt));
        case 1011: 
          return new QCircleInsFeedAdapter.QCircleVH(f(paramViewGroup));
        case 1010: 
          return new QCircleInsFeedAdapter.QCircleVH(a(paramViewGroup));
        }
        return new QCircleInsFeedAdapter.QCircleVH(b(paramViewGroup));
      case 1007: 
        return new QCircleInsFeedAdapter.QCircleVH(c(paramViewGroup));
      case 1006: 
        return new QCircleInsFeedAdapter.QCircleVH(d(paramViewGroup));
      case 1005: 
        return new QCircleInsFeedAdapter.QCircleVH(b(paramViewGroup, paramInt));
      case 1004: 
        return new QCircleInsFeedAdapter.QCircleVH(e(paramViewGroup));
      case 1002: 
      case 1003: 
        return new QCircleInsFeedAdapter.QCircleVH(i());
      }
      return new QCircleInsFeedAdapter.QCircleVH(c(paramViewGroup, paramInt));
    }
    return new QCircleInsFeedAdapter.QCircleVH(e(paramInt));
  }
  
  public List<FeedCloudMeta.StFeed> a(List<FeedCloudMeta.StFeed> paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    this.n = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localIterator.next();
      if (localStFeed.dittoFeed.dittoId.get() == 7)
      {
        localIterator.remove();
        this.n += 1;
      }
      else if (localStFeed.dittoFeed.dittoId.get() == 9)
      {
        localIterator.remove();
        this.n += 1;
      }
    }
    return paramList;
  }
  
  protected List<QCircleFeedBaseScroller> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.h = new QCircleFeedPlayerScroller(getPageId());
    localArrayList.add(this.h);
    localArrayList.add(new QCircleFeedVideoPreloadScroller());
    localArrayList.add(new QCircleFeedGreyPicScroller());
    this.i = new QCircleFeedExportScroller();
    this.i.g().putBoolean("is_enable_bottom_input", this.l);
    localArrayList.add(this.i);
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    j();
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FeedBlockData(paramStFeed).c());
    setDatas(localArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    QCircleFeedExportScroller localQCircleFeedExportScroller = this.i;
    if (localQCircleFeedExportScroller != null) {
      localQCircleFeedExportScroller.g().putBoolean("is_enable_bottom_input", paramBoolean);
    }
    this.l = paramBoolean;
  }
  
  public List<FeedCloudMeta.StFeed> d()
  {
    return a(super.d());
  }
  
  public void d(int paramInt)
  {
    this.k = paramInt;
  }
  
  public QCircleFeedPlayerScroller g()
  {
    return this.h;
  }
  
  protected int getFixedViewTypeOffset()
  {
    return 100000;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt)) {
      return c(((FeedBlockData)this.mDataList.get(paramInt)).b());
    }
    QLog.e(f, 2, "getItemViewType()  return 0");
    return 0;
  }
  
  protected String getLogTag()
  {
    return f;
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
  
  public int h()
  {
    return this.n;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleActivityDestroyEvent(paramActivity.hashCode()));
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.o = new QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null)
    {
      ((QCircleInsFeedAdapter.QCircleVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.a, (QCircleInteractor)this.mInteractor);
      if (paramInt == 0)
      {
        a(paramViewHolder, paramInt);
        this.k = 0;
      }
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((QCircleFeedExportScroller)localObject).c(paramViewHolder);
    }
    localObject = f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append("  ");
    localStringBuilder.append(this);
    QLog.d((String)localObject, 4, localStringBuilder.toString());
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    this.k = 0;
  }
  
  public void setDatas(List<FeedBlockData> paramList)
  {
    super.setDatas(paramList);
    a();
    paramList = this.o;
    if (paramList != null) {
      paramList.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter
 * JD-Core Version:    0.7.0.1
 */