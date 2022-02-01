package com.tencent.luggage.wxa.ea;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "run"}, k=3, mv={1, 1, 16})
final class c$a$a
  implements Runnable
{
  public static final a a = new a();
  
  public final void run()
  {
    Iterator localIterator = ((Iterable)c.c.b().d()).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.c.a.a
 * JD-Core Version:    0.7.0.1
 */