package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Message;

class HeartBeatController$1
  extends Handler
{
  HeartBeatController$1(HeartBeatController paramHeartBeatController) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      HeartBeatController.a(this.a, HeartBeatController.a(this.a), HeartBeatController.a(this.a));
      HeartBeatController.a(this.a);
      return;
    }
    HeartBeatController.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.HeartBeatController.1
 * JD-Core Version:    0.7.0.1
 */