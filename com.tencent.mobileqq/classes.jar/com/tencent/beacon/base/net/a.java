package com.tencent.beacon.base.net;

import java.util.List;
import java.util.Map;

public class a
{
  public Map<String, List<String>> a;
  public int b;
  public String c;
  public byte[] d;
  
  public a(Map<String, List<String>> paramMap, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramMap;
    this.b = paramInt;
    this.c = paramString;
    this.d = paramArrayOfByte;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BResponse{code=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a
 * JD-Core Version:    0.7.0.1
 */