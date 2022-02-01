package com.tencent.mobileqq.app.generalflag;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import java.util.List;

public class GeneralFlagProviderGeneratorImpl
  implements GeneralFlagProviderGenerator
{
  private ClassGenerator<IGeneralFlagProvider> a = new ClassGeneratorImpl();
  
  public List<IGeneralFlagProvider> a()
  {
    return this.a.a();
  }
  
  public void a(Class<? extends IGeneralFlagProvider> paramClass)
  {
    this.a.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */