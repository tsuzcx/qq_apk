package com.tencent.biz.pubaccount.ecshopassit.conf;

import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopMinusViewConfBean
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public EcshopMinusViewConfBean()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static EcshopMinusViewConfBean a(String paramString)
  {
    EcshopMinusViewConfBean localEcshopMinusViewConfBean = new EcshopMinusViewConfBean();
    if (!StringUtil.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localEcshopMinusViewConfBean.jdField_a_of_type_Int = paramString.optInt("minus_view_switch");
      localEcshopMinusViewConfBean.jdField_a_of_type_JavaLangString = paramString.optString("minus_view_titie");
      localEcshopMinusViewConfBean.jdField_b_of_type_JavaLangString = paramString.optString("recommend_title");
      localEcshopMinusViewConfBean.c = paramString.optString("btn_jump_url");
      localEcshopMinusViewConfBean.jdField_b_of_type_Int = paramString.optInt("max_open_cnt", 2);
      if (localEcshopMinusViewConfBean.jdField_b_of_type_Int <= 0) {
        localEcshopMinusViewConfBean.jdField_b_of_type_Int = 2;
      }
      return localEcshopMinusViewConfBean;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localEcshopMinusViewConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.conf.EcshopMinusViewConfBean
 * JD-Core Version:    0.7.0.1
 */