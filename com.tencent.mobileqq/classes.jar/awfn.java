import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class awfn
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = awgj.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                              do
                              {
                                return 0;
                                if (paramLong2 == 0L) {
                                  return 2130850093;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850094;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850095;
                              if (paramLong2 == 0L) {
                                return 2130850087;
                              }
                              if (paramLong2 == 1L) {
                                return 2130850088;
                              }
                            } while (paramLong2 != 2L);
                            return 2130850089;
                            if (paramLong2 == 0L) {
                              return 2130850099;
                            }
                            if (paramLong2 == 1L) {
                              return 2130850100;
                            }
                          } while (paramLong2 != 2L);
                          return 2130850101;
                          if (paramLong2 == 0L) {
                            return 2130850090;
                          }
                          if (paramLong2 == 1L) {
                            return 2130850091;
                          }
                        } while (paramLong2 != 2L);
                        return 2130850092;
                        if (paramLong2 == 1L) {
                          return 2130850084;
                        }
                        if (paramLong2 == 2L) {
                          return 2130850085;
                        }
                      } while (paramLong2 != 3L);
                      return 2130850086;
                      if (paramLong2 == 1L) {
                        return 2130850114;
                      }
                    } while (paramLong2 != 2L);
                    return 2130850070;
                    if (paramLong2 == 1L) {
                      return 2130850118;
                    }
                  } while (paramLong2 != 2L);
                  return 2130850074;
                  if (paramLong2 == 1L) {
                    return 2130850106;
                  }
                } while (paramLong2 != 2L);
                return 2130850105;
                if (paramLong2 == 1L) {
                  return 2130850112;
                }
              } while (paramLong2 != 2L);
              return 2130850113;
              if (paramLong2 == 1L) {
                return 2130850117;
              }
            } while (paramLong2 != 2L);
            return 2130850073;
          } while (paramLong2 != 1L);
          return 2130850111;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130850109;
        if (paramLong2 == 1L) {
          return 2130850102;
        }
        if (paramLong2 == 2L) {
          return 2130850103;
        }
      } while (paramLong2 != 3L);
      return 2130850104;
      if (paramLong2 == 1L) {
        return 2130850081;
      }
      if (paramLong2 == 2L) {
        return 2130850082;
      }
    } while (paramLong2 != 3L);
    return 2130850083;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, awfy.b(paramString2), awfy.a(paramString2));
  }
  
  public static awgn a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return apyz.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, awfy.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = apyz.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return awfy.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, awfy.b(paramString2), awfy.a(paramString2));
  }
  
  public static ArrayList<awgp> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = apyz.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      awgp localawgp = (awgp)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localawgp.a, localawgp.jdField_b_of_type_Long)) {
        localArrayList.add(localawgp);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (apyz.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (apyz.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 26L) && (paramLong != 3L)) || (awgt.a(paramQQAppInterface.getCurrentUin()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 26L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!awgt.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfn
 * JD-Core Version:    0.7.0.1
 */