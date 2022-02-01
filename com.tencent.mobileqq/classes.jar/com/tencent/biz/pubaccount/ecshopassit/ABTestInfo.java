package com.tencent.biz.pubaccount.ecshopassit;

import android.text.TextUtils;
import org.json.JSONObject;

public class ABTestInfo
{
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  
  public static ABTestInfo a(JSONObject paramJSONObject)
  {
    ABTestInfo localABTestInfo = new ABTestInfo();
    localABTestInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sGrayPolicyId");
    localABTestInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("params");
    localABTestInfo.b = paramJSONObject.optString("sGroupKey");
    localABTestInfo.c = paramJSONObject.optString("sStrategyType");
    localABTestInfo.d = paramJSONObject.optString("sExpKey");
    return localABTestInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      return this.jdField_a_of_type_OrgJsonJSONObject.toString();
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = null;
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      str = this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString1);
    }
    if (TextUtils.isEmpty(str)) {
      return paramString2;
    }
    return str;
  }
  
  public String toString()
  {
    return "ABTestInfo{sGrayPolicyId=" + this.jdField_a_of_type_JavaLangString + ", params=" + a() + ", sGroupKey=" + this.b + ", sStrategyType=" + this.c + ", sExpKey=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ABTestInfo
 * JD-Core Version:    0.7.0.1
 */