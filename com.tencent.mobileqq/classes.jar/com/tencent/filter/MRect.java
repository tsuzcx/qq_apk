package com.tencent.filter;

import android.graphics.Rect;

public class MRect
{
  private int h;
  private int w;
  private int x;
  private int y;
  
  public MRect() {}
  
  public MRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.w = paramInt3;
    this.h = paramInt4;
  }
  
  public static MRect toMRect(Rect paramRect)
  {
    return new MRect(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.MRect
 * JD-Core Version:    0.7.0.1
 */