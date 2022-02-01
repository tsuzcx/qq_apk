package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.util.g;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ah
  extends b
{
  private c a;
  private String b;
  private Map<String, Object> c;
  private int d;
  
  public ah a(String paramString, Object paramObject)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    this.c.put(paramString, paramObject);
    return this;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(o paramo)
  {
    c localc = this.a;
    if (localc == null) {
      return;
    }
    localc.a(this, paramo);
  }
  
  public ah b(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.a = paramc;
    this.d = 0;
    return this;
  }
  
  public ah b(c paramc, int paramInt)
  {
    b(paramc);
    this.d = paramInt;
    return this;
  }
  
  public ah b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ah b(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    g.a(paramMap);
    this.c = paramMap;
    return this;
  }
  
  public String c()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.c;
    if (localObject != null)
    {
      g.a((Map)localObject);
      return new JSONObject(this.c).toString();
    }
    return null;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public final int f()
  {
    return this.a.getComponentId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ah
 * JD-Core Version:    0.7.0.1
 */