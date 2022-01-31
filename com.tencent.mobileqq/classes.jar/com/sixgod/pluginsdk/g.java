package com.sixgod.pluginsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sixgod.pluginsdk.apkmanager.a;

final class g
  extends Handler
{
  g(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 1000: 
      this.a.a();
      synchronized (this.a.r)
      {
        this.a.r.notifyAll();
        return;
      }
    }
    this.a.e.b();
    synchronized (this.a.q)
    {
      this.a.q.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */