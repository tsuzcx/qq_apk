package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/DemoScan$QRCodeHandleResult$Failure;", "Lcom/tencent/luggage/wxaapi/internal/DemoScan$QRCodeHandleResult;", "cause", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "(Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;)V", "getCause", "()Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a$a
  extends b.a
{
  @NotNull
  private final LaunchWxaAppResult a;
  
  public b$a$a(@NotNull LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    super(null);
    this.a = paramLaunchWxaAppResult;
    int i;
    if (this.a != LaunchWxaAppResult.OK) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  @NotNull
  public final LaunchWxaAppResult a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b.a.a
 * JD-Core Version:    0.7.0.1
 */