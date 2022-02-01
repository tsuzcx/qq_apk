package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;

public class g
{
  private static float a = -1.0F;
  private static float b;
  private static SparseIntArray c = new SparseIntArray();
  
  public static float a(Context paramContext)
  {
    if ((paramContext != null) && (a < 0.0F)) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return a;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return Math.round(a(paramContext) * paramInt);
  }
  
  public static float b(Context paramContext)
  {
    if (b == 0.0F) {
      if (paramContext == null) {
        b = 1.0F;
      } else {
        b = paramContext.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0F);
      }
    }
    return b;
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("get dimension pixel size, resId %d, but context is null");
      paramContext.append(paramInt);
      f.e("WeUIResHelper", paramContext.toString(), new Object[0]);
      return 0;
    }
    int j = c.get(paramInt, 0);
    int i = j;
    if (j == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(paramInt);
      c.put(paramInt, i);
    }
    return i;
  }
  
  public static Drawable c(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(new int[] { paramInt });
    Drawable localDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
    return localDrawable;
  }
  
  public static int d(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */