package com.google.android.material.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs
{
  @NonNull
  public static InsetDrawable a(@Nullable Drawable paramDrawable, @NonNull Rect paramRect)
  {
    return new InsetDrawable(paramDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.dialog.MaterialDialogs
 * JD-Core Version:    0.7.0.1
 */