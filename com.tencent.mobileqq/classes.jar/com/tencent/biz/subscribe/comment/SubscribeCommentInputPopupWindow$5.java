package com.tencent.biz.subscribe.comment;

import android.content.SharedPreferences.Editor;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class SubscribeCommentInputPopupWindow$5
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  SubscribeCommentInputPopupWindow$5(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (SubscribeCommentInputPopupWindow.e(this.a))
    {
      SubscribeCommentInputPopupWindow.b(this.a, false);
      if (SubscribeCommentInputPopupWindow.f(this.a) != null) {
        SubscribeCommentInputPopupWindow.f(this.a).getView().setVisibility(0);
      }
      if (SubscribeCommentInputPopupWindow.g(this.a) != null) {
        SubscribeCommentInputPopupWindow.g(this.a).setVisibility(0);
      }
    }
    else
    {
      this.a.dismiss();
    }
    SubscribeCommentInputPopupWindow.a(this.a, false);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (SubscribeCommentInputPopupWindow.b(this.a) != paramInt)
    {
      SubscribeCommentInputPopupWindow.a(this.a, paramInt);
      SubscribeCommentInputPopupWindow.c(this.a);
      SubscribeCommentInputPopupWindow.d(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      SubscribeCommentInputPopupWindow.d(this.a).commit();
    }
    this.a.c();
    SubscribeCommentInputPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */