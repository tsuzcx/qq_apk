package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import org.json.JSONObject;

public class CommonProgressStyle
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public String b;
  public float c;
  public int c;
  public String c;
  public float d;
  public int d;
  public String d;
  public float e;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g = 12;
  public int h = 10;
  public int i = 16;
  public int j = 2;
  public int k = 270;
  public int l = 0;
  
  public CommonProgressStyle(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "#12B7F5";
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 50;
    this.jdField_d_of_type_Int = 50;
    this.jdField_e_of_type_Int = 20;
    this.jdField_f_of_type_Int = 22;
    this.jdField_a_of_type_Float = 2.0F;
    this.jdField_b_of_type_JavaLangString = "#F2F2F2";
    this.jdField_c_of_type_JavaLangString = "#F2F2F2";
    this.jdField_d_of_type_JavaLangString = "#ffffff";
    this.jdField_e_of_type_JavaLangString = "#12B7F5";
    this.jdField_b_of_type_Float = 2.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = "#CCE5E5E5";
    this.jdField_c_of_type_Float = 1.5F;
    this.jdField_d_of_type_Float = 1.5F;
    this.jdField_e_of_type_Float = 7.0F;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static CommonProgressStyle a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new CommonProgressStyle(paramInt);
    paramJSONObject.jdField_a_of_type_Int = paramInt;
    paramJSONObject.jdField_c_of_type_Int = ParseUtil.a(localJSONObject.optString("width"), 50);
    paramJSONObject.jdField_d_of_type_Int = ParseUtil.a(localJSONObject.optString("minWidth"), 50);
    paramInt = paramJSONObject.jdField_c_of_type_Int;
    int m = paramJSONObject.jdField_d_of_type_Int;
    if (paramInt < m) {
      paramJSONObject.jdField_c_of_type_Int = m;
    } else if (paramInt > 100) {
      paramJSONObject.jdField_c_of_type_Int = 100;
    }
    paramJSONObject.jdField_e_of_type_Int = ParseUtil.a(localJSONObject.optString("height"), 20);
    paramJSONObject.jdField_f_of_type_Int = ParseUtil.a(localJSONObject.optString("maxHeight"), 22);
    paramInt = paramJSONObject.jdField_e_of_type_Int;
    if (paramInt < 18)
    {
      paramJSONObject.jdField_e_of_type_Int = 18;
    }
    else
    {
      m = paramJSONObject.jdField_f_of_type_Int;
      if (paramInt > m) {
        paramJSONObject.jdField_e_of_type_Int = m;
      }
    }
    paramJSONObject.jdField_a_of_type_Float = ParseUtil.a(localJSONObject.optString("corner"), 2.0F);
    float f1 = paramJSONObject.jdField_a_of_type_Float;
    if (f1 < 2.0F) {
      paramJSONObject.jdField_a_of_type_Float = 2.0F;
    } else if (f1 > 20.0F) {
      paramJSONObject.jdField_a_of_type_Float = 20.0F;
    }
    paramJSONObject.jdField_b_of_type_JavaLangString = ParseUtil.a(localJSONObject, "progressBg", "#F2F2F2");
    paramJSONObject.jdField_c_of_type_JavaLangString = ParseUtil.a(localJSONObject, "secondaryProgressBg", "#F2F2F2");
    paramJSONObject.jdField_a_of_type_JavaLangString = ParseUtil.a(localJSONObject, "progressColor", "#12B7F5");
    paramJSONObject.jdField_d_of_type_JavaLangString = ParseUtil.a(localJSONObject, "textColor", "#ffffff");
    paramJSONObject.g = localJSONObject.optInt("textSize", 12);
    paramJSONObject.h = 10;
    paramJSONObject.i = 16;
    paramJSONObject.jdField_e_of_type_JavaLangString = ParseUtil.a(localJSONObject, "buttonBorderColor", "#12B7F5");
    paramJSONObject.jdField_b_of_type_Float = ParseUtil.a(localJSONObject.optString("buttonBorderSize", "0"), 0.0F);
    paramJSONObject.j = 2;
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonProgressStyle
 * JD-Core Version:    0.7.0.1
 */