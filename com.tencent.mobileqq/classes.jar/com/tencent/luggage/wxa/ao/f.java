package com.tencent.luggage.wxa.ao;

public final class f
{
  private boolean a;
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        return false;
      }
      this.a = true;
      notifyAll();
      return true;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.a;
      this.a = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      while (!this.a) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.f
 * JD-Core Version:    0.7.0.1
 */