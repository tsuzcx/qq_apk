package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.imcore.message.basic.ClassGenerator;
import com.tencent.imcore.message.basic.ClassGeneratorImpl;
import java.util.List;

public class PbSendReqHandlerGeneratorImpl
  implements PbSendReqHandlerGenerator
{
  private ClassGenerator<IPbSendReqHandler> a = new ClassGeneratorImpl();
  
  public List<IPbSendReqHandler> a()
  {
    return this.a.a();
  }
  
  public void a(Class<? extends IPbSendReqHandler> paramClass)
  {
    this.a.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */