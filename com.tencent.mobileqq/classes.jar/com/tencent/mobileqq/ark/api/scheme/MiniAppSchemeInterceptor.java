package com.tencent.mobileqq.ark.api.scheme;

import com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule;
import com.tencent.mobileqq.ark.module.SchemeInterceptor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class MiniAppSchemeInterceptor
  implements SchemeInterceptor
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString1))
    {
      ArkQQAPIIPCModule.d(paramString1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.MiniAppSchemeInterceptor
 * JD-Core Version:    0.7.0.1
 */