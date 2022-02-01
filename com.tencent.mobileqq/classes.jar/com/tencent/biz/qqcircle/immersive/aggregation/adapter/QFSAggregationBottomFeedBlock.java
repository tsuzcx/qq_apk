package com.tencent.biz.qqcircle.immersive.aggregation.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationFeedItemView;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class QFSAggregationBottomFeedBlock
  extends QCircleBaseMultiViewBlock<FeedBlockData>
{
  private QFSAggregationBottomFeedBlock.OnItemClickListener a;
  
  public QFSAggregationBottomFeedBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(View paramView, FeedBlockData paramFeedBlockData)
  {
    VideoReport.setElementId(paramView, "em_xsj_product");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
    VideoReport.setElementParams(paramView, localMap);
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool3 = paramRecyclerView.getLayoutManager() instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramInt1 % paramInt2 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
      return (paramInt1 + 1) % paramInt2 == 0;
    }
    return false;
  }
  
  public void a(QFSAggregationBottomFeedBlock.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
  
  public boolean a()
  {
    return getItemCount() == 0;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = getDataList().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      i += 1;
      if (TextUtils.equals(paramString, ((FeedBlockData)localIterator.next()).b().id.get()))
      {
        localIterator.remove();
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount() - i);
        return true;
      }
    }
    return false;
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.getAdapter() == null) {
        return;
      }
      int i = paramRecyclerView.getChildLayoutPosition(paramView);
      boolean bool1 = a(paramRecyclerView, i, 3);
      boolean bool2 = b(paramRecyclerView, i, 3);
      int k = ViewUtils.dip2px(0.5F);
      if (bool1) {
        i = 0;
      } else if (bool2) {
        i = k * 2;
      } else {
        i = k;
      }
      int j;
      if (bool2) {
        j = 0;
      } else if (bool1) {
        j = k * 2;
      } else {
        j = k;
      }
      paramRect.set(i, 0, j, k * 3);
    }
  }
  
  protected String getLogTag()
  {
    return "QFSAggregationBottomBlock";
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null)
    {
      if (paramInt >= this.mDataList.size()) {
        return;
      }
      FeedBlockData localFeedBlockData = (FeedBlockData)this.mDataList.get(paramInt);
      QFSAggregationBottomFeedBlock.FeedViewHolder localFeedViewHolder = (QFSAggregationBottomFeedBlock.FeedViewHolder)paramViewHolder;
      localFeedViewHolder.a.setData(localFeedBlockData, paramInt);
      localFeedViewHolder.a.setOnClickListener(new QFSAggregationBottomFeedBlock.1(this, paramInt, localFeedBlockData));
      a(paramViewHolder.itemView, localFeedBlockData);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new QFSAggregationBottomFeedBlock.FeedViewHolder(new QFSAggregationFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationBottomFeedBlock
 * JD-Core Version:    0.7.0.1
 */