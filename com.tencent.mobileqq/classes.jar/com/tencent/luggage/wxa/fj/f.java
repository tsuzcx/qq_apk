package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dj.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/SmcReporter;", "", "()V", "REPORTER", "Lcom/tencent/luggage/reporter/ISmcKVReportService;", "getREPORTER", "()Lcom/tencent/luggage/reporter/ISmcKVReportService;", "REPORTER$delegate", "Lkotlin/Lazy;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  @NotNull
  private static final Lazy b = LazyKt.lazy((Function0)f.a.a);
  
  @NotNull
  public final a a()
  {
    return (a)b.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.f
 * JD-Core Version:    0.7.0.1
 */