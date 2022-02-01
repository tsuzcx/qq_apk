package com.tencent.map.sdk.a;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  protected String a = "GBK";
  private ByteBuffer b;
  
  public k() {}
  
  public k(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public k(byte[] paramArrayOfByte, byte paramByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    this.b.position(4);
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      k.a locala = new k.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new h("type mismatch.");
      }
      return this.b.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new h("require field not exist.");
  }
  
  private static int a(k.a parama, ByteBuffer paramByteBuffer)
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
  
  private <T> List<T> a(List<T> paramList, int paramInt, boolean paramBoolean)
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
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (b(paramInt))
      {
        k.a locala = new k.a();
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
          throw new h("size invalid: ".concat(String.valueOf(i)));
        }
        throw new h("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new h("require field not exist.");
    }
    return new HashMap();
  }
  
  private void a()
  {
    k.a locala = new k.a();
    do
    {
      a(locala);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new h("invalid type.");
    case 13: 
      k.a locala = new k.a();
      a(locala);
      if (locala.a == 0)
      {
        a(a(0, 0, true));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(locala.a);
      throw new h(localStringBuilder.toString());
    case 11: 
    case 12: 
      return;
    case 10: 
      a();
      return;
    case 9: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2)
      {
        b();
        paramByte += 1;
      }
      return;
    case 8: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1 * 2)
      {
        b();
        paramByte += 1;
      }
      return;
    case 7: 
      a(this.b.getInt());
      return;
    case 6: 
      b1 = this.b.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      a(paramByte);
      return;
    case 5: 
      a(8);
      return;
    case 4: 
      a(4);
      return;
    case 3: 
      a(8);
      return;
    case 2: 
      a(4);
      return;
    case 1: 
      a(2);
      return;
    }
    a(1);
  }
  
  private void a(int paramInt)
  {
    ByteBuffer localByteBuffer = this.b;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private void a(k.a parama)
  {
    a(parama, this.b);
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return b(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new h("unable to get type of key and value.");
  }
  
  private void b()
  {
    k.a locala = new k.a();
    a(locala);
    a(locala.a);
  }
  
  private boolean b(int paramInt)
  {
    try
    {
      k.a locala = new k.a();
      for (;;)
      {
        i = a(locala, this.b.duplicate());
        if ((paramInt <= locala.b) || (locala.a == 11)) {
          break;
        }
        a(i);
        a(locala.a);
      }
      if (locala.a == 11) {
        return false;
      }
      int i = locala.b;
      return paramInt == i;
    }
    catch (h|BufferUnderflowException localh) {}
    return false;
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      Object localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
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
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    paramT = new h("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          boolean[] arrayOfBoolean = new boolean[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfBoolean;
            if (paramInt >= i) {
              break;
            }
            arrayOfBoolean[paramInt] = a(0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private short[] e(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          short[] arrayOfShort = new short[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfShort;
            if (paramInt >= i) {
              break;
            }
            arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private int[] f(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          int[] arrayOfInt = new int[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfInt;
            if (paramInt >= i) {
              break;
            }
            arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private long[] g(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          long[] arrayOfLong = new long[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfLong;
            if (paramInt >= i) {
              break;
            }
            arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private float[] h(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          float[] arrayOfFloat = new float[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfFloat;
            if (paramInt >= i) {
              break;
            }
            arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private double[] i(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      if (((k.a)localObject).a == 9)
      {
        int i = a(0, 0, true);
        if (i >= 0)
        {
          double[] arrayOfDouble = new double[i];
          paramInt = 0;
          for (;;)
          {
            localObject = arrayOfDouble;
            if (paramInt >= i) {
              break;
            }
            arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        throw new h("size invalid: ".concat(String.valueOf(i)));
      }
      throw new h("type mismatch.");
    }
    if (!paramBoolean)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      k.a locala = new k.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new h("type mismatch.");
      }
      return this.b.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new h("require field not exist.");
  }
  
  public final double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      k.a locala = new k.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt == 12) {
            return 0.0D;
          }
          throw new h("type mismatch.");
        }
        return this.b.getDouble();
      }
      return this.b.getFloat();
    }
    if (!paramBoolean) {
      return paramDouble;
    }
    throw new h("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      k.a locala = new k.a();
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
            throw new h("type mismatch.");
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
    throw new h("require field not exist.");
  }
  
  public final int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      k.a locala = new k.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 12) {
                return 0L;
              }
              throw new h("type mismatch.");
            }
            return this.b.getLong();
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
    if (!paramBoolean) {
      return paramLong;
    }
    throw new h("require field not exist.");
  }
  
  public final n a(n paramn, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt)) {
      try
      {
        paramn = (n)paramn.getClass().newInstance();
        k.a locala = new k.a();
        a(locala);
        if (locala.a == 10)
        {
          paramn.readFrom(this);
          a();
          return paramn;
        }
        throw new h("type mismatch.");
      }
      catch (Exception paramn)
      {
        throw new h(paramn.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new h("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(a(paramInt, paramBoolean));
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
      return b(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return a((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof n)) {
      return a((n)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return d(paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return e(paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return f(paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return g(paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return h(paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return i(paramInt, paramBoolean);
        }
        return a((Object[])paramT, paramInt, paramBoolean);
      }
      return c(paramInt, paramBoolean);
    }
    throw new h("read object error: unsupport type.");
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      k.a locala = new k.a();
      a(locala);
      paramInt = locala.a;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 12) {
            return 0;
          }
          throw new h("type mismatch.");
        }
        return this.b.getShort();
      }
      return (short)this.b.get();
    }
    if (!paramBoolean) {
      return paramShort;
    }
    throw new h("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    return a((byte)0, paramInt, paramBoolean) != 0;
  }
  
  public final String b(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      paramInt = ((k.a)localObject).a;
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
    return new String((byte[])localObject);
    throw new h("String too long: ".concat(String.valueOf(paramInt)));
    throw new h("type mismatch.");
    i = this.b.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    Object localObject = new byte[paramInt];
    this.b.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.a);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label195:
      break label195;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new h("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      int i = ((k.a)localObject).a;
      if (i != 9)
      {
        if (i == 13)
        {
          k.a locala = new k.a();
          a(locala);
          if (locala.a == 0)
          {
            i = a(0, 0, true);
            if ((i >= 0) && (i <= this.b.capacity()))
            {
              localObject = new byte[i];
              this.b.get((byte[])localObject);
              return localObject;
            }
            localStringBuilder = new StringBuilder("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(((k.a)localObject).a);
            localStringBuilder.append(", ");
            localStringBuilder.append(locala.a);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new h(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(((k.a)localObject).a);
          localStringBuilder.append(", ");
          localStringBuilder.append(locala.a);
          throw new h(localStringBuilder.toString());
        }
        throw new h("type mismatch.");
      }
      i = a(0, 0, true);
      if ((i >= 0) && (i <= this.b.capacity()))
      {
        localObject = new byte[i];
        paramInt = 0;
        while (paramInt < i)
        {
          localObject[paramInt] = a(localObject[0], 0, true);
          paramInt += 1;
        }
        return localObject;
      }
      throw new h("size invalid: ".concat(String.valueOf(i)));
    }
    if (!paramBoolean) {
      return null;
    }
    Object localObject = new h("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.k
 * JD-Core Version:    0.7.0.1
 */