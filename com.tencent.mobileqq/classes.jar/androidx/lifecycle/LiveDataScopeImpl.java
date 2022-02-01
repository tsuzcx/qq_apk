package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "target", "Landroidx/lifecycle/CoroutineLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "latestValue", "getLatestValue", "()Ljava/lang/Object;", "getTarget$lifecycle_livedata_ktx_release", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/CoroutineLiveData;)V", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-livedata-ktx_release"}, k=1, mv={1, 1, 15})
public final class LiveDataScopeImpl<T>
  implements LiveDataScope<T>
{
  private final CoroutineContext coroutineContext;
  @NotNull
  private CoroutineLiveData<T> target;
  
  public LiveDataScopeImpl(@NotNull CoroutineLiveData<T> paramCoroutineLiveData, @NotNull CoroutineContext paramCoroutineContext)
  {
    this.target = paramCoroutineLiveData;
    this.coroutineContext = paramCoroutineContext.plus((CoroutineContext)Dispatchers.getMain().getImmediate());
  }
  
  @Nullable
  public Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return BuildersKt.withContext(this.coroutineContext, (Function2)new LiveDataScopeImpl.emit.2(this, paramT, null), paramContinuation);
  }
  
  @Nullable
  public Object emitSource(@NotNull LiveData<T> paramLiveData, @NotNull Continuation<? super DisposableHandle> paramContinuation)
  {
    return BuildersKt.withContext(this.coroutineContext, (Function2)new LiveDataScopeImpl.emitSource.2(this, paramLiveData, null), paramContinuation);
  }
  
  @Nullable
  public T getLatestValue()
  {
    return this.target.getValue();
  }
  
  @NotNull
  public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release()
  {
    return this.target;
  }
  
  public final void setTarget$lifecycle_livedata_ktx_release(@NotNull CoroutineLiveData<T> paramCoroutineLiveData)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineLiveData, "<set-?>");
    this.target = paramCoroutineLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveDataScopeImpl
 * JD-Core Version:    0.7.0.1
 */