package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public abstract class j<CONTEXT extends b, Extension>
  extends a<CONTEXT>
{
  private final Class<Extension> a;
  
  protected j(Class<Extension> paramClass)
  {
    this.a = paramClass;
  }
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new j.1(this, paramCONTEXT, paramInt, paramJSONObject);
    if ((!(paramCONTEXT instanceof u)) && (paramCONTEXT.q().F()))
    {
      paramCONTEXT.q().c(paramJSONObject);
      return;
    }
    paramJSONObject.run();
  }
  
  protected abstract void a(@NonNull CONTEXT paramCONTEXT, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull Extension paramExtension);
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.j
 * JD-Core Version:    0.7.0.1
 */