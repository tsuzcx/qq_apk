package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class ViewUtils$1
  implements Runnable
{
  ViewUtils$1(View paramView) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils.1
 * JD-Core Version:    0.7.0.1
 */