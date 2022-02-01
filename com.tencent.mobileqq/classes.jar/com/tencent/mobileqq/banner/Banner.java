package com.tencent.mobileqq.banner;

import android.view.View;

public class Banner
{
  public int a;
  public int b;
  public View c;
  public boolean d;
  
  public Banner(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt >= 2;
  }
  
  public boolean a()
  {
    return this.b >= 2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("[");
    localStringBuffer.append(this.a);
    localStringBuffer.append(",");
    localStringBuffer.append(this.b);
    localStringBuffer.append(",");
    localStringBuffer.append(this.d);
    localStringBuffer.append(",");
    localStringBuffer.append(this.c);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.Banner
 * JD-Core Version:    0.7.0.1
 */