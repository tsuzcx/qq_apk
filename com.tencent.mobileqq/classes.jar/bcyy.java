import android.text.TextUtils;
import java.util.List;

public class bcyy
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bcyx parambcyx)
  {
    switch (paramInt1)
    {
    default: 
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambcyx.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambcyx);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambcyx);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambcyx);
      return;
    }
    h(paramInt2, paramArrayOfString, parambcyx);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 1;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbcyw = new bcyw();
          localbcyw.jdField_a_of_type_Int = 4;
          localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbcyw = new bcyw();
          localbcyw.jdField_a_of_type_Int = 3;
          localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
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
          parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 4;
          parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbcyw = new bcyw();
        localbcyw.jdField_a_of_type_Int = 3;
        localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
        return;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bcyw localbcyw = new bcyw();
      localbcyw.jdField_a_of_type_Int = 3;
      localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 1;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 6;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bcyx parambcyx)
  {
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 4;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbcyw = new bcyw();
        localbcyw.jdField_a_of_type_Int = 3;
        localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
      }
    }
    do
    {
      return;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bcyw localbcyw = new bcyw();
    localbcyw.jdField_a_of_type_Int = 3;
    localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcyx);
    }
    while (paramInt != 1) {
      return;
    }
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 6;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 4;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bcyw localbcyw = new bcyw();
      localbcyw.jdField_a_of_type_Int = 2;
      localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 2;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 4;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbcyw = new bcyw();
          localbcyw.jdField_a_of_type_Int = 3;
          localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbcyw = new bcyw();
      localbcyw.jdField_a_of_type_Int = 3;
      localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
      return;
      if (paramInt == 1)
      {
        localbcyw = new bcyw();
        localbcyw.jdField_a_of_type_Int = 0;
        localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 3;
          parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
        parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bcyw localbcyw = new bcyw();
    localbcyw.jdField_a_of_type_Int = 7;
    localbcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcyx.jdField_a_of_type_JavaUtilList.add(localbcyw);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 3;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcyx);
    }
    while (paramInt != 1) {
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcyx);
    }
    while (paramInt != 1) {
      return;
    }
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 5;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcyx);
    }
    while (paramInt != 1) {
      return;
    }
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 3;
      parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bcyx parambcyx)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcyx);
    }
    while (paramInt != 1) {
      return;
    }
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_Int = 0;
    parambcyx.jdField_a_of_type_Bcyw.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcyx.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyy
 * JD-Core Version:    0.7.0.1
 */