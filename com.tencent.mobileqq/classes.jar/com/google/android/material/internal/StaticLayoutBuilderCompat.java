package com.google.android.material.internal;

import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat
{
  private static boolean a;
  @Nullable
  private static Constructor<StaticLayout> b;
  @Nullable
  private static Object c;
  private CharSequence d;
  private final TextPaint e;
  private final int f;
  private int g;
  private int h;
  private Layout.Alignment i;
  private int j;
  private boolean k;
  private boolean l;
  @Nullable
  private TextUtils.TruncateAt m;
  
  private StaticLayoutBuilderCompat(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    this.d = paramCharSequence;
    this.e = paramTextPaint;
    this.f = paramInt;
    this.g = 0;
    this.h = paramCharSequence.length();
    this.i = Layout.Alignment.ALIGN_NORMAL;
    this.j = 2147483647;
    this.k = true;
    this.m = null;
  }
  
  @NonNull
  public static StaticLayoutBuilderCompat a(@NonNull CharSequence paramCharSequence, @NonNull TextPaint paramTextPaint, @IntRange(from=0L) int paramInt)
  {
    return new StaticLayoutBuilderCompat(paramCharSequence, paramTextPaint, paramInt);
  }
  
  private void b()
  {
    if (a) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((this.l) && (Build.VERSION.SDK_INT >= 23))
        {
          n = 1;
          Object localObject2;
          Object localObject1;
          if (Build.VERSION.SDK_INT >= 18)
          {
            localObject2 = TextDirectionHeuristic.class;
            if (n != 0) {
              localObject1 = TextDirectionHeuristics.RTL;
            } else {
              localObject1 = TextDirectionHeuristics.LTR;
            }
            c = localObject1;
            localObject1 = localObject2;
          }
          else
          {
            Object localObject3 = StaticLayoutBuilderCompat.class.getClassLoader();
            if (!this.l) {
              break label234;
            }
            localObject1 = "RTL";
            localObject2 = ((ClassLoader)localObject3).loadClass("android.text.TextDirectionHeuristic");
            localObject3 = ((ClassLoader)localObject3).loadClass("android.text.TextDirectionHeuristics");
            c = ((Class)localObject3).getField((String)localObject1).get(localObject3);
            localObject1 = localObject2;
          }
          b = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject1, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
          b.setAccessible(true);
          a = true;
          return;
        }
      }
      catch (Exception localException)
      {
        throw new StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(localException);
      }
      int n = 0;
      continue;
      label234:
      String str = "LTR";
    }
  }
  
  public StaticLayout a()
  {
    if (this.d == null) {
      this.d = "";
    }
    int n = Math.max(0, this.f);
    Object localObject2 = this.d;
    Object localObject1 = localObject2;
    if (this.j == 1) {
      localObject1 = TextUtils.ellipsize((CharSequence)localObject2, this.e, n, this.m);
    }
    this.h = Math.min(((CharSequence)localObject1).length(), this.h);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.l) {
        this.i = Layout.Alignment.ALIGN_OPPOSITE;
      }
      localObject2 = StaticLayout.Builder.obtain((CharSequence)localObject1, this.g, this.h, this.e, n);
      ((StaticLayout.Builder)localObject2).setAlignment(this.i);
      ((StaticLayout.Builder)localObject2).setIncludePad(this.k);
      if (this.l) {
        localObject1 = TextDirectionHeuristics.RTL;
      } else {
        localObject1 = TextDirectionHeuristics.LTR;
      }
      ((StaticLayout.Builder)localObject2).setTextDirection((TextDirectionHeuristic)localObject1);
      localObject1 = this.m;
      if (localObject1 != null) {
        ((StaticLayout.Builder)localObject2).setEllipsize((TextUtils.TruncateAt)localObject1);
      }
      ((StaticLayout.Builder)localObject2).setMaxLines(this.j);
      return ((StaticLayout.Builder)localObject2).build();
    }
    b();
    try
    {
      localObject1 = (StaticLayout)((Constructor)Preconditions.checkNotNull(b)).newInstance(new Object[] { localObject1, Integer.valueOf(this.g), Integer.valueOf(this.h), this.e, Integer.valueOf(n), this.i, Preconditions.checkNotNull(c), Float.valueOf(1.0F), Float.valueOf(0.0F), Boolean.valueOf(this.k), null, Integer.valueOf(n), Integer.valueOf(this.j) });
      return localObject1;
    }
    catch (Exception localException)
    {
      throw new StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(localException);
    }
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(@IntRange(from=0L) int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(@NonNull Layout.Alignment paramAlignment)
  {
    this.i = paramAlignment;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(@Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    this.m = paramTruncateAt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public StaticLayoutBuilderCompat b(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.StaticLayoutBuilderCompat
 * JD-Core Version:    0.7.0.1
 */