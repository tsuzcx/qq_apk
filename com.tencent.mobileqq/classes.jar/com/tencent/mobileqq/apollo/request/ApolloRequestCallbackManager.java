package com.tencent.mobileqq.apollo.request;

import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestCallbackManager;", "", "()V", "mApolloRspCallbackMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/apollo/listener/ApolloRspCallback;", "Lkotlin/collections/HashMap;", "requestIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "handleRspCallBack", "", "callbackIndex", "success", "", "retCode", "errMsg", "", "recordApolloRspCallback", "callback", "intent", "Lmqq/app/NewIntent;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloRequestCallbackManager
{
  public static final ApolloRequestCallbackManager a = new ApolloRequestCallbackManager();
  private static final HashMap<Long, WeakReference<ApolloRspCallback>> b = new HashMap();
  private static final AtomicLong c = new AtomicLong(0L);
  
  public final void a(long paramLong1, boolean paramBoolean, long paramLong2, @Nullable String paramString)
  {
    if (paramLong1 > 0L)
    {
      Object localObject = b.remove(Long.valueOf(paramLong1));
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = (ApolloRspCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloRspCallback)localObject).a(paramBoolean, paramLong2, paramString);
      }
    }
  }
  
  public final void a(@Nullable ApolloRspCallback paramApolloRspCallback, @NotNull NewIntent paramNewIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramNewIntent, "intent");
    if (paramApolloRspCallback != null)
    {
      long l = c.incrementAndGet();
      paramNewIntent.putExtra("index", l);
      ((Map)b).put(Long.valueOf(l), new WeakReference(paramApolloRspCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager
 * JD-Core Version:    0.7.0.1
 */