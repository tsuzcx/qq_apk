package com.tencent.gamecenter.wadl.biz.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WadlQIPCModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("action = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", params = ");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.d("WadlQIPCModule", 1, ((StringBuilder)localObject).toString());
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("action.getSkey".equals(paramString))
    {
      paramString = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(((AppRuntime)localObject).getAccount());
      paramBundle = new Bundle();
      if (paramString == null) {
        paramString = "";
      }
      paramBundle.putString("skey", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    if ("action.getUin".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("uin", ((AppRuntime)localObject).getAccount());
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("action.report".equals(paramString))
    {
      paramString = paramBundle.getString("reportData");
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC((AppRuntime)localObject, paramString);
      return null;
    }
    if ("action.check,foreground".equals(paramString))
    {
      boolean bool = Foreground.isCurrentProcessForeground();
      paramString = new Bundle();
      paramString.putBoolean("isForeground", bool);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule
 * JD-Core Version:    0.7.0.1
 */