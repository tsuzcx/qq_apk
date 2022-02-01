package com.tencent.gathererga.ad.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class AdUUID$Salt
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.jdField_a_of_type_Int);
      localJSONObject.put("salt", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("maxLength", this.b);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdUUID.Salt
 * JD-Core Version:    0.7.0.1
 */