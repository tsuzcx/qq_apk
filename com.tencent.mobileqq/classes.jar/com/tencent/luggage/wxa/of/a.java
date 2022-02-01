package com.tencent.luggage.wxa.of;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.od.b;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;

public class a
{
  @Nullable
  private b a;
  
  public void a()
  {
    o.d("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    b localb = this.a;
    if (localb != null)
    {
      localb.a();
      return;
    }
    throw new IllegalStateException("You had not called whenCreateJsRuntime!");
  }
  
  public void a(@Nullable h paramh, @NonNull i parami)
  {
    o.d("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.a = new b(paramh, parami);
    parami.addJavascriptInterface(this.a, "gJavaBroker");
  }
  
  protected void a(@NonNull StringBuffer paramStringBuffer) {}
  
  public String b()
  {
    if (this.a != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      a(localStringBuffer);
      localStringBuffer.append(c());
      return localStringBuffer.toString();
    }
    throw new IllegalStateException("You had not called whenCreateJsRuntime!");
  }
  
  protected String c()
  {
    return c.a("wxa_library/node_jsapi.js");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.of.a
 * JD-Core Version:    0.7.0.1
 */