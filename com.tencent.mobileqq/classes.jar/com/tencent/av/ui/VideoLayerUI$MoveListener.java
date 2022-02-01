package com.tencent.av.ui;

import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$MoveListener
  implements MoveGestureDetector.OnMoveGestureListener
{
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  
  private VideoLayerUI$MoveListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (this.a.aj.b() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.U, 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.e();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.a.ah == 0)
    {
      this.a.ae[0].a(i, j, false);
      return true;
    }
    if ((this.a.ah == 1) && (this.a.N()))
    {
      if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
        VideoLayerUI.b(this.a, true);
      }
      this.a.e(i, j);
    }
    return true;
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (this.a.ah == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.e();
      int i = (int)paramMoveGestureDetector.x;
      int j = (int)paramMoveGestureDetector.y;
      this.a.ae[0].a(i, j, false);
    }
    else if ((this.a.ah == 1) && (this.a.N()))
    {
      this.b = ((int)paramMoveGestureDetector.c());
      this.c = ((int)paramMoveGestureDetector.d());
      this.f = this.a.ad();
    }
    if (QLog.isColorLevel())
    {
      paramMoveGestureDetector = this.a.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMoveBegin, mTargetIndex[");
      localStringBuilder.append(this.a.ah);
      localStringBuilder.append("], startX[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], startY[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], startPosition[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("], mTopOffset[");
      localStringBuilder.append(this.a.ab);
      localStringBuilder.append("], mBottomOffset[");
      localStringBuilder.append(this.a.ac);
      localStringBuilder.append("], mRecordCtrlBottom[");
      localStringBuilder.append(this.a.J);
      localStringBuilder.append("]");
      QLog.w(paramMoveGestureDetector, 1, localStringBuilder.toString());
      QLog.d(this.a.U, 2, "onMoveBegin");
    }
    this.a.a(Integer.valueOf(6503), Boolean.valueOf(true));
    return true;
  }
  
  public void c(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.U, 2, "onMoveEnd");
    }
    if (this.a.aj.b() == 2) {
      return;
    }
    PointF localPointF = paramMoveGestureDetector.e();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.a.ah == 0)
    {
      this.a.ae[0].a(i, j, true);
    }
    else if ((this.a.ah == 1) && (this.a.N()))
    {
      this.a.e(i, j);
      this.d = ((int)paramMoveGestureDetector.c());
      this.e = ((int)paramMoveGestureDetector.d());
      paramMoveGestureDetector = this.a;
      paramMoveGestureDetector.at = paramMoveGestureDetector.a(this.f, this.b, this.c, this.d, this.e);
      paramMoveGestureDetector = this.a;
      paramMoveGestureDetector.s(paramMoveGestureDetector.at);
    }
    this.a.a(Integer.valueOf(6503), Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.MoveListener
 * JD-Core Version:    0.7.0.1
 */