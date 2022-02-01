package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import java.util.List;

public class MsgBoxAppenderGeneratorImpl
  implements MsgBoxAppenderGenerator
{
  private ClassGenerator<IMsgBoxAppender> a = new ClassGeneratorImpl();
  
  public List<IMsgBoxAppender> a()
  {
    return this.a.a();
  }
  
  public void a(Class<? extends IMsgBoxAppender> paramClass)
  {
    this.a.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgboxappender.MsgBoxAppenderGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */