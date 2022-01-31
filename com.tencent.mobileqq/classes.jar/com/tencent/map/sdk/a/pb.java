package com.tencent.map.sdk.a;

import android.graphics.Paint;
import android.graphics.Typeface;

public final class pb
  extends Paint
{
  public static Typeface a;
  
  public final Typeface setTypeface(Typeface paramTypeface)
  {
    Typeface localTypeface = a;
    if ((localTypeface != null) && ((Typeface.DEFAULT == paramTypeface) || (Typeface.DEFAULT_BOLD == paramTypeface))) {
      return super.setTypeface(localTypeface);
    }
    return super.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.pb
 * JD-Core Version:    0.7.0.1
 */