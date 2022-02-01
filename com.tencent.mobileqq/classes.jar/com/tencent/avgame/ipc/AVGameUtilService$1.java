package com.tencent.avgame.ipc;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;

final class AVGameUtilService$1
  implements Runnable
{
  AVGameUtilService$1(Context paramContext, Intent paramIntent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameUtilService", 2, "restartProcessForPk start Activity");
    }
    RouteUtils.a(this.a, this.b, "/business/avgame/avgameactivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameUtilService.1
 * JD-Core Version:    0.7.0.1
 */