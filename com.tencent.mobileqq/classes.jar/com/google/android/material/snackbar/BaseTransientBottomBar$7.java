package com.google.android.material.snackbar;

import android.graphics.Insets;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsets;

class BaseTransientBottomBar$7
  implements BaseTransientBottomBar.OnAttachStateChangeListener
{
  BaseTransientBottomBar$7(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramView = this.a.b.getRootWindowInsets();
      if (paramView != null)
      {
        BaseTransientBottomBar.e(this.a, paramView.getMandatorySystemGestureInsets().bottom);
        BaseTransientBottomBar.c(this.a);
      }
    }
  }
  
  public void b(View paramView)
  {
    if (this.a.b()) {
      BaseTransientBottomBar.a.post(new BaseTransientBottomBar.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.7
 * JD-Core Version:    0.7.0.1
 */