package com.tencent.biz.pubaccount.util;

import com.tencent.qphone.base.util.QLog;
import sip;

public final class SneakyCallback$4
  implements Runnable
{
  public SneakyCallback$4(int paramInt) {}
  
  public void run()
  {
    try
    {
      sip.a(sip.a(), this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SneakyCallback", 1, "[run] ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback.4
 * JD-Core Version:    0.7.0.1
 */