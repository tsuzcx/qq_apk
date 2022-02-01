package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import java.util.concurrent.atomic.AtomicInteger;
import ykq;

class VideoCompositeHelper$FFMPEGResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public static final int TYPE_CHANGE_ORIENTATION = 4;
  public static final int TYPE_COMPRESS_VIDEO = 1;
  public static final int TYPE_CONVERT_PIC_TO_VIDEO = 2;
  public static final int TYPE_SET_TIME_STAMP = 3;
  private final AtomicInteger mEncodeRequest;
  private final Object mLock;
  private final int mTaskType;
  
  public VideoCompositeHelper$FFMPEGResponseCallback(Object paramObject, AtomicInteger paramAtomicInteger, int paramInt)
  {
    this.mLock = paramObject;
    this.mEncodeRequest = paramAtomicInteger;
    this.mTaskType = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    ykq.d(VideoCompositeHelper.TAG, "FFMPEGResponseCallback onFailure() mTaskType = " + this.mTaskType + " message = " + paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    ykq.d(VideoCompositeHelper.TAG, "FFMPEGResponseCallback onFinish() mTaskType = " + this.mTaskType + " isSuccess = " + paramBoolean);
    synchronized (this.mLock)
    {
      this.mLock.notify();
      switch (this.mTaskType)
      {
      case 1: 
        ykq.e(VideoCompositeHelper.TAG, "Undefined task type mTaskType = " + this.mTaskType);
        throw new RuntimeException("Undefined task in FFMPEGResponseCallback");
      }
    }
    AtomicInteger localAtomicInteger = this.mEncodeRequest;
    if (paramBoolean)
    {
      label152:
      localAtomicInteger.set(i);
      for (;;)
      {
        label158:
        return;
        localAtomicInteger = this.mEncodeRequest;
        if (!paramBoolean) {
          break;
        }
        i = j;
        label174:
        localAtomicInteger.set(i);
      }
      localAtomicInteger = this.mEncodeRequest;
      if (!paramBoolean) {
        break label248;
      }
    }
    label248:
    for (i = k;; i = 945001)
    {
      localAtomicInteger.set(i);
      break label158;
      localAtomicInteger = this.mEncodeRequest;
      if (paramBoolean) {}
      for (i = m;; i = 944004)
      {
        localAtomicInteger.set(i);
        break;
      }
      break;
      i = 943004;
      break label152;
      i = 942004;
      break label174;
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    ykq.c(VideoCompositeHelper.TAG, "onStart() mTaskType = " + this.mTaskType);
  }
  
  public void onSuccess(String paramString)
  {
    ykq.c(VideoCompositeHelper.TAG, "FFMPEGResponseCallback onSuccess() mTaskType = " + this.mTaskType + " message = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.FFMPEGResponseCallback
 * JD-Core Version:    0.7.0.1
 */