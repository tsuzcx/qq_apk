package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public final class fn
{
  public final float a;
  public final float b;
  public final float c;
  public final long d;
  
  public fn(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramLong;
  }
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i;
    if (paramContext == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        i = paramContext.getType();
        return i;
      }
      return -1;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean b(Context paramContext)
  {
    int i;
    label56:
    do
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null) {
          break label56;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        NetworkInfo.State localState;
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        paramContext = paramContext.getState();
        localState = NetworkInfo.State.CONNECTED;
        if (paramContext == localState) {
          return true;
        }
      }
      return false;
      i = 0;
    } while (i == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fn
 * JD-Core Version:    0.7.0.1
 */