package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ra.b;

public abstract class e
  extends b
{
  public void a()
  {
    super.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(" [ENTERING]");
    o.d("MicroMsg.LoggerState", localStringBuilder.toString());
  }
  
  public void b()
  {
    super.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(" [EXITING]");
    o.d("MicroMsg.LoggerState", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.e
 * JD-Core Version:    0.7.0.1
 */