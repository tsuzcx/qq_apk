import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class awzn
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = axaj.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                                return 2130850163;
                              }
                              if (paramLong2 == 1L) {
                                return 2130850164;
                              }
                            } while (paramLong2 != 2L);
                            return 2130850165;
                            if (paramLong2 == 0L) {
                              return 2130850157;
                            }
                            if (paramLong2 == 1L) {
                              return 2130850158;
                            }
                          } while (paramLong2 != 2L);
                          return 2130850159;
                          if (paramLong2 == 0L) {
                            return 2130850160;
                          }
                          if (paramLong2 == 1L) {
                            return 2130850161;
                          }
                        } while (paramLong2 != 2L);
                        return 2130850162;
                        if (paramLong2 == 1L) {
                          return 2130850154;
                        }
                        if (paramLong2 == 2L) {
                          return 2130850155;
                        }
                      } while (paramLong2 != 3L);
                      return 2130850156;
                      if (paramLong2 == 1L) {
                        return 2130850181;
                      }
                    } while (paramLong2 != 2L);
                    return 2130850140;
                    if (paramLong2 == 1L) {
                      return 2130850185;
                    }
                  } while (paramLong2 != 2L);
                  return 2130850144;
                  if (paramLong2 == 1L) {
                    return 2130850173;
                  }
                } while (paramLong2 != 2L);
                return 2130850172;
                if (paramLong2 == 1L) {
                  return 2130850179;
                }
              } while (paramLong2 != 2L);
              return 2130850180;
              if (paramLong2 == 1L) {
                return 2130850184;
              }
            } while (paramLong2 != 2L);
            return 2130850143;
          } while (paramLong2 != 1L);
          return 2130850178;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130850176;
        if (paramLong2 == 1L) {
          return 2130850169;
        }
        if (paramLong2 == 2L) {
          return 2130850170;
        }
      } while (paramLong2 != 3L);
      return 2130850171;
      if (paramLong2 == 1L) {
        return 2130850151;
      }
      if (paramLong2 == 2L) {
        return 2130850152;
      }
    } while (paramLong2 != 3L);
    return 2130850153;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, awzy.b(paramString2), awzy.a(paramString2));
  }
  
  public static axan a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return aqqb.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, awzy.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = aqqb.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return awzy.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, awzy.b(paramString2), awzy.a(paramString2));
  }
  
  public static ArrayList<axao> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = aqqb.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      axao localaxao = (axao)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localaxao.a, localaxao.jdField_b_of_type_Long)) {
        localArrayList.add(localaxao);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (aqqb.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (aqqb.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (axas.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!axas.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzn
 * JD-Core Version:    0.7.0.1
 */