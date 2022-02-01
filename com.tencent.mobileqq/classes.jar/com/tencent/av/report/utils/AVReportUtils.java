package com.tencent.av.report.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AVReportUtils
{
  private static Context sContext;
  
  public static Context getAppContext()
  {
    return sContext;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          int i = paramContext.getType();
          if (i != 0)
          {
            if (i == 1) {
              break label130;
            }
            return 4;
          }
          i = paramContext.getSubtype();
          switch (i)
          {
          case 7: 
          case 10: 
          case 11: 
          default: 
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 12: 
            return 3;
          case 1: 
          case 2: 
          case 4: 
            return 2;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
    label130:
    return 1;
  }
  
  public static void setAppContext(Context paramContext)
  {
    sContext = paramContext.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.utils.AVReportUtils
 * JD-Core Version:    0.7.0.1
 */