package com.tencent.luggage.wxa.en;

import com.tencent.luggage.wxa.hz.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class c$a
  extends Lambda
  implements Function0<String>
{
  public static final a a = new a();
  
  c$a()
  {
    super(0);
  }
  
  public final String a()
  {
    return new File(a.d(), "CodeCache").getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.c.a
 * JD-Core Version:    0.7.0.1
 */