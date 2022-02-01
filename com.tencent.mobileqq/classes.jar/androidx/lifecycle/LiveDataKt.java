package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"observe", "Landroidx/lifecycle/Observer;", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "lifecycle-livedata-core-ktx_release"}, k=2, mv={1, 1, 15})
public final class LiveDataKt
{
  @MainThread
  @NotNull
  public static final <T> Observer<T> observe(@NotNull LiveData<T> paramLiveData, @NotNull LifecycleOwner paramLifecycleOwner, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$observe");
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "owner");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onChanged");
    paramFunction1 = (Observer)new LiveDataKt.observe.wrappedObserver.1(paramFunction1);
    paramLiveData.observe(paramLifecycleOwner, paramFunction1);
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveDataKt
 * JD-Core Version:    0.7.0.1
 */