package com.google.android.material.internal;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextWatcherAdapter
  implements TextWatcher
{
  public void afterTextChanged(@NonNull Editable paramEditable) {}
  
  public void beforeTextChanged(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.TextWatcherAdapter
 * JD-Core Version:    0.7.0.1
 */