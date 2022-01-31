package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aexb;
import android.util.Base64;
import aukp;
import bfnu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class StickerRecManager$3
  implements Runnable
{
  public StickerRecManager$3(aexb paramaexb, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, String paramString3) {}
  
  public void run()
  {
    if (aexb.a(this.this$0) != null) {
      try
      {
        aexb.a(this.this$0, this.jdField_a_of_type_Boolean, this.this$0.b(this.jdField_a_of_type_JavaLangString));
        Object localObject1 = (StickerRecommendEntity)aexb.a(this.this$0).a(StickerRecommendEntity.class, "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
        if (localObject1 == null) {
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "entity is null");
          }
        }
        Object localObject2;
        while ((localObject1 != null) && (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime < 86400000L))
        {
          localObject1 = Base64.decode(((StickerRecommendEntity)localObject1).recList, 0);
          localObject2 = (StickerRecommendSortEntity)aexb.a(this.this$0).a(StickerRecommendSortEntity.class, "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
          if (localObject2 != null) {
            ((StickerRecommendSortEntity)localObject2).convertToList();
          }
          aexb.a(this.this$0, (byte[])localObject1, this.jdField_b_of_type_JavaLangString, "cache", this.jdField_b_of_type_Boolean, (StickerRecommendSortEntity)localObject2);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - ((StickerRecommendEntity)localObject1).cachedTime));
          }
        }
        int j;
        aexb localaexb;
        int i;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StickerRecManager", 2, bfnu.a(localException));
          return;
          aexb.a(this.this$0).a(StickerRecommendEntity.class.getSimpleName(), "usrMessage=?", new String[] { this.jdField_b_of_type_JavaLangString });
          j = aexb.a(this.this$0, this.jdField_a_of_type_Int);
          localaexb = this.this$0;
          localObject2 = aexb.a(this.this$0).c();
          if (this.jdField_b_of_type_Boolean) {}
          for (i = 4;; i = 3)
          {
            localaexb.a((String)localObject2, i, j, this.c, this.jdField_b_of_type_JavaLangString);
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