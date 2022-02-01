package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.mobileqq.apollo.listener.Download403Callback;
import com.tencent.qphone.base.util.QLog;

class ApolloConfigDataReport$1$1
  implements Download403Callback
{
  ApolloConfigDataReport$1$1(ApolloConfigDataReport.1 param1) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloConfigDataReport", 2, new Object[] { "checkReportConfigJson errorCode:", Integer.valueOf(paramInt1), ", httpCode:", Integer.valueOf(paramInt2) });
    }
    if ((paramInt1 == 0) && (paramInt2 == 200)) {
      ApolloConfigDataReport.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport.1.1
 * JD-Core Version:    0.7.0.1
 */