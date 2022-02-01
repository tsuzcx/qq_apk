package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleWaterfallFeedsBlock
  extends QCircleBaseFeedBlock
{
  private RecyclerView.LayoutManager e;
  private int f;
  
  public QCircleWaterfallFeedsBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private List<FeedCloudMeta.StFeed> a(ArrayList<FeedBlockData> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((FeedBlockData)paramArrayList.next()).b());
    }
    return localArrayList;
  }
  
  private void e()
  {
    if (this.mDataList != null)
    {
      if (this.mDataList.size() == 0) {
        return;
      }
      if (((FeedBlockData)this.mDataList.get(0)).b().dittoFeed.dittoId.get() == 10)
      {
        this.mDataList.remove(0);
        QLog.i("QCircleWaterfallFeedsBlock", 1, "checkRemoveHeaderTianShuBanner  remove tianshu banner");
      }
    }
  }
  
  public QCircleWaterfallFeedsBlock c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public List<FeedCloudMeta.StFeed> d()
  {
    return a(this.mDataList);
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mDataList.get(paramInt)).b();
      if (localStFeed.dittoFeed.dittoId.get() != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemViewType()  return 0 , data.dittoFeed.dittoId = ");
        localStringBuilder.append(localStFeed.dittoFeed.dittoId.get());
        localStringBuilder.append(" , position = ");
        localStringBuilder.append(paramInt);
        QLog.i("QCircleWaterfallFeedsBlock", 1, localStringBuilder.toString());
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemViewType()  return ");
      localStringBuilder.append(localStFeed.type.get());
      QLog.i("QCircleWaterfallFeedsBlock", 1, localStringBuilder.toString());
      return localStFeed.type.get();
    }
    QLog.e("QCircleWaterfallFeedsBlock", 1, "getItemViewType()  return 0");
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleWaterfallFeedsBlock";
  }
  
  public int getSpanCount(int paramInt)
  {
    return 2;
  }
  
  public String getUniqueKey()
  {
    return "WATERFALL_ADAPTER_UNIQUE_KEY";
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.e = paramRecyclerView.getLayoutManager();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (ArrayUtils.a(paramInt, getDataList())) {
      return;
    }
    FeedBlockData localFeedBlockData = (FeedBlockData)getDataList().get(paramInt);
    ((QCircleWaterfallFeedsBlock.WaterfallFeedVH)paramViewHolder).a(localFeedBlockData, getQCircleExtraTypeInfo(), paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 3))
    {
      QLog.e("QCircleWaterfallFeedsBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new QCircleWaterfallFeedsBlock.WaterfallFeedVH(this, new QCircleDefaultFeedItemView(getContext(), paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateViewHolder()  viewType = ");
    localStringBuilder.append(paramInt);
    QLog.i("QCircleWaterfallFeedsBlock", 1, localStringBuilder.toString());
    paramViewGroup = new QCircleWaterfallFeedItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(getReportBean());
    paramViewGroup.setViewType(this.f);
    return new QCircleWaterfallFeedsBlock.WaterfallFeedVH(this, paramViewGroup);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    getParentRecyclerView().setClipToPadding(false);
    getParentRecyclerView().setClipChildren(false);
    getParentRecyclerView().setPadding(ViewUtils.a(4.0F), 0, ViewUtils.a(4.0F), 0);
    getParentRecyclerView().addOnScrollListener(new QCircleWaterfallFeedsBlock.1(this));
  }
  
  public void setDatas(List<FeedBlockData> paramList)
  {
    this.mDataList.clear();
    if (paramList == null)
    {
      notifyDataSetChanged();
      return;
    }
    this.mDataList.addAll(paramList);
    e();
    notifyItemRangeChanged(0, paramList.size());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock
 * JD-Core Version:    0.7.0.1
 */