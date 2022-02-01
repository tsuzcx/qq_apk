package com.tencent.crossengine.font;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

@Keep
public class SpineTextPainter
{
  private static final String TAG = "SpineTextPainter";
  private static FontPixelsFactory mFontPixelsFactory;
  
  public static Bitmap getTextPixels(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (mFontPixelsFactory == null) {
      return null;
    }
    FontPixelsFactory.FontOption localFontOption = new FontPixelsFactory.FontOption();
    localFontOption.a = paramInt1;
    localFontOption.b = paramInt2;
    localFontOption.c = paramFloat1;
    localFontOption.d = paramFloat2;
    localFontOption.e = paramFloat3;
    localFontOption.f = paramFloat4;
    return mFontPixelsFactory.a(paramString, localFontOption);
  }
  
  public static void setFontPixelsFactory(FontPixelsFactory paramFontPixelsFactory)
  {
    mFontPixelsFactory = paramFontPixelsFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.font.SpineTextPainter
 * JD-Core Version:    0.7.0.1
 */