package com.tencent.biz.subscribe.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentInputPopupWindow$5
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 4) && (paramInt != 6))
    {
      bool = false;
    }
    else
    {
      if (CommentInputPopupWindow.g(this.a) != null) {
        CommentInputPopupWindow.g(this.a).a();
      }
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */