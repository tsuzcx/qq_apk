package com.tencent.luggage.wxa.ea;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "appId", "", "isGame", "", "versionType", "", "(Ljava/lang/String;ZI)V", "getAppId", "()Ljava/lang/String;", "()Z", "getVersionType", "()I", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class h
{
  @NotNull
  private final String a;
  private final boolean b;
  private final int c;
  
  public h(@NotNull String paramString, boolean paramBoolean, int paramInt)
  {
    this.a = paramString;
    this.b = paramBoolean;
    this.c = paramInt;
  }
  
  @NotNull
  public final String d()
  {
    return this.a;
  }
  
  public final boolean e()
  {
    return this.b;
  }
  
  public final int f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.h
 * JD-Core Version:    0.7.0.1
 */