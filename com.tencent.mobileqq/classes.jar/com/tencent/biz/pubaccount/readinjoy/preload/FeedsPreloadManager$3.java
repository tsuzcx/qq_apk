package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import psr;
import pst;
import psv;

public class FeedsPreloadManager$3
  implements Runnable
{
  public FeedsPreloadManager$3(psr parampsr, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (psv.a(this.a)) {
      bool = false;
    }
    try
    {
      psr.a(this.this$0);
      pst.a(this.a, bool);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp exception, e = ", localException);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */