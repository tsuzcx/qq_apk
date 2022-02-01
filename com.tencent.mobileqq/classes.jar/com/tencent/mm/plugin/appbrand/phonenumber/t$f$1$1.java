package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qw.it;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"}, k=3, mv={1, 1, 16})
final class t$f$1$1
  extends Lambda
  implements Function1<it, Unit>
{
  t$f$1$1(t.f.1 param1, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(1);
  }
  
  public final void a(@Nullable it paramit)
  {
    String str1 = t.a.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateUserPhone success:");
    boolean bool;
    if (paramit != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    o.d(str1, ((StringBuilder)localObject).toString());
    if (paramit != null)
    {
      paramit = s.a;
      str1 = this.a.a.c;
      localObject = this.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "showMobile");
      String str2 = this.c;
      Intrinsics.checkExpressionValueIsNotNull(str2, "encryptedData");
      String str3 = this.d;
      Intrinsics.checkExpressionValueIsNotNull(str3, "iv");
      paramit.b(new r(str1, (String)localObject, str2, str3, this.e, false, false, false, true, 224, null));
      t.c(this.a.a.a).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.f.1.1
 * JD-Core Version:    0.7.0.1
 */