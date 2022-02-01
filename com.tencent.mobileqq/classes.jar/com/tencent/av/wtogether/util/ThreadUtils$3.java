package com.tencent.av.wtogether.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class ThreadUtils$3
  implements Runnable
{
  ThreadUtils$3(ThreadUtils.1Result param1Result, Callable paramCallable, ThreadUtils.1CaughtException param1CaughtException, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvWtogetherUtilThreadUtils$1Result.a = this.jdField_a_of_type_JavaUtilConcurrentCallable.call();
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherUtilThreadUtils$1CaughtException.a = localException;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ThreadUtils.3
 * JD-Core Version:    0.7.0.1
 */