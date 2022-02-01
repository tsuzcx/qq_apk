package com.tencent.comic.api.plugin;

import org.json.JSONException;
import org.json.JSONObject;

public class PreloadPublicParam
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public boolean j = false;
  public boolean k = false;
  
  public PreloadPublicParam()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
  }
  
  public static PreloadPublicParam a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    PreloadPublicParam localPreloadPublicParam = new PreloadPublicParam();
    try
    {
      if (paramJSONObject.has("pppid")) {
        localPreloadPublicParam.jdField_a_of_type_Int = paramJSONObject.getInt("pppid");
      }
      boolean bool = paramJSONObject.has("timecontrol");
      JSONObject localJSONObject;
      if (bool)
      {
        localJSONObject = paramJSONObject.getJSONObject("timecontrol");
        localPreloadPublicParam.jdField_a_of_type_Boolean = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.jdField_b_of_type_Int = localJSONObject.getInt("dayofweek");
        localPreloadPublicParam.jdField_c_of_type_Int = localJSONObject.getInt("hourofday");
      }
      if (paramJSONObject.has("reddot"))
      {
        localJSONObject = paramJSONObject.getJSONObject("reddot");
        localPreloadPublicParam.jdField_b_of_type_Boolean = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.jdField_c_of_type_Boolean = localJSONObject.optBoolean("apponly");
        localPreloadPublicParam.jdField_d_of_type_Boolean = localJSONObject.getBoolean("app");
        localPreloadPublicParam.jdField_e_of_type_Boolean = localJSONObject.getBoolean("leba");
      }
      if (paramJSONObject.has("lebalist")) {
        localPreloadPublicParam.jdField_h_of_type_Boolean = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
      }
      if (paramJSONObject.has("activetime"))
      {
        localJSONObject = paramJSONObject.getJSONObject("activetime");
        localPreloadPublicParam.jdField_i_of_type_Boolean = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.jdField_e_of_type_Int = localJSONObject.getInt("hour");
      }
      if (paramJSONObject.has("usedtimes"))
      {
        localJSONObject = paramJSONObject.getJSONObject("usedtimes");
        localPreloadPublicParam.j = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.jdField_f_of_type_Int = localJSONObject.getInt("times");
      }
      if (paramJSONObject.has("userlearn"))
      {
        localJSONObject = paramJSONObject.getJSONObject("userlearn");
        localPreloadPublicParam.k = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.jdField_g_of_type_Int = localJSONObject.getInt("timearea");
        localPreloadPublicParam.jdField_h_of_type_Int = localJSONObject.getInt("methodid");
        localPreloadPublicParam.jdField_i_of_type_Int = localJSONObject.getInt("clusternum");
      }
      if (paramJSONObject.has("cdperiod"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
        localPreloadPublicParam.jdField_f_of_type_Boolean = paramJSONObject.optBoolean("switch");
        localPreloadPublicParam.jdField_d_of_type_Int = paramJSONObject.optInt("time");
        localPreloadPublicParam.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("reverse");
      }
      return localPreloadPublicParam;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.plugin.PreloadPublicParam
 * JD-Core Version:    0.7.0.1
 */