package com.tencent.mobileqq.browser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/browser/BrowserItem;", "", "name", "", "title", "icon", "jumpUrl", "packageName", "isLocalApp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getIcon", "()Ljava/lang/String;", "()Z", "getJumpUrl", "getName", "getPackageName", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BrowserItem
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  private final boolean f;
  
  public BrowserItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramBoolean;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BrowserItem))
      {
        paramObject = (BrowserItem)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BrowserItem(name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", packageName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isLocalApp=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.browser.BrowserItem
 * JD-Core Version:    0.7.0.1
 */