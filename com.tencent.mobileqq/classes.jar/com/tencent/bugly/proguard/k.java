package com.tencent.bugly.proguard;

import java.io.Serializable;

public abstract class k
  implements Serializable
{
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.k
 * JD-Core Version:    0.7.0.1
 */