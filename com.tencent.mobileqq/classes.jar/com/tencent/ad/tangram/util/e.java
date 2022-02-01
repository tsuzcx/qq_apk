package com.tencent.ad.tangram.util;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;

public final class e
{
  private static final String TAG = "AdPermissionUtil";
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramContext.getApplicationContext() != null)
      {
        int i = paramContext.getApplicationContext().checkCallingOrSelfPermission(paramString);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdPermissionUtil", "checkPermission", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.e
 * JD-Core Version:    0.7.0.1
 */