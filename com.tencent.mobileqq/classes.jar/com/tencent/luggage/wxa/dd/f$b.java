package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/login/account/SessionInfo;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class f$b<_Ret, _Var>
  implements b<_Ret, _Var>
{
  f$b(f paramf) {}
  
  @Nullable
  public final g a(Void paramVoid)
  {
    if (!this.a.g()) {
      return null;
    }
    paramVoid = this.a.f();
    if (paramVoid.i() <= 0) {
      return paramVoid;
    }
    paramVoid = h.c();
    c.a.a(this.a.f(), (b.c)new f.b.1(this, paramVoid));
    return new g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.f.b
 * JD-Core Version:    0.7.0.1
 */