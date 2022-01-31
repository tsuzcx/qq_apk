import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class aswz
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = asxv.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
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
                              return 2130849099;
                            }
                            if (paramLong2 == 1L) {
                              return 2130849100;
                            }
                          } while (paramLong2 != 2L);
                          return 2130849101;
                          if (paramLong2 == 0L) {
                            return 2130849093;
                          }
                          if (paramLong2 == 1L) {
                            return 2130849094;
                          }
                        } while (paramLong2 != 2L);
                        return 2130849095;
                        if (paramLong2 == 0L) {
                          return 2130849096;
                        }
                        if (paramLong2 == 1L) {
                          return 2130849097;
                        }
                      } while (paramLong2 != 2L);
                      return 2130849098;
                      if (paramLong2 == 1L) {
                        return 2130849090;
                      }
                      if (paramLong2 == 2L) {
                        return 2130849091;
                      }
                    } while (paramLong2 != 3L);
                    return 2130849092;
                    if (paramLong2 == 1L) {
                      return 2130849117;
                    }
                  } while (paramLong2 != 2L);
                  return 2130849079;
                  if (paramLong2 == 1L) {
                    return 2130849121;
                  }
                } while (paramLong2 != 2L);
                return 2130849083;
                if (paramLong2 == 1L) {
                  return 2130849109;
                }
              } while (paramLong2 != 2L);
              return 2130849108;
              if (paramLong2 == 1L) {
                return 2130849115;
              }
            } while (paramLong2 != 2L);
            return 2130849116;
            if (paramLong2 == 1L) {
              return 2130849120;
            }
          } while (paramLong2 != 2L);
          return 2130849082;
        } while (paramLong2 != 1L);
        return 2130849114;
      } while ((!paramBoolean) || (paramLong2 != 1L));
      return 2130849112;
      if (paramLong2 == 1L) {
        return 2130849105;
      }
      if (paramLong2 == 2L) {
        return 2130849106;
      }
    } while (paramLong2 != 3L);
    return 2130849107;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asxk.b(paramString2), asxk.a(paramString2));
  }
  
  public static asxz a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return amtg.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, asxk.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = amtg.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return asxk.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, asxk.b(paramString2), asxk.a(paramString2));
  }
  
  public static ArrayList<asya> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = amtg.a().a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      asya localasya = (asya)((Iterator)localObject).next();
      if (b(paramQQAppInterface, localasya.a, localasya.jdField_b_of_type_Long)) {
        localArrayList.add(localasya);
      }
    }
    return localArrayList;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (amtg.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (amtg.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (asye.a(paramQQAppInterface.c()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!asye.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aswz
 * JD-Core Version:    0.7.0.1
 */