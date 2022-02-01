package com.qq.android.dexposed;

import android.os.Build.VERSION;
import android.util.Log;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.Runtime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.method.ArtMethod;

public final class DexposedBridge
{
  public static final ClassLoader BOOTCLASSLOADER;
  private static final Object[] EMPTY_ARRAY;
  private static final String TAG = "DexposedBridge";
  private static final ArrayList<XC_MethodHook.Unhook> allUnhookCallbacks;
  private static final Map<Member, DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook>> hookedMethodCallbacks;
  
  static
  {
    try
    {
      if ((Build.VERSION.SDK_INT > 19) && (Build.VERSION.SDK_INT <= 27))
      {
        System.loadLibrary("qqjhook");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder("unsupported api level: ");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    catch (Throwable localThrowable)
    {
      log(localThrowable);
      EMPTY_ARRAY = new Object[0];
      BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
      hookedMethodCallbacks = new HashMap();
      allUnhookCallbacks = new ArrayList();
    }
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String arg1, Object... paramVarArgs)
  {
    if ((paramVarArgs.length != 0) && ((paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook)))
    {
      XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
      paramClass = hookMethod(XposedHelpers.findMethodExact(paramClass, ???, paramVarArgs), localXC_MethodHook);
      if ((!(localXC_MethodHook instanceof XC_MethodHook.XC_MethodKeepHook)) && (!(localXC_MethodHook instanceof XC_MethodReplacement.XC_MethodKeepReplacement))) {
        synchronized (allUnhookCallbacks)
        {
          allUnhookCallbacks.add(paramClass);
          return paramClass;
        }
      }
      return paramClass;
    }
    throw new IllegalArgumentException("no callback defined");
  }
  
  public static Object handleHookedArtMethod(Object arg0, Object paramObject2, Object[] paramArrayOfObject)
  {
    ArtMethod localArtMethod = (ArtMethod)???;
    synchronized (hookedMethodCallbacks)
    {
      Object localObject = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(localArtMethod.getExecutable());
      ??? = ((DexposedBridge.CopyOnWriteSortedSet)localObject).getSnapshot();
      int k = ???.length;
      if (k == 0) {
        try
        {
          localObject = Epic.getBackMethod(localArtMethod).invoke(paramObject2, paramArrayOfObject);
          return localObject;
        }
        catch (Exception localException)
        {
          log(localException.getCause());
        }
      }
      XC_MethodHook.MethodHookParam localMethodHookParam = new XC_MethodHook.MethodHookParam();
      localMethodHookParam.method = ((Member)localArtMethod.getExecutable());
      localMethodHookParam.thisObject = paramObject2;
      localMethodHookParam.args = paramArrayOfObject;
      int i = 0;
      int j;
      do
      {
        try
        {
          ((XC_MethodHook)???[i]).beforeHookedMethod(localMethodHookParam);
          if (localMethodHookParam.returnEarly) {
            j = i + 1;
          }
        }
        catch (Throwable localThrowable2)
        {
          log(localThrowable2);
          localMethodHookParam.setResult(null);
          localMethodHookParam.returnEarly = false;
          j = i + 1;
          i = j;
        }
      } while (j < k);
      if (!localMethodHookParam.returnEarly) {
        try
        {
          localMethodHookParam.setResult(Epic.getBackMethod(localArtMethod).invoke(paramObject2, paramArrayOfObject));
        }
        catch (Exception paramObject2)
        {
          localMethodHookParam.setThrowable(paramObject2);
        }
      }
      i = j - 1;
      do
      {
        paramObject2 = localMethodHookParam.getResult();
        paramArrayOfObject = localMethodHookParam.getThrowable();
        try
        {
          ((XC_MethodHook)???[i]).afterHookedMethod(localMethodHookParam);
        }
        catch (Throwable localThrowable1)
        {
          log(localThrowable1);
          if (paramArrayOfObject == null) {
            localMethodHookParam.setResult(paramObject2);
          } else {
            localMethodHookParam.setThrowable(paramArrayOfObject);
          }
        }
        j = i - 1;
        i = j;
      } while (j >= 0);
      if (localMethodHookParam.hasThrowable())
      {
        ??? = localMethodHookParam.getThrowable();
        if ((!(??? instanceof IllegalAccessException)) && (!(??? instanceof InvocationTargetException)) && (!(??? instanceof InstantiationException)))
        {
          Logger.e("DexposedBridge", "epic cause exception in call bridge!!", ???);
          return null;
        }
        ???.getCause();
        throwNoCheck(localMethodHookParam.getThrowable().getCause(), null);
        return null;
      }
      return localMethodHookParam.getResult();
    }
    for (;;)
    {
      throw paramObject2;
    }
  }
  
  private static Object handleHookedMethod(Member paramMember, int paramInt, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    DexposedBridge.AdditionalHookInfo localAdditionalHookInfo = (DexposedBridge.AdditionalHookInfo)paramObject1;
    paramObject1 = localAdditionalHookInfo.callbacks.getSnapshot();
    int k = paramObject1.length;
    if (k == 0) {
      try
      {
        paramMember = invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, paramObject2, paramArrayOfObject);
        return paramMember;
      }
      catch (InvocationTargetException paramMember)
      {
        throw paramMember.getCause();
      }
    }
    XC_MethodHook.MethodHookParam localMethodHookParam = new XC_MethodHook.MethodHookParam();
    localMethodHookParam.method = paramMember;
    localMethodHookParam.thisObject = paramObject2;
    localMethodHookParam.args = paramArrayOfObject;
    int i = 0;
    int j;
    do
    {
      try
      {
        ((XC_MethodHook)paramObject1[i]).beforeHookedMethod(localMethodHookParam);
        if (localMethodHookParam.returnEarly) {
          j = i + 1;
        }
      }
      catch (Throwable paramObject2)
      {
        log(paramObject2);
        localMethodHookParam.setResult(null);
        localMethodHookParam.returnEarly = false;
        j = i + 1;
        i = j;
      }
    } while (j < k);
    if (!localMethodHookParam.returnEarly) {
      try
      {
        localMethodHookParam.setResult(invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, localMethodHookParam.thisObject, localMethodHookParam.args));
      }
      catch (InvocationTargetException paramMember)
      {
        localMethodHookParam.setThrowable(paramMember.getCause());
      }
    }
    paramInt = j - 1;
    do
    {
      paramMember = localMethodHookParam.getResult();
      paramObject2 = localMethodHookParam.getThrowable();
      try
      {
        ((XC_MethodHook)paramObject1[paramInt]).afterHookedMethod(localMethodHookParam);
      }
      catch (Throwable paramArrayOfObject)
      {
        log(paramArrayOfObject);
        if (paramObject2 == null) {
          localMethodHookParam.setResult(paramMember);
        } else {
          localMethodHookParam.setThrowable(paramObject2);
        }
      }
      i = paramInt - 1;
      paramInt = i;
    } while (i >= 0);
    if (!localMethodHookParam.hasThrowable()) {
      return localMethodHookParam.getResult();
    }
    paramMember = localMethodHookParam.getThrowable();
    for (;;)
    {
      throw paramMember;
    }
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> paramClass, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localHashSet;
      }
      localHashSet.add(hookMethod(paramClass[i], paramXC_MethodHook));
      i += 1;
    }
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> paramClass, String paramString, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localHashSet;
      }
      Member localMember = paramClass[i];
      if (localMember.getName().equals(paramString)) {
        localHashSet.add(hookMethod(localMember, paramXC_MethodHook));
      }
      i += 1;
    }
  }
  
  public static XC_MethodHook.Unhook hookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    boolean bool2 = paramMember instanceof Method;
    if ((!bool2) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("only methods and constructors can be hooked");
    }
    boolean bool1 = false;
    synchronized (hookedMethodCallbacks)
    {
      Object localObject2 = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(paramMember);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new DexposedBridge.CopyOnWriteSortedSet();
        hookedMethodCallbacks.put(paramMember, localObject1);
        bool1 = true;
      }
      localObject2 = new StringBuilder("hook: ");
      ((StringBuilder)localObject2).append(paramMember);
      ((StringBuilder)localObject2).append(", newMethod ? ");
      ((StringBuilder)localObject2).append(bool1);
      Logger.w("DexposedBridge", ((StringBuilder)localObject2).toString());
      ((DexposedBridge.CopyOnWriteSortedSet)localObject1).add(paramXC_MethodHook);
      if (bool1) {
        if (Runtime.isArt())
        {
          if (bool2) {
            Epic.hookMethod((Method)paramMember);
          } else {
            Epic.hookMethod((Constructor)paramMember);
          }
        }
        else {
          throw new RuntimeException("unsurport dalvik");
        }
      }
      paramXC_MethodHook.getClass();
      return new XC_MethodHook.Unhook(paramXC_MethodHook, paramMember);
    }
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  public static Object invokeOriginalMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = EMPTY_ARRAY;
    }
    boolean bool = paramMember instanceof Method;
    Object localObject1;
    if (bool)
    {
      localObject1 = (Method)paramMember;
      paramArrayOfObject = ((Method)localObject1).getParameterTypes();
      localObject1 = ((Method)localObject1).getReturnType();
    }
    else
    {
      if (!(paramMember instanceof Constructor)) {
        break label128;
      }
      paramArrayOfObject = ((Constructor)paramMember).getParameterTypes();
      localObject1 = null;
    }
    if (Runtime.isArt())
    {
      Object localObject2;
      if (bool) {
        localObject2 = ArtMethod.of((Method)paramMember);
      } else {
        localObject2 = ArtMethod.of((Constructor)paramMember);
      }
      try
      {
        localObject2 = Epic.getBackMethod((ArtMethod)localObject2).invoke(paramObject, arrayOfObject);
        return localObject2;
      }
      catch (InstantiationException localInstantiationException)
      {
        throwNoCheck(localInstantiationException, null);
      }
    }
    return invokeOriginalMethodNative(paramMember, 0, paramArrayOfObject, (Class)localObject1, paramObject, arrayOfObject);
    label128:
    throw new IllegalArgumentException("method must be of type Method or Constructor");
  }
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
  
  public static Object invokeSuper(Object paramObject, Member paramMember, Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if (!Runtime.isArt())
        {
          i = XposedHelpers.getIntField(XposedHelpers.findMethodExact(paramObject.getClass().getSuperclass(), paramMember.getName(), ((Method)paramMember).getParameterTypes()), "slot");
          paramObject = invokeSuperNative(paramObject, paramVarArgs, paramMember, paramMember.getDeclaringClass(), ((Method)paramMember).getParameterTypes(), ((Method)paramMember).getReturnType(), i);
          return paramObject;
        }
      }
      catch (InvocationTargetException paramObject)
      {
        throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
      }
      catch (IllegalArgumentException paramObject)
      {
        throw paramObject;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new IllegalAccessError(paramObject.getMessage());
      }
      int i = 0;
    }
  }
  
  private static native Object invokeSuperNative(Object paramObject, Object[] paramArrayOfObject, Member paramMember, Class<?> paramClass1, Class<?>[] paramArrayOfClass, Class<?> paramClass2, int paramInt);
  
  public static void log(String paramString)
  {
    try
    {
      Log.i("DexposedBridge", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void log(Throwable paramThrowable)
  {
    try
    {
      log(Log.getStackTraceString(paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private static <T extends Throwable> void throwNoCheck(Throwable paramThrowable, Object paramObject)
  {
    throw paramThrowable;
  }
  
  public static void unhookAllMethods()
  {
    ArrayList localArrayList = allUnhookCallbacks;
    int i = 0;
    try
    {
      for (;;)
      {
        if (i >= allUnhookCallbacks.size())
        {
          allUnhookCallbacks.clear();
          return;
        }
        ((XC_MethodHook.Unhook)allUnhookCallbacks.get(i)).unhook();
        i += 1;
      }
      throw localObject;
    }
    finally {}
    for (;;) {}
  }
  
  public static void unhookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    synchronized (hookedMethodCallbacks)
    {
      paramMember = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(paramMember);
      if (paramMember == null) {
        return;
      }
      paramMember.remove(paramXC_MethodHook);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.DexposedBridge
 * JD-Core Version:    0.7.0.1
 */