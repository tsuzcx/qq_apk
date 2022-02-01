package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class AsyncTask$b
  extends Handler
{
  public AsyncTask$b(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AsyncTask.a locala = (AsyncTask.a)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      locala.a.onProgressUpdate(locala.b);
      return;
    }
    AsyncTask.c(locala.a, locala.b[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.b
 * JD-Core Version:    0.7.0.1
 */