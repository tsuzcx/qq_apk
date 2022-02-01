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
    if (QLog.isColorLevel()) {
      QLog.i("ArkAuthorizeConfigInjector", 2, "[canShareArkMsg] ArkName: " + paramString + " ArkShareConfig: " + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    AuthorizeConfig.a().k();
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("validArkNames");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = jdField_a_of_type_OrgJsonJSONArray;
    }
    int i = ((JSONArray)localObject).length() - 1;
    while (i >= 0)
    {
      if (paramString.equals(((JSONArray)localObject).optString(i))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.authorize.ArkAuthorizeConfigInjector
 * JD-Core Version:    0.7.0.1
 */