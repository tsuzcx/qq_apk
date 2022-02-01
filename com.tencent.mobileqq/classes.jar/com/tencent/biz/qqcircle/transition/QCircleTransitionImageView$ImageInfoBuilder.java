package com.tencent.biz.qqcircle.transition;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView.ScaleType;

class QCircleTransitionImageView$ImageInfoBuilder
{
  private final QCircleTransitionImageView.ImageInfo a = new QCircleTransitionImageView.ImageInfo(null);
  
  public QCircleTransitionImageView.ImageInfo a()
  {
    return this.a;
  }
  
  public ImageInfoBuilder a(float paramFloat)
  {
    this.a.f = paramFloat;
    return this;
  }
  
  public ImageInfoBuilder a(PointF paramPointF)
  {
    this.a.e.set(paramPointF);
    return this;
  }
  
  public ImageInfoBuilder a(RectF paramRectF)
  {
    this.a.a.set(paramRectF);
    return this;
  }
  
  public ImageInfoBuilder a(ImageView.ScaleType paramScaleType)
  {
    this.a.g = paramScaleType;
    return this;
  }
  
  public ImageInfoBuilder b(RectF paramRectF)
  {
    this.a.b.set(paramRectF);
    return this;
  }
  
  public ImageInfoBuilder c(RectF paramRectF)
  {
    this.a.c.set(paramRectF);
    return this;
  }
  
  public ImageInfoBuilder d(RectF paramRectF)
  {
    this.a.d.set(paramRectF);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView.ImageInfoBuilder
 * JD-Core Version:    0.7.0.1
 */