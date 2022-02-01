package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.report.AVGamePerfReporter;

class GameEngine$3
  implements Runnable
{
  GameEngine$3(GameEngine paramGameEngine, long paramLong) {}
  
  public void run()
  {
    boolean bool = IAVGameBusinessCtrl.p().g();
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    localAVGamePerfReporter.a(i, this.this$0.s().i(), this.this$0.s().n(), System.currentTimeMillis() - this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.3
 * JD-Core Version:    0.7.0.1
 */