package com.tencent.luggage.wxa.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract void a(ByteBuffer paramByteBuffer);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int b();
  
  public abstract int c();
  
  public abstract void d();
  
  public abstract ByteBuffer e();
  
  public abstract boolean f();
  
  public abstract void g();
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.d
 * JD-Core Version:    0.7.0.1
 */