package com.tencent.biz.authorize;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import org.json.JSONObject;

public class PublicAccountAuthorizeConfigInjector
  implements IAuthorizeConfigInjector
{
  @NonNull
  public String a()
  {
    return "public_account_authorize_config";
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ("publicAccountNew.config".equals(paramString2)) {
      return true;
    }
    if ((((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).hasConfig(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).hasRight(paramString1, paramString2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.PublicAccountAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */