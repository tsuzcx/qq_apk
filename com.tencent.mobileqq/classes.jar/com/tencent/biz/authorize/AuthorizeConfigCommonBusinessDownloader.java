package com.tencent.biz.authorize;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigDownloadInjector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class AuthorizeConfigCommonBusinessDownloader
  implements IAuthorizeConfigDownloadInjector
{
  public JSONObject a()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof QQAppInterface))
    {
      QLog.d("AuthorizeConfigCommonBusinessDownloader", 1, "WebViewSwitchAio main process loadFuncDevWebViewConfig");
      localObject = VasUpdateUtil.a((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", true, null);
    }
    JSONObject localJSONObject;
    do
    {
      return localObject;
      localJSONObject = VasUpdateUtil.a((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", false, null);
      localObject = localJSONObject;
    } while (localJSONObject != null);
    QLog.d("AuthorizeConfigCommonBusinessDownloader", 1, "WebViewSwitchAio calling main process to download FuncDevWebViewConfig");
    localObject = DataFactory.a("download_FuncDev_webview", "", 0, null);
    WebIPCOperator.a().b((Bundle)localObject);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.authorize.AuthorizeConfigCommonBusinessDownloader
 * JD-Core Version:    0.7.0.1
 */