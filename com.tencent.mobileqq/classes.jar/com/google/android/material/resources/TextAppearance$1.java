package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat.FontCallback;

class TextAppearance$1
  extends ResourcesCompat.FontCallback
{
  TextAppearance$1(TextAppearance paramTextAppearance, TextAppearanceFontCallback paramTextAppearanceFontCallback) {}
  
  public void onFontRetrievalFailed(int paramInt)
  {
    TextAppearance.a(this.b, true);
    this.a.a(paramInt);
  }
  
  public void onFontRetrieved(@NonNull Typeface paramTypeface)
  {
    TextAppearance localTextAppearance = this.b;
    TextAppearance.a(localTextAppearance, Typeface.create(paramTypeface, localTextAppearance.f));
    TextAppearance.a(this.b, true);
    this.a.a(TextAppearance.a(this.b), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.resources.TextAppearance.1
 * JD-Core Version:    0.7.0.1
 */