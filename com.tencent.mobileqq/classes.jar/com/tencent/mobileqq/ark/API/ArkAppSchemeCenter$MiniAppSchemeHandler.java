package com.tencent.mobileqq.ark.API;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import org.json.JSONObject;

public class ArkAppSchemeCenter$MiniAppSchemeHandler
  implements ArkAppSchemeCenter.IRegScheme
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramString2 = BaseActivity.sTopActivity;
    if (paramString2 == null) {
      return false;
    }
    if (paramString1.startsWith("open/")) {
      try
      {
        int j = Integer.parseInt(paramString1.substring("open/".length(), paramString1.indexOf("?")));
        paramJSONObject = (String)URLUtil.a(paramString1).get("url");
        int i = j;
        if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).verifyArkScene(j)) {
          i = 2059;
        }
        paramString3 = ArkAppSchemeCenter.a();
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramString2, paramJSONObject, i, paramString3, null);
        return true;
      }
      catch (Exception paramString2)
      {
        QLog.e("ArkApp", 1, "parse miniapp scheme failed:" + paramString1, paramString2);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.MiniAppSchemeHandler
 * JD-Core Version:    0.7.0.1
 */