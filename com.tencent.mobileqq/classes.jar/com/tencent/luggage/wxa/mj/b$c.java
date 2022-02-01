package com.tencent.luggage.wxa.mj;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"}, k=3, mv={1, 1, 16})
final class b$c<T>
  implements Comparator<b.d>
{
  public static final c a = new c();
  
  public final int a(b.d paramd1, b.d paramd2)
  {
    if (paramd1.c() < paramd2.c()) {
      return -1;
    }
    if (paramd2.c() < paramd1.c()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mj.b.c
 * JD-Core Version:    0.7.0.1
 */