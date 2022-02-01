package com.tencent.luggage.wxa.fr;

import android.util.Pair;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "o2", "compare"}, k=3, mv={1, 1, 16})
final class b$a<T>
  implements Comparator<Pair<String, Integer>>
{
  public static final a a = new a();
  
  public final int a(Pair<String, Integer> paramPair1, Pair<String, Integer> paramPair2)
  {
    int i = ((Number)paramPair2.second).intValue();
    paramPair1 = paramPair1.second;
    Intrinsics.checkExpressionValueIsNotNull(paramPair1, "o1.second");
    return i - ((Number)paramPair1).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fr.b.a
 * JD-Core Version:    0.7.0.1
 */