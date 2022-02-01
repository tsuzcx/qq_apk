package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SSOWebviewPlugin$1
  extends OnRemoteRespObserver
{
  SSOWebviewPlugin$1(SSOWebviewPlugin paramSSOWebviewPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == SSOWebviewPlugin.a(this.a).key))
    {
      int i = paramBundle.getInt("failcode");
      Object localObject = paramBundle.getBundle("request");
      if (i != 1000)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("IPC failed ! failcode: ");
        paramBundle.append(i);
        paramBundle.append("  reqParams: ");
        paramBundle.append(localObject);
        QLog.e("SSOWebviewPlugin", 2, paramBundle.toString());
        return;
      }
      String str = paramBundle.getString("cmd");
      paramBundle = paramBundle.getBundle("response");
      if (("ipc_cmd_certified_account_web_plugin_follow".equals(str)) && (localObject != null) && (paramBundle != null))
      {
        localObject = ((Bundle)localObject).getString("callback");
        i = paramBundle.getInt("retCode");
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("retCode", i);
          this.a.callJs((String)localObject, new String[] { paramBundle.toString() });
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW return! retCode: ");
            paramBundle.append(i);
            QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sso.PublicFollow failed! ");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramBundle));
          QLog.e("SSOWebviewPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin.1
 * JD-Core Version:    0.7.0.1
 */