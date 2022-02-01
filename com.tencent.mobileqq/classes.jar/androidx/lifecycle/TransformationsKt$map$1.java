package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Y", "X", "it", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 15})
public final class TransformationsKt$map$1<I, O>
  implements Function<X, Y>
{
  public TransformationsKt$map$1(Function1 paramFunction1) {}
  
  public final Y apply(X paramX)
  {
    return this.$transform.invoke(paramX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.TransformationsKt.map.1
 * JD-Core Version:    0.7.0.1
 */