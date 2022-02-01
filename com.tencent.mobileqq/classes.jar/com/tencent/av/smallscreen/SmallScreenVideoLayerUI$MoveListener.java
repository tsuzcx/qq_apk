package com.tencent.av.smallscreen;

import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoLayerUI$MoveListener
  implements MoveGestureDetector.OnMoveGestureListener
{
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.e();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.a.ah == 0)
    {
      this.a.ae[0].a(i, j, false);
      return true;
    }
    if ((this.a.ah == 1) && ((SmallScreenVideoLayerUI.e(this.a) == 0) || (SmallScreenVideoLayerUI.f(this.a) == 0))) {
      this.a.e(i, j);
    }
    return true;
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMoveBegin");
    }
    if (this.a.ah == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.e();
      int i = (int)paramMoveGestureDetector.x;
      int j = (int)paramMoveGestureDetector.y;
      this.a.ae[0].a(i, j, false);
      return true;
    }
    if ((this.a.ah == 1) && ((SmallScreenVideoLayerUI.c(this.a) == 0) || (SmallScreenVideoLayerUI.d(this.a) == 0)))
    {
      this.b = ((int)paramMoveGestureDetector.c());
      this.c = ((int)paramMoveGestureDetector.d());
      this.f = this.a.ad();
    }
    return true;
  }
  
  public void c(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onMoveEnd");
    }
    PointF localPointF = paramMoveGestureDetector.e();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.a.ah == 0)
    {
      this.a.ae[0].a(i, j, true);
      return;
    }
    if ((this.a.ah == 1) && ((SmallScreenVideoLayerUI.g(this.a) == 0) || (SmallScreenVideoLayerUI.h(this.a) == 0)))
    {
      this.a.e(i, j);
      this.d = ((int)paramMoveGestureDetector.c());
      this.e = ((int)paramMoveGestureDetector.d());
      paramMoveGestureDetector = this.a;
      SmallScreenVideoLayerUI.a(paramMoveGestureDetector, paramMoveGestureDetector.a(this.f, this.b, this.c, this.d, this.e));
      paramMoveGestureDetector = this.a;
      paramMoveGestureDetector.s(SmallScreenVideoLayerUI.i(paramMoveGestureDetector));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI.MoveListener
 * JD-Core Version:    0.7.0.1
 */