package com.tencent.biz.authorize;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class WhiteScreenAuthorizeConfigInjector
  implements IAuthorizeConfigInjector
{
  protected volatile JSONObject a;
  
  @NonNull
  public String a()
  {
    return "white_list_authorize_config";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("WebViewWhiteScreenDomains");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      this.a = paramJSONObject.optJSONObject(0);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    AuthorizeConfig.a().k();
    Object localObject = this.a;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInWhiteScreenWhiteList is called of domain ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" config ");
      localStringBuilder.append(localObject);
      QLog.d("WhiteListAuthorizeConfigInjector", 1, localStringBuilder.toString());
    }
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((JSONObject)localObject).optJSONArray("domains");
      if (localObject != null)
      {
        int i = ((JSONArray)localObject).length() - 1;
        while (i >= 0)
        {
          if (paramString.endsWith(((JSONArray)localObject).optString(i))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.WhiteScreenAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */