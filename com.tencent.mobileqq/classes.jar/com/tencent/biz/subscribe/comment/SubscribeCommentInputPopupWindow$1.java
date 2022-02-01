package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.view.View;

class SubscribeCommentInputPopupWindow$1
  implements CommentEditText.OnInputBackListener
{
  SubscribeCommentInputPopupWindow$1(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void a(View paramView)
  {
    if (this.a.isShowing()) {
      SubscribeCommentInputPopupWindow.a(this.a).runOnUiThread(new SubscribeCommentInputPopupWindow.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */