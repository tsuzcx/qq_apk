package com.tencent.luggage.wxa.mk;

import android.os.Handler;

public class f
{
  private volatile boolean a = false;
  private int b = 1000;
  private Handler c;
  private f.b d;
  private f.a e = new f.a(this, null);
  
  f(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  void a()
  {
    if (!this.a)
    {
      this.a = true;
      this.e.a();
    }
  }
  
  void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  void a(f.b paramb)
  {
    this.d = paramb;
  }
  
  void b()
  {
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.f
 * JD-Core Version:    0.7.0.1
 */