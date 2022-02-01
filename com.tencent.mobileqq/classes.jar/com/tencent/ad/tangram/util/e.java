package com.tencent.ad.tangram.util;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;

public final class e
{
  private static final String TAG = "AdPermissionUtil";
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      try
      {
        if (paramContext.getApplicationContext() != null)
        {
          int i = paramContext.getApplicationContext().checkCallingOrSelfPermission(paramString);
          if (i == 0) {
            return true;
          }
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.i("AdPermissionUtil", "checkPermission", paramContext);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.e
 * JD-Core Version:    0.7.0.1
 */