package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;
import vyy;

class QCircleDoubleClickLayout$1
  implements Runnable
{
  QCircleDoubleClickLayout$1(QCircleDoubleClickLayout paramQCircleDoubleClickLayout) {}
  
  public void run()
  {
    QCircleDoubleClickLayout.a(this.this$0, false);
    if ((QCircleDoubleClickLayout.a(this.this$0) >= 2) && (QCircleDoubleClickLayout.a(this.this$0) != null))
    {
      QCircleDoubleClickLayout.a(this.this$0).a();
      QLog.d("QCircleDoubleClickLayout", 1, "onDoubleClick:" + QCircleDoubleClickLayout.a(this.this$0));
    }
    if (QCircleDoubleClickLayout.a(this.this$0) == 1) {
      QCircleDoubleClickLayout.a(this.this$0);
    }
    QCircleDoubleClickLayout.a(this.this$0, 0);
    QCircleDoubleClickLayout.a(this.this$0, null);
    QCircleDoubleClickLayout.b(this.this$0, null);
    QCircleDoubleClickLayout.c(this.this$0, null);
    QCircleDoubleClickLayout.d(this.this$0, null);
    QCircleDoubleClickLayout.e(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.1
 * JD-Core Version:    0.7.0.1
 */