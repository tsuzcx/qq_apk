package com.google.android.material.snackbar;

import android.os.Handler.Callback;
import android.os.Message;
import androidx.annotation.NonNull;

class SnackbarManager$1
  implements Handler.Callback
{
  SnackbarManager$1(SnackbarManager paramSnackbarManager) {}
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return false;
    }
    this.a.a((SnackbarManager.SnackbarRecord)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarManager.1
 * JD-Core Version:    0.7.0.1
 */