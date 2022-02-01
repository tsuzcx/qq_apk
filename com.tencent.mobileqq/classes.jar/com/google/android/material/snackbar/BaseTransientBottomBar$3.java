package com.google.android.material.snackbar;

import android.util.Log;
import android.view.ViewGroup.MarginLayoutParams;

class BaseTransientBottomBar$3
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (BaseTransientBottomBar.a(this.this$0) == null) {
        return;
      }
      int i = BaseTransientBottomBar.b(this.this$0) - BaseTransientBottomBar.c(this.this$0) + (int)this.this$0.a.getTranslationY();
      if (i >= BaseTransientBottomBar.d(this.this$0)) {
        return;
      }
      Object localObject = this.this$0.a.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams))
      {
        Log.w(BaseTransientBottomBar.a(), "Unable to apply gesture inset because layout params are not MarginLayoutParams");
        return;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += BaseTransientBottomBar.d(this.this$0) - i;
      this.this$0.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.3
 * JD-Core Version:    0.7.0.1
 */