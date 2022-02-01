package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Message;

class HeartBeatController$1
  extends Handler
{
  HeartBeatController$1(HeartBeatController paramHeartBeatController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      HeartBeatController.d(this.a);
      return;
    }
    paramMessage = this.a;
    HeartBeatController.a(paramMessage, HeartBeatController.a(paramMessage), HeartBeatController.b(this.a));
    HeartBeatController.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.HeartBeatController.1
 * JD-Core Version:    0.7.0.1
 */