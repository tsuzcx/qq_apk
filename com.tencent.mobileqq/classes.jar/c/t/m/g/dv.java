package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public final class dv
{
  public float a = -1.0F;
  public float b;
  public long c = -1L;
  public double d = -1.0D;
  public double e = -1.0D;
  public double f = -1.0D;
  public double g;
  public double h = 0.0D;
  public double i = 0.0D;
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  public static dv.a a(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {}
      for (paramContext = null; (paramContext == null) || (!paramContext.isConnected()); paramContext = localConnectivityManager.getActiveNetworkInfo()) {
        return dv.a.a;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (localConnectivityManager.isActiveNetworkMetered()) {
          return dv.a.b;
        }
        return dv.a.c;
      }
      if (1 == paramContext.getType()) {
        return dv.a.c;
      }
      paramContext = dv.a.b;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return dv.a.a;
  }
  
  public final void a()
  {
    this.f = -1.0D;
    this.a = -1.0F;
    this.c = -1L;
    this.h = 0.0D;
    this.i = 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.dv
 * JD-Core Version:    0.7.0.1
 */