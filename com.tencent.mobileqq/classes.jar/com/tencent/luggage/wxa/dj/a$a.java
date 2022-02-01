package com.tencent.luggage.wxa.dj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/reporter/ISmcKVReportService$Factory;", "", "()V", "IMPL", "Lcom/tencent/luggage/reporter/ISmcKVReportService;", "getIMPL", "()Lcom/tencent/luggage/reporter/ISmcKVReportService;", "setIMPL", "(Lcom/tencent/luggage/reporter/ISmcKVReportService;)V", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class a$a
{
  @NotNull
  public static a a;
  public static final a b = new a();
  
  @NotNull
  public final a a()
  {
    a locala = a;
    if (locala == null) {
      Intrinsics.throwUninitializedPropertyAccessException("IMPL");
    }
    return locala;
  }
  
  public final void a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "<set-?>");
    a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.a.a
 * JD-Core Version:    0.7.0.1
 */