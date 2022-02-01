package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_TIMEOUT", "", "liveData", "Landroidx/lifecycle/LiveData;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Ljava/time/Duration;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "timeoutInMs", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "addDisposableSource", "Landroidx/lifecycle/EmittedSource;", "Landroidx/lifecycle/MediatorLiveData;", "source", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Block", "lifecycle-livedata-ktx_release"}, k=2, mv={1, 1, 15})
public final class CoroutineLiveDataKt
{
  public static final long DEFAULT_TIMEOUT = 5000L;
  
  @Nullable
  public static final <T> Object addDisposableSource(@NotNull MediatorLiveData<T> paramMediatorLiveData, @NotNull LiveData<T> paramLiveData, @NotNull Continuation<? super EmittedSource> paramContinuation)
  {
    return BuildersKt.withContext((CoroutineContext)Dispatchers.getMain().getImmediate(), (Function2)new CoroutineLiveDataKt.addDisposableSource.2(paramMediatorLiveData, paramLiveData, null), paramContinuation);
  }
  
  @NotNull
  public static final <T> LiveData<T> liveData(@NotNull CoroutineContext paramCoroutineContext, long paramLong, @BuilderInference @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    return (LiveData)new CoroutineLiveData(paramCoroutineContext, paramLong, paramFunction2);
  }
  
  @RequiresApi(26)
  @NotNull
  public static final <T> LiveData<T> liveData(@NotNull CoroutineContext paramCoroutineContext, @NotNull Duration paramDuration, @BuilderInference @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDuration, "timeout");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    return (LiveData)new CoroutineLiveData(paramCoroutineContext, paramDuration.toMillis(), paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.CoroutineLiveDataKt
 * JD-Core Version:    0.7.0.1
 */