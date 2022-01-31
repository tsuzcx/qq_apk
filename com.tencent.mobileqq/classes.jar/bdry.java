import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;

class bdry
{
  static void a(Exception paramException)
  {
    QLog.e("GLDrawable", 1, paramException, new Object[0]);
  }
  
  static void a(String paramString)
  {
    QLog.i("GLDrawable", 1, paramString);
  }
  
  static void a(String paramString, int paramInt)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString, "1", 0, 0, paramInt, 0, "", "");
  }
  
  static void a(String paramString, Exception paramException)
  {
    QLog.e("GLDrawable", 1, paramString, paramException);
  }
  
  static void a(String paramString1, String paramString2)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString1, "2", 0, 0, 0, 0, paramString2, String.valueOf(System.currentTimeMillis()));
  }
  
  static boolean a()
  {
    if (!aork.c().a()) {
      return false;
    }
    try
    {
      Application localApplication = bdrw.a();
      if ((bdrv.a(localApplication)) && (new File(bdrw.a(localApplication), "gldrawable.dex").exists())) {
        return true;
      }
      bdrv.a();
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("GLDrawable", 1, "", localException);
      a("download-error", localException.getMessage());
    }
    return false;
  }
  
  static void b(String paramString1, String paramString2)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString1, "1", 0, 0, 0, 0, paramString2, "");
  }
  
  static boolean b()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Process.is64Bit();
    }
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GLDrawable", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  static boolean c()
  {
    boolean bool1 = VideoEnvironment.c();
    Object localObject = Build.CPU_ABI;
    if ((localObject != null) && (!"".equals(localObject)) && ("x86".equalsIgnoreCase((String)localObject))) {
      return true;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = Build.SUPPORTED_ABIS;
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          CharSequence localCharSequence = localObject[i];
          bool2 = bool1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            bool2 = bool1;
            if (localCharSequence.toLowerCase().contains("x86")) {
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    return bool2;
  }
  
  static boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdry
 * JD-Core Version:    0.7.0.1
 */