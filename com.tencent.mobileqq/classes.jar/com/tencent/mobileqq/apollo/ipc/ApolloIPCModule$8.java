package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ApolloIPCModule$8
  implements EIPCResultCallback
{
  ApolloIPCModule$8(IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("static checkDownloadFaceData errMsg : ");
    ((StringBuilder)localObject).append(str);
    QLog.d("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
    if (paramEIPCResult.isSuccess())
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResDownloader.OnFaceDataDownloadListener)localObject).a(true, paramEIPCResult.code);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResDownloader.OnFaceDataDownloadListener)localObject).a(false, paramEIPCResult.code);
      }
    }
    ApolloQualityReportUtil.a("apollo_face_data", String.valueOf(System.currentTimeMillis() - l), str);
    int i;
    if (ApolloIPCModule.a()) {
      i = 8;
    } else {
      i = 4;
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
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.8
 * JD-Core Version:    0.7.0.1
 */