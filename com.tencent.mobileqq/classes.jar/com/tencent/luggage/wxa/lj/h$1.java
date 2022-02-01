package com.tencent.luggage.wxa.lj;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$1
  extends Lambda
  implements Function1<Object, String>
{
  public static final 1 a = new 1();
  
  h$1()
  {
    super(1);
  }
  
  @Nullable
  public final String a(@Nullable Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof byte[])))
    {
      paramObject = Base64.encode((byte[])paramObject, 2);
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "Base64.encode(it, Base64.NO_WRAP)");
      Charset localCharset = StandardCharsets.UTF_8;
      Intrinsics.checkExpressionValueIsNotNull(localCharset, "StandardCharsets.UTF_8");
      return new String(paramObject, localCharset);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.h.1
 * JD-Core Version:    0.7.0.1
 */