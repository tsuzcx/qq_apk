package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import java.util.List;

public class MessageDecoderGeneratorImpl
  implements MessageDecoderGenerator
{
  private ClassGenerator<IMessageDecoder> a = new ClassGeneratorImpl();
  
  public List<IMessageDecoder> a()
  {
    return this.a.a();
  }
  
  public void a(Class<? extends IMessageDecoder> paramClass)
  {
    this.a.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.MessageDecoderGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */