package com.tencent.biz.qqcircle.transition;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView.ScaleType;

public class QCircleTransitionImageView$ImageInfo
{
  RectF a = new RectF();
  RectF b = new RectF();
  RectF c = new RectF();
  RectF d = new RectF();
  PointF e = new PointF();
  float f;
  ImageView.ScaleType g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRect:");
    Object localObject = this.a;
    String str = "null";
    if (localObject != null) {
      localObject = ((RectF)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" mImgRect:");
    localObject = this.b;
    if (localObject != null) {
      localObject = ((RectF)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" mWidgetRect:");
    localObject = this.c;
    if (localObject != null) {
      localObject = ((RectF)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" mBaseRect:");
    localObject = this.d;
    if (localObject != null) {
      localObject = ((RectF)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" mWidgetCenter:");
    PointF localPointF = this.e;
    localObject = str;
    if (localPointF != null) {
      localObject = localPointF.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" mScale:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView.ImageInfo
 * JD-Core Version:    0.7.0.1
 */