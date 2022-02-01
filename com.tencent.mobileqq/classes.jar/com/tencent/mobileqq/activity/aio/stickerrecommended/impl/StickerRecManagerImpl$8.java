package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class StickerRecManagerImpl$8
  implements Runnable
{
  StickerRecManagerImpl$8(StickerRecManagerImpl paramStickerRecManagerImpl, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      StickerRecCacheEntity localStickerRecCacheEntity = (StickerRecCacheEntity)localIterator.next();
      Object localObject = (StickerRecCacheEntity)StickerRecManagerImpl.access$000(this.this$0).find(StickerRecCacheEntity.class, "md5=?", new String[] { localStickerRecCacheEntity.md5 });
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("old exist: fileName=");
          localStringBuilder.append(((StickerRecCacheEntity)localObject).md5);
          localStringBuilder.append(" lastTime=");
          localStringBuilder.append(((StickerRecCacheEntity)localObject).lastTime);
          QLog.d("StickerRecManager", 2, localStringBuilder.toString());
        }
        ((StickerRecCacheEntity)localObject).lastTime = localStickerRecCacheEntity.lastTime;
        StickerRecManagerImpl.access$000(this.this$0).update((Entity)localObject);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("old not exist: fileName=");
          ((StringBuilder)localObject).append(localStickerRecCacheEntity.md5);
          ((StringBuilder)localObject).append(" lastTime=");
          ((StringBuilder)localObject).append(localStickerRecCacheEntity.lastTime);
          QLog.d("StickerRecManager", 2, ((StringBuilder)localObject).toString());
        }
        StickerRecManagerImpl.access$000(this.this$0).persistOrReplace(localStickerRecCacheEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.8
 * JD-Core Version:    0.7.0.1
 */