package com.tencent.beacon.a.a;

import java.util.Map;

public final class c
{
  public int a;
  public Map<String, Object> b;
  
  public c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public c(int paramInt, Map<String, Object> paramMap)
  {
    this.a = paramInt;
    this.b = paramMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BusEvent{channel=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.a.c
 * JD-Core Version:    0.7.0.1
 */