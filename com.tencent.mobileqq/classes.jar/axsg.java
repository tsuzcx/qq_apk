import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class axsg
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = axtc.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                                return 2130850175;
                              }
                              if (paramLong2 == 1L) {
                                return 2130850176;
                              }
                            } while (paramLong2 != 2L);
                            return 2130850177;
                            if (paramLong2 == 0L) {
                              return 2130850169;
                            }
                            if (paramLong2 == 1L) {
                              return 2130850170;
                            }
                          } while (paramLong2 != 2L);
                          return 2130850171;
                          if (paramLong2 == 0L) {
                            return 2130850172;
                          }
                          if (paramLong2 == 1L) {
                            return 2130850173;
                          }
                        } while (paramLong2 != 2L);
                        return 2130850174;
                        if (paramLong2 == 1L) {
                          return 2130850166;
                        }
                        if (paramLong2 == 2L) {
                          return 2130850167;
                        }
                      } while (paramLong2 != 3L);
                      return 2130850168;
                      if (paramLong2 == 1L) {
                        return 2130850193;
                      }
                    } while (paramLong2 != 2L);
                    return 2130850152;
                    if (paramLong2 == 1L) {
                      return 2130850197;
                    }
                  } while (paramLong2 != 2L);
                  return 2130850156;
                  if (paramLong2 == 1L) {
                    return 2130850185;
                  }
                } while (paramLong2 != 2L);
                return 2130850184;
                if (paramLong2 == 1L) {
                  return 2130850191;
                }
              } while (paramLong2 != 2L);
              return 2130850192;
              if (paramLong2 == 1L) {
                return 2130850196;
              }
            } while (paramLong2 != 2L);
            return 2130850155;
          } while (paramLong2 != 1L);
          return 2130850190;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130850188;
        if (paramLong2 == 1L) {
          return 2130850181;
        }
        if (paramLong2 == 2L) {
          return 2130850182;
        }
      } while (paramLong2 != 3L);
      return 2130850183;
      if (paramLong2 == 1L) {
        return 2130850163;
      }
      if (paramLong2 == 2L) {
        return 2130850164;
      }
    } while (paramLong2 != 3L);
    return 2130850165;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, axsr.b(paramString2), axsr.a(paramString2));
  }
  
  public static axtg a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return arfj.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, axsr.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = arfj.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return axsr.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, axsr.b(paramString2), axsr.a(paramString2));
  }
  
  public static ArrayList<axti> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = arfj.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      axti localaxti = (axti)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localaxti.a, localaxti.jdField_b_of_type_Long)) {
        localArrayList.add(localaxti);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (arfj.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (arfj.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (axtm.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!axtm.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsg
 * JD-Core Version:    0.7.0.1
 */