package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "mediator", "Landroidx/lifecycle/MediatorLiveData;", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "disposed", "", "dispose", "", "disposeNow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSource", "lifecycle-livedata-ktx_release"}, k=1, mv={1, 1, 15})
public final class EmittedSource
  implements DisposableHandle
{
  private boolean disposed;
  private final MediatorLiveData<?> mediator;
  private final LiveData<?> source;
  
  public EmittedSource(@NotNull LiveData<?> paramLiveData, @NotNull MediatorLiveData<?> paramMediatorLiveData)
  {
    this.source = paramLiveData;
    this.mediator = paramMediatorLiveData;
  }
  
  @MainThread
  private final void removeSource()
  {
    if (!this.disposed)
    {
      this.mediator.removeSource(this.source);
      this.disposed = true;
    }
  }
  
  public void dispose()
  {
    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().getImmediate()), null, null, (Function2)new EmittedSource.dispose.1(this, null), 3, null);
  }
  
  @Nullable
  public final Object disposeNow(@NotNull Continuation<? super Unit> paramContinuation)
  {
    return BuildersKt.withContext((CoroutineContext)Dispatchers.getMain().getImmediate(), (Function2)new EmittedSource.disposeNow.2(this, null), paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.EmittedSource
 * JD-Core Version:    0.7.0.1
 */