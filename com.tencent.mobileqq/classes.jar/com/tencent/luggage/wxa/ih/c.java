package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<c> CREATOR = (Parcelable.Creator)new c.b();
  public static final c.a a = new c.a(null);
  private final boolean b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  private final int e;
  @NotNull
  private final ArrayList<d> f;
  private final boolean g;
  @Nullable
  private final e h;
  private boolean i;
  private final boolean j;
  @NotNull
  private final byte[] k;
  private final int l;
  @Nullable
  private final a m;
  @Nullable
  private final String n;
  @Nullable
  private final String o;
  private final int p;
  @NotNull
  private final String q;
  private final boolean r;
  
  public c(@NotNull Parcel paramParcel)
  {
    int i1 = paramParcel.readByte();
    boolean bool2 = false;
    int i2 = (byte)0;
    if (i1 != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    Object localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.c = ((String)localObject);
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.d = ((String)localObject);
    this.e = paramParcel.readInt();
    this.h = ((e)paramParcel.readParcelable(e.class.getClassLoader()));
    localObject = new ArrayList();
    paramParcel.readList((List)localObject, d.class.getClassLoader());
    this.f = ((ArrayList)localObject);
    if (paramParcel.readByte() != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if (paramParcel.readByte() != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    if (paramParcel.readByte() != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    this.k = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.k);
    this.l = paramParcel.readInt();
    this.m = ((a)paramParcel.readParcelable(a.class.getClassLoader()));
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.n = ((String)localObject);
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.o = ((String)localObject);
    this.p = paramParcel.readInt();
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.q = ((String)localObject);
    boolean bool1 = bool2;
    if (paramParcel.readByte() != i2) {
      bool1 = true;
    }
    this.r = bool1;
  }
  
  public c(boolean paramBoolean1, @NotNull String paramString1, @NotNull String paramString2, int paramInt1, @NotNull ArrayList<d> paramArrayList, boolean paramBoolean2, @Nullable e parame, boolean paramBoolean3, boolean paramBoolean4, @NotNull byte[] paramArrayOfByte, int paramInt2, @Nullable a parama, @Nullable String paramString3, @Nullable String paramString4, int paramInt3, @NotNull String paramString5, boolean paramBoolean5)
  {
    this.b = paramBoolean1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramInt1;
    this.f = paramArrayList;
    this.g = paramBoolean2;
    this.h = parame;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
    this.k = paramArrayOfByte;
    this.l = paramInt2;
    this.m = parama;
    this.n = paramString3;
    this.o = paramString4;
    this.p = paramInt3;
    this.q = paramString5;
    this.r = paramBoolean5;
  }
  
  @NotNull
  public final String a()
  {
    return this.c;
  }
  
  @NotNull
  public final String b()
  {
    return this.d;
  }
  
  @NotNull
  public final ArrayList<d> c()
  {
    return this.f;
  }
  
  @Nullable
  public final e d()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    return this.i;
  }
  
  public final boolean f()
  {
    return this.j;
  }
  
  @NotNull
  public final byte[] g()
  {
    return this.k;
  }
  
  public final int h()
  {
    return this.l;
  }
  
  public final int i()
  {
    return this.p;
  }
  
  @NotNull
  public final String j()
  {
    return this.q;
  }
  
  public final boolean k()
  {
    return this.r;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubscribeMsgRequestResult(alwaysChosenStatus=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appIconUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', appName='");
    localStringBuilder.append(this.d);
    localStringBuilder.append("', cacheMaxSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", subscribeMsgItems=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", notShowAlways=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", wordingInfo=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", CREATOR=");
    localStringBuilder.append(CREATOR);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.c
 * JD-Core Version:    0.7.0.1
 */