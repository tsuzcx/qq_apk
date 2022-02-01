package com.tencent.av.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseGestureDetector
{
  protected final Context a;
  protected boolean b;
  protected MotionEvent c;
  protected MotionEvent d;
  protected float e;
  protected float f;
  protected long g;
  
  public BaseGestureDetector(Context paramContext)
  {
    this.a = paramContext;
  }
  
  protected void a()
  {
    MotionEvent localMotionEvent = this.c;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.c = null;
    }
    localMotionEvent = this.d;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.d = null;
    }
    this.b = false;
  }
  
  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (!this.b) {
      a(i, paramMotionEvent);
    } else {
      b(i, paramMotionEvent);
    }
    return true;
  }
  
  protected abstract void b(int paramInt, MotionEvent paramMotionEvent);
  
  protected void b(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent1 = this.c;
    if ((paramMotionEvent != null) && (localMotionEvent1 != null))
    {
      MotionEvent localMotionEvent2 = this.d;
      if (localMotionEvent2 != null)
      {
        localMotionEvent2.recycle();
        this.d = null;
      }
      this.d = MotionEvent.obtain(paramMotionEvent);
      this.g = (paramMotionEvent.getEventTime() - localMotionEvent1.getEventTime());
      this.e = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
      this.f = localMotionEvent1.getPressure(localMotionEvent1.getActionIndex());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.gesturedetectors.BaseGestureDetector
 * JD-Core Version:    0.7.0.1
 */