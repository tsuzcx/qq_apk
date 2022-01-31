import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class auny
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = auou.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                                return 2130849539;
                              }
                              if (paramLong2 == 1L) {
                                return 2130849540;
                              }
                            } while (paramLong2 != 2L);
                            return 2130849541;
                            if (paramLong2 == 0L) {
                              return 2130849533;
                            }
                            if (paramLong2 == 1L) {
                              return 2130849534;
                            }
                          } while (paramLong2 != 2L);
                          return 2130849535;
                          if (paramLong2 == 0L) {
                            return 2130849536;
                          }
                          if (paramLong2 == 1L) {
                            return 2130849537;
                          }
                        } while (paramLong2 != 2L);
                        return 2130849538;
                        if (paramLong2 == 1L) {
                          return 2130849530;
                        }
                        if (paramLong2 == 2L) {
                          return 2130849531;
                        }
                      } while (paramLong2 != 3L);
                      return 2130849532;
                      if (paramLong2 == 1L) {
                        return 2130849557;
                      }
                    } while (paramLong2 != 2L);
                    return 2130849516;
                    if (paramLong2 == 1L) {
                      return 2130849561;
                    }
                  } while (paramLong2 != 2L);
                  return 2130849520;
                  if (paramLong2 == 1L) {
                    return 2130849549;
                  }
                } while (paramLong2 != 2L);
                return 2130849548;
                if (paramLong2 == 1L) {
                  return 2130849555;
                }
              } while (paramLong2 != 2L);
              return 2130849556;
              if (paramLong2 == 1L) {
                return 2130849560;
              }
            } while (paramLong2 != 2L);
            return 2130849519;
          } while (paramLong2 != 1L);
          return 2130849554;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130849552;
        if (paramLong2 == 1L) {
          return 2130849545;
        }
        if (paramLong2 == 2L) {
          return 2130849546;
        }
      } while (paramLong2 != 3L);
      return 2130849547;
      if (paramLong2 == 1L) {
        return 2130849527;
      }
      if (paramLong2 == 2L) {
        return 2130849528;
      }
    } while (paramLong2 != 3L);
    return 2130849529;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, auoj.b(paramString2), auoj.a(paramString2));
  }
  
  public static auoy a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return aokh.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, auoj.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = aokh.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return auoj.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, auoj.b(paramString2), auoj.a(paramString2));
  }
  
  public static ArrayList<auoz> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = aokh.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      auoz localauoz = (auoz)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localauoz.a, localauoz.jdField_b_of_type_Long)) {
        localArrayList.add(localauoz);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (aokh.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (aokh.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (aupd.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!aupd.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auny
 * JD-Core Version:    0.7.0.1
 */