package com.tencent.luggage.widget;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.io.Serializable;

public class b
  implements Serializable
{
  private final float a;
  private final float b;
  private final float c;
  private final int d;
  
  public b(float paramFloat, @NonNull PointF paramPointF, int paramInt)
  {
    this.a = paramFloat;
    this.b = paramPointF.x;
    this.c = paramPointF.y;
    this.d = paramInt;
  }
  
  public float a()
  {
    return this.a;
  }
  
  @NonNull
  public PointF b()
  {
    return new PointF(this.b, this.c);
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.b
 * JD-Core Version:    0.7.0.1
 */