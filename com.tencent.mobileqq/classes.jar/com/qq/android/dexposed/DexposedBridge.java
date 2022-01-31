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
        EMPTY_ARRAY = new Object[0];
        BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
        hookedMethodCallbacks = new HashMap();
        allUnhookCallbacks = new ArrayList();
        return;
      }
      throw new RuntimeException("unsupported api level: " + Build.VERSION.SDK_INT);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        log(localThrowable);
      }
    }
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String arg1, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
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
  
  /* Error */
  public static Object handleHookedArtMethod(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 118	me/weishu/epic/art/method/ArtMethod
    //   4: astore 7
    //   6: getstatic 53	com/qq/android/dexposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   9: astore_0
    //   10: aload_0
    //   11: monitorenter
    //   12: getstatic 53	com/qq/android/dexposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   15: aload 7
    //   17: invokevirtual 122	me/weishu/epic/art/method/ArtMethod:getExecutable	()Ljava/lang/Object;
    //   20: invokeinterface 128 2 0
    //   25: checkcast 130	com/qq/android/dexposed/DexposedBridge$CopyOnWriteSortedSet
    //   28: astore 6
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 6
    //   34: invokevirtual 133	com/qq/android/dexposed/DexposedBridge$CopyOnWriteSortedSet:getSnapshot	()[Ljava/lang/Object;
    //   37: astore_0
    //   38: aload_0
    //   39: arraylength
    //   40: istore 5
    //   42: iload 5
    //   44: ifne +33 -> 77
    //   47: aload 7
    //   49: invokestatic 139	me/weishu/epic/art/Epic:getBackMethod	(Lme/weishu/epic/art/method/ArtMethod;)Lme/weishu/epic/art/method/ArtMethod;
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 143	me/weishu/epic/art/method/ArtMethod:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore 6
    //   59: aload 6
    //   61: areturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 147	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   74: invokestatic 79	com/qq/android/dexposed/DexposedBridge:log	(Ljava/lang/Throwable;)V
    //   77: new 149	com/qq/android/dexposed/XC_MethodHook$MethodHookParam
    //   80: dup
    //   81: invokespecial 150	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:<init>	()V
    //   84: astore 6
    //   86: aload 6
    //   88: aload 7
    //   90: invokevirtual 122	me/weishu/epic/art/method/ArtMethod:getExecutable	()Ljava/lang/Object;
    //   93: checkcast 152	java/lang/reflect/Member
    //   96: putfield 156	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:method	Ljava/lang/reflect/Member;
    //   99: aload 6
    //   101: aload_1
    //   102: putfield 160	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   105: aload 6
    //   107: aload_2
    //   108: putfield 163	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   111: iconst_0
    //   112: istore_3
    //   113: aload_0
    //   114: iload_3
    //   115: aaload
    //   116: checkcast 87	com/qq/android/dexposed/XC_MethodHook
    //   119: aload 6
    //   121: invokevirtual 167	com/qq/android/dexposed/XC_MethodHook:beforeHookedMethod	(Lcom/qq/android/dexposed/XC_MethodHook$MethodHookParam;)V
    //   124: aload 6
    //   126: getfield 171	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   129: ifeq +138 -> 267
    //   132: iload_3
    //   133: iconst_1
    //   134: iadd
    //   135: istore_3
    //   136: aload 6
    //   138: getfield 171	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   141: ifne +18 -> 159
    //   144: aload 6
    //   146: aload 7
    //   148: invokestatic 139	me/weishu/epic/art/Epic:getBackMethod	(Lme/weishu/epic/art/method/ArtMethod;)Lme/weishu/epic/art/method/ArtMethod;
    //   151: aload_1
    //   152: aload_2
    //   153: invokevirtual 143	me/weishu/epic/art/method/ArtMethod:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   156: invokevirtual 175	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   159: iload_3
    //   160: iconst_1
    //   161: isub
    //   162: istore_3
    //   163: aload 6
    //   165: invokevirtual 178	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   168: astore_1
    //   169: aload 6
    //   171: invokevirtual 181	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   174: astore_2
    //   175: aload_0
    //   176: iload_3
    //   177: aaload
    //   178: checkcast 87	com/qq/android/dexposed/XC_MethodHook
    //   181: aload 6
    //   183: invokevirtual 184	com/qq/android/dexposed/XC_MethodHook:afterHookedMethod	(Lcom/qq/android/dexposed/XC_MethodHook$MethodHookParam;)V
    //   186: iload_3
    //   187: iconst_1
    //   188: isub
    //   189: istore_3
    //   190: iload_3
    //   191: ifge +152 -> 343
    //   194: aload 6
    //   196: invokevirtual 188	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:hasThrowable	()Z
    //   199: ifeq +138 -> 337
    //   202: aload 6
    //   204: invokevirtual 181	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   207: astore_0
    //   208: aload_0
    //   209: instanceof 190
    //   212: ifne +17 -> 229
    //   215: aload_0
    //   216: instanceof 192
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: instanceof 194
    //   226: ifeq +101 -> 327
    //   229: aload_0
    //   230: invokevirtual 195	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   233: pop
    //   234: aload 6
    //   236: invokevirtual 181	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   239: invokevirtual 195	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   242: aconst_null
    //   243: invokestatic 199	com/qq/android/dexposed/DexposedBridge:throwNoCheck	(Ljava/lang/Throwable;Ljava/lang/Object;)V
    //   246: aconst_null
    //   247: areturn
    //   248: astore 8
    //   250: aload 8
    //   252: invokestatic 79	com/qq/android/dexposed/DexposedBridge:log	(Ljava/lang/Throwable;)V
    //   255: aload 6
    //   257: aconst_null
    //   258: invokevirtual 175	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   261: aload 6
    //   263: iconst_0
    //   264: putfield 171	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   267: iload_3
    //   268: iconst_1
    //   269: iadd
    //   270: istore 4
    //   272: iload 4
    //   274: istore_3
    //   275: iload 4
    //   277: iload 5
    //   279: if_icmpge -143 -> 136
    //   282: iload 4
    //   284: istore_3
    //   285: goto -172 -> 113
    //   288: astore_1
    //   289: aload 6
    //   291: aload_1
    //   292: invokevirtual 202	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   295: goto -136 -> 159
    //   298: astore 7
    //   300: aload 7
    //   302: invokestatic 79	com/qq/android/dexposed/DexposedBridge:log	(Ljava/lang/Throwable;)V
    //   305: aload_2
    //   306: ifnonnull +12 -> 318
    //   309: aload 6
    //   311: aload_1
    //   312: invokevirtual 175	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   315: goto -129 -> 186
    //   318: aload 6
    //   320: aload_2
    //   321: invokevirtual 202	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   324: goto -138 -> 186
    //   327: ldc 12
    //   329: ldc 204
    //   331: aload_0
    //   332: invokestatic 210	com/qq/android/dexposed/utility/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   335: aconst_null
    //   336: areturn
    //   337: aload 6
    //   339: invokevirtual 178	com/qq/android/dexposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   342: areturn
    //   343: goto -180 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramObject1	Object
    //   0	346	1	paramObject2	Object
    //   0	346	2	paramArrayOfObject	Object[]
    //   112	173	3	i	int
    //   270	13	4	j	int
    //   40	240	5	k	int
    //   28	32	6	localObject	Object
    //   67	3	6	localException	java.lang.Exception
    //   84	254	6	localMethodHookParam	XC_MethodHook.MethodHookParam
    //   4	143	7	localArtMethod	ArtMethod
    //   298	3	7	localThrowable1	Throwable
    //   248	3	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	32	62	finally
    //   63	65	62	finally
    //   47	59	67	java/lang/Exception
    //   113	124	248	java/lang/Throwable
    //   144	159	288	java/lang/Exception
    //   175	186	298	java/lang/Throwable
  }
  
  private static Object handleHookedMethod(Member paramMember, int paramInt, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    DexposedBridge.AdditionalHookInfo localAdditionalHookInfo = (DexposedBridge.AdditionalHookInfo)paramObject1;
    paramObject1 = localAdditionalHookInfo.callbacks.getSnapshot();
    int j = paramObject1.length;
    if (j == 0) {
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
    label280:
    for (;;)
    {
      try
      {
        ((XC_MethodHook)paramObject1[i]).beforeHookedMethod(localMethodHookParam);
        if (!localMethodHookParam.returnEarly) {
          continue;
        }
        i += 1;
      }
      catch (Throwable paramMember)
      {
        try
        {
          localMethodHookParam.setResult(invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, localMethodHookParam.thisObject, localMethodHookParam.args));
          paramInt = i - 1;
          paramMember = localMethodHookParam.getResult();
          paramObject2 = localMethodHookParam.getThrowable();
        }
        catch (InvocationTargetException paramMember)
        {
          try
          {
            ((XC_MethodHook)paramObject1[paramInt]).afterHookedMethod(localMethodHookParam);
            paramInt -= 1;
            if (paramInt >= 0) {
              continue;
            }
            if (localMethodHookParam.hasThrowable())
            {
              throw localMethodHookParam.getThrowable();
              paramObject2 = paramObject2;
              log(paramObject2);
              localMethodHookParam.setResult(null);
              localMethodHookParam.returnEarly = false;
              i += 1;
              if (i < j) {
                break label280;
              }
              continue;
              paramMember = paramMember;
              localMethodHookParam.setThrowable(paramMember.getCause());
            }
          }
          catch (Throwable paramArrayOfObject)
          {
            log(paramArrayOfObject);
            if (paramObject2 == null)
            {
              localMethodHookParam.setResult(paramMember);
              continue;
            }
            localMethodHookParam.setThrowable(paramObject2);
            continue;
          }
        }
        return localMethodHookParam.getResult();
        continue;
      }
      if (localMethodHookParam.returnEarly) {}
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
    if ((!(paramMember instanceof Method)) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("only methods and constructors can be hooked");
    }
    boolean bool = false;
    for (;;)
    {
      synchronized (hookedMethodCallbacks)
      {
        DexposedBridge.CopyOnWriteSortedSet localCopyOnWriteSortedSet2 = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(paramMember);
        DexposedBridge.CopyOnWriteSortedSet localCopyOnWriteSortedSet1 = localCopyOnWriteSortedSet2;
        if (localCopyOnWriteSortedSet2 == null)
        {
          localCopyOnWriteSortedSet1 = new DexposedBridge.CopyOnWriteSortedSet();
          hookedMethodCallbacks.put(paramMember, localCopyOnWriteSortedSet1);
          bool = true;
        }
        Logger.w("DexposedBridge", "hook: " + paramMember + ", newMethod ? " + bool);
        localCopyOnWriteSortedSet1.add(paramXC_MethodHook);
        if (bool)
        {
          if (!Runtime.isArt()) {
            break;
          }
          if ((paramMember instanceof Method)) {
            Epic.hookMethod((Method)paramMember);
          }
        }
        else
        {
          paramXC_MethodHook.getClass();
          return new XC_MethodHook.Unhook(paramXC_MethodHook, paramMember);
        }
      }
      Epic.hookMethod((Constructor)paramMember);
    }
    throw new RuntimeException("unsurport dalvik");
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  public static Object invokeOriginalMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      paramArrayOfObject = EMPTY_ARRAY;
    }
    for (;;)
    {
      Class[] arrayOfClass;
      Class localClass;
      if ((paramMember instanceof Method))
      {
        arrayOfClass = ((Method)paramMember).getParameterTypes();
        localClass = ((Method)paramMember).getReturnType();
        if (!Runtime.isArt()) {
          break label121;
        }
        if (!(paramMember instanceof Method)) {
          break label101;
        }
      }
      for (Object localObject = ArtMethod.of((Method)paramMember);; localObject = ArtMethod.of((Constructor)paramMember))
      {
        try
        {
          localObject = Epic.getBackMethod((ArtMethod)localObject).invoke(paramObject, paramArrayOfObject);
          return localObject;
        }
        catch (InstantiationException localInstantiationException)
        {
          label101:
          throwNoCheck(localInstantiationException, null);
        }
        if ((paramMember instanceof Constructor))
        {
          arrayOfClass = ((Constructor)paramMember).getParameterTypes();
          localClass = null;
          break;
        }
        throw new IllegalArgumentException("method must be of type Method or Constructor");
      }
      label121:
      return invokeOriginalMethodNative(paramMember, 0, arrayOfClass, localClass, paramObject, paramArrayOfObject);
    }
  }
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
  
  public static Object invokeSuper(Object paramObject, Member paramMember, Object... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!Runtime.isArt()) {
        i = XposedHelpers.getIntField(XposedHelpers.findMethodExact(paramObject.getClass().getSuperclass(), paramMember.getName(), ((Method)paramMember).getParameterTypes()), "slot");
      }
      paramObject = invokeSuperNative(paramObject, paramVarArgs, paramMember, paramMember.getDeclaringClass(), ((Method)paramMember).getParameterTypes(), ((Method)paramMember).getReturnType(), i);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
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
  
  /* Error */
  public static void unhookAllMethods()
  {
    // Byte code:
    //   0: getstatic 58	com/qq/android/dexposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_0
    //   8: iload_0
    //   9: getstatic 58	com/qq/android/dexposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   12: invokevirtual 382	java/util/ArrayList:size	()I
    //   15: if_icmplt +12 -> 27
    //   18: getstatic 58	com/qq/android/dexposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   21: invokevirtual 385	java/util/ArrayList:clear	()V
    //   24: aload_1
    //   25: monitorexit
    //   26: return
    //   27: getstatic 58	com/qq/android/dexposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   30: iload_0
    //   31: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 304	com/qq/android/dexposed/XC_MethodHook$Unhook
    //   37: invokevirtual 391	com/qq/android/dexposed/XC_MethodHook$Unhook:unhook	()V
    //   40: iload_0
    //   41: iconst_1
    //   42: iadd
    //   43: istore_0
    //   44: goto -36 -> 8
    //   47: astore_2
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	37	0	i	int
    //   3	46	1	localArrayList	ArrayList
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	26	47	finally
    //   27	40	47	finally
    //   48	50	47	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.DexposedBridge
 * JD-Core Version:    0.7.0.1
 */