package com.tencent.luggage.wxa.er;

import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.dd.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/login/account/MMDeviceID;", "invoke"}, k=3, mv={1, 1, 16})
final class c$b
  extends Lambda
  implements Function0<e>
{
  public static final b a = new b();
  
  c$b()
  {
    super(0);
  }
  
  @NotNull
  public final e a()
  {
    e locale = new e(i.a.c());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SHARE_ID createdy ");
    localStringBuilder.append(locale);
    o.d("Luggage.WxaMMKVStorageManager", localStringBuilder.toString());
    if (r.h()) {
      i.a.a((b.a)new c.b.a(locale));
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.er.c.b
 * JD-Core Version:    0.7.0.1
 */