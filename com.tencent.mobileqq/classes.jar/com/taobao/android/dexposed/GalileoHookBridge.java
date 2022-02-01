package com.taobao.android.dexposed;

import com.tencent.qa.apphook.GalileoBackupMethod;
import com.tencent.qa.apphook.GalileoHookLog;
import com.tencent.qa.apphook.GalileoHookNative;
import com.tencent.qa.apphook.util.BasicType;
import com.tencent.qa.apphook.util.BasicTypeMethodUtil;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GalileoHookBridge
{
  public static void galileoHook(ClassLoader paramClassLoader, List<GalileoBackupMethod> paramList, ConcurrentHashMap<String, GalileoBackupMethod> paramConcurrentHashMap)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      GalileoBackupMethod localGalileoBackupMethod = (GalileoBackupMethod)localIterator.next();
      Member localMember = localGalileoBackupMethod.getOriginMethod();
      paramList = localMember.getDeclaringClass().getName().replace(".", "_");
      GalileoHookLog.d("Hook Bridge galileoHook name is " + paramList);
      Object localObject = paramClassLoader.loadClass(paramList);
      GalileoHookLog.d("Hook Bridge galileoHook clazz is " + localObject);
      ((Class)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (!GalileoHookNative.setMadeClassSuper((Class)localObject)) {
        throw new FileNotFoundException("found error!");
      }
      if ((localMember instanceof Method)) {
        paramList = ((Class)localObject).getDeclaredMethod(localMember.getName(), ((Method)localMember).getParameterTypes());
      }
      for (localObject = ((Class)localObject).getDeclaredMethod(localMember.getName() + "_Invoker", ((Method)localMember).getParameterTypes()); (paramList == null) || (localObject == null); localObject = ((Class)localObject).getDeclaredMethod("init_Invoker", ((Constructor)localMember).getParameterTypes()))
      {
        throw new NullPointerException("hookedMember is null");
        paramList = ((Class)localObject).getDeclaredConstructor(((Constructor)localMember).getParameterTypes());
      }
      localGalileoBackupMethod.setInvoker((Method)localObject);
      if ((localMember instanceof Method))
      {
        localObject = getMethodSignature((Method)localMember).replace(".", "/");
        GalileoHookNative.initMethod(localMember.getDeclaringClass(), localMember.getName(), (String)localObject, Modifier.isStatic(localMember.getModifiers()));
      }
      for (;;)
      {
        localGalileoBackupMethod.setNewMethod(paramList);
        GalileoHookNative.replaceMethodArt(localGalileoBackupMethod);
        paramList = GalileoHookHelper.getSignName(paramList);
        GalileoHookLog.d("GalileoHookManager startArtHook sigName is " + paramList);
        paramConcurrentHashMap.put(paramList, localGalileoBackupMethod);
        break;
        localObject = getConstructorSignature((Constructor)localMember).replace(".", "/");
        GalileoHookNative.initMethod(localMember.getDeclaringClass(), "<init>", (String)localObject, Modifier.isStatic(localMember.getModifiers()));
      }
    }
  }
  
  static String getConstructorSignature(Constructor paramConstructor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(getSignature(paramConstructor[i]));
      i += 1;
    }
    localStringBuilder.append(")V");
    return localStringBuilder.toString();
  }
  
  static String getMethodSignature(Method paramMethod)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(getSignature(arrayOfClass[i]));
      i += 1;
    }
    localStringBuilder.append(')');
    localStringBuilder.append(getSignature(paramMethod.getReturnType()));
    return localStringBuilder.toString();
  }
  
  public static String getSignature(Class<?> paramClass)
  {
    BasicType localBasicType = BasicTypeMethodUtil.getBasicTypeIfIs(paramClass);
    if (localBasicType != null) {
      return localBasicType.getTypeDesc();
    }
    if (paramClass.isArray()) {
      return "[" + getSignature(paramClass.getComponentType());
    }
    return "L" + paramClass.getName() + ";";
  }
  
  public static Object invoke(Member paramMember, XC_MethodHook paramXC_MethodHook, Object paramObject, Object[] paramArrayOfObject)
  {
    XC_MethodHook.MethodHookParam localMethodHookParam;
    if ((paramMember instanceof Method))
    {
      ((Method)paramMember).setAccessible(true);
      localMethodHookParam = new XC_MethodHook.MethodHookParam();
      localMethodHookParam.method = paramMember;
      localMethodHookParam.thisObject = paramObject;
      localMethodHookParam.args = paramArrayOfObject;
      if (paramXC_MethodHook == null) {
        break label71;
      }
    }
    for (;;)
    {
      if (localMethodHookParam.getThrowable() == null) {
        break label80;
      }
      throw localMethodHookParam.getThrowable();
      ((Constructor)paramMember).setAccessible(true);
      break;
      label71:
      localMethodHookParam.setResult(null);
    }
    label80:
    if (GalileoHookNative.isArt())
    {
      localMethodHookParam.setResult(((Method)paramMember).invoke(paramObject, paramArrayOfObject));
      if (paramXC_MethodHook == null) {}
    }
    while (localMethodHookParam.getThrowable() != null)
    {
      throw localMethodHookParam.getThrowable();
      GalileoHookLog.e("do not support dalvik");
    }
    return localMethodHookParam.getResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.GalileoHookBridge
 * JD-Core Version:    0.7.0.1
 */