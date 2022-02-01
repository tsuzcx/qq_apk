package com.tencent.beacon.pack;

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
  public static final byte[] a = new byte[0];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  protected String c = "GBK";
  private ByteBuffer d;
  
  public b()
  {
    this(128);
  }
  
  public b(int paramInt)
  {
    this.d = ByteBuffer.allocate(paramInt);
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
    this.c = paramString;
    return 0;
  }
  
  public ByteBuffer a()
  {
    return this.d;
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
    this.d.put(paramByte);
  }
  
  public void a(double paramDouble, int paramInt)
  {
    a(10);
    b((byte)5, paramInt);
    this.d.putDouble(paramDouble);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    a(6);
    b((byte)4, paramInt);
    this.d.putFloat(paramFloat);
  }
  
  public void a(int paramInt)
  {
    if (this.d.remaining() < paramInt)
    {
      int i = this.d.capacity();
      try
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocate((i + paramInt) * 2);
        localByteBuffer.put(this.d.array(), 0, this.d.position());
        this.d = localByteBuffer;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw localIllegalArgumentException;
      }
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
    this.d.putInt(paramInt1);
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
    this.d.putLong(paramLong);
  }
  
  public void a(AbstractJceStruct paramAbstractJceStruct, int paramInt)
  {
    a(2);
    b((byte)10, paramInt);
    paramAbstractJceStruct.writeTo(this);
    a(2);
    b((byte)11, 0);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "";
    }
    if ((localObject instanceof Byte))
    {
      a(((Byte)localObject).byteValue(), paramInt);
      return;
    }
    if ((localObject instanceof Boolean))
    {
      a(((Boolean)localObject).booleanValue(), paramInt);
      return;
    }
    if ((localObject instanceof Short))
    {
      a(((Short)localObject).shortValue(), paramInt);
      return;
    }
    if ((localObject instanceof Integer))
    {
      a(((Integer)localObject).intValue(), paramInt);
      return;
    }
    if ((localObject instanceof Long))
    {
      a(((Long)localObject).longValue(), paramInt);
      return;
    }
    if ((localObject instanceof Float))
    {
      a(((Float)localObject).floatValue(), paramInt);
      return;
    }
    if ((localObject instanceof Double))
    {
      a(((Double)localObject).doubleValue(), paramInt);
      return;
    }
    if ((localObject instanceof String))
    {
      a((String)localObject, paramInt);
      return;
    }
    if ((localObject instanceof Map))
    {
      a((Map)localObject, paramInt);
      return;
    }
    if ((localObject instanceof List))
    {
      a((List)localObject, paramInt);
      return;
    }
    if ((localObject instanceof AbstractJceStruct))
    {
      a((AbstractJceStruct)localObject, paramInt);
      return;
    }
    if ((localObject instanceof byte[]))
    {
      a((byte[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof boolean[]))
    {
      a((boolean[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof short[]))
    {
      a((short[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof int[]))
    {
      a((int[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof long[]))
    {
      a((long[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof float[]))
    {
      a((float[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof double[]))
    {
      a((double[])localObject, paramInt);
      return;
    }
    if (localObject.getClass().isArray())
    {
      a((Object[])localObject, paramInt);
      return;
    }
    if ((localObject instanceof Collection))
    {
      a((Collection)localObject, paramInt);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("write object error: unsupport type. ");
    paramObject.append(localObject.getClass());
    throw new RuntimeException(paramObject.toString());
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.c);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label14:
      break label14;
    }
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.d.putInt(paramString.length);
      this.d.put(paramString);
      return;
    }
    b((byte)6, paramInt);
    this.d.put((byte)paramString.length);
    this.d.put(paramString);
  }
  
  public <T> void a(Collection<T> paramCollection, int paramInt)
  {
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {
      paramInt = 0;
    } else {
      paramInt = paramCollection.size();
    }
    a(paramInt, 0);
    if (paramCollection != null)
    {
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
    if (paramMap == null) {
      paramInt = 0;
    } else {
      paramInt = paramMap.size();
    }
    a(paramInt, 0);
    if (paramMap != null)
    {
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
    this.d.putShort(paramShort);
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
    this.d.put(paramArrayOfByte);
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
      b1 = (byte)(paramByte | paramInt << 4);
      this.d.put(b1);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.d.put(b1);
      this.d.put((byte)paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag is too large: ");
    localStringBuilder.append(paramInt);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.d.position()];
    System.arraycopy(this.d.array(), 0, arrayOfByte, 0, this.d.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.b
 * JD-Core Version:    0.7.0.1
 */