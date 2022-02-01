package com.tencent.common.wormhole.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.wormhole.WormholeManager;

public class WormholeLogUtils
{
  public static String a = "Wormhole.";
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (WormholeManager.a().c() != null)
    {
      WormholeManager.a().c().a(paramInt, paramString1, paramString2);
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = a;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
    }
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              Log.d(paramString1, paramString2);
              return;
            }
            Log.e(paramString1, paramString2);
            return;
          }
          Log.w(paramString1, paramString2);
          return;
        }
        Log.i(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.log.WormholeLogUtils
 * JD-Core Version:    0.7.0.1
 */