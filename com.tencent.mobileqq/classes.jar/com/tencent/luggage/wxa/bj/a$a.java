package com.tencent.luggage.wxa.bj;

import com.tencent.luggage.wxa.dc.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class a$a
  extends Lambda
  implements Function0<OkHttpClient>
{
  public static final a a = new a();
  
  a$a()
  {
    super(0);
  }
  
  public final OkHttpClient a()
  {
    return g.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bj.a.a
 * JD-Core Version:    0.7.0.1
 */