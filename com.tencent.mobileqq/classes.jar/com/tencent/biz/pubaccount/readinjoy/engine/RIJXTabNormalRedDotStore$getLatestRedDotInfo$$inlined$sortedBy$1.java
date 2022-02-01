package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Comparator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class RIJXTabNormalRedDotStore$getLatestRedDotInfo$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)((Map.Entry)paramT1).getValue(), (Comparable)((Map.Entry)paramT2).getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore.getLatestRedDotInfo..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */