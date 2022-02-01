package com.tencent.luggage.wxa.er;

import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.dd.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/login/account/MMDeviceID;", "invoke"}, k=3, mv={1, 1, 16})
final class c$a
  extends Lambda
  implements Function0<e>
{
  public static final a a = new a();
  
  c$a()
  {
    super(0);
  }
  
  @NotNull
  public final e a()
  {
    Object localObject1 = r.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "MMApplicationContext.getProcessName()");
    Object localObject2 = r.b();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MMApplicationContext.getPackageName()");
    localObject1 = StringsKt.replaceFirst$default((String)localObject1, (String)localObject2, "", false, 4, null);
    int i;
    if (((CharSequence)localObject1).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = ":main";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i.a.c());
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = new e(((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ISOLATE_ID created ");
    ((StringBuilder)localObject2).append(localObject1);
    o.d("Luggage.WxaMMKVStorageManager", ((StringBuilder)localObject2).toString());
    i.a.a((b.a)new c.a.a((e)localObject1));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.er.c.a
 * JD-Core Version:    0.7.0.1
 */