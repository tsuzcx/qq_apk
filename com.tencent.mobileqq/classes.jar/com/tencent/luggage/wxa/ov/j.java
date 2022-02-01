package com.tencent.luggage.wxa.ov;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.rc.a;

public final class j
{
  private static final j B = new j(true, null);
  private final boolean A;
  private final h C;
  private boolean D = false;
  public int a;
  public String b;
  public String c;
  public String d;
  public com.tencent.luggage.wxa.iu.d e;
  public int f;
  public int g;
  public int h;
  public String i;
  public String j;
  public long k;
  public long l;
  public String m;
  public int n;
  public String o;
  public long p;
  public int q;
  public int r;
  public String s;
  public int t;
  public String u;
  public int v;
  public int w;
  public String x;
  public String y;
  public long z;
  
  private j(boolean paramBoolean, h paramh)
  {
    this.A = paramBoolean;
    this.C = paramh;
  }
  
  public static j a()
  {
    return B;
  }
  
  public static j a(com.tencent.luggage.wxa.ed.d paramd, String paramString, h paramh)
  {
    paramh = new j(false, paramh);
    paramh.c = paramString;
    paramString = paramd.l();
    paramh.a = paramString.c;
    paramh.b = paramString.d;
    paramh.d = paramd.aa();
    paramh.e = paramd;
    paramh.g = (paramd.j().G + 1);
    paramh.f = paramd.j().n;
    paramh.h = paramString.e;
    paramh.r = paramString.a;
    paramh.s = paramString.b;
    return paramh;
  }
  
  private void b()
  {
    if (this.A) {
      return;
    }
    j.1 local1 = new j.1(this, new Object[] { Integer.valueOf(this.a), this.b, this.c, this.d, Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), this.i, this.j, Long.valueOf(this.k), Long.valueOf(this.l), this.m, Integer.valueOf(this.n), this.o, Long.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), this.s, Integer.valueOf(this.t), this.u, Integer.valueOf(this.v), Integer.valueOf(this.w), this.x, this.y, Long.valueOf(this.z) });
    if (this.D)
    {
      local1.run();
      return;
    }
    com.tencent.luggage.wxa.pd.d.a().c(local1);
  }
  
  private void b(com.tencent.luggage.wxa.dq.c paramc)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    Activity localActivity = a.a(paramc.getContext());
    if ((localActivity != null) && (localActivity.isFinishing())) {
      this.D = true;
    }
    b(paramc);
    b();
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc, String paramString)
  {
    b(paramc);
    b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kv_13536{scene=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sceneNote='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sessionId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", usedState=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", pagePath='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", costTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", stayTime=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", referPagePath='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", targetAction=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", targetPagePath='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickTimestamp=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", publicLibVersion=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", preScene=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", preSceneNote='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEntrance=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", apptype=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", systemRecentsReason=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", referAction=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", manufacturerAppId=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", stayTimeFuncPageStart=");
    localStringBuilder.append(this.z);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.j
 * JD-Core Version:    0.7.0.1
 */