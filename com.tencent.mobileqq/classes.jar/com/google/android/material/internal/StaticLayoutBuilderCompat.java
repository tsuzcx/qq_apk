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
  @Nullable
  private static Object jdField_a_of_type_JavaLangObject;
  @Nullable
  private static Constructor<StaticLayout> jdField_a_of_type_JavaLangReflectConstructor;
  private static boolean jdField_a_of_type_Boolean;
  private final int jdField_a_of_type_Int;
  private Layout.Alignment jdField_a_of_type_AndroidTextLayout$Alignment;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  @Nullable
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  private StaticLayoutBuilderCompat(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = paramCharSequence.length();
    this.jdField_a_of_type_AndroidTextLayout$Alignment = Layout.Alignment.ALIGN_NORMAL;
    this.d = 2147483647;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = null;
  }
  
  @NonNull
  public static StaticLayoutBuilderCompat a(@NonNull CharSequence paramCharSequence, @NonNull TextPaint paramTextPaint, @IntRange(from=0L) int paramInt)
  {
    return new StaticLayoutBuilderCompat(paramCharSequence, paramTextPaint, paramInt);
  }
  
  private void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 23))
        {
          i = 1;
          Object localObject2;
          Object localObject1;
          if (Build.VERSION.SDK_INT >= 18)
          {
            localObject2 = TextDirectionHeuristic.class;
            if (i != 0) {
              localObject1 = TextDirectionHeuristics.RTL;
            } else {
              localObject1 = TextDirectionHeuristics.LTR;
            }
            jdField_a_of_type_JavaLangObject = localObject1;
            localObject1 = localObject2;
          }
          else
          {
            Object localObject3 = StaticLayoutBuilderCompat.class.getClassLoader();
            if (!this.jdField_c_of_type_Boolean) {
              break label234;
            }
            localObject1 = "RTL";
            localObject2 = ((ClassLoader)localObject3).loadClass("android.text.TextDirectionHeuristic");
            localObject3 = ((ClassLoader)localObject3).loadClass("android.text.TextDirectionHeuristics");
            jdField_a_of_type_JavaLangObject = ((Class)localObject3).getField((String)localObject1).get(localObject3);
            localObject1 = localObject2;
          }
          jdField_a_of_type_JavaLangReflectConstructor = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject1, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
          jdField_a_of_type_JavaLangReflectConstructor.setAccessible(true);
          jdField_a_of_type_Boolean = true;
          return;
        }
      }
      catch (Exception localException)
      {
        throw new StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(localException);
      }
      int i = 0;
      continue;
      label234:
      String str = "LTR";
    }
  }
  
  public StaticLayout a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = "";
    }
    int i = Math.max(0, this.jdField_a_of_type_Int);
    Object localObject2 = this.jdField_a_of_type_JavaLangCharSequence;
    Object localObject1 = localObject2;
    if (this.d == 1) {
      localObject1 = TextUtils.ellipsize((CharSequence)localObject2, this.jdField_a_of_type_AndroidTextTextPaint, i, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt);
    }
    this.jdField_c_of_type_Int = Math.min(((CharSequence)localObject1).length(), this.jdField_c_of_type_Int);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidTextLayout$Alignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      localObject2 = StaticLayout.Builder.obtain((CharSequence)localObject1, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidTextTextPaint, i);
      ((StaticLayout.Builder)localObject2).setAlignment(this.jdField_a_of_type_AndroidTextLayout$Alignment);
      ((StaticLayout.Builder)localObject2).setIncludePad(this.jdField_b_of_type_Boolean);
      if (this.jdField_c_of_type_Boolean) {
        localObject1 = TextDirectionHeuristics.RTL;
      } else {
        localObject1 = TextDirectionHeuristics.LTR;
      }
      ((StaticLayout.Builder)localObject2).setTextDirection((TextDirectionHeuristic)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
      if (localObject1 != null) {
        ((StaticLayout.Builder)localObject2).setEllipsize((TextUtils.TruncateAt)localObject1);
      }
      ((StaticLayout.Builder)localObject2).setMaxLines(this.d);
      return ((StaticLayout.Builder)localObject2).build();
    }
    a();
    try
    {
      localObject1 = (StaticLayout)((Constructor)Preconditions.checkNotNull(jdField_a_of_type_JavaLangReflectConstructor)).newInstance(new Object[] { localObject1, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_AndroidTextTextPaint, Integer.valueOf(i), this.jdField_a_of_type_AndroidTextLayout$Alignment, Preconditions.checkNotNull(jdField_a_of_type_JavaLangObject), Float.valueOf(1.0F), Float.valueOf(0.0F), Boolean.valueOf(this.jdField_b_of_type_Boolean), null, Integer.valueOf(i), Integer.valueOf(this.d) });
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
    this.d = paramInt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(@NonNull Layout.Alignment paramAlignment)
  {
    this.jdField_a_of_type_AndroidTextLayout$Alignment = paramAlignment;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(@Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = paramTruncateAt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public StaticLayoutBuilderCompat b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.StaticLayoutBuilderCompat
 * JD-Core Version:    0.7.0.1
 */