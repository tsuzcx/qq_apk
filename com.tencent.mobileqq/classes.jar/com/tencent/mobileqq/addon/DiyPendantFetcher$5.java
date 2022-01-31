package com.tencent.mobileqq.addon;

import akmx;
import android.text.TextUtils;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;

public class DiyPendantFetcher$5
  implements Runnable
{
  public DiyPendantFetcher$5(akmx paramakmx, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.a.getEntityManagerFactory().createEntityManager().a(DiyPendantEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)localIterator.next();
        if (!TextUtils.isEmpty(localDiyPendantEntity.uinAndDiyId)) {
          this.this$0.a.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "initCacheFromDB, size: " + localList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.5
 * JD-Core Version:    0.7.0.1
 */