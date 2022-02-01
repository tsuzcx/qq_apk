package com.tencent.luggage.wxa.lb;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.ny.c;
import com.tencent.luggage.wxa.qz.o;

class a$2
  implements com.tencent.luggage.wxa.ny.a.a
{
  a$2(a parama, String paramString1, h paramh, String paramString2) {}
  
  public void a(@NonNull c paramc)
  {
    o.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { this.a, paramc.toString() });
    a.a.a(this.b, this.c, "progressUpdate", this.a, paramc.a(), paramc.b(), paramc.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lb.a.2
 * JD-Core Version:    0.7.0.1
 */