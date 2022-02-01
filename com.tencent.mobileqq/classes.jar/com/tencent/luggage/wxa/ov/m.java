package com.tencent.luggage.wxa.ov;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.k;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;

public final class m
{
  private static final m w = new m(true);
  private boolean A = true;
  public int a;
  public String b;
  public String c;
  public String d;
  public com.tencent.luggage.wxa.ed.d e;
  public int f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  public int m;
  public String n;
  public long o;
  public int p;
  public int q;
  public String r;
  public int s;
  public String t;
  public int u;
  private final boolean v;
  private String x = "";
  private final LinkedList<String> y = new LinkedList();
  private boolean z = false;
  
  private m(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public static m a()
  {
    return w;
  }
  
  public static m a(com.tencent.luggage.wxa.ed.d paramd, String paramString, LinkedList<String> paramLinkedList)
  {
    m localm = new m(false);
    localm.c = paramString;
    paramString = paramd.l();
    localm.a = paramString.c;
    localm.b = paramString.d;
    localm.d = paramd.aa();
    localm.e = paramd;
    if (paramd.i() == null)
    {
      localm.g = (paramd.ab() + 1);
      localm.f = paramd.j().n;
    }
    else
    {
      localm.g = (paramd.i().c() + 1);
      localm.f = paramd.i().S.pkgVersion;
    }
    localm.h = paramString.e;
    localm.q = paramString.a;
    localm.r = paramString.b;
    if (paramLinkedList != null) {
      localm.y.addAll(paramLinkedList);
    }
    return localm;
  }
  
  private void a(com.tencent.luggage.wxa.dq.c paramc, com.tencent.luggage.wxa.mq.a parama)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString)
  {
    this.y.pollFirst();
    this.y.push(com.tencent.luggage.wxa.qz.af.b(paramString));
  }
  
  private void b(com.tencent.luggage.wxa.dq.c paramc)
  {
    com.tencent.luggage.wxa.mq.a locala = paramc.c();
    if (locala == null) {
      return;
    }
    a(paramc, locala);
    c();
  }
  
  private void c()
  {
    if (this.v) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report ");
    ((StringBuilder)localObject).append(toString());
    o.d("MicroMsg.AppBrand.Report.kv_14992", ((StringBuilder)localObject).toString());
    localObject = new m.1(this, new Object[] { Integer.valueOf(this.a), this.b, this.c, this.d, Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), this.i, this.j, this.k, this.l, Integer.valueOf(this.m), this.n, Long.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.q), this.r, Integer.valueOf(this.s), this.t, Integer.valueOf(this.u) });
    if (this.z)
    {
      ((Runnable)localObject).run();
      return;
    }
    com.tencent.luggage.wxa.pd.d.a().c((Runnable)localObject);
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc)
  {
    this.l = ((String)this.y.peekFirst());
    this.n = null;
    int i1 = m.2.a[com.tencent.luggage.wxa.iu.c.i(this.d).ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          Intent localIntent = this.e.k().getReporter().b();
          if (localIntent != null)
          {
            if (localIntent.getComponent() == null)
            {
              o.b("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
              localObject = "";
            }
            else
            {
              localObject = localIntent.getComponent().getClassName();
            }
            this.m = 8;
            this.n = com.tencent.luggage.wxa.qz.af.a(k.a(localIntent, "appbrand_report_key_target_activity"), (String)localObject);
            a(this.n);
          }
          else
          {
            this.m = 7;
          }
        }
      }
      else {
        this.m = 6;
      }
    }
    else {
      this.m = 3;
    }
    Object localObject = com.tencent.luggage.wxa.rc.a.a(paramc.getContext());
    if ((localObject != null) && (((Activity)localObject).isFinishing())) {
      this.z = true;
    }
    b(paramc);
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.dq.c paramc, String paramString)
  {
    this.l = ((String)this.y.peekFirst());
    this.m = 2;
    this.n = paramString;
    this.y.push(paramc.an());
    this.x = paramc.an();
    b(paramc);
  }
  
  public void a(com.tencent.luggage.wxa.dq.c paramc, String paramString1, String paramString2)
  {
    this.l = ((String)this.y.peekFirst());
    this.m = 2;
    this.n = paramString2;
    this.y.push(paramString1);
    b(paramc);
  }
  
  public void a(com.tencent.luggage.wxa.dq.c paramc, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 7;
    }
    this.m = i1;
    String str = (String)this.y.pollFirst();
    this.n = str;
    this.l = str;
    if (!paramBoolean) {
      this.n = this.x;
    }
    b(paramc);
  }
  
  public void b()
  {
    this.A = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kv_4992{scene=");
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
    localStringBuilder.append(", currentUrl='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", referPagePath='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", targetAction=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", targetPagePath='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickTimestamp=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", publicLibVersion=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", preScene=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", preSceneNote='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEntrance=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", apptype=");
    localStringBuilder.append(this.u);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.m
 * JD-Core Version:    0.7.0.1
 */