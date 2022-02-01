package com.tencent.biz.videostory.config.processor;

import org.json.JSONObject;

public class VSEntranceStyleBean
{
  private String jdField_a_of_type_JavaLangString = "";
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private String b = "";
  
  public static VSEntranceStyleBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      VSEntranceStyleBean localVSEntranceStyleBean = new VSEntranceStyleBean();
      paramString = new JSONObject(paramString);
      localVSEntranceStyleBean.jdField_a_of_type_JavaLangString = paramString.optString("icon_image_url", "");
      localVSEntranceStyleBean.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("config");
      localVSEntranceStyleBean.b = paramString.optString("md5", "");
      return localVSEntranceStyleBean;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("k = icon_image_url, value = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n k = config, value = ");
    localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
    localStringBuilder.append("\n k = md5, value = ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceStyleBean
 * JD-Core Version:    0.7.0.1
 */