package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;

class CMResManager$1
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  CMResManager$1(CMResManager paramCMResManager, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener, long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      paramInt = 0;
    }
    IApolloResDownloader.OnFaceDataDownloadListener localOnFaceDataDownloadListener = this.a;
    if (localOnFaceDataDownloadListener != null) {
      localOnFaceDataDownloadListener.a(paramBoolean, paramInt);
    }
    ApolloQualityReportUtil.a("apollo_face_data", String.valueOf(System.currentTimeMillis() - this.b), "success");
    long l = this.b;
    int i;
    if (CMResManager.a()) {
      i = 8;
    } else {
      i = 4;
    }
    TraceReportUtil.a(132, String.valueOf(l), i, paramInt, new Object[] { "success" });
    TraceReportUtil.b(132, String.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CMResManager.1
 * JD-Core Version:    0.7.0.1
 */