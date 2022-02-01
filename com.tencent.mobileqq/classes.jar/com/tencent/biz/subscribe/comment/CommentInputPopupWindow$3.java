package com.tencent.biz.subscribe.comment;

import android.content.SharedPreferences.Editor;

class CommentInputPopupWindow$3
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public void a()
  {
    if (CommentInputPopupWindow.e(this.a))
    {
      CommentInputPopupWindow.b(this.a, false);
      CommentInputPopupWindow.f(this.a).setVisibility(0);
    }
    else
    {
      this.a.dismiss();
    }
    CommentInputPopupWindow.a(this.a, false);
  }
  
  public void a(int paramInt)
  {
    if (CommentInputPopupWindow.b(this.a) != paramInt)
    {
      CommentInputPopupWindow.a(this.a, paramInt);
      CommentInputPopupWindow.c(this.a);
      CommentInputPopupWindow.d(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      CommentInputPopupWindow.d(this.a).commit();
    }
    CommentInputPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */