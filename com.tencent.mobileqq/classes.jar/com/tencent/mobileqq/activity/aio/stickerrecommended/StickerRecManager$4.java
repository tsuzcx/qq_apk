package com.tencent.mobileqq.activity.aio.stickerrecommended;

import ahns;
import ahom;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class StickerRecManager$4
  implements Runnable
{
  public StickerRecManager$4(ahns paramahns, String paramString1, int paramInt, String paramString2, ahom paramahom) {}
  
  public void run()
  {
    Object localObject;
    if (ahns.a(this.this$0) != null)
    {
      localObject = (StickerRecommendEntity)ahns.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      if (localObject != null) {
        break label140;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "entity is null");
      }
    }
    while ((localObject != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime < 86400000L))
    {
      localObject = Base64.decode(((StickerRecommendEntity)localObject).recList, 0);
      StickerRecommendSortEntity localStickerRecommendSortEntity = (StickerRecommendSortEntity)ahns.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
      if (localStickerRecommendSortEntity != null) {
        localStickerRecommendSortEntity.convertToList();
      }
      ahns.a(this.this$0, (byte[])localObject, this.jdField_a_of_type_JavaLangString, "cache", false, localStickerRecommendSortEntity, 1);
      return;
      label140:
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject).cachedTime));
      }
    }
    ahns.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[] { this.jdField_a_of_type_JavaLangString });
    int i = ahns.a(this.this$0, this.jdField_a_of_type_Int);
    this.this$0.a(ahns.a(this.this$0).getCurrentUin(), 3, i, this.b, this.jdField_a_of_type_Ahom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4
 * JD-Core Version:    0.7.0.1
 */