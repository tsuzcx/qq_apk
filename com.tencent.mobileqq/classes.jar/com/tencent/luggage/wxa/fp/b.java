package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.hj.k;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/IsCollectionTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/luggage/wxa/storage/collection/IsCollectionTask$Parameter;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "Parameter", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements k<b.a, com.tencent.luggage.wxa.hu.a>
{
  @NotNull
  public com.tencent.luggage.wxa.hu.a a(@Nullable b.a parama)
  {
    boolean bool = false;
    if (parama != null)
    {
      g localg = (g)com.tencent.luggage.storage.b.a(g.class);
      if (localg != null) {
        bool = localg.a((com.tencent.luggage.wxa.rb.a)f.a(parama.a(), parama.b()), new String[0]);
      }
      return new com.tencent.luggage.wxa.hu.a(bool);
    }
    return new com.tencent.luggage.wxa.hu.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.b
 * JD-Core Version:    0.7.0.1
 */