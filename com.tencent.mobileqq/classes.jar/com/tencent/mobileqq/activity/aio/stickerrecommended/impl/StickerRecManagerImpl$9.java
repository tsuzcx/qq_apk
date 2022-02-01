package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConstants;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class StickerRecManagerImpl$9
  implements Runnable
{
  StickerRecManagerImpl$9(StickerRecManagerImpl paramStickerRecManagerImpl) {}
  
  public void run()
  {
    Object localObject = new File(StickerRecConstants.a).listFiles();
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.length > 0)
      {
        int j = localObject.length;
        l1 = 0L;
        int i = 0;
        while (i < j)
        {
          l1 += localObject[i].length();
          i += 1;
        }
      }
    }
    if (l1 < 104857600L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("current cache length:");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", not need delete cache");
        QLog.d("StickerRecManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    l1 = System.currentTimeMillis();
    try
    {
      localObject = new String[1];
      localObject[0] = String.valueOf(l1 - 86400000L);
      Iterator localIterator = StickerRecManagerImpl.access$000(this.this$0).query(StickerRecCacheEntity.class, StickerRecCacheEntity.class.getSimpleName(), false, "lastTime<?", (String[])localObject, "", "", "", "").iterator();
      while (localIterator.hasNext())
      {
        StickerRecCacheEntity localStickerRecCacheEntity = (StickerRecCacheEntity)localIterator.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fileName=");
          localStringBuilder.append(localStickerRecCacheEntity.filePath);
          localStringBuilder.append(" md5=");
          localStringBuilder.append(localStickerRecCacheEntity.md5);
          QLog.d("StickerRecManager", 2, new Object[] { "Overdue cache:", localStringBuilder.toString() });
        }
        if (!TextUtils.isEmpty(localStickerRecCacheEntity.filePath)) {
          new File(localStickerRecCacheEntity.filePath).delete();
        }
      }
      StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecCacheEntity.class.getSimpleName(), "lastTime<?", (String[])localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "clearOverdueStickerCache error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.9
 * JD-Core Version:    0.7.0.1
 */