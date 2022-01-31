import android.text.TextUtils;
import java.util.List;

public class bavv
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bavu parambavu)
  {
    switch (paramInt1)
    {
    default: 
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      parambavu.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, parambavu);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, parambavu);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, parambavu);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, parambavu);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, parambavu);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, parambavu);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, parambavu);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, parambavu);
      return;
    }
    h(paramInt2, paramArrayOfString, parambavu);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 1;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localbavt = new bavt();
          localbavt.jdField_a_of_type_Int = 4;
          localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbavt = new bavt();
          localbavt.jdField_a_of_type_Int = 3;
          localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
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
          parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 4;
          parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localbavt = new bavt();
        localbavt.jdField_a_of_type_Int = 3;
        localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
        return;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      bavt localbavt = new bavt();
      localbavt.jdField_a_of_type_Int = 3;
      localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 1;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 6;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, bavu parambavu)
  {
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 4;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localbavt = new bavt();
        localbavt.jdField_a_of_type_Int = 3;
        localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
      }
    }
    do
    {
      return;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    bavt localbavt = new bavt();
    localbavt.jdField_a_of_type_Int = 3;
    localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavu);
    }
    while (paramInt != 1) {
      return;
    }
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 6;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 4;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      bavt localbavt = new bavt();
      localbavt.jdField_a_of_type_Int = 2;
      localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 2;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 4;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localbavt = new bavt();
          localbavt.jdField_a_of_type_Int = 3;
          localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
        }
      }
    }
    do
    {
      do
      {
        return;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localbavt = new bavt();
      localbavt.jdField_a_of_type_Int = 3;
      localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
      return;
      if (paramInt == 1)
      {
        localbavt = new bavt();
        localbavt.jdField_a_of_type_Int = 0;
        localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 3;
          parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
        parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    bavt localbavt = new bavt();
    localbavt.jdField_a_of_type_Int = 7;
    localbavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavu.jdField_a_of_type_JavaUtilList.add(localbavt);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 3;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavu);
    }
    while (paramInt != 1) {
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavu.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavu);
    }
    while (paramInt != 1) {
      return;
    }
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 5;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavu);
    }
    while (paramInt != 1) {
      return;
    }
    parambavu.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 3;
      parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, bavu parambavu)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, parambavu);
    }
    while (paramInt != 1) {
      return;
    }
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_Int = 0;
    parambavu.jdField_a_of_type_Bavt.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    parambavu.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavv
 * JD-Core Version:    0.7.0.1
 */