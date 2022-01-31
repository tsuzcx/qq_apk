package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$4
  implements Runnable
{
  QCircleFakeAdapter$4(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent) {}
  
  public void run()
  {
    if ((this.this$0.getComponentPageView() != null) && ((this.this$0.getComponentPageView() instanceof QCircleComponentPageView)) && (this.this$0.getComponentPageView().a() != null) && (this.this$0.getComponentPageView().a().getVisibility() == 0)) {
      this.this$0.getComponentPageView().a().setVisibility(8);
    }
    if ((this.this$0.getDataList() != null) && (this.this$0.a(this.a.mSingleFakeFeed)))
    {
      QCircleFakeAdapter.a(this.this$0).add(this.a.mSingleFakeFeed);
      this.this$0.getDataList().add(0, this.a.mSingleFakeFeed);
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.4
 * JD-Core Version:    0.7.0.1
 */