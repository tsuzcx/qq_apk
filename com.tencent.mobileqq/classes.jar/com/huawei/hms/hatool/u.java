package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u
{
  public String a;
  public String b;
  public String c;
  public List<q> d;
  public String e;
  
  public u(String paramString1, String paramString2, String paramString3, List<q> paramList, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
    this.e = paramString4;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    String str = c.f(paramString1, paramString2);
    if (TextUtils.isEmpty(str))
    {
      y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", new Object[] { paramString1, paramString2 });
      return "";
    }
    if ("oper".equals(paramString2)) {
      paramString1 = "{url}/common/hmshioperqrt";
    }
    for (;;)
    {
      return paramString1.replace("{url}", str);
      if ("maint".equals(paramString2))
      {
        paramString1 = "{url}/common/hmshimaintqrt";
      }
      else
      {
        if (!"diffprivacy".equals(paramString2)) {
          break;
        }
        paramString1 = "{url}/common/common2";
      }
    }
    return "";
  }
  
  public void a()
  {
    Object localObject1 = a(this.a, this.b);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!"preins".equals(this.b))) {}
    for (localObject1 = "collectUrl is empty";; localObject1 = "request body is empty")
    {
      y.e("hmsSdk", (String)localObject1);
      return;
      if ((!"_hms_config_tag".equals(this.a)) && (!"_openness_config_tag".equals(this.a))) {
        b();
      }
      localObject2 = d();
      if (localObject2 == null) {
        break label129;
      }
      localObject2 = a((r)localObject2);
      if (localObject2.length != 0) {
        break;
      }
    }
    localObject1 = new i0((byte[])localObject2, (String)localObject1, this.a, this.b, this.e, this.d);
    Object localObject2 = n0.a();
    break label157;
    label129:
    localObject1 = new l0(this.d, this.a, this.e, this.b);
    localObject2 = n0.b();
    label157:
    ((n0)localObject2).a((m0)localObject1);
  }
  
  public final byte[] a(r paramr)
  {
    try
    {
      paramr = paramr.a();
      if (paramr == null)
      {
        y.e("hmsSdk", "uploadEvents is null");
        return new byte[0];
      }
      paramr = r0.a(paramr.toString().getBytes("UTF-8"));
      return paramr;
    }
    catch (JSONException paramr)
    {
      break label41;
    }
    catch (UnsupportedEncodingException paramr)
    {
      label35:
      label41:
      label44:
      break label35;
    }
    paramr = "sendData(): getBytes - Unsupported coding format!!";
    break label44;
    paramr = "uploadEvents to json error";
    y.e("hmsSdk", paramr);
    return new byte[0];
  }
  
  public final void b()
  {
    if (p0.a(b.f(), "backup_event", 5242880))
    {
      y.d("hmsSdk", "backup file reach max limited size, discard new event ");
      return;
    }
    JSONArray localJSONArray = c();
    String str = s0.a(this.a, this.b, this.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update data cached into backup,spKey: ");
    localStringBuilder.append(str);
    y.c("hmsSdk", localStringBuilder.toString());
    g0.b(b.f(), "backup_event", str, localJSONArray.toString());
  }
  
  public final JSONArray c()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (q)localIterator.next();
      try
      {
        localObject = ((q)localObject).d();
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        label51:
        break label51;
      }
      y.c("hmsSdk", "handleEvents: json error,Abandon this data");
    }
    return localJSONArray;
  }
  
  public final r d()
  {
    return b1.a(this.d, this.a, this.b, this.e, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.u
 * JD-Core Version:    0.7.0.1
 */