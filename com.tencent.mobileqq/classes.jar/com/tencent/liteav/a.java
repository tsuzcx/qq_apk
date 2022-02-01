package com.tencent.liteav;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.module.TXCStatus;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  public static void a(String paramString, ArrayList<String> paramArrayList)
  {
    StatusBucket localStatusBucket = TXCAudioEngine.getInstance().getStatus(1);
    TXCStatus.a(paramString, 14003, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10001)));
    TXCStatus.a(paramString, 8005, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10002)));
    TXCStatus.a(paramString, 14017, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10000)));
    TXCStatus.a(paramString, 14002, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10003)));
    TXCStatus.a(paramString, 14006, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10004)));
    TXCStatus.a(paramString, 14018, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10005)));
    TXCStatus.a(paramString, 18029, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10006)));
    if (paramArrayList == null) {
      return;
    }
    paramString = paramArrayList.iterator();
    while (paramString.hasNext())
    {
      paramArrayList = (String)paramString.next();
      int i = localStatusBucket.getIntStatus(paramArrayList, 10114);
      int k = localStatusBucket.getIntStatus(paramArrayList, 10115);
      TXCStatus.a(paramArrayList, 18031, Integer.valueOf(i));
      TXCStatus.a(paramArrayList, 18032, Integer.valueOf(k));
      int j = 0;
      if (k > 0) {
        i /= k;
      } else {
        i = 0;
      }
      TXCStatus.a(paramArrayList, 2001, Integer.valueOf(i));
      TXCStatus.a(paramArrayList, 2002, Integer.valueOf(k));
      TXCStatus.a(paramArrayList, 2005, Integer.valueOf(k));
      TXCStatus.a(paramArrayList, 2004, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10300)));
      TXCStatus.a(paramArrayList, 2034, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10301)));
      TXCStatus.a(paramArrayList, 2035, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10302)));
      TXCStatus.a(paramArrayList, 2014, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10303)));
      TXCStatus.a(paramArrayList, 2008, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10112)));
      TXCStatus.a(paramArrayList, 2010, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10106)));
      TXCStatus.a(paramArrayList, 2007, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10105)));
      TXCStatus.a(paramArrayList, 2011, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10107)));
      TXCStatus.a(paramArrayList, 18001, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10103)));
      TXCStatus.a(paramArrayList, 18002, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10104)));
      TXCStatus.a(paramArrayList, 18006, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10202)));
      TXCStatus.a(paramArrayList, 18007, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10203)));
      TXCStatus.a(paramArrayList, 18008, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10204)));
      TXCStatus.a(paramArrayList, 18015, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10205)));
      TXCStatus.a(paramArrayList, 18013, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10206)));
      k = localStatusBucket.getIntStatus(paramArrayList, 10203);
      int m = localStatusBucket.getIntStatus(paramArrayList, 10202);
      i = j;
      if (m > 0) {
        i = k * 100 / m;
      }
      TXCStatus.a(paramArrayList, 18014, Integer.valueOf(i));
      TXCStatus.a(paramArrayList, 18023, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10200)));
      TXCStatus.a(paramArrayList, 18026, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10110)));
      TXCStatus.a(paramArrayList, 18027, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10111)));
      TXCStatus.a(paramArrayList, 18028, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10201)));
      TXCStatus.a(paramArrayList, 18030, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10113)));
      TXCStatus.a(paramArrayList, 18003, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10100)));
      TXCStatus.a(paramArrayList, 2019, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10100)));
      TXCStatus.a(paramArrayList, 2020, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10101)));
      TXCStatus.a(paramArrayList, 18016, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10102)));
      TXCStatus.a(paramArrayList, 18009, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10207)));
      TXCStatus.a(paramArrayList, 18010, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10208)));
      TXCStatus.a(paramArrayList, 18012, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10209)));
      TXCStatus.a(paramArrayList, 2021, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10109)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.a
 * JD-Core Version:    0.7.0.1
 */