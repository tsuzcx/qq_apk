import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class aosp
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bgjq.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bhgg.a(anhk.ba) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(aosj paramaosj)
  {
    if (paramaosj == null) {
      return null;
    }
    paramaosj = (aosk)paramaosj.a().get(Integer.valueOf(0));
    if (paramaosj == null) {
      return null;
    }
    return a(paramaosj);
  }
  
  public static String a(aosk paramaosk)
  {
    return paramaosk.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(aosj paramaosj)
  {
    paramaosj = (aosk)paramaosj.a().get(Integer.valueOf(0));
    if (paramaosj == null) {
      return null;
    }
    return b(paramaosj);
  }
  
  public static String b(aosk paramaosk)
  {
    return paramaosk.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosp
 * JD-Core Version:    0.7.0.1
 */