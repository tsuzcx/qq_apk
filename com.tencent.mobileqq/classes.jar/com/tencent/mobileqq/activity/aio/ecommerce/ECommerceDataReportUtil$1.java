package com.tencent.mobileqq.activity.aio.ecommerce;

import afcp;
import afcq;
import aoks;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public final class ECommerceDataReportUtil$1
  implements Runnable
{
  public ECommerceDataReportUtil$1(QQAppInterface paramQQAppInterface, WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    try
    {
      afcp localafcp = (afcp)aoks.a().a(592);
      if ((localafcp != null) && (localafcp.a != null) && (!localafcp.a.isEmpty()))
      {
        afcq.a(localafcp.a);
        afcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        afcq.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ECommerceDataReportUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1
 * JD-Core Version:    0.7.0.1
 */