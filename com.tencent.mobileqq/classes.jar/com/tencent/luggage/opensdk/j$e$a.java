package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"logi", "", "str", "", "invoke", "com/tencent/luggage/opensdk/OpenSDKTicketTransferResponseStepChecker$startCheck$2$1$1"}, k=3, mv={1, 1, 16})
final class j$e$a
  extends Lambda
  implements Function1<String, Unit>
{
  j$e$a(int paramInt, j.e parame, CoroutineScope paramCoroutineScope)
  {
    super(1);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    j.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check() with request:");
    localStringBuilder.append(j.c(this.b.k));
    localStringBuilder.append(" ticket:");
    localStringBuilder.append(j.d(this.b.k));
    localStringBuilder.append(" step:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    o.d("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.j.e.a
 * JD-Core Version:    0.7.0.1
 */