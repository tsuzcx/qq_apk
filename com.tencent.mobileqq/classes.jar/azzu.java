import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;

public class azzu
{
  public static String a;
  static boolean a;
  static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "SystemUtil";
  }
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static String a(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString, null });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    jdField_a_of_type_Boolean = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(a("ro.miui.ui.version.code")))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
        if (TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
          break label50;
        }
      }
    }
    label50:
    for (bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static long b()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data/data/com.tencent.mobileqq/files/");
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_Boolean) {
      return b;
    }
    a();
    return b;
  }
  
  public static boolean c()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean e()
  {
    return (!TextUtils.isEmpty(a("ro.meizu.product.model"))) || ("meizu".equalsIgnoreCase(Build.BRAND)) || ("22c4185e".equalsIgnoreCase(Build.BRAND));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azzu
 * JD-Core Version:    0.7.0.1
 */