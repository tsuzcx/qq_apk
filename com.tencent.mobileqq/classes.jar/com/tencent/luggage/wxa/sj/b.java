package com.tencent.luggage.wxa.sj;

import java.util.concurrent.Future;

public abstract class b
  implements e, f, h, Runnable
{
  private Future a;
  
  public void a(Future paramFuture)
  {
    this.a = paramFuture;
  }
  
  public boolean b()
  {
    Future localFuture = this.a;
    if ((localFuture != null) && (!localFuture.isDone())) {
      return this.a.cancel(false);
    }
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sj.b
 * JD-Core Version:    0.7.0.1
 */