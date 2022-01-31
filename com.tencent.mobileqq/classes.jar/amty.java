import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class amty
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bdep.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bdzf.a(alof.aX) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(amts paramamts)
  {
    if (paramamts == null) {
      return null;
    }
    paramamts = (amtt)paramamts.a().get(Integer.valueOf(0));
    if (paramamts == null) {
      return null;
    }
    return a(paramamts);
  }
  
  public static String a(amtt paramamtt)
  {
    return paramamtt.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(amts paramamts)
  {
    paramamts = (amtt)paramamts.a().get(Integer.valueOf(0));
    if (paramamts == null) {
      return null;
    }
    return b(paramamts);
  }
  
  public static String b(amtt paramamtt)
  {
    return paramamtt.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */