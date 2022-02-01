package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;

class QCircleDoubleClickLayout$2
  implements Runnable
{
  QCircleDoubleClickLayout$2(QCircleDoubleClickLayout paramQCircleDoubleClickLayout) {}
  
  public void run()
  {
    if (QCircleDoubleClickLayout.d(this.this$0) != null)
    {
      QCircleDoubleClickLayout.d(this.this$0).onLongClick();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLongClick:");
      localStringBuilder.append(QCircleDoubleClickLayout.a(this.this$0));
      QLog.d("QCircleDoubleClickLayout", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.2
 * JD-Core Version:    0.7.0.1
 */