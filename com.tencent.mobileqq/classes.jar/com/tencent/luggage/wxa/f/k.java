package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

abstract class k
{
  static final SparseIntArray b = new SparseIntArray();
  private final OrientationEventListener a;
  Display c;
  private int d = 0;
  
  static
  {
    b.put(0, 0);
    b.put(1, 90);
    b.put(2, 180);
    b.put(3, 270);
  }
  
  public k(Context paramContext)
  {
    this.a = new k.1(this, paramContext);
  }
  
  public void a()
  {
    this.a.disable();
    this.c = null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(Display paramDisplay)
  {
    this.c = paramDisplay;
    this.a.enable();
    b(b.get(paramDisplay.getRotation()));
  }
  
  public int b()
  {
    return this.d;
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.k
 * JD-Core Version:    0.7.0.1
 */