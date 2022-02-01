package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioPanelData$AioActivity
{
  public float a;
  public String a;
  public boolean a;
  public float b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public TroopGiftAioPanelData$AioActivity(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("startTime");
    this.c = paramJSONObject.optString("endTime");
    this.d = paramJSONObject.optString("jumpUrl");
    this.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("durationStart"));
    this.jdField_b_of_type_Float = ((float)paramJSONObject.optDouble("durationEnd"));
    this.e = paramJSONObject.optString("replaceImage");
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("replace");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.AioActivity
 * JD-Core Version:    0.7.0.1
 */