package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.List;

public class cq
  extends dj
{
  private static final String q = ct.a() + co.a(cq.class.getName().getBytes(), "SHA-256").substring(0, 8);
  private BroadcastReceiver A = new cq.1(this);
  public cx a = null;
  public long b = 102400L;
  public long c = 3600000L;
  public int d = 1;
  public int e = 25600;
  public long f = 104857600L;
  public long g = 10485760L;
  public long h = 259200000L;
  public long i = 2592000000L;
  public boolean j = true;
  public int k = 0;
  public long l = 60000L;
  public long m = 3000L;
  public cr n;
  private Context r = null;
  private final File s;
  private boolean t;
  private volatile Handler u;
  private long v = 0L;
  private volatile List<cp> w;
  private volatile List<ScanResult> x;
  private volatile Location y;
  private long z = 0L;
  
  private cq(Context paramContext, File paramFile)
  {
    this.r = paramContext;
    this.s = paramFile;
    this.t = false;
  }
  
  public cq(Context paramContext, String paramString)
  {
    this(paramContext, new File(paramString + "/f_c"));
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  public final int a(Looper paramLooper)
  {
    this.w = null;
    this.x = null;
    this.y = null;
    this.v = 0L;
    boolean bool;
    if ((this.s != null) && ((this.s.exists()) || (this.s.mkdirs()))) {
      bool = true;
    }
    for (;;)
    {
      this.t = bool;
      co.a("startup! prepared:" + this.t);
      if (this.t)
      {
        this.u = new cq.a(this, paramLooper);
        this.v = (System.currentTimeMillis() - 40000L);
        co.a(this.u, 107, 300000L);
      }
      try
      {
        IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.r.registerReceiver(this.A, localIntentFilter);
        if ((this.t) && (this.j))
        {
          this.n = new cr(this.s);
          this.n.a(paramLooper);
          co.a("start up:WifiInfoPro");
        }
        return 0;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          co.a("listenNetworkState: failed", localThrowable);
        }
      }
    }
  }
  
  public final void a()
  {
    try
    {
      this.r.unregisterReceiver(this.A);
      label11:
      if (this.n != null)
      {
        this.n.d();
        this.n = null;
      }
      if (this.t)
      {
        co.a(this.u, 104, 0L);
        co.a(this.u, 106, 0L);
        this.v = 0L;
        co.a(this.u, 107, 0L);
        co.a(this.u, 105, 200L);
        this.u = null;
      }
      co.a("shutdown!");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
  
  public final void a(Location paramLocation, List<ScanResult> paramList, List<cp> paramList1)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramLocation != null)
        {
          long l2 = paramLocation.getTime();
          if (l1 - l2 <= 10000L) {}
        }
        else
        {
          return;
        }
        this.y = paramLocation;
        this.x = paramList;
        this.w = paramList1;
        if (!this.t) {
          continue;
        }
        if (paramList == null)
        {
          if (co.a(paramList1)) {
            continue;
          }
          co.a(this.u, 102, 0L);
          continue;
        }
        if (co.a(paramList)) {
          continue;
        }
      }
      finally {}
      co.a(this.u, 101, 0L);
    }
  }
  
  public final String b()
  {
    return "DC_Pro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cq
 * JD-Core Version:    0.7.0.1
 */