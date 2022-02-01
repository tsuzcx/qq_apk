package com.tencent.luggage.opensdk;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.h;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class a$c
{
  public a.a a;
  public String b;
  public String c;
  public int d;
  public int e;
  
  @Nullable
  public d<String> a()
  {
    m localm = this.a.a(this.b);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.c);
    }
    catch (JSONException localJSONException)
    {
      o.b("Luggage.BridgedJsApiInvokeProtocol.Request", "makeBridgedParams, args(%s)->argsJson failed by %s", new Object[] { this.c, localJSONException });
      localJSONObject2 = new JSONObject();
    }
    if ((localm instanceof f))
    {
      Object localObject = this.a;
      if ((localObject instanceof a.b))
      {
        localObject = ((a.b)localObject).i();
        return ((f)localm).a((b)localObject, localJSONObject2, this.d);
      }
    }
    return h.a(f.a(this.a, this.b, localJSONObject2, this.d).toString());
  }
  
  @NotNull
  public String toString()
  {
    return String.format(Locale.ENGLISH, "[appId:%s,api:%s,scene:%d,callbackId:%d]", new Object[] { this.a.a(), this.b, Integer.valueOf(this.e), Integer.valueOf(this.d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.a.c
 * JD-Core Version:    0.7.0.1
 */