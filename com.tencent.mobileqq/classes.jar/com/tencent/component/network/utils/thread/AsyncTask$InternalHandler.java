package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AsyncTask$InternalHandler
  extends Handler
{
  public AsyncTask$InternalHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AsyncTask.AsyncTaskResult localAsyncTaskResult = (AsyncTask.AsyncTaskResult)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      localAsyncTaskResult.mTask.onProgressUpdate(localAsyncTaskResult.mData);
      return;
    }
    AsyncTask.access$500(localAsyncTaskResult.mTask, localAsyncTaskResult.mData[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.InternalHandler
 * JD-Core Version:    0.7.0.1
 */