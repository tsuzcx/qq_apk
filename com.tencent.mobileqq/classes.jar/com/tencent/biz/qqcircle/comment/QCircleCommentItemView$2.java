package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.OnClickHookListener;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;

class QCircleCommentItemView$2
  implements QCircleCommentPraiseLayout.OnClickHookListener
{
  QCircleCommentItemView$2(QCircleCommentItemView paramQCircleCommentItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (QCircleCommentItemView.a(this.a) != null)
    {
      OnCommentElementClickListener localOnCommentElementClickListener = QCircleCommentItemView.a(this.a);
      QCircleCommentPraiseLayout localQCircleCommentPraiseLayout = QCircleCommentItemView.b(this.a);
      int i;
      if (paramBoolean) {
        i = 14;
      } else {
        i = 15;
      }
      localOnCommentElementClickListener.a(localQCircleCommentPraiseLayout, i, QCircleCommentItemView.c(this.a), QCircleCommentItemView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView.2
 * JD-Core Version:    0.7.0.1
 */