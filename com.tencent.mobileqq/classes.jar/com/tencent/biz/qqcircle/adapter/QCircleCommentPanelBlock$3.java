package com.tencent.biz.qqcircle.adapter;

import java.util.ArrayList;

class QCircleCommentPanelBlock$3
  implements Runnable
{
  QCircleCommentPanelBlock$3(QCircleCommentPanelBlock paramQCircleCommentPanelBlock, int paramInt) {}
  
  public void run()
  {
    if (this.a != 0) {
      QCircleCommentPanelBlock.b(this.this$0);
    }
    this.this$0.notifyItemRemoved(this.a);
    QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.this$0;
    localQCircleCommentPanelBlock.notifyItemRangeChanged(this.a, QCircleCommentPanelBlock.e(localQCircleCommentPanelBlock).size() - this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.3
 * JD-Core Version:    0.7.0.1
 */