package com.tencent.luggage.wxa.do;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dw.b;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.jj.m;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends h
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public com.tencent.luggage.wxa.dx.a a;
  public String b;
  public int c;
  public boolean d;
  public String e = "";
  public String f;
  public String g;
  public final j h;
  public final m i;
  public String j;
  public String k;
  public long l;
  public long m;
  public int n;
  public int o;
  public s.f p;
  public String q;
  public int r;
  public boolean s;
  public b<?> t;
  public com.tencent.luggage.wxa.dw.d u;
  public String v;
  private String w;
  private String x;
  private boolean y;
  private transient com.tencent.luggage.wxa.ou.d z;
  
  public c()
  {
    this.y = false;
    this.u = com.tencent.luggage.wxa.dw.d.a;
    this.h = new j();
    this.i = new m();
  }
  
  protected c(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool2 = false;
    this.y = false;
    this.u = com.tencent.luggage.wxa.dw.d.a;
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.b = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = ((j)paramParcel.readParcelable(j.class.getClassLoader()));
    this.i = ((m)paramParcel.readParcelable(m.class.getClassLoader()));
    this.j = paramParcel.readString();
    this.c = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    this.k = paramParcel.readString();
    this.l = paramParcel.readLong();
    this.m = paramParcel.readLong();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = ((s.f)paramParcel.readParcelable(s.f.class.getClassLoader()));
    this.q = paramParcel.readString();
    this.a = ((com.tencent.luggage.wxa.dx.a)paramParcel.readParcelable(com.tencent.luggage.wxa.dx.a.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.y = bool1;
    this.t = com.tencent.luggage.wxa.dw.c.a(paramParcel);
    this.u = com.tencent.luggage.wxa.dw.d.a(paramParcel);
    this.v = paramParcel.readString();
    this.r = paramParcel.readInt();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.s = bool1;
  }
  
  public final String a()
  {
    return this.a.toString();
  }
  
  public void a(com.tencent.luggage.wxa.ou.d paramd)
  {
    this.z = paramd;
  }
  
  public final void a(String paramString)
  {
    junit.framework.a.b(TextUtils.isEmpty(paramString));
    this.x = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public final String b()
  {
    return this.p.k;
  }
  
  public final boolean c()
  {
    boolean bool1 = af.c(b());
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(b()).optJSONArray("call_plugin_info");
      bool1 = bool2;
      if (localJSONArray != null)
      {
        int i1 = localJSONArray.length();
        bool1 = bool2;
        if (i1 > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean d()
  {
    return this.y;
  }
  
  public final void e()
  {
    f localf2 = f.a.a;
    f localf1 = localf2;
    if (localf2 == null) {
      localf1 = f.a;
    }
    this.w = localf1.a(this);
  }
  
  public com.tencent.luggage.wxa.ou.d f()
  {
    return this.z;
  }
  
  public final boolean g()
  {
    return this.c == 4;
  }
  
  public final String h()
  {
    return this.w;
  }
  
  public final String i()
  {
    return this.x;
  }
  
  public JSONObject j()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("shareKey", this.g);
      localJSONObject2.put("shareName", this.f);
      JSONObject localJSONObject1 = localJSONObject2;
      if (localJSONObject2.length() == 0) {
        localJSONObject1 = null;
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public JSONObject k()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("appId", this.D);
      localJSONObject2.put("nickname", this.E);
      localJSONObject2.put("icon", this.F);
      JSONObject localJSONObject1 = localJSONObject2;
      if (localJSONObject2.length() == 0) {
        localJSONObject1 = null;
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  @Nullable
  public final JSONObject l()
  {
    j localj = this.h;
    if ((localj != null) && (2 == localj.a) && (TextUtils.isEmpty(this.h.b))) {
      return null;
    }
    return this.h.a();
  }
  
  public c m()
  {
    return (c)super.n();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandInitConfigLU {visitingSessionId='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", username='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.D);
    localStringBuilder.append('\'');
    localStringBuilder.append(", brandName='");
    localStringBuilder.append(this.E);
    localStringBuilder.append('\'');
    localStringBuilder.append(", debugType=");
    localStringBuilder.append(this.G);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", orientation='");
    localStringBuilder.append(this.H);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enterPath='");
    localStringBuilder.append(this.I);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareName='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareKey='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", referrer=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", extInfo=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("， processIndex=");
    localStringBuilder.append(this.r);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @CallSuper
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.do.c
 * JD-Core Version:    0.7.0.1
 */