import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class bmbb
{
  private static Object a(Object paramObject)
  {
    return a(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static Object a(Object paramObject, int paramInt)
  {
    Object localObject = paramObject.getClass().getComponentType();
    int m = Array.getLength(paramObject);
    if ((paramInt < 0) || (paramInt >= m)) {
      return paramObject;
    }
    localObject = Array.newInstance((Class)localObject, m - 1);
    int j = 0;
    int i = 0;
    if (j < m)
    {
      if (j == paramInt) {
        break label82;
      }
      int k = i + 1;
      Array.set(localObject, i, Array.get(paramObject, j));
      i = k;
    }
    label82:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  private static Object a(Object paramObject, Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject = paramObject2.getClass().getComponentType();
      int j = Array.getLength(paramObject2);
      int k = Array.getLength(paramObject1) + j;
      localObject = Array.newInstance((Class)localObject, k);
      int i = 0;
      if (i < k)
      {
        if (i < j) {
          Array.set(localObject, i, Array.get(paramObject2, i));
        }
        for (;;)
        {
          i += 1;
          break;
          Array.set(localObject, i, Array.get(paramObject1, i - j));
        }
      }
      return localObject;
      localObject = paramObject1;
      paramObject1 = paramObject2;
      paramObject2 = localObject;
    }
  }
  
  public static String a(ClassLoader paramClassLoader, int paramInt)
  {
    Object localObject;
    if (a())
    {
      if ((paramClassLoader instanceof PathClassLoader)) {}
      for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class) {
        return a(paramClassLoader, (Class)localObject, 0);
      }
    }
    if (!b()) {
      try
      {
        if ((paramClassLoader instanceof PathClassLoader)) {}
        for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class) {
          return b(paramClassLoader, (Class)localObject, 0);
        }
        return b(paramClassLoader, 0);
      }
      catch (Throwable paramClassLoader)
      {
        Log.e("QzoneModuleInjector", "fail to inject", paramClassLoader);
        return "";
      }
    }
  }
  
  private static String a(ClassLoader paramClassLoader, Class paramClass, int paramInt)
  {
    try
    {
      if ((paramClassLoader instanceof PathClassLoader)) {
        a(paramClassLoader, paramClass, "mPaths", a(a(paramClassLoader, paramClass, "mPaths"), paramInt));
      }
      a(paramClassLoader, PathClassLoader.class, "mFiles", a(a(paramClassLoader, paramClass, "mFiles"), paramInt));
      a(paramClassLoader, PathClassLoader.class, "mZips", a(a(paramClassLoader, paramClass, "mZips"), paramInt));
      a(paramClassLoader, PathClassLoader.class, "mLexs", a(a(paramClassLoader, paramClass, "mLexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return "unloadDexInAliyunOs error: " + Log.getStackTraceString(paramClassLoader);
  }
  
  private static void a(Context paramContext, ClassLoader paramClassLoader, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    Class localClass = Class.forName("dalvik.system.LexClassLoader");
    paramContext = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramContext.getDir("dex", 0).getAbsolutePath() + File.separator + str, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramClassLoader });
    if (!TextUtils.isEmpty(paramString2)) {
      localClass.getMethod("loadClass", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString2 });
    }
    if ((paramClassLoader instanceof PathClassLoader)) {
      a(paramClassLoader, paramClass, "mPaths", b(a(paramClassLoader, paramClass, "mPaths"), a(paramContext, localClass, "mRawDexPath"), paramBoolean));
    }
    a(paramClassLoader, paramClass, "mFiles", a(a(paramClassLoader, paramClass, "mFiles"), a(paramContext, localClass, "mFiles"), paramBoolean));
    a(paramClassLoader, paramClass, "mZips", a(a(paramClassLoader, paramClass, "mZips"), a(paramContext, localClass, "mZips"), paramBoolean));
    a(paramClassLoader, paramClass, "mLexs", a(a(paramClassLoader, paramClass, "mLexs"), a(paramContext, localClass, "mDexs"), paramBoolean));
  }
  
  private static void a(Context paramContext, ClassLoader paramClassLoader, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneModuleInjector", 2, "injectAboveEqualApiLevel14, libPathL:" + paramString1);
    }
    paramContext = new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramContext.getClassLoader());
    paramContext = a(b(a(paramClassLoader)), b(a(paramContext)), paramBoolean);
    paramString1 = a(paramClassLoader);
    a(paramString1, paramString1.getClass(), "dexElements", paramContext);
    if (!TextUtils.isEmpty(paramString2)) {
      paramClassLoader.loadClass(paramString2);
    }
  }
  
  private static void a(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  private static boolean a()
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public static boolean a(Context paramContext, ClassLoader paramClassLoader, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    Object localObject;
    if (a())
    {
      if ((paramClassLoader instanceof PathClassLoader)) {}
      for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class)
      {
        a(paramContext, paramClassLoader, (Class)localObject, paramString1, paramString2, paramBoolean);
        return true;
      }
    }
    if (!b()) {
      if ((paramClassLoader instanceof PathClassLoader))
      {
        localObject = PathClassLoader.class;
        b(paramContext, paramClassLoader, (Class)localObject, paramString1, paramString2, paramBoolean);
      }
    }
    for (;;)
    {
      return true;
      localObject = DexClassLoader.class;
      break;
      a(paramContext, paramClassLoader, paramString1, paramString2, paramBoolean);
    }
  }
  
  private static Object b(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object b(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = paramObject1.getClass().getComponentType();
    int k = Array.getLength(paramObject1);
    int j = k + 1;
    localObject = Array.newInstance((Class)localObject, j);
    if (paramBoolean)
    {
      Array.set(localObject, 0, paramObject2);
      i = 1;
      while (i < j)
      {
        Array.set(localObject, i, Array.get(paramObject1, i - 1));
        i += 1;
      }
    }
    if (i < j)
    {
      if (i < k) {
        Array.set(localObject, i, Array.get(paramObject1, i));
      }
      for (;;)
      {
        i += 1;
        break;
        Array.set(localObject, i, paramObject2);
      }
    }
    return localObject;
  }
  
  @SuppressLint({"NewApi"})
  private static String b(ClassLoader paramClassLoader, int paramInt)
  {
    try
    {
      Object localObject = a(b(a(paramClassLoader)), paramInt);
      paramClassLoader = a(paramClassLoader);
      a(paramClassLoader, paramClassLoader.getClass(), "dexElements", localObject);
      return "Success";
    }
    catch (Throwable paramClassLoader) {}
    return "unloadDexAboveEqualApiLevel14 error: " + Log.getStackTraceString(null);
  }
  
  @TargetApi(14)
  private static String b(ClassLoader paramClassLoader, Class paramClass, int paramInt)
  {
    try
    {
      if ((paramClassLoader instanceof PathClassLoader)) {
        a(paramClassLoader, paramClass, "mPaths", a(a(paramClassLoader, paramClass, "mPaths"), paramInt));
      }
      a(paramClassLoader, PathClassLoader.class, "mFiles", a(a(paramClassLoader, paramClass, "mFiles"), paramInt));
      a(paramClassLoader, PathClassLoader.class, "mZips", a(a(paramClassLoader, paramClass, "mZips"), paramInt));
      a(paramClassLoader, PathClassLoader.class, "mDexs", a(a(paramClassLoader, paramClass, "mDexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return "unloadDexBelowApiLevel14 error: " + Log.getStackTraceString(paramClassLoader);
  }
  
  private static void b(Context paramContext, ClassLoader paramClassLoader, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramContext.getClassLoader());
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.loadClass(paramString2);
    }
    if ((paramClassLoader instanceof PathClassLoader)) {
      a(paramClassLoader, paramClass, "mPaths", b(a(paramClassLoader, paramClass, "mPaths"), a(paramContext, DexClassLoader.class, "mRawDexPath"), paramBoolean));
    }
    a(paramClassLoader, paramClass, "mFiles", a(a(paramClassLoader, paramClass, "mFiles"), a(paramContext, DexClassLoader.class, "mFiles"), paramBoolean));
    a(paramClassLoader, paramClass, "mZips", a(a(paramClassLoader, paramClass, "mZips"), a(paramContext, DexClassLoader.class, "mZips"), paramBoolean));
    a(paramClassLoader, paramClass, "mDexs", a(a(paramClassLoader, paramClass, "mDexs"), a(paramContext, DexClassLoader.class, "mDexs"), paramBoolean));
    if (!TextUtils.isEmpty(paramString2)) {
      paramClassLoader.loadClass(paramString2);
    }
  }
  
  private static boolean b()
  {
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbb
 * JD-Core Version:    0.7.0.1
 */