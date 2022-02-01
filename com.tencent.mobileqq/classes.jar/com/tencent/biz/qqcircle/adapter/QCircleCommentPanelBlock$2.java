package com.tencent.biz.qqcircle.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class QCircleCommentPanelBlock$2
  implements Runnable
{
  public void run()
  {
    QCircleCommentPanelBlock.b(this.this$0);
    this.this$0.notifyItemInserted(this.a);
    QCircleCommentPanelBlock localQCircleCommentPanelBlock = this.this$0;
    localQCircleCommentPanelBlock.notifyItemRangeChanged(this.a, QCircleCommentPanelBlock.c(localQCircleCommentPanelBlock).size() - this.a);
    QCircleCommentPanelBlock.d(this.this$0).scrollToPosition(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.2
 * JD-Core Version:    0.7.0.1
 */