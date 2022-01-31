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
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.access$500(localAsyncTaskResult.mTask, localAsyncTaskResult.mData[0]);
      return;
    }
    localAsyncTaskResult.mTask.onProgressUpdate(localAsyncTaskResult.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.InternalHandler
 * JD-Core Version:    0.7.0.1
 */