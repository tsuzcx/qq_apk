package com.tencent.mobileqq.app.asyncdb.cache;

import ahmi;
import ahnn;
import ahop;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$5
  implements Runnable
{
  RecentUserCache$5(RecentUserCache paramRecentUserCache, String paramString, RecentUser paramRecentUser, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = ahnn.a().a(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "getBaseItemDataFromCache is null!");
      }
      localObject2 = ahmi.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser, RecentUserCache.e(this.this$0), RecentUserCache.f(this.this$0).getApp());
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ahnn.a().a((RecentBaseData)localObject2, this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
      }
      if (!(localObject1 instanceof RecentUserBaseData)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = ParcelHelper.a(localObject1);
          if (localObject2 == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.parceledRecentBaseData = ((byte[])localObject2);
        }
        catch (ParcelHelper.UnsupportedFieldTypeException localUnsupportedFieldTypeException)
        {
          QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because UnsupportedFieldTypeException, class=", localThrowable1.getClass().getName() });
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("Q.db.Cache.RecentUserCache", 1, "saveParcelDataToRecentData fail, 请对应的开发检查是否使用了不该使用的字段", localThrowable2);
          ahop.a(RecentUserCache.j(this.this$0).getApp(), false, localThrowable2);
          continue;
        }
        RecentUserCache.k(this.this$0).put(this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long));
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData success, key=", this.jdField_a_of_type_JavaLangString, " lastRealOPTime=", Long.valueOf(this.jdField_a_of_type_Long) });
        }
        this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
        return;
        localObject1 = localObject2;
        if (!(localObject2 instanceof RecentUserBaseData)) {
          break;
        }
        ((RecentUserBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
        try
        {
          ((RecentBaseData)localObject2).a(RecentUserCache.g(this.this$0), RecentUserCache.h(this.this$0).getApp());
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable1)
        {
          ahop.a(RecentUserCache.i(this.this$0).getApp(), false, localThrowable1);
          throw new RuntimeException(localThrowable1);
        }
      }
      QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because result is null, class=", localThrowable1.getClass().getName() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.5
 * JD-Core Version:    0.7.0.1
 */