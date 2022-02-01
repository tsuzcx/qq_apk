package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.t;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaXWebUpdater;", "Lcom/tencent/luggage/wxaapi/internal/WxaPeriodTaskChecker;", "()V", "CHECK_INTERVAL_MS", "", "getCHECK_INTERVAL_MS", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "doCheck", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class r
  extends n
{
  public static final r a = new r();
  @NotNull
  private static final String b = "Luggage.WxaXWebUpdater";
  private static final long c = TimeUnit.MINUTES.toMillis(30L);
  
  @NotNull
  public String a()
  {
    return b;
  }
  
  public void b()
  {
    try
    {
      t.a(com.tencent.luggage.wxa.qz.r.a(), null);
      return;
    }
    catch (Exception localException)
    {
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCheck get exception ");
      localStringBuilder.append(localException);
      o.b(str, localStringBuilder.toString());
    }
  }
  
  public long c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.r
 * JD-Core Version:    0.7.0.1
 */