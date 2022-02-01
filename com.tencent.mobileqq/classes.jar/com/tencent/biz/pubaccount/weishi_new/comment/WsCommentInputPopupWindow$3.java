package com.tencent.biz.pubaccount.weishi_new.comment;

import android.content.SharedPreferences.Editor;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class WsCommentInputPopupWindow$3
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  WsCommentInputPopupWindow$3(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void a()
  {
    if (WsCommentInputPopupWindow.a(this.a).a()) {
      WsCommentInputPopupWindow.a(this.a).b();
    } else {
      this.a.dismiss();
    }
    WsCommentInputPopupWindow.a(this.a, false);
  }
  
  public void a(int paramInt)
  {
    if (WsCommentInputPopupWindow.a(this.a) != paramInt)
    {
      WsCommentInputPopupWindow.a(this.a, paramInt);
      WsCommentInputPopupWindow.a(this.a);
      WsCommentInputPopupWindow.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      WsCommentInputPopupWindow.a(this.a).commit();
    }
    WsCommentInputPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */