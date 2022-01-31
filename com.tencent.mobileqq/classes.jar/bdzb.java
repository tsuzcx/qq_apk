import android.text.TextUtils;
import java.lang.reflect.Method;

public class bdzb
{
  private static String a()
  {
    return a("ro.build.display.id", "");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean a()
  {
    return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
  }
  
  public static boolean b()
  {
    return a().toLowerCase().contains("flyme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdzb
 * JD-Core Version:    0.7.0.1
 */