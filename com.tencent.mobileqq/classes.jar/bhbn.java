import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

public class bhbn
{
  private static bhbn jdField_a_of_type_Bhbn = new bhbn();
  private static bhbs jdField_a_of_type_Bhbs = new bhbs();
  private DexClassLoader jdField_a_of_type_DalvikSystemDexClassLoader;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private Object jdField_a_of_type_JavaLangObject;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private Class<?> jdField_b_of_type_JavaLangClass;
  private Method jdField_b_of_type_JavaLangReflectMethod;
  private boolean jdField_b_of_type_Boolean = true;
  private Class<?> jdField_c_of_type_JavaLangClass;
  private Method jdField_c_of_type_JavaLangReflectMethod;
  private Method d;
  private Method e;
  
  public static bhbn a()
  {
    return jdField_a_of_type_Bhbn;
  }
  
  private DexClassLoader a(Context paramContext, File paramFile1, File paramFile2)
  {
    if ((!paramFile1.exists()) || (!paramFile2.exists())) {}
    do
    {
      return null;
      paramContext = new File(a(paramContext), "opt");
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    } while ((!paramContext.exists()) || (!paramContext.isDirectory()));
    return new DexClassLoader(paramFile1.getAbsolutePath(), paramContext.getAbsolutePath(), paramFile2.getAbsolutePath(), bhbn.class.getClassLoader());
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
    jdField_a_of_type_Bhbn.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Bhbn.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(bhbs parambhbs)
  {
    jdField_a_of_type_Bhbs = parambhbs;
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Bhbn.jdField_b_of_type_Boolean) && (jdField_a_of_type_Bhbn.jdField_a_of_type_Boolean);
  }
  
  @Deprecated
  public static boolean a(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Bhbn.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Bhbn.jdField_b_of_type_JavaLangClass != null) && (jdField_a_of_type_Bhbn.jdField_b_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public static boolean a(Object paramObject)
  {
    if ((paramObject instanceof bhbg)) {}
    while ((jdField_a_of_type_Bhbn.jdField_a_of_type_Boolean) && (paramObject != null) && (jdField_a_of_type_Bhbn.jdField_a_of_type_JavaLangClass != null) && (jdField_a_of_type_Bhbn.jdField_a_of_type_JavaLangClass.isAssignableFrom(paramObject.getClass()))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return true;
  }
  
  private void b()
  {
    try
    {
      a("com.tencent.android.gldrawable.utils.Logger").getMethod("setLogger", new Class[] { Handler.Callback.class }).invoke(null, new Object[] { new bhbp(this) });
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Bhbs.a(localException);
    }
  }
  
  public static boolean b()
  {
    return !jdField_a_of_type_Bhbn.jdField_b_of_type_Boolean;
  }
  
  @Deprecated
  public static boolean b(Drawable paramDrawable)
  {
    return (jdField_a_of_type_Bhbn.jdField_a_of_type_Boolean) && (paramDrawable != null) && (jdField_a_of_type_Bhbn.jdField_c_of_type_JavaLangClass != null) && (jdField_a_of_type_Bhbn.jdField_c_of_type_JavaLangClass.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public Drawable a(File paramFile, Looper paramLooper, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = localObject3;
      if (paramFile.exists())
      {
        str = paramFile.getName();
        if (!str.endsWith(".mp4")) {
          break label58;
        }
        localObject1 = a(paramFile.getAbsolutePath(), paramBoolean);
      }
    }
    label58:
    do
    {
      return localObject1;
      if ((str.endsWith(".png")) || (str.endsWith(".jpg"))) {
        break;
      }
      localObject1 = localObject3;
    } while (!str.endsWith(".jpeg"));
    localObject1 = paramFile.getAbsolutePath();
    if (paramLooper == null) {}
    for (paramFile = localObject2;; paramFile = new Handler(paramLooper)) {
      return a((String)localObject1, paramFile, paramBoolean);
    }
  }
  
  @Deprecated
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (new File(paramString).exists())) {
      try
      {
        if (this.d == null) {
          this.d = this.jdField_a_of_type_JavaLangObject.getClass().getMethod("getAutoEtcDrawable", new Class[] { String.class, Handler.class, Boolean.TYPE });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.d.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramString, paramHandler, Boolean.valueOf(paramBoolean) });
        int i = (int)(System.currentTimeMillis() - l);
        if (paramString != null)
        {
          jdField_a_of_type_Bhbs.a("gldrawable_etc_create", "sucess", "", i);
          return paramString;
        }
        jdField_a_of_type_Bhbs.a("gldrawable_etc_create", "empty", "", i);
        return paramString;
      }
      catch (Exception paramString)
      {
        jdField_a_of_type_Bhbs.a(paramString);
        jdField_a_of_type_Bhbs.a("gldrawable_etc_create", "error", paramString.getMessage(), -1L);
      }
    }
    return null;
  }
  
