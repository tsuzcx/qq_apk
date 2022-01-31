import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class baqn
{
  private static final baqn jdField_a_of_type_Baqn = new baqn();
  private Application jdField_a_of_type_AndroidAppApplication;
  private DexClassLoader jdField_a_of_type_DalvikSystemDexClassLoader;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private Constructor jdField_a_of_type_JavaLangReflectConstructor;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private boolean jdField_a_of_type_Boolean;
  private Method jdField_b_of_type_JavaLangReflectMethod;
  private boolean jdField_b_of_type_Boolean = true;
  
  private Application a()
  {
    if (this.jdField_a_of_type_AndroidAppApplication != null) {
      return this.jdField_a_of_type_AndroidAppApplication;
    }
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject1 = ((Class)localObject1).getMethod("getApplication", new Class[0]).invoke(localObject2, new Object[0]);
      if (localObject1 == null) {
        throw new NullPointerException("u should init first");
      }
    }
    catch (Exception localException)
    {
      QLog.e("GLDrawable", 1, "", localException);
      throw new NullPointerException("u should init first");
    }
    this.jdField_a_of_type_AndroidAppApplication = ((Application)localException);
    Application localApplication = this.jdField_a_of_type_AndroidAppApplication;
    return localApplication;
  }
  
  public static baqn a()
  {
    if ((!jdField_a_of_type_Baqn.jdField_a_of_type_Boolean) && (jdField_a_of_type_Baqn.jdField_b_of_type_Boolean) && (jdField_a_of_type_Baqn.a())) {
      jdField_a_of_type_Baqn.b();
    }
    return jdField_a_of_type_Baqn;
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "gldrawable");
  }
  
  private Class<?> a(String paramString)
  {
    return this.jdField_a_of_type_DalvikSystemDexClassLoader.loadClass(paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_Baqn.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Baqn.jdField_a_of_type_Boolean = false;
  }
  
  protected static void a(String paramString, int paramInt)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString, "1", 0, 0, paramInt, 0, "", "");
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return true;
      if (!amjs.c().a()) {
        return false;
      }
      try
      {
        if (new File(a(a()), "gldrawable.dex").exists()) {
          continue;
        }
        baqm.a();
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("GLDrawable", 1, "", localException);
          b("download-error", localException.getMessage());
        }
      }
    }
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Baqn.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Baqn.jdField_a_of_type_JavaLangClass != null) && (jdField_a_of_type_Baqn.jdField_a_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  protected static void b(String paramString1, String paramString2)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString1, "2", 0, 0, 0, 0, paramString2, String.valueOf(System.currentTimeMillis()));
  }
  
  private static boolean b()
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
  
  protected static void c(String paramString1, String paramString2)
  {
    VasWebviewUtil.reportVasStatus("GLDrawable", "gl-" + paramString1, "1", 0, 0, 0, 0, paramString2, "");
  }
  
  private static boolean c()
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
  
  public Drawable a(String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (new File(paramString).exists())) {
      try
      {
        Constructor localConstructor;
        if (this.jdField_a_of_type_JavaLangReflectConstructor == null)
        {
          localConstructor = a("com.tencent.android.gldrawable.video.VideoDrawable").getConstructor(new Class[] { String.class });
          this.jdField_a_of_type_JavaLangReflectConstructor = localConstructor;
        }
        for (;;)
        {
          long l = System.currentTimeMillis();
          paramString = (Drawable)localConstructor.newInstance(new Object[] { paramString });
          a("videodrawable-sucess", (int)(System.currentTimeMillis() - l));
          return paramString;
          localConstructor = this.jdField_a_of_type_JavaLangReflectConstructor;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("GLDrawable", 1, paramString, new Object[0]);
        b("videodrawable-error", paramString.getMessage());
      }
    }
  }
  
  public String a(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangReflectMethod != null)) {
      try
      {
        paramDrawable = (String)this.jdField_b_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[0]);
        return paramDrawable;
      }
      catch (Exception paramDrawable)
      {
        QLog.e("GLDrawable", 1, paramDrawable, new Object[0]);
      }
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangReflectMethod != null)) {}
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[0]);
      return;
    }
    catch (Exception paramDrawable)
    {
      QLog.e("GLDrawable", 1, paramDrawable, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          a();
          continue;
        }
        try
        {
          localApplication = a();
          localFile2 = a(localApplication);
          if (TextUtils.isEmpty(paramString1))
          {
            localFile1 = new File(localFile2, "gldrawable.dex");
            if (!TextUtils.isEmpty(paramString2)) {
              break label300;
            }
            if (c()) {
              break label245;
            }
            if (b()) {
              break label220;
            }
            paramString1 = new File(localFile2, "/jni/armeabi-v7a");
            c("so", "armeabi-v7a");
            if ((!localFile1.exists()) || (!paramString1.exists())) {
              continue;
            }
            paramString2 = new File(localApplication.getFilesDir(), "gldrawable_opt");
            if (!paramString2.exists()) {
              paramString2.mkdirs();
            }
            if ((paramString2.exists()) && (paramString2.isDirectory())) {
              break label312;
            }
            this.jdField_b_of_type_Boolean = false;
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("GLDrawable", 1, paramString1, new Object[0]);
          a();
          b("init-error", paramString1.getMessage());
        }
      }
      finally {}
      File localFile1;
      label300:
      for (;;)
      {
        Application localApplication;
        File localFile2;
        break;
        localFile1 = new File(paramString1);
        continue;
        label220:
        paramString1 = new File(localFile2, "/jni/arm64-v8a");
        c("so", "arm64-v8a");
        continue;
        label245:
        if (!b())
        {
          paramString1 = new File(localFile2, "/jni/x86");
          c("so", "x86");
        }
        else
        {
          paramString1 = new File(localFile2, "/jni/x86_64");
          c("so", "x86_64");
          continue;
          paramString1 = new File(paramString2);
        }
      }
      label312:
      this.jdField_a_of_type_DalvikSystemDexClassLoader = new DexClassLoader(localFile1.getAbsolutePath(), paramString2.getAbsolutePath(), paramString1.getAbsolutePath(), baqn.class.getClassLoader());
      a("com.tencent.android.gldrawable.GLDrawable").getMethod("init", new Class[0]).invoke(null, new Object[0]);
      this.jdField_a_of_type_JavaLangClass = a("com.tencent.android.gldrawable.BaseDrawable");
      try
      {
        this.jdField_a_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("recycle", new Class[0]);
      }
      catch (Exception paramString1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.jdField_b_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("getResID", new Class[0]);
              this.jdField_a_of_type_Boolean = true;
              try
              {
                a("com.tencent.android.gldrawable.utils.Logger").getMethod("setLogger", new Class[] { Handler.Callback.class }).invoke(null, new Object[] { new baqo(this) });
              }
              catch (Exception paramString1)
              {
                QLog.e("GLDrawable", 1, paramString1, new Object[0]);
              }
            }
            break;
            paramString1 = paramString1;
            QLog.e("GLDrawable", 1, paramString1, new Object[0]);
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            QLog.e("GLDrawable", 1, paramString1, new Object[0]);
          }
        }
      }
    }
  }
  
  public void b()
  {
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqn
 * JD-Core Version:    0.7.0.1
 */