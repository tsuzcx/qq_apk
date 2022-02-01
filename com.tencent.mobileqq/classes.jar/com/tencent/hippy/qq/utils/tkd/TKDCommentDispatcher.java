package com.tencent.hippy.qq.utils.tkd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher;", "", "()V", "hippyCommentEvents", "Ljava/util/ArrayList;", "Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "Lkotlin/collections/ArrayList;", "getHippyCommentEvents", "()Ljava/util/ArrayList;", "addEventListener", "", "hippyCommentEvent", "getEvent", "getHippyCommetnProxyImpl", "removeEventListener", "HippyCommentEvent", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentDispatcher
{
  public static final TKDCommentDispatcher INSTANCE = new TKDCommentDispatcher();
  @NotNull
  private static final ArrayList<TKDCommentDispatcher.HippyCommentEvent> hippyCommentEvents = new ArrayList();
  
  public final void addEventListener(@NotNull TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyCommentEvent, "hippyCommentEvent");
    if (!hippyCommentEvents.contains(paramHippyCommentEvent)) {
      hippyCommentEvents.add(paramHippyCommentEvent);
    }
  }
  
  @NotNull
  public final TKDCommentDispatcher.HippyCommentEvent getEvent()
  {
    Object localObject = getHippyCommetnProxyImpl();
    localObject = Proxy.newProxyInstance(localObject.getClass().getClassLoader(), localObject.getClass().getInterfaces(), (InvocationHandler)new HippyCommentEventProxy((List)hippyCommentEvents));
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent");
    }
    return (TKDCommentDispatcher.HippyCommentEvent)localObject;
  }
  
  @NotNull
  public final ArrayList<TKDCommentDispatcher.HippyCommentEvent> getHippyCommentEvents()
  {
    return hippyCommentEvents;
  }
  
  @NotNull
  public final TKDCommentDispatcher.HippyCommentEvent getHippyCommetnProxyImpl()
  {
    return (TKDCommentDispatcher.HippyCommentEvent)new TKDCommentDispatcher.getHippyCommetnProxyImpl.1();
  }
  
  public final void removeEventListener(@NotNull TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyCommentEvent, "hippyCommentEvent");
    hippyCommentEvents.remove(paramHippyCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher
 * JD-Core Version:    0.7.0.1
 */