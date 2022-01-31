package com.tencent.mobileqq.activity.qwallet.fragment;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class BaseHbFragment$HBConfig
{
  public int a;
  public Map a;
  
  public BaseHbFragment$HBConfig(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mk_hb_wishing");
      BaseHbFragment.a(this.jdField_a_of_type_JavaUtilMap, localJSONObject);
      this.jdField_a_of_type_Int = paramJSONObject.optInt("is_vip_bg_show");
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment.HBConfig
 * JD-Core Version:    0.7.0.1
 */