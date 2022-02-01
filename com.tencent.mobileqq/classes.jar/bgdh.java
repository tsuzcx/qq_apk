import android.text.TextUtils;
import java.util.List;

public class bgdh
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bgdg parambgdg)
  {
    switch (paramInt1)
    {
    default: 
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambgdg.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambgdg);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambgdg);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambgdg);
      return;
    }
    h(paramInt2, paramArrayOfString, parambgdg);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 1;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbgdf = new bgdf();
          localbgdf.jdField_a_of_type_Int = 4;
          localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbgdf = new bgdf();
          localbgdf.jdField_a_of_type_Int = 3;
          localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
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
          parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 4;
          parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbgdf = new bgdf();
        localbgdf.jdField_a_of_type_Int = 3;
        localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
        return;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bgdf localbgdf = new bgdf();
      localbgdf.jdField_a_of_type_Int = 3;
      localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 1;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 6;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bgdg parambgdg)
  {
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 4;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbgdf = new bgdf();
        localbgdf.jdField_a_of_type_Int = 3;
        localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
      }
    }
    do
    {
      return;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bgdf localbgdf = new bgdf();
    localbgdf.jdField_a_of_type_Int = 3;
    localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgdg);
    }
    while (paramInt != 1) {
      return;
    }
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 6;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 4;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bgdf localbgdf = new bgdf();
      localbgdf.jdField_a_of_type_Int = 2;
      localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 2;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 4;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbgdf = new bgdf();
          localbgdf.jdField_a_of_type_Int = 3;
          localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbgdf = new bgdf();
      localbgdf.jdField_a_of_type_Int = 3;
      localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
      return;
      if (paramInt == 1)
      {
        localbgdf = new bgdf();
        localbgdf.jdField_a_of_type_Int = 0;
        localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 3;
          parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
        parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bgdf localbgdf = new bgdf();
    localbgdf.jdField_a_of_type_Int = 7;
    localbgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgdg.jdField_a_of_type_JavaUtilList.add(localbgdf);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 3;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgdg);
    }
    while (paramInt != 1) {
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgdg);
    }
    while (paramInt != 1) {
      return;
    }
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 5;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgdg);
    }
    while (paramInt != 1) {
      return;
    }
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 3;
      parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bgdg parambgdg)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambgdg);
    }
    while (paramInt != 1) {
      return;
    }
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_Int = 0;
    parambgdg.jdField_a_of_type_Bgdf.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambgdg.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdh
 * JD-Core Version:    0.7.0.1
 */