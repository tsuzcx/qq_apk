package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$g
  extends Lambda
  implements Function1<Integer, Unit>
{
  public static final g a = new g();
  
  h$g()
  {
    super(1);
  }
  
  public final void a(int paramInt)
  {
    h.a(h.a).putInt("current_collection_count ", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.h.g
 * JD-Core Version:    0.7.0.1
 */