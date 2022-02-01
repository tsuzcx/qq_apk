package com.tencent.imcore.message.core;

import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;

public class CreateMessageRecordCallbackGeneratorImpl
  implements CreateMessageRecordCallbackGenerator
{
  private MapClassGenerator<Integer, CreateMessageRecordCallback> a = new MapClassGeneratorImpl();
  
  public CreateMessageRecordCallback a(Integer paramInteger)
  {
    return (CreateMessageRecordCallback)this.a.a(paramInteger);
  }
  
  public void a(Integer paramInteger, Class<? extends CreateMessageRecordCallback> paramClass)
  {
    this.a.a(paramInteger, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.core.CreateMessageRecordCallbackGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */