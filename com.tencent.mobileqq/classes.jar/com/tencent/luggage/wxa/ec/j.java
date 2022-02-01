package com.tencent.luggage.wxa.ec;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.jj.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "Landroid/os/Parcelable;", "processIndex", "", "appId", "", "versionType", "isGame", "", "appType", "instanceId", "userName", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPersistentApp", "startTimestampNs", "", "stackTrace", "(ILjava/lang/String;IZILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;ZJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppType", "()I", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "getInstanceId", "()Z", "getProcessIndex", "getStackTrace", "getStartTimestampNs", "()J", "getUserName", "getVersionType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class j
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new j.a();
  private final int a;
  @NotNull
  private final String b;
  private final int c;
  private final boolean d;
  private final int e;
  @NotNull
  private final String f;
  @NotNull
  private final String g;
  @NotNull
  private final h h;
  private final boolean i;
  private final long j;
  @NotNull
  private final String k;
  
  public j(int paramInt1, @NotNull String paramString1, int paramInt2, boolean paramBoolean1, int paramInt3, @NotNull String paramString2, @NotNull String paramString3, @NotNull h paramh, boolean paramBoolean2, long paramLong, @NotNull String paramString4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramInt3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramh;
    this.i = paramBoolean2;
    this.j = paramLong;
    this.k = paramString4;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (this.i == paramObject.i) && (this.j == paramObject.j) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
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
    return this.i;
  }
  
  public final long g()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RuntimeInfo(processIndex=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isGame=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", instanceId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", userName=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", initConfig=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", isPersistentApp=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", startTimestampNs=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", stackTrace=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.j
 * JD-Core Version:    0.7.0.1
 */