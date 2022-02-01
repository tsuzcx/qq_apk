package com.tencent.mobileqq.activity.specialcare;

import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundConfig$SpecialSound
{
  public int a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public int g;
  public String h;
  public String i;
  public int j;
  public int k;
  public String l;
  public String m;
  public String n;
  
  static SpecialSound a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new SpecialSound();
    }
    SpecialSound localSpecialSound = new SpecialSound();
    try
    {
      localSpecialSound.a = paramJSONObject.getInt("id");
      localSpecialSound.b = paramJSONObject.getString("name");
      localSpecialSound.c = paramJSONObject.getInt("type");
      localSpecialSound.d = paramJSONObject.optString("soundVersion", "0");
      localSpecialSound.e = paramJSONObject.getString("soundUrl");
      localSpecialSound.f = paramJSONObject.getString("whiteList");
      localSpecialSound.g = paramJSONObject.getInt("isShow");
      localSpecialSound.k = paramJSONObject.getInt("classify");
      localSpecialSound.l = paramJSONObject.getString("classifyName");
      localSpecialSound.h = paramJSONObject.getString("backgroundUrl");
      localSpecialSound.i = String.valueOf(paramJSONObject.getInt("vip_type"));
      localSpecialSound.j = paramJSONObject.getInt("useNum");
      localSpecialSound.m = paramJSONObject.getString("trialstartday");
      localSpecialSound.n = paramJSONObject.getString("trialendday");
      return localSpecialSound;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localSpecialSound;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundConfig.SpecialSound
 * JD-Core Version:    0.7.0.1
 */