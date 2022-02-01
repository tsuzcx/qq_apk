package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.mobileqq.app.QBaseActivity;

class SurvivalRoomController$3
  implements Runnable
{
  SurvivalRoomController$3(SurvivalRoomController paramSurvivalRoomController, QBaseActivity paramQBaseActivity, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (IGameEngine.I().B())
    {
      SurvivalRoomController.a(this.this$0, this.a, String.valueOf(this.b), this.c);
      return;
    }
    SurvivalRoomController.b(this.this$0, this.a, String.valueOf(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.3
 * JD-Core Version:    0.7.0.1
 */