import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class asxb
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = asxx.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                                return 2130849108;
                              }
                              if (paramLong2 == 1L) {
                                return 2130849109;
                              }
                            } while (paramLong2 != 2L);
                            return 2130849110;
                            if (paramLong2 == 0L) {
                              return 2130849102;
                            }
                            if (paramLong2 == 1L) {
                              return 2130849103;
                            }
                          } while (paramLong2 != 2L);
                          return 2130849104;
                          if (paramLong2 == 0L) {
                            return 2130849105;
                          }
                          if (paramLong2 == 1L) {
                            return 2130849106;
                          }
                        } while (paramLong2 != 2L);
                        return 2130849107;
                        if (paramLong2 == 1L) {
                          return 2130849099;
                        }
                        if (paramLong2 == 2L) {
                          return 2130849100;
                        }
                      } while (paramLong2 != 3L);
                      return 2130849101;
                      if (paramLong2 == 1L) {
                        return 2130849126;
                      }
                    } while (paramLong2 != 2L);
                    return 2130849085;
                    if (paramLong2 == 1L) {
                      return 2130849130;
                    }
                  } while (paramLong2 != 2L);
                  return 2130849089;
                  if (paramLong2 == 1L) {
                    return 2130849118;
                  }
                } while (paramLong2 != 2L);
                return 2130849117;
                if (paramLong2 == 1L) {
                  return 2130849124;
                }
              } while (paramLong2 != 2L);
              return 2130849125;
              if (paramLong2 == 1L) {
                return 2130849129;
              }
            } while (paramLong2 != 2L);
            return 2130849088;
          } while (paramLong2 != 1L);
          return 2130849123;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130849121;
        if (paramLong2 == 1L) {
          return 2130849114;
        }
        if (paramLong2 == 2L) {
          return 2130849115;
        }
      } while (paramLong2 != 3L);
      return 2130849116;
      if (paramLong2 == 1L) {
        return 2130849096;
      }
      if (paramLong2 == 2L) {
        return 2130849097;
      }
    } while (paramLong2 != 3L);
    return 2130849098;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asxm.b(paramString2), asxm.a(paramString2));
  }
  
  public static asyb a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return amtf.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, asxm.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = amtf.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return asxm.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asxm.b(paramString2), asxm.a(paramString2));
  }
  
  public static ArrayList<asyc> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = amtf.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      asyc localasyc = (asyc)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localasyc.a, localasyc.jdField_b_of_type_Long)) {
        localArrayList.add(localasyc);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (amtf.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (amtf.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (asyg.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!asyg.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxb
 * JD-Core Version:    0.7.0.1
 */