import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class asav
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = asbr.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
      if (i != 0) {
        return i;
      }
    }
    switch ((int)paramLong1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return 0;
                            if (paramLong2 == 0L) {
                              return 2130848874;
                            }
                            if (paramLong2 == 1L) {
                              return 2130848875;
                            }
                          } while (paramLong2 != 2L);
                          return 2130848876;
                          if (paramLong2 == 0L) {
                            return 2130848868;
                          }
                          if (paramLong2 == 1L) {
                            return 2130848869;
                          }
                        } while (paramLong2 != 2L);
                        return 2130848870;
                        if (paramLong2 == 0L) {
                          return 2130848871;
                        }
                        if (paramLong2 == 1L) {
                          return 2130848872;
                        }
                      } while (paramLong2 != 2L);
                      return 2130848873;
                      if (paramLong2 == 1L) {
                        return 2130848865;
                      }
                      if (paramLong2 == 2L) {
                        return 2130848866;
                      }
                    } while (paramLong2 != 3L);
                    return 2130848867;
                    if (paramLong2 == 1L) {
                      return 2130848892;
                    }
                  } while (paramLong2 != 2L);
                  return 2130848854;
                  if (paramLong2 == 1L) {
                    return 2130848896;
                  }
                } while (paramLong2 != 2L);
                return 2130848858;
                if (paramLong2 == 1L) {
                  return 2130848884;
                }
              } while (paramLong2 != 2L);
              return 2130848883;
              if (paramLong2 == 1L) {
                return 2130848890;
              }
            } while (paramLong2 != 2L);
            return 2130848891;
            if (paramLong2 == 1L) {
              return 2130848895;
            }
          } while (paramLong2 != 2L);
          return 2130848857;
        } while (paramLong2 != 1L);
        return 2130848889;
      } while ((!paramBoolean) || (paramLong2 != 1L));
      return 2130848887;
      if (paramLong2 == 1L) {
        return 2130848880;
      }
      if (paramLong2 == 2L) {
        return 2130848881;
      }
    } while (paramLong2 != 3L);
    return 2130848882;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asbg.b(paramString2), asbg.a(paramString2));
  }
  
  public static asbv a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return amde.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, asbg.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = amde.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return asbg.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asbg.b(paramString2), asbg.a(paramString2));
  }
  
  public static ArrayList<asbw> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = amde.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      asbw localasbw = (asbw)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localasbw.a, localasbw.jdField_b_of_type_Long)) {
        localArrayList.add(localasbw);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (amde.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (amde.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (asca.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!asca.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asav
 * JD-Core Version:    0.7.0.1
 */