package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$4
  implements Runnable
{
  QCircleFakeAdapter$4(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent) {}
  
  public void run()
  {
    if ((this.this$0.a() != null) && ((this.this$0.a() instanceof ComponentPageView)) && (((ComponentPageView)this.this$0.a()).a() != null) && (((ComponentPageView)this.this$0.a()).a().getVisibility() == 0)) {
      ((ComponentPageView)this.this$0.a()).a().setVisibility(8);
    }
    if (this.this$0.b() != null)
    {
      QCircleFakeAdapter.a(this.this$0).add(this.a.mSingleFakeFeed);
      this.this$0.b().add(0, this.a.mSingleFakeFeed);
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.4
 * JD-Core Version:    0.7.0.1
 */