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
  private final long d;
  private final long e;
  
  public fn(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = paramLong1;
    this.e = paramLong2;
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (int i = 1; i != 0; i = 0) {
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
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean b(Context paramContext)
  {
    int i;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        break label62;
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
    while (i != 0)
    {
      return false;
      label62:
      i = 0;
    }
  }
  
  public final float a()
  {
    return (float)Math.sqrt(Math.pow(this.a, 2.0D) + Math.pow(this.b, 2.0D) + Math.pow(this.c, 2.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.fn
 * JD-Core Version:    0.7.0.1
 */