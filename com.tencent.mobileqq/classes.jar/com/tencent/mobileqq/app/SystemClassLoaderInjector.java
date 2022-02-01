package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
  
  public static Object a(Object paramObject1, Object paramObject2, boolean paramBoolean)
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
  
  public static Object a(Object paramObject, List<File> paramList, File paramFile, ClassLoader paramClassLoader)
  {
    paramObject = paramObject.getClass().getDeclaredMethod("makeDexElements", new Class[] { List.class, File.class, List.class, ClassLoader.class });
    paramObject.setAccessible(true);
    return paramObject.invoke(null, new Object[] { paramList, paramFile, new ArrayList(), paramClassLoader });
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramContext, paramInt);
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
      return c(paramContext, paramInt);
    }
    return d(paramContext, paramInt);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramContext, paramString1, paramString3, paramBoolean);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      label19:
      int i;
      label31:
      break label19;
    }
    i = 1;
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label31;
    }
    i = 0;
    if (i == 0) {
      return c(paramContext, paramString1, paramString3, paramBoolean);
    }
    if (Build.VERSION.SDK_INT >= 30) {
      return b(paramContext, paramString1, paramString2, paramString3, paramBoolean, true);
    }
    return a(paramContext, paramString1, paramString2, paramString3, paramBoolean, true);
  }
  
  @SuppressLint({"NewApi"})
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramContext.getClassLoader();
    if (paramBoolean2)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = paramContext.getDir("dex", 0).getAbsolutePath();
      }
      paramContext = DexClassLoaderUtil.createDexClassLoader(paramString1, str, paramString1, paramContext.getClassLoader());
    }
    else
    {
      paramContext = new SystemClassLoaderInjector.SpeedyDexClassLoader(paramString1, null, paramString1, paramContext.getClassLoader());
      Log.i("loadInternal ", "use SpeedyDexClassLoader");
    }
    try
    {
      if (!TextUtils.isEmpty(paramString3)) {
        paramContext.loadClass(paramString3);
      }
      paramContext = a(b(a(localPathClassLoader)), b(a(paramContext)), paramBoolean1);
      paramString1 = a(localPathClassLoader);
      a(paramString1, paramString1.getClass(), "dexElements", paramContext);
      paramContext = new StringBuilder();
      paramContext.append("[注入完成调用] injectAboveEqualApiLevel14 classLoader:");
      paramContext.append(localPathClassLoader);
      Log.e("SystemLoaderInjector", paramContext.toString());
      return "Success";
    }
    catch (Throwable paramContext)
    {
      Log.e("SystemLoaderInjector", "err", paramContext);
      paramString1 = new StringBuilder();
      paramString1.append("injectAboveEqualApiLevel14 error: ");
      paramString1.append(Log.getStackTraceString(paramContext));
    }
    return paramString1.toString();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramContext, paramString1, null, paramString2, paramBoolean);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramContext, paramString1, paramString2, paramBoolean1);
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
      return c(paramContext, paramString1, paramString2, paramBoolean1);
    }
    if (Build.VERSION.SDK_INT >= 30) {
      return b(paramContext, paramString1, null, paramString2, paramBoolean1, paramBoolean2);
    }
    return b(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void a(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
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
  
  private static String b(Context paramContext, int paramInt)
  {
    paramContext = (PathClassLoader)paramContext.getClassLoader();
    try
    {
      a(paramContext, PathClassLoader.class, "mPaths", a(a(paramContext, PathClassLoader.class, "mPaths"), paramInt));
      a(paramContext, PathClassLoader.class, "mFiles", a(a(paramContext, PathClassLoader.class, "mFiles"), paramInt));
      a(paramContext, PathClassLoader.class, "mZips", a(a(paramContext, PathClassLoader.class, "mZips"), paramInt));
      a(paramContext, PathClassLoader.class, "mLexs", a(a(paramContext, PathClassLoader.class, "mLexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unloadDexInAliyunOs error: ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      return localStringBuilder.toString();
    }
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramContext.getClassLoader();
    if (paramBoolean2)
    {
      if (paramString2 == null) {
        paramContext = paramContext.getDir("dex", 0);
      } else {
        paramContext = new File(paramString2);
      }
    }
    else {
      paramContext = null;
    }
    try
    {
      paramString2 = a(localPathClassLoader);
      paramContext = a(b(a(localPathClassLoader)), a(paramString2, Collections.singletonList(new File(paramString1)), paramContext, localPathClassLoader), paramBoolean1);
      a(paramString2, paramString2.getClass(), "dexElements", paramContext);
      if (!TextUtils.isEmpty(paramString3)) {
        localPathClassLoader.loadClass(paramString3);
      }
      paramContext = new StringBuilder();
      paramContext.append("[注入完成调用] injectForR classLoader:");
      paramContext.append(localPathClassLoader);
      Log.e("SystemLoaderInjector", paramContext.toString());
      return "Success";
    }
    catch (Throwable paramContext)
    {
      Log.e("SystemLoaderInjector", "err", paramContext);
      paramString1 = new StringBuilder();
      paramString1.append("injectForR error: ");
      paramString1.append(Log.getStackTraceString(paramContext));
    }
    return paramString1.toString();
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramContext.getClassLoader();
    new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    try
    {
      Class localClass = Class.forName("dalvik.system.LexClassLoader");
      Constructor localConstructor = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getDir("dex", 0).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      paramContext = localConstructor.newInstance(new Object[] { localStringBuilder.toString(), paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader });
      paramString1 = localClass.getMethod("loadClass", new Class[] { String.class });
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.invoke(paramContext, new Object[] { paramString2 });
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramContext, localClass, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramContext, localClass, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramContext, localClass, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mLexs", a(a(localPathClassLoader, PathClassLoader.class, "mLexs"), a(paramContext, localClass, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramString1 = new StringBuilder();
      paramString1.append("injectInAliyunOs error: ");
      paramString1.append(Log.getStackTraceString(paramContext));
    }
    return paramString1.toString();
  }
  
  @SuppressLint({"NewApi"})
  private static String b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, paramString1, null, paramString2, paramBoolean1, paramBoolean2);
  }
  
  @TargetApi(14)
  private static String c(Context paramContext, int paramInt)
  {
    paramContext = (PathClassLoader)paramContext.getClassLoader();
    try
    {
      a(paramContext, PathClassLoader.class, "mPaths", a(a(paramContext, PathClassLoader.class, "mPaths"), paramInt));
      a(paramContext, PathClassLoader.class, "mFiles", a(a(paramContext, PathClassLoader.class, "mFiles"), paramInt));
      a(paramContext, PathClassLoader.class, "mZips", a(a(paramContext, PathClassLoader.class, "mZips"), paramInt));
      a(paramContext, PathClassLoader.class, "mDexs", a(a(paramContext, PathClassLoader.class, "mDexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unloadDexBelowApiLevel14 error: ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      return localStringBuilder.toString();
    }
  }
  
  @TargetApi(14)
  private static String c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramContext.getClassLoader();
    paramContext = DexClassLoaderUtil.createDexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramContext.getClassLoader());
    try
    {
      if (Build.VERSION.SDK_INT <= 8)
      {
        paramString1 = paramContext.getClass().getDeclaredMethod("ensureInit", new Class[0]);
        paramString1.setAccessible(true);
        paramString1.invoke(paramContext, new Object[0]);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.loadClass(paramString2);
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramContext, DexClassLoader.class, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramContext, DexClassLoader.class, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramContext, DexClassLoader.class, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mDexs", a(a(localPathClassLoader, PathClassLoader.class, "mDexs"), a(paramContext, DexClassLoader.class, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramString1 = new StringBuilder();
      paramString1.append("injectBelowApiLevel14 error: ");
      paramString1.append(Log.getStackTraceString(paramContext));
    }
    return paramString1.toString();
  }
  
  @SuppressLint({"NewApi"})
  private static String d(Context paramContext, int paramInt)
  {
    Object localObject = (PathClassLoader)paramContext.getClassLoader();
    try
    {
      paramContext = a(b(a(localObject)), paramInt);
      localObject = a(localObject);
      a(localObject, localObject.getClass(), "dexElements", paramContext);
      return "Success";
    }
    catch (Throwable paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unloadDexAboveEqualApiLevel14 error: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
    }
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SystemClassLoaderInjector
 * JD-Core Version:    0.7.0.1
 */