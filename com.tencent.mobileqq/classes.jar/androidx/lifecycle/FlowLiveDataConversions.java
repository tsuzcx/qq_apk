package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Landroidx/lifecycle/LiveData;", "asLiveData", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "timeoutInMs", "", "lifecycle-livedata-ktx_release"}, k=2, mv={1, 1, 15})
@JvmName(name="FlowLiveDataConversions")
public final class FlowLiveDataConversions
{
  @NotNull
  public static final <T> Flow<T> asFlow(@NotNull LiveData<T> paramLiveData)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$asFlow");
    return FlowKt.flow((Function2)new FlowLiveDataConversions.asFlow.1(paramLiveData, null));
  }
  
  @JvmOverloads
  @NotNull
  public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> paramFlow)
  {
    return asLiveData$default(paramFlow, null, 0L, 3, null);
  }
  
  @JvmOverloads
  @NotNull
  public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext)
  {
    return asLiveData$default(paramFlow, paramCoroutineContext, 0L, 2, null);
  }
  
  @JvmOverloads
  @NotNull
  public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramFlow, "$this$asLiveData");
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineLiveDataKt.liveData(paramCoroutineContext, paramLong, (Function2)new FlowLiveDataConversions.asLiveData.1(paramFlow, null));
  }
  
  @RequiresApi(26)
  @NotNull
  public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext, @NotNull Duration paramDuration)
  {
    Intrinsics.checkParameterIsNotNull(paramFlow, "$this$asLiveData");
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDuration, "timeout");
    return asLiveData(paramFlow, paramCoroutineContext, paramDuration.toMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.FlowLiveDataConversions
 * JD-Core Version:    0.7.0.1
 */