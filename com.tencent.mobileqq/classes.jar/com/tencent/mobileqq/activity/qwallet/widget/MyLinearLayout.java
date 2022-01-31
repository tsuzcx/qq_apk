package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class MyLinearLayout
  extends LinearLayout
{
  private MyLinearLayout.DispatchKeyEventListener mDispatchKeyEventListener;
  
  public MyLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.mDispatchKeyEventListener != null) && (this.mDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void setDispatchKeyEventListener(MyLinearLayout.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.mDispatchKeyEventListener = paramDispatchKeyEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout
 * JD-Core Version:    0.7.0.1
 */