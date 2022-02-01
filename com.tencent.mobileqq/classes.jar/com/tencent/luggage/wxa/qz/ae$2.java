package com.tencent.luggage.wxa.qz;

import com.tencent.luggage.wxa.rz.c.f;

class ae$2
  implements c.f
{
  ae$2(ae paramae) {}
  
  public void a(Thread paramThread, String paramString, long paramLong)
  {
    paramThread = new StringBuilder();
    paramThread.append("[onInterrupt] name=");
    paramThread.append(paramString);
    paramThread.append(" id=");
    paramThread.append(paramLong);
    o.d("Luggage.ThreadBootDelegate", paramThread.toString());
  }
  
  public void b(Thread paramThread, String paramString, long paramLong)
  {
    paramThread = new StringBuilder();
    paramThread.append("[onThreadStart] name=");
    paramThread.append(paramString);
    paramThread.append(" id=");
    paramThread.append(paramLong);
    o.d("Luggage.ThreadBootDelegate", paramThread.toString());
  }
  
  public void c(Thread paramThread, String paramString, long paramLong)
  {
    paramThread = new StringBuilder();
    paramThread.append("[onThreadExit] name=");
    paramThread.append(paramString);
    paramThread.append(" id=");
    paramThread.append(paramLong);
    o.d("Luggage.ThreadBootDelegate", paramThread.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ae.2
 * JD-Core Version:    0.7.0.1
 */