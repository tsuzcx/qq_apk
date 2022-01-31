package com.tencent.luan.ioc;

class LuanInjector$ProvideMethodKey
{
  private final String name;
  private final Class<?> provider;
  private final Class<?> type;
  
  private LuanInjector$ProvideMethodKey(ProvideMethod paramProvideMethod)
  {
    this.provider = paramProvideMethod.provider();
    paramProvideMethod = paramProvideMethod.provideParam();
    this.name = paramProvideMethod.name;
    this.type = paramProvideMethod.type;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (ProvideMethodKey)paramObject;
        bool1 = bool2;
      } while (!this.provider.equals(paramObject.provider));
      bool1 = bool2;
    } while (!this.name.equals(paramObject.name));
    return this.type.equals(paramObject.type);
  }
  
  public int hashCode()
  {
    return (this.provider.hashCode() * 31 + this.name.hashCode()) * 31 + this.type.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.ProvideMethodKey
 * JD-Core Version:    0.7.0.1
 */