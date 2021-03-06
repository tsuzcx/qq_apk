package com.tencent.map.sdk.service.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;

public final class Tag
  extends MapJceStruct
  implements Cloneable
{
  static byte[] a;
  public String strId = "";
  public byte[] value = null;
  
  public Tag() {}
  
  public Tag(String paramString, byte[] paramArrayOfByte)
  {
    this.strId = paramString;
    this.value = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "sosomap.Tag";
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
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.strId, "strId");
    paramStringBuilder.a(this.value, "value");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.strId, true);
    paramStringBuilder.a(this.value, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Tag)paramObject;
    return (o.a(this.strId, paramObject.strId)) && (o.a(this.value, paramObject.value));
  }
  
  public final byte[] getValue()
  {
    return this.value;
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
    this.strId = paramk.b(0, true);
    if (a == null)
    {
      byte[] arrayOfByte = new byte[1];
      a = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.value = paramk.c(1, true);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.strId, 0);
    paraml.a(this.value, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.sso.Tag
 * JD-Core Version:    0.7.0.1
 */