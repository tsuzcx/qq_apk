package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlReportInfo
{
  public static String a;
  private static String i;
  private static String j;
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
  
  static
  {
    try
    {
      i = DeviceInfoUtil.f();
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("b84cf5");
      j = DeviceInfoUtil.b();
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
      localWadlReportInfo.h = String.valueOf(DeviceInfoUtil.b()[1]);
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
        if (!TextUtils.isEmpty(i))
        {
          String str1 = i;
          localJSONObject.put("androidId", str1);
          if (TextUtils.isEmpty(j)) {
            break label88;
          }
          str1 = j;
          localJSONObject.put("imsi", str1);
          localJSONObject.put("leftMemorySize", this.jdField_b_of_type_Long);
          str1 = localJSONObject.toString();
          return str1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      String str2 = "";
      continue;
      label88:
      str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo
 * JD-Core Version:    0.7.0.1
 */