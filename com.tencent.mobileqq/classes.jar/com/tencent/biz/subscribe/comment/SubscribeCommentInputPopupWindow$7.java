package com.tencent.biz.subscribe.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class SubscribeCommentInputPopupWindow$7
  implements TextView.OnEditorActionListener
{
  SubscribeCommentInputPopupWindow$7(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return false;
    }
    if (SubscribeCommentInputPopupWindow.a(this.a) != null) {
      SubscribeCommentInputPopupWindow.a(this.a).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */