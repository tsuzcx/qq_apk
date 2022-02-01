package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;

class QCircleExpandableTextView$2
  implements Runnable
{
  QCircleExpandableTextView$2(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void run()
  {
    QCircleExpandableTextView localQCircleExpandableTextView = this.this$0;
    localQCircleExpandableTextView.k = (localQCircleExpandableTextView.getHeight() - this.this$0.a.getHeight());
    localQCircleExpandableTextView = this.this$0;
    localQCircleExpandableTextView.j = localQCircleExpandableTextView.getMeasuredHeight();
    QLog.d("QCircleExpandableTextView", 1, new Object[] { "onMeasure isCollapsed == true lastHeight: ", Integer.valueOf(this.this$0.k), " | collapsedHeight: ", Integer.valueOf(this.this$0.j) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.2
 * JD-Core Version:    0.7.0.1
 */