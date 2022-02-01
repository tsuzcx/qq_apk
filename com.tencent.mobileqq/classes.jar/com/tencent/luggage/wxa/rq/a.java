package com.tencent.luggage.wxa.rq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class a
{
  private static a c = new a();
  private HandlerThread a = new HandlerThread("Vending-HeavyWorkThread", 10);
  private Handler b;
  
  private a()
  {
    this.a.start();
    this.b = new Handler(this.a.getLooper());
  }
  
  public static a a()
  {
    return c;
  }
  
  public Looper b()
  {
    return this.a.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rq.a
 * JD-Core Version:    0.7.0.1
 */