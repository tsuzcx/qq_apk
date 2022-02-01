package com.tencent.biz.subscribe.comment;

import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class SubscribeCommentInputPopupWindow$5
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  SubscribeCommentInputPopupWindow$5(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (SubscribeCommentInputPopupWindow.a(this.a))
    {
      SubscribeCommentInputPopupWindow.b(this.a, false);
      if (SubscribeCommentInputPopupWindow.a(this.a) != null) {
        SubscribeCommentInputPopupWindow.a(this.a).setVisibility(0);
      }
      if (SubscribeCommentInputPopupWindow.a(this.a) != null) {
        SubscribeCommentInputPopupWindow.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      SubscribeCommentInputPopupWindow.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (SubscribeCommentInputPopupWindow.a(this.a) != paramInt)
    {
      SubscribeCommentInputPopupWindow.a(this.a, paramInt);
      SubscribeCommentInputPopupWindow.a(this.a);
      SubscribeCommentInputPopupWindow.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      SubscribeCommentInputPopupWindow.a(this.a).commit();
    }
    this.a.c();
    SubscribeCommentInputPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */