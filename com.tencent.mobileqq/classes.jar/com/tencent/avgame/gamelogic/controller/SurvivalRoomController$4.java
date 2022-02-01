package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.util.AVGamePerfReporter;

class SurvivalRoomController$4
  implements Runnable
{
  SurvivalRoomController$4(SurvivalRoomController paramSurvivalRoomController, long paramLong) {}
  
  public void run()
  {
    boolean bool = AVGameBusinessCtrl.b().c();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      localAVGamePerfReporter.a(i, GameEngine.a().a().a(), GameEngine.a().a().b(), System.currentTimeMillis() - this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.4
 * JD-Core Version:    0.7.0.1
 */