import android.text.TextUtils;
import java.util.List;

public class bcup
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bcuo parambcuo)
  {
    switch (paramInt1)
    {
    default: 
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambcuo.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambcuo);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambcuo);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambcuo);
      return;
    }
    h(paramInt2, paramArrayOfString, parambcuo);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 1;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbcun = new bcun();
          localbcun.jdField_a_of_type_Int = 4;
          localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbcun = new bcun();
          localbcun.jdField_a_of_type_Int = 3;
          localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
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
          parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 4;
          parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbcun = new bcun();
        localbcun.jdField_a_of_type_Int = 3;
        localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
        return;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bcun localbcun = new bcun();
      localbcun.jdField_a_of_type_Int = 3;
      localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 1;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 6;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bcuo parambcuo)
  {
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 4;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbcun = new bcun();
        localbcun.jdField_a_of_type_Int = 3;
        localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
      }
    }
    do
    {
      return;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bcun localbcun = new bcun();
    localbcun.jdField_a_of_type_Int = 3;
    localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcuo);
    }
    while (paramInt != 1) {
      return;
    }
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 6;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 4;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bcun localbcun = new bcun();
      localbcun.jdField_a_of_type_Int = 2;
      localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 2;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 4;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbcun = new bcun();
          localbcun.jdField_a_of_type_Int = 3;
          localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbcun = new bcun();
      localbcun.jdField_a_of_type_Int = 3;
      localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
      return;
      if (paramInt == 1)
      {
        localbcun = new bcun();
        localbcun.jdField_a_of_type_Int = 0;
        localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 3;
          parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
        parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bcun localbcun = new bcun();
    localbcun.jdField_a_of_type_Int = 7;
    localbcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcuo.jdField_a_of_type_JavaUtilList.add(localbcun);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 3;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcuo);
    }
    while (paramInt != 1) {
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcuo);
    }
    while (paramInt != 1) {
      return;
    }
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 5;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcuo);
    }
    while (paramInt != 1) {
      return;
    }
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 3;
      parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bcuo parambcuo)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambcuo);
    }
    while (paramInt != 1) {
      return;
    }
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_Int = 0;
    parambcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambcuo.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcup
 * JD-Core Version:    0.7.0.1
 */