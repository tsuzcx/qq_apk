package com.tencent.biz.qqcircle.widgets;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock;
import com.tencent.biz.qqcircle.utils.ViewUtils;

class QCircleCommentListView$4
  implements Runnable
{
  QCircleCommentListView$4(QCircleCommentListView paramQCircleCommentListView, int paramInt) {}
  
  public void run()
  {
    int i = QCircleCommentListView.b(this.this$0).a(this.a);
    if ((QCircleCommentListView.c(this.this$0) != null) && (i != 0)) {
      QCircleCommentListView.c(this.this$0).scrollBy(0, -((i - 1) * ViewUtils.a(50.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.4
 * JD-Core Version:    0.7.0.1
 */