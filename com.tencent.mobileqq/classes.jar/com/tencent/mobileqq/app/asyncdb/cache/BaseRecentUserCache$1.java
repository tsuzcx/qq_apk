package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentHashMap;

class BaseRecentUserCache$1
  implements Runnable
{
  BaseRecentUserCache$1(BaseRecentUserCache paramBaseRecentUserCache, String paramString, RecentUser paramRecentUser, long paramLong) {}
  
  public void run()
  {
    Object localObject3 = RecentDataListManager.a().a(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    Object localObject2;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "getBaseItemDataFromCache is null!");
      }
      localObject3 = ConversationDataFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser, this.this$0.a, this.this$0.a.getApp());
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        RecentDataListManager.a().a((RecentBaseData)localObject3, this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject1 = localObject3;
      if ((localObject3 instanceof RecentUserBaseData))
      {
        ((RecentUserBaseData)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
        try
        {
          ((RecentBaseData)localObject3).update(this.this$0.a, this.this$0.a.getApp());
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          RecentParcelUtil.a(this.this$0.a.getApp(), false, localThrowable1);
          throw new RuntimeException(localThrowable1);
        }
        catch (ConcurrentModificationException localConcurrentModificationException)
        {
          CaughtExceptionReportProxy.e(localConcurrentModificationException, "Multi Recent Handle Report");
          localObject2 = localObject3;
        }
      }
    }
    if ((localObject2 instanceof RecentUserBaseData)) {}
    try
    {
      try
      {
        localObject3 = ParcelHelper.a(localObject2);
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.parceledRecentBaseData = ((byte[])localObject3);
        } else {
          QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because result is null, class=", localObject2.getClass().getName() });
        }
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("Q.db.Cache.RecentUserCache", 1, "saveParcelDataToRecentData fail, 请对应的开发检查是否使用了不该使用的字段", localThrowable2);
        RecentParcelUtil.a(this.this$0.a.getApp(), false, localThrowable2);
      }
    }
    catch (ParcelHelper.UnsupportedFieldTypeException localUnsupportedFieldTypeException)
    {
      label239:
      break label239;
    }
    QLog.d("Q.db.Cache.RecentUserCache", 1, new Object[] { "saveRecentUserData, ignore data because UnsupportedFieldTypeException, class=", localThrowable2.getClass().getName() });
    BaseRecentUserCache.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData success, key=", this.jdField_a_of_type_JavaLangString, " lastRealOPTime=", Long.valueOf(this.jdField_a_of_type_Long) });
    }
    this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache.1
 * JD-Core Version:    0.7.0.1
 */