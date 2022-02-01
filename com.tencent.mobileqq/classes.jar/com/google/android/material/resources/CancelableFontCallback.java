package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback
  extends TextAppearanceFontCallback
{
  private final Typeface a;
  private final CancelableFontCallback.ApplyFont b;
  private boolean c;
  
  public CancelableFontCallback(CancelableFontCallback.ApplyFont paramApplyFont, Typeface paramTypeface)
  {
    this.a = paramTypeface;
    this.b = paramApplyFont;
  }
  
  private void a(Typeface paramTypeface)
  {
    if (!this.c) {
      this.b.a(paramTypeface);
    }
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public void a(int paramInt)
  {
    a(this.a);
  }
  
  public void a(Typeface paramTypeface, boolean paramBoolean)
  {
    a(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.resources.CancelableFontCallback
 * JD-Core Version:    0.7.0.1
 */