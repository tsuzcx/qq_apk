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
      for (;;)
      {
        Object localObject4;
        long l2;
        try
        {
          Object localObject1 = new URL(this.b);
          String str1 = ((URL)localObject1).getHost();
          this.x = new ak((URL)localObject1, this.b);
          boolean bool = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
          List localList = this.x.a(this.z, bool);
          int n = localList.size();
          long l1 = SystemClock.elapsedRealtime();
          i = this.f;
          int j = 0;
          if (j >= n) {
            break;
          }
          this.n.incrementAndGet();
          this.A = ((n)localList.get(j));
          if (this.A.e < 3) {
            this.t = true;
          }
          localObject4 = this.x;
          localObject1 = this.A;
          if (((n)localObject1).b())
          {
            localObject3 = ((ak)localObject4).b;
            this.C = ((String)localObject3);
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
              break label817;
            }
            i = 1;
            k = i;
            if (i == 0)
            {
              k = i;
              if (this.w.a == -4)
              {
                k = x.a.a("direct_nonet_retry_gap", 0, 10000, 3000);
                l2 = this.v.o;
                if (l2 < k) {
                  break label822;
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
          if (((ak)localObject4).a.getProtocol().startsWith("https")) {
            break label707;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.w.a = -300;
          return this.w;
        }
        Object localObject3 = "http://" + localMalformedURLException.a + ":" + localMalformedURLException.b;
        label599:
        String str2 = ((ak)localObject4).a.getFile();
        Object localObject2 = localObject3;
        if (!TextUtils.isEmpty(str2)) {
          if (!str2.startsWith("/")) {
            break label786;
          }
        }
        label786:
        for (localObject2 = (String)localObject3 + str2;; localObject2 = (String)localObject3 + "/" + str2)
        {
          localObject4 = ((ak)localObject4).a.getRef();
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject3 = (String)localObject2 + "#" + (String)localObject4;
          break;
          label707:
          if (((ak)localObject4).c != 0)
          {
            localObject3 = "https://" + ((n)localObject2).a + ":" + ((ak)localObject4).c;
            break label599;
          }
          localObject3 = "https://" + ((n)localObject2).a + ":443";
          break label599;
        }
        label817:
        int i = 0;
        continue;
        label822:
        SystemClock.sleep(cn.a((int)(k - l2), 200, k, 200));
        int k = i;
      }
      return this.w;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 1;
    HashMap localHashMap1;
    HashMap localHashMap2;
    StringBuilder localStringBuilder;
    if (this.v != null)
    {
      if (this.i) {
        this.v.i = true;
      }
      localHashMap1 = new HashMap();
      if (paramBoolean) {
        break label531;
      }
      localHashMap1.put("B22", this.k);
      if (!cn.a(this.q)) {
        localHashMap1.put("B15", this.q);
      }
      if (!cn.a(this.B)) {
        localHashMap1.put("B54", this.B);
      }
      localHashMap2 = new HashMap();
      localHashMap2.put("B82", this.g);
      if (this.l != 0L) {
        localHashMap2.put("B83", this.l);
      }
      localHashMap2.put("B44", this.a);
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.C))) {
        localHashMap2.put("B49", this.C);
      }
      if (this.A != null)
      {
        if (!this.A.b()) {
          localHashMap2.put("B10", this.A.a());
        }
        if (this.A.c != -1) {
          localHashMap2.put("B45", this.A.c);
        }
        localHashMap2.put("B202", this.A.e);
        localHashMap2.put("B204", this.A.d);
        localStringBuilder = new StringBuilder();
        if (!this.t) {
          break label547;
        }
      }
    }
    for (;;)
    {
      localHashMap2.put("B203", i);
      localHashMap2.put("B53", this.n.get());
      if (!TextUtils.isEmpty(this.x.d)) {
        localHashMap2.put("B26", this.x.d);
      }
      if (this.j) {
        localHashMap2.put("B97", "1");
      }
      if (this.p != -1) {
        localHashMap2.put("B211", this.p);
      }
      this.v.a(localHashMap1, localHashMap2);
      return;
      label531:
      localHashMap1.put("B46", "1");
      break;
      label547:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.al
 * JD-Core Version:    0.7.0.1
 */