package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WadlParams
  implements Parcelable
{
  public static final Parcelable.Creator<WadlParams> CREATOR = new WadlParams.1();
  public String A = "";
  public long B;
  public int C;
  public int D;
  public boolean E;
  public int F;
  public String G;
  public int a = 39;
  public boolean b;
  public int c;
  public int d;
  public String e = "";
  public String f;
  public boolean g;
  public int h;
  public String i = "";
  public String j;
  public String k = "";
  public int l;
  public String m = "";
  public long n;
  public long o;
  public int p = -1;
  public String q;
  public String r;
  public String s;
  public int t;
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public WadlParams() {}
  
  public WadlParams(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.G = paramString;
      a(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.m = paramString2;
    this.d = this.a;
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramInt1 != 1) && (paramInt1 != 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(paramInt1);
    paramString2.append("_");
    paramString2.append(paramInt2);
    return paramString2.toString();
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.c = paramString.optInt("actionCode");
        this.e = paramString.optString("appId");
        this.f = paramString.optString("apkSign");
        this.l = paramString.optInt("versionCode");
        this.m = paramString.optString("packageName");
        this.u = paramString.optString("appName");
        this.v = paramString.optString("iconUrl");
        if (paramString.optInt("delayDownload") > 0)
        {
          bool = true;
          this.g = bool;
          this.x = paramString.optString("fromWebUrl");
          this.i = paramString.optString("apkChannel", "10000144");
          this.w = paramString.optString("via");
          this.n = paramString.optLong("downloadStartTime");
          this.o = paramString.optLong("downloadEndTime");
          this.y = paramString.optString("adtag");
          this.h = paramString.optInt("from", 0);
          this.d = paramString.optInt("flags", this.a);
          if (a(64))
          {
            b(64);
            c(1);
          }
          if (a(128)) {
            b(128);
          }
          this.z = paramString.optString("extraData");
          this.e = paramString.optString("appid", this.e);
          this.x = paramString.optString("wadlSource", this.x);
          this.f = paramString.optString("myAppId", this.f);
          if ((paramString.has("isAutoInstall")) && (paramString.optInt("isAutoInstall") == 0)) {
            b(1);
          }
          if ((paramString.has("showPageNotification")) && (paramString.optInt("showPageNotification") == 0)) {
            b(2);
          }
          if ((paramString.has("showSystemNotification")) && (paramString.optInt("showSystemNotification") == 0)) {
            b(4);
          }
          if ((paramString.has("requireWifi")) && (paramString.optBoolean("requireWifi", false))) {
            c(8);
          }
          if ((paramString.has("showNetworkDiaLog")) && (paramString.optInt("showNetworkDiaLog") > 0)) {
            c(16);
          }
          this.A = paramString.optString("sourceId");
          this.B = paramString.optLong("pkgSize");
          this.b = paramString.optBoolean("isRes");
          if (this.b)
          {
            this.k = paramString.optString("resUrl");
          }
          else
          {
            this.k = paramString.optString("apkUrl");
            if (TextUtils.isEmpty(this.k)) {
              this.k = paramString.optString("url");
            }
          }
          this.p = paramString.optInt("resIndex");
          this.q = paramString.optString("resVersionCode");
          this.r = paramString.optString("resName");
          this.s = paramString.optString("resMD5");
          this.j = paramString.optString("resDir");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("Wadl_WadlParams", 1, "parse json exception:", paramString);
        return;
      }
      boolean bool = false;
    }
  }
  
  public String a()
  {
    if (this.b) {
      return a(this.e, this.t, this.l, this.r);
    }
    return this.e;
  }
  
  public void a(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.c = paramParcel.readInt();
      this.e = paramParcel.readString();
      this.k = paramParcel.readString();
      this.f = paramParcel.readString();
      this.l = paramParcel.readInt();
      this.m = paramParcel.readString();
      this.u = paramParcel.readString();
      this.v = paramParcel.readString();
      int i1 = paramParcel.readInt();
      boolean bool2 = true;
      boolean bool1;
      if (i1 > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.g = bool1;
      this.x = paramParcel.readString();
      this.i = paramParcel.readString();
      this.w = paramParcel.readString();
      this.n = paramParcel.readLong();
      this.o = paramParcel.readLong();
      this.y = paramParcel.readString();
      this.h = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.z = paramParcel.readString();
      this.A = paramParcel.readString();
      if (paramParcel.readInt() > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.b = bool1;
      this.p = paramParcel.readInt();
      this.q = paramParcel.readString();
      this.r = paramParcel.readString();
      this.s = paramParcel.readString();
      this.k = paramParcel.readString();
      this.t = paramParcel.readInt();
      this.j = paramParcel.readString();
      this.B = paramParcel.readLong();
      this.C = paramParcel.readInt();
      this.D = paramParcel.readInt();
      this.F = paramParcel.readInt();
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    this.d = paramWadlParams.d;
    this.C = paramWadlParams.C;
    this.x = paramWadlParams.x;
  }
  
  public boolean a(int paramInt)
  {
    return (this.d & paramInt) == paramInt;
  }
  
  public void b(int paramInt)
  {
    this.d = ((paramInt ^ 0xFFFFFFFF) & this.d);
  }
  
  public void c(int paramInt)
  {
    this.d = (paramInt | this.d);
  }
  
  public void d(int paramInt)
  {
    this.F = (paramInt | this.d);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(int paramInt)
  {
    this.F = ((paramInt ^ 0xFFFFFFFF) & this.F);
  }
  
  public boolean f(int paramInt)
  {
    return (this.F & paramInt) == paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WadlParams{actionCode='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isRes='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resType=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", apkUrl='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.u);
    localStringBuilder.append('\'');
    localStringBuilder.append(", delayDownload=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", extraData='");
    localStringBuilder.append(this.z);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apkChannel='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", via='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", fromWebUrl=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", yyStartTime=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", yyEndTime=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", adtag='");
    localStringBuilder.append(this.y);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resName='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resIndex='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resMD5='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resDir='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkgSize=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", ignoreSpace=");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", channelNum=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(", isCancelRequest=");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", extFlags=");
    localStringBuilder.append(this.F);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlParams
 * JD-Core Version:    0.7.0.1
 */