package com.tencent.luggage.wxa.qx;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

@Deprecated
public final class a
{
  private static float a = -1.0F;
  private static SparseIntArray b = new SparseIntArray();
  private static boolean c = false;
  private static boolean d = true;
  private static float e = 0.0F;
  
  public static float a(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = r.a();
    }
    if (a < 0.0F) {
      a = localContext.getResources().getDisplayMetrics().density;
    }
    return a;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return Math.round(a(paramContext) * paramFloat);
  }
  
  @Nullable
  public static Drawable a(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    return ContextCompat.getDrawable(paramContext, paramInt);
  }
  
  public static int b(@NonNull Context paramContext, @DimenRes int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  @Nullable
  public static String c(@NonNull Context paramContext, @StringRes int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().getString(paramInt);
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static int d(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      o.b("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
      return 0;
    }
    int j = b.get(paramInt, 0);
    int i = j;
    if (j == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(paramInt);
      b.put(paramInt, i);
    }
    return i;
  }
  
  public static int e(Context paramContext, int paramInt)
  {
    return Math.round(a(paramContext) * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qx.a
 * JD-Core Version:    0.7.0.1
 */