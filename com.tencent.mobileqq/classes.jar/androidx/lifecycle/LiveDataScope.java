package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/LiveDataScope;", "T", "", "latestValue", "getLatestValue", "()Ljava/lang/Object;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-livedata-ktx_release"}, k=1, mv={1, 1, 15})
public abstract interface LiveDataScope<T>
{
  @Nullable
  public abstract Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation);
  
  @Nullable
  public abstract Object emitSource(@NotNull LiveData<T> paramLiveData, @NotNull Continuation<? super DisposableHandle> paramContinuation);
  
  @Nullable
  public abstract T getLatestValue();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveDataScope
 * JD-Core Version:    0.7.0.1
 */