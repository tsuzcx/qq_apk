package com.google.android.material.snackbar;

import android.os.Handler.Callback;
import android.os.Message;
import androidx.annotation.NonNull;

final class BaseTransientBottomBar$1
  implements Handler.Callback
{
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      ((BaseTransientBottomBar)paramMessage.obj).b(paramMessage.arg1);
      return true;
    }
    ((BaseTransientBottomBar)paramMessage.obj).b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.1
 * JD-Core Version:    0.7.0.1
 */