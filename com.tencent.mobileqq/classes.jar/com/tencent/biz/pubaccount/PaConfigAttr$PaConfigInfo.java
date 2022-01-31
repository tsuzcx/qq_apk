package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.VideoAttr;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PaConfigAttr$PaConfigInfo
{
  public static final Map a;
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
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Boolean.TYPE, Integer.valueOf(1));
    jdField_a_of_type_JavaUtilMap.put(Integer.TYPE, Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put(Long.TYPE, Integer.valueOf(3));
    jdField_a_of_type_JavaUtilMap.put(String.class, Integer.valueOf(4));
    jdField_a_of_type_JavaUtilMap.put(Double.TYPE, Integer.valueOf(5));
  }
  
  public PaConfigAttr$PaConfigInfo() {}
  
  public PaConfigAttr$PaConfigInfo(mobileqq_mp.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_Int = paramConfigInfo.type.get();
    this.jdField_a_of_type_JavaLangString = paramConfigInfo.title.get();
    this.jdField_b_of_type_JavaLangString = paramConfigInfo.content.get();
    this.jdField_c_of_type_Int = paramConfigInfo.event_id.get();
    this.jdField_c_of_type_JavaLangString = paramConfigInfo.url.get();
    this.jdField_d_of_type_Int = paramConfigInfo.state.get();
    this.jdField_e_of_type_Int = paramConfigInfo.state_id.get();
    this.jdField_f_of_type_Int = paramConfigInfo.confirm_flag.get();
    this.jdField_d_of_type_JavaLangString = paramConfigInfo.confirm_tips.get();
  }
  
  public static PaConfigInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    PaConfigInfo localPaConfigInfo;
    for (;;)
    {
      return paramJSONObject;
      localPaConfigInfo = new PaConfigInfo();
      try
      {
        localPaConfigInfo.jdField_a_of_type_Int = paramJSONObject.optInt("type");
        localPaConfigInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
        localPaConfigInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
        localPaConfigInfo.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
        localPaConfigInfo.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
        localPaConfigInfo.jdField_d_of_type_Int = paramJSONObject.optInt("state");
        localPaConfigInfo.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
        localPaConfigInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
        localPaConfigInfo.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
        localPaConfigInfo.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
        localPaConfigInfo.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
        localPaConfigInfo.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
        localPaConfigInfo.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
        localPaConfigInfo.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
        localPaConfigInfo.jdField_g_of_type_Int = paramJSONObject.optInt("width");
        localPaConfigInfo.jdField_h_of_type_Int = paramJSONObject.optInt("height");
        localPaConfigInfo.i = paramJSONObject.optString("icon");
        localPaConfigInfo.j = paramJSONObject.optString("vid");
        paramJSONObject = localPaConfigInfo;
        if (localPaConfigInfo.jdField_a_of_type_Int == 3)
        {
          paramJSONObject = localPaConfigInfo;
          if (localPaConfigInfo.jdField_c_of_type_Int == 23)
          {
            paramJSONObject = localPaConfigInfo;
            if (!TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString))
            {
              DynamicInfo localDynamicInfo = new DynamicInfo();
              localDynamicInfo.a(localPaConfigInfo.jdField_b_of_type_JavaLangString);
              if ((TextUtils.isEmpty(localPaConfigInfo.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString))) {
                localPaConfigInfo.jdField_e_of_type_JavaLangString = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString;
              }
              paramJSONObject = localPaConfigInfo;
              if (TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString))
              {
                paramJSONObject = localPaConfigInfo;
                if (!TextUtils.isEmpty(localDynamicInfo.jdField_a_of_type_JavaLangString))
                {
                  localPaConfigInfo.jdField_a_of_type_JavaLangString = localDynamicInfo.jdField_a_of_type_JavaLangString;
                  return localPaConfigInfo;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return localPaConfigInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo
 * JD-Core Version:    0.7.0.1
 */