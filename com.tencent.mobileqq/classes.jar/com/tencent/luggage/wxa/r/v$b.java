package com.tencent.luggage.wxa.r;

import java.util.Collections;
import java.util.List;

public final class v$b
{
  public final int a;
  public final String b;
  public final List<v.a> c;
  public final byte[] d;
  
  public v$b(int paramInt, String paramString, List<v.a> paramList, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramString;
    if (paramList == null) {
      paramString = Collections.emptyList();
    } else {
      paramString = Collections.unmodifiableList(paramList);
    }
    this.c = paramString;
    this.d = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.v.b
 * JD-Core Version:    0.7.0.1
 */