package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.model.ApolloDressInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.qphone.base.util.QLog;

class CMResManager$4
  implements IApolloResManager.ApolloUserDressInfoListener
{
  CMResManager$4(CMResManager paramCMResManager, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener, long paramLong) {}
  
  public void a(ApolloDressInfo paramApolloDressInfo, String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("static getApolloUserRes errMsg : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[cmshow]CEResManager", 1, ((StringBuilder)localObject).toString());
    int i;
    if (paramApolloDressInfo != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResManager.ApolloUserDressInfoListener)localObject).a(paramApolloDressInfo, paramString, 0);
      }
    }
    else
    {
      paramApolloDressInfo = this.a;
      if (paramApolloDressInfo != null) {
        paramApolloDressInfo.a(null, paramString, paramInt);
      }
    }
    ApolloQualityReportUtil.a("apollo_user_res", String.valueOf(System.currentTimeMillis() - this.b), paramString);
    long l = this.b;
    int j;
    if (CMResManager.a()) {
      j = 5;
    } else {
      j = 1;
    }
    if (i != 0) {
      paramInt = 0;
    }
    if (i != 0) {
      paramString = "";
    }
    TraceReportUtil.a(132, String.valueOf(l), j, paramInt, new Object[] { paramString });
    TraceReportUtil.b(132, String.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CMResManager.4
 * JD-Core Version:    0.7.0.1
 */