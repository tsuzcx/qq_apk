package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class c$1
  extends Handler
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    c.a locala = (c.a)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    c.a(locala.Y, locala.Z[0]);
    paramMessage.obj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.c.1
 * JD-Core Version:    0.7.0.1
 */