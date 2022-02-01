package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ac;
import com.tencent.luggage.wxa.qw.ca;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "items", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"}, k=3, mv={1, 1, 16})
final class i$c
  extends Lambda
  implements Function1<ca[], Unit>
{
  i$c(Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void a(@NotNull ca[] paramArrayOfca)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfca, "items");
    Function1 localFunction1 = this.a;
    ac localac = new ac();
    int j = paramArrayOfca.length;
    int i = 0;
    while (i < j)
    {
      ca localca = paramArrayOfca[i];
      if (localca != null) {
        localac.a.add(localca);
      }
      i += 1;
    }
    localFunction1.invoke(localac);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.i.c
 * JD-Core Version:    0.7.0.1
 */