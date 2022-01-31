package c.t.m.g;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class ag
  extends ae
{
  private static boolean p = false;
  public boolean o;
  private ak q;
  private aj r;
  private af s;
  private boolean t;
  private r u;
  private String v;
  private m w;
  private String x;
  private String y;
  
  public ag(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean, r paramr, String paramString3)
  {
    this.b = paramString1;
    this.c = false;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt;
    this.g = paramString2;
    this.t = paramBoolean;
    this.u = paramr;
    this.x = paramString3;
  }
  
  public static ag a(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, r paramr)
  {
    return new ag(paramString1, paramMap, paramArrayOfByte, paramInt, paramString2, true, paramr, "");
  }
  
  public final aj a()
  {
    if (!p) {
      p = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.r = new aj(0, "");
      for (;;)
      {
        long l2;
        try
        {
          URL localURL = new URL(this.b);
          this.s = new af(localURL, this.b, this.u);
          boolean bool = localURL.getProtocol().toLowerCase().startsWith("https");
          List localList = this.s.a(this.t, bool);
          int n = localList.size();
          long l1 = SystemClock.elapsedRealtime();
          i = this.f;
          int j = 0;
          if (j >= n) {
            break;
          }
          this.n.incrementAndGet();
          this.w = ((m)localList.get(j));
          this.y = this.s.a(this.w);
          this.q = new ak(localURL.getHost(), this.y, this.c, this.d, this.e, i, this.g);
          if (j != 0) {
            this.q.A = true;
          }
          if ((o.i()) && (j != 0)) {
            this.q.x = true;
          }
          if ((j == 1) && (((m)localList.get(0)).a.equals(this.b)) && (((m)localList.get(1)).a.equals(this.b))) {
            this.q.y = true;
          }
          this.q.z = this.n.get();
          this.r = this.q.a();
          if ((this.q.i) || (this.r.c >= 500))
          {
            if ((o.h()) && (this.w != null) && (!this.w.b())) {
              af.b(this.w);
            }
            int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
            if (((this.r.a != 0) || (this.r.c < 200) || (this.r.c >= 400)) && (this.r.a != -20) && (this.r.a != -300) && (this.r.a != -306) && (j != n - 1) && (m > 200)) {
              break label586;
            }
            i = 1;
            k = i;
            if (i == 0)
            {
              k = i;
              if (this.r.a == -4)
              {
                k = v.a("direct_nonet_retry_gap", 0, 10000, 3000);
                l2 = this.q.w;
                if (l2 < k) {
                  break label591;
                }
                k = 1;
              }
            }
            if (k != 0) {
              break;
            }
            a(true);
            j += 1;
            i = m;
            continue;
          }
          af.c(this.w);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.r.a = -300;
          return this.r;
        }
        continue;
        label586:
        int i = 0;
        continue;
        label591:
        SystemClock.sleep(ch.a((int)(k - l2), 200, k, 200));
        int k = i;
      }
      return this.r;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(String paramString)
  {
    this.v = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    HashMap localHashMap3;
    ak localak;
    HashMap localHashMap2;
    label480:
    int i;
    if (this.q != null)
    {
      if (this.i) {
        this.q.i = true;
      }
      localHashMap3 = new HashMap();
      if (paramBoolean) {
        break label876;
      }
      localHashMap3.put("B22", this.k);
      if (!ch.a(this.v)) {
        localHashMap3.put("B15", this.v);
      }
      if (!ch.a(this.x)) {
        localHashMap3.put("B54", this.x);
      }
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("B82", this.g);
      if (this.l != 0L) {
        localHashMap1.put("B83", this.l);
      }
      localHashMap1.put("B44", ch.b(this.a));
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.y))) {
        localHashMap1.put("B49", ch.b(this.y));
      }
      if (this.w != null)
      {
        if (!this.w.b()) {
          localHashMap1.put("B10", this.w.a());
        }
        if (this.w.c != -1) {
          localHashMap1.put("B45", this.w.c);
        }
      }
      localHashMap1.put("B53", this.n.get());
      if (!TextUtils.isEmpty(this.s.a)) {
        localHashMap1.put("B26", this.s.a);
      }
      if (this.j) {
        localHashMap1.put("B97", "1");
      }
      localak = this.q;
      localHashMap2 = new HashMap();
      localHashMap2.putAll(localHashMap3);
      localHashMap2.put("B59", localak.w);
      if (localak.p) {
        localHashMap2.put("B85", "1");
      }
      if (!localak.c) {
        break label893;
      }
      localHashMap2.put("B95", "1");
      if (!localak.q) {
        localHashMap2.put("B23", "1");
      }
      localHashMap3 = new HashMap();
      localHashMap3.putAll(localHashMap1);
      if (localak.m != 0L) {
        localHashMap3.put("B84", localak.m);
      }
      localHashMap3.put("B87", localak.r);
      localHashMap3.put("B88", localak.s);
      localHashMap3.put("B90", localak.v.g);
      localHashMap3.put("B91", localak.v.h);
      localHashMap3.put("B92", localak.v.i);
      localHashMap3.put("B93", localak.v.j);
      localHashMap3.put("B94", localak.v.k);
      if (!TextUtils.isEmpty(localak.h)) {
        localHashMap3.put("B47", ch.b(localak.h));
      }
      if (!TextUtils.isEmpty(localak.u)) {
        localHashMap3.put("B41", localak.u);
      }
      if (localak.o.a == 0) {
        break label925;
      }
      i = localak.o.a;
    }
    for (;;)
    {
      if (!localak.A) {
        break label956;
      }
      cd.a("HLHttpDirect", l.c(), i, localak.o.b, localHashMap2, localHashMap3, localak.i);
      return;
      label876:
      localHashMap3.put("B46", "1");
      break;
      label893:
      localHashMap2.put("B96", localak.t);
      break label480;
      label925:
      if (localak.o.c == 200) {
        i = 0;
      } else {
        i = localak.o.c;
      }
    }
    label956:
    cd.b("HLHttpDirect", l.c(), i, localak.o.b, localHashMap2, localHashMap3, localak.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ag
 * JD-Core Version:    0.7.0.1
 */