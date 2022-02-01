package com.tencent.biz.authorize;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class AIOAuthorizeConfigInjector
  implements IAuthorizeConfigInjector
{
  protected volatile JSONObject a;
  
  @NonNull
  public String a()
  {
    return "aio_authorize_config";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAuthorizeConfigInjector", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return " + paramJSONObject.toString());
    }
    paramJSONObject = paramJSONObject.optJSONArray("WebViewSwitchAioConfig");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      this.a = paramJSONObject.optJSONObject(0);
    }
  }
  
  public boolean a()
  {
    return this.a == null;
  }
  
  public boolean a(String paramString)
  {
    AuthorizeConfig.a().k();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject1 = Uri.parse(paramString);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if (("http".equals(localObject2)) || ("https".equals(localObject2)))
      {
        localObject1 = ((Uri)localObject1).getHost();
        localObject2 = this.a;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAuthorizeConfigInjector", 1, "WebViewSwitchAio call canSwitchAIO url " + paramString + " config " + localObject2);
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((JSONObject)localObject2).optInt("enable", 0) == 1))
        {
          paramString = ((JSONObject)localObject2).optJSONArray("domains");
          if (paramString != null)
          {
            int i = paramString.length() - 1;
            while (i >= 0)
            {
              if (((String)localObject1).endsWith(paramString.optString(i))) {
                return true;
              }
              i -= 1;
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.authorize.AIOAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */