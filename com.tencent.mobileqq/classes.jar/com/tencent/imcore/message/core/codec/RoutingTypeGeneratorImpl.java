package com.tencent.imcore.message.core.codec;

import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;

public class RoutingTypeGeneratorImpl
  implements RoutingTypeGenerator
{
  private MapClassGenerator<Integer, RoutingType> a = new MapClassGeneratorImpl();
  
  public RoutingType a(Integer paramInteger)
  {
    return (RoutingType)this.a.a(paramInteger);
  }
  
  public void a(Integer paramInteger, Class<? extends RoutingType> paramClass)
  {
    this.a.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.RoutingTypeGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */