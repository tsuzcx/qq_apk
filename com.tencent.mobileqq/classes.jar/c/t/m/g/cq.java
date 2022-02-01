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
  extends dk
{
  private static final String o;
  private BroadcastReceiver A = new cq.1(this);
  public long a = 102400L;
  public long b = 3600000L;
  public int c = 1;
  public int d = 25600;
  public long e = 104857600L;
  public long f = 10485760L;
  public long g = 259200000L;
  public long h = 2592000000L;
  public boolean i = true;
  public boolean j = false;
  public cs k;
  public cr l;
  private Context p = null;
  private final File q;
  private boolean r;
  private volatile Handler s;
  private int t = 0;
  private long u = 60000L;
  private long v = 3000L;
  private long w = 0L;
  private volatile List<cp> x;
  private volatile List<ScanResult> y;
  private volatile Location z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(cu.a());
    localStringBuilder.append(co.b(cq.class.getName(), "SHA-256").substring(0, 8));
    o = localStringBuilder.toString();
  }
  
  private cq(Context paramContext, File paramFile)
  {
    this.p = paramContext;
    this.q = paramFile;
    this.r = false;
  }
  
  public cq(Context paramContext, String paramString)
  {
    this(paramContext, new File(localStringBuilder.toString()));
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  public final int a(Looper paramLooper)
  {
    this.x = null;
    this.y = null;
    this.z = null;
    this.w = 0L;
    Object localObject = this.q;
    boolean bool;
    if ((localObject != null) && ((((File)localObject).exists()) || (this.q.mkdirs()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.r = bool;
    localObject = new StringBuilder("startup! prepared:");
    ((StringBuilder)localObject).append(this.r);
    co.a(((StringBuilder)localObject).toString());
    if (this.r)
    {
      this.s = new cq.a(this, paramLooper);
      this.w = (System.currentTimeMillis() - 40000L);
      co.a(this.s, 107, 300000L);
      try
      {
        localObject = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.p.registerReceiver(this.A, (IntentFilter)localObject);
      }
      catch (Throwable localThrowable)
      {
        co.a("listenNetworkState: failed", localThrowable);
      }
    }
    if ((this.r) && (this.i))
    {
      this.k = new cs(this.q);
      this.k.a(paramLooper);
    }
    if (this.j)
    {
      this.l = new cr(this.q);
      this.l.a(paramLooper);
    }
    return 0;
  }
  
  public final void a()
  {
    try
    {
      this.p.unregisterReceiver(this.A);
      label11:
      Object localObject = this.k;
      if (localObject != null)
      {
        ((cs)localObject).d();
        this.k = null;
      }
      localObject = this.l;
      if (localObject != null)
      {
        ((cr)localObject).d();
        this.l = null;
      }
      if (this.r)
      {
        co.a(this.s, 104, 0L);
        co.a(this.s, 106, 0L);
        this.w = 0L;
        co.a(this.s, 107, 0L);
        co.a(this.s, 105, 200L);
        this.s = null;
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
    try
    {
      long l1 = System.currentTimeMillis();
      if ((paramLocation != null) && (l1 - paramLocation.getTime() <= 10000L))
      {
        this.z = paramLocation;
        this.y = paramList;
        this.x = paramList1;
        if (this.r) {
          if (paramList == null)
          {
            if (!co.a(paramList1)) {
              co.a(this.s, 102, 0L);
            }
          }
          else if (!co.a(paramList)) {
            co.a(this.s, 101, 0L);
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public final String b()
  {
    return "DC_Pro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cq
 * JD-Core Version:    0.7.0.1
 */