package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.iu.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
{
  @NotNull
  private final b a;
  @NotNull
  private final String b;
  @Nullable
  private final String c;
  private final int d;
  
  @JvmOverloads
  public d(@NotNull b paramb, @NotNull String paramString)
  {
    this(paramb, paramString, null, 0, 12, null);
  }
  
  @JvmOverloads
  public d(@NotNull b paramb, @NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.a = paramb;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  @NotNull
  public final b a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsAuthExecuteContext(appId='");
    localStringBuilder.append(this.a.getAppId());
    localStringBuilder.append("', api='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', callbackId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.d
 * JD-Core Version:    0.7.0.1
 */