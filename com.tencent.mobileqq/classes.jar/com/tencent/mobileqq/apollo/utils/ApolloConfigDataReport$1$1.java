package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.impl.listener.Download403Callback;
import com.tencent.qphone.base.util.QLog;

class ApolloConfigDataReport$1$1
  implements Download403Callback
{
  ApolloConfigDataReport$1$1(ApolloConfigDataReport.1 param1) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfigDataReport", 2, new Object[] { "checkReportConfigJson errorCode:", Integer.valueOf(paramInt1), ", httpCode:", Integer.valueOf(paramInt2) });
    }
    if ((paramInt1 == 0) && (paramInt2 == 200)) {
      ApolloConfigDataReport.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1.1
 * JD-Core Version:    0.7.0.1
 */