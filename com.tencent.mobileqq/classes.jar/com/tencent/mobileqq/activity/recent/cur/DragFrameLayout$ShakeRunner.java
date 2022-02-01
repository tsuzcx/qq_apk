package com.tencent.mobileqq.activity.recent.cur;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

class DragFrameLayout$ShakeRunner
  implements Runnable
{
  private int a = 9;
  private int b = 20;
  private float c;
  private RectF d;
  private PointF e;
  private PointF f;
  private int g;
  private boolean h;
  
  public DragFrameLayout$ShakeRunner(DragFrameLayout paramDragFrameLayout, PointF paramPointF, RectF paramRectF)
  {
    this.e = new PointF(paramPointF.x, paramPointF.y);
    this.f = new PointF(this.e.x, this.e.y);
    this.d = paramRectF;
    this.c = ((float)Math.sqrt(this.d.width() * this.d.width() + this.d.height() * this.d.height()));
    float f1 = this.c;
    if (f1 <= 0.01D)
    {
      this.g = 0;
      return;
    }
    this.b = ((int)(this.b * f1 / DragFrameLayout.g(paramDragFrameLayout)));
    this.a = ((int)(this.a * this.c / DragFrameLayout.g(paramDragFrameLayout)));
    this.g = (-this.b);
  }
  
  public PointF a()
  {
    return this.f;
  }
  
  public void run()
  {
    if (this.h) {
      return;
    }
    int i = Math.abs(this.g);
    int j = this.a;
    if ((i >= j) && (j != 0))
    {
      this.f.x = (this.e.x + this.g * this.d.width() / this.c);
      this.f.y = (this.e.y + this.g * this.d.height() / this.c);
      i = this.g;
      if (i < 0) {
        this.g = (-i - this.a);
      } else {
        this.g = (-i + this.a);
      }
    }
    else if (DragFrameLayout.h(this.this$0) == this)
    {
      DragFrameLayout.a(this.this$0, null);
      DragFrameLayout.a(this.this$0, -1);
      DragFrameLayout.a(this.this$0, null);
      DragFrameLayout.i(this.this$0).setVisibility(0);
      DragFrameLayout.a(this.this$0, null);
      DragFrameLayout.a(this.this$0, false);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.ShakeRunner
 * JD-Core Version:    0.7.0.1
 */