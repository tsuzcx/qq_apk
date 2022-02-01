package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"}, k=3, mv={1, 1, 16})
final class f$a
  extends Lambda
  implements Function0<i>
{
  public static final a a = new a();
  
  f$a()
  {
    super(0);
  }
  
  @NotNull
  public final i a()
  {
    i locali = new i(g.a(), "wxacache");
    k.g(locali.l());
    locali = new i(locali, "unzip");
    k.g(locali.l());
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.f.a
 * JD-Core Version:    0.7.0.1
 */