package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.persistence.EntityManager;

class StickerRecManagerImpl$5
  implements Runnable
{
  StickerRecManagerImpl$5(StickerRecManagerImpl paramStickerRecManagerImpl, StickerRecommendEntity paramStickerRecommendEntity) {}
  
  public void run()
  {
    StickerRecManagerImpl.access$000(this.this$0).persistOrReplace(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */