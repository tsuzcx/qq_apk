package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

public class o
{
  private String A = "";
  private int B;
  private String C = "";
  private String D;
  private String E = "";
  private String a = "";
  private int b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q = "";
  private String r;
  private String s;
  private int t = r.a.ordinal();
  private String u = "";
  private String v = "";
  private String w = "";
  private int x = 0;
  private int y = 0;
  private String z;
  
  public o(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.r = new String(paramArrayOfByte1, ab.a);
    this.s = new String(paramArrayOfByte2, ab.a);
  }
  
  private JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
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
  
  private void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("group");
    HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.a);
    this.x = paramJSONObject.optInt("autoCancel", 1);
    HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
    this.y = paramJSONObject.optInt("visibility", 0);
    this.z = paramJSONObject.optString("when");
    this.A = paramJSONObject.optString("tag");
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("msgId"))
    {
      paramJSONObject = paramJSONObject.get("msgId");
      if ((paramJSONObject instanceof String)) {
        this.e = ((String)paramJSONObject);
      }
      for (;;)
      {
        return true;
        if ((paramJSONObject instanceof Integer)) {
          this.e = String.valueOf(((Integer)paramJSONObject).intValue());
        }
      }
    }
    HMSLog.i("PushSelfShowLog", "msgId == null");
    return false;
  }
  
  private void c(JSONObject paramJSONObject)
  {
    int i1 = 0;
    if (paramJSONObject.has("ap"))
    {
      paramJSONObject = paramJSONObject.getString("ap");
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!TextUtils.isEmpty(paramJSONObject)) && (paramJSONObject.length() < 48))
      {
        int i2 = paramJSONObject.length();
        while (i1 < 48 - i2)
        {
          localStringBuilder.append("0");
          i1 += 1;
        }
        localStringBuilder.append(paramJSONObject);
        this.d = localStringBuilder.toString();
      }
    }
    else
    {
      return;
    }
    this.d = paramJSONObject.substring(0, 48);
  }
  
  private boolean d(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("psContent"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("psContent");
      if (paramJSONObject != null) {
        break label22;
      }
    }
    label22:
    do
    {
      return false;
      this.g = paramJSONObject.getString("cmd");
      this.h = paramJSONObject.optString("content");
      this.i = paramJSONObject.optString("notifyIcon");
      this.j = paramJSONObject.optString("notifyTitle");
      this.k = paramJSONObject.optString("notifySummary");
      this.D = paramJSONObject.optString("ticker");
    } while (((paramJSONObject.has("notifyDetail")) && (!k(paramJSONObject))) || (!paramJSONObject.has("param")));
    return e(paramJSONObject);
  }
  
  private boolean e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("param");
      if (paramJSONObject.has("autoClear")) {}
      for (this.b = paramJSONObject.getInt("autoClear"); ("app".equals(this.g)) || ("cosa".equals(this.g)); this.b = 0)
      {
        f(paramJSONObject);
        break label121;
      }
      if (!"url".equals(this.g)) {
        break label102;
      }
    }
    catch (Exception paramJSONObject)
    {
      HMSLog.e("PushSelfShowLog", "ParseParam error ", paramJSONObject);
      return false;
    }
    g(paramJSONObject);
    break label121;
    label102:
    if ("rp".equals(this.g)) {
      h(paramJSONObject);
    }
    label121:
    return true;
  }
  
  private boolean f(JSONObject paramJSONObject)
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
  
  private boolean g(JSONObject paramJSONObject)
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
  
  private boolean h(JSONObject paramJSONObject)
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
  
  private JSONObject i(JSONObject paramJSONObject)
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
  
  private JSONObject j(JSONObject paramJSONObject)
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
  
  private boolean k(JSONObject paramJSONObject)
  {
    HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("notifyDetail");
      if (paramJSONObject == null) {
        return false;
      }
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
  
  private JSONObject y()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style", this.t);
    localJSONObject.put("bigTitle", this.u);
    localJSONObject.put("bigContent", this.v);
    localJSONObject.put("bigPic", this.w);
    return localJSONObject;
  }
  
  private JSONObject z()
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
  
  public String a()
  {
    HMSLog.d("PushSelfShowLog", "msgId =" + this.e);
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.B = paramInt;
  }
  
  public boolean b()
  {
    try
    {
      if (TextUtils.isEmpty(this.r))
      {
        HMSLog.d("PushSelfShowLog", "msg is null");
        return false;
      }
      JSONObject localJSONObject = new JSONObject(this.r);
      a(localJSONObject);
      localJSONObject = localJSONObject.getJSONObject("msgContent");
      if (localJSONObject == null)
      {
        HMSLog.i("PushSelfShowLog", "msgObj == null");
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
      HMSLog.d("PushSelfShowLog", "parse message exception.");
      return false;
      if (b(localJSONException))
      {
        this.f = localJSONException.optString("dispPkgName");
        c(localJSONException);
        this.B = localJSONException.optInt("notifyId", -1);
        this.C = localJSONException.optString("data");
        boolean bool = d(localJSONException);
        return bool;
      }
    }
    catch (Exception localException)
    {
      HMSLog.d("PushSelfShowLog", localException.toString());
    }
    return false;
  }
  
  public byte[] c()
  {
    try
    {
      byte[] arrayOfByte = i(a(j(z()), y())).toString().getBytes(ab.a);
      return arrayOfByte;
    }
    catch (JSONException localJSONException)
    {
      HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", localJSONException);
    }
    return new byte[0];
  }
  
  public byte[] d()
  {
    return this.s.getBytes(ab.a);
  }
  
  public String e()
  {
    return this.a;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public String i()
  {
    return this.f;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public String l()
  {
    return this.j;
  }
  
  public String m()
  {
    return this.l;
  }
  
  public String n()
  {
    return this.m;
  }
  
  public int o()
  {
    return this.t;
  }
  
  public String p()
  {
    return this.k;
  }
  
  public String q()
  {
    return this.u;
  }
  
  public String r()
  {
    return this.v;
  }
  
  public int s()
  {
    return this.x;
  }
  
  public String t()
  {
    return this.A;
  }
  
  public int u()
  {
    return this.B;
  }
  
  public String v()
  {
    return this.D;
  }
  
  public String w()
  {
    if (this.x == 1) {
      return a();
    }
    return String.valueOf(System.currentTimeMillis());
  }
  
  public String x()
  {
    return this.E;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.o
 * JD-Core Version:    0.7.0.1
 */