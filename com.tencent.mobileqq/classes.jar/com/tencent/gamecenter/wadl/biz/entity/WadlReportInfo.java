package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlReportInfo
{
  public static String a;
  private static String m;
  private static String n;
  public WadlParams b;
  public String c;
  public int d;
  public String e = "";
  public String f;
  public String g;
  public String h;
  public String i;
  public long j;
  public String k;
  public long l;
  
  static
  {
    try
    {
      m = DeviceInfoUtil.j();
      a = QQDeviceInfo.getIMEI("b84cf5");
      n = DeviceInfoUtil.c();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static WadlReportInfo a()
  {
    WadlReportInfo localWadlReportInfo = new WadlReportInfo();
    try
    {
      localWadlReportInfo.l = (DeviceInfoUtil.r() / 1048576L);
      localWadlReportInfo.k = String.valueOf(DeviceInfoUtil.q()[1]);
      localWadlReportInfo.c = "";
      localWadlReportInfo.d = 0;
      return localWadlReportInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localWadlReportInfo;
  }
  
  public String b()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(m))
        {
          String str1 = m;
          localJSONObject.put("androidId", str1);
          if (TextUtils.isEmpty(n)) {
            break label88;
          }
          str1 = n;
          localJSONObject.put("imsi", str1);
          localJSONObject.put("leftMemorySize", this.l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo
 * JD-Core Version:    0.7.0.1
 */