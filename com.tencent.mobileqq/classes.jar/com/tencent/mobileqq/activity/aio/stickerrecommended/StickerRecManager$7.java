package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.EntityManager;

class StickerRecManager$7
  implements Runnable
{
  StickerRecManager$7(StickerRecManager paramStickerRecManager, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      StickerRecManager.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    StickerRecManager.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.7
 * JD-Core Version:    0.7.0.1
 */