package com.bm.library;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView.ScaleType;

public class Info
{
  RectF a = new RectF();
  RectF b = new RectF();
  RectF c = new RectF();
  RectF d = new RectF();
  PointF e = new PointF();
  float f;
  float g;
  ImageView.ScaleType h;
  
  public Info(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType)
  {
    this.a.set(paramRectF1);
    this.b.set(paramRectF2);
    this.c.set(paramRectF3);
    this.f = paramFloat1;
    this.h = paramScaleType;
    this.g = paramFloat2;
    this.d.set(paramRectF4);
    this.e.set(paramPointF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.Info
 * JD-Core Version:    0.7.0.1
 */