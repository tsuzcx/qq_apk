package com.tencent.kingkong;

import org.json.JSONObject;

public class NativePatch$FingerprintDef
{
  public int a;
  public String a;
  public String b;
  
  public NativePatch$FingerprintDef(NativePatch paramNativePatch) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("lib_name").trim();
      this.b = paramJSONObject.getString("func_name").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      label41:
      break label41;
    }
    Common.Log.a("KingKongNativePatch", "Parse fingerprint error!");
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.NativePatch.FingerprintDef
 * JD-Core Version:    0.7.0.1
 */