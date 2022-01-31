package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.VideoReporter;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyUtils$ReportR5Builder
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  
  public ReportR5Builder a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      if (this.jdField_a_of_type_Boolean) {
        ((JSONObject)localObject).put("folder_status", ReadInJoyUtils.d);
      }
      if (this.jdField_b_of_type_Boolean) {
        ((JSONObject)localObject).put("time", System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int != -1) {
        ((JSONObject)localObject).put("channel_id", this.jdField_a_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        ((JSONObject)localObject).put("kandian_mode", ReadInJoyUtils.e());
      }
      if (this.d) {
        ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
      }
      if (this.e) {
        ((JSONObject)localObject).put("tab_source", ReadInJoyUtils.d());
      }
      if (this.f) {
        ((JSONObject)localObject).put("session_id", ReadInJoyUtils.j());
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        ((JSONObject)localObject).put("skin_id", this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int != -1) {
        ((JSONObject)localObject).put("skin_voice", this.jdField_b_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != -1) {
        ((JSONObject)localObject).put("skin_type", this.jdField_c_of_type_Int);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public ReportR5Builder b()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder c()
  {
    this.jdField_c_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder d()
  {
    this.d = true;
    return this;
  }
  
  public ReportR5Builder e()
  {
    this.e = true;
    return this;
  }
  
  public ReportR5Builder f()
  {
    this.f = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder
 * JD-Core Version:    0.7.0.1
 */