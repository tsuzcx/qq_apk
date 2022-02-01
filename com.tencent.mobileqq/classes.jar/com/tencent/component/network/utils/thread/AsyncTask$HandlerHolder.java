package com.tencent.component.network.utils.thread;

import android.os.Looper;

final class AsyncTask$HandlerHolder
{
  static final AsyncTask.InternalHandler Handler;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      Handler = new AsyncTask.InternalHandler(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.HandlerHolder
 * JD-Core Version:    0.7.0.1
 */