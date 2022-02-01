package com.tencent.biz.qqcircle.widgets;

import android.support.v7.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import uyc;
import zlx;

class QCircleCommentListView$4
  implements Runnable
{
  QCircleCommentListView$4(QCircleCommentListView paramQCircleCommentListView, int paramInt) {}
  
  public void run()
  {
    int i = QCircleCommentListView.a(this.this$0).a(this.a);
    if ((QCircleCommentListView.a(this.this$0) != null) && (i != 0)) {
      QCircleCommentListView.a(this.this$0).scrollBy(0, -((i - 1) * zlx.a(BaseApplicationImpl.getContext(), 50.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.4
 * JD-Core Version:    0.7.0.1
 */