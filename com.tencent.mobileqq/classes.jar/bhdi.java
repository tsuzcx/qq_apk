import android.text.TextUtils;
import java.util.List;

public class bhdi
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bhdh parambhdh)
  {
    switch (paramInt1)
    {
    default: 
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambhdh.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambhdh);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambhdh);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambhdh);
      return;
    }
    h(paramInt2, paramArrayOfString, parambhdh);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 1;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbhdg = new bhdg();
          localbhdg.jdField_a_of_type_Int = 4;
          localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbhdg = new bhdg();
          localbhdg.jdField_a_of_type_Int = 3;
          localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
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
          parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 4;
          parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbhdg = new bhdg();
        localbhdg.jdField_a_of_type_Int = 3;
        localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
        return;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bhdg localbhdg = new bhdg();
      localbhdg.jdField_a_of_type_Int = 3;
      localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 1;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 6;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bhdh parambhdh)
  {
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 4;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbhdg = new bhdg();
        localbhdg.jdField_a_of_type_Int = 3;
        localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
      }
    }
    do
    {
      return;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bhdg localbhdg = new bhdg();
    localbhdg.jdField_a_of_type_Int = 3;
    localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambhdh);
    }
    while (paramInt != 1) {
      return;
    }
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 6;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 4;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bhdg localbhdg = new bhdg();
      localbhdg.jdField_a_of_type_Int = 2;
      localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 2;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 4;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbhdg = new bhdg();
          localbhdg.jdField_a_of_type_Int = 3;
          localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbhdg = new bhdg();
      localbhdg.jdField_a_of_type_Int = 3;
      localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
      return;
      if (paramInt == 1)
      {
        localbhdg = new bhdg();
        localbhdg.jdField_a_of_type_Int = 0;
        localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 3;
          parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
        parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bhdg localbhdg = new bhdg();
    localbhdg.jdField_a_of_type_Int = 7;
    localbhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambhdh.jdField_a_of_type_JavaUtilList.add(localbhdg);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 3;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambhdh);
    }
    while (paramInt != 1) {
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambhdh);
    }
    while (paramInt != 1) {
      return;
    }
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 5;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambhdh);
    }
    while (paramInt != 1) {
      return;
    }
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 3;
      parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bhdh parambhdh)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambhdh);
    }
    while (paramInt != 1) {
      return;
    }
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_Int = 0;
    parambhdh.jdField_a_of_type_Bhdg.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambhdh.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdi
 * JD-Core Version:    0.7.0.1
 */