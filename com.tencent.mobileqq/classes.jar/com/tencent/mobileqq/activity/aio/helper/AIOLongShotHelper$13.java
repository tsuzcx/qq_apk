package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.qphone.base.util.QLog;

class AIOLongShotHelper$13
  implements Runnable
{
  AIOLongShotHelper$13(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void run()
  {
    try
    {
      AIOLongShotHelper.b(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOLongShotHelper", 1, "run: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.13
 * JD-Core Version:    0.7.0.1
 */