package com.tencent.luggage.standalone_ext.service;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.bp.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.c.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import org.json.JSONException;
import org.json.JSONObject;

public class b<SERVICE extends com.tencent.luggage.wxa.du.c>
  extends com.tencent.luggage.wxa.bp.a<SERVICE>
{
  private com.tencent.luggage.wxa.of.a a = null;
  
  public b(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
  }
  
  protected d a(SERVICE paramSERVICE, s params)
  {
    return new g(paramSERVICE, params);
  }
  
  protected i a(String paramString, byte[] paramArrayOfByte)
  {
    c.a locala = new c.a();
    locala.a = paramString;
    locala.b = paramArrayOfByte;
    locala.c = "1";
    locala.d = true;
    locala.f = true;
    locala.g = false;
    paramString = new v(locala);
    this.a = new c();
    this.a.a((h)y(), paramString);
    return paramString;
  }
  
  public void b(@NonNull JSONObject paramJSONObject)
  {
    super.b(paramJSONObject);
    try
    {
      paramJSONObject.put("JSEngineName", com.tencent.luggage.wxa.dv.b.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime()));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      o.a("Luggage.MGameServiceLogic", paramJSONObject, "attachCommonConfig error", new Object[0]);
    }
  }
  
  protected void h()
  {
    super.h();
    com.tencent.luggage.wxa.of.a locala = this.a;
    if (locala != null) {
      locala.a();
    }
  }
  
  protected String i()
  {
    return com.tencent.luggage.wxa.en.c.a.a();
  }
  
  protected String s()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("var openInvokeHandlerJsBinding = true;");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(super.s());
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (this.a != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(this.a.b());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.b
 * JD-Core Version:    0.7.0.1
 */