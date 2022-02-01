package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/LiveData;", "Y", "X", "it", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Object;)Landroidx/lifecycle/LiveData;"}, k=3, mv={1, 1, 15})
public final class TransformationsKt$switchMap$1<I, O>
  implements Function<X, LiveData<Y>>
{
  public TransformationsKt$switchMap$1(Function1 paramFunction1) {}
  
  @NotNull
  public final LiveData<Y> apply(X paramX)
  {
    return (LiveData)this.$transform.invoke(paramX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.TransformationsKt.switchMap.1
 * JD-Core Version:    0.7.0.1
 */