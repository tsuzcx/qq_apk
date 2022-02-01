package com.tencent.component.network.utils.thread;

import android.os.Looper;

final class AsyncTask$HandlerHolder
{
  static final AsyncTask.InternalHandler Handler;
  
  static
  {
    Looper localLooper;
    if (Looper.getMainLooper() != null) {
      localLooper = Looper.getMainLooper();
    } else {
      localLooper = Looper.myLooper();
    }
    Handler = new AsyncTask.InternalHandler(localLooper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.HandlerHolder
 * JD-Core Version:    0.7.0.1
 */