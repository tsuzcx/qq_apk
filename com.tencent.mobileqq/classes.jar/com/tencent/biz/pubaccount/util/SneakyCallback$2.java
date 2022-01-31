package com.tencent.biz.pubaccount.util;

import com.tencent.qphone.base.util.QLog;
import tah;

public class SneakyCallback$2
  implements Runnable
{
  public SneakyCallback$2(tah paramtah) {}
  
  public void run()
  {
    try
    {
      tah.a(this.this$0, 2);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SneakyCallback", 1, "[run] ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback.2
 * JD-Core Version:    0.7.0.1
 */