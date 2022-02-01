package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import java.util.concurrent.atomic.AtomicInteger;

class VideoCompositeHelper$FFMPEGResponseCallback
  implements FFmpegExecuteResponseCallback
{
  private final int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public VideoCompositeHelper$FFMPEGResponseCallback(Object paramObject, AtomicInteger paramAtomicInteger, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    SLog.d(VideoCompositeHelper.a, "FFMPEGResponseCallback onFailure() mTaskType = " + this.jdField_a_of_type_Int + " message = " + paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    SLog.d(VideoCompositeHelper.a, "FFMPEGResponseCallback onFinish() mTaskType = " + this.jdField_a_of_type_Int + " isSuccess = " + paramBoolean);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
        SLog.e(VideoCompositeHelper.a, "Undefined task type mTaskType = " + this.jdField_a_of_type_Int);
        throw new RuntimeException("Undefined task in FFMPEGResponseCallback");
      }
    }
    AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
    if (paramBoolean)
    {
      label152:
      localAtomicInteger.set(i);
      for (;;)
      {
        label158:
        return;
        localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
        if (!paramBoolean) {
          break;
        }
        i = j;
        label174:
        localAtomicInteger.set(i);
      }
      localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!paramBoolean) {
        break label248;
      }
    }
    label248:
    for (i = k;; i = 945001)
    {
      localAtomicInteger.set(i);
      break label158;
      localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
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
    SLog.c(VideoCompositeHelper.a, "onStart() mTaskType = " + this.jdField_a_of_type_Int);
  }
  
  public void onSuccess(String paramString)
  {
    SLog.c(VideoCompositeHelper.a, "FFMPEGResponseCallback onSuccess() mTaskType = " + this.jdField_a_of_type_Int + " message = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.FFMPEGResponseCallback
 * JD-Core Version:    0.7.0.1
 */