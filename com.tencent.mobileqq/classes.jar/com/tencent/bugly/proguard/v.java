package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class v
  implements Runnable
{
  private int a = 2;
  private int b = 30000;
  private final Context c;
  private final int d;
  private final byte[] e;
  private final com.tencent.bugly.crashreport.common.info.a f;
  private final com.tencent.bugly.crashreport.common.strategy.a g;
  private final s h;
  private final u i;
  private final int j;
  private final t k;
  private final t l;
  private String m = null;
  private final String n;
  private final Map<String, String> o;
  private int p = 0;
  private long q = 0L;
  private long r = 0L;
  private boolean s = false;
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.c = paramContext;
    this.f = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.e = paramArrayOfByte;
    this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.h = s.a(paramContext);
    this.i = u.a();
    this.j = paramInt1;
    this.m = paramString1;
    this.n = paramString2;
    this.k = paramt;
    this.l = this.i.a;
    this.d = paramInt2;
    if (paramInt3 > 0) {
      this.a = paramInt3;
    }
    if (paramInt4 > 0) {
      this.b = paramInt4;
    }
    this.s = paramBoolean;
    this.o = paramMap;
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramt, 2, 30000, paramBoolean2, null);
  }
  
  private static String a(String paramString)
  {
    if (z.a(paramString)) {
      return paramString;
    }
    try
    {
      String str = String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
      return str;
    }
    catch (Throwable localThrowable)
    {
      x.a(localThrowable);
    }
    return paramString;
  }
  
  private void a(an paraman, boolean paramBoolean, int paramInt, String paramString)
  {
    String str;
    switch (this.d)
    {
    default: 
      str = String.valueOf(this.d);
      if (paramBoolean) {
        x.a("[Upload] Success: %s", new Object[] { str });
      }
      break;
    }
    for (;;)
    {
      if (this.q + this.r > 0L)
      {
        long l1 = this.i.a(this.s);
        long l2 = this.q;
        long l3 = this.r;
        this.i.a(l1 + l2 + l3, this.s);
      }
      if (this.k != null) {
        this.k.a(this.d, paraman, this.q, this.r, paramBoolean, paramString);
      }
      if (this.l != null) {
        this.l.a(this.d, paraman, this.q, this.r, paramBoolean, paramString);
      }
      return;
      str = "crash";
      break;
      str = "userinfo";
      break;
      x.e("[Upload] Failed to upload(%d) %s: %s", new Object[] { Integer.valueOf(paramInt), str, paramString });
    }
  }
  
  private static boolean a(an paraman, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    if (paraman == null)
    {
      x.d("resp == null!", new Object[0]);
      return false;
    }
    if (paraman.a != 0)
    {
      x.e("resp result error %d", new Object[] { Byte.valueOf(paraman.a) });
      return false;
    }
    try
    {
      if ((!z.a(paraman.d)) && (!com.tencent.bugly.crashreport.common.info.a.b().h().equals(paraman.d)))
      {
        p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "gateway", paraman.d.getBytes("UTF-8"), null, true);
        parama.d(paraman.d);
      }
      if ((!z.a(paraman.f)) && (!com.tencent.bugly.crashreport.common.info.a.b().i().equals(paraman.f)))
      {
        p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "device", paraman.f.getBytes("UTF-8"), null, true);
        parama.e(paraman.f);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        x.a(localThrowable);
      }
      parama = (ap)a.a(paraman.c, ap.class);
      if (parama != null) {
        break label254;
      }
      x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", new Object[] { Integer.valueOf(paraman.b) });
      return false;
      label254:
      parama1.a(parama);
    }
    parama.l = paraman.e;
    if (paraman.b == 510) {
      if (paraman.c == null)
      {
        x.e("[Upload] Strategy data is null. Response cmd: %d", new Object[] { Integer.valueOf(paraman.b) });
        return false;
      }
    }
    return true;
  }
  
  public final void a(long paramLong)
  {
    this.p += 1;
    this.q += paramLong;
  }
  
  public final void b(long paramLong)
  {
    this.r += paramLong;
  }
  
  public final void run()
  {
    try
    {
      this.p = 0;
      this.q = 0L;
      this.r = 0L;
      byte[] arrayOfByte1 = this.e;
      if (b.c(this.c) == null)
      {
        a(null, false, 0, "network is not available");
        return;
      }
      if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0)) {
        break label80;
      }
      a(null, false, 0, "request package is empty!");
      return;
    }
    catch (Throwable localThrowable1)
    {
      if (x.a(localThrowable1)) {
        break label1371;
      }
    }
    localThrowable1.printStackTrace();
    return;
    label80:
    x.c("[Upload] Run upload task with cmd: %d", new Object[] { Integer.valueOf(this.d) });
    if ((this.c == null) || (this.f == null) || (this.g == null) || (this.h == null))
    {
      a(null, false, 0, "illegal access error");
      return;
    }
    Object localObject2 = this.g.c();
    if (localObject2 == null)
    {
      a(null, false, 0, "illegal local strategy");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("prodId", this.f.e());
    localHashMap.put("bundleId", this.f.c);
    localHashMap.put("appVer", this.f.m);
    if (this.o != null) {
      localHashMap.putAll(this.o);
    }
    localHashMap.put("cmd", Integer.toString(this.d));
    localHashMap.put("platformId", Byte.toString((byte)1));
    localHashMap.put("sdkVer", this.f.g);
    localHashMap.put("strategylastUpdateTime", Long.toString(((StrategyBean)localObject2).o));
    byte[] arrayOfByte2 = z.a(localThrowable1, 2);
    if (arrayOfByte2 == null)
    {
      a(null, false, 0, "failed to zip request body");
      return;
    }
    if (arrayOfByte2 == null)
    {
      a(null, false, 0, "failed to encrypt request body");
      return;
    }
    this.i.a(this.j, System.currentTimeMillis());
    if (this.k != null) {
      this.k.a(this.d);
    }
    if (this.l != null) {
      this.l.a(this.d);
    }
    Object localObject1 = this.m;
    i4 = -1;
    i1 = 0;
    int i2 = 0;
    Object localObject3;
    for (;;)
    {
      int i3 = i1 + 1;
      if (i1 >= this.a) {
        break label1355;
      }
      localObject2 = localObject1;
      if (i3 > 1)
      {
        x.d("[Upload] Failed to upload last time, wait and try(%d) again.", new Object[] { Integer.valueOf(i3) });
        z.b(this.b);
        localObject2 = localObject1;
        if (i3 == this.a)
        {
          x.d("[Upload] Use the back-up url at the last time: %s", new Object[] { this.n });
          localObject2 = this.n;
        }
      }
      x.c("[Upload] Send %d bytes", new Object[] { Integer.valueOf(arrayOfByte2.length) });
      localObject1 = a((String)localObject2);
      x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", new Object[] { localObject1, Integer.valueOf(this.d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      localObject2 = this.h.a((String)localObject1, arrayOfByte2, this, localHashMap);
      if (localObject2 == null)
      {
        x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "Failed to upload for no response!" });
        i2 = 1;
        i1 = i3;
      }
      else
      {
        localObject3 = this.h.a;
        if ((localObject3 == null) || (((Map)localObject3).size() == 0))
        {
          x.d("[Upload] Headers is empty.", new Object[0]);
          i1 = 0;
        }
        for (;;)
        {
          if (i1 == 0)
          {
            x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
            x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "[Upload] Failed to upload for no status header." });
            if (localObject3 != null)
            {
              localObject2 = ((Map)localObject3).entrySet().iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (Map.Entry)((Iterator)localObject2).next();
                  x.c(String.format("[key]: %s, [value]: %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() }), new Object[0]);
                  continue;
                  if (!((Map)localObject3).containsKey("status"))
                  {
                    x.d("[Upload] Headers does not contain %s", new Object[] { "status" });
                    i1 = 0;
                    break;
                  }
                  if (!((Map)localObject3).containsKey("Bugly-Version"))
                  {
                    x.d("[Upload] Headers does not contain %s", new Object[] { "Bugly-Version" });
                    i1 = 0;
                    break;
                  }
                  String str = (String)((Map)localObject3).get("Bugly-Version");
                  if (!str.contains("bugly"))
                  {
                    x.d("[Upload] Bugly version is not valid: %s", new Object[] { str });
                    i1 = 0;
                    break;
                  }
                  x.c("[Upload] Bugly version from headers is: %s", new Object[] { str });
                  i1 = 1;
                  break;
                }
              }
            }
            x.c("[Upload] Failed to upload for no status header.", new Object[0]);
            i2 = 1;
            i1 = i3;
            break;
          }
        }
      }
      for (;;)
      {
        try
        {
          i1 = Integer.parseInt((String)((Map)localObject3).get("status"));
        }
        catch (Throwable localThrowable3)
        {
          i1 = i4;
          continue;
        }
        try
        {
          x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", new Object[] { Integer.valueOf(i1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          if (i1 == 0) {
            continue;
          }
          a(null, false, 1, "status of server is " + i1);
          return;
        }
        catch (Throwable localThrowable2) {}
      }
      x.e("[Upload] Failed to upload(%d): %s", new Object[] { Integer.valueOf(1), "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i1) });
      i2 = 1;
      i4 = i1;
      i1 = i3;
    }
    x.c("[Upload] Received %d bytes", new Object[] { Integer.valueOf(localObject2.length) });
    if (localObject2.length == 0)
    {
      localObject1 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        x.c("[Upload] HTTP headers from server: key = %s, value = %s", new Object[] { ((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue() });
      }
      a(null, false, 1, "response data from server is empty");
      return;
    }
    if (localObject2 == null)
    {
      a(null, false, 1, "failed to decrypt response from server");
      return;
    }
    localObject1 = z.b((byte[])localObject2, 2);
    if (localObject1 == null)
    {
      a(null, false, 1, "failed unzip(Gzip) response from server");
      return;
    }
    localObject1 = a.b((byte[])localObject1);
    if (localObject1 == null)
    {
      a(null, false, 1, "failed to decode response package");
      return;
    }
    i2 = ((an)localObject1).b;
    if (((an)localObject1).c == null) {}
    for (i1 = 0;; i1 = ((an)localObject1).c.length)
    {
      x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
      if (a((an)localObject1, this.f, this.g)) {
        break;
      }
      a((an)localObject1, false, 2, "failed to process response package");
      return;
    }
    a((an)localObject1, true, 2, "successfully uploaded");
    return;
    label1355:
    a(null, false, i2, "failed after many attempts");
    return;
    label1371:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.v
 * JD-Core Version:    0.7.0.1
 */