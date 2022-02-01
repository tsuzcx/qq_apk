package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.featuretoggle.hltxkg.common.a.c.d;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends a
{
  private static boolean o = false;
  private String A;
  private String B;
  private boolean p = true;
  private boolean q = false;
  private boolean r = false;
  private int s;
  private g t;
  private f u;
  private b v;
  private com.tencent.featuretoggle.hltxkg.common.b.a w = com.tencent.featuretoggle.hltxkg.common.b.a.a();
  private boolean x;
  private String y;
  private com.tencent.featuretoggle.hltxkg.common.a.a z;
  
  public c(String paramString1, boolean paramBoolean1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt1, String paramString2, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, d paramd, String paramString3)
  {
    this.b = paramString1;
    this.c = paramBoolean1;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt1;
    this.h = paramString2;
    this.q = false;
    this.s = 0;
    this.x = paramBoolean3;
    this.A = paramString3;
  }
  
  public static c a(String paramString1, boolean paramBoolean1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean2, d paramd)
  {
    return new c(paramString1, false, null, paramArrayOfByte, 15000, paramString2, false, 0, false, paramd, "");
  }
  
  public final f a()
  {
    if (!o) {
      o = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.u = new f(0, "", 0);
      try
      {
        Object localObject2 = new URL(this.b);
        localObject1 = ((URL)localObject2).getHost();
        this.v = new b((URL)localObject2, this.b);
        boolean bool = ((URL)localObject2).getProtocol().toLowerCase().startsWith("https");
        localObject2 = this.v.a(this.w, this.x, bool);
        int n = ((List)localObject2).size();
        long l1 = SystemClock.elapsedRealtime();
        int i;
        if (n > 1) {
          i = this.f / 2;
        } else {
          i = this.f;
        }
        int j = 0;
        while (j < n)
        {
          this.n.incrementAndGet();
          this.z = ((com.tencent.featuretoggle.hltxkg.common.a.a)((List)localObject2).get(j));
          if (this.z.f()) {
            this.r = true;
          }
          this.B = this.v.a(this.z);
          this.t = new g((String)localObject1, this.B, this.c, this.d, this.e, i, this.h);
          if ((j != 0) || (this.q)) {
            this.t.r = true;
          }
          if ((e.h()) && (j != 0)) {
            this.t.p = true;
          }
          this.t.q = this.n.get();
          Object localObject3 = this.t;
          bool = this.p;
          this.u = ((g)localObject3).a();
          if ((this.r) && (this.u.a != 0) && (e.g()))
          {
            localObject3 = this.w;
            com.tencent.featuretoggle.hltxkg.common.b.a.a((String)localObject1, this.z, this.u.a, this.u.c);
          }
          int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
          if (((this.u.a != 0) || (this.u.c < 200) || (this.u.c >= 400)) && (this.u.a != -20) && (this.u.a != -300) && (this.u.a != -306) && (this.u.a != -292) && (j != n - 1) && (m > 200)) {
            i = 0;
          } else {
            i = 1;
          }
          int k = i;
          if (i == 0)
          {
            k = i;
            if (this.u.a == -4)
            {
              k = i.a("direct_nonet_retry_gap", 0, 10000, 3000);
              long l2 = this.t.o;
              long l3 = k;
              if (l2 >= l3)
              {
                k = 1;
              }
              else
              {
                SystemClock.sleep(com.tencent.featuretoggle.hltxkg.common.e.c.a((int)(l3 - l2), 200, k, 200));
                k = i;
              }
            }
          }
          if (k != 0) {
            break;
          }
          a(true);
          j += 1;
          i = m;
        }
        return this.u;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        label605:
        break label605;
      }
      localObject1 = this.u;
      ((f)localObject1).a = -300;
      return localObject1;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(int paramInt) {}
  
  public final void a(String paramString)
  {
    this.y = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean b()
  {
    this.m = true;
    g localg = this.t;
    if (localg != null) {
      localg.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.c
 * JD-Core Version:    0.7.0.1
 */