package androidx.core.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat
{
  public static int getLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 17) {
      i = paramMarginLayoutParams.getLayoutDirection();
    } else {
      i = 0;
    }
    int j = i;
    if (i != 0)
    {
      j = i;
      if (i != 1) {
        j = 0;
      }
    }
    return j;
  }
  
  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramMarginLayoutParams.getMarginEnd();
    }
    return paramMarginLayoutParams.rightMargin;
  }
  
  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramMarginLayoutParams.getMarginStart();
    }
    return paramMarginLayoutParams.leftMargin;
  }
  
  public static boolean isMarginRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramMarginLayoutParams.isMarginRelative();
    }
    return false;
  }
  
  public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramMarginLayoutParams.resolveLayoutDirection(paramInt);
    }
  }
  
  public static void setLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramMarginLayoutParams.setLayoutDirection(paramInt);
    }
  }
  
  public static void setMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginEnd(paramInt);
      return;
    }
    paramMarginLayoutParams.rightMargin = paramInt;
  }
  
  public static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginStart(paramInt);
      return;
    }
    paramMarginLayoutParams.leftMargin = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.MarginLayoutParamsCompat
 * JD-Core Version:    0.7.0.1
 */