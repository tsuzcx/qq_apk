package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QFSAggregationBottomWidget$3
  extends RecyclerView.OnScrollListener
{
  QFSAggregationBottomWidget$3(QFSAggregationBottomWidget paramQFSAggregationBottomWidget) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomWidget.3
 * JD-Core Version:    0.7.0.1
 */