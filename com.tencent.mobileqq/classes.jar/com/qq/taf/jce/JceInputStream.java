package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JceInputStream
{
  private ByteBuffer bs;
  protected String sServerEncoding = "GBK";
  
  public JceInputStream() {}
  
  public JceInputStream(ByteBuffer paramByteBuffer)
  {
    this.bs = paramByteBuffer;
  }
  
  public JceInputStream(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public JceInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    this.bs.position(paramInt);
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  private int peakHead(JceInputStream.HeadData paramHeadData)
  {
    return readHead(paramHeadData, this.bs.duplicate());
  }
  
  private <T> T[] readArrayImpl(T paramT, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      Object localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      if (((JceInputStream.HeadData)localObject).type == 9)
      {
        int i = read(0, 0, true);
        if (i >= 0)
        {
          localObject = (Object[])Array.newInstance(paramT.getClass(), i);
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt] = read(paramT, 0, true);
            paramInt += 1;
          }
          return localObject;
        }
        paramT = new StringBuilder();
        paramT.append("size invalid: ");
        paramT.append(i);
        throw new JceDecodeException(paramT.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean) {
      return null;
    }
    paramT = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  public static int readHead(JceInputStream.HeadData paramHeadData, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    paramHeadData.type = ((byte)(i & 0xF));
    paramHeadData.tag = ((i & 0xF0) >> 4);
    if (paramHeadData.tag == 15)
    {
      paramHeadData.tag = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> readMap(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 != null) && (!paramMap2.isEmpty()))
    {
      Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
      paramMap2 = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (skipToTag(paramInt))
      {
        JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        if (localHeadData.type == 8)
        {
          int i = read(0, 0, true);
          if (i >= 0)
          {
            paramInt = 0;
            while (paramInt < i)
            {
              paramMap1.put(read(paramMap2, 0, true), read(localObject, 1, true));
              paramInt += 1;
            }
          }
          paramMap1 = new StringBuilder();
          paramMap1.append("size invalid: ");
          paramMap1.append(i);
          throw new JceDecodeException(paramMap1.toString());
        }
        throw new JceDecodeException("type mismatch.");
      }
      if (!paramBoolean) {
        return paramMap1;
      }
      throw new JceDecodeException("require field not exist.");
    }
    return new HashMap();
  }
  
  private void skip(int paramInt)
  {
    ByteBuffer localByteBuffer = this.bs;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  private void skipField()
  {
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
    readHead(localHeadData);
    skipField(localHeadData.type);
  }
  
  private void skipField(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new JceDecodeException("invalid type.");
    case 13: 
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      if (localHeadData.type == 0)
      {
        skip(read(0, 0, true));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skipField with invalid type, type value: ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(", ");
      localStringBuilder.append(localHeadData.type);
      throw new JceDecodeException(localStringBuilder.toString());
    case 10: 
      skipToStructEnd();
      return;
    case 9: 
      b2 = read(0, 0, true);
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
        skipField();
        paramByte += 1;
        continue;
        b1 = read(0, 0, true);
        paramByte = b2;
        while (paramByte < b1 * 2)
        {
          skipField();
          paramByte += 1;
          continue;
          skip(this.bs.getInt());
          return;
          b1 = this.bs.get();
          paramByte = b1;
          if (b1 < 0) {
            paramByte = b1 + 256;
          }
          skip(paramByte);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(8);
          return;
          skip(4);
          return;
          skip(2);
          return;
          skip(1);
        }
      }
    }
  }
  
  public JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt)) {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        if (localHeadData.type == 10)
        {
          paramJceStruct.readFrom(this);
          skipToStructEnd();
          return paramJceStruct;
        }
        throw new JceDecodeException("type mismatch.");
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public ByteBuffer getBs()
  {
    return this.bs;
  }
  
  public byte read(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 0)
      {
        if (paramInt == 12) {
          return 0;
        }
        throw new JceDecodeException("type mismatch.");
      }
      return this.bs.get();
    }
    if (!paramBoolean) {
      return paramByte;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt == 12) {
            return 0.0D;
          }
          throw new JceDecodeException("type mismatch.");
        }
        return this.bs.getDouble();
      }
      return this.bs.getFloat();
    }
    if (!paramBoolean) {
      return paramDouble;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public float read(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 4)
      {
        if (paramInt == 12) {
          return 0.0F;
        }
        throw new JceDecodeException("type mismatch.");
      }
      return this.bs.getFloat();
    }
    if (!paramBoolean) {
      return paramFloat;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (skipToTag(paramInt2))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt1 = localHeadData.type;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 == 12) {
              return 0;
            }
            throw new JceDecodeException("type mismatch.");
          }
          return this.bs.getInt();
        }
        return this.bs.getShort();
      }
      return this.bs.get();
    }
    if (!paramBoolean) {
      return paramInt1;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public long read(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
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
              throw new JceDecodeException("type mismatch.");
            }
            return this.bs.getLong();
          }
          paramInt = this.bs.getInt();
        }
        else
        {
          paramInt = this.bs.getShort();
        }
      }
      else {
        paramInt = this.bs.get();
      }
      return paramInt;
    }
    if (!paramBoolean) {
      return paramLong;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt)) {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        if (localHeadData.type == 10)
        {
          paramJceStruct.readFrom(this);
          skipToStructEnd();
          return paramJceStruct;
        }
        throw new JceDecodeException("type mismatch.");
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
    }
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public <T> Object read(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(read((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(read(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(read((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(read(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(read(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(read(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(read(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return readString(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return readMap((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return readArray((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof JceStruct)) {
      return read((JceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if ((!(paramT instanceof byte[])) && (!(paramT instanceof Byte[])))
      {
        if ((paramT instanceof boolean[])) {
          return read((boolean[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof short[])) {
          return read((short[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof int[])) {
          return read((int[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof long[])) {
          return read((long[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof float[])) {
          return read((float[])null, paramInt, paramBoolean);
        }
        if ((paramT instanceof double[])) {
          return read((double[])null, paramInt, paramBoolean);
        }
        return readArray((Object[])paramT, paramInt, paramBoolean);
      }
      return read((byte[])null, paramInt, paramBoolean);
    }
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public String read(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new JceInputStream.HeadData();
      readHead(paramString);
      paramInt = paramString.type;
      if (paramInt != 6) {
        if (paramInt == 7)
        {
          paramInt = this.bs.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.bs.capacity()))
          {
            arrayOfByte = new byte[paramInt];
            this.bs.get(arrayOfByte);
          }
        }
      }
    }
    try
    {
      paramString = new String(arrayOfByte, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException paramString)
    {
      label100:
      int i;
      break label100;
    }
    paramString = new String(arrayOfByte);
    break label223;
    paramString = new StringBuilder();
    paramString.append("String too long: ");
    paramString.append(paramInt);
    throw new JceDecodeException(paramString.toString());
    throw new JceDecodeException("type mismatch.");
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.bs.get(arrayOfByte);
    try
    {
      paramString = new String(arrayOfByte, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException paramString)
    {
      label213:
      label223:
      break label213;
    }
    paramString = new String(arrayOfByte);
    return paramString;
    if (!paramBoolean) {
      return paramString;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      paramInt = localHeadData.type;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 12) {
            return 0;
          }
          throw new JceDecodeException("type mismatch.");
        }
        return this.bs.getShort();
      }
      return (short)this.bs.get();
    }
    if (!paramBoolean) {
      return paramShort;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (read((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfByte = new JceInputStream.HeadData();
      readHead(paramArrayOfByte);
      int i = paramArrayOfByte.type;
      if (i != 9)
      {
        if (i == 13)
        {
          JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
          readHead(localHeadData);
          if (localHeadData.type == 0)
          {
            i = read(0, 0, true);
            if ((i >= 0) && (i <= this.bs.capacity()))
            {
              paramArrayOfByte = new byte[i];
              this.bs.get(paramArrayOfByte);
              return paramArrayOfByte;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("invalid size, tag: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", type: ");
            localStringBuilder.append(paramArrayOfByte.type);
            localStringBuilder.append(", ");
            localStringBuilder.append(localHeadData.type);
            localStringBuilder.append(", size: ");
            localStringBuilder.append(i);
            throw new JceDecodeException(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("type mismatch, tag: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", type: ");
          localStringBuilder.append(paramArrayOfByte.type);
          localStringBuilder.append(", ");
          localStringBuilder.append(localHeadData.type);
          throw new JceDecodeException(localStringBuilder.toString());
        }
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if ((i >= 0) && (i <= this.bs.capacity()))
      {
        paramArrayOfByte = new byte[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramArrayOfByte[paramInt] = read(paramArrayOfByte[0], 0, true);
          paramInt += 1;
        }
        return paramArrayOfByte;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("size invalid: ");
      paramArrayOfByte.append(i);
      throw new JceDecodeException(paramArrayOfByte.toString());
    }
    if (!paramBoolean) {
      return null;
    }
    paramArrayOfByte = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new JceInputStream.HeadData();
      readHead(paramArrayOfDouble);
      if (paramArrayOfDouble.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfDouble[paramInt] = read(arrayOfDouble[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfDouble = new StringBuilder();
        paramArrayOfDouble.append("size invalid: ");
        paramArrayOfDouble.append(i);
        throw new JceDecodeException(paramArrayOfDouble.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfDouble = null;
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new JceInputStream.HeadData();
      readHead(paramArrayOfFloat);
      if (paramArrayOfFloat.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfFloat[paramInt] = read(arrayOfFloat[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append("size invalid: ");
        paramArrayOfFloat.append(i);
        throw new JceDecodeException(paramArrayOfFloat.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfFloat = null;
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
  
  public int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new JceInputStream.HeadData();
      readHead(paramArrayOfInt);
      if (paramArrayOfInt.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfInt[paramInt] = read(arrayOfInt[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("size invalid: ");
        paramArrayOfInt.append(i);
        throw new JceDecodeException(paramArrayOfInt.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfInt = null;
      return paramArrayOfInt;
    }
    paramArrayOfInt = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new JceInputStream.HeadData();
      readHead(paramArrayOfLong);
      if (paramArrayOfLong.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfLong[paramInt] = read(arrayOfLong[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfLong = new StringBuilder();
        paramArrayOfLong.append("size invalid: ");
        paramArrayOfLong.append(i);
        throw new JceDecodeException(paramArrayOfLong.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfLong = null;
      return paramArrayOfLong;
    }
    paramArrayOfLong = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public JceStruct[] read(JceStruct[] paramArrayOfJceStruct, int paramInt, boolean paramBoolean)
  {
    return (JceStruct[])readArray(paramArrayOfJceStruct, paramInt, paramBoolean);
  }
  
  public String[] read(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    return (String[])readArray(paramArrayOfString, paramInt, paramBoolean);
  }
  
  public short[] read(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new JceInputStream.HeadData();
      readHead(paramArrayOfShort);
      if (paramArrayOfShort.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfShort[paramInt] = read(arrayOfShort[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfShort = new StringBuilder();
        paramArrayOfShort.append("size invalid: ");
        paramArrayOfShort.append(i);
        throw new JceDecodeException(paramArrayOfShort.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfShort = null;
      return paramArrayOfShort;
    }
    paramArrayOfShort = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfShort;
    }
  }
  
  public boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new JceInputStream.HeadData();
      readHead(paramArrayOfBoolean);
      if (paramArrayOfBoolean.type == 9)
      {
        int i = read(0, 0, true);
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
            arrayOfBoolean[paramInt] = read(arrayOfBoolean[0], 0, true);
            paramInt += 1;
          }
        }
        paramArrayOfBoolean = new StringBuilder();
        paramArrayOfBoolean.append("size invalid: ");
        paramArrayOfBoolean.append(i);
        throw new JceDecodeException(paramArrayOfBoolean.toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean)
    {
      paramArrayOfBoolean = null;
      return paramArrayOfBoolean;
    }
    paramArrayOfBoolean = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw paramArrayOfBoolean;
    }
  }
  
  public <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      paramList = readArrayImpl(paramList.get(0), paramInt, paramBoolean);
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
  
  public <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0)) {
      return readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
    }
    throw new JceDecodeException("unable to get type of key and value.");
  }
  
  public String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new JceInputStream.HeadData();
      readHead(paramString);
      paramInt = paramString.type;
      if (paramInt != 6)
      {
        if (paramInt == 7)
        {
          paramInt = this.bs.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.bs.capacity()))
          {
            paramString = new byte[paramInt];
            this.bs.get(paramString);
            return HexUtil.bytes2HexStr(paramString);
          }
          paramString = new StringBuilder();
          paramString.append("String too long: ");
          paramString.append(paramInt);
          throw new JceDecodeException(paramString.toString());
        }
        throw new JceDecodeException("type mismatch.");
      }
      int i = this.bs.get();
      paramInt = i;
      if (i < 0) {
        paramInt = i + 256;
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      return HexUtil.bytes2HexStr(paramString);
    }
    if (!paramBoolean) {
      return paramString;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public void readHead(JceInputStream.HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (skipToTag(paramInt))
    {
      Object localObject2 = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject2);
      if (((JceInputStream.HeadData)localObject2).type == 9)
      {
        int k = read(0, 0, true);
        if (k >= 0)
        {
          paramInt = 0;
          while (paramInt < k)
          {
            localObject2 = new JceInputStream.HeadData();
            readHead((JceInputStream.HeadData)localObject2);
            switch (((JceInputStream.HeadData)localObject2).type)
            {
            case 11: 
            default: 
              throw new JceDecodeException("type mismatch.");
            case 12: 
              localArrayList.add(new Integer(0));
              break;
            case 10: 
              try
              {
                localObject2 = (JceStruct)Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                ((JceStruct)localObject2).readFrom(this);
                skipToStructEnd();
                localArrayList.add(localObject2);
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("type mismatch.");
                ((StringBuilder)localObject2).append(localException);
                throw new JceDecodeException(((StringBuilder)localObject2).toString());
              }
            case 7: 
              skip(this.bs.getInt());
              break;
            case 6: 
              int j = this.bs.get();
              int i = j;
              if (j < 0) {
                i = j + 256;
              }
              skip(i);
              break;
            case 5: 
              skip(8);
              break;
            case 4: 
              skip(4);
              break;
            case 3: 
              skip(8);
              break;
            case 2: 
              skip(4);
              break;
            case 1: 
              skip(2);
              break;
            case 0: 
              skip(1);
            }
            paramInt += 1;
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("size invalid: ");
        ((StringBuilder)localObject1).append(k);
        throw new JceDecodeException(((StringBuilder)localObject1).toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean) {
      return localObject1;
    }
    Object localObject1 = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public String readString(int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      paramInt = ((JceInputStream.HeadData)localObject).type;
      if (paramInt != 6) {
        if (paramInt == 7)
        {
          paramInt = this.bs.getInt();
          if ((paramInt <= 104857600) && (paramInt >= 0) && (paramInt <= this.bs.capacity()))
          {
            localObject = new byte[paramInt];
            this.bs.get((byte[])localObject);
          }
        }
      }
    }
    try
    {
      str = new String((byte[])localObject, this.sServerEncoding);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("String too long: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new JceDecodeException(((StringBuilder)localObject).toString());
    throw new JceDecodeException("type mismatch.");
    i = this.bs.get();
    paramInt = i;
    if (i < 0) {
      paramInt = i + 256;
    }
    localObject = new byte[paramInt];
    this.bs.get((byte[])localObject);
    try
    {
      str = new String((byte[])localObject, this.sServerEncoding);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      label215:
      break label215;
    }
    return new String((byte[])localObject);
    if (!paramBoolean) {
      return null;
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    Object localObject = new HashMap();
    if (skipToTag(paramInt))
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      if (localHeadData.type == 8)
      {
        int i = read(0, 0, true);
        if (i >= 0)
        {
          paramInt = 0;
          while (paramInt < i)
          {
            ((HashMap)localObject).put(readString(0, true), readString(1, true));
            paramInt += 1;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size invalid: ");
        ((StringBuilder)localObject).append(i);
        throw new JceDecodeException(((StringBuilder)localObject).toString());
      }
      throw new JceDecodeException("type mismatch.");
    }
    if (!paramBoolean) {
      return localObject;
    }
    localObject = new JceDecodeException("require field not exist.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public void skipToStructEnd()
  {
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
    do
    {
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
  }
  
  public boolean skipToTag(int paramInt)
  {
    try
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      for (;;)
      {
        int i = peakHead(localHeadData);
        if (localHeadData.type == 11) {
          return false;
        }
        if (paramInt <= localHeadData.tag)
        {
          if (paramInt != localHeadData.tag) {
            break;
          }
          return true;
        }
        skip(i);
        skipField(localHeadData.type);
      }
      return false;
    }
    catch (JceDecodeException|BufferUnderflowException localJceDecodeException)
    {
      return false;
    }
  }
  
  public void warp(byte[] paramArrayOfByte)
  {
    wrap(paramArrayOfByte);
  }
  
  public void wrap(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */