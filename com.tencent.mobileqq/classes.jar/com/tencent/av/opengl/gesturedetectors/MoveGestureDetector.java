package com.tencent.av.opengl.gesturedetectors;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class MoveGestureDetector
  extends BaseGestureDetector
{
  private static final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private final MoveGestureDetector.OnMoveGestureListener jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector$OnMoveGestureListener;
  private PointF b;
  private PointF c;
  private PointF d = new PointF();
  private PointF e = new PointF();
  
  public MoveGestureDetector(Context paramContext, MoveGestureDetector.OnMoveGestureListener paramOnMoveGestureListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector$OnMoveGestureListener = paramOnMoveGestureListener;
  }
  
  private PointF a(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    float f2 = 0.0F;
    int i = 0;
    float f1 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    float f3 = j;
    return new PointF(f2 / f3, f1 / f3);
  }
  
  public float a()
  {
    return this.d.x;
  }
  
  public PointF a()
  {
    return this.e;
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return;
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector$OnMoveGestureListener.b(this);
      return;
    }
    a();
    this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_Long = 0L;
    a(paramMotionEvent);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
    if ((paramMotionEvent != null) && (localMotionEvent != null))
    {
      this.jdField_b_of_type_AndroidGraphicsPointF = a(paramMotionEvent);
      this.c = a(localMotionEvent);
      int i;
      if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramMotionEvent = jdField_a_of_type_AndroidGraphicsPointF;
      } else {
        paramMotionEvent = new PointF(this.jdField_b_of_type_AndroidGraphicsPointF.x - this.c.x, this.jdField_b_of_type_AndroidGraphicsPointF.y - this.c.y);
      }
      this.e = paramMotionEvent;
      paramMotionEvent = this.d;
      paramMotionEvent.x += this.e.x;
      paramMotionEvent = this.d;
      paramMotionEvent.y += this.e.y;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
    }
  }
  
  public float b()
  {
    return this.d.y;
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
        a(paramMotionEvent);
        if ((this.jdField_a_of_type_Float / this.jdField_b_of_type_Float <= 0.67F) || (!this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector$OnMoveGestureListener.a(this)) || (this.jdField_a_of_type_AndroidViewMotionEvent == null)) {
          return;
        }
        this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector$OnMoveGestureListener.a(this);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.gesturedetectors.MoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */