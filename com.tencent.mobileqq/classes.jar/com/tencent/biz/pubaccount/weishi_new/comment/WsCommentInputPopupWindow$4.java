package com.tencent.biz.pubaccount.weishi_new.comment;

import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class WsCommentInputPopupWindow$4
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  WsCommentInputPopupWindow$4(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void a()
  {
    WSLog.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onSoftKeyboardClosed]");
    if (WsCommentInputPopupWindow.f(this.a).d()) {
      WsCommentInputPopupWindow.f(this.a).b();
    } else {
      this.a.dismiss();
    }
    WsCommentInputPopupWindow.a(this.a, false);
  }
  
  public void a(int paramInt)
  {
    WSLog.b("WsCommentInputPopupWindow", "[WsCommentInputPopupWindow.java][onSoftKeyboardOpened]");
    if (WsCommentInputPopupWindow.c(this.a) != paramInt)
    {
      WsCommentInputPopupWindow.a(this.a, paramInt);
      WsCommentInputPopupWindow.d(this.a);
      WsCommentInputPopupWindow.e(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      WsCommentInputPopupWindow.e(this.a).commit();
    }
    WsCommentInputPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */