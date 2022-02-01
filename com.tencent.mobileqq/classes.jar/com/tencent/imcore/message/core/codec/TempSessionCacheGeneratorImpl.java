package com.tencent.imcore.message.core.codec;

import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;

public class TempSessionCacheGeneratorImpl
  implements TempSessionCacheGenerator
{
  private MapClassGenerator<Integer, TempSessionCache> a = new MapClassGeneratorImpl();
  
  public TempSessionCache a(Integer paramInteger)
  {
    return (TempSessionCache)this.a.a(paramInteger);
  }
  
  public void a(Integer paramInteger, Class<? extends TempSessionCache> paramClass)
  {
    this.a.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.TempSessionCacheGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */