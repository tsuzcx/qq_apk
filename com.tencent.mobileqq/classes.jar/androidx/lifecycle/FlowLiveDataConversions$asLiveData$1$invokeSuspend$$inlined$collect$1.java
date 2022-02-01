package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 15})
public final class FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1
  implements FlowCollector<T>
{
  public FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1(LiveDataScope paramLiveDataScope) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1.1))
    {
      localObject1 = (FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1.1)paramContinuation;
      if ((((FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = paramContinuation.L$3;
        paramObject = (Continuation)paramContinuation.L$2;
        paramObject = paramContinuation.L$1;
        paramObject = (1)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      localObject1 = (Continuation)paramContinuation;
      LiveDataScope localLiveDataScope = this.$this_liveData$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localObject1;
      paramContinuation.L$3 = paramObject;
      paramContinuation.label = 1;
      if (localLiveDataScope.emit(paramObject, paramContinuation) == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.invokeSuspend..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */