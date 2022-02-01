package com.tencent.biz.game;

import android.os.Handler;
import android.os.Message;

class SensorAPIJavaScript$2
  extends Handler
{
  SensorAPIJavaScript$2(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      this.a.a((String)paramMessage.obj);
    }
    while (paramMessage.what != 291) {
      return;
    }
    this.a.updateMicStatus((String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.2
 * JD-Core Version:    0.7.0.1
 */