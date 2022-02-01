package com.tencent.mobileqq.activity.specialcare;

import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundConfig$SpecialSound
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static SpecialSound a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new SpecialSound();
    }
    SpecialSound localSpecialSound = new SpecialSound();
    try
    {
      localSpecialSound.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localSpecialSound.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localSpecialSound.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localSpecialSound.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localSpecialSound.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localSpecialSound.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localSpecialSound.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localSpecialSound.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localSpecialSound.g = paramJSONObject.getString("classifyName");
      localSpecialSound.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localSpecialSound.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localSpecialSound.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localSpecialSound.h = paramJSONObject.getString("trialstartday");
      localSpecialSound.i = paramJSONObject.getString("trialendday");
      return localSpecialSound;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localSpecialSound;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundConfig.SpecialSound
 * JD-Core Version:    0.7.0.1
 */