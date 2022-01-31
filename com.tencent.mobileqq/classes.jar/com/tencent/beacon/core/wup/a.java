package com.tencent.beacon.core.wup;

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

public final class a
{
  private ByteBuffer a;
  private String b = "GBK";
  
  public a() {}
  
  public a(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public a(byte[] paramArrayOfByte, byte paramByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramDouble;
      return this.a.getFloat();
      return this.a.getDouble();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramFloat;
      return this.a.getFloat();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private static int a(a.a parama, ByteBuffer paramByteBuffer)
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
  
  private JceStruct a(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    a.a locala = null;
    if (b(paramInt))
    {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        locala = new a.a();
        a(locala);
        if (locala.a != 10) {
          throw new RuntimeException("type mismatch.");
        }
      }
      catch (Exception paramJceStruct)
      {
        throw new RuntimeException(paramJceStruct.getMessage());
      }
      paramJceStruct.readFrom(this);
      a();
    }
    do
    {
      return paramJceStruct;
      paramJceStruct = locala;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (b(paramInt))
      {
        paramMap2 = new a.a();
        a(paramMap2);
        switch (paramMap2.a)
        {
        default: 
          throw new RuntimeException("type mismatch.");
        }
        int i = a(0, 0, true);
        if (i < 0) {
          throw new RuntimeException("size invalid: " + i);
        }
        paramInt = 0;
        for (;;)
        {
          paramMap2 = paramMap1;
          if (paramInt >= i) {
            break;
          }
          paramMap1.put(a(localObject1, 0, true), a(localObject2, 1, true));
          paramInt += 1;
        }
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  private void a()
  {
    a.a locala = new a.a();
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
      throw new RuntimeException("invalid type.");
    case 0: 
      a(1);
    case 11: 
    case 12: 
      return;
    case 1: 
      a(2);
      return;
    case 2: 
      a(4);
      return;
    case 3: 
      a(8);
      return;
    case 4: 
      a(4);
      return;
    case 5: 
      a(8);
      return;
    case 6: 
      b1 = this.a.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      a(paramByte);
      return;
    case 7: 
      a(this.a.getInt());
      return;
    case 8: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 << 1)
      {
        b();
        paramByte += 1;
      }
    case 9: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1)
      {
        b();
        paramByte += 1;
      }
    case 13: 
      a.a locala = new a.a();
      a(locala);
      if (locala.a != 0) {
        throw new RuntimeException("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
      }
      a(a(0, 0, true));
      return;
    }
    a();
  }
  
  private void a(int paramInt)
  {
    this.a.position(this.a.position() + paramInt);
  }
  
  private void a(a.a parama)
  {
    a(parama, this.a);
  }
  
  private void b()
  {
    a.a locala = new a.a();
    a(locala);
    a(locala.a);
  }
  
  private boolean b(int paramInt)
  {
    try
    {
      a.a locala = new a.a();
      for (;;)
      {
        int i = a(locala, this.a.duplicate());
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
        a(i);
        a(locala.a);
      }
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      return false;
    }
    catch (RuntimeException localRuntimeException) {}
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (paramInt >= i) {
          break;
        }
        arrayOfObject[paramInt] = a(paramT, 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    Object localObject = null;
    return localObject;
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  private short[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  private int[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  private long[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  private float[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  private double[] i(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a.a();
      a((a.a)localObject);
      switch (((a.a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
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
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return localObject;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramByte;
      return this.a.get();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramInt1;
      return this.a.get();
      return this.a.getShort();
      return this.a.getInt();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramLong;
      return this.a.get();
      return this.a.getShort();
      return this.a.getInt();
      return this.a.getLong();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    int i = 0;
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
    if ((paramT instanceof List))
    {
      paramT = (List)paramT;
      if ((paramT == null) || (paramT.isEmpty())) {
        return new ArrayList();
      }
      paramT = b(paramT.get(0), paramInt, paramBoolean);
      if (paramT == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramInt = i;
      while (paramInt < paramT.length)
      {
        localArrayList.add(paramT[paramInt]);
        paramInt += 1;
      }
      return localArrayList;
    }
    if ((paramT instanceof JceStruct)) {
      return a((JceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
        return c(paramInt, paramBoolean);
      }
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
      paramT = (Object[])paramT;
      if ((paramT == null) || (paramT.length == 0)) {
        throw new RuntimeException("unable to get type of key and value.");
      }
      return b(paramT[0], paramInt, paramBoolean);
    }
    throw new RuntimeException("read object error: unsupport type.");
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new a.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean)
    {
      a.a locala;
      return paramShort;
      return (short)this.a.get();
      return this.a.getShort();
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (a((byte)0, paramInt, paramBoolean) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final String b(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (b(paramInt))
    {
      localObject1 = new a.a();
      a((a.a)localObject1);
      switch (((a.a)localObject1).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 6: 
        i = this.a.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject2 = new byte[paramInt];
        this.a.get((byte[])localObject2);
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        int i;
        localObject1 = new String((byte[])localObject2, this.b);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2);
      }
      paramInt = this.a.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.a.capacity())) {
        throw new RuntimeException("String too long: " + paramInt);
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.a.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.b);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (b(paramInt))
    {
      localObject1 = new a.a();
      a((a.a)localObject1);
      switch (((a.a)localObject1).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 13: 
        localObject2 = new a.a();
        a((a.a)localObject2);
        if (((a.a)localObject2).a != 0) {
          throw new RuntimeException("type mismatch, tag: " + paramInt + ", type: " + ((a.a)localObject1).a + ", " + ((a.a)localObject2).a);
        }
        i = a(0, 0, true);
        if ((i < 0) || (i > this.a.capacity())) {
          throw new RuntimeException("invalid size, tag: " + paramInt + ", type: " + ((a.a)localObject1).a + ", " + ((a.a)localObject2).a + ", size: " + i);
        }
        localObject1 = new byte[i];
        this.a.get((byte[])localObject1);
      }
    }
    while (!paramBoolean)
    {
      return localObject1;
      int i = a(0, 0, true);
      if ((i < 0) || (i > this.a.capacity())) {
        throw new RuntimeException("size invalid: " + i);
      }
      Object localObject2 = new byte[i];
      paramInt = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt >= i) {
          break;
        }
        localObject2[paramInt] = a(localObject2[0], 0, true);
        paramInt += 1;
      }
    }
    throw new RuntimeException("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.wup.a
 * JD-Core Version:    0.7.0.1
 */