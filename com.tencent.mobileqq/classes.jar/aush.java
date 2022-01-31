import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class aush
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = autd.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                            do
                            {
                              return 0;
                              if (paramLong2 == 0L) {
                                return 2130849612;
                              }
                              if (paramLong2 == 1L) {
                                return 2130849613;
                              }
                            } while (paramLong2 != 2L);
                            return 2130849614;
                            if (paramLong2 == 0L) {
                              return 2130849606;
                            }
                            if (paramLong2 == 1L) {
                              return 2130849607;
                            }
                          } while (paramLong2 != 2L);
                          return 2130849608;
                          if (paramLong2 == 0L) {
                            return 2130849609;
                          }
                          if (paramLong2 == 1L) {
                            return 2130849610;
                          }
                        } while (paramLong2 != 2L);
                        return 2130849611;
                        if (paramLong2 == 1L) {
                          return 2130849603;
                        }
                        if (paramLong2 == 2L) {
                          return 2130849604;
                        }
                      } while (paramLong2 != 3L);
                      return 2130849605;
                      if (paramLong2 == 1L) {
                        return 2130849630;
                      }
                    } while (paramLong2 != 2L);
                    return 2130849589;
                    if (paramLong2 == 1L) {
                      return 2130849634;
                    }
                  } while (paramLong2 != 2L);
                  return 2130849593;
                  if (paramLong2 == 1L) {
                    return 2130849622;
                  }
                } while (paramLong2 != 2L);
                return 2130849621;
                if (paramLong2 == 1L) {
                  return 2130849628;
                }
              } while (paramLong2 != 2L);
              return 2130849629;
              if (paramLong2 == 1L) {
                return 2130849633;
              }
            } while (paramLong2 != 2L);
            return 2130849592;
          } while (paramLong2 != 1L);
          return 2130849627;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130849625;
        if (paramLong2 == 1L) {
          return 2130849618;
        }
        if (paramLong2 == 2L) {
          return 2130849619;
        }
      } while (paramLong2 != 3L);
      return 2130849620;
      if (paramLong2 == 1L) {
        return 2130849600;
      }
      if (paramLong2 == 2L) {
        return 2130849601;
      }
    } while (paramLong2 != 3L);
    return 2130849602;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, auss.b(paramString2), auss.a(paramString2));
  }
  
  public static auth a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return aooq.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, auss.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = aooq.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return auss.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, auss.b(paramString2), auss.a(paramString2));
  }
  
  public static ArrayList<auti> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = aooq.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      auti localauti = (auti)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localauti.a, localauti.jdField_b_of_type_Long)) {
        localArrayList.add(localauti);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (aooq.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (aooq.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (autm.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!autm.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aush
 * JD-Core Version:    0.7.0.1
 */