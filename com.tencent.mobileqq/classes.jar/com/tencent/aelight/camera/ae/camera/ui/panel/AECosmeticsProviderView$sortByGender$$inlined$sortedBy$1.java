package com.tencent.aelight.camera.ae.camera.ui.panel;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class AECosmeticsProviderView$sortByGender$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)Integer.valueOf(((DYAEEffectItem)paramT1).k()), (Comparable)Integer.valueOf(((DYAEEffectItem)paramT2).k()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView.sortByGender..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */