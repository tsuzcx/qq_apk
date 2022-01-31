package com.tencent.biz.pubaccount.util;

import com.tencent.qphone.base.util.QLog;
import sip;

public class SneakyCallback$2
  implements Runnable
{
  public SneakyCallback$2(sip paramsip) {}
  
  public void run()
  {
    try
    {
      sip.a(this.this$0, 2);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SneakyCallback", 1, "[run] ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback.2
 * JD-Core Version:    0.7.0.1
 */