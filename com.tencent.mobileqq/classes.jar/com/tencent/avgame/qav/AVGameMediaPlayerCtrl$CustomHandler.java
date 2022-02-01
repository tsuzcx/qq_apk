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
    switch (paramMessage.what)
    {
    case 257: 
    default: 
      return;
    case 152: 
      AVGameMediaPlayerCtrl.a(this.a);
      return;
    case 153: 
      AVGameMediaPlayerCtrl.b(this.a);
      return;
    case 256: 
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      AVGameMediaPlayerCtrl.a(this.a, null, i, j, l);
      return;
    }
    AVGameMediaPlayerCtrl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaPlayerCtrl.CustomHandler
 * JD-Core Version:    0.7.0.1
 */