package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.ipc.IPCAsyncMethodHandler;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkAppSSOIPCHandler
  implements IPCAsyncMethodHandler
{
  static void a(int paramInt, boolean paramBoolean, String paramString1, Bundle paramBundle, String paramString2, IPCMethodCallback paramIPCMethodCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramBundle);
    localBundle.putBoolean("result_is_success", paramBoolean);
    localBundle.putInt("result_notify_type", paramInt);
    localBundle.putString("result_data", paramString1);
    paramString1 = EIPCResult.createResult(0, localBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("receive reply, cmd:");
    paramBundle.append(paramString2);
    paramBundle.append(", success=");
    paramBundle.append(paramBoolean);
    QLog.i("ArkApp.ArkAppSSOIPCHandler", 1, paramBundle.toString());
    paramIPCMethodCallback.a(paramString1);
  }
  
  protected static void a(ArkIPCService paramArkIPCService, String paramString1, String paramString2, int paramInt1, int paramInt2, ArkAppSSOIPCHandler.OnSendMsgComplete paramOnSendMsgComplete)
  {
    paramArkIPCService.a(new ArkAppSSOIPCHandler.2(paramString1, paramString2, paramInt1, paramInt2, paramOnSendMsgComplete));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, ArkAppSSOIPCHandler.OnSendMsgComplete paramOnSendMsgComplete)
  {
    a(ArkIPCService.a(), paramString1, paramString2, paramInt1, paramInt2, paramOnSendMsgComplete);
  }
  
  protected IArkAppSSO a()
  {
    return ((IArkService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkService.class, "")).getSSO();
  }
  
  public String a()
  {
    return "ARK.SendSSOMsg";
  }
  
  public void a(Bundle paramBundle, IPCMethodCallback paramIPCMethodCallback)
  {
    String str1 = paramBundle.getString("param_cmd");
    String str2 = paramBundle.getString("param_data");
    int i = paramBundle.getInt("param_timeout");
    int j = paramBundle.getInt("param_notify_type");
    IArkAppSSO localIArkAppSSO = a();
    if (localIArkAppSSO == null)
    {
      QLog.i("ArkApp.ArkAppSSOIPCHandler", 1, "ark sso is null");
      paramIPCMethodCallback.a(EIPCResult.createResult(-102, new Bundle()));
      return;
    }
    localIArkAppSSO.a(str1, str2, i, j, new ArkAppSSOIPCHandler.1(this, paramBundle, str1, paramIPCMethodCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppSSOIPCHandler
 * JD-Core Version:    0.7.0.1
 */