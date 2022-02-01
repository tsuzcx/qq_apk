package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import qag;
import qai;
import qak;

public class FeedsPreloadManager$3
  implements Runnable
{
  public FeedsPreloadManager$3(qag paramqag, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (qak.a(this.a)) {
      bool = false;
    }
    try
    {
      qag.a(this.this$0);
      qai.a(this.a, bool);
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