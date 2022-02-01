package com.google.android.material.snackbar;

import android.util.Log;
import android.view.ViewGroup.MarginLayoutParams;

class BaseTransientBottomBar$3
  implements Runnable
{
  public void run()
  {
    if (this.this$0.b != null)
    {
      if (BaseTransientBottomBar.d(this.this$0) == null) {
        return;
      }
      int i = BaseTransientBottomBar.e(this.this$0) - BaseTransientBottomBar.f(this.this$0) + (int)this.this$0.b.getTranslationY();
      if (i >= BaseTransientBottomBar.g(this.this$0)) {
        return;
      }
      Object localObject = this.this$0.b.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams))
      {
        Log.w(BaseTransientBottomBar.h(), "Unable to apply gesture inset because layout params are not MarginLayoutParams");
        return;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += BaseTransientBottomBar.g(this.this$0) - i;
      this.this$0.b.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.3
 * JD-Core Version:    0.7.0.1
 */