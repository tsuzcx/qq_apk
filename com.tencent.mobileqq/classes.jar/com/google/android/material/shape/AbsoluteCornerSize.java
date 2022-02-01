package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class AbsoluteCornerSize
  implements CornerSize
{
  private final float a;
  
  public AbsoluteCornerSize(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public float a(@NonNull RectF paramRectF)
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AbsoluteCornerSize)) {
      return false;
    }
    paramObject = (AbsoluteCornerSize)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.AbsoluteCornerSize
 * JD-Core Version:    0.7.0.1
 */