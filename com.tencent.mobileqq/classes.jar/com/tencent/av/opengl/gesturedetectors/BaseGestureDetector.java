package com.tencent.av.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseGestureDetector
{
  protected float a;
  protected long a;
  protected final Context a;
  protected MotionEvent a;
  protected boolean a;
  protected float b;
  protected MotionEvent b;
  
  public BaseGestureDetector(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_b_of_type_AndroidViewMotionEvent = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);
  
  protected void a(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
      }
      return;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_b_of_type_AndroidViewMotionEvent = null;
    }
    this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_Long = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.jdField_a_of_type_Float = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
    this.jdField_b_of_type_Float = localMotionEvent.getPressure(localMotionEvent.getActionIndex());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (!this.jdField_a_of_type_Boolean) {
      a(i, paramMotionEvent);
    }
    for (;;)
    {
      return true;
      b(i, paramMotionEvent);
    }
  }
  
  protected abstract void b(int paramInt, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.gesturedetectors.BaseGestureDetector
 * JD-Core Version:    0.7.0.1
 */