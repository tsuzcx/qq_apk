package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/DisposableHandle;", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 15})
@DebugMetadata(c="androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f="CoroutineLiveData.kt", i={0}, l={94}, m="invokeSuspend", n={"$this$withContext"}, s={"L$0"})
final class LiveDataScopeImpl$emitSource$2
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super DisposableHandle>, Object>
{
  Object L$0;
  int label;
  private CoroutineScope p$;
  
  LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl paramLiveDataScopeImpl, LiveData paramLiveData, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 2(this.this$0, this.$source, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        return paramObject;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.p$;
    CoroutineLiveData localCoroutineLiveData = this.this$0.getTarget$lifecycle_livedata_ktx_release();
    LiveData localLiveData = this.$source;
    this.L$0 = paramObject;
    this.label = 1;
    paramObject = localCoroutineLiveData.emitSource$lifecycle_livedata_ktx_release(localLiveData, this);
    if (paramObject == localObject) {
      return localObject;
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveDataScopeImpl.emitSource.2
 * JD-Core Version:    0.7.0.1
 */