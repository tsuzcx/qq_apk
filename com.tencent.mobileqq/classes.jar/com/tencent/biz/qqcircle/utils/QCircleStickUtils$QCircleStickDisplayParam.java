package com.tencent.biz.qqcircle.utils;

import android.graphics.Point;
import android.graphics.Rect;

public class QCircleStickUtils$QCircleStickDisplayParam
{
  private Point a = new Point();
  private Rect b = new Rect();
  private Rect c = new Rect();
  private int d = 0;
  private boolean e = false;
  
  public static QCircleStickDisplayParam a()
  {
    return new QCircleStickDisplayParam();
  }
  
  public QCircleStickDisplayParam a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public QCircleStickDisplayParam a(Point paramPoint)
  {
    this.a = paramPoint;
    return this;
  }
  
  public QCircleStickDisplayParam a(Rect paramRect)
  {
    this.b = paramRect;
    return this;
  }
  
  public QCircleStickDisplayParam a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public Point b()
  {
    return this.a;
  }
  
  public QCircleStickDisplayParam b(Rect paramRect)
  {
    this.c = paramRect;
    return this;
  }
  
  public Rect c()
  {
    return this.b;
  }
  
  public Rect d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleStickUtils.QCircleStickDisplayParam
 * JD-Core Version:    0.7.0.1
 */