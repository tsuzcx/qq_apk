package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$2
  extends CameraObserver
{
  SmallScreenVideoController$2(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAfterOpenCamera, success[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], preSessionType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if ((this.b.r != null) && (SmallScreenUtils.g()) && ((paramInt == 1) || (paramInt == 3)) && (this.b.u != null))
      {
        this.b.u.a(true, false);
        this.b.u.c(paramLong, this.b.v.isFrontCamera());
      }
    }
    else
    {
      if ((this.b.s != null) && (this.b.s.k() != null))
      {
        if (this.b.s.k().p()) {
          localObject = "0X8004894";
        }
        for (;;)
        {
          break;
          if (this.b.s.k().h == 1) {
            localObject = "0X8004888";
          } else if (this.b.s.k().h == 2) {
            localObject = "0X800488E";
          } else {
            localObject = "";
          }
        }
        ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      if (this.b.r != null) {
        this.b.r.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      }
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((this.b.s != null) && (this.b.s.k().p == 1011))
    {
      this.b.u.a(false, false);
      this.b.u.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.2
 * JD-Core Version:    0.7.0.1
 */