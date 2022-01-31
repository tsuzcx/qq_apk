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
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramFloat;
      return this.b.getFloat();
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
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList();
    }
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
        paramMap2 = new k.a();
        a(paramMap2);
        switch (paramMap2.a)
        {
        default: 
          throw new h("type mismatch.");
        }
        int i = a(0, 0, true);
        if (i < 0) {
          throw new h("size invalid: ".concat(String.valueOf(i)));
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
    throw new h("require field not exist.");
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
      b1 = this.b.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      a(paramByte);
      return;
    case 7: 
      a(this.b.getInt());
      return;
    case 8: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 * 2)
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
      k.a locala = new k.a();
      a(locala);
      if (locala.a != 0) {
        throw new h("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
      }
      a(a(0, 0, true));
      return;
    }
    a();
  }
  
  private void a(int paramInt)
  {
    this.b.position(this.b.position() + paramInt);
  }
  
  private void a(k.a parama)
  {
    a(parama, this.b);
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0)) {
      throw new h("unable to get type of key and value.");
    }
    return b(paramArrayOfT[0], paramInt, paramBoolean);
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
        int i = a(locala, this.b.duplicate());
        if ((paramInt <= locala.b) || (locala.a == 11))
        {
          if (locala.a == 11) {
            return false;
          }
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
    catch (h localh)
    {
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException) {}
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    Object localObject = null;
    return localObject;
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  private short[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  private int[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  private long[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  private float[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  private double[] i(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new k.a();
      a((k.a)localObject);
      switch (((k.a)localObject).a)
      {
      default: 
        throw new h("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
      throw new h("require field not exist.");
    }
    return localObject;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramByte;
      return this.b.get();
    }
    throw new h("require field not exist.");
  }
  
  public final double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (b(paramInt))
    {
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramDouble;
      return this.b.getFloat();
      return this.b.getDouble();
    }
    throw new h("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (b(paramInt2))
    {
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramInt1;
      return this.b.get();
      return this.b.getShort();
      return this.b.getInt();
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
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramLong;
      return this.b.get();
      return this.b.getShort();
      return this.b.getInt();
      return this.b.getLong();
    }
    throw new h("require field not exist.");
  }
  
  public final n a(n paramn, int paramInt, boolean paramBoolean)
  {
    k.a locala = null;
    if (b(paramInt))
    {
      try
      {
        paramn = (n)paramn.getClass().newInstance();
        locala = new k.a();
        a(locala);
        if (locala.a != 10) {
          throw new h("type mismatch.");
        }
      }
      catch (Exception paramn)
      {
        throw new h(paramn.getMessage());
      }
      paramn.readFrom(this);
      a();
    }
    do
    {
      return paramn;
      paramn = locala;
    } while (!paramBoolean);
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
      return a((Object[])paramT, paramInt, paramBoolean);
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
      locala = new k.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new h("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean)
    {
      k.a locala;
      return paramShort;
      return (short)this.b.get();
      return this.b.getShort();
    }
    throw new h("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
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
      localObject1 = new k.a();
      a((k.a)localObject1);
      switch (((k.a)localObject1).a)
      {
      default: 
        throw new h("type mismatch.");
      case 6: 
        i = this.b.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject2 = new byte[paramInt];
        this.b.get((byte[])localObject2);
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        int i;
        localObject1 = new String((byte[])localObject2, this.a);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2);
      }
      paramInt = this.b.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.b.capacity())) {
        throw new h("String too long: ".concat(String.valueOf(paramInt)));
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.b.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.a);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new h("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (b(paramInt))
    {
      localObject1 = new k.a();
      a((k.a)localObject1);
      switch (((k.a)localObject1).a)
      {
      default: 
        throw new h("type mismatch.");
      case 13: 
        localObject2 = new k.a();
        a((k.a)localObject2);
        if (((k.a)localObject2).a != 0) {
          throw new h("type mismatch, tag: " + paramInt + ", type: " + ((k.a)localObject1).a + ", " + ((k.a)localObject2).a);
        }
        i = a(0, 0, true);
        if ((i < 0) || (i > this.b.capacity())) {
          throw new h("invalid size, tag: " + paramInt + ", type: " + ((k.a)localObject1).a + ", " + ((k.a)localObject2).a + ", size: " + i);
        }
        localObject1 = new byte[i];
        this.b.get((byte[])localObject1);
      }
    }
    while (!paramBoolean)
    {
      return localObject1;
      int i = a(0, 0, true);
      if ((i < 0) || (i > this.b.capacity())) {
        throw new h("size invalid: ".concat(String.valueOf(i)));
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
    throw new h("require field not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.k
 * JD-Core Version:    0.7.0.1
 */