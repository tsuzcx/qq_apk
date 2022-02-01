package com.tencent.biz.qqcircle.widgets;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.NestScrollDelegate;

class QCircleCommentListView$11
  implements NestScrollRecyclerView.NestScrollDelegate
{
  QCircleCommentListView$11(QCircleCommentListView paramQCircleCommentListView) {}
  
  public boolean a(RecyclerView paramRecyclerView)
  {
    if ((QCircleCommentListView.k(this.a) != null) && (QCircleCommentListView.l(this.a) != null))
    {
      paramRecyclerView = new Rect();
      return QCircleCommentListView.l(this.a).getGlobalVisibleRect(paramRecyclerView);
    }
    return false;
  }
  
  public float[] a()
  {
    Rect localRect = new Rect();
    QCircleCommentListView.l(this.a).getGlobalVisibleRect(localRect);
    return new float[] { localRect.left, localRect.top };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.11
 * JD-Core Version:    0.7.0.1
 */