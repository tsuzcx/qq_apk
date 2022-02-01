package com.tencent.mobileqq.apollo.meme.manager;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MemeBornPlayerManager$destroyForAccountChange$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  MemeBornPlayerManager$destroyForAccountChange$1()
  {
    super(0);
  }
  
  public final void invoke()
  {
    Lock localLock = (Lock)MemeBornPlayerManager.b(MemeBornPlayerManager.a);
    localLock.lock();
    try
    {
      MemeBornPlayerManager.e(MemeBornPlayerManager.a).clear();
      MemeBornPlayerManager.f(MemeBornPlayerManager.a).clear();
      MemeBornPlayerManager.d(MemeBornPlayerManager.a).clear();
      MemeBornPlayerManager.c(MemeBornPlayerManager.a).clear();
      MemeBornPlayerManager.a(MemeBornPlayerManager.a).clear();
      Unit localUnit = Unit.INSTANCE;
      localLock.unlock();
      MemeBornPlayerManager.a.b();
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.destroyForAccountChange.1
 * JD-Core Version:    0.7.0.1
 */