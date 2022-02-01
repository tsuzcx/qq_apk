package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

final class ApolloIPCModule$6
  implements EIPCResultCallback
{
  ApolloIPCModule$6(IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("static getApolloDressInfo errMsg : ");
    ((StringBuilder)localObject).append(str);
    QLog.d("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
    if (paramEIPCResult.isSuccess())
    {
      localObject = (HashMap)paramEIPCResult.data.getSerializable("apolloDressInfo");
      IApolloResManager.ApolloDressInfoListener localApolloDressInfoListener = this.a;
      if (localApolloDressInfoListener != null) {
        localApolloDressInfoListener.a((HashMap)localObject, str, paramEIPCResult.code);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResManager.ApolloDressInfoListener)localObject).a(null, str, paramEIPCResult.code);
      }
    }
    ApolloQualityReportUtil.a("apollo_dress_info", String.valueOf(System.currentTimeMillis() - l), str);
    int i;
    if (ApolloIPCModule.a()) {
      i = 6;
    } else {
      i = 2;
    }
    int j;
    if (paramEIPCResult.isSuccess()) {
      j = 0;
    } else {
      j = paramEIPCResult.code;
    }
    if (paramEIPCResult.isSuccess()) {
      str = "";
    }
    TraceReportUtil.a(132, String.valueOf(l), i, j, new Object[] { str });
    TraceReportUtil.b(132, String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.6
 * JD-Core Version:    0.7.0.1
 */