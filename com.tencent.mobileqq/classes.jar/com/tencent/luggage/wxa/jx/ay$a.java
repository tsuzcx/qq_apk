package com.tencent.luggage.wxa.jx;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.ipc.b;
import org.json.JSONObject;

class ay$a
  extends b
{
  public static final Parcelable.Creator<a> CREATOR = new ay.a.1();
  private m a;
  private c b;
  private int c;
  private String d;
  private String e;
  private boolean f;
  private String g;
  
  public ay$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public ay$a(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
  {
    this.a = paramm;
    this.b = paramc;
    this.c = paramInt;
    this.d = paramJSONObject.optString("packageName");
    this.e = paramJSONObject.optString("data");
    this.f = true;
  }
  
  private void c()
  {
    if (af.c(this.d))
    {
      o.b("MicroMsg.JsApiWriteCommData", "packageName nil");
      return;
    }
    Context localContext = r.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(r.b());
    localStringBuilder.append("_comm_preferences");
    this.f = (localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString(this.d, this.e).commit() ^ true);
  }
  
  public void a()
  {
    c();
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.f = bool;
    this.g = paramParcel.readString();
  }
  
  public void b()
  {
    if (this.f)
    {
      String str;
      if (af.c(this.g)) {
        str = "fail";
      } else {
        str = String.format("fail:%s", new Object[] { this.g });
      }
      this.b.a(this.c, this.a.b(str));
      return;
    }
    this.b.a(this.c, this.a.b("ok"));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ay.a
 * JD-Core Version:    0.7.0.1
 */