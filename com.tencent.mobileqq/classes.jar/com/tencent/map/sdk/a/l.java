package com.tencent.map.sdk.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
{
  public ByteBuffer a;
  protected String b = "GBK";
  
  public l()
  {
    this(128);
  }
  
  public l(int paramInt)
  {
    this.a = ByteBuffer.allocate(paramInt);
  }
  
  private void a(float paramFloat, int paramInt)
  {
    a(6);
    b((byte)4, paramInt);
    this.a.putFloat(paramFloat);
  }
  
  private void a(int paramInt)
  {
    int i;
    if (this.a.remaining() < paramInt) {
      i = this.a.capacity();
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((i + paramInt) * 2);
      localByteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = localByteBuffer;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
  }
  
  private void a(double[] paramArrayOfDouble, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfDouble.length, 0);
    int i = paramArrayOfDouble.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfDouble[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfFloat.length, 0);
    int i = paramArrayOfFloat.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfFloat[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(int[] paramArrayOfInt, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfInt.length, 0);
    int i = paramArrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfInt[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(long[] paramArrayOfLong, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfLong.length, 0);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfLong[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(Object[] paramArrayOfObject, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfObject.length, 0);
    int i = paramArrayOfObject.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfObject[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(short[] paramArrayOfShort, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfShort.length, 0);
    int i = paramArrayOfShort.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfShort[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfBoolean.length, 0);
    int i = paramArrayOfBoolean.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfBoolean[paramInt], 0);
      paramInt += 1;
    }
  }
  
  private void b(byte paramByte, int paramInt)
  {
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.a.put(b1);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.a.put(b1);
      this.a.put((byte)paramInt);
      return;
    }
    throw new j("tag is too large: ".concat(String.valueOf(paramInt)));
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
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
    this.a.put(paramByte);
  }
  
  public final void a(double paramDouble, int paramInt)
  {
    a(10);
    b((byte)5, paramInt);
    this.a.putDouble(paramDouble);
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
    this.a.putInt(paramInt1);
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
    this.a.putLong(paramLong);
  }
  
  public final void a(n paramn, int paramInt)
  {
    a(2);
    b((byte)10, paramInt);
    paramn.writeTo(this);
    a(2);
    b((byte)11, 0);
  }
  
  public final void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte))
    {
      a(((Byte)paramObject).byteValue(), paramInt);
      return;
    }
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
    if ((paramObject instanceof n))
    {
      a((n)paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      a((byte[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      a((boolean[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      a((short[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a((int[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      a((long[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      a((float[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      a((double[])paramObject, paramInt);
      return;
    }
    if (paramObject.getClass().isArray())
    {
      a((Object[])paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    throw new j("write object error: unsupport type. " + paramObject.getClass());
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.b);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      b((byte)6, paramInt);
      this.a.put((byte)paramString.length);
      this.a.put(paramString);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
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
    this.a.putShort(paramShort);
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
    this.a.put(paramArrayOfByte);
  }
  
  public final byte[] a()
  {
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.l
 * JD-Core Version:    0.7.0.1
 */