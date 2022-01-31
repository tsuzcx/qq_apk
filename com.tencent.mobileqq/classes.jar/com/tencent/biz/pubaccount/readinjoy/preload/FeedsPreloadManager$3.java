package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import pcv;
import pcx;
import pcz;

public class FeedsPreloadManager$3
  implements Runnable
{
  public FeedsPreloadManager$3(pcv parampcv, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (pcz.a(this.a)) {
      bool = false;
    }
    try
    {
      pcv.a(this.this$0);
      pcx.a(this.a, bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */