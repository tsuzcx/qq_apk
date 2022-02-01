package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class TraceReportInterceptor
{
  public static void a(int paramInt, String paramString)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putString("featureKey", paramString);
    localBundle.putLong("endTime", SystemClock.uptimeMillis());
    if (ProcessUtil.a())
    {
      TraceReportInstance.a().b(paramInt, paramString, localBundle);
      return;
    }
    a("action_end_trace", localBundle);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, Object... paramVarArgs)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    paramVarArgs = new Bundle();
    paramVarArgs.putInt("featureId", paramInt1);
    paramVarArgs.putString("featureKey", paramString);
    paramVarArgs.putInt("spanId", paramInt2);
    paramVarArgs.putInt("errCode", paramInt3);
    long l;
    if (paramLong1 > 0L) {
      l = paramLong1;
    } else {
      l = System.currentTimeMillis();
    }
    paramVarArgs.putLong("timestamp", l);
    if ((paramInt3 == 0) || (paramInt3 == -100))
    {
      l = paramLong1;
      if (paramLong1 > 0L) {}
    }
    else
    {
      l = SystemClock.uptimeMillis();
    }
    paramVarArgs.putLong("serverTime", NetConnInfoCenter.getServerTimeMillis());
    paramVarArgs.putLong("startTime", l);
    paramVarArgs.putLong("endTime", l);
    paramVarArgs.putString("msg", localStringBuilder.toString());
    paramVarArgs.putInt("extKey", paramInt4);
    paramVarArgs.putLong("extValue", paramLong2);
    if (ProcessUtil.a())
    {
      TraceReportInstance.a().c(paramInt1, paramString, paramVarArgs);
      return;
    }
    a("action_report_span", paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putString("featureKey", paramString2);
    localBundle.putString("tuid", paramString1);
    localBundle.putLong("timestamp", System.currentTimeMillis());
    localBundle.putLong("serverTime", NetConnInfoCenter.getServerTimeMillis());
    localBundle.putLong("startTime", SystemClock.uptimeMillis());
    localBundle.putLong("endTime", SystemClock.uptimeMillis());
    if (ProcessUtil.a())
    {
      TraceReportInstance.a().a(paramInt, paramString2, localBundle);
      return;
    }
    a("action_begin_trace", localBundle);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, int... paramVarArgs)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    int j = 0;
    int m = 0;
    int k = 0;
    int i = 0;
    while ((j < paramVarArgs.length) && (j < 3))
    {
      if (j == 0) {
        m = paramVarArgs[j];
      }
      if (j == 1) {
        k = paramVarArgs[j];
      }
      if (j == 2) {
        i = paramVarArgs[j];
      }
      j += 1;
    }
    paramVarArgs = new Bundle();
    paramVarArgs.putInt("featureId", paramInt);
    paramVarArgs.putString("featureKey", paramString2);
    paramVarArgs.putString("tuid", paramString1);
    paramVarArgs.putInt("extra1", m);
    paramVarArgs.putInt("extra2", k);
    paramVarArgs.putInt("extra3", i);
    if (ProcessUtil.a())
    {
      TraceReportInstance.a().a(paramInt, paramVarArgs);
      return;
    }
    a("action_update_trace", paramVarArgs);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      TraceReportInstance.a().a(paramInt, paramBoolean);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putBoolean("enable", paramBoolean);
    a("action_enable_trace", localBundle);
  }
  
  public static void a(TraceConfig paramTraceConfig)
  {
    if (!TraceReportInstance.d()) {
      return;
    }
    if (ProcessUtil.a())
    {
      TraceReportInstance.a().a(paramTraceConfig);
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramTraceConfig != null)
    {
      int i = paramTraceConfig.a();
      paramTraceConfig = paramTraceConfig.f();
      localBundle.putInt("appId", i);
      localBundle.putString("currentAccount", paramTraceConfig);
    }
    a("action_init_trace", localBundle);
  }
  
  private static void a(String paramString, Bundle paramBundle)
  {
    if (BaseApplicationImpl.sProcessId == 2)
    {
      b(paramString, paramBundle);
      return;
    }
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      b(paramString, paramBundle);
      return;
    }
    paramBundle.putString("action", paramString);
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramBundle);
  }
  
  private static void b(String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", paramString);
    localBundle.putBundle("bundle", paramBundle);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_cmshow_tracereport", localBundle, new TraceReportInterceptor.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInterceptor
 * JD-Core Version:    0.7.0.1
 */