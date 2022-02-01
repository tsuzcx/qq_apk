package com.tencent.map.sdk.a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class be
  extends bc
{
  private static boolean q = false;
  private String A;
  private String B;
  public boolean o = true;
  public String p;
  private boolean r = false;
  private boolean s = false;
  private int t;
  private bi u;
  private bh v;
  private bd w;
  private bb x = bb.a();
  private boolean y;
  private ad z;
  
  public be(String paramString1, boolean paramBoolean1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramBoolean1;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt;
    this.h = paramString2;
    this.r = false;
    this.t = 0;
    this.y = paramBoolean2;
    this.A = paramString3;
  }
  
  public static be a(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    return new be(paramString1, false, paramMap, paramArrayOfByte, paramInt, paramString2, false, "");
  }
  
  public final bh a()
  {
    if (!q) {
      q = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.v = new bh(0, "");
      try
      {
        localObject1 = new URL(this.b);
        String str1 = ((URL)localObject1).getHost();
        this.w = new bd((URL)localObject1, this.b);
        boolean bool = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        List localList = this.w.a(this.y, bool);
        int n = localList.size();
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
          this.z = ((ad)localList.get(j));
          localObject1 = this.z;
          if ((((ad)localObject1).e != 3) && (((ad)localObject1).e != 4)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            this.s = true;
          }
          Object localObject3 = this.w;
          Object localObject2 = this.z;
          if (((ad)localObject2).b())
          {
            localObject1 = ((bd)localObject3).b;
          }
          else
          {
            if (!((bd)localObject3).a.getProtocol().startsWith("https"))
            {
              localObject1 = new StringBuilder("http://");
              ((StringBuilder)localObject1).append(((ad)localObject2).a);
              ((StringBuilder)localObject1).append(":");
              k = ((ad)localObject2).b;
              ((StringBuilder)localObject1).append(k);
            }
            for (;;)
            {
              localObject2 = ((StringBuilder)localObject1).toString();
              break label398;
              if (((bd)localObject3).c != 0)
              {
                localObject1 = new StringBuilder("https://");
                ((StringBuilder)localObject1).append(((ad)localObject2).a);
                ((StringBuilder)localObject1).append(":");
                k = ((bd)localObject3).c;
                break;
              }
              localObject1 = new StringBuilder("https://");
              ((StringBuilder)localObject1).append(((ad)localObject2).a);
              ((StringBuilder)localObject1).append(":443");
            }
            label398:
            String str2 = ((bd)localObject3).a.getFile();
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(str2)) {
              if (str2.startsWith("/"))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append(str2);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append("/");
                ((StringBuilder)localObject1).append(str2);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
            localObject2 = ((bd)localObject3).a.getRef();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("#");
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = ((StringBuilder)localObject3).toString();
            }
          }
          this.B = ((String)localObject1);
          this.u = new bi(str1, this.B, this.c, this.d, this.e, i, this.h);
          if ((j != 0) || (this.r)) {
            this.u.r = true;
          }
          if ((ao.j()) && (j != 0)) {
            this.u.p = true;
          }
          this.u.q = this.n.get();
          this.v = this.u.a();
          if ((this.s) && (this.v.a != 0) && (ao.i())) {
            bb.a(str1, this.z, this.v.a, this.v.c);
          }
          int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
          if (((this.v.a != 0) || (this.v.c < 200) || (this.v.c >= 400)) && (this.v.a != -20) && (this.v.a != -300) && (this.v.a != -306) && (this.v.a != -292) && (j != n - 1) && (m > 200)) {
            i = 0;
          } else {
            i = 1;
          }
          int k = i;
          if (i == 0)
          {
            k = i;
            if (this.v.a == -4)
            {
              k = as.a("direct_nonet_retry_gap", 0, 10000, 3000);
              long l2 = this.u.o;
              long l3 = k;
              if (l2 >= l3)
              {
                k = 1;
              }
              else
              {
                SystemClock.sleep(dg.a((int)(l3 - l2), 200, k, 200));
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
        return this.v;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        label948:
        break label948;
      }
      localObject1 = this.v;
      ((bh)localObject1).a = -300;
      return localObject1;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean b()
  {
    this.m = true;
    bi localbi = this.u;
    if (localbi != null) {
      localbi.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.be
 * JD-Core Version:    0.7.0.1
 */