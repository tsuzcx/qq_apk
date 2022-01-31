package com.tencent.beacon.core.wup;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  protected String a = "GBK";
  private ByteBuffer b;
  
  public b()
  {
    this(128);
  }
  
  public b(int paramInt)
  {
    this.b = ByteBuffer.allocate(paramInt);
  }
  
  private void a(double paramDouble, int paramInt)
  {
    a(10);
    b((byte)5, paramInt);
    this.b.putDouble(paramDouble);
  }
  
  private void a(float paramFloat, int paramInt)
  {
    a(6);
    b((byte)4, paramInt);
    this.b.putFloat(paramFloat);
  }
  
  private void a(int paramInt)
  {
    int i;
    if (this.b.remaining() < paramInt) {
      i = this.b.capacity();
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + paramInt << 1);
      localByteBuffer.put(this.b.array(), 0, this.b.position());
      this.b = localByteBuffer;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
  }
  
  private void b(byte paramByte, int paramInt)
  {
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.b.put(b1);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.b.put(b1);
      this.b.put((byte)paramInt);
      return;
    }
    throw new RuntimeException("tag is too large: " + paramInt);
  }
  
  public final int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public final ByteBuffer a()
  {
    return this.b;
  }
  
  public final void a(byte paramByte, int paramInt)
  {
    a(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      return;
    }
    b((byte)0, paramInt);
    this.b.put(paramByte);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    b((byte)2, paramInt2);
    this.b.putInt(paramInt1);
  }
  
  public final void a(long paramLong, int paramInt)
  {
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      return;
    }
    b((byte)3, paramInt);
    this.b.putLong(paramLong);
  }
  
  public final void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte)) {
      a(((Byte)paramObject).byteValue(), paramInt);
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        a(((Boolean)paramObject).booleanValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Short))
      {
        a(((Short)paramObject).shortValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Integer))
      {
        a(((Integer)paramObject).intValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Long))
      {
        a(((Long)paramObject).longValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Float))
      {
        a(((Float)paramObject).floatValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Double))
      {
        a(((Double)paramObject).doubleValue(), paramInt);
        return;
      }
      if ((paramObject instanceof String))
      {
        a((String)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof Map))
      {
        a((Map)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof List))
      {
        a((List)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof JceStruct))
      {
        paramObject = (JceStruct)paramObject;
        a(2);
        b((byte)10, paramInt);
        paramObject.writeTo(this);
        a(2);
        b((byte)11, 0);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject, paramInt);
        return;
      }
      int i;
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof float[]))
      {
        paramObject = (float[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else
      {
        if (!paramObject.getClass().isArray()) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        i = paramObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    throw new RuntimeException("write object error: unsupport type. " + paramObject.getClass());
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.a);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      b((byte)6, paramInt);
      this.b.put((byte)paramString.length);
      this.b.put(paramString);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.b.putInt(paramString.length);
      this.b.put(paramString);
      return;
    }
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {}
    for (paramInt = 0;; paramInt = paramCollection.size())
    {
      a(paramInt, 0);
      if (paramCollection == null) {
        break;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    a(8);
    b((byte)8, paramInt);
    if (paramMap == null) {}
    for (paramInt = 0;; paramInt = paramMap.size())
    {
      a(paramInt, 0);
      if (paramMap == null) {
        break;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
    }
  }
  
  public final void a(short paramShort, int paramInt)
  {
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      return;
    }
    b((byte)1, paramInt);
    this.b.putShort(paramShort);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a((byte)i, paramInt);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.b.put(paramArrayOfByte);
  }
  
  public final byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b.position()];
    System.arraycopy(this.b.array(), 0, arrayOfByte, 0, this.b.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.wup.b
 * JD-Core Version:    0.7.0.1
 */