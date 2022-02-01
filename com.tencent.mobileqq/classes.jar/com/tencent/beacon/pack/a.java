package com.tencent.beacon.pack;

import com.tencent.beacon.base.util.c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  protected String a = "GBK";
  private ByteBuffer b;
  
  public a() {}
  
  public a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    this.b.position(paramInt);
  }
  
  public static int a(a.a parama, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15)
    {
      parama.b = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (a(paramInt))
      {
        a.a locala = new a.a();
        a(locala);
        if (locala.a == 8)
        {
          int i = a(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            while (paramInt < i)
            {
              paramMap1.put(a(paramMap2, 0, true), a(localObject, 1, true));
              paramInt += 1;
            }
          }
          paramMap1 = new StringBuilder();
          paramMap1.append("size invalid: ");
          paramMap1.append(i);
          throw new RuntimeException(paramMap1.toString());
        }
        throw new RuntimeException("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new RuntimeException("require field not exist.");
    }
    return new HashMap();
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new RuntimeException("invalid type.");
    case 13: 
      a.a locala = new a.a();
      a(locala);
      if (locala.a == 0)
      {
        b(a(0, 0, true));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(locala.a);
      throw new RuntimeException(localStringBuilder.toString());
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
    case 8: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      while (paramByte < b2)
      {
        b();
        paramByte += 1;
        continue;
        b1 = a(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          b();
          paramByte += 1;
          continue;
          b(this.b.getInt());
          return;
          b1 = this.b.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          b(paramByte);
          return;
          b(8);
          return;
          b(4);
          return;
          b(8);
          return;
          b(4);
          return;
          b(2);
          return;
          b(1);
        }
      }
    }
  }
  
  private int b(a.a parama)
  {
    return a(parama, this.b.duplicate());
  }
  
  private void b()
  {
    a.a locala = new a.a();
    a(locala);
    a(locala.a);
  }
  
  private void b(int paramInt)
  {
    ByteBuffer localByteBuffer = this.b;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      Object localObject = new a.a();
      a((a.a)localObject);
      if (((a.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = a(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        paramT = new StringBuilder();
        paramT.append("size invalid: ");
        paramT.append(i);
        throw new RuntimeException(paramT.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    paramT = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new RuntimeException("type mismatch.");
      }
      return this.b.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt == 12) {
            return 0.0D;
          }
          throw new RuntimeException("type mismatch.");
        }
        return this.b.getDouble();
      }
      return this.b.getFloat();
    }
    if (!paramBoolean) {
      return paramDouble;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new RuntimeException("type mismatch.");
      }
      return this.b.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt1 = locala.a;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 == 12) {
              return 0;
            }
            throw new RuntimeException("type mismatch.");
          }
          return this.b.getInt();
        }
        return this.b.getShort();
      }
      return this.b.get();
    }
    if (!paramBoolean) {
      return paramInt1;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 12)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3) {
                return this.b.getLong();
              }
              throw new RuntimeException("type mismatch.");
            }
            paramInt = this.b.getInt();
          }
          else
          {
            paramInt = this.b.getShort();
          }
        }
        else {
          paramInt = this.b.get();
        }
        return paramInt;
      }
      return 0L;
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public AbstractJceStruct a(AbstractJceStruct paramAbstractJceStruct, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt)) {
      try
      {
        paramAbstractJceStruct = (AbstractJceStruct)paramAbstractJceStruct.getClass().newInstance();
        a.a locala = new a.a();
        a(locala);
        if (locala.a == 10)
        {
          paramAbstractJceStruct.readFrom(this);
          a();
          return paramAbstractJceStruct;
        }
        throw new RuntimeException("type mismatch.");
      }
      catch (Exception paramAbstractJceStruct)
      {
        throw new RuntimeException(paramAbstractJceStruct.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(a(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(a((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(a(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(a(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(a(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(a(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return a(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return a((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof AbstractJceStruct)) {
      return a((AbstractJceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return a(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return a(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return a(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return a(null, paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return a((float[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return a(null, paramInt, paramBoolean);
        }
        return a((Object[])paramT, paramInt, paramBoolean);
      }
      return a(null, paramInt, paramBoolean);
    }
    throw new RuntimeException("read object error: unsupport type.");
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      paramInt = ((a.a)localObject).a;
      if (paramInt != 6) {
        if (paramInt == 7)
        {
          paramInt = this.b.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.b.capacity()))
          {
            localObject = new byte[paramInt];
            this.b.get((byte[])localObject);
          }
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.a);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str;
      label104:
      int i;
      break label104;
    }
    return new String((byte[])localObject, Charset.forName("UTF-8"));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new RuntimeException(((StringBuilder)localObject).toString());
    throw new RuntimeException("type mismatch.");
    i = this.b.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    localObject = new byte[paramInt];
    this.b.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.a);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label221:
      break label221;
    }
    return new String((byte[])localObject, Charset.forName("UTF-8"));
    if (!paramBoolean) {
      return null;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public <T> List<T> a(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      paramList = b(paramList.get(0), paramInt, paramBoolean);
      if (paramList == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramInt = i;
      while (paramInt < paramList.length)
      {
        localArrayList.add(paramList[paramInt]);
        paramInt += 1;
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      a.a locala = new a.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 12) {
            return 0;
          }
          throw new RuntimeException("type mismatch.");
        }
        return this.b.getShort();
      }
      return (short)this.b.get();
    }
    if (!paramBoolean) {
      return paramShort;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public void a()
  {
    a.a locala = new a.a();
    do
    {
      a(locala);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  public void a(a.a parama)
  {
    a(parama, this.b);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      a.a locala = new a.a();
      for (;;)
      {
        int i = b(locala);
        if (locala.a == 11) {
          return false;
        }
        if (paramInt <= locala.b)
        {
          if (paramInt != locala.b) {
            break;
          }
          return true;
        }
        b(i);
        a(locala.a);
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      c.a(localRuntimeException);
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      c.a(localBufferUnderflowException);
      return false;
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (a((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfByte = new a.a();
      a(paramArrayOfByte);
      int i = paramArrayOfByte.a;
      if (i != 9)
      {
        if (i == 13)
        {
          a.a locala = new a.a();
          a(locala);
          if (locala.a == 0)
          {
            i = a(0, 0, true);
            if ((i >= 0) && (i <= this.b.capacity()))
            {
              paramArrayOfByte = new byte[i];
              this.b.get(paramArrayOfByte);
              return paramArrayOfByte;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(paramArrayOfByte.a);
            localStringBuilder.append(", ");
            localStringBuilder.append(locala.a);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new RuntimeException(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(paramArrayOfByte.a);
          localStringBuilder.append(", ");
          localStringBuilder.append(locala.a);
          throw new RuntimeException(localStringBuilder.toString());
        }
        throw new RuntimeException("type mismatch.");
      }
      i = a(0, 0, true);
      if ((i >= 0) && (i <= this.b.capacity()))
      {
        paramArrayOfByte = new byte[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfByte[paramInt] = a(paramArrayOfByte[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfByte;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("size invalid: ");
      paramArrayOfByte.append(i);
      throw new RuntimeException(paramArrayOfByte.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    paramArrayOfByte = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public double[] a(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfDouble = new a.a();
      a(paramArrayOfDouble);
      if (paramArrayOfDouble.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          double[] arrayOfDouble = new double[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfDouble = arrayOfDouble;
            if (paramInt >= i) {
              break;
            }
            arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfDouble = new StringBuilder();
        paramArrayOfDouble.append("size invalid: ");
        paramArrayOfDouble.append(i);
        throw new RuntimeException(paramArrayOfDouble.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfDouble = null;
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public float[] a(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfFloat = new a.a();
      a(paramArrayOfFloat);
      if (paramArrayOfFloat.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          float[] arrayOfFloat = new float[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfFloat = arrayOfFloat;
            if (paramInt >= i) {
              break;
            }
            arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append("size invalid: ");
        paramArrayOfFloat.append(i);
        throw new RuntimeException(paramArrayOfFloat.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfFloat = null;
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfInt = new a.a();
      a(paramArrayOfInt);
      if (paramArrayOfInt.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          int[] arrayOfInt = new int[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfInt = arrayOfInt;
            if (paramInt >= i) {
              break;
            }
            arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("size invalid: ");
        paramArrayOfInt.append(i);
        throw new RuntimeException(paramArrayOfInt.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfInt = null;
      return paramArrayOfInt;
    }
    paramArrayOfInt = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public long[] a(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfLong = new a.a();
      a(paramArrayOfLong);
      if (paramArrayOfLong.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          long[] arrayOfLong = new long[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfLong = arrayOfLong;
            if (paramInt >= i) {
              break;
            }
            arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfLong = new StringBuilder();
        paramArrayOfLong.append("size invalid: ");
        paramArrayOfLong.append(i);
        throw new RuntimeException(paramArrayOfLong.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfLong = null;
      return paramArrayOfLong;
    }
    paramArrayOfLong = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return b(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new RuntimeException("unable to get type of key and value.");
  }
  
  public short[] a(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfShort = new a.a();
      a(paramArrayOfShort);
      if (paramArrayOfShort.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          short[] arrayOfShort = new short[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfShort = arrayOfShort;
            if (paramInt >= i) {
              break;
            }
            arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfShort = new StringBuilder();
        paramArrayOfShort.append("size invalid: ");
        paramArrayOfShort.append(i);
        throw new RuntimeException(paramArrayOfShort.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfShort = null;
      return paramArrayOfShort;
    }
    paramArrayOfShort = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfShort;
    }
  }
  
  public boolean[] a(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      paramArrayOfBoolean = new a.a();
      a(paramArrayOfBoolean);
      if (paramArrayOfBoolean.a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          boolean[] arrayOfBoolean = new boolean[i];
          paramInt = 0;
          for (;;)
          {
            paramArrayOfBoolean = arrayOfBoolean;
            if (paramInt >= i) {
              break;
            }
            arrayOfBoolean[paramInt] = a(arrayOfBoolean[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfBoolean = new StringBuilder();
        paramArrayOfBoolean.append("size invalid: ");
        paramArrayOfBoolean.append(i);
        throw new RuntimeException(paramArrayOfBoolean.toString());
      }
      throw new RuntimeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfBoolean = null;
      return paramArrayOfBoolean;
    }
    paramArrayOfBoolean = new RuntimeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.a
 * JD-Core Version:    0.7.0.1
 */