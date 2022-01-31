package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SelfInfoModule$BusinessCountInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("businessId", this.jdField_a_of_type_Int);
      localJSONObject.put("businessType", this.jdField_b_of_type_Int);
      localJSONObject.put("businessName", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("jumpUrl", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("businessIconUrl", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("fansCount", this.jdField_c_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("SelfInfoModule", 1, "toJson error. " + localJSONException);
    }
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.getInt("businessId");
    this.jdField_b_of_type_Int = paramJSONObject.getInt("businessType");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("businessName");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("jumpUrl");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("businessIconUrl");
    this.jdField_c_of_type_Int = paramJSONObject.getInt("fansCount");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.BusinessCountInfo
 * JD-Core Version:    0.7.0.1
 */