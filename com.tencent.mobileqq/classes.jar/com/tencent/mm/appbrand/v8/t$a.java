package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Function;

class t$a
{
  private volatile int a;
  private volatile n b;
  private volatile V8Function c;
  
  public t$a(int paramInt, n paramn, V8Function paramV8Function)
  {
    this.a = paramInt;
    this.b = paramn;
    this.c = paramV8Function;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LockItem{itemId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t.a
 * JD-Core Version:    0.7.0.1
 */