package com.tencent.biz.qqcircle.comment;

import android.widget.ImageButton;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;

class QCircleCommentInputPopupWindow$4
  implements Runnable
{
  QCircleCommentInputPopupWindow$4(QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow) {}
  
  public void run()
  {
    QCircleCommentInputPopupWindow.b(this.this$0).setVisibility(8);
    QCircleCommentInputPopupWindow.c(this.this$0).setVisibility(0);
    QCircleCommentInputPopupWindow.a(this.this$0, true);
    this.this$0.c.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */