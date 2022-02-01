package com.google.android.material.snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager$SnackbarRecord
{
  int jdField_a_of_type_Int;
  @NonNull
  final WeakReference<SnackbarManager.Callback> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  
  boolean a(@Nullable SnackbarManager.Callback paramCallback)
  {
    return (paramCallback != null) && (this.a.get() == paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarManager.SnackbarRecord
 * JD-Core Version:    0.7.0.1
 */