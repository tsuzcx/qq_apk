package com.tencent.avgame.gamelogic.controller;

import android.text.TextUtils;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class SurvivalRoomController$5
  implements Runnable
{
  SurvivalRoomController$5(SurvivalRoomController paramSurvivalRoomController, QBaseActivity paramQBaseActivity, int paramInt) {}
  
  public void run()
  {
    String str = ((IAVGameRootContainer)this.a).getRoomId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom run mGameExited:");
    localStringBuilder.append(((IAVGameRootContainer)this.a).getGameExitStatus());
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mRoomId:");
    localStringBuilder.append(str);
    QLog.i("SurvivalRoomController", 1, localStringBuilder.toString());
    if (((IAVGameRootContainer)this.a).getGameExitStatus()) {
      return;
    }
    int i = this.b;
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(str)) && (this.a.getAppRuntime() != null)) {
        ((IAVGameAppInterface)this.a.getAppRuntime()).a().b(1, str);
      }
    }
    else if (i != 5)
    {
      if (i == 6) {
        return;
      }
      if ((IGameEngine.I().D()) && (IGameEngine.I().B())) {
        AVGameExceptionReporter.a().a(8, null, String.valueOf(this.b), null);
      }
      SurvivalRoomController.a(this.this$0, this.a, 2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.5
 * JD-Core Version:    0.7.0.1
 */