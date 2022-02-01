package com.tencent.mobileqq.ark.vipreport;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.ipc.IPCAsyncMethodHandler;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkVipReporterIPCHandler
  implements IPCAsyncMethodHandler
{
  public static void a(String paramString)
  {
    ((IArkIPCService)QRoute.api(IArkIPCService.class)).call(new ArkVipReporterIPCHandler.1(paramString));
  }
  
  static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "doVipReport()=null");
      return;
    }
    paramAppRuntime = ((IArkService)paramAppRuntime.getRuntimeService(IArkService.class, "")).getSSO();
    if (paramAppRuntime == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doVipReport()=");
    localStringBuilder.append(paramString);
    QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, localStringBuilder.toString());
    paramAppRuntime.a("ArkAppReport.VIPReport", paramString, 10000, 0, new ArkVipReporterIPCHandler.2());
  }
  
  public String a()
  {
    return "ARK.VipReport";
  }
  
  public void a(Bundle paramBundle, IPCMethodCallback paramIPCMethodCallback)
  {
    a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramBundle.getString("content"));
    paramIPCMethodCallback.a(EIPCResult.createResult(0, new Bundle()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporterIPCHandler
 * JD-Core Version:    0.7.0.1
 */