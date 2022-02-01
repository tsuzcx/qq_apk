package com.tencent.av.wtogether.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import mzv;
import mzw;

public final class TheadUtils$3
  implements Runnable
{
  public TheadUtils$3(mzw parammzw, Callable paramCallable, mzv parammzv, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Mzw.a = this.jdField_a_of_type_JavaUtilConcurrentCallable.call();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Mzv.a = localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.util.TheadUtils.3
 * JD-Core Version:    0.7.0.1
 */