package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WSPlayerAudioControl$AudioHandler
  extends Handler
{
  private WSPlayerAudioControl a;
  
  WSPlayerAudioControl$AudioHandler(Looper paramLooper, WSPlayerAudioControl paramWSPlayerAudioControl)
  {
    super(paramLooper);
    this.a = paramWSPlayerAudioControl;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      WSPlayerAudioControl.a(this.a);
      return;
    }
    WSPlayerAudioControl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl.AudioHandler
 * JD-Core Version:    0.7.0.1
 */