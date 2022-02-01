package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.util.Base64;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.util.ArrayList;
import java.util.List;

class StickerRecManagerImpl$2
  implements Runnable
{
  StickerRecManagerImpl$2(StickerRecManagerImpl paramStickerRecManagerImpl, String paramString1, boolean paramBoolean1, BaseSessionInfo paramBaseSessionInfo, String paramString2, int paramInt, boolean paramBoolean2, String paramString3) {}
  
  public void run()
  {
    if (StickerRecManagerImpl.access$000(this.this$0) != null) {}
    for (;;)
    {
      try
      {
        this.this$0.showLocalEmo(this.a, this.b, this.c);
        Object localObject1 = (StickerRecommendEntity)StickerRecManagerImpl.access$000(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.d });
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cache Time : ");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime);
          QLog.d("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
        }
        int j = StickerRecManagerImpl.access$100(this.this$0, this.e);
        if ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
        {
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)StickerRecManagerImpl.access$000(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.d });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          StickerRecManagerImpl.access$200(this.this$0, (byte[])localObject1, this.d, "cache", this.f, (StickerRecommendSortEntity)localObject2, 0, j);
          return;
        }
        StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.d });
        StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.d });
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(this.d);
        Object localObject2 = this.this$0;
        String str = StickerRecManagerImpl.access$300(this.this$0).getCurrentUin();
        if (!this.f) {
          break label368;
        }
        i = 4;
        ((StickerRecManagerImpl)localObject2).sendPullPicsRequest(str, i, j, this.g, (List)localObject1);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(localException));
        }
      }
      return;
      label368:
      int i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */