package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Queue;

class StartAppCheckHandler$2
  extends Handler
{
  StartAppCheckHandler$2(StartAppCheckHandler paramStartAppCheckHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 2) {
      return;
    }
    paramMessage = (StartAppCheckHandler.PendingAPP)paramMessage.obj;
    this.a.e.remove(paramMessage);
    paramMessage.b.startActivity(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.2
 * JD-Core Version:    0.7.0.1
 */