package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.AbstractProvideMethod;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import java.lang.reflect.Method;

class ReflectProvideMethod<T>
  extends AbstractProvideMethod<T>
{
  private final InjectParam argParam;
  private final Method method;
  
  ReflectProvideMethod(Class<?> paramClass, Method paramMethod, InjectParam paramInjectParam1, InjectParam paramInjectParam2)
  {
    super(paramClass, paramInjectParam1, InjectChecker.checkAndGetScope(paramMethod));
    paramMethod.setAccessible(true);
    this.method = paramMethod;
    this.argParam = paramInjectParam2;
  }
  
  public T newInstance(Injector paramInjector)
  {
    try
    {
      if (this.argParam == null) {
        return this.method.invoke(null, new Object[0]);
      }
      if (this.argParam.name.isEmpty()) {
        paramInjector = paramInjector.getOrCreateObject(this.argParam.type);
      } else {
        paramInjector = paramInjector.getOrCreateObject(this.argParam.name);
      }
      paramInjector = this.method.invoke(null, new Object[] { paramInjector });
      return paramInjector;
    }
    catch (Exception paramInjector)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to invoke provide method ");
      localStringBuilder.append(this.method.getDeclaringClass().getName());
      localStringBuilder.append("#");
      localStringBuilder.append(this.method.getName());
      throw new InjectException(localStringBuilder.toString(), paramInjector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectProvideMethod
 * JD-Core Version:    0.7.0.1
 */