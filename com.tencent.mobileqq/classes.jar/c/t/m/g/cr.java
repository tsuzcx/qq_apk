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
    if (co.c(paramString)) {
      return;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      byte[] arrayOfByte = cw.a(paramString, 3);
      if (co.e())
      {
        StringBuilder localStringBuilder = new StringBuilder("srcBytes.len=");
        localStringBuilder.append(paramString.length);
        localStringBuilder.append(",encBytes.len=");
        localStringBuilder.append(arrayOfByte.length);
        co.a(localStringBuilder.toString());
      }
      a(i(), arrayOfByte, new cr.1(this, arrayOfByte));
      return;
    }
    catch (Throwable paramString)
    {
      if (co.e()) {
        co.a("uploadUT error.", paramString);
      }
    }
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
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((File)localObject1).exists())) {
      localObject1 = this.d.listFiles();
    } else {
      localObject1 = null;
    }
    int k = 0;
    if ((localObject1 != null) && (localObject1.length != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    long l = System.currentTimeMillis();
    dv.a locala = dv.a(dp.a());
    int j = 0;
    int i = k;
    while (i < localObject1.length)
    {
      File localFile = localObject1[i];
      Object localObject2 = localFile.getName();
      k = j;
      if (localFile.exists())
      {
        k = j;
        if (localFile.isFile())
        {
          k = j;
          if (((String)localObject2).startsWith("utr_"))
          {
            if (l - localFile.lastModified() > 1728000000L)
            {
              if (co.e())
              {
                localObject2 = new StringBuilder("del file:");
                ((StringBuilder)localObject2).append(localFile.getName());
                co.a(((StringBuilder)localObject2).toString());
              }
              localFile.delete();
            }
            localObject2 = co.a(localFile);
            k = j + localObject2.length;
            if (co.e())
            {
              StringBuilder localStringBuilder = new StringBuilder("upload file:");
              localStringBuilder.append(localFile.getName());
              localStringBuilder.append(",len=");
              localStringBuilder.append(localObject2.length);
              localStringBuilder.append(",sum=");
              localStringBuilder.append(k);
              localStringBuilder.append(",netType=");
              localStringBuilder.append(locala);
              co.a(localStringBuilder.toString());
            }
            a(i(), (byte[])localObject2, new cr.2(this, localFile));
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
  
  private static String i()
  {
    boolean bool = cu.h;
    bool = cu.e;
    String str = "https://analytics.map.qq.com/tr?utr";
    if (!bool) {
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
    synchronized (this.b)
    {
      if (!f()) {
        return;
      }
      long l = System.currentTimeMillis();
      if (l - this.f[0] < 900L) {
        return;
      }
      this.f[0] = l;
      if (paramLocation != null)
      {
        try
        {
          if (!"gps".equals(paramLocation.getProvider())) {
            break label279;
          }
          boolean bool = cu.h;
          if (Build.VERSION.SDK_INT >= 18)
          {
            bool = paramLocation.isFromMockProvider();
            if (bool) {
              return;
            }
          }
          String str = String.format(Locale.ENGLISH, "%d,G,%d,0,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f", new Object[] { Long.valueOf(l), Long.valueOf(paramLocation.getTime()), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getSpeed()), Float.valueOf(paramLocation.getBearing()) });
          Handler localHandler = e();
          if (localHandler != null)
          {
            if (localHandler == null) {
              paramLocation = new Message();
            } else {
              paramLocation = localHandler.obtainMessage(1003);
            }
            paramLocation.what = 1003;
            paramLocation.arg1 = 0;
            paramLocation.arg2 = 0;
            paramLocation.obj = str;
            co.a(localHandler, paramLocation, 0L);
          }
        }
        catch (Throwable paramLocation)
        {
          if (co.e()) {
            co.a("set gps loc error.", paramLocation);
          }
        }
        return;
      }
      label279:
      return;
    }
  }
  
  public final void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1004: 
      a(1004, 1200000L);
      h();
      return;
    case 1003: 
      String str1 = (String)paramMessage.obj;
      long l1 = System.currentTimeMillis();
      if (this.c.length() == 0)
      {
        StringBuilder localStringBuilder1 = this.c;
        paramMessage = new StringBuilder();
        paramMessage.append(dz.g().replaceAll("[| _,]", ""));
        paramMessage.append("_");
        paramMessage.append(dz.f());
        paramMessage.append("_");
        paramMessage.append(dz.h());
        String str2 = paramMessage.toString();
        paramMessage = new StringBuilder();
        paramMessage.append(((String)co.a(Build.MANUFACTURER, "")).replaceAll("[| _,]", ""));
        paramMessage.append("_");
        paramMessage.append(((String)co.a(Build.MODEL, "")).replaceAll("[| _,]", ""));
        String str3 = paramMessage.toString();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("SYSTEM,");
        localStringBuilder2.append(System.currentTimeMillis());
        localStringBuilder2.append(',');
        localStringBuilder2.append(dz.c());
        localStringBuilder2.append(',');
        if (cu.i == null) {
          paramMessage = "";
        } else {
          paramMessage = dt.a(cu.i.c);
        }
        localStringBuilder2.append(paramMessage);
        localStringBuilder2.append(',');
        localStringBuilder2.append(str2);
        localStringBuilder2.append(',');
        localStringBuilder2.append(str3);
        localStringBuilder2.append(',');
        localStringBuilder2.append(Build.VERSION.SDK_INT);
        localStringBuilder2.append(',');
        localStringBuilder2.append(cx.a());
        localStringBuilder2.append(',');
        localStringBuilder2.append(cx.c());
        localStringBuilder2.append(',');
        localStringBuilder2.append(cx.d().replaceAll(":", "").toLowerCase());
        localStringBuilder2.append(',');
        localStringBuilder2.append(cx.b());
        localStringBuilder1.append(localStringBuilder2.toString());
        this.e = l1;
      }
      paramMessage = this.c;
      paramMessage.append('$');
      paramMessage.append(str1);
      if (this.c.length() < 15360L)
      {
        long l2 = this.e;
        if ((l2 == 0L) || (l1 - l2 < 300000L)) {}
      }
      else
      {
        a(this.c.toString());
        this.c.setLength(0);
      }
      return;
    case 1002: 
      paramMessage = e();
      if (paramMessage != null) {
        paramMessage.removeCallbacksAndMessages(null);
      }
      a(this.c.toString());
      g();
      return;
    }
    g();
    a(1004, 600000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cr
 * JD-Core Version:    0.7.0.1
 */