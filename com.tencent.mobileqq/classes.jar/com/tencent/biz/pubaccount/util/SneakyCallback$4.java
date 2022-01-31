package com.tencent.biz.pubaccount.util;

import com.tencent.qphone.base.util.QLog;
import tah;

public final class SneakyCallback$4
  implements Runnable
{
  public SneakyCallback$4(int paramInt) {}
  
  public void run()
  {
    try
    {
      tah.a(tah.a(), this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SneakyCallback", 1, "[run] ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback.4
 * JD-Core Version:    0.7.0.1
 */