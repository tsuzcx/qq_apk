package com.tencent.avgame.qav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class AVGameMediaPlayerCtrl$CustomHandler
  extends Handler
{
  public AVGameMediaPlayerCtrl$CustomHandler(AVGameMediaPlayerCtrl paramAVGameMediaPlayerCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 152) {
      if (i == 153) {}
    }
    switch (i)
    {
    default: 
    case 258: 
      AVGameMediaPlayerCtrl.b(this.a);
      return;
    case 256: 
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      AVGameMediaPlayerCtrl.a(this.a, null, i, j, l);
      return;
      AVGameMediaPlayerCtrl.b(this.a);
      return;
      AVGameMediaPlayerCtrl.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaPlayerCtrl.CustomHandler
 * JD-Core Version:    0.7.0.1
 */