package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aexd;
import android.util.Base64;
import aukn;
import bfnd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class StickerRecManager$3
  implements Runnable
{
  public StickerRecManager$3(aexd paramaexd, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, String paramString3) {}
  
  public void run()
  {
    if (aexd.a(this.this$0) != null) {
      try
      {
        aexd.a(this.this$0, this.jdField_a_of_type_Boolean, this.this$0.b(this.jdField_a_of_type_JavaLangString));
        Object localObject1 = (StickerRecommendEntity)aexd.a(this.this$0).a(StickerRecommendEntity.class, "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
        if (localObject1 == null) {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        Object localObject2;
        while ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
        {
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)aexd.a(this.this$0).a(StickerRecommendSortEntity.class, "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          aexd.a(this.this$0, (byte[])localObject1, this.jdField_b_of_type_JavaLangString, "cache", this.jdField_b_of_type_Boolean, (StickerRecommendSortEntity)localObject2);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime));
          }
        }
        int j;
        aexd localaexd;
        int i;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StickerRecManager", 2, bfnd.a(localException));
          return;
          aexd.a(this.this$0).a(StickerRecommendEntity.class.getSimpleName(), "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
          j = aexd.a(this.this$0, this.jdField_a_of_type_Int);
          localaexd = this.this$0;
          localObject2 = aexd.a(this.this$0).c();
          if (this.jdField_b_of_type_Boolean) {}
          for (i = 4;; i = 3)
          {
            localaexd.a((String)localObject2, i, j, this.c, this.jdField_b_of_type_JavaLangString);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3
 * JD-Core Version:    0.7.0.1
 */