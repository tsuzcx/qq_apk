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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      WSPlayerAudioControl.b(this.a);
      return;
    }
    WSPlayerAudioControl.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl.AudioHandler
 * JD-Core Version:    0.7.0.1
 */