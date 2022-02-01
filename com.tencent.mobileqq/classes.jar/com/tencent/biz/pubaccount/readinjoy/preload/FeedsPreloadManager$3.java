package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$3
  implements Runnable
{
  FeedsPreloadManager$3(FeedsPreloadManager paramFeedsPreloadManager, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool;
    if (FeedsPreloadHelper.a(this.a)) {
      bool = false;
    }
    try
    {
      FeedsPreloadManager.a(this.this$0);
      FeedsPreloadDataReport.a(this.a, bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */