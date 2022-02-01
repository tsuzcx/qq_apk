package com.tencent.luggage.wxa.sk;

import com.tencent.luggage.wxa.sj.i;

public class e<E>
  extends i<E>
{
  private final a e;
  private e.a f;
  
  public e(Runnable paramRunnable, long paramLong, String paramString, boolean paramBoolean)
  {
    super(paramRunnable, paramLong, paramBoolean);
    this.e = a.b(paramString);
  }
  
  void a(e.a parama)
  {
    this.f = parama;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (super.cancel(paramBoolean))
    {
      e.a locala = this.f;
      if (locala != null) {
        locala.b(this);
      }
      return true;
    }
    return false;
  }
  
  public a m()
  {
    return this.e;
  }
  
  public void run()
  {
    try
    {
      a.a(this.e);
      super.run();
      e.a locala1;
      return;
    }
    finally
    {
      a.a(null);
      e.a locala2 = this.f;
      if (locala2 != null) {
        locala2.a(this.e, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.e
 * JD-Core Version:    0.7.0.1
 */