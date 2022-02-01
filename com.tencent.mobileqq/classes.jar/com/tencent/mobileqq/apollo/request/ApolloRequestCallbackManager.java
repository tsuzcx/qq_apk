package com.tencent.mobileqq.apollo.request;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestCallbackManager;", "", "()V", "mApolloRspCallbackMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestCallbackManager$ApolloRspCallback;", "Lkotlin/collections/HashMap;", "requestIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "handleRspCallBack", "", "callbackIndex", "success", "", "retCode", "errMsg", "", "recordApolloRspCallback", "callback", "intent", "Lmqq/app/NewIntent;", "ApolloRspCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloRequestCallbackManager
{
  public static final ApolloRequestCallbackManager a;
  private static final HashMap<Long, WeakReference<ApolloRequestCallbackManager.ApolloRspCallback>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloRequestApolloRequestCallbackManager = new ApolloRequestCallbackManager();
  }
  
  public final void a(long paramLong1, boolean paramBoolean, long paramLong2, @Nullable String paramString)
  {
    if (paramLong1 > 0L)
    {
      Object localObject = jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong1));
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = (ApolloRequestCallbackManager.ApolloRspCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloRequestCallbackManager.ApolloRspCallback)localObject).a(paramBoolean, paramLong2, paramString);
      }
    }
  }
  
  public final void a(@Nullable ApolloRequestCallbackManager.ApolloRspCallback paramApolloRspCallback, @NotNull NewIntent paramNewIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramNewIntent, "intent");
    if (paramApolloRspCallback != null)
    {
      long l = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.incrementAndGet();
      paramNewIntent.putExtra("index", l);
      ((Map)jdField_a_of_type_JavaUtilHashMap).put(Long.valueOf(l), new WeakReference(paramApolloRspCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager
 * JD-Core Version:    0.7.0.1
 */