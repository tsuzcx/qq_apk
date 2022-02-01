package com.tencent.av.opengl.gesturedetectors;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class MoveGestureDetector
  extends BaseGestureDetector
{
  private static final PointF h = new PointF();
  private final MoveGestureDetector.OnMoveGestureListener i;
  private PointF j;
  private PointF k;
  private PointF l = new PointF();
  private PointF m = new PointF();
  
  public MoveGestureDetector(Context paramContext, MoveGestureDetector.OnMoveGestureListener paramOnMoveGestureListener)
  {
    super(paramContext);
    this.i = paramOnMoveGestureListener;
  }
  
  private PointF c(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    float f2 = 0.0F;
    int n = 0;
    float f1 = 0.0F;
    while (n < i1)
    {
      f2 += paramMotionEvent.getX(n);
      f1 += paramMotionEvent.getY(n);
      n += 1;
    }
    float f3 = i1;
    return new PointF(f2 / f3, f1 / f3);
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return;
      }
      this.b = this.i.b(this);
      return;
    }
    a();
    this.c = MotionEvent.obtain(paramMotionEvent);
    this.g = 0L;
    b(paramMotionEvent);
  }
  
  protected void b(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        b(paramMotionEvent);
        if ((this.e / this.f <= 0.67F) || (!this.i.a(this)) || (this.c == null)) {
          return;
        }
        this.c.recycle();
        this.c = MotionEvent.obtain(paramMotionEvent);
        return;
      }
    }
    this.i.c(this);
    a();
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    super.b(paramMotionEvent);
    MotionEvent localMotionEvent = this.c;
    if ((paramMotionEvent != null) && (localMotionEvent != null))
    {
      this.j = c(paramMotionEvent);
      this.k = c(localMotionEvent);
      int n;
      if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount()) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0) {
        paramMotionEvent = h;
      } else {
        paramMotionEvent = new PointF(this.j.x - this.k.x, this.j.y - this.k.y);
      }
      this.m = paramMotionEvent;
      paramMotionEvent = this.l;
      paramMotionEvent.x += this.m.x;
      paramMotionEvent = this.l;
      paramMotionEvent.y += this.m.y;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
    }
  }
  
  public float c()
  {
    return this.l.x;
  }
  
  public float d()
  {
    return this.l.y;
  }
  
  public PointF e()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.gesturedetectors.MoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */