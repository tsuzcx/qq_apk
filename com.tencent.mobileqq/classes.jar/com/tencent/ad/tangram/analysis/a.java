package com.tencent.ad.tangram.analysis;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_abtest.ABTest;
import com.tencent.ad.tangram.protocol.gdt_abtest.ABTest.LimitByUIN;
import java.util.Arrays;
import java.util.List;

public class a
{
  private static final String TAG = "AdABTest";
  
  public static boolean isABTestByUIN(String paramString, gdt_abtest.ABTest.LimitByUIN paramLimitByUIN)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    List localList;
    do
    {
      for (;;)
      {
        return false;
        try
        {
          l = Long.valueOf(paramString).longValue();
          if ((l != -2147483648L) && (paramLimitByUIN != null))
          {
            localList = Arrays.asList(paramLimitByUIN.whiteList);
            if ((localList != null) && (localList.contains(paramString))) {
              return true;
            }
          }
        }
        catch (Throwable paramString)
        {
          AdLog.e("AdABTest", "isABTestByUIN", paramString);
          return false;
        }
      }
      localList = Arrays.asList(paramLimitByUIN.blackList);
    } while (((localList != null) && (localList.contains(paramString))) || (TextUtils.isEmpty(paramLimitByUIN.lower)) || (TextUtils.isEmpty(paramLimitByUIN.upper)));
    for (;;)
    {
      try
      {
        i = Integer.valueOf(paramLimitByUIN.lower).intValue();
        j = Integer.valueOf(paramLimitByUIN.upper).intValue();
        if ((i == -2147483648) || (j == -2147483648) || (i > j)) {
          break;
        }
        int k = paramString.length() - paramLimitByUIN.upper.length();
        int m = paramString.length();
        if (k >= m) {
          break;
        }
        paramString = paramString.substring(k, m);
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
      }
      catch (Throwable paramString)
      {
        try
        {
          int i;
          int j;
          l = Long.valueOf(paramString).longValue();
          if (l == -2147483648L) {
            break;
          }
          if ((i > l) || (l > j)) {
            break label258;
          }
          return bool;
        }
        catch (Throwable paramString)
        {
          AdLog.e("AdABTest", "isABTestByUIN", paramString);
          return false;
        }
        paramString = paramString;
        AdLog.e("AdABTest", "isABTestByUIN", paramString);
        return false;
      }
      label258:
      bool = false;
    }
  }
  
  public static boolean isABTestByUIN(String paramString, gdt_abtest.ABTest paramABTest)
  {
    if (paramABTest == null) {}
    while (paramABTest.mode == 0) {
      return false;
    }
    if (paramABTest.mode == 1) {
      return true;
    }
    if (paramABTest.mode == 2) {
      return isABTestByUIN(paramString, paramABTest.limitByUIN);
    }
    AdLog.e("AdABTest", "isABTestByUIN error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.a
 * JD-Core Version:    0.7.0.1
 */