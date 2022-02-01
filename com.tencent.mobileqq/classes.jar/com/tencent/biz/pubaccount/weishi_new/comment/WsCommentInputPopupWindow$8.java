package com.tencent.biz.pubaccount.weishi_new.comment;

import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper;

class WsCommentInputPopupWindow$8
  implements Runnable
{
  WsCommentInputPopupWindow$8(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void run()
  {
    if (WsCommentInputPopupWindow.k(this.this$0) == null) {
      return;
    }
    WsCommentInputPopupWindow.k(this.this$0).a(WsCommentInputPopupWindow.l(this.this$0));
    WsCommentInputPopupWindow.c(this.this$0, true);
    WsCommentInputPopupWindow.g(this.this$0).requestFocus();
    WsCommentInputPopupWindow.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.8
 * JD-Core Version:    0.7.0.1
 */