package com.google.android.material.internal;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

class TextDrawableHelper$1
  extends TextAppearanceFontCallback
{
  TextDrawableHelper$1(TextDrawableHelper paramTextDrawableHelper) {}
  
  public void a(int paramInt)
  {
    TextDrawableHelper.a(this.a, true);
    TextDrawableHelper.TextDrawableDelegate localTextDrawableDelegate = (TextDrawableHelper.TextDrawableDelegate)TextDrawableHelper.a(this.a).get();
    if (localTextDrawableDelegate != null) {
      localTextDrawableDelegate.f();
    }
  }
  
  public void a(@NonNull Typeface paramTypeface, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    TextDrawableHelper.a(this.a, true);
    paramTypeface = (TextDrawableHelper.TextDrawableDelegate)TextDrawableHelper.a(this.a).get();
    if (paramTypeface != null) {
      paramTypeface.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.TextDrawableHelper.1
 * JD-Core Version:    0.7.0.1
 */