package com.tencent.avgame.ui;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.util.AVGamePerfReporter;

class AVGameActivity$3$1
  implements Runnable
{
  AVGameActivity$3$1(AVGameActivity.3 param3, long paramLong) {}
  
  public void run()
  {
    boolean bool = AVGameBusinessCtrl.b().c();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      localAVGamePerfReporter.a(i, GameEngine.a().a().a(), GameEngine.a().a().b(), System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.3.1
 * JD-Core Version:    0.7.0.1
 */