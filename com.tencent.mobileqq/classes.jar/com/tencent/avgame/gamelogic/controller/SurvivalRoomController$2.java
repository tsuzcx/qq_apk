package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.ui.AVGameHandler;

class SurvivalRoomController$2
  extends GameActivityLifeCycleListener
{
  SurvivalRoomController$2(SurvivalRoomController paramSurvivalRoomController) {}
  
  public void a()
  {
    super.a();
    if (SurvivalRoomController.a(this.a) != null) {
      AVGameHandler.a().a().removeCallbacks(SurvivalRoomController.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.2
 * JD-Core Version:    0.7.0.1
 */