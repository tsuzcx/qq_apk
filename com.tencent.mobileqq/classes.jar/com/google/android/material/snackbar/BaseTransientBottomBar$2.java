package com.google.android.material.snackbar;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class BaseTransientBottomBar$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    if (!BaseTransientBottomBar.a(this.a)) {
      return;
    }
    BaseTransientBottomBar localBaseTransientBottomBar = this.a;
    BaseTransientBottomBar.a(localBaseTransientBottomBar, BaseTransientBottomBar.a(localBaseTransientBottomBar));
    BaseTransientBottomBar.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.2
 * JD-Core Version:    0.7.0.1
 */