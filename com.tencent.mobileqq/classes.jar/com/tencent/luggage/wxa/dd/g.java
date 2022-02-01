package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/SessionInfo;", "", "runtimeAppId", "", "uin", "", "sessionKey", "oauthCode", "expiresIn", "openId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "()V", "getExpiresIn", "()I", "setExpiresIn", "(I)V", "getOauthCode", "()Ljava/lang/String;", "setOauthCode", "(Ljava/lang/String;)V", "getOpenId", "setOpenId", "getRuntimeAppId", "setRuntimeAppId", "getSessionKey", "setSessionKey", "getUin", "setUin", "updateTimeStamp", "getUpdateTimeStamp", "setUpdateTimeStamp", "nowInSeconds", "willSessionExpireIn", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class g
{
  public static final g.a a = new g.a(null);
  @NotNull
  private String b = "";
  private int c;
  private int d;
  @NotNull
  private String e = "";
  @NotNull
  private String f = "";
  private int g;
  @NotNull
  private String h = "";
  
  public g() {}
  
  public g(@NotNull String paramString1, int paramInt1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, @NotNull String paramString4)
  {
    this();
    b(paramInt1);
    a(paramString2);
    b(paramString3);
    a(h());
    if (paramInt2 <= 0) {
      paramInt2 = (int)604800L;
    }
    c(paramInt2);
    c(paramString1);
    d(paramString4);
  }
  
  @NotNull
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  @NotNull
  public String d()
  {
    return this.e;
  }
  
  public void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.h = paramString;
  }
  
  @NotNull
  public String e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  @NotNull
  public String g()
  {
    return this.h;
  }
  
  protected final int h()
  {
    return (int)(System.currentTimeMillis() / 1000L);
  }
  
  public final int i()
  {
    return (int)(af.b(b()) - f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.g
 * JD-Core Version:    0.7.0.1
 */