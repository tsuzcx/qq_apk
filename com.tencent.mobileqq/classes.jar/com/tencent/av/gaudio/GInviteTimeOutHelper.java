package com.tencent.av.gaudio;

import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class GInviteTimeOutHelper
{
  private static volatile GInviteTimeOutHelper b;
  Timer a = null;
  
  public static GInviteTimeOutHelper a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new GInviteTimeOutHelper();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    QLog.i("GInviteTimeOutHelper", 1, "startTimer");
    Object localObject = this.a;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.a = new Timer(true);
    localObject = new GInviteTimeOutHelper.1(this);
    this.a.schedule((TimerTask)localObject, paramLong1);
  }
  
  public void b()
  {
    QLog.i("GInviteTimeOutHelper", 1, "destroyTimer");
    Timer localTimer = this.a;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GInviteTimeOutHelper
 * JD-Core Version:    0.7.0.1
 */