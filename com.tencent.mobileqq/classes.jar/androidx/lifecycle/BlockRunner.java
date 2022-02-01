package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/BlockRunner;", "T", "", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "timeoutInMs", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onDone", "Lkotlin/Function0;", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/jvm/functions/Function2;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function2;", "cancellationJob", "Lkotlinx/coroutines/Job;", "runningJob", "cancel", "maybeRun", "lifecycle-livedata-ktx_release"}, k=1, mv={1, 1, 15})
public final class BlockRunner<T>
{
  private final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;
  private Job cancellationJob;
  private final CoroutineLiveData<T> liveData;
  private final Function0<Unit> onDone;
  private Job runningJob;
  private final CoroutineScope scope;
  private final long timeoutInMs;
  
  public BlockRunner(@NotNull CoroutineLiveData<T> paramCoroutineLiveData, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2, long paramLong, @NotNull CoroutineScope paramCoroutineScope, @NotNull Function0<Unit> paramFunction0)
  {
    this.liveData = paramCoroutineLiveData;
    this.block = paramFunction2;
    this.timeoutInMs = paramLong;
    this.scope = paramCoroutineScope;
    this.onDone = paramFunction0;
  }
  
  @MainThread
  public final void cancel()
  {
    if (this.cancellationJob == null)
    {
      this.cancellationJob = BuildersKt.launch$default(this.scope, (CoroutineContext)Dispatchers.getMain().getImmediate(), null, (Function2)new BlockRunner.cancel.1(this, null), 2, null);
      return;
    }
    throw ((Throwable)new IllegalStateException("Cancel call cannot happen without a maybeRun".toString()));
  }
  
  @MainThread
  public final void maybeRun()
  {
    Job localJob = this.cancellationJob;
    if (localJob != null) {
      Job.DefaultImpls.cancel$default(localJob, null, 1, null);
    }
    this.cancellationJob = ((Job)null);
    if (this.runningJob != null) {
      return;
    }
    this.runningJob = BuildersKt.launch$default(this.scope, null, null, (Function2)new BlockRunner.maybeRun.1(this, null), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.BlockRunner
 * JD-Core Version:    0.7.0.1
 */