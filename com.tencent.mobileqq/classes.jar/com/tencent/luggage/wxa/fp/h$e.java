package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$e
  extends Lambda
  implements Function0<Integer>
{
  public static final e a = new e();
  
  h$e()
  {
    super(0);
  }
  
  public final int a()
  {
    return h.a(h.a).getInt("current_collection_count ", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.h.e
 * JD-Core Version:    0.7.0.1
 */