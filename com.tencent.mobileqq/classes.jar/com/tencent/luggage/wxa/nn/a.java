package com.tencent.luggage.wxa.nn;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dw.b;
import com.tencent.luggage.wxa.jj.i;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.jj.m;
import com.tencent.luggage.wxa.jj.p;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public int A;
  public String B;
  public String a;
  public String b;
  public int c;
  public int d;
  public String e;
  public com.tencent.luggage.wxa.ou.d f;
  public j g;
  public com.tencent.luggage.wxa.ie.a h;
  public long i;
  public long j;
  @Nullable
  public String k;
  @Nullable
  public PersistableBundle l;
  @Nullable
  public com.tencent.luggage.wxa.dw.a m;
  @Nullable
  public b<?> n;
  public int o = -1;
  @Nullable
  public b<Bundle> p;
  public PersistableBundle q = null;
  public String r = null;
  public int s;
  public i t;
  public p u = p.h;
  public boolean v;
  public Parcelable w;
  @Nullable
  public Parcelable x;
  public List<String> y;
  public com.tencent.luggage.wxa.dw.d z;
  
  public a()
  {
    this.v = false;
    this.y = new ArrayList();
    this.z = com.tencent.luggage.wxa.dw.d.a;
    this.A = 0;
    this.B = "";
  }
  
  private a(Parcel paramParcel)
  {
    boolean bool = false;
    this.v = false;
    this.y = new ArrayList();
    this.z = com.tencent.luggage.wxa.dw.d.a;
    this.A = 0;
    this.B = "";
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = ((com.tencent.luggage.wxa.ou.d)paramParcel.readParcelable(com.tencent.luggage.wxa.ou.d.class.getClassLoader()));
    this.g = ((j)paramParcel.readParcelable(j.class.getClassLoader()));
    this.h = ((com.tencent.luggage.wxa.ie.a)paramParcel.readParcelable(com.tencent.luggage.wxa.ie.a.class.getClassLoader()));
    this.i = paramParcel.readLong();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.l = paramParcel.readPersistableBundle(a.class.getClassLoader());
    this.m = ((com.tencent.luggage.wxa.dw.a)paramParcel.readParcelable(com.tencent.luggage.wxa.dw.a.class.getClassLoader()));
    this.n = com.tencent.luggage.wxa.dw.c.a(paramParcel);
    this.o = paramParcel.readInt();
    this.p = com.tencent.luggage.wxa.dw.c.a(paramParcel);
    this.q = paramParcel.readPersistableBundle(a.class.getClassLoader());
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = ((i)paramParcel.readParcelable(i.class.getClassLoader()));
    this.w = paramParcel.readParcelable(a.class.getClassLoader());
    this.x = paramParcel.readParcelable(a.class.getClassLoader());
    paramParcel.readStringList(this.y);
    this.u = ((p)paramParcel.readParcelable(p.class.getClassLoader()));
    this.z = com.tencent.luggage.wxa.dw.d.a(paramParcel);
    if (paramParcel.readInt() == 1) {
      bool = true;
    }
    this.v = bool;
    this.A = paramParcel.readInt();
    this.B = paramParcel.readString();
  }
  
  public static String a(String paramString)
  {
    return k.c(paramString);
  }
  
  public static String b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str1 = "";
    if (bool) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = a(paramString);
    int i1 = str2.lastIndexOf("?");
    paramString = str2;
    if (i1 != -1)
    {
      paramString = str2.substring(0, i1);
      str1 = str2.substring(i1);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".html")))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(".html");
      localStringBuilder.append(str1);
    }
    else
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str1);
    }
    return localStringBuilder.toString();
  }
  
  public void a(com.tencent.luggage.wxa.do.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (TextUtils.isEmpty(paramc.b)) {
      paramc.b = this.a;
    }
    Object localObject1 = this.h;
    if ((localObject1 != null) && (((com.tencent.luggage.wxa.ie.a)localObject1).d != null)) {
      paramc.i.a(this.h.d);
    }
    paramc.I = a(this.e);
    paramc.h.a(this.g);
    localObject1 = this.h;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((com.tencent.luggage.wxa.ie.a)localObject1).a;
    }
    paramc.f = ((String)localObject1);
    localObject1 = this.h;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((com.tencent.luggage.wxa.ie.a)localObject1).b;
    }
    paramc.g = ((String)localObject1);
    paramc.l = this.i;
    paramc.m = this.j;
    paramc.t = this.n;
    paramc.u = this.z;
    paramc.j = this.k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LaunchParcel{username='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", enterPath='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", statObj=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", referrer=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", startClickTimestamp=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", forceKeepOpaque=");
    localStringBuilder.append(this.v);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nn.a
 * JD-Core Version:    0.7.0.1
 */