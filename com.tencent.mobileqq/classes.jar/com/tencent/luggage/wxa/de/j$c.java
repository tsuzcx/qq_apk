package com.tencent.luggage.wxa.de;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$c
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  j$c(j paramj)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String arg2)
  {
    Intrinsics.checkParameterIsNotNull(???, "errMsg");
    if (paramBoolean) {
      synchronized (j.a(this.a))
      {
        Object localObject1 = ((Iterable)j.b(this.a)).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Function2)((Iterator)localObject1).next()).invoke(Boolean.valueOf(true), "");
        }
        j.b(this.a).clear();
        localObject1 = Unit.INSTANCE;
      }
    }
    synchronized (j.a(this.a))
    {
      Iterator localIterator = ((Iterable)j.b(this.a)).iterator();
      while (localIterator.hasNext()) {
        ((Function2)localIterator.next()).invoke(Boolean.valueOf(false), ???);
      }
      j.b(this.a).clear();
      ??? = Unit.INSTANCE;
      j.a(this.a, false);
      return;
    }
    for (;;)
    {
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.c
 * JD-Core Version:    0.7.0.1
 */