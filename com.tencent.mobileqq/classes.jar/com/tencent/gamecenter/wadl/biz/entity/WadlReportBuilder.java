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
  public int b = 0;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  public String i;
  public HashMap<Integer, String> j = new HashMap();
  
  public WadlReportBuilder()
  {
    this.j.put(Integer.valueOf(1), "55801");
    this.j.put(Integer.valueOf(3), "1");
    this.j.put(Integer.valueOf(11), "4");
    this.j.put(Integer.valueOf(12), "430");
    this.j.put(Integer.valueOf(14), Build.MODEL);
    this.j.put(Integer.valueOf(15), Build.VERSION.RELEASE);
  }
  
  public WadlReportBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public WadlReportBuilder a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= a)) {
      this.j.put(Integer.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public WadlReportBuilder a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a()
  {
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC(this);
  }
  
  public WadlReportBuilder b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public JSONObject b(int paramInt)
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
        localJSONObject3.put("sq_ver", "8.8.17");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        int m = HttpUtil.getNetWorkType();
        if (m >= 0)
        {
          k = m;
          if (m < AppConstants.NET_TYPE_NAME.length)
          {
            localJSONObject3.put("net_type", AppConstants.NET_TYPE_NAME[k]);
            localJSONObject3.put("resolution", GameCenterUtil.d());
            localJSONObject3.put("is_red_point", "0");
            localJSONObject3.put("is_new_status", "0");
            localJSONObject3.put("gamecenter_src", "1");
            localJSONObject3.put("ret_id", String.valueOf(this.f));
            if (!TextUtils.isEmpty(this.e)) {
              localJSONObject3.put("oper_moudle", this.e);
            }
            if (!TextUtils.isEmpty(this.d)) {
              localJSONObject3.put("oper_id", this.d);
            }
            if (!TextUtils.isEmpty(this.g)) {
              localJSONObject3.put("gameappid", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
              localJSONObject3.put("tianji_report_str", this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
              localJSONObject3.put("apk_volume", this.i);
            }
            Iterator localIterator = this.j.entrySet().iterator();
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
            localJSONObject2.put("dc_id", this.c);
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
      int k = 0;
    }
  }
  
  public WadlReportBuilder c(String paramString)
  {
    this.d = paramString;
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
    this.e = paramString;
    return this;
  }
  
  public WadlReportBuilder i(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public WadlReportBuilder j(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[dcId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",operId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",operModule=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder
 * JD-Core Version:    0.7.0.1
 */