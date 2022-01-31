package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;

class QCircleFakeAdapter$3
  implements Runnable
{
  QCircleFakeAdapter$3(QCircleFakeAdapter paramQCircleFakeAdapter, int paramInt) {}
  
  public void run()
  {
    this.this$0.a(this.a);
    if ((this.this$0.getDataList() != null) && (this.this$0.getDataList().size() == 0) && (this.this$0.getComponentPageView() != null) && ((this.this$0.getComponentPageView() instanceof QCircleComponentPageView)) && (this.this$0.getComponentPageView().a() != null) && (this.this$0.getComponentPageView().a().getVisibility() == 8)) {
      this.this$0.getComponentPageView().a().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.3
 * JD-Core Version:    0.7.0.1
 */