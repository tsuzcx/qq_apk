package com.tencent.avgame.ui;

import android.graphics.RectF;

public class HoleBean
{
  private int jdField_a_of_type_Int;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  public HoleBean(RectF paramRectF, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramRectF);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return (int)Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.HoleBean
 * JD-Core Version:    0.7.0.1
 */