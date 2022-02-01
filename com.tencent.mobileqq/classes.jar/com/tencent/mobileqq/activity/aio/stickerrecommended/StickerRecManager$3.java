package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.Base64;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.util.ArrayList;

class StickerRecManager$3
  implements Runnable
{
  StickerRecManager$3(StickerRecManager paramStickerRecManager, String paramString1, boolean paramBoolean1, SessionInfo paramSessionInfo, String paramString2, int paramInt, boolean paramBoolean2, String paramString3) {}
  
  public void run()
  {
    if (StickerRecManager.a(this.this$0) != null) {
      try
      {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        Object localObject1 = (StickerRecommendEntity)StickerRecManager.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
        if (localObject1 == null) {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        int j;
        Object localObject2;
        for (;;)
        {
          j = StickerRecManager.a(this.this$0, this.jdField_a_of_type_Int);
          if ((localObject1 == null) || (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime >= 86400000L)) {
            break;
          }
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)StickerRecManager.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          StickerRecManager.a(this.this$0, (byte[])localObject1, this.jdField_b_of_type_JavaLangString, "cache", this.jdField_b_of_type_Boolean, (StickerRecommendSortEntity)localObject2, 0, j);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime));
          }
        }
        ArrayList localArrayList;
        String str;
        int i;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(localException));
          return;
          StickerRecManager.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
          StickerRecManager.a(this.this$0).delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
          localArrayList = new ArrayList();
          localArrayList.add(this.jdField_b_of_type_JavaLangString);
          localObject2 = this.this$0;
          str = StickerRecManager.a(this.this$0).getCurrentUin();
          if (this.jdField_b_of_type_Boolean) {}
          for (i = 4;; i = 3)
          {
            ((StickerRecManager)localObject2).a(str, i, j, this.c, localArrayList);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3
 * JD-Core Version:    0.7.0.1
 */