package com.tencent.biz.subscribe.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class CommentInputPopupWindow$5
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 4) && (paramInt != 6)) {
      return false;
    }
    if (CommentInputPopupWindow.a(this.a) != null) {
      CommentInputPopupWindow.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */