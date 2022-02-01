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
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q;
  
  public WadlParams()
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
  }
  
  public WadlParams(String paramString)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    if (!TextUtils.isEmpty(paramString))
    {
      this.q = paramString;
      a(paramString);
    }
  }
  
  public WadlParams(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 39;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_f_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
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
        this.jdField_b_of_type_Int = paramString.optInt("actionCode");
        this.jdField_a_of_type_JavaLangString = paramString.optString("appId");
        this.jdField_b_of_type_JavaLangString = paramString.optString("apkSign");
        this.jdField_e_of_type_Int = paramString.optInt("versionCode");
        this.jdField_f_of_type_JavaLangString = paramString.optString("packageName");
        this.jdField_j_of_type_JavaLangString = paramString.optString("appName");
        this.k = paramString.optString("iconUrl");
        if (paramString.optInt("delayDownload") > 0)
        {
          bool = true;
          this.jdField_b_of_type_Boolean = bool;
          this.m = paramString.optString("fromWebUrl");
          this.jdField_c_of_type_JavaLangString = paramString.optString("apkChannel", "10000144");
          this.l = paramString.optString("via");
          this.jdField_a_of_type_Long = paramString.optLong("downloadStartTime");
          this.jdField_b_of_type_Long = paramString.optLong("downloadEndTime");
          this.n = paramString.optString("adtag");
          this.jdField_d_of_type_Int = paramString.optInt("from", 0);
          this.jdField_c_of_type_Int = paramString.optInt("flags", this.jdField_a_of_type_Int);
          if (a(64))
          {
            a(64);
            b(1);
          }
          if (a(128)) {
            a(128);
          }
          this.o = paramString.optString("extraData");
          this.jdField_a_of_type_JavaLangString = paramString.optString("appid", this.jdField_a_of_type_JavaLangString);
          this.m = paramString.optString("wadlSource", this.m);
          this.jdField_b_of_type_JavaLangString = paramString.optString("myAppId", this.jdField_b_of_type_JavaLangString);
          if ((paramString.has("isAutoInstall")) && (paramString.optInt("isAutoInstall") == 0)) {
            a(1);
          }
          if ((paramString.has("showPageNotification")) && (paramString.optInt("showPageNotification") == 0)) {
            a(2);
          }
          if ((paramString.has("showSystemNotification")) && (paramString.optInt("showSystemNotification") == 0)) {
            a(4);
          }
          if ((paramString.has("requireWifi")) && (paramString.optBoolean("requireWifi", false))) {
            b(8);
          }
          if ((paramString.has("showNetworkDiaLog")) && (paramString.optInt("showNetworkDiaLog") > 0)) {
            b(16);
          }
          this.p = paramString.optString("sourceId");
          this.jdField_c_of_type_Long = paramString.optLong("pkgSize");
          this.jdField_a_of_type_Boolean = paramString.optBoolean("isRes");
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_e_of_type_JavaLangString = paramString.optString("resUrl");
          }
          else
          {
            this.jdField_e_of_type_JavaLangString = paramString.optString("apkUrl");
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              this.jdField_e_of_type_JavaLangString = paramString.optString("url");
            }
          }
          this.jdField_f_of_type_Int = paramString.optInt("resIndex");
          this.jdField_g_of_type_JavaLangString = paramString.optString("resVersionCode");
          this.jdField_h_of_type_JavaLangString = paramString.optString("resName");
          this.jdField_i_of_type_JavaLangString = paramString.optString("resMD5");
          this.jdField_d_of_type_JavaLangString = paramString.optString("resDir");
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
    if (this.jdField_a_of_type_Boolean) {
      return a(this.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_Int, this.jdField_e_of_type_Int, this.jdField_h_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = ((paramInt ^ 0xFFFFFFFF) & this.jdField_c_of_type_Int);
  }
  
  public void a(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_j_of_type_JavaLangString = paramParcel.readString();
      this.k = paramParcel.readString();
      int i1 = paramParcel.readInt();
      boolean bool2 = true;
      boolean bool1;
      if (i1 > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_b_of_type_Boolean = bool1;
      this.m = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.l = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.n = paramParcel.readString();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      if (paramParcel.readInt() > 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.jdField_i_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_j_of_type_Int = paramParcel.readInt();
    }
  }
  
  public void a(WadlParams paramWadlParams)
  {
    this.jdField_c_of_type_Int = paramWadlParams.jdField_c_of_type_Int;
    this.jdField_h_of_type_Int = paramWadlParams.jdField_h_of_type_Int;
    this.m = paramWadlParams.m;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_c_of_type_Int & paramInt) == paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = (paramInt | this.jdField_c_of_type_Int);
  }
  
  public boolean b(int paramInt)
  {
    return (this.jdField_j_of_type_Int & paramInt) == paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_j_of_type_Int = (paramInt | this.jdField_c_of_type_Int);
  }
  
  public void d(int paramInt)
  {
    this.jdField_j_of_type_Int = ((paramInt ^ 0xFFFFFFFF) & this.jdField_j_of_type_Int);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WadlParams{actionCode='");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isRes='");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resType=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", apkUrl='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", delayDownload=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", extraData='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apkChannel='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", via='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", fromWebUrl=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", yyStartTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", yyEndTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", adtag='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resName='");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resIndex='");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resMD5='");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resDir='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkgSize=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", ignoreSpace=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(", channelNum=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(", isCancelRequest=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", extFlags=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlParams
 * JD-Core Version:    0.7.0.1
 */