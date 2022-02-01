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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebViewSwitchAio loadFuncDevWebViewConfig return ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("AIOAuthorizeConfigInjector", 1, localStringBuilder.toString());
    }
    paramJSONObject = paramJSONObject.optJSONArray("WebViewSwitchAioConfig");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      this.a = paramJSONObject.optJSONObject(0);
    }
  }
  
  public boolean a(String paramString)
  {
    AuthorizeConfig.a().s();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    if ((!"http".equals(localObject2)) && (!"https".equals(localObject2))) {
      return false;
    }
    localObject1 = ((Uri)localObject1).getHost();
    localObject2 = this.a;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebViewSwitchAio call canSwitchAIO url ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" config ");
      localStringBuilder.append(localObject2);
      QLog.d("AIOAuthorizeConfigInjector", 1, localStringBuilder.toString());
    }
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (((JSONObject)localObject2).optInt("enable", 0) != 1) {
        return false;
      }
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
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean b()
  {
    return this.a == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.AIOAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */