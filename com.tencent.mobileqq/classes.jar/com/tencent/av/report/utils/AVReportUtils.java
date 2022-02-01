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
        if ((paramContext != null) && (paramContext.isConnected())) {
          switch (paramContext.getType())
          {
          case 0: 
            int i = paramContext.getSubtype();
            switch (i)
            {
            }
            break;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
      return 4;
    }
    return 0;
    return 2;
    return 3;
    return 1;
  }
  
  public static void setAppContext(Context paramContext)
  {
    sContext = paramContext.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.report.utils.AVReportUtils
 * JD-Core Version:    0.7.0.1
 */