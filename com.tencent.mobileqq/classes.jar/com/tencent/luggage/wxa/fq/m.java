package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.cx.u;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaHostAttrPeriodUpdateChecker;", "Lcom/tencent/luggage/wxaapi/internal/WxaPeriodTaskChecker;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "doCheck", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class m
  extends n
{
  public static final m a = new m();
  @NotNull
  private static final String b = "Luggage.WxaHostAttrPeriodUpdateChecker";
  
  @NotNull
  public String a()
  {
    return b;
  }
  
  public void b()
  {
    int i;
    if (((CharSequence)g.c.a.a()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      u.b.a(null, g.c.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.m
 * JD-Core Version:    0.7.0.1
 */