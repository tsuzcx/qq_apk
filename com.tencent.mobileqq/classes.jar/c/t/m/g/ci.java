package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public final class ci
{
  private byte[] a = new byte[0];
  private Context b;
  private co c;
  private volatile Location d;
  private volatile Location e;
  private volatile List<ck> f;
  private volatile ck g;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  
  public ci(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getApplicationContext())
    {
      this.b = paramContext;
      if (this.b != null) {
        break;
      }
      throw new IllegalArgumentException("context cannot be null!");
    }
    try
    {
      paramContext = this.b.getExternalFilesDir("data").getAbsolutePath();
      if (!TextUtils.isEmpty(paramContext)) {
        this.c = new co(this.b, paramContext);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      this.c = null;
    }
  }
  
  private static Location a(Location paramLocation1, Location paramLocation2)
  {
    Location localLocation = paramLocation1;
    if (paramLocation1 == null) {
      localLocation = new Location("gps");
    }
    if (paramLocation2 != null) {
      localLocation.set(paramLocation2);
    }
    return localLocation;
  }
  
  public static String b()
  {
    return "1.2.8_180224";
  }
  
  private void c()
  {
    int m = 0;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.d;
    int n = arrayOfObject.length;
    int k = 0;
    if (k < n) {
      if (arrayOfObject[k] == null)
      {
        k = m;
        label44:
        if ((k != 0) && (!f.a.a(this.f))) {
          break label71;
        }
      }
    }
    label71:
    long l;
    do
    {
      do
      {
        return;
        k += 1;
        break;
        k = 1;
        break label44;
      } while ((this.c.c()) && (f.a.b(this.b) == 3));
      l = System.currentTimeMillis();
    } while (l - this.h >= 30000L);
    this.j = l;
    this.e = a(this.e, this.d);
    this.c.a(this.d, null, this.f);
  }
  
  private boolean d()
  {
    if (this.c == null) {
      return false;
    }
    return this.c.a();
  }
  
  private void e()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      co localco;
      if ((this.c != null) && (this.c.a())) {
        localco = this.c;
      }
      synchronized (localco.b)
      {
        if (!localco.a)
        {
          e();
          return;
        }
        localco.a = false;
        localco.b();
      }
    }
  }
  
  public final void a(Location paramLocation)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      if ((paramLocation == null) || (!"gps".equals(paramLocation.getProvider())) || (paramLocation.getAltitude() == 0.0D)) {
        break label127;
      }
      if ((Build.VERSION.SDK_INT >= 18) && (paramLocation.isFromMockProvider())) {
        return;
      }
    }
    this.d = a(this.d, paramLocation);
    if ((this.e == null) || ((this.d != null) && (this.d.distanceTo(this.e) >= 50.0F) && (System.currentTimeMillis() - this.j >= 5000L))) {
      c();
    }
    label127:
  }
  
  public final void a(Looper paramLooper)
  {
    synchronized (this.a)
    {
      e();
      co localco;
      if (this.c != null) {
        localco = this.c;
      }
      synchronized (localco.b)
      {
        if (localco.a) {
          return;
        }
        localco.a = true;
        localco.a(paramLooper);
      }
    }
  }
  
  public final void a(cj paramcj)
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        if (paramcj != null) {
          paramcj.a = this.b;
        }
        this.c.a(paramcj);
        cl.a("TxCoreDC", "appInfo:1.2.8," + cj.a(paramcj.c) + "_" + cj.a(paramcj.b) + "," + cj.a(Build.MANUFACTURER) + "," + cj.a(Build.MODEL));
      }
      return;
    }
  }
  
  public final void a(ck paramck, List<ck> paramList)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      this.f = paramList;
      this.h = System.currentTimeMillis();
      if ((paramck != null) && (!paramck.equals(this.g)))
      {
        this.g = paramck;
        c();
      }
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int k;
      synchronized (this.a)
      {
        if (this.c != null)
        {
          if (paramString2 == null) {
            break label132;
          }
          if (paramString2.length() == 0) {
            break label132;
          }
        }
        else
        {
          return;
        }
        k = 0;
      }
      label132:
      do
      {
        try
        {
          if ("D_CH_ID".equals(paramString1)) {
            cq.a(paramString2);
          }
          for (;;)
          {
            return;
            paramString1 = finally;
            throw paramString1;
            if (!"D_FC_SRC".equals(paramString1)) {
              break;
            }
            cq.b(paramString2);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cl.a("TxCoreDC", "set data[" + paramString1 + "," + paramString2 + "] error.", localThrowable);
            continue;
            this.c.a(paramString1, paramString2);
          }
        }
        k = 1;
      } while (k == 0);
    }
  }
  
  public final void a(List<ScanResult> paramList)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      if ((this.c == null) || (this.d == null) || (f.a.a(paramList))) {
        break label242;
      }
      if (paramList.size() == 1)
      {
        if (!"123456789abc".equals(((ScanResult)paramList.get(0)).BSSID.toLowerCase())) {
          break label173;
        }
        return;
      }
    }
    if (paramList.size() > 1)
    {
      if (paramList == null) {
        break label252;
      }
      if (paramList.size() <= 1) {
        break label252;
      }
    }
    for (;;)
    {
      Object localObject;
      if (k != 0)
      {
        return;
        localObject = ((ScanResult)paramList.get(0)).BSSID;
        k = 1;
      }
      for (;;)
      {
        if (k >= paramList.size()) {
          break label264;
        }
        if (!((String)localObject).equals(((ScanResult)paramList.get(k)).BSSID))
        {
          k = 0;
          break;
          label173:
          long l = System.currentTimeMillis();
          if ((this.c.c()) && (l - this.i < 5000L)) {
            return;
          }
          this.i = l;
          if (l - this.h < 30000L) {}
          for (localObject = this.f;; localObject = null)
          {
            this.c.a(this.d, paramList, (List)localObject);
            label242:
            return;
          }
          label252:
          k = 1;
          break;
        }
        k += 1;
      }
      label264:
      int k = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ci
 * JD-Core Version:    0.7.0.1
 */