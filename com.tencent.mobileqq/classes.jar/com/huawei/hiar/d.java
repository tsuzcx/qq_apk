package com.huawei.hiar;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

class d
  extends HandlerThread
  implements Handler.Callback
{
  static final String a = a.class.getSimpleName();
  
  public d(String paramString)
  {
    super(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Log.d(a, "handleMessage: handle message");
    switch (d.1.a[i.a(paramMessage.what).ordinal()])
    {
    default: 
      Log.d(a, "handleMessage: cancle this thread");
      if (Build.VERSION.SDK_INT >= 18) {
        quitSafely();
      }
      break;
    }
    for (;;)
    {
      return false;
      ((a)paramMessage.obj).a();
      continue;
      quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.d
 * JD-Core Version:    0.7.0.1
 */