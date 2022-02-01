package com.tencent.biz.qqcircle.widgets;

import com.tencent.qphone.base.util.QLog;

class QCircleExpandableTextView$3
  implements Runnable
{
  QCircleExpandableTextView$3(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void run()
  {
    QCircleExpandableTextView localQCircleExpandableTextView = this.this$0;
    localQCircleExpandableTextView.k = (localQCircleExpandableTextView.getHeight() - this.this$0.a.getHeight());
    localQCircleExpandableTextView = this.this$0;
    localQCircleExpandableTextView.j = (QCircleExpandableTextView.a(localQCircleExpandableTextView, localQCircleExpandableTextView.a, this.this$0.c) + this.this$0.k);
    QLog.d("QCircleExpandableTextView", 1, new Object[] { "onMeasure isCollapsed == false lastHeight: ", Integer.valueOf(this.this$0.k), " | collapsedHeight: ", Integer.valueOf(this.this$0.j) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.3
 * JD-Core Version:    0.7.0.1
 */