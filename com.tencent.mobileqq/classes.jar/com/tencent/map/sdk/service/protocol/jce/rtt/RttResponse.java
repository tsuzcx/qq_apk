package com.tencent.map.sdk.service.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;

public final class RttResponse
  extends MapJceStruct
  implements Cloneable
{
  static byte[] a;
  public byte[] result = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    a = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public RttResponse() {}
  
  public RttResponse(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "navsns.RttResponse";
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (b) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new i(paramStringBuilder, paramInt).a(this.result, "result");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new i(paramStringBuilder, paramInt).a(this.result, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RttResponse)paramObject;
    return o.a(this.result, paramObject.result);
  }
  
  public final byte[] getResult()
  {
    return this.result;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(k paramk)
  {
    this.result = ((byte[])paramk.c(0, true));
  }
  
  public final void setResult(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.result, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.rtt.RttResponse
 * JD-Core Version:    0.7.0.1
 */