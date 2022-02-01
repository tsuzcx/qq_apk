package com.tencent.mobileqq.app.asyncdb.cache;

import alan;
import albs;
import alcu;
import anyx;
import bcrp;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentHashMap;

public class RecentUserCache$5
  implements Runnable
{
  public RecentUserCache$5(anyx paramanyx, String paramString, RecentUser paramRecentUser, long paramLong) {}
  
  public void run()
  {
    Object localObject3 = albs.a().a(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "getBaseItemDataFromCache is null!");
      }
      localObject3 = alan.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser, (QQAppInterface)this.this$0.app, ((QQAppInterface)this.this$0.app).getApp());
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        albs.a().a((RecentBaseData)localObject3, this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject3;
      }
      if (!(localObject1 instanceof RecentUserBaseData)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject3 = ParcelHelper.a(localObject1);
          if (localObject3 == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.parceledRecentBaseData = ((byte[])localObject3);
        }
        catch (ParcelHelper.UnsupportedFieldTypeException localUnsupportedFieldTypeException)
        {
          QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because UnsupportedFieldTypeException, class=", localThrowable1.getClass().getName() });
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("Q.db.Cache.RecentUserCache", 1, "saveParcelDataToRecentData fail, 请对应的开发检查是否使用了不该使用的字段", localThrowable2);
          alcu.a(((QQAppInterface)this.this$0.app).getApp(), false, localThrowable2);
          continue;
        }
        anyx.k(this.this$0).put(this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long));
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData success, key=", this.jdField_a_of_type_JavaLangString, " lastRealOPTime=", Long.valueOf(this.jdField_a_of_type_Long) });
        }
        this.this$0.saveRecentUser(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
        return;
        localObject1 = localObject3;
        if (!(localObject3 instanceof RecentUserBaseData)) {
          break;
        }
        ((RecentUserBaseData)localObject3).setRecentUser(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
        try
        {
          ((RecentBaseData)localObject3).update(this.this$0.app, ((QQAppInterface)this.this$0.app).getApp());
          localObject1 = localObject3;
        }
        catch (ConcurrentModificationException localConcurrentModificationException)
        {
          bcrp.a(localConcurrentModificationException, "Multi Recent Handle Report");
          Object localObject2 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          alcu.a(((QQAppInterface)this.this$0.app).getApp(), false, localThrowable1);
          throw new RuntimeException(localThrowable1);
        }
      }
      QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because result is null, class=", localThrowable1.getClass().getName() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.5
 * JD-Core Version:    0.7.0.1
 */