package com.tencent.biz.pubaccount.readinjoy.preload;

import com.tencent.qphone.base.util.QLog;
import qko;
import qkp;
import qkq;
import qku;

public class FeedsPreloadManager$4
  implements Runnable
{
  public FeedsPreloadManager$4(qkq paramqkq, qkp paramqkp, long paramLong) {}
  
  public void run()
  {
    qko localqko = qko.a();
    if (localqko != null)
    {
      if (!qku.b(this.jdField_a_of_type_Qkp.a)) {
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
    localqko.a(this.jdField_a_of_type_Qkp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4
 * JD-Core Version:    0.7.0.1
 */