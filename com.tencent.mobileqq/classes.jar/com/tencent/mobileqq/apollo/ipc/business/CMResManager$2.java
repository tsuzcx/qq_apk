package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.qphone.base.util.QLog;

class CMResManager$2
  implements IApolloResManager.ApolloRoleInfoListener
{
  CMResManager$2(CMResManager paramCMResManager, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener, long paramLong) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    int i;
    if (paramString1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("static getApolloRoleInfo errMsg : ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("[cmshow]CEResManager", 1, ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      localObject = this.a;
      if (localObject != null) {
        ((IApolloResManager.ApolloRoleInfoListener)localObject).a(paramString1, paramString2, 0);
      }
    }
    else
    {
      paramString1 = this.a;
      if (paramString1 != null) {
        paramString1.a(null, paramString2, paramInt);
      }
    }
    ApolloQualityReportUtil.a("apollo_role_info", String.valueOf(System.currentTimeMillis() - this.b), paramString2);
    long l = this.b;
    int j;
    if (CMResManager.a()) {
      j = 7;
    } else {
      j = 3;
    }
    if (i != 0) {
      paramInt = 0;
    }
    if (i != 0) {
      paramString2 = "";
    }
    TraceReportUtil.a(132, String.valueOf(l), j, paramInt, new Object[] { paramString2 });
    TraceReportUtil.b(132, String.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CMResManager.2
 * JD-Core Version:    0.7.0.1
 */