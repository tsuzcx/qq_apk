package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class WadlReportBuilder
{
  public static int a = 51;
  public String a;
  public HashMap<Integer, String> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public WadlReportBuilder()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "55801");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "1");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "4");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "430");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), Build.MODEL);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), Build.VERSION.RELEASE);
  }
  
  public WadlReportBuilder a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public WadlReportBuilder a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public WadlReportBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "8.7.0");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        int j = HttpUtil.getNetWorkType();
        if (j >= 0)
        {
          i = j;
          if (j < AppConstants.NET_TYPE_NAME.length)
          {
            localJSONObject3.put("net_type", AppConstants.NET_TYPE_NAME[i]);
            localJSONObject3.put("resolution", GameCenterUtil.c());
            localJSONObject3.put("is_red_point", "0");
            localJSONObject3.put("is_new_status", "0");
            localJSONObject3.put("gamecenter_src", "1");
            localJSONObject3.put("ret_id", String.valueOf(this.jdField_c_of_type_Int));
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
              localJSONObject3.put("oper_moudle", this.jdField_c_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              localJSONObject3.put("oper_id", this.jdField_b_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty(this.d)) {
              localJSONObject3.put("gameappid", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
              localJSONObject3.put("tianji_report_str", this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
              localJSONObject3.put("apk_volume", this.f);
            }
            Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              String str = (String)localEntry.getValue();
              if (TextUtils.isEmpty(str)) {
                continue;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("ext");
              localStringBuilder.append(localEntry.getKey());
              localJSONObject3.put(localStringBuilder.toString(), str);
              continue;
            }
            localJSONObject2.put("data", localJSONObject3);
            localJSONObject2.put("dc_id", this.jdField_a_of_type_JavaLangString);
            localJSONArray.put(localJSONObject2);
            localJSONObject1.put("target", paramInt);
            localJSONObject1.put("report_list", localJSONArray);
            return localJSONObject1;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localJSONObject1;
      }
      int i = 0;
    }
  }
  
  public void a()
  {
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC(this);
  }
  
  public WadlReportBuilder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public WadlReportBuilder c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WadlReportBuilder d(String paramString)
  {
    a(1, paramString);
    return this;
  }
  
  public WadlReportBuilder e(String paramString)
  {
    a(11, paramString);
    return this;
  }
  
  public WadlReportBuilder f(String paramString)
  {
    a(12, paramString);
    return this;
  }
  
  public WadlReportBuilder g(String paramString)
  {
    a(4, paramString);
    return this;
  }
  
  public WadlReportBuilder h(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WadlReportBuilder i(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public WadlReportBuilder j(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[dcId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",operId=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",operModule=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder
 * JD-Core Version:    0.7.0.1
 */