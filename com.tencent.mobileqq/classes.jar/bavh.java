import android.text.TextUtils;
import java.util.List;

public class bavh
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bavg parambavg)
  {
    switch (paramInt1)
    {
    default: 
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambavg.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambavg);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambavg);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambavg);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambavg);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambavg);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambavg);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambavg);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambavg);
      return;
    }
    h(paramInt2, paramArrayOfString, parambavg);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 1;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbavf = new bavf();
          localbavf.jdField_a_of_type_Int = 4;
          localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbavf = new bavf();
          localbavf.jdField_a_of_type_Int = 3;
          localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
        }
      }
    }
    while (paramInt != 1)
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(paramArrayOfString[4])) {
            break;
          }
          parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 4;
          parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbavf = new bavf();
        localbavf.jdField_a_of_type_Int = 3;
        localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
        return;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bavf localbavf = new bavf();
      localbavf.jdField_a_of_type_Int = 3;
      localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 1;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 6;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bavg parambavg)
  {
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 4;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbavf = new bavf();
        localbavf.jdField_a_of_type_Int = 3;
        localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
      }
    }
    do
    {
      return;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bavf localbavf = new bavf();
    localbavf.jdField_a_of_type_Int = 3;
    localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavg);
    }
    while (paramInt != 1) {
      return;
    }
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 6;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 4;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bavf localbavf = new bavf();
      localbavf.jdField_a_of_type_Int = 2;
      localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 2;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 4;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbavf = new bavf();
          localbavf.jdField_a_of_type_Int = 3;
          localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbavf = new bavf();
      localbavf.jdField_a_of_type_Int = 3;
      localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
      return;
      if (paramInt == 1)
      {
        localbavf = new bavf();
        localbavf.jdField_a_of_type_Int = 0;
        localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 3;
          parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
        parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bavf localbavf = new bavf();
    localbavf.jdField_a_of_type_Int = 7;
    localbavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavg.jdField_a_of_type_JavaUtilList.add(localbavf);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 3;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavg);
    }
    while (paramInt != 1) {
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavg.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavg);
    }
    while (paramInt != 1) {
      return;
    }
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 5;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavg);
    }
    while (paramInt != 1) {
      return;
    }
    parambavg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 3;
      parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bavg parambavg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavg);
    }
    while (paramInt != 1) {
      return;
    }
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
    parambavg.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavg.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavh
 * JD-Core Version:    0.7.0.1
 */