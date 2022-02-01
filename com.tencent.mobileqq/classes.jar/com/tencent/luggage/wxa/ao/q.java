package com.tencent.luggage.wxa.ao;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class q
  extends BufferedOutputStream
{
  private boolean a;
  
  public q(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public q(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    a.b(this.a);
    this.out = paramOutputStream;
    this.count = 0;
    this.a = false;
  }
  
  public void close()
  {
    this.a = true;
    try
    {
      flush();
      Object localObject1 = null;
    }
    catch (Throwable localThrowable1) {}
    Object localObject2;
    try
    {
      this.out.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    if (localObject2 != null) {
      x.a((Throwable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.q
 * JD-Core Version:    0.7.0.1
 */