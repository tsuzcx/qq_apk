package com.tencent.luggage.wxa.rq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class b
{
  private static b c = new b();
  private HandlerThread a = new HandlerThread("Vending-LogicThread");
  private Handler b;
  
  private b()
  {
    this.a.start();
    this.b = new Handler(this.a.getLooper());
  }
  
  public static b a()
  {
    return c;
  }
  
  public Looper b()
  {
    return this.a.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rq.b
 * JD-Core Version:    0.7.0.1
 */