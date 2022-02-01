package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.report.AVGamePerfReporter;

class SurvivalRoomController$4
  implements Runnable
{
  SurvivalRoomController$4(SurvivalRoomController paramSurvivalRoomController, long paramLong) {}
  
  public void run()
  {
    boolean bool = IAVGameBusinessCtrl.a().c();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    localAVGamePerfReporter.a(i, IGameEngine.a().a().a(), IGameEngine.a().a().b(), System.currentTimeMillis() - this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.4
 * JD-Core Version:    0.7.0.1
 */