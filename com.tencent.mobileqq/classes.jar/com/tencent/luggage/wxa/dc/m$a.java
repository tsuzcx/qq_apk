package com.tencent.luggage.wxa.dc;

import junit.framework.a;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/UIN64$Companion;", "", "()V", "getString", "", "uin64", "", "toUIN64String", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class m$a
{
  @NotNull
  public final String a(long paramLong)
  {
    return new m(paramLong).toString();
  }
  
  @ExperimentalUnsignedTypes
  @NotNull
  public final String b(long paramLong)
  {
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, CharsKt.checkRadix(10));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      return localObject;
    }
    long l5 = 10;
    long l3 = (paramLong >>> 1) / l5 << 1;
    long l4 = paramLong - l3 * l5;
    long l2 = l3;
    long l1 = l4;
    if (l4 >= l5)
    {
      l1 = l4 - l5;
      l2 = l3 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(l2, CharsKt.checkRadix(10));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    str = Long.toString(l1, CharsKt.checkRadix(10));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      a.a((String)localObject, ULong.toString-impl(ULong.constructor-impl(paramLong)));
      return localObject;
    }
    catch (VerifyError localVerifyError) {}
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.m.a
 * JD-Core Version:    0.7.0.1
 */