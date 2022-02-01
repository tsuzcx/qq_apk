import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class anzg
{
  private static anzg jdField_a_of_type_Anzg;
  public int a;
  long jdField_a_of_type_Long = 720000L;
  public String a;
  boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.94F, 0.6F, 0.0F };
  int[] jdField_a_of_type_ArrayOfInt = { 47185920, 68157440, 89128960, 120586240 };
  public int b;
  int[] b;
  public int c = 0;
  private int d = 1;
  private int e = -1;
  private int f = 1;
  
  private anzg()
  {
    this.jdField_b_of_type_ArrayOfInt = new int[] { 3840000, 1920000, 960000, 720000, 600000 };
    this.jdField_a_of_type_Int = 12;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = "";
    String[] arrayOfString = a();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
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
                com.tencent.mobileqq.app.GuardManager.c = i;
              }
            }
            b(arrayOfString);
            a(arrayOfString);
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "Exception: ", localThrowable);
  }
  
  public static anzg a()
  {
    if (jdField_a_of_type_Anzg == null) {}
    try
    {
      if (jdField_a_of_type_Anzg == null) {
        jdField_a_of_type_Anzg = new anzg();
      }
      return jdField_a_of_type_Anzg;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    paramString = paramString.split("\\|");
    int j = Integer.parseInt(paramString[0]);
    int i;
    if (j < 1)
    {
      i = 1;
      if (24 % i == 0) {
        this.jdField_a_of_type_Int = i;
      }
      j = Integer.parseInt(paramString[1]);
      if (j >= 0) {
        break label66;
      }
      i = 0;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      return;
      i = j;
      if (j <= 24) {
        break;
      }
      i = 24;
      break;
      label66:
      i = j;
      if (j > this.jdField_a_of_type_Int) {
        i = this.jdField_a_of_type_Int;
      }
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString.length <= 9) || (Integer.parseInt(paramArrayOfString[9]) == 1)) {}
    for (;;)
    {
      try
      {
        paramArrayOfString = System.getProperty("ro.miui.ui.version.name");
        if ((!TextUtils.isEmpty(paramArrayOfString)) && (paramArrayOfString.length() == 2) && (Integer.parseInt(paramArrayOfString.substring(1)) >= 7)) {
          this.jdField_a_of_type_Boolean = true;
        }
        return;
      }
      catch (Throwable paramArrayOfString) {}
      try
      {
        paramArrayOfString = System.getProperty("ro.miui.ui.version.name");
        if ((!TextUtils.isEmpty(paramArrayOfString)) && (paramArrayOfString.length() == 2) && (Integer.parseInt(paramArrayOfString.substring(1)) >= 7))
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
      }
      catch (Throwable paramArrayOfString) {}
    }
  }
  
  private String[] a()
  {
    Object localObject1 = DeviceProfileManager.a();
    Object localObject2 = ((DeviceProfileManager)localObject1).a("qq_process_gm");
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "config = " + (String)localObject2);
    }
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("0")))
    {
      localObject1 = null;
      return localObject1;
    }
    localObject2 = ((String)localObject2).split("__");
    if (localObject2.length > 1) {}
    for (localObject1 = localObject2[(localObject1.jdField_a_of_type_Int % localObject2.length)];; localObject1 = localObject2[0])
    {
      localObject2 = ((String)localObject1).split(";");
      localObject1 = localObject2;
      if (localObject2.length >= 4) {
        break;
      }
      return null;
    }
  }
  
  private void b(String paramString)
  {
    int i = Integer.parseInt(paramString.split("\\|")[0]);
    if ((i > 1) && (i < 120))
    {
      this.jdField_a_of_type_Long = (i * 60 * 1000);
      return;
    }
    throw new IllegalArgumentException("Illegal wake interval " + i);
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 8)
    {
      paramArrayOfString = paramArrayOfString[8].split("\\|");
      if (paramArrayOfString.length > 0) {
        com.tencent.mobileqq.app.GuardManager.d = Integer.parseInt(paramArrayOfString[0]);
      }
      if (paramArrayOfString.length > 1) {
        com.tencent.mobileqq.app.GuardManager.e = Integer.parseInt(paramArrayOfString[1]);
      }
    }
  }
  
  private void c(String paramString)
  {
    paramString = paramString.split("\\|");
    if (this.jdField_a_of_type_ArrayOfFloat.length < paramString.length) {}
    float f1;
    for (int i = this.jdField_a_of_type_ArrayOfFloat.length;; i = paramString.length)
    {
      int j = 0;
      for (;;)
      {
        if (j >= i) {
          return;
        }
        f1 = Float.parseFloat(paramString[j]);
        if ((f1 < 0.0F) || (f1 > 15.0F)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfFloat[j] = f1;
        j += 1;
      }
    }
    throw new IllegalArgumentException("Illegal fraction value " + f1);
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
        throw new IllegalArgumentException("Illegal memory size " + k);
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
        throw new IllegalArgumentException("Illegal timeout value " + j);
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
      i = 2;
    }
    do
    {
      return i;
      i = j;
    } while (j >= 0);
    return 0;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt2 != this.e)
    {
      paramInt1 = 0;
      float f2;
      for (float f1 = 0.0F; paramInt1 < 3; f1 += f2)
      {
        int i = 0;
        f2 = 0.0F;
        while (i < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][i];
          i += 1;
        }
        f2 = this.jdField_a_of_type_ArrayOfFloat[paramInt1] * f2 * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      paramInt1 = (int)(3.0F - f1);
      if (paramInt1 < 0) {
        paramInt1 = j;
      }
    }
    for (;;)
    {
      this.e = paramInt2;
      this.f = paramInt1;
      return paramInt1;
      if (paramInt1 > 2)
      {
        paramInt1 = 2;
        continue;
        return this.f;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anzg
 * JD-Core Version:    0.7.0.1
 */