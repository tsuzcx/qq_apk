package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Lkotlin.Unit;>;
import kotlin.coroutines.Continuation<-Lkotlinx.coroutines.DisposableHandle;>;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k=1, mv={1, 1, 15})
public final class CoroutineLiveData<T>
  extends MediatorLiveData<T>
{
  private BlockRunner<T> blockRunner;
  private EmittedSource emittedSource;
  
  public CoroutineLiveData(@NotNull CoroutineContext paramCoroutineContext, long paramLong, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    CompletableJob localCompletableJob = SupervisorKt.SupervisorJob((Job)paramCoroutineContext.get((CoroutineContext.Key)Job.Key));
    this.blockRunner = new BlockRunner(this, paramFunction2, paramLong, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(paramCoroutineContext).plus((CoroutineContext)localCompletableJob)), (Function0)new CoroutineLiveData.1(this));
  }
  
  @Nullable
  public final Object clearSource$lifecycle_livedata_ktx_release(@NotNull Continuation<? super Unit> paramContinuation)
  {
    if ((paramContinuation instanceof CoroutineLiveData.clearSource.1))
    {
      localObject1 = (CoroutineLiveData.clearSource.1)paramContinuation;
      if ((((CoroutineLiveData.clearSource.1)localObject1).label & 0x80000000) != 0)
      {
        ((CoroutineLiveData.clearSource.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Unit>)localObject1;
        break label48;
      }
    }
    paramContinuation = new CoroutineLiveData.clearSource.1(this, paramContinuation);
    label48:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramContinuation = (CoroutineLiveData)paramContinuation.L$0;
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
      localObject1 = this.emittedSource;
      if (localObject1 == null) {
        break label145;
      }
      paramContinuation.L$0 = this;
      paramContinuation.label = 1;
      localObject1 = ((EmittedSource)localObject1).disposeNow(paramContinuation);
      if (localObject1 == localObject2) {
        return localObject2;
      }
      paramContinuation = this;
    }
    localObject1 = (Unit)localObject1;
    break label147;
    label145:
    paramContinuation = this;
    label147:
    paramContinuation.emittedSource = ((EmittedSource)null);
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object emitSource$lifecycle_livedata_ktx_release(@NotNull LiveData<T> paramLiveData, @NotNull Continuation<? super DisposableHandle> paramContinuation)
  {
    if ((paramContinuation instanceof CoroutineLiveData.emitSource.1))
    {
      localObject1 = (CoroutineLiveData.emitSource.1)paramContinuation;
      if ((((CoroutineLiveData.emitSource.1)localObject1).label & 0x80000000) != 0)
      {
        ((CoroutineLiveData.emitSource.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super DisposableHandle>)localObject1;
        break label53;
      }
    }
    paramContinuation = new CoroutineLiveData.emitSource.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramLiveData = (LiveData)paramContinuation.L$1;
          paramLiveData = (CoroutineLiveData)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject1);
          paramContinuation = (Continuation<? super DisposableHandle>)localObject1;
          break label225;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      LiveData localLiveData = (LiveData)paramContinuation.L$1;
      paramLiveData = (CoroutineLiveData)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject1 = localLiveData;
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramLiveData;
      paramContinuation.label = 1;
      if (clearSource$lifecycle_livedata_ktx_release(paramContinuation) == localObject2) {
        return localObject2;
      }
      localObject1 = paramLiveData;
      paramLiveData = this;
    }
    paramContinuation.L$0 = paramLiveData;
    paramContinuation.L$1 = localObject1;
    paramContinuation.label = 2;
    localObject1 = CoroutineLiveDataKt.addDisposableSource(paramLiveData, (LiveData)localObject1, paramContinuation);
    paramContinuation = (Continuation<? super DisposableHandle>)localObject1;
    if (localObject1 == localObject2) {
      return localObject2;
    }
    label225:
    paramContinuation = (EmittedSource)paramContinuation;
    paramLiveData.emittedSource = paramContinuation;
    return paramContinuation;
  }
  
  protected void onActive()
  {
    super.onActive();
    BlockRunner localBlockRunner = this.blockRunner;
    if (localBlockRunner != null) {
      localBlockRunner.maybeRun();
    }
  }
  
  protected void onInactive()
  {
    super.onInactive();
    BlockRunner localBlockRunner = this.blockRunner;
    if (localBlockRunner != null) {
      localBlockRunner.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.CoroutineLiveData
 * JD-Core Version:    0.7.0.1
 */