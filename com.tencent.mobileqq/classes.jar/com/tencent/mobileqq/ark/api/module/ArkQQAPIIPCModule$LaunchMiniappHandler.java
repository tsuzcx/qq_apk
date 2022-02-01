package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.api.scheme.MiniAppSchemeHandler;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import eipc.EIPCResult;
import java.util.Map;

public class ArkQQAPIIPCModule$LaunchMiniappHandler
  implements IPCSyncMethodHandler
{
  public static boolean a(String paramString)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
    {
      int i;
      try
      {
        i = Integer.parseInt((String)URLUtil.b(paramString.substring(paramString.indexOf("?") + 1)).get("scene"));
      }
      catch (Exception localException)
      {
        QLog.e("ArkApp", 1, "Ark parse miniapp scene failed.", localException);
        i = 2059;
      }
      EntryModel localEntryModel = MiniAppSchemeHandler.a();
      Activity localActivity = ArkAppQQModule.a();
      Object localObject = localActivity;
      if (localActivity == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)localObject, paramString, i, localEntryModel, null);
      return true;
    }
    return false;
  }
  
  public EIPCResult a(Bundle paramBundle)
  {
    if (ArkQQAPIIPCModule.a() == null)
    {
      QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    if (!a(paramBundle.getString("url")))
    {
      QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, launch failed");
      return EIPCResult.createResult(-102, new Bundle());
    }
    return EIPCResult.createResult(0, new Bundle());
  }
  
  public String a()
  {
    return "QQ.LaunchMiniappHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.LaunchMiniappHandler
 * JD-Core Version:    0.7.0.1
 */