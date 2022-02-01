package com.tencent.luggage.opensdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class g$a
{
  private String a;
  private String b;
  private int c;
  private String d;
  private int e;
  private boolean f;
  private boolean g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private JSONObject m;
  private String n;
  private String o;
  private int p;
  private String q;
  private String r;
  private String s;
  
  public a a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public a a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public a b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public a b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public a b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public a c(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  public a c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public a d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public a e(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public a f(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public a g(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public a h(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public a i(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public a j(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public a k(String paramString)
  {
    this.q = paramString;
    return this;
  }
  
  public a l(String paramString)
  {
    this.r = paramString;
    return this;
  }
  
  public a m(String paramString)
  {
    this.s = paramString;
    return this;
  }
  
  @NonNull
  public String toString()
  {
    JSONStringer localJSONStringer1 = new JSONStringer();
    for (;;)
    {
      try
      {
        localJSONStringer1.object();
        localJSONStringer1.key("runtimeAppid");
        localJSONStringer1.value(this.i);
        localJSONStringer1.key("runtimeTicket");
        localJSONStringer1.value(this.j);
        localJSONStringer1.key("runtimeSessionId");
        localJSONStringer1.value(this.k);
        localJSONStringer1.key("pathType");
        localJSONStringer1.value(this.e);
        localJSONStringer1.key("invokeData");
        JSONStringer localJSONStringer2 = new JSONStringer();
        localJSONStringer2.object();
        localJSONStringer2.key("name");
        localJSONStringer2.value(this.a);
        localJSONStringer2.key("args");
        localJSONStringer2.value(this.b);
        localJSONStringer2.key("isBridgedJsApi");
        localJSONStringer2.value(this.f);
        localJSONStringer2.key("jsapiType");
        localJSONStringer2.value(this.h);
        localJSONStringer2.key("isGame");
        localJSONStringer2.value(this.g);
        if (this.m != null)
        {
          localJSONStringer2.key("runtimeTransferAction");
          localJSONStringer2.value(this.m);
        }
        JSONStringer localJSONStringer3 = new JSONStringer();
        localJSONStringer3.object();
        localJSONStringer3.key("callbackId");
        localJSONStringer3.value(this.c);
        localJSONStringer3.key("callbackActivity");
        localJSONStringer3.value(this.d);
        localJSONStringer3.key("isBridgedJsApi");
        if (!this.f) {
          break label544;
        }
        l1 = 1L;
        localJSONStringer3.value(l1);
        localJSONStringer3.endObject();
        localJSONStringer2.key("transitiveData");
        localJSONStringer2.value(localJSONStringer3.toString());
        localJSONStringer2.key("miniprogramAppID");
        localJSONStringer2.value(this.l);
        localJSONStringer2.key("sessionId");
        localJSONStringer2.value(this.n);
        localJSONStringer2.key("instanceId");
        localJSONStringer2.value(this.o);
        localJSONStringer2.key("debugMode");
        localJSONStringer2.value(this.p);
        if (!TextUtils.isEmpty(this.q))
        {
          localJSONStringer2.key("path");
          localJSONStringer2.value(this.q);
        }
        if (!TextUtils.isEmpty(this.r))
        {
          localJSONStringer2.key("title");
          localJSONStringer2.value(this.r);
        }
        if (!TextUtils.isEmpty(this.s))
        {
          localJSONStringer2.key("currentH5Url");
          localJSONStringer2.value(this.s);
        }
        localJSONStringer2.endObject();
        localJSONStringer1.value(localJSONStringer2.toString());
        localJSONStringer1.endObject();
      }
      catch (JSONException localJSONException)
      {
        o.b("Luggage.OpenSDKBridgedJsApiParams", "JSONException:%s", new Object[] { localJSONException.getMessage() });
      }
      o.f("Luggage.OpenSDKBridgedJsApiParams", "req:%s", new Object[] { localJSONStringer1.toString() });
      return localJSONStringer1.toString();
      label544:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.g.a
 * JD-Core Version:    0.7.0.1
 */