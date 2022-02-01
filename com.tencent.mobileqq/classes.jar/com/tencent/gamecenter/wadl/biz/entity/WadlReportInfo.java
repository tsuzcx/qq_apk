package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlReportInfo
{
  public static String a;
  private static int b;
  private static String j;
  private static String k;
  public int a;
  public long a;
  public WadlParams a;
  public long b;
  public String b;
  public String c = "";
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    try
    {
      j = DeviceInfoUtil.f();
      jdField_b_of_type_Int = DeviceInfoUtil.f();
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("b84cf5");
      k = DeviceInfoUtil.b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static WadlReportInfo a()
  {
    WadlReportInfo localWadlReportInfo = new WadlReportInfo();
    try
    {
      localWadlReportInfo.jdField_b_of_type_Long = (DeviceInfoUtil.e() / 1048576L);
      localWadlReportInfo.i = String.valueOf(DeviceInfoUtil.b()[1]);
      localWadlReportInfo.jdField_b_of_type_JavaLangString = "";
      localWadlReportInfo.jdField_a_of_type_Int = 0;
      return localWadlReportInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localWadlReportInfo;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(j))
        {
          String str1 = j;
          localJSONObject.put("androidId", str1);
          if (!TextUtils.isEmpty(k))
          {
            str1 = k;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", jdField_b_of_type_Int);
            localJSONObject.put("leftMemorySize", this.jdField_b_of_type_Long);
            localJSONObject.put("pageUrl", this.e);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo
 * JD-Core Version:    0.7.0.1
 */