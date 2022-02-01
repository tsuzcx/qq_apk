package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.listener.IApolloStatusOrDressChangeListener;
import com.tencent.mobileqq.apollo.listener.ITraceSpanMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/impl/ApolloMessageServiceImpl;", "Lcom/tencent/mobileqq/apollo/api/IApolloMessageService;", "()V", "appRuntime", "Lmqq/app/AppRuntime;", "listenerMap", "", "Lcom/tencent/mobileqq/apollo/api/impl/ApolloMessageServiceImpl$Companion$MessageType;", "", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "addListener", "", "type", "listener", "apolloStatusOrDressChange", "", "uinList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getListeners", "onCreate", "runtime", "onDestroy", "removeListener", "reportTraceSpanMsg", "errCode", "msg", "", "(I[Ljava/lang/Object;)V", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloMessageServiceImpl
  implements IApolloMessageService
{
  public static final ApolloMessageServiceImpl.Companion Companion = new ApolloMessageServiceImpl.Companion(null);
  @NotNull
  public static final String TAG = "ApolloMessageServiceImpl";
  private AppRuntime appRuntime;
  private final Map<ApolloMessageServiceImpl.Companion.MessageType, List<Object>> listenerMap = (Map)new LinkedHashMap();
  private final ReentrantLock lock = new ReentrantLock();
  
  private final List<Object> getListeners(ApolloMessageServiceImpl.Companion.MessageType paramMessageType)
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      if (this.listenerMap.get(paramMessageType) == null) {
        this.listenerMap.put(paramMessageType, (List)new ArrayList());
      }
      paramMessageType = this.listenerMap.get(paramMessageType);
      if (paramMessageType == null) {
        Intrinsics.throwNpe();
      }
      paramMessageType = (List)paramMessageType;
      return paramMessageType;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void addListener(@NotNull ApolloMessageServiceImpl.Companion.MessageType paramMessageType, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageType, "type");
    Intrinsics.checkParameterIsNotNull(paramObject, "listener");
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      paramMessageType = getListeners(paramMessageType);
      if (!paramMessageType.contains(paramObject)) {
        paramMessageType.add(paramObject);
      }
      paramMessageType = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void apolloStatusOrDressChange(int paramInt, @NotNull ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "uinList");
    Iterator localIterator = ((Iterable)CollectionsKt.toMutableList((Collection)getListeners(ApolloMessageServiceImpl.Companion.MessageType.STATE_OR_DRESS_CHANGE))).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject != null) {}
      try
      {
        ((IApolloStatusOrDressChangeListener)localObject).a(paramInt, paramArrayList);
      }
      catch (Exception localException)
      {
        label75:
        break label75;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.listener.IApolloStatusOrDressChangeListener");
      QLog.e("ApolloMessageServiceImpl", 1, "apolloStatusOrDressChange exception:", localObject);
    }
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "runtime");
    this.appRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.appRuntime = ((AppRuntime)null);
    this.listenerMap.clear();
  }
  
  public final void removeListener(@NotNull ApolloMessageServiceImpl.Companion.MessageType paramMessageType, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageType, "type");
    Intrinsics.checkParameterIsNotNull(paramObject, "listener");
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      paramMessageType = (List)this.listenerMap.get(paramMessageType);
      if (paramMessageType != null) {
        paramMessageType.remove(paramObject);
      }
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void reportTraceSpanMsg(int paramInt, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "msg");
    Iterator localIterator = ((Iterable)CollectionsKt.toMutableList((Collection)getListeners(ApolloMessageServiceImpl.Companion.MessageType.TRACE_SPAN_MESSAGE))).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject != null) {}
      try
      {
        ((ITraceSpanMessage)localObject).a(paramInt, new Object[] { paramVarArgs });
      }
      catch (Exception localException)
      {
        label82:
        break label82;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.listener.ITraceSpanMessage");
      QLog.e("ApolloMessageServiceImpl", 1, "reportTraceSpanMsg exception:", localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl
 * JD-Core Version:    0.7.0.1
 */