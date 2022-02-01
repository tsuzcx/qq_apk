package com.tencent.aelight.camera.aioeditor.capture.text;

import org.json.JSONObject;

public class DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  
  public static DynamicTextFontInfo a(JSONObject paramJSONObject)
  {
    DynamicTextFontInfo localDynamicTextFontInfo = new DynamicTextFontInfo();
    localDynamicTextFontInfo.a = paramJSONObject.optString("resurl");
    localDynamicTextFontInfo.b = paramJSONObject.optString("md5");
    localDynamicTextFontInfo.c = paramJSONObject.optString("name");
    localDynamicTextFontInfo.d = paramJSONObject.optInt("text_id");
    localDynamicTextFontInfo.e = paramJSONObject.optInt("progress");
    return localDynamicTextFontInfo;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo
 * JD-Core Version:    0.7.0.1
 */