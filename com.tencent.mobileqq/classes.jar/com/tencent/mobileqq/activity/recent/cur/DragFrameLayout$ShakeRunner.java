package com.tencent.mobileqq.activity.recent.cur;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

class DragFrameLayout$ShakeRunner
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 9;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 20;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  private int c;
  
  public DragFrameLayout$ShakeRunner(DragFrameLayout paramDragFrameLayout, PointF paramPointF, RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    this.jdField_a_of_type_Float = ((float)Math.sqrt(this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.jdField_a_of_type_AndroidGraphicsRectF.width() + this.jdField_a_of_type_AndroidGraphicsRectF.height() * this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    if (this.jdField_a_of_type_Float <= 0.01D)
    {
      this.c = 0;
      return;
    }
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.c = (-this.jdField_b_of_type_Int);
  }
  
  public PointF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPointF;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((Math.abs(this.c) < this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int == 0)) {
      if (DragFrameLayout.a(this.this$0) == this)
      {
        DragFrameLayout.a(this.this$0, null);
        DragFrameLayout.a(this.this$0, -1);
        DragFrameLayout.a(this.this$0, null);
        DragFrameLayout.a(this.this$0).setVisibility(0);
        DragFrameLayout.a(this.this$0, null);
        DragFrameLayout.a(this.this$0, false);
      }
    }
    for (;;)
    {
      this.this$0.invalidate();
      return;
      this.jdField_b_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x + this.c * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPointF.y = (this.jdField_a_of_type_AndroidGraphicsPointF.y + this.c * this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_Float);
      if (this.c < 0) {
        this.c = (-this.c - this.jdField_a_of_type_Int);
      } else {
        this.c = (-this.c + this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.ShakeRunner
 * JD-Core Version:    0.7.0.1
 */