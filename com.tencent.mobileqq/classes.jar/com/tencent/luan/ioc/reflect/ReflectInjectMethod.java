package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import java.lang.reflect.Method;

class ReflectInjectMethod
  implements InjectMethod
{
  private final Method method;
  private final InjectParam param;
  
  ReflectInjectMethod(Method paramMethod, InjectParam paramInjectParam)
  {
    paramMethod.setAccessible(true);
    this.method = paramMethod;
    this.param = paramInjectParam;
  }
  
  public void invoke(Object paramObject, Injector paramInjector)
  {
    if (this.param.name.isEmpty()) {
      paramInjector = paramInjector.getOrCreateObject(this.param.type);
    } else {
      paramInjector = paramInjector.getOrCreateObject(this.param.name);
    }
    try
    {
      this.method.invoke(paramObject, new Object[] { paramInjector });
      return;
    }
    catch (Exception paramObject)
    {
      paramInjector = new StringBuilder();
      paramInjector.append("failed to invoke inject method ");
      paramInjector.append(this.method.getDeclaringClass().getName());
      paramInjector.append("#");
      paramInjector.append(this.method.getName());
      throw new InjectException(paramInjector.toString(), paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectInjectMethod
 * JD-Core Version:    0.7.0.1
 */