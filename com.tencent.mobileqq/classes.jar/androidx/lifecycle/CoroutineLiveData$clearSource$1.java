package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"clearSource", "", "T", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 15})
@DebugMetadata(c="androidx.lifecycle.CoroutineLiveData", f="CoroutineLiveData.kt", i={0}, l={234}, m="clearSource$lifecycle_livedata_ktx_release", n={"this"}, s={"L$0"})
final class CoroutineLiveData$clearSource$1
  extends ContinuationImpl
{
  Object L$0;
  int label;
  
  CoroutineLiveData$clearSource$1(CoroutineLiveData paramCoroutineLiveData, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.CoroutineLiveData.clearSource.1
 * JD-Core Version:    0.7.0.1
 */