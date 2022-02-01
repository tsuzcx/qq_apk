package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "mobile", "", "showMobile", "encryptedData", "iv", "cloud_id", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getCloud_id", "()Ljava/lang/String;", "getEncryptedData", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class r
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new r.b();
  public static final r.a a = new r.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  private final boolean g;
  private final boolean h;
  private boolean i;
  private boolean j;
  
  public r(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("mobile", this.b);
    ((JSONObject)localObject).put("show_mobile", this.c);
    ((JSONObject)localObject).put("need_auth", this.g);
    ((JSONObject)localObject).put("allow_send_sms", this.h);
    ((JSONObject)localObject).put("encryptedData", this.d);
    ((JSONObject)localObject).put("iv", this.e);
    ((JSONObject)localObject).put("cloud_id", this.f);
    ((JSONObject)localObject).put("is_wechat", this.i);
    ((JSONObject)localObject).put("is_check", this.j);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObject.toString()");
    return localObject;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
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
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof r))
    {
      paramObject = (r)paramObject;
      return (Intrinsics.areEqual(paramObject.b, this.b)) && (paramObject.i == this.i);
    }
    return super.equals(paramObject);
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public final boolean g()
  {
    return this.g;
  }
  
  public final boolean h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean i()
  {
    return this.i;
  }
  
  public final boolean j()
  {
    return this.j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhoneItem(mobile=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", showMobile=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", encryptedData=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", iv=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", cloud_id=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", needAuth=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", allowSendSms=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", isWechat=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isCheck=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r
 * JD-Core Version:    0.7.0.1
 */