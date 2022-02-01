package com.tencent.luan.ioc;

public abstract class AbstractProvideMethod<T>
  extends AbstractInjectConstructor<T>
  implements ProvideMethod<T>
{
  private final InjectParam provideParam;
  
  protected AbstractProvideMethod(Class<?> paramClass, InjectParam paramInjectParam, int paramInt)
  {
    super(paramInt, localStringBuilder.toString());
    this.provideParam = paramInjectParam;
  }
  
  public boolean needInject()
  {
    return false;
  }
  
  public InjectParam provideParam()
  {
    return this.provideParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.AbstractProvideMethod
 * JD-Core Version:    0.7.0.1
 */