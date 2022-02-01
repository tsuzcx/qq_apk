package com.tencent.luggage.wxa.fq;

import android.os.Bundle;
import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hu.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"}, k=3, mv={1, 1, 16})
final class j$a<InputType, ResultType>
  implements c<Bundle, d>
{
  public static final a a = new a();
  
  public final void a(Bundle paramBundle, e<d> parame)
  {
    long l = paramBundle.getLong("KEY_TIMESTAMP", 0L);
    paramBundle = paramBundle.getString("KEY_APPID", "");
    parame = j.a;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "appId");
    j.a(parame, l, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.j.a
 * JD-Core Version:    0.7.0.1
 */