package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;

class QCircleFakeAdapter$3
  implements Runnable
{
  QCircleFakeAdapter$3(QCircleFakeAdapter paramQCircleFakeAdapter, int paramInt) {}
  
  public void run()
  {
    this.this$0.a(this.a);
    if ((this.this$0.b() != null) && (this.this$0.b().size() == 0) && (this.this$0.a() != null) && ((this.this$0.a() instanceof ComponentPageView)) && (((ComponentPageView)this.this$0.a()).a() != null) && (((ComponentPageView)this.this$0.a()).a().getVisibility() == 8)) {
      ((ComponentPageView)this.this$0.a()).a().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.3
 * JD-Core Version:    0.7.0.1
 */