package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab
{
  private String a;
  private String b;
  private String c;
  private List<w> d;
  private String e;
  
  public ab(String paramString1, String paramString2, String paramString3, List<w> paramList, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
    this.e = paramString4;
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = c.c(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {
      af.a("DataReportHandler", "No report address,TAG : %s,TYPE: %s ", new Object[] { paramString1, paramString2 });
    }
    do
    {
      return "";
      if ("oper".equals(paramString2)) {
        return "{url}/common/hmshioperqrt".replace("{url}", str);
      }
      if ("maint".equals(paramString2)) {
        return "{url}/common/hmshimaintqrt".replace("{url}", str);
      }
    } while (!"diffprivacy".equals(paramString2));
    return "{url}/common/common2".replace("{url}", str);
  }
  
  private byte[] a(x paramx)
  {
    try
    {
      paramx = paramx.c();
      if (paramx == null)
      {
        af.c("DataReportHandler", "uploadEvents is null");
        return new byte[0];
      }
      paramx = ba.a(paramx.toString().getBytes("UTF-8"));
      return paramx;
    }
    catch (JSONException paramx)
    {
      af.c("DataReportHandler", "uploadEvents to json error");
      return new byte[0];
    }
    catch (UnsupportedEncodingException paramx)
    {
      for (;;)
      {
        af.c("DataReportHandler", "sendData(): getBytes - Unsupported coding format!!");
      }
    }
  }
  
  private JSONArray b()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (w)localIterator.next();
      try
      {
        localObject = ((w)localObject).d();
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        af.b("DataReportHandler", "handleEvents: json error,Abandon this data");
      }
    }
    return localJSONArray;
  }
  
  private void c()
  {
    if (ay.a(b.j(), "backup_event", 5242880))
    {
      af.b("DataReportHandler", "backup file reach max limited size, discard new event ");
      return;
    }
    JSONArray localJSONArray = b();
    String str = bb.a(this.a, this.b, this.e);
    af.b("DataReportHandler", "Update data cached into backup,spKey: " + str);
    ap.a(b.j(), "backup_event", str, localJSONArray.toString());
  }
  
  private x d()
  {
    return bk.a(this.d, this.a, this.b, this.e, this.c);
  }
  
  public void a()
  {
    Object localObject1 = a(this.a, this.b);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!"preins".equals(this.b)))
    {
      af.c("DataReportHandler", "collectUrl is empty");
      return;
    }
    if ((!"_hms_config_tag".equals(this.a)) && (!"_openness_config_tag".equals(this.a))) {
      c();
    }
    Object localObject2 = d();
    if (localObject2 != null)
    {
      localObject2 = a((x)localObject2);
      if (localObject2.length == 0)
      {
        af.c("DataReportHandler", "request body is empty");
        return;
      }
      localObject1 = new ar((byte[])localObject2, (String)localObject1, this.a, this.b, this.e, this.d);
      aw.b().a((av)localObject1);
      return;
    }
    localObject1 = new au(this.d, this.a, this.e, this.b);
    aw.a().a((av)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ab
 * JD-Core Version:    0.7.0.1
 */