package com.tencent.biz.pubaccount.weishi_new.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.subscribe.comment.CommentBoxListener;

class WsCommentInputPopupWindow$6
  implements TextView.OnEditorActionListener
{
  WsCommentInputPopupWindow$6(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 4) && (paramInt != 6)) {
      return false;
    }
    if (WsCommentInputPopupWindow.a(this.a) != null) {
      WsCommentInputPopupWindow.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */