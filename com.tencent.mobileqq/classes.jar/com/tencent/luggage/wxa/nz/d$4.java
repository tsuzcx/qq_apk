package com.tencent.luggage.wxa.nz;

import java.util.Set;

class d$4
  implements Runnable
{
  d$4(d paramd, Runnable paramRunnable, String paramString) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      d.g(this.c).remove(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.d.4
 * JD-Core Version:    0.7.0.1
 */