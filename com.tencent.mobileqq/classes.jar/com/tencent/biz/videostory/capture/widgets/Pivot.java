package com.tencent.biz.videostory.capture.widgets;

import android.view.View;

public class Pivot
{
  private int a;
  private int b;
  
  public Pivot(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static Pivot a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return new Pivot(0, -1);
        }
        return new Pivot(0, -2);
      }
      return new Pivot(0, -1);
    }
    return new Pivot(0, 0);
  }
  
  public static Pivot b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return new Pivot(1, -1);
        }
        return new Pivot(1, -2);
      }
      return new Pivot(1, 0);
    }
    return new Pivot(1, -1);
  }
  
  public void a(View paramView)
  {
    int i = this.a;
    if (i == 0)
    {
      i = this.b;
      if (i != -2)
      {
        if (i != -1)
        {
          paramView.setPivotX(i);
          return;
        }
        paramView.setPivotX(paramView.getWidth() * 0.5F);
        return;
      }
      paramView.setPivotX(paramView.getWidth());
      return;
    }
    if (i == 1)
    {
      i = this.b;
      if (i != -2)
      {
        if (i != -1)
        {
          paramView.setPivotY(i);
          return;
        }
        paramView.setPivotY(paramView.getHeight() * 0.5F);
        return;
      }
      paramView.setPivotY(paramView.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.Pivot
 * JD-Core Version:    0.7.0.1
 */