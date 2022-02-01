package com.tencent.luan.ioc.reflect;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.ioc.InjectAnalysisService;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.ProvideMethod;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.annotation.Provide;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ReflectInjectAnalysisService
  implements InjectAnalysisService
{
  private static final String TAG = "ReflectInjectAnalysisSe";
  private final ClassLoader loader;
  private volatile boolean valid = true;
  
  public ReflectInjectAnalysisService(ClassLoader paramClassLoader)
  {
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    this.loader = localClassLoader;
  }
  
  private InjectParam getInjectParam(Class<?> paramClass, String paramString, Named paramNamed)
  {
    String str = getNamedValue(paramNamed);
    if (str.isEmpty()) {
      if (paramString.isEmpty()) {
        paramNamed = paramClass;
      }
    }
    for (;;)
    {
      return new InjectParam(paramNamed, str);
      paramNamed = loadClass(paramString);
      continue;
      paramNamed = paramClass;
      if (paramString.length() > 0)
      {
        LuanLog.w("ReflectInjectAnalysisSe", "getInjectParam: annotated type " + paramString + " with @Named(" + str + "), is Anything wrong? And this type will be ignored.");
        paramNamed = paramClass;
      }
    }
  }
  
  private static String getNamedValue(Named paramNamed)
  {
    String str = null;
    if (paramNamed != null) {
      str = paramNamed.value();
    }
    paramNamed = str;
    if (str == null) {
      paramNamed = "";
    }
    return paramNamed;
  }
  
  public ReflectInjectConstructor<?> getInjectConstructor(Class<?> paramClass)
  {
    Object localObject2 = "";
    Constructor[] arrayOfConstructor = paramClass.getConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    Object localObject1 = null;
    if (i < j)
    {
      localObject3 = arrayOfConstructor[i];
      Inject localInject = (Inject)((Constructor)localObject3).getAnnotation(Inject.class);
      if (localInject == null)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        i += 1;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        if (localObject1 != null) {
          throw new InjectException("there are more than one inject constructors in this type: " + paramClass.getName());
        }
        localObject1 = localInject.type();
        localObject2 = localObject3;
      }
    }
    Object localObject3 = localObject1;
    if (localObject1 == null) {}
    Object localObject4;
    try
    {
      localObject3 = paramClass.getConstructor(new Class[0]);
      if (!InjectChecker.isValidInjectConstructor((Constructor)localObject3)) {
        throw new InjectException("inject constructor must be public and with one or no param " + paramClass.getName());
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        LuanLog.e("ReflectInjectAnalysisSe", "getInjectConstructor: none injected constructor and failed to get empty constructor in " + paramClass.getName(), localNoSuchMethodException);
        localObject4 = localObject1;
      }
      localObject1 = (Named)localObject4.getAnnotation(Named.class);
      if (localObject4.getParameterTypes().length != 0) {
        break label343;
      }
    }
    if (((String)localObject2).length() > 0) {
      LuanLog.w("ReflectInjectAnalysisSe", "getInjectConstructor: inject has a type name on an empty constructor of " + paramClass.getName() + ", is Anything wrong? And this type will be ignored " + (String)localObject2);
    }
    if (localObject1 != null)
    {
      LuanLog.w("ReflectInjectAnalysisSe", "getInjectConstructor: inject has been named on an empty constructor of " + ((Named)localObject1).value() + ", is Anything wrong? And this name will be ignored");
      paramClass = null;
    }
    for (;;)
    {
      return new ReflectInjectConstructor(localObject4, paramClass);
      label343:
      paramClass = getInjectParam(localObject4.getParameterTypes()[0], (String)localObject2, (Named)localObject1);
      continue;
      paramClass = null;
    }
  }
  
  public List<InjectMethod> getInjectMethods(Class<?> paramClass)
  {
    paramClass = paramClass.getMethods();
    LinkedList localLinkedList = new LinkedList();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = paramClass[i];
      Inject localInject = (Inject)localMethod.getAnnotation(Inject.class);
      if (localInject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (!InjectChecker.isValidInjectMethod(localMethod)) {
          throw new InjectException("inject method must be public and with one param " + localMethod.getDeclaringClass().getName() + "#" + localMethod.getName());
        }
        Named localNamed = (Named)localMethod.getAnnotation(Named.class);
        localLinkedList.add(new ReflectInjectMethod(localMethod, getInjectParam(localMethod.getParameterTypes()[0], localInject.type(), localNamed)));
      }
    }
    return Collections.unmodifiableList(localLinkedList);
  }
  
  public ClassLoader getLoader()
  {
    return this.loader;
  }
  
  public List<ProvideMethod<?>> getProvideMethods(Class<?> paramClass)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int k = arrayOfMethod.length;
    int i = 0;
    Method localMethod;
    Provide localProvide;
    InjectParam localInjectParam;
    while (i < k)
    {
      localMethod = arrayOfMethod[i];
      localProvide = (Provide)localMethod.getAnnotation(Provide.class);
      if (localProvide == null)
      {
        i += 1;
      }
      else
      {
        if (!InjectChecker.isValidProvideMethod(localMethod)) {
          throw new InjectException("provide method must be static public and with none param " + localMethod.getDeclaringClass().getName() + "#" + localMethod.getName());
        }
        localInjectParam = getInjectParam(localMethod.getReturnType(), localProvide.type(), (Named)localMethod.getAnnotation(Named.class));
        if (localInjectParam.name.isEmpty())
        {
          if (!localHashSet1.add(localInjectParam.type)) {
            throw new InjectException("duplicate provide method for type " + localInjectParam.type.getName() + " in " + paramClass.getName());
          }
        }
        else if (!localHashSet2.add(localInjectParam.name)) {
          throw new InjectException("duplicate provide method for name " + localInjectParam.name + " in " + paramClass.getName());
        }
        if (localMethod.getParameterTypes().length != 1) {
          break label408;
        }
        Annotation[] arrayOfAnnotation = localMethod.getParameterAnnotations()[0];
        localObject = null;
        int m = arrayOfAnnotation.length;
        int j = 0;
        while (j < m)
        {
          Annotation localAnnotation = arrayOfAnnotation[j];
          if (!(localAnnotation instanceof Named)) {
            break label405;
          }
          localObject = (Named)localAnnotation;
          label345:
          j += 1;
        }
      }
    }
    label405:
    label408:
    for (Object localObject = getInjectParam(localMethod.getParameterTypes()[0], localProvide.inputType(), (Named)localObject);; localObject = null)
    {
      localLinkedList.add(new ReflectProvideMethod(paramClass, localMethod, localInjectParam, (InjectParam)localObject));
      break;
      return Collections.unmodifiableList(localLinkedList);
      break label345;
    }
  }
  
  public boolean isValid()
  {
    return this.valid;
  }
  
  Class<?> loadClass(String paramString)
  {
    try
    {
      Class localClass = this.loader.loadClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new InjectException("failed to load injected class " + paramString, localClassNotFoundException);
    }
  }
  
  public void setValid(boolean paramBoolean)
  {
    this.valid = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService
 * JD-Core Version:    0.7.0.1
 */