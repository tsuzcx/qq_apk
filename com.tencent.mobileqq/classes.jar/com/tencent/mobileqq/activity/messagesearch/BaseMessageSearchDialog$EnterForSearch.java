package com.tencent.mobileqq.activity.messagesearch;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BaseMessageSearchDialog$EnterForSearch
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  protected BaseMessageSearchDialog$EnterForSearch(BaseMessageSearchDialog paramBaseMessageSearchDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 3)
    {
      this.a.a();
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() != 66) && (paramKeyEvent.getKeyCode() != 84)) {
      return false;
    }
    if (paramKeyEvent.getAction() == 1) {
      this.a.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.EnterForSearch
 * JD-Core Version:    0.7.0.1
 */