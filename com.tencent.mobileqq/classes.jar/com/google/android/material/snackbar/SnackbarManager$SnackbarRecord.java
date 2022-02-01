package com.google.android.material.snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager$SnackbarRecord
{
  @NonNull
  final WeakReference<SnackbarManager.Callback> a;
  int b;
  boolean c;
  
  boolean a(@Nullable SnackbarManager.Callback paramCallback)
  {
    return (paramCallback != null) && (this.a.get() == paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarManager.SnackbarRecord
 * JD-Core Version:    0.7.0.1
 */