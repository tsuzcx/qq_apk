package com.tencent.luggage.wxa.jz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.a;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class j$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new j.a.1();
  public String a;
  public boolean b = false;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g;
  public String h;
  private m i;
  private com.tencent.luggage.wxa.jx.c j;
  private int k;
  
  public j$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public j$a(m paramm, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    this.i = paramm;
    this.j = paramc;
    this.k = paramInt;
  }
  
  public void a()
  {
    Object localObject = com.tencent.luggage.wxa.nr.b.b().c();
    if ((!af.c((String)localObject)) && (!((String)localObject).equals(this.a)))
    {
      o.d("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
      this.b = true;
      this.h = "appid not match cannot operate";
      e();
      return;
    }
    localObject = a.f();
    if (localObject != null)
    {
      com.tencent.luggage.wxa.ig.c localc = a.g();
      int m = -1;
      int n;
      if (localc != null)
      {
        m = localc.a();
        n = localc.b();
        this.e = localc.c();
        this.f = localc.d();
      }
      else
      {
        n = -1;
      }
      this.c = (m / 1000);
      this.d = (n / 1000);
      this.g = ((e)localObject).i;
      this.h = "";
      this.b = false;
    }
    else
    {
      this.e = 2;
      this.h = "";
      this.b = false;
    }
    o.d("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), this.g });
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.c));
    localHashMap.put("currentPosition", Integer.valueOf(this.d));
    localHashMap.put("status", Integer.valueOf(this.e));
    localHashMap.put("downloadPercent", Integer.valueOf(this.f));
    localHashMap.put("dataUrl", this.g);
    com.tencent.luggage.wxa.jx.c localc = this.j;
    int m = this.k;
    m localm = this.i;
    Object localObject;
    if (this.b)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail");
      if (TextUtils.isEmpty(this.h))
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.h);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "ok";
    }
    localc.a(m, localm.a((String)localObject, localHashMap));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.j.a
 * JD-Core Version:    0.7.0.1
 */