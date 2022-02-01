package com.tencent.mobileqq.app.guard;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class GuardConfig
{
  private static GuardConfig jdField_a_of_type_ComTencentMobileqqAppGuardGuardConfig;
  int jdField_a_of_type_Int = 12;
  long jdField_a_of_type_Long = 720000L;
  public String a;
  boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.94F, 0.6F, 0.0F };
  int[] jdField_a_of_type_ArrayOfInt = { 47185920, 68157440, 89128960, 120586240 };
  int b;
  public int[] b;
  int c = 0;
  private int d = 1;
  private int e = -1;
  private int f = 1;
  
  private GuardConfig()
  {
    this.jdField_b_of_type_ArrayOfInt = new int[] { 3840000, 1920000, 960000, 720000, 600000 };
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = "";
    String[] arrayOfString = a();
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
          this.c = Integer.parseInt(arrayOfString[5]);
          this.jdField_a_of_type_JavaLangString = arrayOfString[6];
        }
        if (arrayOfString.length > 7)
        {
          int i = Integer.parseInt(arrayOfString[7]);
          if ((i >= 1) && (i < 10)) {
            GuardManager.c = i;
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
    if (jdField_a_of_type_ComTencentMobileqqAppGuardGuardConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppGuardGuardConfig == null) {
          jdField_a_of_type_ComTencentMobileqqAppGuardGuardConfig = new GuardConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqAppGuardGuardConfig;
  }
  
  private void a(String paramString)
  {
    paramString = paramString.split("\\|");
    int j = 0;
    int k = Integer.parseInt(paramString[0]);
    if (k < 1)
    {
      i = 1;
    }
    else
    {
      i = k;
      if (k > 24) {
        i = 24;
      }
    }
    if (24 % i == 0) {
      this.jdField_a_of_type_Int = i;
    }
    int i = Integer.parseInt(paramString[1]);
    if (i < 0)
    {
      i = j;
    }
    else
    {
      j = this.jdField_a_of_type_Int;
      if (i > j) {
        i = j;
      }
    }
    this.jdField_b_of_type_Int = i;
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
          this.jdField_a_of_type_Boolean = true;
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
          this.jdField_a_of_type_Boolean = true;
          return;
        }
      }
      catch (Throwable paramArrayOfString)
      {
        QLog.e("GuardConfig", 1, "parseMiuiForeground 2 t:", paramArrayOfString);
      }
    }
  }
  
  private String[] a()
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
  
  private void b(String paramString)
  {
    int i = Integer.parseInt(paramString.split("\\|")[0]);
    if ((i > 1) && (i < 120))
    {
      this.jdField_a_of_type_Long = (i * 60 * 1000);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Illegal wake interval ");
    paramString.append(i);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 8)
    {
      paramArrayOfString = paramArrayOfString[8].split("\\|");
      if (paramArrayOfString.length > 0) {
        GuardManager.d = Integer.parseInt(paramArrayOfString[0]);
      }
      if (paramArrayOfString.length > 1) {
        GuardManager.e = Integer.parseInt(paramArrayOfString[1]);
      }
    }
  }
  
  private void c(String paramString)
  {
    paramString = paramString.split("\\|");
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int i;
    if (arrayOfFloat.length < paramString.length) {
      i = arrayOfFloat.length;
    } else {
      i = paramString.length;
    }
    int j = 0;
    while (j < i)
    {
      float f1 = Float.parseFloat(paramString[j]);
      if ((f1 >= 0.0F) && (f1 <= 15.0F))
      {
        this.jdField_a_of_type_ArrayOfFloat[j] = f1;
        j += 1;
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
    int j = 0;
    String[] arrayOfString = paramArrayOfString[0].split("\\|");
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int k = Integer.parseInt(arrayOfString[i]);
      if ((k > 20) && (k < 200))
      {
        this.jdField_a_of_type_ArrayOfInt[i] = (k * 1024 * 1024);
        i += 1;
      }
      else
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Illegal memory size ");
        paramArrayOfString.append(k);
        throw new IllegalArgumentException(paramArrayOfString.toString());
      }
    }
    paramArrayOfString = paramArrayOfString[1].split("\\|");
    i = j;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      j = Integer.parseInt(paramArrayOfString[i]);
      if ((j > 5) && (j < 100))
      {
        this.jdField_b_of_type_ArrayOfInt[i] = (j * 60 * 1000);
        i += 1;
      }
      else
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Illegal timeout value ");
        paramArrayOfString.append(j);
        throw new IllegalArgumentException(paramArrayOfString.toString());
      }
    }
  }
  
  public int a(long paramLong)
  {
    int j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, (int)paramLong);
    int i = j;
    if (j < 0) {
      i = -1 - j;
    }
    j = i - this.d;
    if (j > 2) {
      return 2;
    }
    i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 != this.e)
    {
      paramInt1 = 0;
      float f1 = 0.0F;
      while (paramInt1 < 3)
      {
        i = 0;
        float f2 = 0.0F;
        while (i < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][i];
          i += 1;
        }
        f1 += f2 * this.jdField_a_of_type_ArrayOfFloat[paramInt1] * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      int i = (int)(3.0F - f1);
      if (i < 0)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = i;
        if (i > 2) {
          paramInt1 = 2;
        }
      }
      this.e = paramInt2;
      this.f = paramInt1;
      return paramInt1;
    }
    return this.f;
  }
  
  public long a(long[][] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    return this.jdField_b_of_type_ArrayOfInt[(a(paramLong) + a(paramArrayOfLong, paramInt1, paramInt2))];
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardConfig
 * JD-Core Version:    0.7.0.1
 */