package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class i
{
  public static int a(long paramLong1, long paramLong2)
  {
    int i = 100;
    if (paramLong2 <= 0L) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = (int)Math.round(paramLong1 / paramLong2 * 100.0D);
    } while (j > 100);
    return j;
  }
  
  public static String a(int paramInt)
  {
    NumberFormat localNumberFormat = NumberFormat.getPercentInstance();
    double d = paramInt / 100.0D;
    localNumberFormat.setMinimumFractionDigits(0);
    return localNumberFormat.format(d);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong == 0L) {
      return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { "0" });
    }
    DecimalFormat localDecimalFormat = null;
    if (paramLong > 104857L) {
      localDecimalFormat = new DecimalFormat("###.#");
    }
    while (localDecimalFormat != null)
    {
      double d = paramLong / 1048576.0D;
      return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { localDecimalFormat.format(d) });
      if (paramLong > 10485L) {
        localDecimalFormat = new DecimalFormat("###.##");
      }
    }
    return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { "0.01" });
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.i
 * JD-Core Version:    0.7.0.1
 */