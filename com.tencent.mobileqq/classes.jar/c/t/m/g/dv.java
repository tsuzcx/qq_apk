package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.util.LinkedList;

public final class dv
{
  public LinkedList<fn> a = null;
  public fp b = null;
  public fp c = null;
  public float d = 0.0F;
  public float e = 0.0F;
  public long f = 0L;
  public boolean g = true;
  public float h = 0.0F;
  public ee i;
  private final float j = 1.0F;
  private final float k = 0.6F;
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  public static dv.a a(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {
        paramContext = null;
      } else {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
      }
      if ((paramContext != null) && (paramContext.isConnected()))
      {
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
        return dv.a.b;
      }
      paramContext = dv.a.a;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label83:
      break label83;
    }
    return dv.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dv
 * JD-Core Version:    0.7.0.1
 */