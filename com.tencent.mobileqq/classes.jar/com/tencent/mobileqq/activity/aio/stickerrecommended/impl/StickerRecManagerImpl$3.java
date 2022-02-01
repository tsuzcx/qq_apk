package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.util.Base64;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class StickerRecManagerImpl$3
  implements Runnable
{
  StickerRecManagerImpl$3(StickerRecManagerImpl paramStickerRecManagerImpl, String paramString1, int paramInt, String paramString2, ScenesRecommendItem paramScenesRecommendItem) {}
  
  public void run()
  {
    if (StickerRecManagerImpl.access$000(this.this$0) != null)
    {
      Object localObject1 = (StickerRecommendEntity)StickerRecManagerImpl.access$000(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.a });
      Object localObject2;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "scene entity is null");
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("scene cache Time : ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime);
        QLog.d("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
      }
      int i = StickerRecManagerImpl.access$100(this.this$0, this.b);
      if ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
      {
        localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
        localObject2 = (StickerRecommendSortEntity)StickerRecManagerImpl.access$000(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.a });
        if (localObject2 != null) {
          ((StickerRecommendSortEntity)localObject2).convertToList();
        }
        StickerRecManagerImpl.access$200(this.this$0, (byte[])localObject1, this.a, "cache", false, (StickerRecommendSortEntity)localObject2, 1, i);
        return;
      }
      StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.a });
      StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType=1", new String[] { this.a });
      localObject1 = this.this$0;
      ((StickerRecManagerImpl)localObject1).sendScenesPullPicsRequest(StickerRecManagerImpl.access$300((StickerRecManagerImpl)localObject1).getCurrentUin(), 3, i, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */