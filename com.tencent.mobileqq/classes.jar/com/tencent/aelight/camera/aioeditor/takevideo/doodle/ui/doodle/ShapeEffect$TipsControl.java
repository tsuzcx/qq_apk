package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;

class ShapeEffect$TipsControl
  extends ShapeEffect.ControlPoint
{
  private Context c;
  private float d;
  private float e;
  
  private ShapeEffect$TipsControl(ShapeEffect paramShapeEffect, Context paramContext)
  {
    super(paramShapeEffect);
    this.c = paramContext;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      boolean bool2 = false;
      if (i != 1) {
        return false;
      }
      long l = paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime();
      boolean bool1;
      if (l <= ShapeEffect.f()) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      float f1 = paramMotionEvent.getX() - this.d;
      float f2 = paramMotionEvent.getY() - this.e;
      if (Math.sqrt(f1 * f1 + f2 * f2) <= ShapeEffect.g()) {
        bool2 = true;
      }
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleTouchEvent--UP--elapse=");
      paramMotionEvent.append(l);
      paramMotionEvent.append(", inTapTime=");
      paramMotionEvent.append(bool1);
      paramMotionEvent.append(", inTapDis=");
      paramMotionEvent.append(bool2);
      AEQLog.a("TipsControl", paramMotionEvent.toString());
      if ((bool1) && (bool2)) {
        ShapeEffect.h(this.b);
      }
      return true;
    }
    this.d = paramMotionEvent.getX();
    this.e = paramMotionEvent.getY();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.TipsControl
 * JD-Core Version:    0.7.0.1
 */