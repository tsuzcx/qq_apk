package com.bm.library;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView.ScaleType;

public class Info
{
  float jdField_a_of_type_Float;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  float jdField_b_of_type_Float;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  RectF c = new RectF();
  RectF d = new RectF();
  
  public Info(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF1);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramRectF2);
    this.c.set(paramRectF3);
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
    this.jdField_b_of_type_Float = paramFloat2;
    this.d.set(paramRectF4);
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.Info
 * JD-Core Version:    0.7.0.1
 */