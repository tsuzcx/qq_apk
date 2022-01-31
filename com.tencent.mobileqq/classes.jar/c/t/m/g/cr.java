package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Message;
import android.util.Base64;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cr
  extends di
  implements ds.a, Runnable
{
  private volatile boolean d = false;
  private List<String> e = new ArrayList();
  private db f = new db((byte)0);
  private volatile dc g;
  private File h;
  private String i = "wf4_bf";
  private String j = "wf4";
  private StringBuilder k = new StringBuilder(100);
  
  public cr(File paramFile)
  {
    this.h = paramFile;
    co.a("data dir:" + this.h.getAbsolutePath());
  }
  
  private String a(ScanResult paramScanResult)
  {
    this.k.setLength(0);
    try
    {
      this.k.append(paramScanResult.BSSID).append(',');
      this.k.append(Base64.encodeToString(paramScanResult.SSID.getBytes("UTF-8"), 2)).append(',');
      this.k.append(paramScanResult.frequency).append(',');
      this.k.append(Base64.encodeToString(paramScanResult.capabilities.getBytes("UTF-8"), 2));
      return this.k.toString();
    }
    catch (Throwable paramScanResult)
    {
      for (;;)
      {
        this.k.setLength(0);
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    if ((!this.d) && (!co.a(paramList))) {
      if (this.g != null) {
        break label28;
      }
    }
    label28:
    for (int m = 1; m != 0; m = 0) {
      return;
    }
    long l = this.g.b().length();
    co.a("wf file len:".concat(String.valueOf(l)));
    Object localObject2;
    if (l <= 51200L)
    {
      localObject1 = new StringBuilder(500);
      ((StringBuilder)localObject1).append("1|").append(paramList.size());
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append('|').append((String)???);
      }
      localObject2 = this.g;
    }
    for (Object localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = ((dc)localObject2).c.a((byte[])localObject1)) {
      synchronized (((dc)localObject2).a)
      {
        if (((dc)localObject2).b == null)
        {
          paramList.clear();
          return;
        }
        localObject1 = ((String)localObject1).getBytes("UTF-8");
        if (((dc)localObject2).c == null) {
          ((dc)localObject2).b.write((byte[])localObject1);
        }
      }
    }
  }
  
  private void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 104: 
    case 102: 
      do
      {
        return;
        this.g = new dc(new File(this.h, this.j));
        this.g.a(this);
        byte[] arrayOfByte = co.a(new File(this.h, this.i));
        l1 = ((Long)dv.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(0L))).longValue();
        l2 = System.currentTimeMillis();
        db localdb;
        if ((l2 - l1 < 2592000000L) && (!co.b(arrayOfByte)))
        {
          localdb = this.f;
          paramMessage = localdb.a;
          if (arrayOfByte == null) {}
        }
        for (;;)
        {
          try
          {
            int m = Math.min(arrayOfByte.length, localdb.b.length);
            System.arraycopy(arrayOfByte, 0, localdb.b, 0, m);
            co.a("bf init.");
            a(103, 300000L);
            co.a(new File(this.h, this.i), this.f.a());
            a(104, 300000L);
            return;
          }
          finally {}
          dv.a("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(l2));
          co.a("bf reset.");
        }
        paramMessage = ((List)paramMessage.obj).iterator();
        while (paramMessage.hasNext())
        {
          Object localObject2 = (ScanResult)paramMessage.next();
          if (!this.f.b(((ScanResult)localObject2).BSSID))
          {
            this.f.a(((ScanResult)localObject2).BSSID);
            localObject2 = a((ScanResult)localObject2);
            this.e.add(localObject2);
          }
        }
        co.a("wf list size:" + this.e.size());
      } while (this.e.size() < 30);
      a(this.e);
      return;
    case 101: 
      a(this.e);
      co.a(new File(this.h, this.i), this.f.a());
      if (this.g != null)
      {
        this.g.a();
        this.g = null;
      }
      break;
    }
    if (e()) {
      a(103, 1800000L);
    }
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)dv.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(0L))).longValue();
    paramMessage = dt.a(do.a());
    if ((paramMessage == dt.a.c) || ((paramMessage == dt.a.b) && ((ct.f) || (ct.g)))) {}
    for (boolean bool = true;; bool = false)
    {
      co.a("lastUpT:" + l2 + ",deltaT:" + (l1 - l2) + ",network status:" + paramMessage + ",isUpload:" + bool);
      if (!bool) {
        break;
      }
      if ((l2 != 0L) && (l1 - l2 >= 86400000L)) {
        break label633;
      }
      if (l2 != 0L) {
        break;
      }
      dv.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
      return;
    }
    label633:
    new Thread(this, "th_upload_wf").start();
    dv.a("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(l1));
  }
  
  public final int a()
  {
    a(100, 0L);
    return 0;
  }
  
  public final void a(Message paramMessage)
  {
    try
    {
      if (this.h == null) {
        return;
      }
      co.a("msg " + paramMessage.what);
      b(paramMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a("handler msg error:" + paramMessage.what, localThrowable);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = dq.a(co.a(paramArrayOfByte), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
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
      this.d = true;
      if (this.g != null)
      {
        this.g.a();
        this.g = null;
      }
      File localFile = new File(this.h, this.j);
      co.a("upload:" + localFile.getName() + "," + localFile.length());
      byte[] arrayOfByte = co.a(co.a(localFile));
      boolean bool = ct.h;
      String str = "https://analytics.map.qq.com/?wf4";
      if (!ct.e) {
        str = "https://analytics.map.qq.com/?wf4".replace("https:", "http:");
      }
      ct.i.a(str, arrayOfByte, new cr.1(this, localFile));
      if (e())
      {
        this.g = new dc(new File(this.h, this.j));
        this.g.a(this);
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
      this.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cr
 * JD-Core Version:    0.7.0.1
 */