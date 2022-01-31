package com.tencent.component.network.utils;

import java.io.UnsupportedEncodingException;
import pkv;
import pkw;

public class Base64
{
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    pkv localpkv = new pkv(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localpkv.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localpkv.jdField_a_of_type_Int == localpkv.jdField_a_of_type_ArrayOfByte.length) {
      return localpkv.jdField_a_of_type_ArrayOfByte;
    }
    paramArrayOfByte = new byte[localpkv.jdField_a_of_type_Int];
    System.arraycopy(localpkv.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 0, localpkv.jdField_a_of_type_Int);
    return paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    pkw localpkw = new pkw(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localpkw.jdField_a_of_type_Boolean)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localpkw.b)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localpkw.c) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localpkw.jdField_a_of_type_ArrayOfByte = new byte[i];
      localpkw.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((jdField_a_of_type_Boolean) || (localpkw.jdField_a_of_type_Int == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localpkw.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.Base64
 * JD-Core Version:    0.7.0.1
 */