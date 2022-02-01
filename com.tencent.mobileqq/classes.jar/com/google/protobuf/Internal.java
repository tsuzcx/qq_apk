package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

public final class Internal
{
  static final Charset a = Charset.forName("UTF-8");
  static final Charset b = Charset.forName("ISO-8859-1");
  public static final byte[] c = new byte[0];
  public static final ByteBuffer d = ByteBuffer.wrap(c);
  public static final CodedInputStream e = CodedInputStream.a(c);
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 + paramInt3)
    {
      i = i * 31 + paramArrayOfByte[paramInt1];
      paramInt1 += 1;
    }
    return i;
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int a(Internal.EnumLite paramEnumLite)
  {
    return paramEnumLite.getNumber();
  }
  
  public static int a(List<? extends Internal.EnumLite> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = i * 31 + a((Internal.EnumLite)paramList.next())) {}
    return i;
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = a(paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public static <T extends MessageLite> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getMethod("getDefaultInstance", new Class[0]);
      localObject = (MessageLite)((Method)localObject).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get default instance for ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
  
  static <T> T a(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  static Object a(Object paramObject1, Object paramObject2)
  {
    return ((MessageLite)paramObject1).toBuilder().mergeFrom((MessageLite)paramObject2).buildPartial();
  }
  
  static <T> T a(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return Utf8.a(paramArrayOfByte);
  }
  
  public static byte[] a(String paramString)
  {
    return paramString.getBytes(a);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, a);
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal
 * JD-Core Version:    0.7.0.1
 */