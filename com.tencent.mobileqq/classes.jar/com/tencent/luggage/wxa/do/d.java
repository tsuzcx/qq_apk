package com.tencent.luggage.wxa.do;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jj.s.d;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.on.b;
import com.tencent.mm.plugin.appbrand.appcache.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class d
  extends l
  implements Parcelable, j
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public int A;
  public int B;
  public long C;
  public g D;
  public String[] E;
  public long F;
  public List<s.d> G;
  @Nullable
  public byte[] H;
  public String a;
  public boolean b;
  public boolean c;
  @Deprecated
  public boolean d;
  public boolean e;
  public boolean f;
  public b g;
  public HashMap<String, b> h;
  public String i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public boolean p;
  public boolean q;
  public long r;
  public int s;
  public ArrayList<String> t;
  public ArrayList<String> u;
  public ArrayList<String> v;
  public ArrayList<String> w;
  public ArrayList<String> x;
  public boolean y;
  public int z;
  
  public d()
  {
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.C = 0L;
    this.E = new String[0];
  }
  
  protected d(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.C = 0L;
    this.E = new String[0];
    this.I = paramParcel.readString();
    this.a = paramParcel.readString();
    this.J = paramParcel.readString();
    this.K = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    this.g = ((b)paramParcel.readParcelable(b.class.getClassLoader()));
    this.L = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.p = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.q = bool1;
    this.r = paramParcel.readLong();
    this.s = paramParcel.readInt();
    this.t = paramParcel.createStringArrayList();
    this.u = paramParcel.createStringArrayList();
    this.v = paramParcel.createStringArrayList();
    this.w = paramParcel.createStringArrayList();
    this.x = paramParcel.createStringArrayList();
    this.S = ((af)paramParcel.readParcelable(af.class.getClassLoader()));
    this.D = ((g)paramParcel.readParcelable(g.class.getClassLoader()));
    if (paramParcel.readByte() > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.M = bool1;
    if (paramParcel.readByte() > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.N = bool1;
    this.Q = paramParcel.readInt();
    this.R = paramParcel.readInt();
    this.z = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.y = bool1;
    this.C = paramParcel.readLong();
    this.i = paramParcel.readString();
    this.E = new String[paramParcel.readInt()];
    paramParcel.readStringArray(this.E);
    this.A = paramParcel.readInt();
    this.B = paramParcel.readInt();
    this.T = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.U = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.O = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.P = bool1;
    this.F = paramParcel.readLong();
    this.G = paramParcel.createTypedArrayList(s.d.CREATOR);
    this.h = paramParcel.readHashMap(b.class.getClassLoader());
    this.H = paramParcel.createByteArray();
  }
  
  public long a()
  {
    return this.F;
  }
  
  public final int b()
  {
    return this.S.pkgVersion;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandSysConfigLU{, brandName='");
    localStringBuilder.append(this.I);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.J);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appIconUrl='");
    localStringBuilder.append(this.K);
    localStringBuilder.append('\'');
    localStringBuilder.append(", debugEnabled=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", performancePanelEnabled=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", maxWebViewDepth=");
    localStringBuilder.append(this.L);
    localStringBuilder.append(", maxBackgroundLifeSpan=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", maxRequestConcurrent=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", maxUploadConcurrent=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", maxDownloadConcurrent=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", maxWebsocketConnect=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", websocketSkipPortCheck=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", requestDomains=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", socketDomains=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", uploadDomains=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", downloadDomains=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", downloadDomains=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", appPkgInfo=");
    localStringBuilder.append(this.S);
    localStringBuilder.append(", systemSettings=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(", runningFlag=");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", operationInfo=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", kvStorageScheme=");
    localStringBuilder.append(this.T);
    localStringBuilder.append(", TLSSkipHostnameCheck=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", kvStoragePerformanceReportOn=");
    localStringBuilder.append(this.U);
    localStringBuilder.append(", pluginPermissionBundleMap=");
    HashMap localHashMap = this.h;
    int i1;
    if (localHashMap == null) {
      i1 = 0;
    } else {
      i1 = localHashMap.size();
    }
    localStringBuilder.append(String.valueOf(i1));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.do.d
 * JD-Core Version:    0.7.0.1
 */