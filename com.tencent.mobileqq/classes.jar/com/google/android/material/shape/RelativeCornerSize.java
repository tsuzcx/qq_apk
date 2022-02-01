package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class RelativeCornerSize
  implements CornerSize
{
  private final float a;
  
  public RelativeCornerSize(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public float a(@NonNull RectF paramRectF)
  {
    return this.a * paramRectF.height();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof RelativeCornerSize)) {
      return false;
    }
    paramObject = (RelativeCornerSize)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.RelativeCornerSize
 * JD-Core Version:    0.7.0.1
 */