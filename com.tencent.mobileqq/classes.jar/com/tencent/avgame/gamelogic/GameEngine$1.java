package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.report.AVGamePerfReporter;

class GameEngine$1
  implements Runnable
{
  GameEngine$1(GameEngine paramGameEngine, long paramLong) {}
  
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
    localAVGamePerfReporter.a(i, this.this$0.a().a(), this.this$0.a().b(), System.currentTimeMillis() - this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.1
 * JD-Core Version:    0.7.0.1
 */