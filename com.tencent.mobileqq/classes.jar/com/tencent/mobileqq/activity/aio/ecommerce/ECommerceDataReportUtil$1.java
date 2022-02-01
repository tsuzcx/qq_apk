package com.tencent.mobileqq.activity.aio.ecommerce;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

final class ECommerceDataReportUtil$1
  implements Runnable
{
  ECommerceDataReportUtil$1(QQAppInterface paramQQAppInterface, WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    try
    {
      ECommerceDataReportConfigProcessor.Config localConfig = (ECommerceDataReportConfigProcessor.Config)QConfigManager.b().b(592);
      if ((localConfig != null) && (localConfig.a != null) && (!localConfig.a.isEmpty()))
      {
        ECommerceDataReportUtil.a(localConfig.a);
        ECommerceDataReportUtil.a(this.a.getCurrentAccountUin());
        ECommerceDataReportUtil.a((QQAppInterface)this.b.get(), this.c, this.d, this.e);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ECommerceDataReportUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1
 * JD-Core Version:    0.7.0.1
 */