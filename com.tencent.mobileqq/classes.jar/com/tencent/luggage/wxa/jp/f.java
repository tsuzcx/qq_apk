package com.tencent.luggage.wxa.jp;

import java.net.InetAddress;

public class f
{
  private static int a = 900;
  private InetAddress b;
  private int c;
  private int d;
  
  public f(String paramString, int paramInt)
  {
    this(InetAddress.getByName(paramString), paramInt, a);
  }
  
  public f(InetAddress paramInetAddress, int paramInt1, int paramInt2)
  {
    this.b = paramInetAddress;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public InetAddress a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.f
 * JD-Core Version:    0.7.0.1
 */