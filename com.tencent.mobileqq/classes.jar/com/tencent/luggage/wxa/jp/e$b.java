package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jm.a;

class e$b
  implements Runnable
{
  private e$b(e parame) {}
  
  public void run()
  {
    try
    {
      e.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      if (localException.getCause() != null) {
        a.b(e.d(), localException.getCause().toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.e.b
 * JD-Core Version:    0.7.0.1
 */