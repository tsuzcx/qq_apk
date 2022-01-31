package c.t.m.g;

import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public final class cr
  extends dj
{
  private final StringBuilder c = new StringBuilder();
  private final File d;
  private volatile long e = 0L;
  private volatile long f = 0L;
  private final long[] g = new long[2];
  private final int[] h = new int[2];
  
  public cr(File paramFile)
  {
    this.d = paramFile;
  }
  
  private void a(String paramString)
  {
    if (co.c(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = paramString.getBytes("UTF-8");
          paramString = cw.a((byte[])localObject, 3);
          if (co.e()) {
            co.a("srcBytes.len=" + localObject.length + ",encBytes.len=" + paramString.length);
          }
          localObject = "utr_" + co.b(cq.class.getName(), "SHA-256").substring(0, 8) + "_" + dq.b("yyyyMMdd");
          localObject = new File(this.d, (String)localObject);
          co.a((File)localObject, paramString, true);
          if (((File)localObject).length() > 51200L)
          {
            ((File)localObject).renameTo(new File(((File)localObject).getParent(), ((File)localObject).getName() + "_" + dq.b("HHmmss")));
            return;
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!co.e());
    co.a("writeStrToFile error.", paramString);
  }
  
  private void g()
  {
    this.f = System.currentTimeMillis();
    this.c.setLength(0);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.g, 0L);
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.e < 60000L) {
      if (co.e()) {
        co.a("last upload time: < 1min");
      }
    }
    for (;;)
    {
      return;
      this.e = l1;
      dv.a locala = dv.a(dp.a());
      boolean bool;
      if (locala == dv.a.a) {
        bool = false;
      }
      label167:
      while (bool)
      {
        i();
        return;
        if (locala == dv.a.b)
        {
          bool = cu.f;
          if ((cu.f) || (!cu.g)) {
            break label167;
          }
          long l2 = ((Long)dy.b("LocationSDK", "log_utr_up_in_m", Long.valueOf(l1))).longValue();
          if (l1 - l2 <= 86400000L) {
            break label167;
          }
          dy.a("LocationSDK", "log_utr_up_in_m", Long.valueOf(l1));
          if (co.e()) {
            co.a("upload in mobile once today. lastUpT=" + l2 + ",curT=" + l1);
          }
        }
        bool = true;
      }
    }
  }
  
  private void i()
  {
    int j = 0;
    File[] arrayOfFile;
    if ((this.d != null) && (this.d.exists()))
    {
      arrayOfFile = this.d.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label52;
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label57;
      }
      return;
      arrayOfFile = null;
      break;
    }
    label57:
    long l = System.currentTimeMillis();
    dv.a locala = dv.a(dp.a());
    String str2 = dq.b("yyyyMMdd");
    i = 0;
    label79:
    Object localObject;
    String str1;
    int k;
    if (i < arrayOfFile.length)
    {
      localObject = arrayOfFile[i];
      str1 = ((File)localObject).getName();
      k = j;
      if (((File)localObject).exists())
      {
        k = j;
        if (((File)localObject).isFile())
        {
          k = j;
          if (str1.startsWith("utr_"))
          {
            k = j;
            if (!str1.contains(str2))
            {
              if (l - ((File)localObject).lastModified() <= 1296000000L) {
                break label204;
              }
              if (co.e()) {
                co.a("del file:" + ((File)localObject).getName());
              }
              ((File)localObject).delete();
              k = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label79;
      break;
      label204:
      byte[] arrayOfByte = co.a((File)localObject);
      k = arrayOfByte.length + j;
      if (co.e()) {
        co.a("upload file:" + ((File)localObject).getName() + ",len=" + arrayOfByte.length + ",sum=" + k + ",netType=" + locala);
      }
      boolean bool = cu.h;
      str1 = "https://analytics.map.qq.com/tr?utr";
      if (!cu.e) {
        str1 = "https://analytics.map.qq.com/tr?utr".replace("https:", "http:");
      }
      localObject = new cr.1(this, (File)localObject);
      if (!co.b(arrayOfByte)) {
        ds.a("th_loc_task_t_consume", new cr.2(this, str1, arrayOfByte, (de)localObject));
      }
      if ((locala == dv.a.b) || (k >= 409600)) {
        break;
      }
    }
  }
  
  public final int a()
  {
    a(1001, 0L);
    return 0;
  }
  
  public final void a(Location paramLocation)
  {
    long l;
    synchronized (this.b)
    {
      if (!f()) {
        return;
      }
      l = System.currentTimeMillis();
      if (l - this.g[0] < 900L) {
        return;
      }
    }
    this.g[0] = l;
    Object localObject = this.h;
    localObject[0] += 1;
    if (paramLocation != null) {}
    for (;;)
    {
      try
      {
        boolean bool = "gps".equals(paramLocation.getProvider());
        if (!bool) {
          return;
        }
        bool = cu.h;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool = paramLocation.isFromMockProvider();
          if (bool) {
            return;
          }
        }
        localObject = String.format(Locale.ENGLISH, "%d,G,%d,0,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", new Object[] { Long.valueOf(l), Long.valueOf(paramLocation.getTime()), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getSpeed()), Float.valueOf(paramLocation.getBearing()) });
        localHandler = e();
        if (localHandler != null)
        {
          if (localHandler != null) {
            continue;
          }
          paramLocation = new Message();
          paramLocation.what = 1003;
          paramLocation.arg1 = 0;
          paramLocation.arg2 = 0;
          paramLocation.obj = localObject;
          co.a(localHandler, paramLocation, 0L);
        }
      }
      catch (Throwable paramLocation)
      {
        Handler localHandler;
        if (!co.e()) {
          continue;
        }
        co.a("set gps loc error.", paramLocation);
        continue;
      }
      return;
      paramLocation = localHandler.obtainMessage(1003);
    }
  }
  
  public final void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      String str1 = (String)paramMessage.obj;
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder1;
      String str2;
      String str3;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      if (this.c.length() == 0)
      {
        localStringBuilder1 = this.c;
        str2 = dz.g().replaceAll("[| _,]", "") + "_" + dz.f() + "_" + dz.h();
        str3 = ((String)co.a(Build.MANUFACTURER, "")).replaceAll("[| _,]", "") + "_" + ((String)co.a(Build.MODEL, "")).replaceAll("[| _,]", "");
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = localStringBuilder2.append("SYSTEM,").append(System.currentTimeMillis()).append(',').append(dz.c()).append(',');
        if (cu.i != null) {
          break label438;
        }
      }
      for (paramMessage = "";; paramMessage = dt.a(cu.i.c))
      {
        localStringBuilder3.append(paramMessage).append(',').append(str2).append(',').append(str3).append(',').append(Build.VERSION.SDK_INT).append(',').append(cx.a()).append(',').append(cx.c()).append(',').append(cx.d().replaceAll(":", "").toLowerCase()).append(',').append(cx.b());
        localStringBuilder1.append(localStringBuilder2.toString());
        this.f = l;
        this.c.append('$').append(str1);
        if ((this.c.length() < 15360L) && ((this.f == 0L) || (l - this.f < 600000L))) {
          break;
        }
        if (this.h[0] + this.h[1] >= 3) {
          a(this.c.toString());
        }
        this.c.setLength(0);
        Arrays.fill(this.h, 0);
        return;
      }
    case 1002: 
      paramMessage = e();
      if (paramMessage != null) {
        paramMessage.removeCallbacksAndMessages(null);
      }
      if (this.h[0] + this.h[1] >= 3) {
        a(this.c.toString());
      }
      g();
      this.e = 0L;
      h();
      return;
    case 1001: 
      label438:
      g();
      this.e = (System.currentTimeMillis() - 40000L);
      a(1004, 300000L);
      return;
    }
    a(1004, 1800000L);
    h();
  }
  
  public final void b()
  {
    a(1002, 0L);
  }
  
  public final String c()
  {
    return "UserTrackPro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.cr
 * JD-Core Version:    0.7.0.1
 */