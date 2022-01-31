package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import pcs;
import pcu;
import pcw;

public class FeedsPreloadManager$3
  implements Runnable
{
  public FeedsPreloadManager$3(pcs parampcs, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (pcw.a(this.a)) {
      bool = false;
    }
    try
    {
      pcs.a(this.this$0);
      pcu.a(this.a, bool);
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