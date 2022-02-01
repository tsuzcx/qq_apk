package com.tencent.av.wtogether.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class TheadUtils$3
  implements Runnable
{
  TheadUtils$3(TheadUtils.1Result param1Result, Callable paramCallable, TheadUtils.1CaughtException param1CaughtException, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvWtogetherUtilTheadUtils$1Result.a = this.jdField_a_of_type_JavaUtilConcurrentCallable.call();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherUtilTheadUtils$1CaughtException.a = localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.TheadUtils.3
 * JD-Core Version:    0.7.0.1
 */