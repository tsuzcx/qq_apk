package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

final class ApolloClientQIPCModule$10
  implements EIPCResultCallback
{
  ApolloClientQIPCModule$10(IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static getApolloDressInfo errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      HashMap localHashMap = (HashMap)paramEIPCResult.data.getSerializable("apolloDressInfo");
      if (this.a != null) {
        this.a.a(localHashMap, str, paramEIPCResult.code);
      }
      ApolloQualityReportUtil.a("apollo_dress_info", String.valueOf(System.currentTimeMillis() - l), str);
      if (!paramEIPCResult.isSuccess()) {
        break label185;
      }
    }
    label185:
    for (int i = 0;; i = paramEIPCResult.code)
    {
      if (paramEIPCResult.isSuccess()) {
        str = "";
      }
      TraceReportUtil.a(132, String.valueOf(l), 2, i, new Object[] { str });
      TraceReportUtil.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(null, str, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.10
 * JD-Core Version:    0.7.0.1
 */