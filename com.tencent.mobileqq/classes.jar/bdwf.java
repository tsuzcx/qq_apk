import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class bdwf
{
  private static Application jdField_a_of_type_AndroidAppApplication;
  private static final bdwf jdField_a_of_type_Bdwf = new bdwf();
  private DexClassLoader jdField_a_of_type_DalvikSystemDexClassLoader;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private Object jdField_a_of_type_JavaLangObject;
  private Constructor jdField_a_of_type_JavaLangReflectConstructor;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private Class<?> jdField_b_of_type_JavaLangClass;
  private Method jdField_b_of_type_JavaLangReflectMethod;
  private boolean jdField_b_of_type_Boolean = true;
  private Class<?> jdField_c_of_type_JavaLangClass;
  private Method jdField_c_of_type_JavaLangReflectMethod;
  
  static Application a()
  {
    if (jdField_a_of_type_AndroidAppApplication != null) {
      return jdField_a_of_type_AndroidAppApplication;
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
      bdwh.a("", localException);
      throw new NullPointerException("u should init first");
    }
    jdField_a_of_type_AndroidAppApplication = (Application)localException;
    Application localApplication = jdField_a_of_type_AndroidAppApplication;
    return localApplication;
  }
  
  public static bdwf a()
  {
    if ((!jdField_a_of_type_Bdwf.jdField_a_of_type_Boolean) && (jdField_a_of_type_Bdwf.jdField_b_of_type_Boolean))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        break label33;
      }
      a();
    }
    for (;;)
    {
      return jdField_a_of_type_Bdwf;
      label33:
      if (jdField_a_of_type_Bdwf.a()) {
        jdField_a_of_type_Bdwf.b();
      }
    }
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
    jdField_a_of_type_Bdwf.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Bdwf.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return bdwh.a();
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Bdwf.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Bdwf.jdField_a_of_type_JavaLangClass != null) && (jdField_a_of_type_Bdwf.jdField_a_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return true;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Bdwf.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Bdwf.jdField_b_of_type_JavaLangClass != null) && (jdField_a_of_type_Bdwf.jdField_b_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Bdwf.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Bdwf.jdField_c_of_type_JavaLangClass != null) && (jdField_a_of_type_Bdwf.jdField_c_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public Drawable a(String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (new File(paramString).exists())) {
      try
      {
        if (this.jdField_a_of_type_JavaLangReflectConstructor == null) {
          this.jdField_a_of_type_JavaLangReflectConstructor = a("com.tencent.android.gldrawable.video.VideoDrawable").getConstructor(new Class[] { String.class });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.jdField_a_of_type_JavaLangReflectConstructor.newInstance(new Object[] { paramString });
        bdwh.a("videodrawable-sucess", (int)(System.currentTimeMillis() - l));
        return paramString;
      }
      catch (Exception paramString)
      {
        bdwh.a(paramString);
        bdwh.a("videodrawable-error", paramString.getMessage());
      }
    }
    return null;
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (new File(paramString).exists())) {
      try
      {
        if (this.jdField_c_of_type_JavaLangReflectMethod == null) {
          this.jdField_c_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangObject.getClass().getMethod("getAutoEtcDrawable", new Class[] { String.class, Handler.class, Boolean.TYPE });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramString, paramHandler, Boolean.valueOf(paramBoolean) });
        bdwh.a("autoetc-sucess", (int)(System.currentTimeMillis() - l));
        return paramString;
      }
      catch (Exception paramString)
      {
        bdwh.a(paramString);
        bdwh.a("autoetc-error", paramString.getMessage());
      }
    }
    return null;
  }
  
  public String a(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramDrawable != null))
    {
      if ((this.jdField_b_of_type_JavaLangReflectMethod == null) && (a("setLockWH"))) {}
      try
      {
        this.jdField_b_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("setLockWH", new Class[] { Boolean.TYPE });
        if (this.jdField_b_of_type_JavaLangReflectMethod == null) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            paramDrawable = (String)this.jdField_b_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[] { Boolean.valueOf(paramBoolean) });
            return paramDrawable;
          }
          catch (Exception paramDrawable)
          {
            bdwh.a(paramDrawable);
          }
          localException = localException;
          bdwh.a(localException);
        }
      }
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((!this.jdField_a_of_type_Boolean) || (paramDrawable == null) || ((this.jdField_a_of_type_JavaLangReflectMethod == null) && (a("recycle")))) {}
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("recycle", new Class[0]);
      if (this.jdField_a_of_type_JavaLangReflectMethod == null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[0]);
          return;
        }
        catch (Exception paramDrawable)
        {
          bdwh.a(paramDrawable);
        }
        localException = localException;
        bdwh.a(localException);
      }
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
              break label286;
            }
            if (bdwh.c()) {
              break label232;
            }
            if (bdwh.b()) {
              break label208;
            }
            paramString1 = new File(localFile2, "/jni/armeabi-v7a");
            bdwh.b("so", "armeabi-v7a");
            if ((!localFile1.exists()) || (!paramString1.exists())) {
              continue;
            }
            paramString2 = new File(localApplication.getFilesDir(), "gldrawable/opt");
            if (!paramString2.exists()) {
              paramString2.mkdirs();
            }
            if ((paramString2.exists()) && (paramString2.isDirectory())) {
              break label298;
            }
            this.jdField_b_of_type_Boolean = false;
          }
        }
        catch (Exception paramString1)
        {
          bdwh.a(paramString1);
          a();
          bdwh.a("init-error", paramString1.getMessage());
        }
      }
      finally {}
      File localFile1;
      label286:
      for (;;)
      {
        Application localApplication;
        File localFile2;
        break;
        localFile1 = new File(paramString1);
        continue;
        label208:
        paramString1 = new File(localFile2, "/jni/arm64-v8a");
        bdwh.b("so", "arm64-v8a");
        continue;
        label232:
        if (!bdwh.b())
        {
          paramString1 = new File(localFile2, "/jni/x86");
          bdwh.b("so", "x86");
        }
        else
        {
          paramString1 = new File(localFile2, "/jni/x86_64");
          bdwh.b("so", "x86_64");
          continue;
          paramString1 = new File(paramString2);
        }
      }
      label298:
      this.jdField_a_of_type_DalvikSystemDexClassLoader = new DexClassLoader(localFile1.getAbsolutePath(), paramString2.getAbsolutePath(), paramString1.getAbsolutePath(), bdwf.class.getClassLoader());
      try
      {
        a("com.tencent.android.gldrawable.utils.Logger").getMethod("setLogger", new Class[] { Handler.Callback.class }).invoke(null, new Object[] { new bdwg(this) });
        paramString1 = a("com.tencent.android.gldrawable.GLDrawable");
        paramString1.getMethod("init", new Class[0]).invoke(null, new Object[0]);
        if (bdwh.d()) {
          paramString1.getMethod("setDebugGL", new Class[] { Boolean.TYPE }).invoke(null, new Object[] { Boolean.valueOf(true) });
        }
        this.jdField_a_of_type_JavaLangClass = a("com.tencent.android.gldrawable.common.BaseDrawable");
        this.jdField_b_of_type_JavaLangClass = a("com.tencent.android.gldrawable.video.VideoDrawable");
        this.jdField_c_of_type_JavaLangClass = a("com.tencent.android.gldrawable.etc.EtcDrawable");
      }
      catch (Exception paramString1)
      {
        try
        {
          this.jdField_a_of_type_JavaLangObject = a("com.tencent.android.gldrawable.GLDrawable").getMethod("factory", new Class[0]).invoke(null, new Object[0]);
          this.jdField_a_of_type_Boolean = true;
          continue;
          paramString1 = paramString1;
          bdwh.a(paramString1);
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            bdwh.a(paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwf
 * JD-Core Version:    0.7.0.1
 */