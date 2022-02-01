package com.tencent.aelight.camera.aioeditor.capture.control;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class CaptureAsyncAutomator$MyThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  private CaptureAsyncAutomator$MyThreadFactory(CaptureAsyncAutomator paramCaptureAsyncAutomator) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureAsyncAutomator_");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setPriority(4);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncAutomator.MyThreadFactory
 * JD-Core Version:    0.7.0.1
 */