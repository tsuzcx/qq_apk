package com.dartnative.dart_native;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ArrayListConverter
{
  public List arrayToList(Object paramObject)
  {
    boolean bool = paramObject instanceof byte[];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = 0;
    ArrayList localArrayList;
    Object localObject;
    if (bool)
    {
      localArrayList = new ArrayList();
      localObject = (byte[])paramObject;
      j = localObject.length;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Byte.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localArrayList = new ArrayList();
      localObject = (short[])paramObject;
      k = localObject.length;
      i = j;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= k) {
          break;
        }
        localArrayList.add(Short.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      localArrayList = new ArrayList();
      localObject = (long[])paramObject;
      j = localObject.length;
      i = k;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Long.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      localArrayList = new ArrayList();
      localObject = (int[])paramObject;
      j = localObject.length;
      i = m;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Integer.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      localArrayList = new ArrayList();
      localObject = (boolean[])paramObject;
      j = localObject.length;
      i = n;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Boolean.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof char[]))
    {
      localArrayList = new ArrayList();
      localObject = (char[])paramObject;
      j = localObject.length;
      i = i1;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Character.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      localArrayList = new ArrayList();
      localObject = (float[])paramObject;
      j = localObject.length;
      i = i2;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Float.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      localArrayList = new ArrayList();
      localObject = (double[])paramObject;
      j = localObject.length;
      i = i3;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Double.valueOf(localObject[i]));
        i += 1;
      }
    }
    paramObject = Collections.singletonList(paramObject);
    return paramObject;
  }
  
  public boolean[] boolListToArray(List<Boolean> paramList)
  {
    boolean[] arrayOfBoolean = new boolean[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfBoolean[i] = ((Boolean)paramList.get(i)).booleanValue();
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public byte[] byteListToArray(List<Byte> paramList)
  {
    byte[] arrayOfByte = new byte[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfByte[i] = ((Byte)paramList.get(i)).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public char[] charListToArray(List<Character> paramList)
  {
    char[] arrayOfChar = new char[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfChar[i] = ((Character)paramList.get(i)).charValue();
      i += 1;
    }
    return arrayOfChar;
  }
  
  public double[] doubleListToArray(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public float[] floatListToArray(List<Float> paramList)
  {
    float[] arrayOfFloat = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat[i] = ((Float)paramList.get(i)).floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public int[] intListToArray(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public long[] longListToArray(List<Long> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public Object[] objectListToArray(List<Object> paramList)
  {
    Object[] arrayOfObject = new Object[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfObject[i] = paramList.get(i);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public List setToList(HashSet<Object> paramHashSet)
  {
    if ((paramHashSet != null) && (paramHashSet.size() != 0)) {
      return new ArrayList(paramHashSet);
    }
    return new ArrayList();
  }
  
  public short[] shortListToArray(List<Short> paramList)
  {
    short[] arrayOfShort = new short[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfShort[i] = ((Short)paramList.get(i)).shortValue();
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dartnative.dart_native.ArrayListConverter
 * JD-Core Version:    0.7.0.1
 */