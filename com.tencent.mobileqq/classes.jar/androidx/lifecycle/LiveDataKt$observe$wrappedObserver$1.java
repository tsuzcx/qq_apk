package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 15})
public final class LiveDataKt$observe$wrappedObserver$1<T>
  implements Observer<T>
{
  public LiveDataKt$observe$wrappedObserver$1(Function1 paramFunction1) {}
  
  public final void onChanged(T paramT)
  {
    this.$onChanged.invoke(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveDataKt.observe.wrappedObserver.1
 * JD-Core Version:    0.7.0.1
 */