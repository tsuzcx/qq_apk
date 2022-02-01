package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$1
  implements ReadinjoySPEventReport.ForeBackGroundCallback
{
  FeedsPreloadManager$1(FeedsPreloadManager paramFeedsPreloadManager) {}
  
  public void l()
  {
    if (!FeedsPreloadHelper.b())
    {
      QLog.d("FeedsPreloadManager", 1, "foreground, feeds preload.");
      this.a.a(false);
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "lock screen enter foreground, no need to preload.");
  }
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */