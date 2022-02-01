package com.tencent.biz.authorize;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.webview.authorize.IAuthorizeConfigInjector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkAuthorizeConfigInjector
  implements IAuthorizeConfigInjector
{
  protected static final JSONArray a;
  protected volatile JSONObject a;
  
  static
  {
    jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.qqcomic.aiogift");
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.gamecenter.hebao");
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.gamecenter.hebao2020");
  }
  
  @NonNull
  public String a()
  {
    return "ark_authorize_config";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("arkShareWhiteList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject(0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject == null;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[canShareArkMsg] ArkName: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" ArkShareConfig: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.i("ArkAuthorizeConfigInjector", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    AuthorizeConfig.a().k();
    Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((JSONObject)localObject2).optJSONArray("validArkNames");
    }
    if (localObject2 != null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      localObject2 = jdField_a_of_type_OrgJsonJSONArray;
    }
    int i = ((JSONArray)localObject2).length() - 1;
    while (i >= 0)
    {
      if (paramString.equals(((JSONArray)localObject2).optString(i))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.ArkAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */