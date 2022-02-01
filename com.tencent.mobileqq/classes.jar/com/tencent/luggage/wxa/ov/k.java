package com.tencent.luggage.wxa.ov;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ou.l;
import com.tencent.luggage.wxa.ou.l.a;
import com.tencent.luggage.wxa.qw.lr;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public final class k
{
  private static final k m = new k(true, h.a);
  public String a;
  public String b;
  public int c;
  public String d;
  public int e;
  public String f;
  public String g;
  public int h;
  public int i;
  public String j;
  public int k;
  private final boolean l;
  private final h n;
  
  private k(boolean paramBoolean, h paramh)
  {
    this.l = paramBoolean;
    this.n = paramh;
  }
  
  public static k a()
  {
    return m;
  }
  
  public static k a(com.tencent.luggage.wxa.ed.d paramd, String paramString, h paramh)
  {
    paramh = new k(false, paramh);
    try
    {
      paramh.b = paramString;
      paramh.a = paramd.aa();
      paramString = paramd.l();
      paramh.c = paramString.c;
      paramh.d = paramString.d;
      paramh.e = paramString.a;
      paramh.f = paramString.b;
      paramh.h = paramString.e;
      paramh.i = (paramd.j().G + 1);
      return paramh;
    }
    catch (Exception paramd)
    {
      o.a("MicroMsg.AppBrand.Report.kv_14004", paramd, "Kv_14004 protect the npe", new Object[0]);
    }
    return paramh;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (af.b(paramString).length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    return str;
  }
  
  private void b()
  {
    if (this.l) {
      return;
    }
    this.g = a(this.g);
    this.j = a(this.j);
    lr locallr = new lr();
    locallr.a = 1;
    locallr.b = this.a;
    locallr.c = this.g;
    locallr.d = 0;
    locallr.e = ((int)af.a());
    locallr.f = 1;
    locallr.g = "";
    locallr.h = this.i;
    locallr.i = this.b;
    locallr.j = com.tencent.luggage.wxa.ou.h.a();
    locallr.k = this.c;
    locallr.l = this.h;
    locallr.m = this.d;
    locallr.n = this.j;
    locallr.o = this.e;
    locallr.q = this.f;
    locallr.r = this.k;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report ");
    ((StringBuilder)localObject).append(toString());
    o.d("MicroMsg.AppBrand.Report.kv_14004", ((StringBuilder)localObject).toString());
    localObject = l.a.a();
    if (localObject == null)
    {
      o.b("MicroMsg.AppBrand.Report.kv_14004", "report() get null protocol impl");
      return;
    }
    ((l)localObject).a(locallr);
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    b(paramc);
  }
  
  public void b(com.tencent.luggage.wxa.dq.c paramc)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kv_14004{appId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sessionId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sceneNote='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", preScene=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", preSceneNote='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pagePath='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", usedState=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", referPagePath='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEntrance=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.k
 * JD-Core Version:    0.7.0.1
 */