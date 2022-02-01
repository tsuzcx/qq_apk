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
    localFontOption.jdField_a_of_type_Int = paramInt1;
    localFontOption.jdField_b_of_type_Int = paramInt2;
    localFontOption.jdField_a_of_type_Float = paramFloat1;
    localFontOption.jdField_b_of_type_Float = paramFloat2;
    localFontOption.c = paramFloat3;
    localFontOption.d = paramFloat4;
    return mFontPixelsFactory.a(paramString, localFontOption);
  }
  
  public static void setFontPixelsFactory(FontPixelsFactory paramFontPixelsFactory)
  {
    mFontPixelsFactory = paramFontPixelsFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.font.SpineTextPainter
 * JD-Core Version:    0.7.0.1
 */