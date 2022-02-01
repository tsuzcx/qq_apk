package com.tencent.mm.ui;

import android.graphics.Color;
import androidx.annotation.ColorInt;

public class e
{
  public static boolean a(@ColorInt int paramInt)
  {
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.3D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */