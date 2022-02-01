package com.tencent.luggage.wxa.aa;

import android.util.Log;
import com.tencent.luggage.wxa.al.e;
import com.tencent.luggage.wxa.am.s.e;

public final class b
{
  public static boolean a(e parame, int paramInt, Exception paramException)
  {
    return a(parame, paramInt, paramException, 60000L);
  }
  
  public static boolean a(e parame, int paramInt, Exception paramException, long paramLong)
  {
    if (a(paramException))
    {
      boolean bool = parame.a(paramInt, paramLong);
      int i = ((s.e)paramException).c;
      if (bool)
      {
        paramException = new StringBuilder();
        paramException.append("Blacklisted: duration=");
        paramException.append(paramLong);
        paramException.append(", responseCode=");
        paramException.append(i);
        paramException.append(", format=");
        paramException.append(parame.a(paramInt));
        Log.w("ChunkedTrackBlacklist", paramException.toString());
        return bool;
      }
      paramException = new StringBuilder();
      paramException.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
      paramException.append(i);
      paramException.append(", format=");
      paramException.append(parame.a(paramInt));
      Log.w("ChunkedTrackBlacklist", paramException.toString());
      return bool;
    }
    return false;
  }
  
  public static boolean a(Exception paramException)
  {
    boolean bool3 = paramException instanceof s.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = ((s.e)paramException).c;
      if (i != 404)
      {
        bool1 = bool2;
        if (i != 410) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aa.b
 * JD-Core Version:    0.7.0.1
 */