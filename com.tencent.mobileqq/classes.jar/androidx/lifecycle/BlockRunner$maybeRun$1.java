package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 15})
@DebugMetadata(c="androidx.lifecycle.BlockRunner$maybeRun$1", f="CoroutineLiveData.kt", i={0, 0}, l={176}, m="invokeSuspend", n={"$this$launch", "liveDataScope"}, s={"L$0", "L$1"})
final class BlockRunner$maybeRun$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private CoroutineScope p$;
  
  BlockRunner$maybeRun$1(BlockRunner paramBlockRunner, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.this$0, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
        localObject = (LiveDataScopeImpl)this.L$1;
        localObject = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      LiveDataScopeImpl localLiveDataScopeImpl = new LiveDataScopeImpl(BlockRunner.access$getLiveData$p(this.this$0), paramObject.getCoroutineContext());
      Function2 localFunction2 = BlockRunner.access$getBlock$p(this.this$0);
      this.L$0 = paramObject;
      this.L$1 = localLiveDataScopeImpl;
      this.label = 1;
      if (localFunction2.invoke(localLiveDataScopeImpl, this) == localObject) {
        return localObject;
      }
    }
    BlockRunner.access$getOnDone$p(this.this$0).invoke();
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.BlockRunner.maybeRun.1
 * JD-Core Version:    0.7.0.1
 */