package com.tencent.luggage.wxa.de;

import android.os.Parcelable;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class k$b<_Ret, _Var>
  implements b<_Ret, _Var>
{
  k$b(k paramk, int paramInt, String paramString, b.y paramy, a parama, Class paramClass) {}
  
  @Nullable
  public final Void a(Void paramVoid)
  {
    paramVoid = com.tencent.luggage.wxa.ro.h.c();
    String str1 = r.i();
    int i = this.b;
    String str2 = this.c;
    b.y localy = this.d;
    a locala = this.e;
    String str3 = this.f.getName();
    Intrinsics.checkExpressionValueIsNotNull(str3, "respClazz.name");
    com.tencent.luggage.wxa.hj.h.a(str1, (Parcelable)new com.tencent.luggage.wxa.df.e(i, str2, localy, locala, str3), new k.b.1().getClass(), (com.tencent.luggage.wxa.hj.e)new k.b.2(this, paramVoid));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.k.b
 * JD-Core Version:    0.7.0.1
 */