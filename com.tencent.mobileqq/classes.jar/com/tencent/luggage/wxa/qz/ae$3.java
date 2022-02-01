package com.tencent.luggage.wxa.qz;

import com.tencent.luggage.wxa.rz.c.e;
import com.tencent.luggage.wxa.rz.d;

class ae$3
  implements c.e
{
  ae$3(ae paramae) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[wait] ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("@");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" runningCount=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" waitFor=");
    localStringBuilder.append(paramLong / 100000L);
    localStringBuilder.append("ms pool=");
    localStringBuilder.append(paramString2);
    o.c("Luggage.ThreadBootDelegate", localStringBuilder.toString());
  }
  
  public void a(String paramString1, int paramInt, d paramd, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramd == d.d)
    {
      paramString2 = new StringBuilder();
      paramString2.append("====== ");
      paramString2.append(paramString1);
      paramString2.append("@");
      paramString2.append(paramInt);
      paramString2.append(" state=");
      paramString2.append(paramd);
      paramString2.append(" delay=");
      paramLong2 = 0L;
      if (paramLong1 < 0L) {
        paramLong1 = paramLong2;
      } else {
        paramLong1 /= 1000000L;
      }
      paramString2.append(paramLong1);
      paramString2.append("ms");
      o.d("Luggage.ThreadBootDelegate", paramString2.toString());
      return;
    }
    StringBuilder localStringBuilder;
    if (paramd == d.f)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>>>> ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("@");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" state=");
      localStringBuilder.append(paramd);
      localStringBuilder.append(" pool=");
      localStringBuilder.append(paramString2);
      o.d("Luggage.ThreadBootDelegate", localStringBuilder.toString());
      return;
    }
    if (paramd == d.g)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<<<< ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("@");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" state=");
      localStringBuilder.append(paramd);
      localStringBuilder.append(" cost=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("ms pool=");
      localStringBuilder.append(paramString2);
      o.d("Luggage.ThreadBootDelegate", localStringBuilder.toString());
      return;
    }
    if (paramd == d.c)
    {
      paramString2 = new StringBuilder();
      paramString2.append("|||||| ");
      paramString2.append(paramString1);
      paramString2.append("@");
      paramString2.append(paramInt);
      paramString2.append(" state=");
      paramString2.append(paramd);
      o.d("Luggage.ThreadBootDelegate", paramString2.toString());
      return;
    }
    if (paramd == d.a)
    {
      paramString2 = new StringBuilder();
      paramString2.append("****** ");
      paramString2.append(paramString1);
      paramString2.append("@");
      paramString2.append(paramInt);
      paramString2.append(" state=");
      paramString2.append(paramd);
      o.d("Luggage.ThreadBootDelegate", paramString2.toString());
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[rejected] ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" pool=");
      localStringBuilder.append(paramString2);
      o.c("Luggage.ThreadBootDelegate", localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("@");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramThrowable);
    o.b("Luggage.ThreadBootDelegate", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ae.3
 * JD-Core Version:    0.7.0.1
 */