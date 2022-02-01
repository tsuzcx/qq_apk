package com.tencent.av.doodle;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

public abstract class PathDoodleItem
  extends DoodleItem
{
  protected Path j = new Path();
  protected PathMeasure k = null;
  
  public abstract void a();
  
  public void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    this.j.reset();
    this.j.moveTo(paramFloat1, paramFloat2);
    this.k.setPath(this.j, false);
    a();
  }
  
  public void c(float paramFloat1, float paramFloat2)
  {
    this.j.quadTo(this.h.x, this.h.y, (paramFloat1 + this.h.x) / 2.0F, (paramFloat2 + this.h.y) / 2.0F);
    this.k.setPath(this.j, false);
    a();
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    this.h.x = paramFloat1;
    this.h.y = paramFloat2;
    this.j.lineTo(this.h.x, this.h.y);
    this.k.setPath(this.j, false);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathDoodleItem
 * JD-Core Version:    0.7.0.1
 */