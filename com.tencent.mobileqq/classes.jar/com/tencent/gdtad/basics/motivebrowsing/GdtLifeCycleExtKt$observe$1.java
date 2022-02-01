package com.tencent.gdtad.basics.motivebrowsing;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
final class GdtLifeCycleExtKt$observe$1<T>
  implements Observer<T>
{
  GdtLifeCycleExtKt$observe$1(Function1 paramFunction1) {}
  
  public final void onChanged(T paramT)
  {
    if (paramT != null) {
      this.a.invoke(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtLifeCycleExtKt.observe.1
 * JD-Core Version:    0.7.0.1
 */