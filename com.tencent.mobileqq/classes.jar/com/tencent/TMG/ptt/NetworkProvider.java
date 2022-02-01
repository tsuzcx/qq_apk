package com.tencent.TMG.ptt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkProvider
{
  private static String TAG = "NetworkProvider";
  
  public static int getNetTypeName(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      if (paramContext.getType() == 0)
      {
        switch (paramContext.getSubtype())
        {
        default: 
          paramContext = paramContext.getSubtypeName();
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("network type = ");
          localStringBuilder.append(paramContext);
          Log.d(str, localStringBuilder.toString());
          if ((paramContext.equalsIgnoreCase("TD-SCDMA")) || (paramContext.equalsIgnoreCase("WCDMA"))) {
            break label230;
          }
          if (paramContext.equalsIgnoreCase("CDMA2000")) {
            return 3;
          }
          break;
        case 13: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          return 2;
        }
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown network type = ");
        localStringBuilder.append(paramContext);
        Log.d(str, localStringBuilder.toString());
        return 0;
        label230:
        return 3;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.NetworkProvider
 * JD-Core Version:    0.7.0.1
 */