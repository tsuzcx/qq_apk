package com.google.android.material.snackbar;

import android.os.Handler;

class BaseTransientBottomBar$6
  implements SnackbarManager.Callback
{
  public void a()
  {
    BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(0, this.a));
  }
  
  public void a(int paramInt)
  {
    BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(1, paramInt, 0, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.6
 * JD-Core Version:    0.7.0.1
 */