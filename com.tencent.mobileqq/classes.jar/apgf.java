import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class apgf
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bhjr.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bigv.a(antf.ba) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(apfz paramapfz)
  {
    if (paramapfz == null) {
      return null;
    }
    paramapfz = (apga)paramapfz.a().get(Integer.valueOf(0));
    if (paramapfz == null) {
      return null;
    }
    return a(paramapfz);
  }
  
  public static String a(apga paramapga)
  {
    return paramapga.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(apfz paramapfz)
  {
    paramapfz = (apga)paramapfz.a().get(Integer.valueOf(0));
    if (paramapfz == null) {
      return null;
    }
    return b(paramapfz);
  }
  
  public static String b(apga paramapga)
  {
    return paramapga.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgf
 * JD-Core Version:    0.7.0.1
 */