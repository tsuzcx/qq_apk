package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aijp;
import com.tencent.mobileqq.persistence.EntityManager;

public class StickerRecManager$7
  implements Runnable
{
  public StickerRecManager$7(aijp paramaijp, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      aijp.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    aijp.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.7
 * JD-Core Version:    0.7.0.1
 */