package c.t.m.g;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class al
  extends aj
{
  private static boolean r = false;
  private n A;
  private String B;
  private String C;
  public boolean o = true;
  public int p = -1;
  public String q;
  private boolean s = false;
  private boolean t = false;
  private int u;
  private ap v;
  private ao w;
  private ak x;
  private ai y = ai.a();
  private boolean z;
  
  public al(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean, String paramString3)
  {
    this.b = paramString1;
    this.c = false;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt;
    this.g = paramString2;
    this.s = false;
    this.u = 0;
    this.z = paramBoolean;
    this.B = paramString3;
  }
  
  public static al a(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    return new al(paramString1, paramMap, paramArrayOfByte, paramInt, paramString2, false, "");
  }
  
  public final ao a()
  {
    if (!r) {
      r = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.w = new ao(0, "");
      try
      {
        localObject1 = new URL(this.b);
        String str1 = ((URL)localObject1).getHost();
        this.x = new ak((URL)localObject1, this.b);
        boolean bool = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        List localList = this.x.a(this.z, bool);
        int n = localList.size();
        long l1 = SystemClock.elapsedRealtime();
        int i = this.f;
        int j = 0;
        while (j < n)
        {
          this.n.incrementAndGet();
          this.A = ((n)localList.get(j));
          if (this.A.e < 3) {
            this.t = true;
          }
          Object localObject3 = this.x;
          Object localObject2 = this.A;
          if (((n)localObject2).b())
          {
            localObject1 = ((ak)localObject3).b;
          }
          else
          {
            if (!((ak)localObject3).a.getProtocol().startsWith("https"))
            {
              localObject1 = new StringBuilder("http://");
              ((StringBuilder)localObject1).append(((n)localObject2).a);
              ((StringBuilder)localObject1).append(":");
              k = ((n)localObject2).b;
              ((StringBuilder)localObject1).append(k);
            }
            for (;;)
            {
              localObject2 = ((StringBuilder)localObject1).toString();
              break label358;
              if (((ak)localObject3).c != 0)
              {
                localObject1 = new StringBuilder("https://");
                ((StringBuilder)localObject1).append(((n)localObject2).a);
                ((StringBuilder)localObject1).append(":");
                k = ((ak)localObject3).c;
                break;
              }
              localObject1 = new StringBuilder("https://");
              ((StringBuilder)localObject1).append(((n)localObject2).a);
              ((StringBuilder)localObject1).append(":443");
            }
            label358:
            String str2 = ((ak)localObject3).a.getFile();
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
            localObject2 = ((ak)localObject3).a.getRef();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("#");
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = ((StringBuilder)localObject3).toString();
            }
          }
          this.C = ((String)localObject1);
          this.v = new ap(str1, this.C, this.c, this.d, this.e, i, this.g);
          if (j != 0) {
            this.v.r = true;
          }
          if ((x.i()) && (j != 0)) {
            this.v.p = true;
          }
          this.v.q = this.n.get();
          this.w = this.v.a();
          if (((this.v.i) || (this.w.c >= 500)) && (x.h()) && (this.t)) {
            ai.a(str1, this.A, this.w.a);
          }
          int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
          if (((this.w.a != 0) || (this.w.c < 200) || (this.w.c >= 400)) && (this.w.a != -20) && (this.w.a != -300) && (this.w.a != -306) && (j != n - 1) && (m > 200)) {
            i = 0;
          } else {
            i = 1;
          }
          int k = i;
          if (i == 0)
          {
            k = i;
            if (this.w.a == -4)
            {
              k = x.a.a("direct_nonet_retry_gap", 0, 10000, 3000);
              long l2 = this.v.o;
              long l3 = k;
              if (l2 >= l3)
              {
                k = 1;
              }
              else
              {
                SystemClock.sleep(cn.a((int)(l3 - l2), 200, k, 200));
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
        return this.w;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        label894:
        break label894;
      }
      localObject1 = this.w;
      ((ao)localObject1).a = -300;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.al
 * JD-Core Version:    0.7.0.1
 */