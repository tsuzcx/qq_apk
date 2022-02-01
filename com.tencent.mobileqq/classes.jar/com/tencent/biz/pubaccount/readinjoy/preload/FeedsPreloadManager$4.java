package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$4
  implements Runnable
{
  FeedsPreloadManager$4(FeedsPreloadManager paramFeedsPreloadManager, FeedsPreloadDataModule.PreloadCache paramPreloadCache, long paramLong) {}
  
  public void run()
  {
    FeedsPreloadDataModule localFeedsPreloadDataModule = FeedsPreloadDataModule.a();
    if (localFeedsPreloadDataModule != null)
    {
      if (!FeedsPreloadHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.a)) {
        QLog.d("FeedsPreloadManager", 1, "is not latest request, do not update preload cache.");
      }
    }
    else {
      return;
    }
    QLog.d("FeedsPreloadManager", 1, new Object[] { "feeds preload recPackageSize = ", Long.valueOf(this.jdField_a_of_type_Long), ", limit = ", Integer.valueOf(20000) });
    if (this.jdField_a_of_type_Long > 20000L)
    {
      QLog.d("FeedsPreloadManager", 1, "preload feeds recPackage is too large, do not update cache.");
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "update preload cache.");
    localFeedsPreloadDataModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */