package com.tencent.mobileqq.bubble;

import almr;
import android.text.TextUtils;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BubbleDiyFetcher$2
  implements Runnable
{
  public BubbleDiyFetcher$2(almr paramalmr, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.a.getEntityManagerFactory().createEntityManager().a(BubbleDiyEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)localIterator.next();
        if (!TextUtils.isEmpty(localBubbleDiyEntity.uinAndDiyId))
        {
          this.this$0.a.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
          this.this$0.b.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "initCacheFromDB, size: " + localList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.2
 * JD-Core Version:    0.7.0.1
 */