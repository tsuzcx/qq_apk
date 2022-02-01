package com.tencent.mobileqq.ark.api.scheme;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.module.SchemeHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import org.json.JSONObject;

public class MiniAppSchemeHandler
  implements SchemeHandler
{
  public static EntryModel a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if (((localObject instanceof BaseActivity)) && (((BaseActivity)localObject).getChatFragment() != null))
    {
      localObject = ((BaseActivity)localObject).getChatFragment().a();
      if ((localObject instanceof TroopChatPie)) {
        return ((BaseChatPie)localObject).a();
      }
    }
    return null;
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramString2 = BaseActivity.sTopActivity;
    if (paramString2 == null) {
      return false;
    }
    if (paramString1.startsWith("open/")) {}
    label148:
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(paramString1.substring(5, paramString1.indexOf("?")));
        paramJSONObject = (String)URLUtil.a(paramString1).get("url");
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).verifyArkScene(i)) {
          break label148;
        }
        i = 2059;
        paramString3 = a();
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramString2, paramJSONObject, i, paramString3, null);
        return true;
      }
      catch (Exception paramString2)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parse miniapp scheme failed:");
        paramJSONObject.append(paramString1);
        QLog.e("ArkApp", 1, paramJSONObject.toString(), paramString2);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.MiniAppSchemeHandler
 * JD-Core Version:    0.7.0.1
 */