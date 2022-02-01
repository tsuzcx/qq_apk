package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class SystemClassLoaderInjector
{
  public static Object a(Object paramObject)
  {
    return a(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static Object a(Object paramObject, int paramInt)
  {
    Object localObject = paramObject.getClass().getComponentType();
    int m = Array.getLength(paramObject);
    if (paramInt >= 0)
    {
      if (paramInt >= m) {
        return paramObject;
      }
      localObject = Array.newInstance((Class)localObject, m - 1);
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (i != paramInt)
        {
          Array.set(localObject, j, Array.get(paramObject, i));
          k = j + 1;
        }
        i += 1;
      }
      return localObject;
    }
    return paramObject;
  }
  
  private static Object a(Object paramObject, Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    Object localObject1 = paramObject1.getClass().getComponentType();
    int k = Array.getLength(paramObject1);
    int j = Array.getLength(paramObject2);
    int i;
    if (paramBoolean) {
      i = k;
    } else {
      i = j;
    }
    if (paramBoolean) {
      k = j;
    }
    k += i;
    Object localObject2 = Array.newInstance((Class)localObject1, k);
    j = 0;
    while (j < k)
    {
      if (j < i)
      {
        if (paramBoolean) {
          localObject1 = paramObject1;
        } else {
          localObject1 = paramObject2;
        }
        Array.set(localObject2, j, Array.get(localObject1, j));
      }
      else
      {
        if (paramBoolean) {
          localObject1 = paramObject2;
        } else {
          localObject1 = paramObject1;
        }
        Array.set(localObject2, j, Array.get(localObject1, j - i));
      }
      j += 1;
    }
    return localObject2;
  }
  
  public static String a(Application paramApplication, int paramInt)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramInt);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      label14:
      int i;
      label25:
      break label14;
    }
    i = 1;
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label25;
    }
    i = 0;
    if (i == 0) {
      return c(paramApplication, paramInt);
    }
    return d(paramApplication, paramInt);
  }
  
  public static String a(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramString1, paramString2, paramBoolean);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      label18:
      int i;
      label30:
      break label18;
    }
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      i = 1;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label30;
    }
    i = 0;
    if (i == 0) {
      return c(paramApplication, paramString1, paramString2, paramBoolean);
    }
    return b(paramApplication, paramString1, paramString2, paramBoolean, true);
  }
  
  public static String a(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramString1, paramString2, paramBoolean1);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      label18:
      int i;
      label30:
      break label18;
    }
    i = 1;
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label30;
    }
    i = 0;
    if (i == 0) {
      return c(paramApplication, paramString1, paramString2, paramBoolean1);
    }
    return b(paramApplication, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  @RequiresApi(api=26)
  public static String a(Application paramApplication, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      paramApplication = new InMemoryDexClassLoader(paramByteBuffer, paramApplication.getClassLoader());
      QLog.d("SystemClassLoaderInjector", 1, "InMemoryDexClassLoader load done");
      if (!TextUtils.isEmpty(paramString))
      {
        QLog.e("SystemClassLoaderInjector", 1, "InMemoryDexClassLoader start test");
        paramApplication.loadClass(paramString);
        QLog.d("SystemClassLoaderInjector", 1, "InMemoryDexClassLoader test suc!");
      }
      paramApplication = a(b(a(localPathClassLoader)), b(a(paramApplication)), paramBoolean);
      paramByteBuffer = a(localPathClassLoader);
      a(paramByteBuffer, paramByteBuffer.getClass(), "dexElements", paramApplication);
      QLog.d("SystemClassLoaderInjector", 1, "InMemoryDexClassLoader combine pathList done!");
      paramApplication = new StringBuilder();
      paramApplication.append("[注入完成调用] injectByInMemoryDexClassLoader classLoader:");
      paramApplication.append(localPathClassLoader);
      QLog.e("SystemClassLoaderInjector", 1, paramApplication.toString());
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      QLog.e("SystemClassLoaderInjector", 1, "err", paramApplication);
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("injectByInMemoryDexClassLoader error: ");
      paramByteBuffer.append(Log.getStackTraceString(paramApplication));
    }
    return paramByteBuffer.toString();
  }
  
  private static void a(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public static Object b(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object b(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    Object localObject1 = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int i;
    if (paramBoolean) {
      i = j;
    } else {
      i = 1;
    }
    if (paramBoolean) {
      j = 1;
    }
    int k = j + i;
    Object localObject2 = Array.newInstance((Class)localObject1, k);
    j = 0;
    while (j < k)
    {
      if (j < i)
      {
        if (paramBoolean) {
          localObject1 = Array.get(paramObject1, j);
        } else {
          localObject1 = paramObject2;
        }
        Array.set(localObject2, j, localObject1);
      }
      else
      {
        if (paramBoolean) {
          localObject1 = paramObject2;
        } else {
          localObject1 = Array.get(paramObject1, j - i);
        }
        Array.set(localObject2, j, localObject1);
      }
      j += 1;
    }
    return localObject2;
  }
  
  private static String b(Application paramApplication, int paramInt)
  {
    paramApplication = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      a(paramApplication, PathClassLoader.class, "mPaths", a(a(paramApplication, PathClassLoader.class, "mPaths"), paramInt));
      a(paramApplication, PathClassLoader.class, "mFiles", a(a(paramApplication, PathClassLoader.class, "mFiles"), paramInt));
      a(paramApplication, PathClassLoader.class, "mZips", a(a(paramApplication, PathClassLoader.class, "mZips"), paramInt));
      a(paramApplication, PathClassLoader.class, "mLexs", a(a(paramApplication, PathClassLoader.class, "mLexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unloadDexInAliyunOs error: ");
      localStringBuilder.append(Log.getStackTraceString(paramApplication));
      return localStringBuilder.toString();
    }
  }
  
  private static String b(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    try
    {
      Class localClass = Class.forName("dalvik.system.LexClassLoader");
      Constructor localConstructor = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramApplication.getDir("dex", 0).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      paramApplication = localConstructor.newInstance(new Object[] { localStringBuilder.toString(), paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader });
      paramString1 = localClass.getMethod("loadClass", new Class[] { String.class });
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.invoke(paramApplication, new Object[] { paramString2 });
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, localClass, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, localClass, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, localClass, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mLexs", a(a(localPathClassLoader, PathClassLoader.class, "mLexs"), a(paramApplication, localClass, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
      paramString1 = new StringBuilder();
      paramString1.append("injectInAliyunOs error: ");
      paramString1.append(Log.getStackTraceString(paramApplication));
    }
    return paramString1.toString();
  }
  
  @SuppressLint({"NewApi"})
  private static String b(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    if (paramBoolean2)
    {
      paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    }
    else
    {
      paramApplication = new SystemClassLoaderInjector.SpeedyDexClassLoader(paramString1, null, paramString1, paramApplication.getClassLoader());
      Log.i("loadInternal ", "use SpeedyDexClassLoader");
    }
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramApplication.loadClass(paramString2);
      }
      paramApplication = a(b(a(localPathClassLoader)), b(a(paramApplication)), paramBoolean1);
      paramString1 = a(localPathClassLoader);
      a(paramString1, paramString1.getClass(), "dexElements", paramApplication);
      paramApplication = new StringBuilder();
      paramApplication.append("[注入完成调用] injectAboveEqualApiLevel14 classLoader:");
      paramApplication.append(localPathClassLoader);
      QLog.e("SystemClassLoaderInjector", 1, paramApplication.toString());
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      QLog.e("harlan", 1, "err", paramApplication);
      paramString1 = new StringBuilder();
      paramString1.append("injectAboveEqualApiLevel14 error: ");
      paramString1.append(Log.getStackTraceString(paramApplication));
    }
    return paramString1.toString();
  }
  
  @TargetApi(14)
  private static String c(Application paramApplication, int paramInt)
  {
    paramApplication = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      a(paramApplication, PathClassLoader.class, "mPaths", a(a(paramApplication, PathClassLoader.class, "mPaths"), paramInt));
      a(paramApplication, PathClassLoader.class, "mFiles", a(a(paramApplication, PathClassLoader.class, "mFiles"), paramInt));
      a(paramApplication, PathClassLoader.class, "mZips", a(a(paramApplication, PathClassLoader.class, "mZips"), paramInt));
      a(paramApplication, PathClassLoader.class, "mDexs", a(a(paramApplication, PathClassLoader.class, "mDexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unloadDexBelowApiLevel14 error: ");
      localStringBuilder.append(Log.getStackTraceString(paramApplication));
      return localStringBuilder.toString();
    }
  }
  
  @TargetApi(14)
  private static String c(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    try
    {
      if (Build.VERSION.SDK_INT <= 8)
      {
        paramString1 = paramApplication.getClass().getDeclaredMethod("ensureInit", new Class[0]);
        paramString1.setAccessible(true);
        paramString1.invoke(paramApplication, new Object[0]);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramApplication.loadClass(paramString2);
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, DexClassLoader.class, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, DexClassLoader.class, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, DexClassLoader.class, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mDexs", a(a(localPathClassLoader, PathClassLoader.class, "mDexs"), a(paramApplication, DexClassLoader.class, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
      paramString1 = new StringBuilder();
      paramString1.append("injectBelowApiLevel14 error: ");
      paramString1.append(Log.getStackTraceString(paramApplication));
    }
    return paramString1.toString();
  }
  
  @SuppressLint({"NewApi"})
  private static String d(Application paramApplication, int paramInt)
  {
    Object localObject = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      paramApplication = a(b(a(localObject)), paramInt);
      localObject = a(localObject);
      a(localObject, localObject.getClass(), "dexElements", paramApplication);
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unloadDexAboveEqualApiLevel14 error: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramApplication));
    }
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SystemClassLoaderInjector
 * JD-Core Version:    0.7.0.1
 */