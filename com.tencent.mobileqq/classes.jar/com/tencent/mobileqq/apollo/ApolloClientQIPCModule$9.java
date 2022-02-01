package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloDressInfo;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ApolloClientQIPCModule$9
  implements EIPCResultCallback
{
  ApolloClientQIPCModule$9(ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static getApolloUserRes errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      ApolloResManagerImpl.ApolloDressInfo localApolloDressInfo = (ApolloResManagerImpl.ApolloDressInfo)paramEIPCResult.data.getParcelable("apolloUserDressInfo");
      if (this.a != null) {
        this.a.a(localApolloDressInfo, str, paramEIPCResult.code);
      }
      ApolloQualityReportUtil.a("apollo_user_res", String.valueOf(System.currentTimeMillis() - l), str);
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
      TraceReportUtil.a(132, String.valueOf(l), 1, i, new Object[] { str });
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
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.9
 * JD-Core Version:    0.7.0.1
 */