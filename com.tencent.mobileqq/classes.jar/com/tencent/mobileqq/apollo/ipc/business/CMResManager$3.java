package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CMResManager$3
  implements IApolloResManager.ApolloDressInfoListener
{
  CMResManager$3(CMResManager paramCMResManager, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener, long paramLong) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("static getApolloDressInfo errMsg : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[cmshow]CEResManager", 1, ((StringBuilder)localObject).toString());
    int i;
    if (paramHashMap != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResManager.ApolloDressInfoListener)localObject).a(paramHashMap, paramString, 0);
      }
    }
    else
    {
      paramHashMap = this.a;
      if (paramHashMap != null) {
        paramHashMap.a(null, paramString, paramInt);
      }
    }
    ApolloQualityReportUtil.a("apollo_dress_info", String.valueOf(System.currentTimeMillis() - this.b), paramString);
    long l = this.b;
    int j;
    if (CMResManager.a()) {
      j = 6;
    } else {
      j = 2;
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
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CMResManager.3
 * JD-Core Version:    0.7.0.1
 */