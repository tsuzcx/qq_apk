package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ApolloClientQIPCModule$12
  implements EIPCResultCallback
{
  ApolloClientQIPCModule$12(IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static checkDownloadFaceData errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      if (this.a != null) {
        this.a.a(true, paramEIPCResult.code);
      }
      ApolloQualityReportUtil.a("apollo_face_data", String.valueOf(System.currentTimeMillis() - l), str);
      if (!paramEIPCResult.isSuccess()) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = paramEIPCResult.code)
    {
      if (paramEIPCResult.isSuccess()) {
        str = "";
      }
      TraceReportUtil.a(132, String.valueOf(l), 4, i, new Object[] { str });
      TraceReportUtil.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(false, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.12
 * JD-Core Version:    0.7.0.1
 */