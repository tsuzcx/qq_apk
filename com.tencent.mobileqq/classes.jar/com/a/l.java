package com.a;

import java.io.Serializable;

public final class l
  implements Serializable, Cloneable
{
  private String a;
  private int b;
  private int c;
  
  public l(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = 1;
    this.c = 1;
  }
  
  public final Object clone()
  {
    return super.clone();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof l)) {
      return false;
    }
    paramObject = (l)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c);
  }
  
  public final int hashCode()
  {
    return this.a.hashCode() ^ this.b * 100000 ^ this.c;
  }
  
  public final String toString()
  {
    f localf = new f(16);
    localf.a(this.a);
    localf.a('/');
    localf.a(Integer.toString(this.b));
    localf.a('.');
    localf.a(Integer.toString(this.c));
    return localf.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.a.l
 * JD-Core Version:    0.7.0.1
 */