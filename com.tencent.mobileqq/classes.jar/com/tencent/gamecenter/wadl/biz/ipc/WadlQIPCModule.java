package com.tencent.gamecenter.wadl.biz.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class WadlQIPCModule
  extends QIPCModule
{
  public static WadlQIPCModule a;
  
  private WadlQIPCModule()
  {
    super("WadlQIPCModule");
  }
  
  public static WadlQIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new WadlQIPCModule();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("action.getSkey".equals(paramString))
    {
      paramString = ((TicketManager)localAppRuntime.getManager(2)).getSkey(localAppRuntime.getAccount());
      paramBundle = new Bundle();
      if (paramString != null) {}
      for (;;)
      {
        paramBundle.putString("skey", paramString);
        return EIPCResult.createSuccessResult(paramBundle);
        paramString = "";
      }
    }
    if ("action.getUin".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("uin", localAppRuntime.getAccount());
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("action.report".equals(paramString))
    {
      paramString = paramBundle.getString("reportData");
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC(localAppRuntime, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule
 * JD-Core Version:    0.7.0.1
 */