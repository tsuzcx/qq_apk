package com.tencent.beacon.core.wup;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  public static final byte[] b = new byte[0];
  private ByteBuffer c;
  protected String d = "GBK";
  
  public b()
  {
    this(128);
  }
  
  public b(int paramInt)
  {
    this.c = ByteBuffer.allocate(paramInt);
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
  
  public int a(String paramString)
  {
    this.d = paramString;
    return 0;
  }
  
  public ByteBuffer a()
  {
    return this.c;
  }
  
  public void a(byte paramByte, int paramInt)
  {
    a(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      return;
    }
    b((byte)0, paramInt);
    this.c.put(paramByte);
  }
  
  public void a(double paramDouble, int paramInt)
  {
    a(10);
    b((byte)5, paramInt);
    this.c.putDouble(paramDouble);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    a(6);
    b((byte)4, paramInt);
    this.c.putFloat(paramFloat);
  }
  
  public void a(int paramInt)
  {
    int i;
    if (this.c.remaining() < paramInt) {
      i = this.c.capacity();
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((i + paramInt) * 2);
      localByteBuffer.put(this.c.array(), 0, this.c.position());
      this.c = localByteBuffer;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    b((byte)2, paramInt2);
    this.c.putInt(paramInt1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      return;
    }
    b((byte)3, paramInt);
    this.c.putLong(paramLong);
  }
  
  public void a(JceStruct paramJceStruct, int paramInt)
  {
    a(2);
    b((byte)10, paramInt);
    paramJceStruct.writeTo(this);
    a(2);
    b((byte)11, 0);
  }
  
  public void a(Object paramObject, int paramInt)
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
    if ((paramObject instanceof JceStruct))
    {
      a((JceStruct)paramObject, paramInt);
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
    throw new RuntimeException("write object error: unsupport type. " + paramObject.getClass());
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.d);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes(Charset.forName("UTF-8"));
      }
      b((byte)6, paramInt);
      this.c.put((byte)paramString.length);
      this.c.put(paramString);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.c.putInt(paramString.length);
      this.c.put(paramString);
      return;
    }
  }
  
  public <T> void a(Collection<T> paramCollection, int paramInt)
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
  
  public <K, V> void a(Map<K, V> paramMap, int paramInt)
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
  
  public void a(short paramShort, int paramInt)
  {
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      return;
    }
    b((byte)1, paramInt);
    this.c.putShort(paramShort);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a((byte)paramBoolean, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.c.put(paramArrayOfByte);
  }
  
  public void a(double[] paramArrayOfDouble, int paramInt)
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
  
  public void a(float[] paramArrayOfFloat, int paramInt)
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
  
  public void a(int[] paramArrayOfInt, int paramInt)
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
  
  public void a(long[] paramArrayOfLong, int paramInt)
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
  
  public void a(short[] paramArrayOfShort, int paramInt)
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
  
  public void a(boolean[] paramArrayOfBoolean, int paramInt)
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
  
  public void b(byte paramByte, int paramInt)
  {
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.c.put(b1);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.c.put(b1);
      this.c.put((byte)paramInt);
      return;
    }
    throw new RuntimeException("tag is too large: " + paramInt);
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.c.position()];
    System.arraycopy(this.c.array(), 0, arrayOfByte, 0, this.c.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.wup.b
 * JD-Core Version:    0.7.0.1
 */