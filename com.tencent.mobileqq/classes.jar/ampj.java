import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class ampj
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bdag.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bduw.a(aljq.aX) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(ampd paramampd)
  {
    if (paramampd == null) {
      return null;
    }
    paramampd = (ampe)paramampd.a().get(Integer.valueOf(0));
    if (paramampd == null) {
      return null;
    }
    return a(paramampd);
  }
  
  public static String a(ampe paramampe)
  {
    return paramampe.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(ampd paramampd)
  {
    paramampd = (ampe)paramampd.a().get(Integer.valueOf(0));
    if (paramampd == null) {
      return null;
    }
    return b(paramampd);
  }
  
  public static String b(ampe paramampe)
  {
    return paramampe.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampj
 * JD-Core Version:    0.7.0.1
 */