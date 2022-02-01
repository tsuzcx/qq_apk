import android.text.TextUtils;
import java.util.List;

public class bfmu
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bfmt parambfmt)
  {
    switch (paramInt1)
    {
    default: 
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambfmt.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambfmt);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambfmt);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambfmt);
      return;
    }
    h(paramInt2, paramArrayOfString, parambfmt);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 1;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbfms = new bfms();
          localbfms.jdField_a_of_type_Int = 4;
          localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbfms = new bfms();
          localbfms.jdField_a_of_type_Int = 3;
          localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
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
          parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 4;
          parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbfms = new bfms();
        localbfms.jdField_a_of_type_Int = 3;
        localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
        return;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bfms localbfms = new bfms();
      localbfms.jdField_a_of_type_Int = 3;
      localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 1;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 6;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bfmt parambfmt)
  {
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 4;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbfms = new bfms();
        localbfms.jdField_a_of_type_Int = 3;
        localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
      }
    }
    do
    {
      return;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bfms localbfms = new bfms();
    localbfms.jdField_a_of_type_Int = 3;
    localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambfmt);
    }
    while (paramInt != 1) {
      return;
    }
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 6;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 4;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bfms localbfms = new bfms();
      localbfms.jdField_a_of_type_Int = 2;
      localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 2;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 4;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbfms = new bfms();
          localbfms.jdField_a_of_type_Int = 3;
          localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbfms = new bfms();
      localbfms.jdField_a_of_type_Int = 3;
      localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
      return;
      if (paramInt == 1)
      {
        localbfms = new bfms();
        localbfms.jdField_a_of_type_Int = 0;
        localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 3;
          parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
        parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bfms localbfms = new bfms();
    localbfms.jdField_a_of_type_Int = 7;
    localbfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambfmt.jdField_a_of_type_JavaUtilList.add(localbfms);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 3;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambfmt);
    }
    while (paramInt != 1) {
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambfmt);
    }
    while (paramInt != 1) {
      return;
    }
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 5;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambfmt);
    }
    while (paramInt != 1) {
      return;
    }
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 3;
      parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bfmt parambfmt)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambfmt);
    }
    while (paramInt != 1) {
      return;
    }
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_Int = 0;
    parambfmt.jdField_a_of_type_Bfms.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambfmt.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmu
 * JD-Core Version:    0.7.0.1
 */