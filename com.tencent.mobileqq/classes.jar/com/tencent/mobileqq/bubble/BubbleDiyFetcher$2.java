package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class BubbleDiyFetcher$2
  implements Runnable
{
  BubbleDiyFetcher$2(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = this.a.getEntityManagerFactory().createEntityManager().query(BubbleDiyEntity.class, true, null, null, null, null, null, " 20 ");
    if ((localList != null) && (localList.size() > 0))
    {
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localBubbleDiyEntity.uinAndDiyId))
        {
          this.this$0.a.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
          this.this$0.b.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initCacheFromDB, size: ");
        ((StringBuilder)localObject).append(localList.size());
        QLog.i("BubbleDiyFetcher", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.2
 * JD-Core Version:    0.7.0.1
 */