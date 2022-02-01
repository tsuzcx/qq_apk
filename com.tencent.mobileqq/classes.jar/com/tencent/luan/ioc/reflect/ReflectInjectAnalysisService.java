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
    if (str.isEmpty())
    {
      if (paramString.isEmpty()) {
        paramNamed = paramClass;
      } else {
        paramNamed = loadClass(paramString);
      }
    }
    else
    {
      paramNamed = paramClass;
      if (paramString.length() > 0)
      {
        paramNamed = new StringBuilder();
        paramNamed.append("getInjectParam: annotated type ");
        paramNamed.append(paramString);
        paramNamed.append(" with @Named(");
        paramNamed.append(str);
        paramNamed.append("), is Anything wrong? And this type will be ignored.");
        LuanLog.w("ReflectInjectAnalysisSe", paramNamed.toString());
        paramNamed = paramClass;
      }
    }
    return new InjectParam(paramNamed, str);
  }
  
  private static String getNamedValue(Named paramNamed)
  {
    if (paramNamed != null) {
      paramNamed = paramNamed.value();
    } else {
      paramNamed = null;
    }
    Object localObject = paramNamed;
    if (paramNamed == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public ReflectInjectConstructor<?> getInjectConstructor(Class<?> paramClass)
  {
    Object localObject5 = paramClass.getConstructors();
    int j = localObject5.length;
    Object localObject4 = null;
    Object localObject1 = null;
    String str = "";
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject5[i];
      Inject localInject = (Inject)((Constructor)localObject2).getAnnotation(Inject.class);
      if (localInject != null)
      {
        if (localObject1 == null)
        {
          str = localInject.type();
          localObject1 = localObject2;
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("there are more than one inject constructors in this type: ");
      ((StringBuilder)localObject1).append(paramClass.getName());
      throw new InjectException(((StringBuilder)localObject1).toString());
    }
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null) {
      try
      {
        localObject2 = paramClass.getConstructor(new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("getInjectConstructor: none injected constructor and failed to get empty constructor in ");
        ((StringBuilder)localObject5).append(paramClass.getName());
        LuanLog.e("ReflectInjectAnalysisSe", ((StringBuilder)localObject5).toString(), localNoSuchMethodException);
        localObject3 = localObject1;
      }
    }
    if (InjectChecker.isValidInjectConstructor(localObject3))
    {
      localObject1 = (Named)localObject3.getAnnotation(Named.class);
      if (localObject3.getParameterTypes().length == 0)
      {
        if (str.length() > 0)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("getInjectConstructor: inject has a type name on an empty constructor of ");
          ((StringBuilder)localObject5).append(paramClass.getName());
          ((StringBuilder)localObject5).append(", is Anything wrong? And this type will be ignored ");
          ((StringBuilder)localObject5).append(str);
          LuanLog.w("ReflectInjectAnalysisSe", ((StringBuilder)localObject5).toString());
        }
        paramClass = localObject4;
        if (localObject1 != null)
        {
          paramClass = new StringBuilder();
          paramClass.append("getInjectConstructor: inject has been named on an empty constructor of ");
          paramClass.append(((Named)localObject1).value());
          paramClass.append(", is Anything wrong? And this name will be ignored");
          LuanLog.w("ReflectInjectAnalysisSe", paramClass.toString());
          paramClass = localObject4;
        }
      }
      else
      {
        paramClass = getInjectParam(localObject3.getParameterTypes()[0], str, (Named)localObject1);
      }
      return new ReflectInjectConstructor(localObject3, paramClass);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("inject constructor must be public and with one or no param ");
    ((StringBuilder)localObject1).append(paramClass.getName());
    paramClass = new InjectException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public List<InjectMethod> getInjectMethods(Class<?> paramClass)
  {
    Object localObject = paramClass.getMethods();
    LinkedList localLinkedList = new LinkedList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramClass = localObject[i];
      Inject localInject = (Inject)paramClass.getAnnotation(Inject.class);
      if (localInject != null)
      {
        if (InjectChecker.isValidInjectMethod(paramClass))
        {
          Named localNamed = (Named)paramClass.getAnnotation(Named.class);
          localLinkedList.add(new ReflectInjectMethod(paramClass, getInjectParam(paramClass.getParameterTypes()[0], localInject.type(), localNamed)));
        }
      }
      else
      {
        i += 1;
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("inject method must be public and with one param ");
      ((StringBuilder)localObject).append(paramClass.getDeclaringClass().getName());
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramClass.getName());
      throw new InjectException(((StringBuilder)localObject).toString());
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
    while (i < k)
    {
      Method localMethod = arrayOfMethod[i];
      Provide localProvide = (Provide)localMethod.getAnnotation(Provide.class);
      InjectParam localInjectParam;
      if (localProvide != null)
      {
        if (!InjectChecker.isValidProvideMethod(localMethod)) {
          break label395;
        }
        localInjectParam = getInjectParam(localMethod.getReturnType(), localProvide.type(), (Named)localMethod.getAnnotation(Named.class));
        if (localInjectParam.name.isEmpty())
        {
          if (!localHashSet1.add(localInjectParam.type))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("duplicate provide method for type ");
            ((StringBuilder)localObject).append(localInjectParam.type.getName());
            ((StringBuilder)localObject).append(" in ");
            ((StringBuilder)localObject).append(paramClass.getName());
            throw new InjectException(((StringBuilder)localObject).toString());
          }
        }
        else {
          if (!localHashSet2.add(localInjectParam.name)) {
            break label336;
          }
        }
        int j = localMethod.getParameterTypes().length;
        localObject = null;
        if (j == 1)
        {
          Annotation[] arrayOfAnnotation = localMethod.getParameterAnnotations()[0];
          int m = arrayOfAnnotation.length;
          localObject = null;
          j = 0;
          while (j < m)
          {
            Annotation localAnnotation = arrayOfAnnotation[j];
            if ((localAnnotation instanceof Named)) {
              localObject = (Named)localAnnotation;
            }
            j += 1;
          }
          localObject = getInjectParam(localMethod.getParameterTypes()[0], localProvide.inputType(), (Named)localObject);
        }
        localLinkedList.add(new ReflectProvideMethod(paramClass, localMethod, localInjectParam, (InjectParam)localObject));
      }
      else
      {
        i += 1;
        continue;
      }
      label336:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("duplicate provide method for name ");
      ((StringBuilder)localObject).append(localInjectParam.name);
      ((StringBuilder)localObject).append(" in ");
      ((StringBuilder)localObject).append(paramClass.getName());
      throw new InjectException(((StringBuilder)localObject).toString());
      label395:
      paramClass = new StringBuilder();
      paramClass.append("provide method must be static public and with none param ");
      paramClass.append(localMethod.getDeclaringClass().getName());
      paramClass.append("#");
      paramClass.append(localMethod.getName());
      throw new InjectException(paramClass.toString());
    }
    return Collections.unmodifiableList(localLinkedList);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to load injected class ");
      localStringBuilder.append(paramString);
      throw new InjectException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  public void setValid(boolean paramBoolean)
  {
    this.valid = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService
 * JD-Core Version:    0.7.0.1
 */