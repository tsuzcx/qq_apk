package com.tencent.magicbrush;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/FpsInfo;", "", "()V", "fps", "", "exceedFps", "(FF)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class a
{
  @JvmField
  public float a;
  @JvmField
  public float b;
  
  public a()
  {
    this(0.0F, 0.0F);
  }
  
  public a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.a) * 31 + Float.floatToIntBits(this.b);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = Locale.ENGLISH;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ENGLISH");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.a);
    arrayOfObject[1] = Float.valueOf(this.b);
    localObject = String.format((Locale)localObject, "fps(%.2f, %.2f)", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, this, *args)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */