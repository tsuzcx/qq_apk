package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;

public class DataReport$ShareChat
{
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    int j = 1;
    switch (paramInt2)
    {
    default: 
      return null;
    }
    for (int i = 1;; i = 2)
    {
      paramInt2 = j;
      switch (paramInt1)
      {
      default: 
        return null;
      }
    }
    paramInt2 = 2;
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      paramInt2 = 3;
      continue;
      paramInt2 = 4;
      continue;
      paramInt2 = 5;
      continue;
      paramInt2 = 7;
    }
  }
  
  public static void a()
  {
    DataReport.b("0X800A2B9");
  }
  
  public static void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 4: 
      str = "0X800A2BF";
    }
    for (;;)
    {
      DataReport.b(str);
      return;
      str = "0X800A2C1";
      continue;
      str = "0X800A2BE";
      continue;
      str = "0X800A2C3";
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2);
    if (localPair == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2BB", "0X800A2BB", ((Integer)localPair.first).intValue(), 0, String.valueOf(((Integer)localPair.second).intValue()), "", "", "");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str;
    switch (paramInt3)
    {
    default: 
      return;
    case 1: 
      str = "0X800A3E3";
    }
    for (;;)
    {
      Object localObject = a(paramInt1, paramInt2);
      if (localObject == null) {
        break;
      }
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      localObject = String.valueOf(((Pair)localObject).second);
      if (!TextUtils.isEmpty(paramString)) {
        localObject = paramString;
      }
      ReportController.b(null, "dc00898", "", "", str, str, paramInt1, 0, (String)localObject, "", "", "");
      return;
      str = "0X800A3E1";
      continue;
      str = "0X800A2BC";
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800A3E2", "0X800A3E2", 0, 0, "", paramString, "", "");
    }
  }
  
  public static void b()
  {
    DataReport.b("0X800A2BA");
  }
  
  public static void c()
  {
    DataReport.b("0X800A2BD");
  }
  
  public static void d()
  {
    DataReport.b("0X800A2C0");
  }
  
  public static void e()
  {
    DataReport.b("0X800A2C2");
  }
  
  public static void f()
  {
    DataReport.b("0X800A3DB");
  }
  
  public static void g()
  {
    DataReport.b("0X800A3DC");
  }
  
  public static void h()
  {
    DataReport.b("0X800B5A0");
  }
  
  public static void i()
  {
    DataReport.b("0X800B5A1");
  }
  
  public static void j()
  {
    DataReport.b("0X800B5A2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.DataReport.ShareChat
 * JD-Core Version:    0.7.0.1
 */