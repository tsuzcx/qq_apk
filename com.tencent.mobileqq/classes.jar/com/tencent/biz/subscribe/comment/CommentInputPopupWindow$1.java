package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.view.View;

class CommentInputPopupWindow$1
  implements CommentEditText.OnInputBackListener
{
  public void a(View paramView)
  {
    if (this.a.isShowing()) {
      CommentInputPopupWindow.a(this.a).runOnUiThread(new CommentInputPopupWindow.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */