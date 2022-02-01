package com.tencent.mobileqq.app.guard;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class GuardConfig
{
  private static GuardConfig j;
  boolean a;
  int[] b = { 47185920, 68157440, 89128960, 120586240 };
  public int[] c = { 3840000, 1920000, 960000, 720000, 600000 };
  float[] d = { 0.94F, 0.6F, 0.0F };
  int e = 12;
  int f = 3;
  long g = 720000L;
  int h = 0;
  public String i = "";
  private int k = 1;
  private int l = -1;
  private int m = 1;
  
  private GuardConfig()
  {
    String[] arrayOfString = c();
    if (arrayOfString == null) {
      return;
    }
    try
    {
      c(arrayOfString);
      c(arrayOfString[2]);
      b(arrayOfString[3]);
      if (arrayOfString.length > 4)
      {
        a(arrayOfString[4]);
        if (arrayOfString.length > 6)
        {
          this.h = Integer.parseInt(arrayOfString[5]);
          this.i = arrayOfString[6];
        }
        if (arrayOfString.length > 7)
        {
          int n = Integer.parseInt(arrayOfString[7]);
          if ((n >= 1) && (n < 10)) {
            GuardManager.SUICIDE_FACTOR = n;
          }
        }
        b(arrayOfString);
        a(arrayOfString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "Exception: ", localThrowable);
      }
    }
  }
  
  public static GuardConfig a()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new GuardConfig();
        }
      }
      finally {}
    }
    return j;
  }
  
  private void a(String paramString)
  {
    paramString = paramString.split("\\|");
    int i1 = 0;
    int i2 = Integer.parseInt(paramString[0]);
    if (i2 < 1)
    {
      n = 1;
    }
    else
    {
      n = i2;
      if (i2 > 24) {
        n = 24;
      }
    }
    if (24 % n == 0) {
      this.e = n;
    }
    int n = Integer.parseInt(paramString[1]);
    if (n < 0)
    {
      n = i1;
    }
    else
    {
      i1 = this.e;
      if (n > i1) {
        n = i1;
      }
    }
    this.f = n;
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 9)
    {
      if (Integer.parseInt(paramArrayOfString[9]) == 1) {
        try
        {
          paramArrayOfString = System.getProperty("ro.miui.ui.version.name");
          if ((TextUtils.isEmpty(paramArrayOfString)) || (paramArrayOfString.length() != 2) || (Integer.parseInt(paramArrayOfString.substring(1)) < 7)) {
            return;
          }
          this.a = true;
          return;
        }
        catch (Throwable paramArrayOfString)
        {
          QLog.e("GuardConfig", 1, "parseMiuiForeground t:", paramArrayOfString);
          return;
        }
      }
    }
    else {
      try
      {
        paramArrayOfString = System.getProperty("ro.miui.ui.version.name");
        if ((!TextUtils.isEmpty(paramArrayOfString)) && (paramArrayOfString.length() == 2) && (Integer.parseInt(paramArrayOfString.substring(1)) >= 7))
        {
          this.a = true;
          return;
        }
      }
      catch (Throwable paramArrayOfString)
      {
        QLog.e("GuardConfig", 1, "parseMiuiForeground 2 t:", paramArrayOfString);
      }
    }
  }
  
  private void b(String paramString)
  {
    int n = Integer.parseInt(paramString.split("\\|")[0]);
    if ((n > 1) && (n < 120))
    {
      this.g = (n * 60 * 1000);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Illegal wake interval ");
    paramString.append(n);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 8)
    {
      paramArrayOfString = paramArrayOfString[8].split("\\|");
      if (paramArrayOfString.length > 0) {
        GuardManager.sTickToolBgFgKill = Integer.parseInt(paramArrayOfString[0]);
      }
      if (paramArrayOfString.length > 1) {
        GuardManager.sTickQZoneBgKill = Integer.parseInt(paramArrayOfString[1]);
      }
    }
  }
  
  private void c(String paramString)
  {
    paramString = paramString.split("\\|");
    float[] arrayOfFloat = this.d;
    int n;
    if (arrayOfFloat.length < paramString.length) {
      n = arrayOfFloat.length;
    } else {
      n = paramString.length;
    }
    int i1 = 0;
    while (i1 < n)
    {
      float f1 = Float.parseFloat(paramString[i1]);
      if ((f1 >= 0.0F) && (f1 <= 15.0F))
      {
        this.d[i1] = f1;
        i1 += 1;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("Illegal fraction value ");
        paramString.append(f1);
        throw new IllegalArgumentException(paramString.toString());
      }
    }
  }
  
  private void c(String[] paramArrayOfString)
  {
    int i1 = 0;
    String[] arrayOfString = paramArrayOfString[0].split("\\|");
    int n = 0;
    while (n < this.b.length)
    {
      int i2 = Integer.parseInt(arrayOfString[n]);
      if ((i2 > 20) && (i2 < 200))
      {
        this.b[n] = (i2 * 1024 * 1024);
        n += 1;
      }
      else
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Illegal memory size ");
        paramArrayOfString.append(i2);
        throw new IllegalArgumentException(paramArrayOfString.toString());
      }
    }
    paramArrayOfString = paramArrayOfString[1].split("\\|");
    n = i1;
    while (n < this.c.length)
    {
      i1 = Integer.parseInt(paramArrayOfString[n]);
      if ((i1 > 5) && (i1 < 100))
      {
        this.c[n] = (i1 * 60 * 1000);
        n += 1;
      }
      else
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Illegal timeout value ");
        paramArrayOfString.append(i1);
        throw new IllegalArgumentException(paramArrayOfString.toString());
      }
    }
  }
  
  private String[] c()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue("qq_process_gm");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("config = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GuardManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).equals("0")) {
        return null;
      }
      localObject = ((String)localObject).split("__");
      if (localObject.length > 1) {
        localObject = localObject[(((IDPCApi)QRoute.api(IDPCApi.class)).getAbRamdom() % localObject.length)];
      } else {
        localObject = localObject[0];
      }
      localObject = ((String)localObject).split(";");
      if (localObject.length < 4) {
        return null;
      }
      return localObject;
    }
    return null;
  }
  
  public int a(long paramLong)
  {
    int i1 = Arrays.binarySearch(this.b, (int)paramLong);
    int n = i1;
    if (i1 < 0) {
      n = -1 - i1;
    }
    i1 = n - this.k;
    if (i1 > 2) {
      return 2;
    }
    n = i1;
    if (i1 < 0) {
      n = 0;
    }
    return n;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 != this.l)
    {
      paramInt1 = 0;
      float f1 = 0.0F;
      while (paramInt1 < 3)
      {
        n = 0;
        float f2 = 0.0F;
        while (n < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][n];
          n += 1;
        }
        f1 += f2 * this.d[paramInt1] * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      int n = (int)(3.0F - f1);
      if (n < 0)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = n;
        if (n > 2) {
          paramInt1 = 2;
        }
      }
      this.l = paramInt2;
      this.m = paramInt1;
      return paramInt1;
    }
    return this.m;
  }
  
  public long a(long[][] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    return this.c[(a(paramLong) + a(paramArrayOfLong, paramInt1, paramInt2))];
  }
  
  public String b()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardConfig
 * JD-Core Version:    0.7.0.1
 */