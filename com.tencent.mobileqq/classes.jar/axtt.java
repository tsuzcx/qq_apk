import com.tencent.qphone.base.util.QLog;

public class axtt
{
  private static int a;
  public static axtw a;
  private static int b;
  public static axtw b;
  private static int c;
  public static axtw c;
  
  static
  {
    jdField_a_of_type_Int = 18;
    jdField_b_of_type_Int = 6;
    jdField_c_of_type_Int = 600000;
    jdField_a_of_type_Axtw = new axtu();
    jdField_b_of_type_Axtw = new axtv();
    jdField_c_of_type_Axtw = new axua();
  }
  
  public static int a()
  {
    try
    {
      int i = jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static axtw a(int paramInt)
  {
    axtw localaxtw = jdField_a_of_type_Axtw;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return localaxtw;
    case 1: 
    case 4: 
    case 5: 
      return jdField_c_of_type_Axtw;
    }
    return jdField_b_of_type_Axtw;
  }
  
  public static void a(String paramString)
  {
    int i = 0;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.length() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString = " + paramString);
          }
          paramString = paramString.split("\\|");
          int j;
          if (paramString != null)
          {
            j = paramString.length;
            if (j == 3) {
              if (i >= 3) {
                continue;
              }
            }
          }
          try
          {
            j = Integer.valueOf(paramString[i]).intValue();
            if (j > 0) {
              continue;
            }
          }
          catch (NumberFormatException paramString)
          {
            QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", paramString);
            continue;
          }
          return;
          i += 1;
          continue;
          jdField_a_of_type_Int = Integer.valueOf(paramString[0]).intValue();
          jdField_b_of_type_Int = Integer.valueOf(paramString[1]).intValue();
          jdField_c_of_type_Int = Integer.valueOf(paramString[2]).intValue() * 1000;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RichMediaStrategy", 2, "updataFromDpc: TryCount_dpc = " + jdField_a_of_type_Int + " FixSchedulTryCount_dpc = " + jdField_b_of_type_Int + " TryTime_dpc = " + jdField_c_of_type_Int);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047)) {
      bool = true;
    }
    return bool;
  }
  
  public static int b()
  {
    try
    {
      int i = jdField_b_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9361) || (paramInt == 9037)) {
      bool = true;
    }
    return bool;
  }
  
  public static int c()
  {
    try
    {
      int i = jdField_c_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axtt
 * JD-Core Version:    0.7.0.1
 */