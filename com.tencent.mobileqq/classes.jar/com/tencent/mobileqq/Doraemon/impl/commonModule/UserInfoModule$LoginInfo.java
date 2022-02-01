package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class UserInfoModule$LoginInfo
{
  public long a;
  public String a;
  public long b;
  public String b;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("access_token", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("expire_in", this.jdField_a_of_type_Long);
      localJSONObject.put("expire_time", this.jdField_b_of_type_Long);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(UserInfoModule.jdField_a_of_type_JavaLangString, 2, localJSONException.getMessage(), localJSONException);
      }
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginInfo{, openid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", access_token='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", expireIn='");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", expireTime='");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.LoginInfo
 * JD-Core Version:    0.7.0.1
 */