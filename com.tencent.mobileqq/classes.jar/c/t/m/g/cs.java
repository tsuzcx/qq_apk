package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Message;
import android.util.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cs
  extends dj
  implements du.a, Runnable
{
  private volatile boolean c = false;
  private List<String> d = new ArrayList();
  private dc e = new dc((byte)0);
  private volatile dd f;
  private File g;
  private String h = "wf4_bf";
  private String i = "wf4";
  private StringBuilder j = new StringBuilder(100);
  
  public cs(File paramFile)
  {
    this.g = paramFile;
    co.a("data dir:" + this.g.getAbsolutePath());
  }
  
  private String a(ScanResult paramScanResult)
  {
    this.j.setLength(0);
    try
    {
      this.j.append(paramScanResult.BSSID).append(',');
      this.j.append(Base64.encodeToString(paramScanResult.SSID.getBytes("UTF-8"), 2)).append(',');
      this.j.append(paramScanResult.frequency).append(',');
      this.j.append(Base64.encodeToString(paramScanResult.capabilities.getBytes("UTF-8"), 2));
      return this.j.toString();
    }
    catch (Throwable paramScanResult)
    {
      for (;;)
      {
        this.j.setLength(0);
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    int k = 0;
    if ((!this.c) && (!co.a(paramList)))
    {
      if (this.f == null) {
        k = 1;
      }
      if (k == 0) {}
    }
    else
    {
      return;
    }
    long l = this.f.b().length();
    co.a("wf file len:".concat(String.valueOf(l)));
    Object localObject2;
    String str;
    if (l <= 51200L)
    {
      ??? = new StringBuilder(500);
      ((StringBuilder)???).append("1|").append(paramList.size());
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        ((StringBuilder)???).append('|').append(str);
      }
      localObject2 = this.f;
      str = ((StringBuilder)???).toString();
    }
    synchronized (((dd)localObject2).a)
    {
      ((dd)localObject2).b.append(str);
      if (((dd)localObject2).b.length() >= ((dd)localObject2).c)
      {
        ((dd)localObject2).a(((dd)localObject2).b.toString().getBytes("UTF-8"));
        ((dd)localObject2).b.setLength(0);
      }
      paramList.clear();
      return;
    }
  }
  
  public final int a()
  {
    a(100, 0L);
    return 0;
  }
  
  public final void a(Message paramMessage)
  {
    if (this.g == null) {}
    do
    {
      return;
      byte[] arrayOfByte;
      dc localdc;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        this.f = new dd(new File(this.g, this.i));
        this.f.a(this);
        arrayOfByte = co.a(new File(this.g, this.h));
        l1 = ((Long)dy.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(0L))).longValue();
        l2 = System.currentTimeMillis();
        if ((l2 - l1 < 2592000000L) && (!co.b(arrayOfByte)))
        {
          localdc = this.e;
          paramMessage = localdc.a;
          if (arrayOfByte == null) {
            break;
          }
        }
      case 104: 
        for (;;)
        {
          try
          {
            int k = Math.min(arrayOfByte.length, localdc.b.length);
            System.arraycopy(arrayOfByte, 0, localdc.b, 0, k);
            co.a("bf init.");
            a(103, 300000L);
            co.a(new File(this.g, this.h), this.e.a());
            a(104, 300000L);
            return;
          }
          finally {}
          dy.a("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(l2));
          co.a("bf reset.");
        }
      case 102: 
        paramMessage = ((List)paramMessage.obj).iterator();
        while (paramMessage.hasNext())
        {
          Object localObject2 = (ScanResult)paramMessage.next();
          if (!this.e.b(((ScanResult)localObject2).BSSID))
          {
            this.e.a(((ScanResult)localObject2).BSSID);
            localObject2 = a((ScanResult)localObject2);
            this.d.add(localObject2);
          }
        }
        co.a("wf list size:" + this.d.size());
      }
    } while (this.d.size() < 30);
    a(this.d);
    return;
    a(this.d);
    co.a(new File(this.g, this.h), this.e.a());
    if (this.f != null)
    {
      this.f.a();
      this.f = null;
    }
    if (f()) {
      a(103, 1800000L);
    }
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)dy.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(0L))).longValue();
    paramMessage = dv.a(dp.a());
    if ((paramMessage == dv.a.c) || ((paramMessage == dv.a.b) && ((cu.f) || (cu.g)))) {}
    for (boolean bool = true;; bool = false)
    {
      co.a("lastUpT:" + l2 + ",deltaT:" + (l1 - l2) + ",network status:" + paramMessage + ",isUpload:" + bool);
      if (!bool) {
        break;
      }
      if ((l2 != 0L) && (l1 - l2 >= 86400000L)) {
        break label640;
      }
      if (l2 != 0L) {
        break;
      }
      dy.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
      return;
    }
    label640:
    ds.a("th_loc_task_t_consume", this);
    dy.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = dr.a(co.a(paramArrayOfByte), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
    if (!co.b(paramArrayOfByte))
    {
      paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
      if (!co.b(paramArrayOfByte))
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        paramArrayOfByte = paramArrayOfByte + '$';
        try
        {
          paramArrayOfByte = paramArrayOfByte.getBytes("UTF-8");
          return paramArrayOfByte;
        }
        catch (Throwable paramArrayOfByte) {}
      }
    }
    return new byte[0];
  }
  
  public final void b()
  {
    a(101, 0L);
  }
  
  public final String c()
  {
    return "WifiInfoPro";
  }
  
  public final void run()
  {
    try
    {
      this.c = true;
      if (this.f != null)
      {
        this.f.a();
        this.f = null;
      }
      File localFile = new File(this.g, this.i);
      co.a("upload:" + localFile.getName() + "," + localFile.length());
      byte[] arrayOfByte = co.a(co.a(localFile));
      boolean bool = cu.h;
      String str = "https://analytics.map.qq.com/?wf4";
      if (!cu.e) {
        str = "https://analytics.map.qq.com/?wf4".replace("https:", "http:");
      }
      cu.j.a(str, arrayOfByte, new cs.1(this, localFile));
      if (f())
      {
        this.f = new dd(new File(this.g, this.i));
        this.f.a(this);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a("upload error.", localThrowable);
      return;
    }
    finally
    {
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.cs
 * JD-Core Version:    0.7.0.1
 */