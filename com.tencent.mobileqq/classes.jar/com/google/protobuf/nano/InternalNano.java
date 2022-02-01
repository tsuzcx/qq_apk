package com.google.protobuf.nano;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class InternalNano
{
  static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Object LAZY_INIT_LOCK = new Object();
  public static final int TYPE_BOOL = 8;
  public static final int TYPE_BYTES = 12;
  public static final int TYPE_DOUBLE = 1;
  public static final int TYPE_ENUM = 14;
  public static final int TYPE_FIXED32 = 7;
  public static final int TYPE_FIXED64 = 6;
  public static final int TYPE_FLOAT = 2;
  public static final int TYPE_GROUP = 10;
  public static final int TYPE_INT32 = 5;
  public static final int TYPE_INT64 = 3;
  public static final int TYPE_MESSAGE = 11;
  public static final int TYPE_SFIXED32 = 15;
  public static final int TYPE_SFIXED64 = 16;
  public static final int TYPE_SINT32 = 17;
  public static final int TYPE_SINT64 = 18;
  public static final int TYPE_STRING = 9;
  public static final int TYPE_UINT32 = 13;
  public static final int TYPE_UINT64 = 4;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static byte[] bytesDefaultValue(String paramString)
  {
    return paramString.getBytes(ISO_8859_1);
  }
  
  public static void cloneUnknownFieldData(ExtendableMessageNano paramExtendableMessageNano1, ExtendableMessageNano paramExtendableMessageNano2)
  {
    if (paramExtendableMessageNano1.unknownFieldData != null) {
      paramExtendableMessageNano2.unknownFieldData = paramExtendableMessageNano1.unknownFieldData.clone();
    }
  }
  
  public static <K, V> int computeMapFieldSize(Map<K, V> paramMap, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = CodedOutputByteBufferNano.computeTagSize(paramInt1);
    paramMap = paramMap.entrySet().iterator();
    paramInt1 = 0;
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject2 != null))
      {
        int j = CodedOutputByteBufferNano.computeFieldSize(1, paramInt2, localObject1) + CodedOutputByteBufferNano.computeFieldSize(2, paramInt3, localObject2);
        paramInt1 += i + j + CodedOutputByteBufferNano.computeRawVarint32Size(j);
      }
      else
      {
        throw new IllegalStateException("keys and values in maps cannot be null");
      }
    }
    return paramInt1;
  }
  
  public static byte[] copyFromUtf8(String paramString)
  {
    return paramString.getBytes(UTF_8);
  }
  
  public static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {
      return true;
    }
    if (paramMap1 == null) {
      return paramMap2.size() == 0;
    }
    if (paramMap2 == null) {
      return paramMap1.size() == 0;
    }
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(localEntry.getKey())) {
        return false;
      }
      if (!equalsMapValue(localEntry.getValue(), paramMap2.get(localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean equals(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble1.length != 0)) {
      return Arrays.equals(paramArrayOfDouble1, paramArrayOfDouble2);
    }
    return (paramArrayOfDouble2 == null) || (paramArrayOfDouble2.length == 0);
  }
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.length != 0)) {
      return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
    }
    return (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0);
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt1.length != 0)) {
      return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    }
    return (paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0);
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
      return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    }
    return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int k;
    if (paramArrayOfObject1 == null) {
      k = 0;
    } else {
      k = paramArrayOfObject1.length;
    }
    int m;
    if (paramArrayOfObject2 == null) {
      m = 0;
    } else {
      m = paramArrayOfObject2.length;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int n = j;
      if (i < k)
      {
        n = j;
        if (paramArrayOfObject1[i] == null)
        {
          i += 1;
          continue;
        }
      }
      while ((n < m) && (paramArrayOfObject2[n] == null)) {
        n += 1;
      }
      if (i >= k) {
        j = 1;
      } else {
        j = 0;
      }
      int i1;
      if (n >= m) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((j != 0) && (i1 != 0)) {
        return true;
      }
      if (j != i1) {
        return false;
      }
      if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[n])) {
        return false;
      }
      i += 1;
      j = n + 1;
    }
  }
  
  public static boolean equals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if ((paramArrayOfBoolean1 != null) && (paramArrayOfBoolean1.length != 0)) {
      return Arrays.equals(paramArrayOfBoolean1, paramArrayOfBoolean2);
    }
    return (paramArrayOfBoolean2 == null) || (paramArrayOfBoolean2.length == 0);
  }
  
  public static boolean equals(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    int k;
    if (paramArrayOfByte1 == null) {
      k = 0;
    } else {
      k = paramArrayOfByte1.length;
    }
    int m;
    if (paramArrayOfByte2 == null) {
      m = 0;
    } else {
      m = paramArrayOfByte2.length;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int n = j;
      if (i < k)
      {
        n = j;
        if (paramArrayOfByte1[i] == null)
        {
          i += 1;
          continue;
        }
      }
      while ((n < m) && (paramArrayOfByte2[n] == null)) {
        n += 1;
      }
      if (i >= k) {
        j = 1;
      } else {
        j = 0;
      }
      int i1;
      if (n >= m) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((j != 0) && (i1 != 0)) {
        return true;
      }
      if (j != i1) {
        return false;
      }
      if (!Arrays.equals(paramArrayOfByte1[i], paramArrayOfByte2[n])) {
        return false;
      }
      i += 1;
      j = n + 1;
    }
  }
  
  private static boolean equalsMapValue(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
        return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
      }
      return paramObject1.equals(paramObject2);
    }
    throw new IllegalStateException("keys and values in maps cannot be null");
  }
  
  public static <K, V> int hashCode(Map<K, V> paramMap)
  {
    int i = 0;
    if (paramMap == null) {
      return 0;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int j = hashCodeForMap(localEntry.getKey());
      i += (hashCodeForMap(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public static int hashCode(double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0)) {
      return Arrays.hashCode(paramArrayOfDouble);
    }
    return 0;
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0)) {
      return Arrays.hashCode(paramArrayOfFloat);
    }
    return 0;
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0)) {
      return Arrays.hashCode(paramArrayOfInt);
    }
    return 0;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
      return Arrays.hashCode(paramArrayOfLong);
    }
    return 0;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int j = 0;
    int i;
    if (paramArrayOfObject == null) {
      i = 0;
    } else {
      i = paramArrayOfObject.length;
    }
    int m;
    for (int k = 0; j < i; k = m)
    {
      Object localObject = paramArrayOfObject[j];
      m = k;
      if (localObject != null) {
        m = k * 31 + localObject.hashCode();
      }
      j += 1;
    }
    return k;
  }
  
  public static int hashCode(boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length != 0)) {
      return Arrays.hashCode(paramArrayOfBoolean);
    }
    return 0;
  }
  
  public static int hashCode(byte[][] paramArrayOfByte)
  {
    int j = 0;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    int m;
    for (int k = 0; j < i; k = m)
    {
      byte[] arrayOfByte = paramArrayOfByte[j];
      m = k;
      if (arrayOfByte != null) {
        m = k * 31 + Arrays.hashCode(arrayOfByte);
      }
      j += 1;
    }
    return k;
  }
  
  private static int hashCodeForMap(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return Arrays.hashCode((byte[])paramObject);
    }
    return paramObject.hashCode();
  }
  
  public static final <K, V> Map<K, V> mergeMapEntry(CodedInputByteBufferNano paramCodedInputByteBufferNano, Map<K, V> paramMap, MapFactories.MapFactory paramMapFactory, int paramInt1, int paramInt2, V paramV, int paramInt3, int paramInt4)
  {
    paramMapFactory = paramMapFactory.forMap(paramMap);
    int i = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
    paramMap = null;
    int j;
    do
    {
      for (;;)
      {
        j = paramCodedInputByteBufferNano.readTag();
        if (j == 0) {
          break label96;
        }
        if (j == paramInt3)
        {
          paramMap = paramCodedInputByteBufferNano.readPrimitiveField(paramInt1);
        }
        else
        {
          if (j != paramInt4) {
            break;
          }
          if (paramInt2 == 11) {
            paramCodedInputByteBufferNano.readMessage((MessageNano)paramV);
          } else {
            paramV = paramCodedInputByteBufferNano.readPrimitiveField(paramInt2);
          }
        }
      }
    } while (paramCodedInputByteBufferNano.skipField(j));
    label96:
    paramCodedInputByteBufferNano.checkLastTagWas(0);
    paramCodedInputByteBufferNano.popLimit(i);
    paramCodedInputByteBufferNano = paramMap;
    if (paramMap == null) {
      paramCodedInputByteBufferNano = primitiveDefaultValue(paramInt1);
    }
    paramMap = paramV;
    if (paramV == null) {
      paramMap = primitiveDefaultValue(paramInt2);
    }
    paramMapFactory.put(paramCodedInputByteBufferNano, paramMap);
    return paramMapFactory;
  }
  
  private static Object primitiveDefaultValue(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Type: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a primitive type.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 12: 
      return WireFormatNano.EMPTY_BYTES;
    case 9: 
      return "";
    case 8: 
      return Boolean.FALSE;
    case 5: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
      return Integer.valueOf(0);
    case 3: 
    case 4: 
    case 6: 
    case 16: 
    case 18: 
      return Long.valueOf(0L);
    case 2: 
      return Float.valueOf(0.0F);
    }
    return Double.valueOf(0.0D);
  }
  
  public static <K, V> void serializeMapField(CodedOutputByteBufferNano paramCodedOutputByteBufferNano, Map<K, V> paramMap, int paramInt1, int paramInt2, int paramInt3)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject2 != null))
      {
        int i = CodedOutputByteBufferNano.computeFieldSize(1, paramInt2, localObject1);
        int j = CodedOutputByteBufferNano.computeFieldSize(2, paramInt3, localObject2);
        paramCodedOutputByteBufferNano.writeTag(paramInt1, 2);
        paramCodedOutputByteBufferNano.writeRawVarint32(i + j);
        paramCodedOutputByteBufferNano.writeField(1, paramInt2, localObject1);
        paramCodedOutputByteBufferNano.writeField(2, paramInt3, localObject2);
      }
      else
      {
        throw new IllegalStateException("keys and values in maps cannot be null");
      }
    }
  }
  
  public static String stringDefaultValue(String paramString)
  {
    return new String(paramString.getBytes(ISO_8859_1), UTF_8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.InternalNano
 * JD-Core Version:    0.7.0.1
 */