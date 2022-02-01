package com.tencent.luggage.wxa.nl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k$b
  implements Comparable<b>
{
  @Deprecated
  public static final k.b.a a = new k.b.a(null);
  @NotNull
  private String b = "";
  @Nullable
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  
  public int a(@NotNull b paramb)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  @Nullable
  public final String b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = paramObject instanceof b;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (((b)this == paramObject) || (hashCode() == paramObject.hashCode())) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public final boolean i()
  {
    return this.j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalUnifiedGetDownloadUrlRequest(appId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', moduleName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", packageType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", supportEncryptVersion=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", localPkgVersion=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", localPkgEncryptVersion=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", needLatestVersion=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.k.b
 * JD-Core Version:    0.7.0.1
 */