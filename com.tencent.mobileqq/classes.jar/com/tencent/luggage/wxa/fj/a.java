package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dj.a.a;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/AbstractReportStruct;", "", "()V", "getId", "", "report", "", "toRptValue", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class a
{
  public final void a()
  {
    com.tencent.luggage.wxa.dj.a locala = a.a.b.a();
    int i = c();
    Object localObject = b();
    Charset localCharset = Charsets.UTF_8;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
      locala.a(i, (byte[])localObject, false, 0, false, 1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public abstract String b();
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.a
 * JD-Core Version:    0.7.0.1
 */