package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aijp;
import android.util.Base64;
import bkgg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class StickerRecManager$3
  implements Runnable
{
  public StickerRecManager$3(aijp paramaijp, String paramString1, boolean paramBoolean1, SessionInfo paramSessionInfo, String paramString2, boolean paramBoolean2, int paramInt, String paramString3) {}
  
  public void run()
  {
    if (aijp.a(this.this$0) != null) {
      try
      {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        Object localObject1 = (StickerRecommendEntity)aijp.a(this.this$0).find(StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
        if (localObject1 == null) {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        Object localObject2;
        while ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
        {
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)aijp.a(this.this$0).find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          aijp.a(this.this$0, (byte[])localObject1, this.jdField_b_of_type_JavaLangString, "cache", this.jdField_b_of_type_Boolean, (StickerRecommendSortEntity)localObject2, 0);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime));
          }
        }
        int j;
        ArrayList localArrayList;
        String str;
        int i;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StickerRecManager", 2, bkgg.a(localException));
          return;
          aijp.a(this.this$0).delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[] { this.jdField_b_of_type_JavaLangString });
          j = aijp.a(this.this$0, this.jdField_a_of_type_Int);
          localArrayList = new ArrayList();
          localArrayList.add(this.jdField_b_of_type_JavaLangString);
          localObject2 = this.this$0;
          str = aijp.a(this.this$0).c();
          if (this.jdField_b_of_type_Boolean) {}
          for (i = 4;; i = 3)
          {
            ((aijp)localObject2).a(str, i, j, this.c, localArrayList);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3
 * JD-Core Version:    0.7.0.1
 */