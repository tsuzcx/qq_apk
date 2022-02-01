package com.tencent.biz.qqcircle.publish.activity;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishKeyboardEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleLabelPart$2
  extends RecyclerView.OnScrollListener
{
  QCircleLabelPart$2(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (1 == paramInt) {
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishKeyboardEvent(false));
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.2
 * JD-Core Version:    0.7.0.1
 */