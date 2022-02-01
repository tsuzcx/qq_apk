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
  private long e = 0L;
  private final long[] f = new long[2];
  
  public cr(File paramFile)
  {
    this.d = paramFile;
  }
  
  private void a(String paramString)
  {
    if (co.c(paramString)) {}
    do
    {
      return;
      try
      {
        paramString = paramString.getBytes("UTF-8");
        byte[] arrayOfByte = cw.a(paramString, 3);
        if (co.e()) {
          co.a("srcBytes.len=" + paramString.length + ",encBytes.len=" + arrayOfByte.length);
        }
        a(i(), arrayOfByte, new cr.1(this, arrayOfByte));
        return;
      }
      catch (Throwable paramString) {}
    } while (!co.e());
    co.a("uploadUT error.", paramString);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, de paramde)
  {
    if (co.b(paramArrayOfByte)) {
      return;
    }
    ds.a("th_loc_task_t_consume", new cr.3(this, paramString, paramArrayOfByte, paramde));
  }
  
  private void g()
  {
    this.e = System.currentTimeMillis();
    this.c.setLength(0);
  }
  
  private void h()
  {
    int k = 0;
    File[] arrayOfFile;
    int i;
    if ((this.d != null) && (this.d.exists()))
    {
      arrayOfFile = this.d.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label52;
      }
      i = 1;
      label41:
      if (i == 0) {
        break label57;
      }
    }
    label288:
    for (;;)
    {
      return;
      arrayOfFile = null;
      break;
      label52:
      i = 0;
      break label41;
      label57:
      long l = System.currentTimeMillis();
      dv.a locala = dv.a(dp.a());
      int j = 0;
      i = k;
      for (;;)
      {
        if (i >= arrayOfFile.length) {
          break label288;
        }
        File localFile = arrayOfFile[i];
        Object localObject = localFile.getName();
        k = j;
        if (localFile.exists())
        {
          k = j;
          if (localFile.isFile())
          {
            k = j;
            if (((String)localObject).startsWith("utr_"))
            {
              if (l - localFile.lastModified() > 1728000000L)
              {
                if (co.e()) {
                  co.a("del file:" + localFile.getName());
                }
                localFile.delete();
              }
              localObject = co.a(localFile);
              k = j + localObject.length;
              if (co.e()) {
                co.a("upload file:" + localFile.getName() + ",len=" + localObject.length + ",sum=" + k + ",netType=" + locala);
              }
              a(i(), (byte[])localObject, new cr.2(this, localFile));
              if ((locala != dv.a.c) || (k >= 102400)) {
                break;
              }
            }
          }
        }
        i += 1;
        j = k;
      }
    }
  }
  
  private static String i()
  {
    boolean bool = cu.h;
    String str = "https://analytics.map.qq.com/tr?utr";
    if (!cu.e) {
      str = "https://analytics.map.qq.com/tr?utr".replace("https:", "http:");
    }
    return str;
  }
  
  public final int a()
  {
    Arrays.fill(this.f, 0L);
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
      if (l - this.f[0] < 900L) {
        return;
      }
    }
    this.f[0] = l;
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
        String str = String.format(Locale.ENGLISH, "%d,G,%d,0,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", new Object[] { Long.valueOf(l), Long.valueOf(paramLocation.getTime()), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getSpeed()), Float.valueOf(paramLocation.getBearing()) });
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
          paramLocation.obj = str;
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
          break label416;
        }
      }
      for (paramMessage = "";; paramMessage = dt.a(cu.i.c))
      {
        localStringBuilder3.append(paramMessage).append(',').append(str2).append(',').append(str3).append(',').append(Build.VERSION.SDK_INT).append(',').append(cx.a()).append(',').append(cx.c()).append(',').append(cx.d().replaceAll(":", "").toLowerCase()).append(',').append(cx.b());
        localStringBuilder1.append(localStringBuilder2.toString());
        this.e = l;
        this.c.append('$').append(str1);
        if ((this.c.length() < 15360L) && ((this.e == 0L) || (l - this.e < 300000L))) {
          break;
        }
        a(this.c.toString());
        this.c.setLength(0);
        return;
      }
    case 1002: 
      paramMessage = e();
      if (paramMessage != null) {
        paramMessage.removeCallbacksAndMessages(null);
      }
      a(this.c.toString());
      g();
      return;
    case 1001: 
      label416:
      g();
      a(1004, 600000L);
      return;
    }
    a(1004, 1200000L);
    h();
  }
  
  public final void b()
  {
    a(1002, 0L);
    Arrays.fill(this.f, 0L);
  }
  
  public final String c()
  {
    return "UserTrackPro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cr
 * JD-Core Version:    0.7.0.1
 */