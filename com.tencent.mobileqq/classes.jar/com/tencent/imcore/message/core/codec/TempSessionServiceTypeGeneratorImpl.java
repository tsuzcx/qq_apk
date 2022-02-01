package com.tencent.imcore.message.core.codec;

import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;

public class TempSessionServiceTypeGeneratorImpl
  implements TempSessionServiceTypeGenerator
{
  private MapClassGenerator<Integer, TempSessionServiceType> a = new MapClassGeneratorImpl();
  
  public TempSessionServiceType a(Integer paramInteger)
  {
    return (TempSessionServiceType)this.a.a(paramInteger);
  }
  
  public void a(Integer paramInteger, Class<? extends TempSessionServiceType> paramClass)
  {
    this.a.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.TempSessionServiceTypeGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */