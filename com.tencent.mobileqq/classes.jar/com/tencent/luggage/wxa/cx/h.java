package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qw.fa;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qy.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/OnLaunchWxaResponseReceivedEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "request", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class h
  extends b
{
  @NotNull
  private final fa a;
  @NotNull
  private final fb b;
  
  public h(@NotNull fa paramfa, @NotNull fb paramfb)
  {
    this.a = paramfa;
    this.b = paramfb;
  }
  
  @NotNull
  public final fb a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.h
 * JD-Core Version:    0.7.0.1
 */