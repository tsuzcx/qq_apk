package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;
import vvw;

class QCircleDoubleClickLayout$2
  implements Runnable
{
  QCircleDoubleClickLayout$2(QCircleDoubleClickLayout paramQCircleDoubleClickLayout) {}
  
  public void run()
  {
    if (QCircleDoubleClickLayout.a(this.this$0) != null)
    {
      QCircleDoubleClickLayout.a(this.this$0).a();
      QLog.d("QCircleDoubleClickLayout", 1, "onLongClick:" + QCircleDoubleClickLayout.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.2
 * JD-Core Version:    0.7.0.1
 */