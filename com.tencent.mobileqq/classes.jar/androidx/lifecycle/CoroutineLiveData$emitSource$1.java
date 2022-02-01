package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"emitSource", "", "T", "source", "Landroidx/lifecycle/LiveData;", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/DisposableHandle;"}, k=3, mv={1, 1, 15})
@DebugMetadata(c="androidx.lifecycle.CoroutineLiveData", f="CoroutineLiveData.kt", i={0, 0, 1, 1}, l={227, 228}, m="emitSource$lifecycle_livedata_ktx_release", n={"this", "source", "this", "source"}, s={"L$0", "L$1", "L$0", "L$1"})
final class CoroutineLiveData$emitSource$1
  extends ContinuationImpl
{
  Object L$0;
  Object L$1;
  int label;
  
  CoroutineLiveData$emitSource$1(CoroutineLiveData paramCoroutineLiveData, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.emitSource$lifecycle_livedata_ktx_release(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.CoroutineLiveData.emitSource.1
 * JD-Core Version:    0.7.0.1
 */