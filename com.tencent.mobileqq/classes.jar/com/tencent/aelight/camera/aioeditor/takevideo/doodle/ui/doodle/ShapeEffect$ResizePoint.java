package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.RectF;
import android.view.MotionEvent;

class ShapeEffect$ResizePoint
  extends ShapeEffect.ControlPoint
{
  private ShapeEffect$ResizePoint(ShapeEffect paramShapeEffect)
  {
    super(paramShapeEffect);
  }
  
  protected void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    this.b.b(paramFloat1, paramFloat2);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1)
      {
        ShapeEffect.a(this.b, false);
        ShapeEffect.d(this.b);
        ShapeEffect localShapeEffect = this.b;
        ShapeEffect.a(localShapeEffect, ShapeEffect.e(localShapeEffect).left);
        localShapeEffect = this.b;
        ShapeEffect.b(localShapeEffect, ShapeEffect.e(localShapeEffect).top);
        localShapeEffect = this.b;
        ShapeEffect.c(localShapeEffect, ShapeEffect.e(localShapeEffect).right);
        localShapeEffect = this.b;
        ShapeEffect.d(localShapeEffect, ShapeEffect.e(localShapeEffect).bottom);
      }
    }
    else
    {
      ShapeEffect.a(this.b, true);
      ShapeEffect.c(this.b);
    }
    return super.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.ResizePoint
 * JD-Core Version:    0.7.0.1
 */