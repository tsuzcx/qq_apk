package com.tencent.aelight.camera.aioeditor.capture.text;

import org.json.JSONObject;

public class DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static DynamicTextFontInfo a(JSONObject paramJSONObject)
  {
    DynamicTextFontInfo localDynamicTextFontInfo = new DynamicTextFontInfo();
    localDynamicTextFontInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("resurl");
    localDynamicTextFontInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("md5");
    localDynamicTextFontInfo.c = paramJSONObject.optString("name");
    localDynamicTextFontInfo.jdField_a_of_type_Int = paramJSONObject.optInt("text_id");
    localDynamicTextFontInfo.jdField_b_of_type_Int = paramJSONObject.optInt("progress");
    return localDynamicTextFontInfo;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo
 * JD-Core Version:    0.7.0.1
 */