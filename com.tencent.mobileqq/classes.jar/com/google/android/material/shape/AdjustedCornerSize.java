package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize
  implements CornerSize
{
  private final CornerSize a;
  private final float b;
  
  public AdjustedCornerSize(float paramFloat, @NonNull CornerSize paramCornerSize)
  {
    while ((paramCornerSize instanceof AdjustedCornerSize))
    {
      paramCornerSize = ((AdjustedCornerSize)paramCornerSize).a;
      paramFloat += ((AdjustedCornerSize)paramCornerSize).b;
    }
    this.a = paramCornerSize;
    this.b = paramFloat;
  }
  
  public float a(@NonNull RectF paramRectF)
  {
    return Math.max(0.0F, this.a.a(paramRectF) + this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AdjustedCornerSize)) {
      return false;
    }
    paramObject = (AdjustedCornerSize)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b == paramObject.b);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, Float.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.AdjustedCornerSize
 * JD-Core Version:    0.7.0.1
 */