package com.tencent.avgame.ui;

import android.graphics.RectF;

public class HoleBean
{
  private RectF a;
  private int b;
  
  public HoleBean(RectF paramRectF, int paramInt)
  {
    this.a = new RectF(paramRectF);
    this.b = paramInt;
  }
  
  public int a()
  {
    return (int)Math.min(this.a.width(), this.a.height()) / 2;
  }
  
  public RectF b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.HoleBean
 * JD-Core Version:    0.7.0.1
 */