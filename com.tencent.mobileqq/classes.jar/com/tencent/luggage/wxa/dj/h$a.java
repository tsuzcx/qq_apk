package com.tencent.luggage.wxa.dj;

import com.tencent.ilinkservice.ao;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/reporter/SmcKVReportSessionInterface$CloneSessionAdapter;", "Lcom/tencent/luggage/reporter/SmcKVReportSessionInterface;", "session", "Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "(Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;)V", "TAG", "", "getSession", "()Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "writeKvData", "", "logId", "", "reportContent", "", "reportNow", "", "type", "ignoreFreqCheck", "reportUinType", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class h$a
  implements h
{
  private final String a;
  @NotNull
  private final ao c;
  
  public h$a(@NotNull ao paramao)
  {
    this.c = paramao;
    this.a = "SmcKVReportSessionInterface.CloneSessionAdapter";
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reportContent");
    if (c.a)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeKvData logId:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" data:");
      localStringBuilder.append(new String(paramArrayOfByte, Charsets.UTF_8));
      o.f(str, localStringBuilder.toString());
    }
    this.c.a(paramInt1, paramArrayOfByte, paramBoolean1, paramInt2, paramBoolean2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.h.a
 * JD-Core Version:    0.7.0.1
 */