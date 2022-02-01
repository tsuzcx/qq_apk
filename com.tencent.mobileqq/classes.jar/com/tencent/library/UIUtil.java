package com.tencent.library;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class UIUtil
{
  public static float a(Context paramContext, float paramFloat, IHeaderView paramIHeaderView)
  {
    float f;
    if (paramIHeaderView == null) {
      f = paramContext.getResources().getDisplayMetrics().density;
    } else {
      f = paramIHeaderView.a(paramContext);
    }
    return paramFloat / f + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.library.UIUtil
 * JD-Core Version:    0.7.0.1
 */