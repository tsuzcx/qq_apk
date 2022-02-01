package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.Base64;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class StickerRecManager$4
  implements Runnable
{
  StickerRecManager$4(StickerRecManager paramStickerRecManager, String paramString1, int paramInt, String paramString2, ScenesRecommendItem paramScenesRecommendItem) {}
  
  public void run()
  {
    Object localObject;
    if (StickerRecManager.a(this.this$0) != null)
    {
      localObject = (StickerRecommendEntity)StickerRecManager.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      if (localObject != null) {
        break label153;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "entity is null");
      }
    }
    int i;
    for (;;)
    {
      i = StickerRecManager.a(this.this$0, this.jdField_a_of_type_Int);
      if ((localObject == null) || (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime >= 86400000L)) {
        break;
      }
      localObject = Base64.decode(((StickerRecommendEntity)localObject).recList, 0);
      StickerRecommendSortEntity localStickerRecommendSortEntity = (StickerRecommendSortEntity)StickerRecManager.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      if (localStickerRecommendSortEntity != null) {
        localStickerRecommendSortEntity.convertToList();
      }
      StickerRecManager.a(this.this$0, (byte[])localObject, this.jdField_a_of_type_JavaLangString, "cache", false, localStickerRecommendSortEntity, 1, i);
      return;
      label153:
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime));
      }
    }
    StickerRecManager.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
    StickerRecManager.a(this.this$0).delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType=1", new String[] { this.jdField_a_of_type_JavaLangString });
    this.this$0.a(StickerRecManager.a(this.this$0).getCurrentUin(), 3, i, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedScenesrecommendScenesRecommendItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4
 * JD-Core Version:    0.7.0.1
 */