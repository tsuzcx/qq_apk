import android.text.TextUtils;
import java.util.List;

public class azud
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, azuc paramazuc)
  {
    switch (paramInt1)
    {
    default: 
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramazuc.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, paramazuc);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramazuc);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramazuc);
      return;
    }
    h(paramInt2, paramArrayOfString, paramazuc);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 1;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localazub = new azub();
          localazub.jdField_a_of_type_Int = 4;
          localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localazub = new azub();
          localazub.jdField_a_of_type_Int = 3;
          localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
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
          paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 4;
          paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localazub = new azub();
        localazub.jdField_a_of_type_Int = 3;
        localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
        return;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      azub localazub = new azub();
      localazub.jdField_a_of_type_Int = 3;
      localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 1;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 6;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, azuc paramazuc)
  {
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 4;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localazub = new azub();
        localazub.jdField_a_of_type_Int = 3;
        localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
      }
    }
    do
    {
      return;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    azub localazub = new azub();
    localazub.jdField_a_of_type_Int = 3;
    localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramazuc);
    }
    while (paramInt != 1) {
      return;
    }
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 6;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 4;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      azub localazub = new azub();
      localazub.jdField_a_of_type_Int = 2;
      localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 2;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 4;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localazub = new azub();
          localazub.jdField_a_of_type_Int = 3;
          localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
        }
      }
    }
    do
    {
      do
      {
        return;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localazub = new azub();
      localazub.jdField_a_of_type_Int = 3;
      localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
      return;
      if (paramInt == 1)
      {
        localazub = new azub();
        localazub.jdField_a_of_type_Int = 0;
        localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 3;
          paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
        paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    azub localazub = new azub();
    localazub.jdField_a_of_type_Int = 7;
    localazub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramazuc.jdField_a_of_type_JavaUtilList.add(localazub);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 3;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramazuc);
    }
    while (paramInt != 1) {
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramazuc);
    }
    while (paramInt != 1) {
      return;
    }
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 5;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramazuc);
    }
    while (paramInt != 1) {
      return;
    }
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 3;
      paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, azuc paramazuc)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramazuc);
    }
    while (paramInt != 1) {
      return;
    }
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_Int = 0;
    paramazuc.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramazuc.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azud
 * JD-Core Version:    0.7.0.1
 */