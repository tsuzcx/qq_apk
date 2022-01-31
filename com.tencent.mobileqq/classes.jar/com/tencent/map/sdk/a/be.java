package com.tencent.map.sdk.a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
      for (;;)
      {
        Object localObject4;
        Object localObject3;
        long l2;
        try
        {
          Object localObject1 = new URL(this.b);
          String str1 = ((URL)localObject1).getHost();
          this.w = new bd((URL)localObject1, this.b);
          boolean bool = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
          List localList = this.w.a(this.y, bool);
          int n = localList.size();
          long l1 = SystemClock.elapsedRealtime();
          if (n > 1)
          {
            i = this.f / 2;
            int j = 0;
            if (j >= n) {
              break;
            }
            this.n.incrementAndGet();
            this.z = ((ad)localList.get(j));
            localObject1 = this.z;
            if ((((ad)localObject1).e == 3) || (((ad)localObject1).e == 4)) {
              break label597;
            }
            k = 1;
            if (k != 0) {
              this.s = true;
            }
            localObject4 = this.w;
            localObject1 = this.z;
            if (!((ad)localObject1).b()) {
              break label602;
            }
            localObject3 = ((bd)localObject4).b;
            this.B = ((String)localObject3);
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
              break label871;
            }
            i = 1;
            k = i;
            if (i == 0)
            {
              k = i;
              if (this.v.a == -4)
              {
                k = as.a("direct_nonet_retry_gap", 0, 10000, 3000);
                l2 = this.u.o;
                if (l2 < k) {
                  break label876;
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
          i = this.f;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.v.a = -300;
          return this.v;
        }
        continue;
        label597:
        int k = 0;
        continue;
        label602:
        String str2;
        if (!((bd)localObject4).a.getProtocol().startsWith("https"))
        {
          localObject3 = "http://" + localMalformedURLException.a + ":" + localMalformedURLException.b;
          label653:
          str2 = ((bd)localObject4).a.getFile();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str2)) {
            if (!str2.startsWith("/")) {
              break label840;
            }
          }
        }
        label840:
        for (Object localObject2 = (String)localObject3 + str2;; localObject2 = (String)localObject3 + "/" + str2)
        {
          localObject4 = ((bd)localObject4).a.getRef();
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject3 = (String)localObject2 + "#" + (String)localObject4;
          break;
          if (((bd)localObject4).c != 0)
          {
            localObject3 = "https://" + ((ad)localObject2).a + ":" + ((bd)localObject4).c;
            break label653;
          }
          localObject3 = "https://" + ((ad)localObject2).a + ":443";
          break label653;
        }
        label871:
        int i = 0;
        continue;
        label876:
        SystemClock.sleep(dg.a((int)(k - l2), 200, k, 200));
        k = i;
      }
      return this.v;
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
    if (this.u != null)
    {
      if (this.j) {
        this.u.j = true;
      }
      localHashMap1 = new HashMap();
      if (paramBoolean) {
        break label505;
      }
      localHashMap1.put("B22", this.l);
      if (!dg.a(this.p)) {
        localHashMap1.put("B15", this.p);
      }
      if (!dg.a(this.A)) {
        localHashMap1.put("B54", this.A);
      }
      localHashMap2 = new HashMap();
      localHashMap2.put("B82", this.h);
      if (this.r)
      {
        localHashMap1.put("B52", "1");
        localHashMap1.put("B58", this.t);
      }
      localHashMap2.put("B44", this.a);
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.B))) {
        localHashMap2.put("B49", this.B);
      }
      if (this.z != null)
      {
        if (!this.z.b()) {
          localHashMap2.put("B10", this.z.a());
        }
        if (this.z.c != -1) {
          localHashMap2.put("B45", this.z.c);
        }
        localHashMap2.put("B202", this.z.e);
        localHashMap2.put("B204", this.z.d);
        localStringBuilder = new StringBuilder();
        if (!this.s) {
          break label521;
        }
      }
    }
    for (;;)
    {
      localHashMap2.put("B203", i);
      localHashMap2.put("B53", this.n.get());
      if (!TextUtils.isEmpty(this.w.d)) {
        localHashMap2.put("B26", this.w.d);
      }
      if (this.k) {
        localHashMap2.put("B97", "1");
      }
      this.u.a(localHashMap1, localHashMap2);
      return;
      label505:
      localHashMap1.put("B46", "1");
      break;
      label521:
      i = 0;
    }
  }
  
  public final boolean b()
  {
    this.m = true;
    if (this.u != null) {
      this.u.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.be
 * JD-Core Version:    0.7.0.1
 */