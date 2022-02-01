import android.text.TextUtils;
import java.util.List;

public class bgvl
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bgvk parambgvk)
  {
    switch (paramInt1)
    {
    default: 
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambgvk.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambgvk);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambgvk);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambgvk);
      return;
    }
    h(paramInt2, paramArrayOfString, parambgvk);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 1;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbgvj = new bgvj();
          localbgvj.jdField_a_of_type_Int = 4;
          localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbgvj = new bgvj();
          localbgvj.jdField_a_of_type_Int = 3;
          localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
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
          parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 4;
          parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbgvj = new bgvj();
        localbgvj.jdField_a_of_type_Int = 3;
        localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
        return;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bgvj localbgvj = new bgvj();
      localbgvj.jdField_a_of_type_Int = 3;
      localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 1;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 6;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bgvk parambgvk)
  {
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 4;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbgvj = new bgvj();
        localbgvj.jdField_a_of_type_Int = 3;
        localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
      }
    }
    do
    {
      return;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bgvj localbgvj = new bgvj();
    localbgvj.jdField_a_of_type_Int = 3;
    localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgvk);
    }
    while (paramInt != 1) {
      return;
    }
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 6;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 4;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bgvj localbgvj = new bgvj();
      localbgvj.jdField_a_of_type_Int = 2;
      localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 2;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 4;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbgvj = new bgvj();
          localbgvj.jdField_a_of_type_Int = 3;
          localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbgvj = new bgvj();
      localbgvj.jdField_a_of_type_Int = 3;
      localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
      return;
      if (paramInt == 1)
      {
        localbgvj = new bgvj();
        localbgvj.jdField_a_of_type_Int = 0;
        localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 3;
          parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
        parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bgvj localbgvj = new bgvj();
    localbgvj.jdField_a_of_type_Int = 7;
    localbgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgvk.jdField_a_of_type_JavaUtilList.add(localbgvj);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 3;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgvk);
    }
    while (paramInt != 1) {
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgvk);
    }
    while (paramInt != 1) {
      return;
    }
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 5;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgvk);
    }
    while (paramInt != 1) {
      return;
    }
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 3;
      parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bgvk parambgvk)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgvk);
    }
    while (paramInt != 1) {
      return;
    }
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_Int = 0;
    parambgvk.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgvk.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvl
 * JD-Core Version:    0.7.0.1
 */