  @Deprecated
  public Drawable a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (new File(paramString).exists())) {
      try
      {
        if (this.e == null) {
          this.e = this.jdField_a_of_type_JavaLangObject.getClass().getMethod("getVideoDrawable", new Class[] { String.class, Boolean.TYPE });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.e.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        int i = (int)(System.currentTimeMillis() - l);
        if (paramString != null)
        {
          jdField_a_of_type_Bhbs.a("gldrawable_video_create", "sucess", "", i);
          return paramString;
        }
        jdField_a_of_type_Bhbs.a("gldrawable_video_create", "empty", "", i);
        return paramString;
      }
      catch (Exception paramString)
      {
        jdField_a_of_type_Bhbs.a(paramString);
        jdField_a_of_type_Bhbs.a("gldrawable_video_create", "error", paramString.getMessage(), -1L);
      }
    }
    return null;
  }
  
  public bhbg a(File paramFile, Looper paramLooper, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    bhbg localbhbg = new bhbg();
    localbhbg.a(paramFunction0);
    localbhbg.b(new bhbo(this, paramFile, paramLooper, paramBoolean));
    localbhbg.a();
    return localbhbg;
  }
  
  public void a(Context paramContext, File paramFile1, File paramFile2)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (paramContext == null)) {
      return;
    }
    try
    {
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return;
      }
    }
    finally {}
    for (;;)
    {
      try
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_DalvikSystemDexClassLoader = a(paramContext, paramFile1, paramFile2);
        if (this.jdField_a_of_type_DalvikSystemDexClassLoader == null)
        {
          jdField_a_of_type_Bhbs.a("gldrawable_main_init", "error", "class-loader", -1L);
          return;
        }
        b();
        paramContext = a("com.tencent.android.gldrawable.GLDrawable");
        paramContext.getMethod("init", new Class[0]).invoke(null, new Object[0]);
        if (!((Boolean)paramContext.getMethod("isEnable", new Class[0]).invoke(null, new Object[0])).booleanValue())
        {
          jdField_a_of_type_Bhbs.a("gldrawable_main_init", "disable", "sdk=" + Build.VERSION.SDK_INT, -1L);
          a();
          return;
        }
        this.jdField_a_of_type_JavaLangClass = a("com.tencent.android.gldrawable.common.BaseDrawable");
        this.jdField_b_of_type_JavaLangClass = a("com.tencent.android.gldrawable.video.VideoDrawable");
        this.jdField_c_of_type_JavaLangClass = a("com.tencent.android.gldrawable.etc.anim.AETCDrawable");
      }
      catch (Exception paramContext)
      {
        long l;
        jdField_a_of_type_Bhbs.a(paramContext);
        a();
        jdField_a_of_type_Bhbs.a("gldrawable_main_init", "error", paramContext.getMessage(), -1L);
        continue;
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject = a("com.tencent.android.gldrawable.GLDrawable").getMethod("factory", new Class[0]).invoke(null, new Object[0]);
        this.jdField_a_of_type_Boolean = true;
        jdField_a_of_type_Bhbs.a("gldrawable_main_init", "sucess", "", System.currentTimeMillis() - l);
        return;
      }
      catch (Exception paramContext)
      {
        jdField_a_of_type_Bhbs.a(paramContext);
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof bhbg)) {
      ((bhbg)paramDrawable).b();
    }
    for (;;)
    {
      return;
      if ((!this.jdField_a_of_type_Boolean) || (paramDrawable == null)) {
        continue;
      }
      if ((this.jdField_a_of_type_JavaLangReflectMethod == null) && (a("recycle"))) {}
      try
      {
        this.jdField_a_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("recycle", new Class[0]);
        if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[0]);
          return;
        }
        catch (Exception paramDrawable)
        {
          jdField_a_of_type_Bhbs.a(paramDrawable);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          jdField_a_of_type_Bhbs.a(localException);
        }
      }
    }
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramDrawable instanceof bhbg))
    {
      ((bhbg)paramDrawable).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      return true;
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramDrawable == null) || ((this.jdField_c_of_type_JavaLangReflectMethod == null) && (a("setDrawArea")))) {}
    try
    {
      this.jdField_c_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("setDrawArea", new Class[] { Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE });
      if (this.jdField_c_of_type_JavaLangReflectMethod != null) {
        try
        {
          this.jdField_c_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          jdField_a_of_type_Bhbs.a(paramDrawable);
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Bhbs.a(localException);
      }
    }
  }
  
  public boolean a(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramDrawable instanceof bhbg))
    {
      ((bhbg)paramDrawable).a(paramBoolean);
      return true;
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramDrawable == null) || ((this.jdField_b_of_type_JavaLangReflectMethod == null) && (a("setLockWH")))) {}
    try
    {
      this.jdField_b_of_type_JavaLangReflectMethod = this.jdField_a_of_type_JavaLangClass.getMethod("setLockWH", new Class[] { Boolean.TYPE });
      if (this.jdField_b_of_type_JavaLangReflectMethod != null) {
        try
        {
          this.jdField_b_of_type_JavaLangReflectMethod.invoke(paramDrawable, new Object[] { Boolean.valueOf(paramBoolean) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          jdField_a_of_type_Bhbs.a(paramDrawable);
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Bhbs.a(localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbn
 * JD-Core Version:    0.7.0.1
 */