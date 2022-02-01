package com.tencent.biz.pubaccount.weishi_new.comment;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.subscribe.comment.CommentEditText.OnInputBackListener;

class WsCommentInputPopupWindow$1
  implements CommentEditText.OnInputBackListener
{
  WsCommentInputPopupWindow$1(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void a(View paramView)
  {
    if ((this.a.isShowing()) && (!WsCommentInputPopupWindow.a(this.a).isFinishing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */