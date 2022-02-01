package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.persistence.EntityManager;

class StickerRecManagerImpl$6
  implements Runnable
{
  StickerRecManagerImpl$6(StickerRecManagerImpl paramStickerRecManagerImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    StickerRecManagerImpl.access$000(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */