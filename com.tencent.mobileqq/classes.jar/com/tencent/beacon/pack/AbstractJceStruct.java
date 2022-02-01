package com.tencent.beacon.pack;

import java.io.Serializable;

public abstract class AbstractJceStruct
  implements Serializable
{
  public static final byte BYTE = 0;
  public static final byte DOUBLE = 5;
  public static final byte FLOAT = 4;
  public static final byte INT = 2;
  public static final int JCE_MAX_STRING_LENGTH = 104857600;
  public static final byte LIST = 9;
  public static final byte LONG = 3;
  public static final byte MAP = 8;
  public static final byte SHORT = 1;
  public static final byte SIMPLE_LIST = 13;
  public static final byte STRING1 = 6;
  public static final byte STRING4 = 7;
  public static final byte STRUCT_BEGIN = 10;
  public static final byte STRUCT_END = 11;
  public static final byte ZERO_TAG = 12;
  
  public AbstractJceStruct newInit()
  {
    return null;
  }
  
  public abstract void readFrom(a parama);
  
  public byte[] toByteArray()
  {
    b localb = new b();
    writeTo(localb);
    return localb.b();
  }
  
  public byte[] toByteArray(String paramString)
  {
    b localb = new b();
    localb.c = paramString;
    writeTo(localb);
    return localb.b();
  }
  
  public abstract void writeTo(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.AbstractJceStruct
 * JD-Core Version:    0.7.0.1
 */