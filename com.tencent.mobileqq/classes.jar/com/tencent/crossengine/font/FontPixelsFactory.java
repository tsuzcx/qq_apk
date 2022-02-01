package com.tencent.crossengine.font;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public abstract interface FontPixelsFactory
{
  public abstract Bitmap a(String paramString, @NonNull FontPixelsFactory.FontOption paramFontOption);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.font.FontPixelsFactory
 * JD-Core Version:    0.7.0.1
 */