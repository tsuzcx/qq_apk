package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QCircleLightInteractListPart$4
  extends RecyclerView.OnScrollListener
{
  QCircleLightInteractListPart$4(QCircleLightInteractListPart paramQCircleLightInteractListPart) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.4
 * JD-Core Version:    0.7.0.1
 */