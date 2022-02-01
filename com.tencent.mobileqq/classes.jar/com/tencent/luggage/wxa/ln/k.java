package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.jx.c;
import org.json.JSONObject;

@Deprecated
public abstract class k<CONTEXT extends c, EXTENSION>
  extends com.tencent.luggage.wxa.jx.u<CONTEXT>
{
  private final Class<EXTENSION> a;
  
  protected k(Class<EXTENSION> paramClass)
  {
    this.a = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    com.tencent.mm.plugin.appbrand.page.u localu = bd.a(paramCONTEXT);
    if (localu == null) {
      return b("fail:page don't exist");
    }
    if (paramJSONObject == null) {
      return b("fail:invalid data");
    }
    Object localObject = localu.d(this.a);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localu.d()) {
      return b("fail:interrupted");
    }
    if (!localu.L()) {
      return b("fail:not supported");
    }
    throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.a.getName() }));
  }
  
  protected abstract String a(@NonNull CONTEXT paramCONTEXT, @NonNull JSONObject paramJSONObject, @NonNull EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.k
 * JD-Core Version:    0.7.0.1
 */