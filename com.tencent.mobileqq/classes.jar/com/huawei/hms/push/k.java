package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  public String A = "";
  public int B;
  public String C = "";
  public String D;
  public String E = "";
  public String F = "";
  public String a = "";
  public int b;
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q = "";
  public String r;
  public String s;
  public int t = n.a.ordinal();
  public String u = "";
  public String v = "";
  public String w = "";
  public int x = 0;
  public int y = 0;
  public String z;
  
  public k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.r = new String(paramArrayOfByte1, w.a);
    this.s = new String(paramArrayOfByte2, w.a);
  }
  
  public String a()
  {
    return this.m;
  }
  
  public final JSONObject a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("msgContent", paramJSONObject);
    localJSONObject.put("group", this.a);
    localJSONObject.put("tag", this.A);
    localJSONObject.put("autoCancel", this.x);
    localJSONObject.put("visibility", this.y);
    localJSONObject.put("when", this.z);
    return localJSONObject;
  }
  
  public final JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("dispPkgName", this.f);
    localJSONObject.put("msgId", this.e);
    localJSONObject.put("ap", this.d);
    localJSONObject.put("notifyId", this.B);
    localJSONObject.put("psContent", paramJSONObject1);
    localJSONObject.put("notifyDetail", paramJSONObject2);
    localJSONObject.put("ticker", this.D);
    localJSONObject.put("data", this.C);
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    this.B = paramInt;
  }
  
  public String b()
  {
    return this.F;
  }
  
  public final JSONObject b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cmd", this.g);
    localJSONObject.put("content", this.h);
    localJSONObject.put("notifyIcon", this.i);
    localJSONObject.put("notifyTitle", this.j);
    localJSONObject.put("notifySummary", this.k);
    localJSONObject.put("param", paramJSONObject);
    return localJSONObject;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("ap"))
    {
      paramJSONObject = paramJSONObject.getString("ap");
      StringBuilder localStringBuilder = new StringBuilder();
      boolean bool = TextUtils.isEmpty(paramJSONObject);
      int i1 = 0;
      if ((!bool) && (paramJSONObject.length() < 48))
      {
        int i2 = paramJSONObject.length();
        while (i1 < 48 - i2)
        {
          localStringBuilder.append("0");
          i1 += 1;
        }
        localStringBuilder.append(paramJSONObject);
        this.d = localStringBuilder.toString();
        return;
      }
      this.d = paramJSONObject.substring(0, 48);
    }
  }
  
  public String d()
  {
    return this.l;
  }
  
  public final boolean d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (paramJSONObject.has("acn")) {
      this.m = paramJSONObject.getString("acn");
    }
    if (paramJSONObject.has("intentUri")) {
      this.c = paramJSONObject.getString("intentUri");
    }
    if (paramJSONObject.has("appPackageName"))
    {
      this.l = paramJSONObject.getString("appPackageName");
      return true;
    }
    HMSLog.d("PushSelfShowLog", "appPackageName is null");
    return false;
  }
  
  public int e()
  {
    return this.x;
  }
  
  public final boolean e(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("msgId"))
    {
      paramJSONObject = paramJSONObject.get("msgId");
      if ((paramJSONObject instanceof String)) {
        this.e = ((String)paramJSONObject);
      } else if ((paramJSONObject instanceof Integer)) {
        this.e = String.valueOf(((Integer)paramJSONObject).intValue());
      }
      return true;
    }
    HMSLog.i("PushSelfShowLog", "msgId == null");
    return false;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public final boolean f(JSONObject paramJSONObject)
  {
    HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("notifyDetail");
      if (paramJSONObject.has("style")) {
        this.t = paramJSONObject.getInt("style");
      }
      this.u = paramJSONObject.optString("bigTitle");
      this.v = paramJSONObject.optString("bigContent");
      this.E = paramJSONObject.optString("icon");
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      HMSLog.i("PushSelfShowLog", paramJSONObject.toString());
    }
    return false;
  }
  
  public String g()
  {
    return this.v;
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("group");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NOTIFY_GROUP:");
    localStringBuilder.append(this.a);
    HMSLog.d("PushSelfShowLog", localStringBuilder.toString());
    this.x = paramJSONObject.optInt("autoCancel", 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("autoCancel: ");
    localStringBuilder.append(this.x);
    HMSLog.d("PushSelfShowLog", localStringBuilder.toString());
    this.y = paramJSONObject.optInt("visibility", 0);
    this.z = paramJSONObject.optString("when");
    this.A = paramJSONObject.optString("tag");
  }
  
  public String h()
  {
    return this.u;
  }
  
  public final boolean h(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("param");
      if (paramJSONObject.has("autoClear")) {
        this.b = paramJSONObject.getInt("autoClear");
      } else {
        this.b = 0;
      }
      boolean bool = "app".equals(this.g);
      if (!bool)
      {
        bool = "cosa".equals(this.g);
        if (!bool)
        {
          if ("url".equals(this.g))
          {
            k(paramJSONObject);
            break label119;
          }
          if (!"rp".equals(this.g)) {
            break label119;
          }
          j(paramJSONObject);
          break label119;
        }
      }
      d(paramJSONObject);
      label119:
      return true;
    }
    catch (Exception paramJSONObject)
    {
      HMSLog.e("PushSelfShowLog", "ParseParam error ", paramJSONObject);
    }
    return false;
  }
  
  public String i()
  {
    return this.g;
  }
  
  public final boolean i(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("psContent"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("psContent");
      this.g = paramJSONObject.getString("cmd");
      this.h = paramJSONObject.optString("content");
      this.i = paramJSONObject.optString("notifyIcon");
      this.j = paramJSONObject.optString("notifyTitle");
      this.k = paramJSONObject.optString("notifySummary");
      this.D = paramJSONObject.optString("ticker");
      if ((paramJSONObject.has("notifyDetail")) && (!f(paramJSONObject))) {
        return false;
      }
      if (paramJSONObject.has("param")) {
        return h(paramJSONObject);
      }
    }
    return false;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public final boolean j(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (paramJSONObject.has("appPackageName")) {
      this.l = paramJSONObject.getString("appPackageName");
    }
    if ((paramJSONObject.has("rpt")) && (paramJSONObject.has("rpl")))
    {
      this.o = paramJSONObject.getString("rpl");
      this.p = paramJSONObject.getString("rpt");
      if (paramJSONObject.has("rpct")) {
        this.q = paramJSONObject.getString("rpct");
      }
      return true;
    }
    HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
    return false;
  }
  
  public String k()
  {
    return this.f;
  }
  
  public final boolean k(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (paramJSONObject.has("url"))
    {
      this.n = paramJSONObject.getString("url");
      if (paramJSONObject.has("appPackageName")) {
        this.l = paramJSONObject.getString("appPackageName");
      }
      if ((paramJSONObject.has("rpt")) && (paramJSONObject.has("rpl")))
      {
        this.o = paramJSONObject.getString("rpl");
        this.p = paramJSONObject.getString("rpt");
        if (paramJSONObject.has("rpct")) {
          this.q = paramJSONObject.getString("rpct");
        }
      }
      return true;
    }
    HMSLog.d("PushSelfShowLog", "url is null");
    return false;
  }
  
  public String l()
  {
    return this.a;
  }
  
  public String m()
  {
    return this.E;
  }
  
  public String n()
  {
    return this.c;
  }
  
  public byte[] o()
  {
    try
    {
      byte[] arrayOfByte = a(a(b(v()), r())).toString().getBytes(w.a);
      return arrayOfByte;
    }
    catch (JSONException localJSONException)
    {
      HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", localJSONException);
    }
    return new byte[0];
  }
  
  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgId =");
    localStringBuilder.append(this.e);
    HMSLog.d("PushSelfShowLog", localStringBuilder.toString());
    return this.e;
  }
  
  public String q()
  {
    return this.A;
  }
  
  public final JSONObject r()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style", this.t);
    localJSONObject.put("bigTitle", this.u);
    localJSONObject.put("bigContent", this.v);
    localJSONObject.put("bigPic", this.w);
    return localJSONObject;
  }
  
  public int s()
  {
    return this.B;
  }
  
  public String t()
  {
    return this.k;
  }
  
  public String u()
  {
    return this.j;
  }
  
  public final JSONObject v()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("autoClear", this.b);
    localJSONObject.put("url", this.n);
    localJSONObject.put("rpl", this.o);
    localJSONObject.put("rpt", this.p);
    localJSONObject.put("rpct", this.q);
    localJSONObject.put("appPackageName", this.l);
    localJSONObject.put("acn", this.m);
    localJSONObject.put("intentUri", this.c);
    return localJSONObject;
  }
  
  public int w()
  {
    return this.t;
  }
  
  public String x()
  {
    return this.D;
  }
  
  public byte[] y()
  {
    return this.s.getBytes(w.a);
  }
  
  public boolean z()
  {
    try
    {
      boolean bool = TextUtils.isEmpty(this.r);
      if (bool)
      {
        HMSLog.d("PushSelfShowLog", "msg is null");
        return false;
      }
      JSONObject localJSONObject = new JSONObject(this.r);
      g(localJSONObject);
      localJSONObject = localJSONObject.getJSONObject("msgContent");
      bool = e(localJSONObject);
      if (!bool) {
        return false;
      }
      this.f = localJSONObject.optString("dispPkgName");
      c(localJSONObject);
      this.B = localJSONObject.optInt("notifyId", -1);
      this.C = localJSONObject.optString("data");
      this.F = localJSONObject.optString("analyticInfo");
      bool = i(localJSONObject);
      return bool;
    }
    catch (Exception localException)
    {
      HMSLog.d("PushSelfShowLog", localException.toString());
      return false;
      HMSLog.d("PushSelfShowLog", "parse message exception.");
      return false;
    }
    catch (JSONException localJSONException)
    {
      label125:
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.k
 * JD-Core Version:    0.7.0.1
 */