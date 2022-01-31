import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.hotpatch.PatchResolveForDalvik;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class bjmt
{
  private static boolean a;
  
  public static boolean a(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, bjmm parambjmm)
  {
    return a(paramString1, paramContext, paramClassLoader, paramString2, parambjmm, false);
  }
  
  public static boolean a(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, bjmm parambjmm, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneModuleLoader", 2, "classloader is: " + paramClassLoader + " , classloader class is: " + paramClassLoader.getClass());
    }
    QLog.d("QzoneModuleLoader", 4, "load module: " + paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return bool1;
      if (!new File(paramString1).exists()) {
        continue;
      }
      long l = System.nanoTime();
      try
      {
        paramBoolean = bjms.a(paramContext, paramClassLoader, paramString1, paramString2, paramBoolean);
        l = (System.nanoTime() - l) / 1000000L;
        QLog.d("QzoneModuleLoader", 1, "loaded module success ? " + paramBoolean + " --module:  " + paramString1 + " , classloader: " + paramClassLoader + ", cost:" + l);
        bool1 = paramBoolean;
        if (parambjmm == null) {
          continue;
        }
        bjmx.b(parambjmm, paramBoolean, l);
        return paramBoolean;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          QLog.e("QzoneModuleLoader", 1, "inject failed, catch an exception:", paramContext);
          paramBoolean = bool2;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, bjmm parambjmm)
  {
    long l = System.nanoTime();
    boolean bool = a(paramString1, paramContext, QzoneModuleConst.class.getClassLoader(), paramString2, parambjmm, true);
    if (bool)
    {
      if (Build.VERSION.SDK_INT < 21) {}
      for (;;)
      {
        try
        {
          if (!a)
          {
            if ((!Build.CPU_ABI.toLowerCase(Locale.US).contains("x86")) && (!SoLoadUtil.b())) {
              continue;
            }
            QLog.d("QzoneModuleLoader", 4, "is x86,so call loadNativeLibrary.");
            a = SoLoadUtil.a(paramContext.getApplicationContext(), "qq_patch", 0, false, false);
          }
          if (!a) {
            continue;
          }
          i = PatchResolveForDalvik.a(Arrays.asList(parambjmm.h.split(";")), parambjmm.a);
        }
        catch (Throwable paramContext)
        {
          QLog.e("QzoneModuleLoader", 1, "catch an exception:", paramContext);
          i = -1;
          continue;
          QLog.e("QzoneModuleLoader", 1, "resolvePatchClass failed: " + paramString1 + " ,load so failed.");
          bjmx.a(parambjmm, "-1", (System.nanoTime() - l) / 1000000L);
        }
        if (i == 0) {
          break;
        }
        QLog.e("QzoneModuleLoader", 1, "resolvePatchClass failed: " + paramString1 + " ,resolveRes: " + i + ",classIdCount:" + parambjmm.a);
        paramString1 = bjms.a(QzoneModuleConst.class.getClassLoader(), 0);
        l = (System.nanoTime() - l) / 1000000L;
        bjmx.a(parambjmm, "0", l);
        QLog.i("QzoneModuleLoader", 1, "----------unloadDexElement " + paramString1 + " , cost:" + l);
        return false;
        a = SoLoadUtilNew.loadSoByName(paramContext.getApplicationContext(), "qq_patch");
        continue;
        int i = 0;
      }
      l = (System.nanoTime() - l) / 1000000L;
      QLog.i("QzoneModuleLoader", 1, "----------resolve class successful, cost:" + l);
      bjmx.a(parambjmm, "1", l);
      return true;
    }
    QLog.e("QzoneModuleLoader", 1, "loadModule failed: " + paramString1);
    bjmx.a(parambjmm, "0", (System.nanoTime() - l) / 1000000L);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmt
 * JD-Core Version:    0.7.0.1
 */