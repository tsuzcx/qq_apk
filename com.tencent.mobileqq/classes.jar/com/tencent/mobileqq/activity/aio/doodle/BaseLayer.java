package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

public abstract class BaseLayer
{
  protected Context a;
  protected DoodleView b;
  protected Rect c = new Rect();
  
  public BaseLayer(DoodleView paramDoodleView)
  {
    if (paramDoodleView != null)
    {
      this.a = paramDoodleView.getContext();
      this.b = paramDoodleView;
      return;
    }
    throw new IllegalStateException("DoodleView can not be null.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      this.c.set(0, 0, paramInt1, paramInt2);
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    b(paramCanvas);
  }
  
  public boolean a()
  {
    return d();
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    c();
    return b(paramMotionEvent);
  }
  
  public void b()
  {
    e();
  }
  
  protected abstract void b(Canvas paramCanvas);
  
  protected abstract boolean b(MotionEvent paramMotionEvent);
  
  public void c()
  {
    DoodleView localDoodleView = this.b;
    if (localDoodleView != null) {
      localDoodleView.invalidate();
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.BaseLayer
 * JD-Core Version:    0.7.0.1
 */