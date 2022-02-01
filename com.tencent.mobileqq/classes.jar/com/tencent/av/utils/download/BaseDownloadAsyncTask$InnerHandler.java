package com.tencent.av.utils.download;

import android.os.Handler;
import android.os.Message;

class BaseDownloadAsyncTask$InnerHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    BaseDownloadAsyncTask.HYAsyncTaskResult localHYAsyncTaskResult = (BaseDownloadAsyncTask.HYAsyncTaskResult)paramMessage.obj;
    if (paramMessage.what != 1) {
      return;
    }
    localHYAsyncTaskResult.a.a(((DownloadParams[])localHYAsyncTaskResult.b)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.download.BaseDownloadAsyncTask.InnerHandler
 * JD-Core Version:    0.7.0.1
 */