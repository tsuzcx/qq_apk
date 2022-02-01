package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, k=2, mv={1, 1, 15})
public final class TransformationsKt
{
  @NotNull
  public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> paramLiveData)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$distinctUntilChanged");
    paramLiveData = Transformations.distinctUntilChanged(paramLiveData);
    Intrinsics.checkExpressionValueIsNotNull(paramLiveData, "Transformations.distinctUntilChanged(this)");
    return paramLiveData;
  }
  
  @NotNull
  public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> paramLiveData, @NotNull Function1<? super X, ? extends Y> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramLiveData = Transformations.map(paramLiveData, (Function)new TransformationsKt.map.1(paramFunction1));
    Intrinsics.checkExpressionValueIsNotNull(paramLiveData, "Transformations.map(this) { transform(it) }");
    return paramLiveData;
  }
  
  @NotNull
  public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> paramLiveData, @NotNull Function1<? super X, ? extends LiveData<Y>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveData, "$this$switchMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramLiveData = Transformations.switchMap(paramLiveData, (Function)new TransformationsKt.switchMap.1(paramFunction1));
    Intrinsics.checkExpressionValueIsNotNull(paramLiveData, "Transformations.switchMap(this) { transform(it) }");
    return paramLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.TransformationsKt
 * JD-Core Version:    0.7.0.1
 */