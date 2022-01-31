package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.AbstractInjectConstructor;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import java.lang.reflect.Constructor;

class ReflectInjectConstructor<T>
  extends AbstractInjectConstructor<T>
{
  private final Constructor<T> constructor;
  private final InjectParam param;
  
  ReflectInjectConstructor(Constructor<T> paramConstructor, InjectParam paramInjectParam)
  {
    super(paramConstructor.getDeclaringClass(), InjectChecker.checkAndGetScope(paramConstructor.getDeclaringClass()));
    paramConstructor.setAccessible(true);
    this.constructor = paramConstructor;
    this.param = paramInjectParam;
  }
  
  public T newInstance(Injector paramInjector)
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.param == null) {
        return this.constructor.newInstance(new Object[0]);
      }
      if (this.param.name.isEmpty()) {
        return this.constructor.newInstance(new Object[] { paramInjector.getOrCreateObject(this.param.type) });
      }
      paramInjector = this.constructor.newInstance(new Object[] { paramInjector.getOrCreateObject(this.param.name) });
      return paramInjector;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder().append("failed to create ").append(this.constructor.getDeclaringClass().getName()).append(" instance by inject constructor ");
      if (this.param != null) {}
    }
    for (paramInjector = "none param";; paramInjector = "param " + this.param.type.getName() + " name " + this.param.name) {
      throw new InjectException(paramInjector, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.reflect.ReflectInjectConstructor
 * JD-Core Version:    0.7.0.1
 */