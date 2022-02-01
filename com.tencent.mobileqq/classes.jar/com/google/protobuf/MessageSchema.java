package com.google.protobuf;

import TT;;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sun.misc.Unsafe;

final class MessageSchema<T>
  implements Schema<T>
{
  private static final int[] a = new int[0];
  private static final Unsafe b = UnsafeUtil.c();
  private final int[] c;
  private final Object[] d;
  private final int e;
  private final int f;
  private final MessageLite g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final int[] l;
  private final int m;
  private final int n;
  private final NewInstanceSchema o;
  private final ListFieldSchema p;
  private final UnknownFieldSchema<?, ?> q;
  private final ExtensionSchema<?> r;
  private final MapFieldSchema s;
  
  private MessageSchema(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, MessageLite paramMessageLite, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema)
  {
    this.c = paramArrayOfInt1;
    this.d = paramArrayOfObject;
    this.e = paramInt1;
    this.f = paramInt2;
    this.i = (paramMessageLite instanceof GeneratedMessageLite);
    this.j = paramBoolean1;
    if ((paramExtensionSchema != null) && (paramExtensionSchema.a(paramMessageLite))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.h = paramBoolean1;
    this.k = paramBoolean2;
    this.l = paramArrayOfInt2;
    this.m = paramInt3;
    this.n = paramInt4;
    this.o = paramNewInstanceSchema;
    this.p = paramListFieldSchema;
    this.q = paramUnknownFieldSchema;
    this.r = paramExtensionSchema;
    this.g = paramMessageLite;
    this.s = paramMapFieldSchema;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.e) && (paramInt1 <= this.f)) {
      return b(paramInt1, paramInt2);
    }
    return -1;
  }
  
  private <UT, UB> int a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT)
  {
    return paramUnknownFieldSchema.f(paramUnknownFieldSchema.b(paramT));
  }
  
  private int a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, ArrayDecoders.Registers paramRegisters)
  {
    Unsafe localUnsafe = b;
    long l1 = this.c[(paramInt8 + 2)] & 0xFFFFF;
    switch (paramInt7)
    {
    default: 
      break;
    case 68: 
      if (paramInt5 == 3)
      {
        paramInt1 = ArrayDecoders.a(a(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramRegisters);
        if (localUnsafe.getInt(paramT, l1) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramT, paramLong, paramRegisters.c);
        } else {
          localUnsafe.putObject(paramT, paramLong, Internal.a(paramArrayOfByte, paramRegisters.c));
        }
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 67: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(CodedInputStream.a(paramRegisters.b)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 66: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(CodedInputStream.e(paramRegisters.a)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 63: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
        paramInt2 = paramRegisters.a;
        paramArrayOfByte = c(paramInt8);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.a(paramInt2)))
        {
          c(paramT).a(paramInt3, Long.valueOf(paramInt2));
        }
        else
        {
          localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
          localUnsafe.putInt(paramT, l1, paramInt4);
        }
        return paramInt1;
      }
      break;
    case 61: 
      if (paramInt5 == 2)
      {
        paramInt1 = ArrayDecoders.e(paramArrayOfByte, paramInt1, paramRegisters);
        localUnsafe.putObject(paramT, paramLong, paramRegisters.c);
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 60: 
      if (paramInt5 == 2)
      {
        paramInt1 = ArrayDecoders.a(a(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
        if (localUnsafe.getInt(paramT, l1) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramT, paramLong, paramRegisters.c);
        } else {
          localUnsafe.putObject(paramT, paramLong, Internal.a(paramArrayOfByte, paramRegisters.c));
        }
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 59: 
      if (paramInt5 == 2)
      {
        paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
        paramInt2 = paramRegisters.a;
        if (paramInt2 == 0)
        {
          localUnsafe.putObject(paramT, paramLong, "");
        }
        else
        {
          if (((paramInt6 & 0x20000000) != 0) && (!Utf8.a(paramArrayOfByte, paramInt1, paramInt1 + paramInt2))) {
            throw InvalidProtocolBufferException.invalidUtf8();
          }
          localUnsafe.putObject(paramT, paramLong, new String(paramArrayOfByte, paramInt1, paramInt2, Internal.a));
          paramInt1 += paramInt2;
        }
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 58: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
        boolean bool;
        if (paramRegisters.b != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        localUnsafe.putObject(paramT, paramLong, Boolean.valueOf(bool));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 57: 
    case 64: 
      if (paramInt5 == 5)
      {
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(ArrayDecoders.a(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1 + 4;
      }
      break;
    case 56: 
    case 65: 
      if (paramInt5 == 1)
      {
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(ArrayDecoders.b(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1 + 8;
      }
      break;
    case 55: 
    case 62: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
        localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramRegisters.a));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 53: 
    case 54: 
      if (paramInt5 == 0)
      {
        paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
        localUnsafe.putObject(paramT, paramLong, Long.valueOf(paramRegisters.b));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 52: 
      if (paramInt5 == 5)
      {
        localUnsafe.putObject(paramT, paramLong, Float.valueOf(ArrayDecoders.d(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1 + 4;
      }
      break;
    case 51: 
      if (paramInt5 == 1)
      {
        localUnsafe.putObject(paramT, paramLong, Double.valueOf(ArrayDecoders.c(paramArrayOfByte, paramInt1)));
        localUnsafe.putInt(paramT, l1, paramInt4);
        return paramInt1 + 8;
      }
      break;
    }
    return paramInt1;
  }
  
  private int a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, ArrayDecoders.Registers paramRegisters)
  {
    Internal.ProtobufList localProtobufList2 = (Internal.ProtobufList)b.getObject(paramT, paramLong2);
    Internal.ProtobufList localProtobufList1 = localProtobufList2;
    if (!localProtobufList2.a())
    {
      int i1 = localProtobufList2.size();
      if (i1 == 0) {
        i1 = 10;
      } else {
        i1 *= 2;
      }
      localProtobufList1 = localProtobufList2.e(i1);
      b.putObject(paramT, paramLong2, localProtobufList1);
    }
    switch (paramInt7)
    {
    default: 
      break;
    case 49: 
      if (paramInt5 == 3) {
        return ArrayDecoders.b(a(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 34: 
    case 48: 
      if (paramInt5 == 2) {
        return ArrayDecoders.i(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 0) {
        return ArrayDecoders.i(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 33: 
    case 47: 
      if (paramInt5 == 2) {
        return ArrayDecoders.h(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 0) {
        return ArrayDecoders.h(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      else
      {
        if (paramInt5 != 0) {
          break;
        }
        paramInt1 = ArrayDecoders.a(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      paramRegisters = (GeneratedMessageLite)paramT;
      paramArrayOfByte = paramRegisters.a;
      paramT = paramArrayOfByte;
      if (paramArrayOfByte == UnknownFieldSetLite.a()) {
        paramT = null;
      }
      paramT = (UnknownFieldSetLite)SchemaUtil.a(paramInt4, localProtobufList1, c(paramInt6), paramT, this.q);
      if (paramT != null) {
        paramRegisters.a = paramT;
      }
      return paramInt1;
    case 28: 
      if (paramInt5 == 2) {
        return ArrayDecoders.l(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 27: 
      if (paramInt5 == 2) {
        return ArrayDecoders.a(a(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 26: 
      if (paramInt5 == 2)
      {
        if ((paramLong1 & 0x20000000) == 0L) {
          return ArrayDecoders.j(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
        }
        return ArrayDecoders.k(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 25: 
    case 42: 
      if (paramInt5 == 2) {
        return ArrayDecoders.g(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 0) {
        return ArrayDecoders.g(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2) {
        return ArrayDecoders.c(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 5) {
        return ArrayDecoders.c(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2) {
        return ArrayDecoders.d(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 1) {
        return ArrayDecoders.d(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2) {
        return ArrayDecoders.a(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 0) {
        return ArrayDecoders.a(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2) {
        return ArrayDecoders.b(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 0) {
        return ArrayDecoders.b(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 19: 
    case 36: 
      if (paramInt5 == 2) {
        return ArrayDecoders.e(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 5) {
        return ArrayDecoders.e(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    case 18: 
    case 35: 
      if (paramInt5 == 2) {
        return ArrayDecoders.f(paramArrayOfByte, paramInt1, localProtobufList1, paramRegisters);
      }
      if (paramInt5 == 1) {
        return ArrayDecoders.f(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localProtobufList1, paramRegisters);
      }
      break;
    }
    return paramInt1;
  }
  
  private <K, V> int a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, ArrayDecoders.Registers paramRegisters)
  {
    Unsafe localUnsafe = b;
    Object localObject3 = b(paramInt3);
    Object localObject2 = localUnsafe.getObject(paramT, paramLong);
    Object localObject1 = localObject2;
    if (this.s.c(localObject2))
    {
      localObject1 = this.s.e(localObject3);
      this.s.a(localObject1, localObject2);
      localUnsafe.putObject(paramT, paramLong, localObject1);
    }
    return a(paramArrayOfByte, paramInt1, paramInt2, this.s.f(localObject3), this.s.a(localObject1), paramRegisters);
  }
  
  private <K, V> int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap, ArrayDecoders.Registers paramRegisters)
  {
    paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
    int i1 = paramRegisters.a;
    if ((i1 >= 0) && (i1 <= paramInt2 - paramInt1))
    {
      int i2 = paramInt1 + i1;
      Object localObject1 = paramMetadata.d;
      Object localObject2 = paramMetadata.f;
      while (paramInt1 < i2)
      {
        i1 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        if (paramInt1 < 0)
        {
          i1 = ArrayDecoders.a(paramInt1, paramArrayOfByte, i1, paramRegisters);
          paramInt1 = paramRegisters.a;
        }
        int i3 = paramInt1 >>> 3;
        int i4 = paramInt1 & 0x7;
        if (i3 != 1)
        {
          if ((i3 == 2) && (i4 == paramMetadata.e.getWireType()))
          {
            paramInt1 = a(paramArrayOfByte, i1, paramInt2, paramMetadata.e, paramMetadata.f.getClass(), paramRegisters);
            localObject2 = paramRegisters.c;
          }
        }
        else if (i4 == paramMetadata.c.getWireType())
        {
          paramInt1 = a(paramArrayOfByte, i1, paramInt2, paramMetadata.c, null, paramRegisters);
          localObject1 = paramRegisters.c;
          continue;
        }
        paramInt1 = ArrayDecoders.a(paramInt1, paramArrayOfByte, i1, paramInt2, paramRegisters);
      }
      if (paramInt1 == i2)
      {
        paramMap.put(localObject1, localObject2);
        return i2;
      }
      throw InvalidProtocolBufferException.parseFailure();
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, WireFormat.FieldType paramFieldType, Class<?> paramClass, ArrayDecoders.Registers paramRegisters)
  {
    switch (MessageSchema.1.a[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return ArrayDecoders.d(paramArrayOfByte, paramInt1, paramRegisters);
    case 16: 
      paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
      paramRegisters.c = Long.valueOf(CodedInputStream.a(paramRegisters.b));
      return paramInt1;
    case 15: 
      paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
      paramRegisters.c = Integer.valueOf(CodedInputStream.e(paramRegisters.a));
      return paramInt1;
    case 14: 
      return ArrayDecoders.a(Protobuf.a().a(paramClass), paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
    case 12: 
    case 13: 
      paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
      paramRegisters.c = Long.valueOf(paramRegisters.b);
      return paramInt1;
    case 9: 
    case 10: 
    case 11: 
      paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
      paramRegisters.c = Integer.valueOf(paramRegisters.a);
      return paramInt1;
    case 8: 
      paramRegisters.c = Float.valueOf(ArrayDecoders.d(paramArrayOfByte, paramInt1));
      break;
    case 6: 
    case 7: 
      paramRegisters.c = Long.valueOf(ArrayDecoders.b(paramArrayOfByte, paramInt1));
      break;
    case 4: 
    case 5: 
      paramRegisters.c = Integer.valueOf(ArrayDecoders.a(paramArrayOfByte, paramInt1));
      return paramInt1 + 4;
    case 3: 
      paramRegisters.c = Double.valueOf(ArrayDecoders.c(paramArrayOfByte, paramInt1));
      return paramInt1 + 8;
    case 2: 
      return ArrayDecoders.e(paramArrayOfByte, paramInt1, paramRegisters);
    }
    paramInt1 = ArrayDecoders.b(paramArrayOfByte, paramInt1, paramRegisters);
    boolean bool;
    if (paramRegisters.b != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramRegisters.c = Boolean.valueOf(bool);
    return paramInt1;
  }
  
  static <T> MessageSchema<T> a(RawMessageInfo paramRawMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema)
  {
    boolean bool;
    if (paramRawMessageInfo.a() == ProtoSyntax.PROTO3) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramRawMessageInfo.d();
    int i13 = str.length();
    int i2 = str.charAt(0);
    int i4;
    if (i2 >= 55296)
    {
      i3 = i2 & 0x1FFF;
      i4 = 1;
      i2 = 13;
      for (;;)
      {
        i1 = i4 + 1;
        i4 = str.charAt(i4);
        if (i4 < 55296) {
          break;
        }
        i3 |= (i4 & 0x1FFF) << i2;
        i2 += 13;
        i4 = i1;
      }
      i2 = i4 << i2 | i3;
    }
    else
    {
      i1 = 1;
    }
    int i3 = i1 + 1;
    int i1 = str.charAt(i1);
    int i6;
    if (i1 >= 55296)
    {
      i4 = i1 & 0x1FFF;
      i1 = 13;
      for (;;)
      {
        i6 = i3 + 1;
        i3 = str.charAt(i3);
        if (i3 < 55296) {
          break;
        }
        i4 |= (i3 & 0x1FFF) << i1;
        i1 += 13;
        i3 = i6;
      }
      i1 = i4 | i3 << i1;
    }
    else
    {
      i6 = i3;
    }
    int[] arrayOfInt1;
    int i8;
    int i5;
    int i9;
    if (i1 == 0)
    {
      arrayOfInt1 = a;
      i8 = 0;
      i4 = 0;
      i5 = 0;
      i7 = 0;
      i10 = 0;
      i1 = 0;
      i9 = 0;
    }
    else
    {
      i3 = i6 + 1;
      i1 = str.charAt(i6);
      if (i1 >= 55296)
      {
        i4 = i1 & 0x1FFF;
        i1 = 13;
        for (i5 = i3;; i5 = i3)
        {
          i3 = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          i4 |= (i5 & 0x1FFF) << i1;
          i1 += 13;
        }
        i1 = i5 << i1 | i4;
        i4 = i3;
      }
      else
      {
        i4 = i3;
      }
      i3 = i4 + 1;
      i9 = str.charAt(i4);
      if (i9 >= 55296)
      {
        i5 = i9 & 0x1FFF;
        i4 = 13;
        for (i6 = i3;; i6 = i3)
        {
          i3 = i6 + 1;
          i6 = str.charAt(i6);
          if (i6 < 55296) {
            break;
          }
          i5 |= (i6 & 0x1FFF) << i4;
          i4 += 13;
        }
        i9 = i5 | i6 << i4;
      }
      i4 = i3 + 1;
      i3 = str.charAt(i3);
      if (i3 >= 55296)
      {
        i5 = i3 & 0x1FFF;
        i3 = 13;
        for (i6 = i4;; i6 = i4)
        {
          i4 = i6 + 1;
          i6 = str.charAt(i6);
          if (i6 < 55296) {
            break;
          }
          i5 |= (i6 & 0x1FFF) << i3;
          i3 += 13;
        }
        i3 = i6 << i3 | i5;
      }
      i5 = i4 + 1;
      i4 = str.charAt(i4);
      if (i4 >= 55296)
      {
        i6 = i4 & 0x1FFF;
        i4 = 13;
        for (i7 = i5;; i7 = i5)
        {
          i5 = i7 + 1;
          i7 = str.charAt(i7);
          if (i7 < 55296) {
            break;
          }
          i6 |= (i7 & 0x1FFF) << i4;
          i4 += 13;
        }
        i4 = i7 << i4 | i6;
      }
      i6 = i5 + 1;
      i5 = str.charAt(i5);
      if (i5 >= 55296)
      {
        i7 = i5 & 0x1FFF;
        i5 = 13;
        for (i8 = i6;; i8 = i6)
        {
          i6 = i8 + 1;
          i8 = str.charAt(i8);
          if (i8 < 55296) {
            break;
          }
          i7 |= (i8 & 0x1FFF) << i5;
          i5 += 13;
        }
        i5 = i8 << i5 | i7;
      }
      i7 = i6 + 1;
      i10 = str.charAt(i6);
      i8 = i7;
      i6 = i10;
      if (i10 >= 55296)
      {
        i8 = i10 & 0x1FFF;
        i6 = 13;
        for (i10 = i7;; i10 = i7)
        {
          i7 = i10 + 1;
          i10 = str.charAt(i10);
          if (i10 < 55296) {
            break;
          }
          i8 |= (i10 & 0x1FFF) << i6;
          i6 += 13;
        }
        i6 = i10 << i6 | i8;
        i8 = i7;
      }
      i7 = i8 + 1;
      i11 = str.charAt(i8);
      i10 = i11;
      i8 = i7;
      if (i11 >= 55296)
      {
        i10 = i11 & 0x1FFF;
        i8 = 13;
        for (i11 = i7;; i11 = i7)
        {
          i7 = i11 + 1;
          i11 = str.charAt(i11);
          if (i11 < 55296) {
            break;
          }
          i10 |= (i11 & 0x1FFF) << i8;
          i8 += 13;
        }
        i10 |= i11 << i8;
        i8 = i7;
      }
      i11 = i8 + 1;
      i12 = str.charAt(i8);
      i7 = i12;
      i8 = i11;
      if (i12 >= 55296)
      {
        i7 = 13;
        i8 = i12 & 0x1FFF;
        i12 = i11;
        i11 = i8;
        for (;;)
        {
          i8 = i12 + 1;
          i12 = str.charAt(i12);
          if (i12 < 55296) {
            break;
          }
          i11 |= (i12 & 0x1FFF) << i7;
          i7 += 13;
          i12 = i8;
        }
        i7 = i11 | i12 << i7;
      }
      arrayOfInt1 = new int[i7 + i6 + i10];
      i11 = i1 * 2 + i9;
      i9 = i1;
      i1 = i7;
      i10 = i6;
      i7 = i5;
      i6 = i8;
      i5 = i11;
      i8 = i3;
    }
    Unsafe localUnsafe = b;
    Object[] arrayOfObject1 = paramRawMessageInfo.e();
    Class localClass = paramRawMessageInfo.c().getClass();
    int[] arrayOfInt2 = new int[i7 * 3];
    Object[] arrayOfObject2 = new Object[i7 * 2];
    int i12 = i10 + i1;
    int i16 = i12;
    i3 = i1;
    int i7 = 0;
    int i15 = 0;
    int i10 = i1;
    i1 = i5;
    int i11 = i4;
    int i14 = i2;
    while (i6 < i13)
    {
      i2 = i6 + 1;
      int i17 = str.charAt(i6);
      if (i17 >= 55296)
      {
        i4 = 13;
        i5 = i17 & 0x1FFF;
        i6 = i2;
        i2 = i4;
        for (;;)
        {
          i4 = i6 + 1;
          i6 = str.charAt(i6);
          if (i6 < 55296) {
            break;
          }
          i5 |= (i6 & 0x1FFF) << i2;
          i2 += 13;
          i6 = i4;
        }
        i17 = i5 | i6 << i2;
      }
      else
      {
        i4 = i2;
      }
      i2 = i4 + 1;
      int i19 = str.charAt(i4);
      if (i19 >= 55296)
      {
        i4 = 13;
        i5 = i19 & 0x1FFF;
        i6 = i2;
        i2 = i4;
        for (;;)
        {
          i4 = i6 + 1;
          i6 = str.charAt(i6);
          if (i6 < 55296) {
            break;
          }
          i5 |= (i6 & 0x1FFF) << i2;
          i2 += 13;
          i6 = i4;
        }
        i19 = i5 | i6 << i2;
      }
      else
      {
        i4 = i2;
      }
      int i26 = i19 & 0xFF;
      int i18 = i7;
      if ((i19 & 0x400) != 0)
      {
        arrayOfInt1[i7] = i15;
        i18 = i7 + 1;
      }
      Object localObject;
      int i24;
      int i23;
      int i22;
      int i21;
      int i20;
      if (i26 >= 51)
      {
        i5 = i4 + 1;
        i6 = str.charAt(i4);
        i4 = i6;
        i2 = i5;
        if (i6 >= 55296)
        {
          i4 = i6 & 0x1FFF;
          i2 = 13;
          i6 = i5;
          i5 = i4;
          for (;;)
          {
            i4 = i6 + 1;
            i6 = str.charAt(i6);
            if (i6 < 55296) {
              break;
            }
            i5 |= (i6 & 0x1FFF) << i2;
            i2 += 13;
            i6 = i4;
          }
          i5 |= i6 << i2;
          i2 = i4;
          i4 = i5;
        }
        i5 = i26 - 51;
        if ((i5 != 9) && (i5 != 17))
        {
          if ((i5 == 12) && ((i14 & 0x1) == 1))
          {
            i6 = i15 / 3;
            i5 = i1 + 1;
            arrayOfObject2[(i6 * 2 + 1)] = arrayOfObject1[i1];
            i1 = i5;
          }
        }
        else
        {
          i6 = i15 / 3;
          i5 = i1 + 1;
          arrayOfObject2[(i6 * 2 + 1)] = arrayOfObject1[i1];
          i1 = i5;
        }
        i4 *= 2;
        localObject = arrayOfObject1[i4];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localObject = a(localClass, (String)localObject);
          arrayOfObject1[i4] = localObject;
        }
        i24 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i4 += 1;
        localObject = arrayOfObject1[i4];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localObject = a(localClass, (String)localObject);
          arrayOfObject1[i4] = localObject;
        }
        i23 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i22 = 0;
        i4 = i1;
        i21 = i3;
        i20 = i16;
        i3 = i2;
      }
      else
      {
        i5 = i1 + 1;
        localObject = a(localClass, (String)arrayOfObject1[i1]);
        if ((i26 != 9) && (i26 != 17))
        {
          if ((i26 != 27) && (i26 != 49))
          {
            if ((i26 != 12) && (i26 != 30) && (i26 != 44))
            {
              if (i26 == 50)
              {
                i1 = i3 + 1;
                arrayOfInt1[i3] = i15;
                i2 = i15 / 3 * 2;
                i3 = i5 + 1;
                arrayOfObject2[i2] = arrayOfObject1[i5];
                if ((i19 & 0x800) != 0)
                {
                  i5 = i3 + 1;
                  arrayOfObject2[(i2 + 1)] = arrayOfObject1[i3];
                  i2 = i1;
                  i1 = i5;
                  break label2171;
                }
                i2 = i1;
                i1 = i3;
                break label2171;
              }
              i1 = i5;
              i2 = i3;
              break label2171;
            }
            i1 = i5;
            i2 = i3;
            if ((i14 & 0x1) != 1) {
              break label2171;
            }
            i2 = i15 / 3;
            i1 = i5 + 1;
            arrayOfObject2[(i2 * 2 + 1)] = arrayOfObject1[i5];
          }
          else
          {
            i2 = i15 / 3;
            i1 = i5 + 1;
            arrayOfObject2[(i2 * 2 + 1)] = arrayOfObject1[i5];
          }
          i2 = i3;
        }
        else
        {
          arrayOfObject2[(i15 / 3 * 2 + 1)] = ((Field)localObject).getType();
          i2 = i3;
          i1 = i5;
        }
        label2171:
        int i25 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        if (((i14 & 0x1) == 1) && (i26 <= 17))
        {
          i5 = i4 + 1;
          i3 = str.charAt(i4);
          if (i3 >= 55296)
          {
            i4 = i3 & 0x1FFF;
            i3 = 13;
            for (;;)
            {
              i7 = i5 + 1;
              i5 = str.charAt(i5);
              if (i5 < 55296) {
                break;
              }
              i4 |= (i5 & 0x1FFF) << i3;
              i3 += 13;
              i5 = i7;
            }
            i3 = i4 | i5 << i3;
          }
          else
          {
            i7 = i5;
          }
          i4 = i9 * 2 + i3 / 32;
          localObject = arrayOfObject1[i4];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = a(localClass, (String)localObject);
            arrayOfObject1[i4] = localObject;
          }
          i6 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i5 = i3 % 32;
        }
        else
        {
          i5 = 0;
          i6 = 0;
          i7 = i4;
        }
        i22 = i5;
        i23 = i6;
        i24 = i25;
        i4 = i1;
        i21 = i2;
        i20 = i16;
        i3 = i7;
        if (i26 >= 18)
        {
          i22 = i5;
          i23 = i6;
          i24 = i25;
          i4 = i1;
          i21 = i2;
          i20 = i16;
          i3 = i7;
          if (i26 <= 49)
          {
            arrayOfInt1[i16] = i25;
            i20 = i16 + 1;
            i3 = i7;
            i21 = i2;
            i4 = i1;
            i24 = i25;
            i23 = i6;
            i22 = i5;
          }
        }
      }
      i5 = i15 + 1;
      arrayOfInt2[i15] = i17;
      i6 = i5 + 1;
      if ((i19 & 0x200) != 0) {
        i1 = 536870912;
      } else {
        i1 = 0;
      }
      if ((i19 & 0x100) != 0) {
        i2 = 268435456;
      } else {
        i2 = 0;
      }
      arrayOfInt2[i5] = (i2 | i1 | i26 << 20 | i24);
      i15 = i6 + 1;
      arrayOfInt2[i6] = (i22 << 20 | i23);
      i1 = i4;
      i6 = i3;
      i7 = i18;
      i3 = i21;
      i16 = i20;
    }
    return new MessageSchema(arrayOfInt2, arrayOfObject2, i8, i11, paramRawMessageInfo.c(), bool, false, arrayOfInt1, i10, i12, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema);
  }
  
  static <T> MessageSchema<T> a(StructuralMessageInfo paramStructuralMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema)
  {
    boolean bool;
    if (paramStructuralMessageInfo.a() == ProtoSyntax.PROTO3) {
      bool = true;
    } else {
      bool = false;
    }
    FieldInfo[] arrayOfFieldInfo = paramStructuralMessageInfo.e();
    int i3;
    int i4;
    if (arrayOfFieldInfo.length == 0)
    {
      i3 = 0;
      i4 = 0;
    }
    else
    {
      i3 = arrayOfFieldInfo[0].a();
      i4 = arrayOfFieldInfo[(arrayOfFieldInfo.length - 1)].a();
    }
    int i1 = arrayOfFieldInfo.length;
    int[] arrayOfInt2 = new int[i1 * 3];
    Object[] arrayOfObject = new Object[i1 * 2];
    int i8 = arrayOfFieldInfo.length;
    int i2 = 0;
    int i5 = 0;
    for (i1 = 0; i2 < i8; i1 = i7)
    {
      localObject1 = arrayOfFieldInfo[i2];
      if (((FieldInfo)localObject1).c() == FieldType.MAP)
      {
        i6 = i5 + 1;
        i7 = i1;
      }
      else
      {
        i6 = i5;
        i7 = i1;
        if (((FieldInfo)localObject1).c().id() >= 18)
        {
          i6 = i5;
          i7 = i1;
          if (((FieldInfo)localObject1).c().id() <= 49)
          {
            i7 = i1 + 1;
            i6 = i5;
          }
        }
      }
      i2 += 1;
      i5 = i6;
    }
    int[] arrayOfInt1 = null;
    if (i5 > 0) {
      localObject1 = new int[i5];
    } else {
      localObject1 = null;
    }
    if (i1 > 0) {
      arrayOfInt1 = new int[i1];
    }
    Object localObject3 = paramStructuralMessageInfo.d();
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = a;
    }
    int i7 = 0;
    i5 = 0;
    i2 = 0;
    i1 = 0;
    int i6 = 0;
    while (i7 < arrayOfFieldInfo.length)
    {
      localObject3 = arrayOfFieldInfo[i7];
      int i9 = ((FieldInfo)localObject3).a();
      a((FieldInfo)localObject3, arrayOfInt2, i5, bool, arrayOfObject);
      i8 = i2;
      if (i2 < localObject2.length)
      {
        i8 = i2;
        if (localObject2[i2] == i9)
        {
          localObject2[i2] = i5;
          i8 = i2 + 1;
        }
      }
      if (((FieldInfo)localObject3).c() == FieldType.MAP)
      {
        localObject1[i1] = i5;
        i2 = i1 + 1;
      }
      do
      {
        do
        {
          i1 = i2;
          break;
          i2 = i1;
        } while (((FieldInfo)localObject3).c().id() < 18);
        i2 = i1;
      } while (((FieldInfo)localObject3).c().id() > 49);
      arrayOfInt1[i6] = ((int)UnsafeUtil.a(((FieldInfo)localObject3).b()));
      i6 += 1;
      i7 += 1;
      i5 += 3;
      i2 = i8;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = a;
    }
    Object localObject1 = arrayOfInt1;
    if (arrayOfInt1 == null) {
      localObject1 = a;
    }
    arrayOfInt1 = new int[localObject2.length + localObject3.length + localObject1.length];
    System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
    System.arraycopy(localObject3, 0, arrayOfInt1, localObject2.length, localObject3.length);
    System.arraycopy(localObject1, 0, arrayOfInt1, localObject2.length + localObject3.length, localObject1.length);
    return new MessageSchema(arrayOfInt2, arrayOfObject, i3, i4, paramStructuralMessageInfo.c(), bool, true, arrayOfInt1, localObject2.length, localObject2.length + localObject3.length, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema);
  }
  
  static <T> MessageSchema<T> a(Class<T> paramClass, MessageInfo paramMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema)
  {
    if ((paramMessageInfo instanceof RawMessageInfo)) {
      return a((RawMessageInfo)paramMessageInfo, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema);
    }
    return a((StructuralMessageInfo)paramMessageInfo, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema);
  }
  
  private Schema a(int paramInt)
  {
    paramInt = paramInt / 3 * 2;
    Schema localSchema = (Schema)this.d[paramInt];
    if (localSchema != null) {
      return localSchema;
    }
    localSchema = Protobuf.a().a((Class)this.d[(paramInt + 1)]);
    this.d[paramInt] = localSchema;
    return localSchema;
  }
  
  private final <K, V, UT, UB> UB a(int paramInt1, int paramInt2, Map<K, V> paramMap, Internal.EnumVerifier paramEnumVerifier, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    MapEntryLite.Metadata localMetadata = this.s.f(b(paramInt1));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramEnumVerifier.a(((Integer)localEntry.getValue()).intValue()))
      {
        paramMap = paramUB;
        if (paramUB == null) {
          paramMap = paramUnknownFieldSchema.a();
        }
        paramUB = ByteString.newCodedBuilder(MapEntryLite.a(localMetadata, localEntry.getKey(), localEntry.getValue()));
        CodedOutputStream localCodedOutputStream = paramUB.b();
        try
        {
          MapEntryLite.a(localCodedOutputStream, localMetadata, localEntry.getKey(), localEntry.getValue());
          paramUnknownFieldSchema.a(paramMap, paramInt2, paramUB.a());
          localIterator.remove();
          paramUB = paramMap;
        }
        catch (IOException paramMap)
        {
          throw new RuntimeException(paramMap);
        }
      }
    }
    return paramUB;
  }
  
  private final <UT, UB> UB a(Object paramObject, int paramInt, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    int i1 = d(paramInt);
    paramObject = UnsafeUtil.f(paramObject, j(e(paramInt)));
    if (paramObject == null) {
      return paramUB;
    }
    Internal.EnumVerifier localEnumVerifier = c(paramInt);
    if (localEnumVerifier == null) {
      return paramUB;
    }
    return a(paramInt, i1, this.s.a(paramObject), localEnumVerifier, paramUB, paramUnknownFieldSchema);
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject1 = paramClass.getDeclaredField(paramString);
      return localObject1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject1;
      label10:
      int i2;
      int i1;
      Object localObject2;
      break label10;
    }
    localObject1 = paramClass.getDeclaredFields();
    i2 = localObject1.length;
    i1 = 0;
    while (i1 < i2)
    {
      localObject2 = localObject1[i1];
      if (paramString.equals(((Field)localObject2).getName())) {
        return localObject2;
      }
      i1 += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Field ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(paramClass.getName());
    ((StringBuilder)localObject2).append(" not found. Known fields are ");
    ((StringBuilder)localObject2).append(Arrays.toString((Object[])localObject1));
    paramClass = new RuntimeException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  private static List<?> a(Object paramObject, long paramLong)
  {
    return (List)UnsafeUtil.f(paramObject, paramLong);
  }
  
  private void a(int paramInt, Object paramObject, Writer paramWriter)
  {
    if ((paramObject instanceof String))
    {
      paramWriter.a(paramInt, (String)paramObject);
      return;
    }
    paramWriter.a(paramInt, (ByteString)paramObject);
  }
  
  private static void a(FieldInfo paramFieldInfo, int[] paramArrayOfInt, int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject = paramFieldInfo.d();
    int i6 = 0;
    int i3;
    int i2;
    int i1;
    if (localObject != null)
    {
      i3 = paramFieldInfo.c().id();
      i2 = (int)UnsafeUtil.a(((OneofInfo)localObject).b());
      i1 = (int)UnsafeUtil.a(((OneofInfo)localObject).a());
      i3 += 51;
    }
    int i4;
    for (;;)
    {
      i4 = 0;
      break;
      localObject = paramFieldInfo.c();
      i2 = (int)UnsafeUtil.a(paramFieldInfo.b());
      i3 = ((FieldType)localObject).id();
      if ((!paramBoolean) && (!((FieldType)localObject).isList()) && (!((FieldType)localObject).isMap()))
      {
        i1 = (int)UnsafeUtil.a(paramFieldInfo.f());
        i4 = Integer.numberOfTrailingZeros(paramFieldInfo.h());
        break;
      }
      if (paramFieldInfo.k() == null) {
        i1 = 0;
      } else {
        i1 = (int)UnsafeUtil.a(paramFieldInfo.k());
      }
    }
    paramArrayOfInt[paramInt] = paramFieldInfo.a();
    int i5;
    if (paramFieldInfo.j()) {
      i5 = 536870912;
    } else {
      i5 = 0;
    }
    if (paramFieldInfo.i()) {
      i6 = 268435456;
    }
    paramArrayOfInt[(paramInt + 1)] = (i6 | i5 | i3 << 20 | i2);
    paramArrayOfInt[(paramInt + 2)] = (i1 | i4 << 20);
    paramArrayOfInt = paramFieldInfo.l();
    if (paramFieldInfo.g() != null)
    {
      paramInt = paramInt / 3 * 2;
      paramArrayOfObject[paramInt] = paramFieldInfo.g();
      if (paramArrayOfInt != null)
      {
        paramArrayOfObject[(paramInt + 1)] = paramArrayOfInt;
        return;
      }
      if (paramFieldInfo.e() != null) {
        paramArrayOfObject[(paramInt + 1)] = paramFieldInfo.e();
      }
    }
    else
    {
      if (paramArrayOfInt != null)
      {
        paramArrayOfObject[(paramInt / 3 * 2 + 1)] = paramArrayOfInt;
        return;
      }
      if (paramFieldInfo.e() != null) {
        paramArrayOfObject[(paramInt / 3 * 2 + 1)] = paramFieldInfo.e();
      }
    }
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, ExtensionSchema<ET> paramExtensionSchema, T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    Object localObject1 = null;
    Object localObject5 = localObject1;
    for (;;)
    {
      Object localObject2 = localObject1;
      try
      {
        i1 = paramReader.b();
        localObject2 = localObject1;
        i2 = k(i1);
        if (i2 < 0)
        {
          if (i1 == 2147483647)
          {
            i1 = this.m;
            while (i1 < this.n)
            {
              localObject1 = a(paramT, this.l[i1], localObject1, paramUnknownFieldSchema);
              i1 += 1;
            }
            if (localObject1 != null) {
              paramUnknownFieldSchema.b(paramT, localObject1);
            }
            return;
          }
          localObject2 = localObject1;
          if (!this.h)
          {
            localObject3 = null;
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = paramExtensionSchema.a(paramExtensionRegistryLite, this.g, i1);
          }
          if (localObject3 != null)
          {
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              localObject2 = localObject1;
              localObject4 = paramExtensionSchema.b(paramT);
            }
            localObject2 = localObject1;
            localObject1 = paramExtensionSchema.a(paramReader, localObject3, paramExtensionRegistryLite, (FieldSet)localObject4, localObject1, paramUnknownFieldSchema);
            localObject5 = localObject4;
            continue;
          }
          localObject2 = localObject1;
          if (paramUnknownFieldSchema.a(paramReader))
          {
            localObject4 = localObject1;
            localObject2 = localObject1;
            if (!paramReader.d()) {}
          }
          else
          {
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              localObject3 = paramUnknownFieldSchema.c(paramT);
            }
            localObject2 = localObject3;
            bool = paramUnknownFieldSchema.a(localObject3, paramReader);
            localObject4 = localObject3;
            if (bool)
            {
              localObject1 = localObject3;
              continue;
            }
          }
          i1 = this.m;
          while (i1 < this.n)
          {
            localObject4 = a(paramT, this.l[i1], localObject4, paramUnknownFieldSchema);
            i1 += 1;
          }
          if (localObject4 != null) {
            paramUnknownFieldSchema.b(paramT, localObject4);
          }
          return;
        }
        localObject2 = localObject1;
        i3 = e(i2);
        localObject2 = localObject1;
        localObject3 = localObject1;
      }
      finally
      {
        try
        {
          int i1;
          int i2;
          Object localObject3;
          Object localObject4;
          boolean bool;
          int i3;
          int i4;
          switch (g(i3))
          {
          case 68: 
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject4 = paramUnknownFieldSchema.a();
              break label3762;
              localObject2 = localObject1;
              localObject3 = localObject1;
              UnsafeUtil.a(paramT, j(i3), paramReader.b(a(i2), paramExtensionRegistryLite));
              localObject2 = localObject1;
              localObject3 = localObject1;
              d(paramT, i1, i2);
            }
            break;
          case 67: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Long.valueOf(paramReader.u()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 66: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(paramReader.t()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 65: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Long.valueOf(paramReader.s()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 64: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(paramReader.r()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 63: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            i4 = paramReader.q();
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = c(i2);
            if (localObject4 != null)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!((Internal.EnumVerifier)localObject4).a(i4))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                localObject1 = SchemaUtil.a(i1, i4, localObject1, paramUnknownFieldSchema);
                continue;
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(i4));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 62: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(paramReader.p()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 61: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.o());
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 60: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (c(paramT, i1, i2))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject4 = Internal.a(UnsafeUtil.f(paramT, j(i3)), paramReader.a(a(i2), paramExtensionRegistryLite));
              localObject2 = localObject1;
              localObject3 = localObject1;
              UnsafeUtil.a(paramT, j(i3), localObject4);
            }
            else
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              UnsafeUtil.a(paramT, j(i3), paramReader.a(a(i2), paramExtensionRegistryLite));
              localObject2 = localObject1;
              localObject3 = localObject1;
              b(paramT, i2);
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 59: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            a(paramT, i3, paramReader);
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 58: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Boolean.valueOf(paramReader.l()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 57: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(paramReader.k()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 56: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Long.valueOf(paramReader.j()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 55: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Integer.valueOf(paramReader.i()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 54: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Long.valueOf(paramReader.g()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 53: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Long.valueOf(paramReader.h()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 52: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Float.valueOf(paramReader.f()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 51: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), Double.valueOf(paramReader.e()));
            localObject2 = localObject1;
            localObject3 = localObject1;
            d(paramT, i1, i2);
            break;
          case 50: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            a(paramT, i2, b(i2), paramExtensionRegistryLite, paramReader);
            break;
          case 49: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            a(paramT, j(i3), paramReader, a(i2), paramExtensionRegistryLite);
            break;
          case 48: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.q(this.p.a(paramT, j(i3)));
            break;
          case 47: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.p(this.p.a(paramT, j(i3)));
            break;
          case 46: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.o(this.p.a(paramT, j(i3)));
            break;
          case 45: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.n(this.p.a(paramT, j(i3)));
            break;
          case 44: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = this.p.a(paramT, j(i3));
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.m((List)localObject4);
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject1 = SchemaUtil.a(i1, (List)localObject4, c(i2), localObject1, paramUnknownFieldSchema);
            break;
          case 43: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.l(this.p.a(paramT, j(i3)));
            break;
          case 42: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.h(this.p.a(paramT, j(i3)));
            break;
          case 41: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.g(this.p.a(paramT, j(i3)));
            break;
          case 40: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.f(this.p.a(paramT, j(i3)));
            break;
          case 39: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.e(this.p.a(paramT, j(i3)));
            break;
          case 38: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.c(this.p.a(paramT, j(i3)));
            break;
          case 37: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.d(this.p.a(paramT, j(i3)));
            break;
          case 36: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.b(this.p.a(paramT, j(i3)));
            break;
          case 35: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.a(this.p.a(paramT, j(i3)));
            break;
          case 34: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.q(this.p.a(paramT, j(i3)));
            break;
          case 33: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.p(this.p.a(paramT, j(i3)));
            break;
          case 32: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.o(this.p.a(paramT, j(i3)));
            break;
          case 31: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.n(this.p.a(paramT, j(i3)));
            break;
          case 30: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = this.p.a(paramT, j(i3));
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.m((List)localObject4);
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject1 = SchemaUtil.a(i1, (List)localObject4, c(i2), localObject1, paramUnknownFieldSchema);
            break;
          case 29: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.l(this.p.a(paramT, j(i3)));
            break;
          case 28: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.k(this.p.a(paramT, j(i3)));
            break;
          case 27: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            a(paramT, i3, paramReader, a(i2), paramExtensionRegistryLite);
            break;
          case 26: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i3, paramReader);
            break;
          case 25: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.h(this.p.a(paramT, j(i3)));
            break;
          case 24: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.g(this.p.a(paramT, j(i3)));
            break;
          case 23: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.f(this.p.a(paramT, j(i3)));
            break;
          case 22: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.e(this.p.a(paramT, j(i3)));
            break;
          case 21: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.c(this.p.a(paramT, j(i3)));
            break;
          case 20: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.d(this.p.a(paramT, j(i3)));
            break;
          case 19: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.b(this.p.a(paramT, j(i3)));
            break;
          case 18: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            paramReader.a(this.p.a(paramT, j(i3)));
            break;
          case 17: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (a(paramT, i2))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject4 = Internal.a(UnsafeUtil.f(paramT, j(i3)), paramReader.b(a(i2), paramExtensionRegistryLite));
              localObject2 = localObject1;
              localObject3 = localObject1;
              UnsafeUtil.a(paramT, j(i3), localObject4);
              continue;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.b(a(i2), paramExtensionRegistryLite));
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 16: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.u());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 15: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.t());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 14: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.s());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 13: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.r());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 12: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            i4 = paramReader.q();
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject4 = c(i2);
            if (localObject4 != null)
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (!((Internal.EnumVerifier)localObject4).a(i4))
              {
                localObject2 = localObject1;
                localObject3 = localObject1;
                localObject1 = SchemaUtil.a(i1, i4, localObject1, paramUnknownFieldSchema);
                continue;
              }
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), i4);
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 11: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.p());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 10: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.o());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 9: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            if (a(paramT, i2))
            {
              localObject2 = localObject1;
              localObject3 = localObject1;
              localObject4 = Internal.a(UnsafeUtil.f(paramT, j(i3)), paramReader.a(a(i2), paramExtensionRegistryLite));
              localObject2 = localObject1;
              localObject3 = localObject1;
              UnsafeUtil.a(paramT, j(i3), localObject4);
              continue;
            }
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.a(a(i2), paramExtensionRegistryLite));
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 8: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            a(paramT, i3, paramReader);
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 7: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.l());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 6: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.k());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 5: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.j());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 4: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.i());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 3: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.g());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 2: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.h());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 1: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.f());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            break;
          case 0: 
            localObject2 = localObject1;
            localObject3 = localObject1;
            UnsafeUtil.a(paramT, j(i3), paramReader.e());
            localObject2 = localObject1;
            localObject3 = localObject1;
            b(paramT, i2);
            continue;
            label3762:
            localObject2 = localObject4;
            localObject3 = localObject4;
            bool = paramUnknownFieldSchema.a(localObject4, paramReader);
            localObject1 = localObject4;
            if (bool) {
              continue;
            }
            i1 = this.m;
            while (i1 < this.n)
            {
              localObject4 = a(paramT, this.l[i1], localObject4, paramUnknownFieldSchema);
              i1 += 1;
            }
            if (localObject4 != null) {
              paramUnknownFieldSchema.b(paramT, localObject4);
            }
            return;
            localObject2 = localObject3;
            if (paramUnknownFieldSchema.a(paramReader))
            {
              localObject2 = localObject3;
              bool = paramReader.d();
              localObject1 = localObject3;
              if (bool) {
                continue;
              }
              i1 = this.m;
              while (i1 < this.n)
              {
                localObject3 = a(paramT, this.l[i1], localObject3, paramUnknownFieldSchema);
                i1 += 1;
              }
              if (localObject3 != null) {
                paramUnknownFieldSchema.b(paramT, localObject3);
              }
              return;
            }
            localObject4 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = localObject3;
              localObject4 = paramUnknownFieldSchema.c(paramT);
            }
            localObject2 = localObject4;
            bool = paramUnknownFieldSchema.a(localObject4, paramReader);
            localObject1 = localObject4;
            if (bool) {
              continue;
            }
            i1 = this.m;
            while (i1 < this.n)
            {
              localObject4 = a(paramT, this.l[i1], localObject4, paramUnknownFieldSchema);
              i1 += 1;
            }
            if (localObject4 != null) {
              paramUnknownFieldSchema.b(paramT, localObject4);
            }
            return;
            paramExtensionSchema = finally;
            i1 = this.m;
            while (i1 < this.n)
            {
              localObject2 = a(paramT, this.l[i1], localObject2, paramUnknownFieldSchema);
              i1 += 1;
            }
            if (localObject2 != null) {
              paramUnknownFieldSchema.b(paramT, localObject2);
            }
            for (;;)
            {
              throw paramExtensionSchema;
            }
          }
        }
        catch (InvalidProtocolBufferException.InvalidWireTypeException localInvalidWireTypeException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private <UT, UB> void a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT, Writer paramWriter)
  {
    paramUnknownFieldSchema.a(paramUnknownFieldSchema.b(paramT), paramWriter);
  }
  
  private <K, V> void a(Writer paramWriter, int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramObject != null) {
      paramWriter.a(paramInt1, this.s.f(b(paramInt2)), this.s.b(paramObject));
    }
  }
  
  private void a(Object paramObject, int paramInt, Reader paramReader)
  {
    if (i(paramInt))
    {
      UnsafeUtil.a(paramObject, j(paramInt), paramReader.n());
      return;
    }
    if (this.i)
    {
      UnsafeUtil.a(paramObject, j(paramInt), paramReader.m());
      return;
    }
    UnsafeUtil.a(paramObject, j(paramInt), paramReader.o());
  }
  
  private <E> void a(Object paramObject, int paramInt, Reader paramReader, Schema<E> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    long l1 = j(paramInt);
    paramReader.a(this.p.a(paramObject, l1), paramSchema, paramExtensionRegistryLite);
  }
  
  private final <K, V> void a(Object paramObject1, int paramInt, Object paramObject2, ExtensionRegistryLite paramExtensionRegistryLite, Reader paramReader)
  {
    long l1 = j(e(paramInt));
    Object localObject2 = UnsafeUtil.f(paramObject1, l1);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = this.s.e(paramObject2);
      UnsafeUtil.a(paramObject1, l1, localObject1);
    }
    else
    {
      localObject1 = localObject2;
      if (this.s.c(localObject2))
      {
        localObject1 = this.s.e(paramObject2);
        this.s.a(localObject1, localObject2);
        UnsafeUtil.a(paramObject1, l1, localObject1);
      }
    }
    paramReader.a(this.s.a(localObject1), this.s.f(paramObject2), paramExtensionRegistryLite);
  }
  
  private <E> void a(Object paramObject, long paramLong, Reader paramReader, Schema<E> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramReader.b(this.p.a(paramObject, paramLong), paramSchema, paramExtensionRegistryLite);
  }
  
  private boolean a(T paramT, int paramInt)
  {
    boolean bool17 = this.j;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool16 = false;
    boolean bool1 = false;
    if (bool17)
    {
      paramInt = e(paramInt);
      long l1 = j(paramInt);
      switch (g(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        if (UnsafeUtil.f(paramT, l1) != null) {
          bool1 = true;
        }
        return bool1;
      case 16: 
        bool1 = bool2;
        if (UnsafeUtil.b(paramT, l1) != 0L) {
          bool1 = true;
        }
        return bool1;
      case 15: 
        bool1 = bool3;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 14: 
        bool1 = bool4;
        if (UnsafeUtil.b(paramT, l1) != 0L) {
          bool1 = true;
        }
        return bool1;
      case 13: 
        bool1 = bool5;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 12: 
        bool1 = bool6;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 11: 
        bool1 = bool7;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 10: 
        return ByteString.EMPTY.equals(UnsafeUtil.f(paramT, l1)) ^ true;
      case 9: 
        bool1 = bool8;
        if (UnsafeUtil.f(paramT, l1) != null) {
          bool1 = true;
        }
        return bool1;
      case 8: 
        paramT = UnsafeUtil.f(paramT, l1);
        if ((paramT instanceof String)) {
          return ((String)paramT).isEmpty() ^ true;
        }
        if ((paramT instanceof ByteString)) {
          return ByteString.EMPTY.equals(paramT) ^ true;
        }
        throw new IllegalArgumentException();
      case 7: 
        return UnsafeUtil.c(paramT, l1);
      case 6: 
        bool1 = bool9;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 5: 
        bool1 = bool10;
        if (UnsafeUtil.b(paramT, l1) != 0L) {
          bool1 = true;
        }
        return bool1;
      case 4: 
        bool1 = bool11;
        if (UnsafeUtil.a(paramT, l1) != 0) {
          bool1 = true;
        }
        return bool1;
      case 3: 
        bool1 = bool12;
        if (UnsafeUtil.b(paramT, l1) != 0L) {
          bool1 = true;
        }
        return bool1;
      case 2: 
        bool1 = bool13;
        if (UnsafeUtil.b(paramT, l1) != 0L) {
          bool1 = true;
        }
        return bool1;
      case 1: 
        bool1 = bool14;
        if (UnsafeUtil.d(paramT, l1) != 0.0F) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool15;
      if (UnsafeUtil.e(paramT, l1) != 0.0D) {
        bool1 = true;
      }
      return bool1;
    }
    paramInt = f(paramInt);
    bool1 = bool16;
    if ((UnsafeUtil.a(paramT, paramInt & 0xFFFFF) & 1 << (paramInt >>> 20)) != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private <N> boolean a(Object paramObject, int paramInt1, int paramInt2)
  {
    paramObject = (List)UnsafeUtil.f(paramObject, j(paramInt1));
    if (paramObject.isEmpty()) {
      return true;
    }
    Schema localSchema = a(paramInt2);
    paramInt1 = 0;
    while (paramInt1 < paramObject.size())
    {
      if (!localSchema.e(paramObject.get(paramInt1))) {
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private boolean a(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.j) {
      return a(paramT, paramInt1);
    }
    return (paramInt2 & paramInt3) != 0;
  }
  
  private static boolean a(Object paramObject, int paramInt, Schema paramSchema)
  {
    return paramSchema.e(UnsafeUtil.f(paramObject, j(paramInt)));
  }
  
  private boolean a(T paramT1, T paramT2, int paramInt)
  {
    int i1 = e(paramInt);
    long l1 = j(i1);
    i1 = g(i1);
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool16 = false;
    boolean bool17 = false;
    boolean bool18 = false;
    boolean bool19 = false;
    boolean bool20 = false;
    boolean bool2 = false;
    switch (i1)
    {
    default: 
      return true;
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
      bool1 = bool2;
      if (f(paramT1, paramT2, paramInt))
      {
        bool1 = bool2;
        if (SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    case 50: 
      return SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1));
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
      return SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1));
    case 17: 
      bool1 = bool3;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool3;
        if (SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    case 16: 
      bool1 = bool4;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool4;
        if (UnsafeUtil.b(paramT1, l1) == UnsafeUtil.b(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 15: 
      bool1 = bool5;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool5;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 14: 
      bool1 = bool6;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool6;
        if (UnsafeUtil.b(paramT1, l1) == UnsafeUtil.b(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 13: 
      bool1 = bool7;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool7;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 12: 
      bool1 = bool8;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool8;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 11: 
      bool1 = bool9;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool9;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 10: 
      bool1 = bool10;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool10;
        if (SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    case 9: 
      bool1 = bool11;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool11;
        if (SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    case 8: 
      bool1 = bool12;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool12;
        if (SchemaUtil.a(UnsafeUtil.f(paramT1, l1), UnsafeUtil.f(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    case 7: 
      bool1 = bool13;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool13;
        if (UnsafeUtil.c(paramT1, l1) == UnsafeUtil.c(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 6: 
      bool1 = bool14;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool14;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 5: 
      bool1 = bool15;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool15;
        if (UnsafeUtil.b(paramT1, l1) == UnsafeUtil.b(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 4: 
      bool1 = bool16;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool16;
        if (UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 3: 
      bool1 = bool17;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool17;
        if (UnsafeUtil.b(paramT1, l1) == UnsafeUtil.b(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 2: 
      bool1 = bool18;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool18;
        if (UnsafeUtil.b(paramT1, l1) == UnsafeUtil.b(paramT2, l1)) {
          bool1 = true;
        }
      }
      return bool1;
    case 1: 
      bool1 = bool19;
      if (e(paramT1, paramT2, paramInt))
      {
        bool1 = bool19;
        if (Float.floatToIntBits(UnsafeUtil.d(paramT1, l1)) == Float.floatToIntBits(UnsafeUtil.d(paramT2, l1))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool20;
    if (e(paramT1, paramT2, paramInt))
    {
      bool1 = bool20;
      if (Double.doubleToLongBits(UnsafeUtil.e(paramT1, l1)) == Double.doubleToLongBits(UnsafeUtil.e(paramT2, l1))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static <T> double b(T paramT, long paramLong)
  {
    return UnsafeUtil.e(paramT, paramLong);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i1 = this.c.length / 3 - 1;
    while (paramInt2 <= i1)
    {
      int i2 = i1 + paramInt2 >>> 1;
      int i3 = i2 * 3;
      int i4 = d(i3);
      if (paramInt1 == i4) {
        return i3;
      }
      if (paramInt1 < i4) {
        i1 = i2 - 1;
      } else {
        paramInt2 = i2 + 1;
      }
    }
    return -1;
  }
  
  private int b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters)
  {
    Unsafe localUnsafe = b;
    int i1 = paramInt1;
    int i2 = -1;
    paramInt1 = 0;
    int i5;
    for (;;)
    {
      Object localObject2 = this;
      T ? = paramT;
      i5 = paramInt2;
      Object localObject3 = paramArrayOfByte;
      Object localObject1 = paramRegisters;
      if (i1 >= i5) {
        break;
      }
      int i3 = i1 + 1;
      int i4 = localObject3[i1];
      if (i4 < 0)
      {
        i1 = ArrayDecoders.a(i4, (byte[])localObject3, i3, (ArrayDecoders.Registers)localObject1);
        i4 = ((ArrayDecoders.Registers)localObject1).a;
      }
      else
      {
        i1 = i3;
      }
      i3 = i4 >>> 3;
      int i6 = i4 & 0x7;
      if (i3 > i2) {
        paramInt1 = ((MessageSchema)localObject2).a(i3, paramInt1 / 3);
      } else {
        paramInt1 = ((MessageSchema)localObject2).k(i3);
      }
      label1034:
      if (paramInt1 == -1)
      {
        paramInt1 = 0;
      }
      else
      {
        i2 = localObject2.c[(paramInt1 + 1)];
        int i7 = g(i2);
        long l1 = j(i2);
        if (i7 <= 17)
        {
          boolean bool = true;
          switch (i7)
          {
          default: 
            break;
          case 16: 
            if (i6 != 0) {
              break label877;
            }
            i1 = ArrayDecoders.b((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putLong(paramT, l1, CodedInputStream.a(((ArrayDecoders.Registers)localObject1).b));
            break;
          case 15: 
            if (i6 != 0) {
              break label756;
            }
            i1 = ArrayDecoders.a((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putInt(?, l1, CodedInputStream.e(((ArrayDecoders.Registers)localObject1).a));
            break;
          case 12: 
            if (i6 != 0) {
              break label756;
            }
            i1 = ArrayDecoders.a((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putInt(?, l1, ((ArrayDecoders.Registers)localObject1).a);
            break;
          case 10: 
            if (i6 != 2) {
              break label877;
            }
            i1 = ArrayDecoders.e((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putObject(?, l1, ((ArrayDecoders.Registers)localObject1).c);
            break;
          case 9: 
            if (i6 != 2) {
              break label877;
            }
            i1 = ArrayDecoders.a(((MessageSchema)localObject2).a(paramInt1), (byte[])localObject3, i1, i5, (ArrayDecoders.Registers)localObject1);
            localObject2 = localUnsafe.getObject(?, l1);
            if (localObject2 == null) {
              localUnsafe.putObject(?, l1, ((ArrayDecoders.Registers)localObject1).c);
            } else {
              localUnsafe.putObject(?, l1, Internal.a(localObject2, ((ArrayDecoders.Registers)localObject1).c));
            }
            break;
          case 8: 
            if (i6 != 2) {
              break label877;
            }
            if ((0x20000000 & i2) == 0) {
              i1 = ArrayDecoders.c((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            } else {
              i1 = ArrayDecoders.d((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            }
            localUnsafe.putObject(?, l1, ((ArrayDecoders.Registers)localObject1).c);
            break;
          case 7: 
            if (i6 != 0) {
              break label877;
            }
            i1 = ArrayDecoders.b((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            if (((ArrayDecoders.Registers)localObject1).b == 0L) {
              bool = false;
            }
            UnsafeUtil.a(?, l1, bool);
            break;
          case 6: 
          case 13: 
            if (i6 != 5) {
              break label877;
            }
            localUnsafe.putInt(?, l1, ArrayDecoders.a((byte[])localObject3, i1));
            i1 += 4;
            break;
          case 5: 
          case 14: 
            if (i6 != 1) {
              break label877;
            }
            localUnsafe.putLong(paramT, l1, ArrayDecoders.b((byte[])localObject3, i1));
            break;
          case 4: 
          case 11: 
            if (i6 != 0) {
              break label756;
            }
            i1 = ArrayDecoders.a((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putInt(?, l1, ((ArrayDecoders.Registers)localObject1).a);
            break;
          case 2: 
          case 3: 
            if (i6 != 0) {
              break label756;
            }
            i1 = ArrayDecoders.b((byte[])localObject3, i1, (ArrayDecoders.Registers)localObject1);
            localUnsafe.putLong(paramT, l1, ((ArrayDecoders.Registers)localObject1).b);
            break;
          case 1: 
            if (i6 != 5) {
              break label756;
            }
            UnsafeUtil.a(?, l1, ArrayDecoders.d((byte[])localObject3, i1));
            i1 += 4;
            break;
          }
          if (i6 == 1)
          {
            UnsafeUtil.a(?, l1, ArrayDecoders.c((byte[])localObject3, i1));
            i1 += 8;
          }
        }
        for (;;)
        {
          i2 = i3;
          break;
          label756:
          i2 = paramInt1;
          break label880;
          if (i7 != 27) {
            break label883;
          }
          if (i6 != 2) {
            break label877;
          }
          localObject3 = (Internal.ProtobufList)localUnsafe.getObject(?, l1);
          localObject1 = localObject3;
          if (!((Internal.ProtobufList)localObject3).a())
          {
            i2 = ((Internal.ProtobufList)localObject3).size();
            if (i2 == 0) {
              i2 = 10;
            } else {
              i2 *= 2;
            }
            localObject1 = ((Internal.ProtobufList)localObject3).e(i2);
            localUnsafe.putObject(?, l1, localObject1);
          }
          i1 = ArrayDecoders.a(((MessageSchema)localObject2).a(paramInt1), i4, paramArrayOfByte, i1, paramInt2, (Internal.ProtobufList)localObject1, paramRegisters);
        }
        label877:
        i2 = paramInt1;
        label880:
        label883:
        if (i7 <= 49)
        {
          i5 = a(paramT, paramArrayOfByte, i1, paramInt2, i4, i3, i6, paramInt1, i2, i7, l1, paramRegisters);
          i2 = i5;
          if (i5 != i1) {
            i1 = i5;
          }
        }
        else
        {
          do
          {
            for (;;)
            {
              break label1056;
              i5 = i1;
              if (i7 != 50) {
                break label993;
              }
              i2 = paramInt1;
              if (i6 != 2) {
                break;
              }
              i1 = a(paramT, paramArrayOfByte, i5, paramInt2, paramInt1, l1, paramRegisters);
              i2 = i1;
              if (i1 == i5) {
                break label1034;
              }
            }
            paramInt1 = i2;
            break label1038;
            i1 = a(paramT, paramArrayOfByte, i5, paramInt2, i4, i3, i6, i2, i7, l1, paramInt1, paramRegisters);
            i2 = i1;
          } while (i1 != i5);
        }
        label993:
        i1 = i2;
      }
      label1038:
      i1 = ArrayDecoders.a(i4, paramArrayOfByte, i1, paramInt2, c(paramT), paramRegisters);
      label1056:
      i2 = i3;
    }
    if (i1 == i5) {
      return i1;
    }
    paramT = InvalidProtocolBufferException.parseFailure();
    for (;;)
    {
      throw paramT;
    }
  }
  
  private Object b(int paramInt)
  {
    return this.d[(paramInt / 3 * 2)];
  }
  
  private void b(T paramT, int paramInt)
  {
    if (this.j) {
      return;
    }
    paramInt = f(paramInt);
    long l1 = paramInt & 0xFFFFF;
    UnsafeUtil.a(paramT, l1, UnsafeUtil.a(paramT, l1) | 1 << (paramInt >>> 20));
  }
  
  private void b(Object paramObject, int paramInt, Reader paramReader)
  {
    if (i(paramInt))
    {
      paramReader.j(this.p.a(paramObject, j(paramInt)));
      return;
    }
    paramReader.i(this.p.a(paramObject, j(paramInt)));
  }
  
  private void b(T paramT, Writer paramWriter)
  {
    if (this.h)
    {
      localObject1 = this.r.a(paramT);
      if (!((FieldSet)localObject1).c())
      {
        localIterator = ((FieldSet)localObject1).i();
        localObject1 = (Map.Entry)localIterator.next();
        break label53;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = null;
    label53:
    int i1 = -1;
    int i6 = this.c.length;
    Unsafe localUnsafe = b;
    int i2 = 0;
    int i3 = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i2 >= i6) {
        break;
      }
      int i8 = e(i2);
      int i7 = d(i2);
      int i9 = g(i8);
      int i5;
      int i4;
      if ((!this.j) && (i9 <= 17))
      {
        i5 = this.c[(i2 + 2)];
        i4 = i5 & 0xFFFFF;
        if (i4 != i1)
        {
          i3 = localUnsafe.getInt(paramT, i4);
          i1 = i4;
        }
        i5 = 1 << (i5 >>> 20);
        i4 = i1;
      }
      else
      {
        i5 = 0;
        i4 = i1;
      }
      for (;;)
      {
        i1 = i2;
        if ((localObject1 == null) || (this.r.a((Map.Entry)localObject1) > i7)) {
          break;
        }
        this.r.a(paramWriter, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      long l1 = j(i8);
      switch (i9)
      {
      }
      for (;;)
      {
        break;
        i2 = i1;
        if (c(paramT, i7, i2))
        {
          paramWriter.b(i7, localUnsafe.getObject(paramT, l1), a(i2));
          continue;
          if (c(paramT, i7, i1))
          {
            paramWriter.d(i7, j(paramT, l1));
            continue;
            if (c(paramT, i7, i1))
            {
              paramWriter.f(i7, i(paramT, l1));
              continue;
              if (c(paramT, i7, i1))
              {
                paramWriter.b(i7, j(paramT, l1));
                continue;
                if (c(paramT, i7, i1))
                {
                  paramWriter.a(i7, i(paramT, l1));
                  continue;
                  if (c(paramT, i7, i1))
                  {
                    paramWriter.b(i7, i(paramT, l1));
                    continue;
                    if (c(paramT, i7, i1))
                    {
                      paramWriter.d(i7, i(paramT, l1));
                      continue;
                      if (c(paramT, i7, i1))
                      {
                        paramWriter.a(i7, (ByteString)localUnsafe.getObject(paramT, l1));
                        continue;
                        i2 = i1;
                        if (c(paramT, i7, i2))
                        {
                          paramWriter.a(i7, localUnsafe.getObject(paramT, l1), a(i2));
                          continue;
                          if (c(paramT, i7, i1))
                          {
                            a(i7, localUnsafe.getObject(paramT, l1), paramWriter);
                            continue;
                            if (c(paramT, i7, i1))
                            {
                              paramWriter.a(i7, k(paramT, l1));
                              continue;
                              if (c(paramT, i7, i1))
                              {
                                paramWriter.g(i7, i(paramT, l1));
                                continue;
                                if (c(paramT, i7, i1))
                                {
                                  paramWriter.e(i7, j(paramT, l1));
                                  continue;
                                  if (c(paramT, i7, i1))
                                  {
                                    paramWriter.e(i7, i(paramT, l1));
                                    continue;
                                    if (c(paramT, i7, i1))
                                    {
                                      paramWriter.c(i7, j(paramT, l1));
                                      continue;
                                      if (c(paramT, i7, i1))
                                      {
                                        paramWriter.a(i7, j(paramT, l1));
                                        continue;
                                        if (c(paramT, i7, i1))
                                        {
                                          paramWriter.a(i7, h(paramT, l1));
                                          continue;
                                          if (c(paramT, i7, i1))
                                          {
                                            paramWriter.a(i7, g(paramT, l1));
                                            continue;
                                            a(paramWriter, i7, localUnsafe.getObject(paramT, l1), i1);
                                            continue;
                                            i2 = i1;
                                            SchemaUtil.b(d(i2), (List)localUnsafe.getObject(paramT, l1), paramWriter, a(i2));
                                            continue;
                                            SchemaUtil.e(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.j(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.g(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.l(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.m(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.i(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.n(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.k(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.f(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.h(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.d(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.c(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.b(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.a(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, true);
                                            continue;
                                            SchemaUtil.e(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.j(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.g(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.l(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.m(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.i(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            continue;
                                            SchemaUtil.b(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter);
                                            continue;
                                            i2 = i1;
                                            SchemaUtil.a(d(i2), (List)localUnsafe.getObject(paramT, l1), paramWriter, a(i2));
                                            continue;
                                            SchemaUtil.a(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter);
                                            continue;
                                            SchemaUtil.n(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.k(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.f(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.h(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.d(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.c(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.b(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            SchemaUtil.a(d(i1), (List)localUnsafe.getObject(paramT, l1), paramWriter, false);
                                            break;
                                            if ((i5 & i3) != 0)
                                            {
                                              paramWriter.b(i7, localUnsafe.getObject(paramT, l1), a(i1));
                                              break;
                                              if ((i5 & i3) != 0)
                                              {
                                                paramWriter.d(i7, localUnsafe.getLong(paramT, l1));
                                                break;
                                                if ((i5 & i3) != 0)
                                                {
                                                  paramWriter.f(i7, localUnsafe.getInt(paramT, l1));
                                                  break;
                                                  if ((i5 & i3) != 0)
                                                  {
                                                    paramWriter.b(i7, localUnsafe.getLong(paramT, l1));
                                                    break;
                                                    if ((i5 & i3) != 0)
                                                    {
                                                      paramWriter.a(i7, localUnsafe.getInt(paramT, l1));
                                                      break;
                                                      if ((i5 & i3) != 0)
                                                      {
                                                        paramWriter.b(i7, localUnsafe.getInt(paramT, l1));
                                                        break;
                                                        if ((i5 & i3) != 0)
                                                        {
                                                          paramWriter.d(i7, localUnsafe.getInt(paramT, l1));
                                                          break;
                                                          if ((i5 & i3) != 0)
                                                          {
                                                            paramWriter.a(i7, (ByteString)localUnsafe.getObject(paramT, l1));
                                                            break;
                                                            if ((i5 & i3) != 0)
                                                            {
                                                              paramWriter.a(i7, localUnsafe.getObject(paramT, l1), a(i1));
                                                              break;
                                                              if ((i5 & i3) != 0)
                                                              {
                                                                a(i7, localUnsafe.getObject(paramT, l1), paramWriter);
                                                                break;
                                                                if ((i5 & i3) != 0)
                                                                {
                                                                  paramWriter.a(i7, f(paramT, l1));
                                                                  break;
                                                                  if ((i5 & i3) != 0)
                                                                  {
                                                                    paramWriter.g(i7, localUnsafe.getInt(paramT, l1));
                                                                    break;
                                                                    if ((i5 & i3) != 0)
                                                                    {
                                                                      paramWriter.e(i7, localUnsafe.getLong(paramT, l1));
                                                                      break;
                                                                      if ((i5 & i3) != 0)
                                                                      {
                                                                        paramWriter.e(i7, localUnsafe.getInt(paramT, l1));
                                                                        break;
                                                                        if ((i5 & i3) != 0)
                                                                        {
                                                                          paramWriter.c(i7, localUnsafe.getLong(paramT, l1));
                                                                          break;
                                                                          if ((i5 & i3) != 0)
                                                                          {
                                                                            paramWriter.a(i7, localUnsafe.getLong(paramT, l1));
                                                                            break;
                                                                            if ((i5 & i3) != 0)
                                                                            {
                                                                              paramWriter.a(i7, c(paramT, l1));
                                                                              break;
                                                                              if ((i5 & i3) != 0) {
                                                                                paramWriter.a(i7, b(paramT, l1));
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      i2 = i1 + 3;
      i1 = i4;
    }
    while (localObject2 != null)
    {
      this.r.a(paramWriter, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    a(this.q, paramT, paramWriter);
  }
  
  private void b(T paramT1, T paramT2, int paramInt)
  {
    int i1 = e(paramInt);
    long l1 = j(i1);
    int i2 = d(paramInt);
    switch (g(i1))
    {
    default: 
    case 68: 
      d(paramT1, paramT2, paramInt);
      return;
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
      if (c(paramT2, i2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.f(paramT2, l1));
        d(paramT1, i2, paramInt);
        return;
      }
      break;
    case 60: 
      d(paramT1, paramT2, paramInt);
      return;
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
      if (c(paramT2, i2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.f(paramT2, l1));
        d(paramT1, i2, paramInt);
        return;
      }
      break;
    case 50: 
      SchemaUtil.a(this.s, paramT1, paramT2, l1);
      return;
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
      this.p.a(paramT1, paramT2, l1);
      return;
    case 17: 
      c(paramT1, paramT2, paramInt);
      return;
    case 16: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.b(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 15: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 14: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.b(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 13: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 12: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 11: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 10: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.f(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 9: 
      c(paramT1, paramT2, paramInt);
      return;
    case 8: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.f(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 7: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.c(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 6: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 5: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.b(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 4: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.a(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 3: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.b(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 2: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.b(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 1: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.d(paramT2, l1));
        b(paramT1, paramInt);
        return;
      }
      break;
    case 0: 
      if (a(paramT2, paramInt))
      {
        UnsafeUtil.a(paramT1, l1, UnsafeUtil.e(paramT2, l1));
        b(paramT1, paramInt);
      }
      break;
    }
  }
  
  private boolean b(T paramT, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.s.b(UnsafeUtil.f(paramT, j(paramInt1)));
    if (((Map)localObject1).isEmpty()) {
      return true;
    }
    paramT = b(paramInt2);
    if (this.s.f(paramT).e.getJavaType() != WireFormat.JavaType.MESSAGE) {
      return true;
    }
    paramT = null;
    Iterator localIterator = ((Map)localObject1).values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      localObject1 = paramT;
      if (paramT == null) {
        localObject1 = Protobuf.a().a(localObject2.getClass());
      }
      paramT = (TT)localObject1;
      if (!((Schema)localObject1).e(localObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private static <T> float c(T paramT, long paramLong)
  {
    return UnsafeUtil.d(paramT, paramLong);
  }
  
  private Internal.EnumVerifier c(int paramInt)
  {
    return (Internal.EnumVerifier)this.d[(paramInt / 3 * 2 + 1)];
  }
  
  static UnknownFieldSetLite c(Object paramObject)
  {
    GeneratedMessageLite localGeneratedMessageLite = (GeneratedMessageLite)paramObject;
    UnknownFieldSetLite localUnknownFieldSetLite = localGeneratedMessageLite.a;
    paramObject = localUnknownFieldSetLite;
    if (localUnknownFieldSetLite == UnknownFieldSetLite.a())
    {
      paramObject = UnknownFieldSetLite.b();
      localGeneratedMessageLite.a = paramObject;
    }
    return paramObject;
  }
  
  private void c(T paramT, Writer paramWriter)
  {
    if (this.h)
    {
      localObject1 = this.r.a(paramT);
      if (!((FieldSet)localObject1).c())
      {
        localIterator = ((FieldSet)localObject1).i();
        localObject1 = (Map.Entry)localIterator.next();
        break label54;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = localIterator;
    label54:
    int i2 = this.c.length;
    int i1 = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i1 >= i2) {
        break;
      }
      int i3 = e(i1);
      int i4 = d(i1);
      while ((localObject1 != null) && (this.r.a((Map.Entry)localObject1) <= i4))
      {
        this.r.a(paramWriter, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      switch (g(i3))
      {
      default: 
        break;
      case 68: 
        if (c(paramT, i4, i1)) {
          paramWriter.b(i4, UnsafeUtil.f(paramT, j(i3)), a(i1));
        }
        break;
      case 67: 
        if (c(paramT, i4, i1)) {
          paramWriter.d(i4, j(paramT, j(i3)));
        }
        break;
      case 66: 
        if (c(paramT, i4, i1)) {
          paramWriter.f(i4, i(paramT, j(i3)));
        }
        break;
      case 65: 
        if (c(paramT, i4, i1)) {
          paramWriter.b(i4, j(paramT, j(i3)));
        }
        break;
      case 64: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, i(paramT, j(i3)));
        }
        break;
      case 63: 
        if (c(paramT, i4, i1)) {
          paramWriter.b(i4, i(paramT, j(i3)));
        }
        break;
      case 62: 
        if (c(paramT, i4, i1)) {
          paramWriter.d(i4, i(paramT, j(i3)));
        }
        break;
      case 61: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, (ByteString)UnsafeUtil.f(paramT, j(i3)));
        }
        break;
      case 60: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, UnsafeUtil.f(paramT, j(i3)), a(i1));
        }
        break;
      case 59: 
        if (c(paramT, i4, i1)) {
          a(i4, UnsafeUtil.f(paramT, j(i3)), paramWriter);
        }
        break;
      case 58: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, k(paramT, j(i3)));
        }
        break;
      case 57: 
        if (c(paramT, i4, i1)) {
          paramWriter.g(i4, i(paramT, j(i3)));
        }
        break;
      case 56: 
        if (c(paramT, i4, i1)) {
          paramWriter.e(i4, j(paramT, j(i3)));
        }
        break;
      case 55: 
        if (c(paramT, i4, i1)) {
          paramWriter.e(i4, i(paramT, j(i3)));
        }
        break;
      case 54: 
        if (c(paramT, i4, i1)) {
          paramWriter.c(i4, j(paramT, j(i3)));
        }
        break;
      case 53: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, j(paramT, j(i3)));
        }
        break;
      case 52: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, h(paramT, j(i3)));
        }
        break;
      case 51: 
        if (c(paramT, i4, i1)) {
          paramWriter.a(i4, g(paramT, j(i3)));
        }
        break;
      case 50: 
        a(paramWriter, i4, UnsafeUtil.f(paramT, j(i3)), i1);
        break;
      case 49: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, a(i1));
        break;
      case 48: 
        SchemaUtil.e(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 47: 
        SchemaUtil.j(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 46: 
        SchemaUtil.g(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 45: 
        SchemaUtil.l(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 44: 
        SchemaUtil.m(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 43: 
        SchemaUtil.i(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 42: 
        SchemaUtil.n(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 41: 
        SchemaUtil.k(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 40: 
        SchemaUtil.f(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 39: 
        SchemaUtil.h(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 38: 
        SchemaUtil.d(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 37: 
        SchemaUtil.c(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 36: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 35: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, true);
        break;
      case 34: 
        SchemaUtil.e(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 33: 
        SchemaUtil.j(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 32: 
        SchemaUtil.g(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 31: 
        SchemaUtil.l(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 30: 
        SchemaUtil.m(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 29: 
        SchemaUtil.i(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 28: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter);
        break;
      case 27: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, a(i1));
        break;
      case 26: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter);
        break;
      case 25: 
        SchemaUtil.n(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 24: 
        SchemaUtil.k(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 23: 
        SchemaUtil.f(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 22: 
        SchemaUtil.h(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 21: 
        SchemaUtil.d(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 20: 
        SchemaUtil.c(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 19: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 18: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i3)), paramWriter, false);
        break;
      case 17: 
        if (a(paramT, i1)) {
          paramWriter.b(i4, UnsafeUtil.f(paramT, j(i3)), a(i1));
        }
        break;
      case 16: 
        if (a(paramT, i1)) {
          paramWriter.d(i4, e(paramT, j(i3)));
        }
        break;
      case 15: 
        if (a(paramT, i1)) {
          paramWriter.f(i4, d(paramT, j(i3)));
        }
        break;
      case 14: 
        if (a(paramT, i1)) {
          paramWriter.b(i4, e(paramT, j(i3)));
        }
        break;
      case 13: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, d(paramT, j(i3)));
        }
        break;
      case 12: 
        if (a(paramT, i1)) {
          paramWriter.b(i4, d(paramT, j(i3)));
        }
        break;
      case 11: 
        if (a(paramT, i1)) {
          paramWriter.d(i4, d(paramT, j(i3)));
        }
        break;
      case 10: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, (ByteString)UnsafeUtil.f(paramT, j(i3)));
        }
        break;
      case 9: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, UnsafeUtil.f(paramT, j(i3)), a(i1));
        }
        break;
      case 8: 
        if (a(paramT, i1)) {
          a(i4, UnsafeUtil.f(paramT, j(i3)), paramWriter);
        }
        break;
      case 7: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, f(paramT, j(i3)));
        }
        break;
      case 6: 
        if (a(paramT, i1)) {
          paramWriter.g(i4, d(paramT, j(i3)));
        }
        break;
      case 5: 
        if (a(paramT, i1)) {
          paramWriter.e(i4, e(paramT, j(i3)));
        }
        break;
      case 4: 
        if (a(paramT, i1)) {
          paramWriter.e(i4, d(paramT, j(i3)));
        }
        break;
      case 3: 
        if (a(paramT, i1)) {
          paramWriter.c(i4, e(paramT, j(i3)));
        }
        break;
      case 2: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, e(paramT, j(i3)));
        }
        break;
      case 1: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, c(paramT, j(i3)));
        }
        break;
      case 0: 
        if (a(paramT, i1)) {
          paramWriter.a(i4, b(paramT, j(i3)));
        }
        break;
      }
      i1 += 3;
    }
    while (localObject2 != null)
    {
      this.r.a(paramWriter, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    a(this.q, paramT, paramWriter);
  }
  
  private void c(T paramT1, T paramT2, int paramInt)
  {
    long l1 = j(e(paramInt));
    if (!a(paramT2, paramInt)) {
      return;
    }
    Object localObject = UnsafeUtil.f(paramT1, l1);
    paramT2 = UnsafeUtil.f(paramT2, l1);
    if ((localObject != null) && (paramT2 != null))
    {
      UnsafeUtil.a(paramT1, l1, Internal.a(localObject, paramT2));
      b(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      UnsafeUtil.a(paramT1, l1, paramT2);
      b(paramT1, paramInt);
    }
  }
  
  private boolean c(T paramT, int paramInt1, int paramInt2)
  {
    return UnsafeUtil.a(paramT, f(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private int d(int paramInt)
  {
    return this.c[paramInt];
  }
  
  private static <T> int d(T paramT, long paramLong)
  {
    return UnsafeUtil.a(paramT, paramLong);
  }
  
  private void d(T paramT, int paramInt1, int paramInt2)
  {
    UnsafeUtil.a(paramT, f(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private void d(T paramT, Writer paramWriter)
  {
    a(this.q, paramT, paramWriter);
    if (this.h)
    {
      localObject1 = this.r.a(paramT);
      if (!((FieldSet)localObject1).c())
      {
        localIterator = ((FieldSet)localObject1).j();
        localObject1 = (Map.Entry)localIterator.next();
        break label64;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = localIterator;
    label64:
    int i1 = this.c.length - 3;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i1 < 0) {
        break;
      }
      int i2 = e(i1);
      int i3 = d(i1);
      while ((localObject1 != null) && (this.r.a((Map.Entry)localObject1) > i3))
      {
        this.r.a(paramWriter, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      switch (g(i2))
      {
      default: 
        break;
      case 68: 
        if (c(paramT, i3, i1)) {
          paramWriter.b(i3, UnsafeUtil.f(paramT, j(i2)), a(i1));
        }
        break;
      case 67: 
        if (c(paramT, i3, i1)) {
          paramWriter.d(i3, j(paramT, j(i2)));
        }
        break;
      case 66: 
        if (c(paramT, i3, i1)) {
          paramWriter.f(i3, i(paramT, j(i2)));
        }
        break;
      case 65: 
        if (c(paramT, i3, i1)) {
          paramWriter.b(i3, j(paramT, j(i2)));
        }
        break;
      case 64: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, i(paramT, j(i2)));
        }
        break;
      case 63: 
        if (c(paramT, i3, i1)) {
          paramWriter.b(i3, i(paramT, j(i2)));
        }
        break;
      case 62: 
        if (c(paramT, i3, i1)) {
          paramWriter.d(i3, i(paramT, j(i2)));
        }
        break;
      case 61: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, (ByteString)UnsafeUtil.f(paramT, j(i2)));
        }
        break;
      case 60: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, UnsafeUtil.f(paramT, j(i2)), a(i1));
        }
        break;
      case 59: 
        if (c(paramT, i3, i1)) {
          a(i3, UnsafeUtil.f(paramT, j(i2)), paramWriter);
        }
        break;
      case 58: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, k(paramT, j(i2)));
        }
        break;
      case 57: 
        if (c(paramT, i3, i1)) {
          paramWriter.g(i3, i(paramT, j(i2)));
        }
        break;
      case 56: 
        if (c(paramT, i3, i1)) {
          paramWriter.e(i3, j(paramT, j(i2)));
        }
        break;
      case 55: 
        if (c(paramT, i3, i1)) {
          paramWriter.e(i3, i(paramT, j(i2)));
        }
        break;
      case 54: 
        if (c(paramT, i3, i1)) {
          paramWriter.c(i3, j(paramT, j(i2)));
        }
        break;
      case 53: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, j(paramT, j(i2)));
        }
        break;
      case 52: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, h(paramT, j(i2)));
        }
        break;
      case 51: 
        if (c(paramT, i3, i1)) {
          paramWriter.a(i3, g(paramT, j(i2)));
        }
        break;
      case 50: 
        a(paramWriter, i3, UnsafeUtil.f(paramT, j(i2)), i1);
        break;
      case 49: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, a(i1));
        break;
      case 48: 
        SchemaUtil.e(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 47: 
        SchemaUtil.j(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 46: 
        SchemaUtil.g(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 45: 
        SchemaUtil.l(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 44: 
        SchemaUtil.m(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 43: 
        SchemaUtil.i(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 42: 
        SchemaUtil.n(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 41: 
        SchemaUtil.k(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 40: 
        SchemaUtil.f(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 39: 
        SchemaUtil.h(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 38: 
        SchemaUtil.d(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 37: 
        SchemaUtil.c(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 36: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 35: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, true);
        break;
      case 34: 
        SchemaUtil.e(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 33: 
        SchemaUtil.j(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 32: 
        SchemaUtil.g(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 31: 
        SchemaUtil.l(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 30: 
        SchemaUtil.m(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 29: 
        SchemaUtil.i(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 28: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter);
        break;
      case 27: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, a(i1));
        break;
      case 26: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter);
        break;
      case 25: 
        SchemaUtil.n(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 24: 
        SchemaUtil.k(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 23: 
        SchemaUtil.f(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 22: 
        SchemaUtil.h(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 21: 
        SchemaUtil.d(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 20: 
        SchemaUtil.c(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 19: 
        SchemaUtil.b(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 18: 
        SchemaUtil.a(d(i1), (List)UnsafeUtil.f(paramT, j(i2)), paramWriter, false);
        break;
      case 17: 
        if (a(paramT, i1)) {
          paramWriter.b(i3, UnsafeUtil.f(paramT, j(i2)), a(i1));
        }
        break;
      case 16: 
        if (a(paramT, i1)) {
          paramWriter.d(i3, e(paramT, j(i2)));
        }
        break;
      case 15: 
        if (a(paramT, i1)) {
          paramWriter.f(i3, d(paramT, j(i2)));
        }
        break;
      case 14: 
        if (a(paramT, i1)) {
          paramWriter.b(i3, e(paramT, j(i2)));
        }
        break;
      case 13: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, d(paramT, j(i2)));
        }
        break;
      case 12: 
        if (a(paramT, i1)) {
          paramWriter.b(i3, d(paramT, j(i2)));
        }
        break;
      case 11: 
        if (a(paramT, i1)) {
          paramWriter.d(i3, d(paramT, j(i2)));
        }
        break;
      case 10: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, (ByteString)UnsafeUtil.f(paramT, j(i2)));
        }
        break;
      case 9: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, UnsafeUtil.f(paramT, j(i2)), a(i1));
        }
        break;
      case 8: 
        if (a(paramT, i1)) {
          a(i3, UnsafeUtil.f(paramT, j(i2)), paramWriter);
        }
        break;
      case 7: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, f(paramT, j(i2)));
        }
        break;
      case 6: 
        if (a(paramT, i1)) {
          paramWriter.g(i3, d(paramT, j(i2)));
        }
        break;
      case 5: 
        if (a(paramT, i1)) {
          paramWriter.e(i3, e(paramT, j(i2)));
        }
        break;
      case 4: 
        if (a(paramT, i1)) {
          paramWriter.e(i3, d(paramT, j(i2)));
        }
        break;
      case 3: 
        if (a(paramT, i1)) {
          paramWriter.c(i3, e(paramT, j(i2)));
        }
        break;
      case 2: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, e(paramT, j(i2)));
        }
        break;
      case 1: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, c(paramT, j(i2)));
        }
        break;
      case 0: 
        if (a(paramT, i1)) {
          paramWriter.a(i3, b(paramT, j(i2)));
        }
        break;
      }
      i1 -= 3;
    }
    while (localObject2 != null)
    {
      this.r.a(paramWriter, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
  }
  
  private void d(T paramT1, T paramT2, int paramInt)
  {
    int i1 = e(paramInt);
    int i2 = d(paramInt);
    long l1 = j(i1);
    if (!c(paramT2, i2, paramInt)) {
      return;
    }
    Object localObject = UnsafeUtil.f(paramT1, l1);
    paramT2 = UnsafeUtil.f(paramT2, l1);
    if ((localObject != null) && (paramT2 != null))
    {
      UnsafeUtil.a(paramT1, l1, Internal.a(localObject, paramT2));
      d(paramT1, i2, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      UnsafeUtil.a(paramT1, l1, paramT2);
      d(paramT1, i2, paramInt);
    }
  }
  
  private int e(int paramInt)
  {
    return this.c[(paramInt + 1)];
  }
  
  private static <T> long e(T paramT, long paramLong)
  {
    return UnsafeUtil.b(paramT, paramLong);
  }
  
  private boolean e(T paramT1, T paramT2, int paramInt)
  {
    return a(paramT1, paramInt) == a(paramT2, paramInt);
  }
  
  private int f(int paramInt)
  {
    return this.c[(paramInt + 2)];
  }
  
  private int f(T paramT)
  {
    Unsafe localUnsafe = b;
    int i4 = 0;
    int i5 = 0;
    int i1 = -1;
    int i7;
    for (int i2 = 0; i4 < this.c.length; i2 = i7)
    {
      int i10 = e(i4);
      int i9 = d(i4);
      int i11 = g(i10);
      int i8;
      int i6;
      int i3;
      if (i11 <= 17)
      {
        i8 = this.c[(i4 + 2)];
        i6 = 0xFFFFF & i8;
        i3 = i1;
        if (i6 != i1)
        {
          i2 = localUnsafe.getInt(paramT, i6);
          i3 = i6;
        }
        i1 = 1 << (i8 >>> 20);
        i6 = i3;
        i7 = i2;
        i3 = i8;
        i8 = i1;
      }
      else
      {
        if ((this.k) && (i11 >= FieldType.DOUBLE_LIST_PACKED.id()) && (i11 <= FieldType.SINT64_LIST_PACKED.id())) {
          i3 = this.c[(i4 + 2)] & 0xFFFFF;
        } else {
          i3 = 0;
        }
        i8 = 0;
        i7 = i2;
        i6 = i1;
      }
      long l1 = j(i10);
      Object localObject;
      switch (i11)
      {
      default: 
        i1 = i5;
        break;
      case 68: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.d(i9, (MessageLite)localUnsafe.getObject(paramT, l1), a(i4));
        break;
      case 67: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.h(i9, j(paramT, l1));
        break;
      case 66: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.j(i9, i(paramT, l1));
        break;
      case 65: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.j(i9, 0L);
        break;
      case 64: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.l(i9, 0);
        break;
      case 63: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.m(i9, i(paramT, l1));
        break;
      case 62: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.i(i9, i(paramT, l1));
        break;
      case 61: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.c(i9, (ByteString)localUnsafe.getObject(paramT, l1));
        break;
      case 60: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = SchemaUtil.a(i9, localUnsafe.getObject(paramT, l1), a(i4));
        break;
      case 59: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        localObject = localUnsafe.getObject(paramT, l1);
        if ((localObject instanceof ByteString)) {
          i1 = CodedOutputStream.c(i9, (ByteString)localObject);
        } else {
          i1 = CodedOutputStream.b(i9, (String)localObject);
        }
        break;
      case 58: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.b(i9, true);
        break;
      case 57: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.k(i9, 0);
        break;
      case 56: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.i(i9, 0L);
        break;
      case 55: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.h(i9, i(paramT, l1));
        break;
      case 54: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.g(i9, j(paramT, l1));
        break;
      case 53: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.f(i9, j(paramT, l1));
        break;
      case 52: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.b(i9, 0.0F);
        break;
      case 51: 
        i1 = i5;
        if (!c(paramT, i9, i4)) {
          break label2819;
        }
        i1 = CodedOutputStream.b(i9, 0.0D);
        break;
      case 50: 
        i1 = this.s.a(i9, localUnsafe.getObject(paramT, l1), b(i4));
        break;
      case 49: 
        i1 = SchemaUtil.b(i9, (List)localUnsafe.getObject(paramT, l1), a(i4));
        break;
      case 48: 
        i2 = SchemaUtil.c((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 47: 
        i2 = SchemaUtil.g((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 46: 
        i2 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 45: 
        i2 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 44: 
        i2 = SchemaUtil.d((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 43: 
        i2 = SchemaUtil.f((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 42: 
        i2 = SchemaUtil.j((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 41: 
        i2 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 40: 
        i2 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 39: 
        i2 = SchemaUtil.e((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 38: 
        i2 = SchemaUtil.b((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 37: 
        i2 = SchemaUtil.a((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 36: 
        i2 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i2 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i2);
        }
        i8 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i2);
        i1 = i2;
        i2 = i8;
        break;
      case 35: 
        i8 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i1 = i5;
        if (i8 <= 0) {
          break label2819;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i3, i8);
        }
        i2 = CodedOutputStream.h(i9);
        i3 = CodedOutputStream.j(i8);
        i1 = i8;
        i1 = i5 + (i2 + i3 + i1);
        break;
      case 34: 
        i1 = SchemaUtil.c(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 33: 
        i1 = SchemaUtil.g(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 32: 
        i1 = SchemaUtil.i(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 31: 
        i1 = SchemaUtil.h(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 30: 
        i1 = SchemaUtil.d(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 29: 
        i1 = SchemaUtil.f(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 28: 
        i1 = SchemaUtil.b(i9, (List)localUnsafe.getObject(paramT, l1));
        break;
      case 27: 
        i1 = SchemaUtil.a(i9, (List)localUnsafe.getObject(paramT, l1), a(i4));
        break;
      case 26: 
        i1 = SchemaUtil.a(i9, (List)localUnsafe.getObject(paramT, l1));
        break;
      case 25: 
        i1 = SchemaUtil.j(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 24: 
        i1 = SchemaUtil.h(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 23: 
        i1 = SchemaUtil.i(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 22: 
        i1 = SchemaUtil.e(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 21: 
        i1 = SchemaUtil.b(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 20: 
        i1 = SchemaUtil.a(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 19: 
        i1 = SchemaUtil.h(i9, (List)localUnsafe.getObject(paramT, l1), false);
        break;
      case 18: 
        i1 = SchemaUtil.i(i9, (List)localUnsafe.getObject(paramT, l1), false);
      }
      for (;;)
      {
        i1 = i5 + i1;
        break;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.d(i9, (MessageLite)localUnsafe.getObject(paramT, l1), a(i4));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.h(i9, localUnsafe.getLong(paramT, l1));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.j(i9, localUnsafe.getInt(paramT, l1));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.j(i9, 0L);
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.l(i9, 0);
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.m(i9, localUnsafe.getInt(paramT, l1));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.i(i9, localUnsafe.getInt(paramT, l1));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = CodedOutputStream.c(i9, (ByteString)localUnsafe.getObject(paramT, l1));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        i1 = SchemaUtil.a(i9, localUnsafe.getObject(paramT, l1), a(i4));
        continue;
        i1 = i5;
        if ((i7 & i8) == 0) {
          break;
        }
        localObject = localUnsafe.getObject(paramT, l1);
        if ((localObject instanceof ByteString))
        {
          i1 = CodedOutputStream.c(i9, (ByteString)localObject);
        }
        else
        {
          i1 = CodedOutputStream.b(i9, (String)localObject);
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.b(i9, true);
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.k(i9, 0);
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.i(i9, 0L);
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.h(i9, localUnsafe.getInt(paramT, l1));
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.g(i9, localUnsafe.getLong(paramT, l1));
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.f(i9, localUnsafe.getLong(paramT, l1));
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.b(i9, 0.0F);
          continue;
          i1 = i5;
          if ((i7 & i8) == 0) {
            break;
          }
          i1 = CodedOutputStream.b(i9, 0.0D);
        }
      }
      label2819:
      i4 += 3;
      i5 = i1;
      i1 = i6;
    }
    i2 = i5 + a(this.q, paramT);
    i1 = i2;
    if (this.h) {
      i1 = i2 + this.r.a(paramT).l();
    }
    return i1;
  }
  
  private static <T> boolean f(T paramT, long paramLong)
  {
    return UnsafeUtil.c(paramT, paramLong);
  }
  
  private boolean f(T paramT1, T paramT2, int paramInt)
  {
    long l1 = f(paramInt) & 0xFFFFF;
    return UnsafeUtil.a(paramT1, l1) == UnsafeUtil.a(paramT2, l1);
  }
  
  private static <T> double g(T paramT, long paramLong)
  {
    return ((Double)UnsafeUtil.f(paramT, paramLong)).doubleValue();
  }
  
  private static int g(int paramInt)
  {
    return (paramInt & 0xFF00000) >>> 20;
  }
  
  private int g(T paramT)
  {
    Unsafe localUnsafe = b;
    int i4 = 0;
    int i2;
    for (int i5 = 0; i4 < this.c.length; i5 = i2)
    {
      int i1 = e(i4);
      i2 = g(i1);
      int i7 = d(i4);
      long l1 = j(i1);
      if ((i2 >= FieldType.DOUBLE_LIST_PACKED.id()) && (i2 <= FieldType.SINT64_LIST_PACKED.id())) {
        i1 = this.c[(i4 + 2)] & 0xFFFFF;
      } else {
        i1 = 0;
      }
      Object localObject;
      int i3;
      int i6;
      switch (i2)
      {
      default: 
        i2 = i5;
        break;
      case 68: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.d(i7, (MessageLite)UnsafeUtil.f(paramT, l1), a(i4));
        break;
      case 67: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.h(i7, j(paramT, l1));
        break;
      case 66: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.j(i7, i(paramT, l1));
        break;
      case 65: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.j(i7, 0L);
        break;
      case 64: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.l(i7, 0);
        break;
      case 63: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.m(i7, i(paramT, l1));
        break;
      case 62: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.i(i7, i(paramT, l1));
        break;
      case 61: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.c(i7, (ByteString)UnsafeUtil.f(paramT, l1));
        break;
      case 60: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = SchemaUtil.a(i7, UnsafeUtil.f(paramT, l1), a(i4));
        break;
      case 59: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        localObject = UnsafeUtil.f(paramT, l1);
        if ((localObject instanceof ByteString)) {
          i1 = CodedOutputStream.c(i7, (ByteString)localObject);
        } else {
          i1 = CodedOutputStream.b(i7, (String)localObject);
        }
        break;
      case 58: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.b(i7, true);
        break;
      case 57: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.k(i7, 0);
        break;
      case 56: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.i(i7, 0L);
        break;
      case 55: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.h(i7, i(paramT, l1));
        break;
      case 54: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.g(i7, j(paramT, l1));
        break;
      case 53: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.f(i7, j(paramT, l1));
        break;
      case 52: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.b(i7, 0.0F);
        break;
      case 51: 
        i2 = i5;
        if (!c(paramT, i7, i4)) {
          break label2677;
        }
        i1 = CodedOutputStream.b(i7, 0.0D);
        break;
      case 50: 
        i1 = this.s.a(i7, UnsafeUtil.f(paramT, l1), b(i4));
        break;
      case 49: 
        i1 = SchemaUtil.b(i7, a(paramT, l1), a(i4));
        break;
      case 48: 
        i3 = SchemaUtil.c((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 47: 
        i3 = SchemaUtil.g((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 46: 
        i3 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 45: 
        i3 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 44: 
        i3 = SchemaUtil.d((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 43: 
        i3 = SchemaUtil.f((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 42: 
        i3 = SchemaUtil.j((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 41: 
        i3 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 40: 
        i3 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 39: 
        i3 = SchemaUtil.e((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 38: 
        i3 = SchemaUtil.b((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 37: 
        i3 = SchemaUtil.a((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 36: 
        i3 = SchemaUtil.h((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i3 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i3);
        }
        i1 = CodedOutputStream.h(i7);
        i6 = CodedOutputStream.j(i3);
        i2 = i3;
        i3 = i6;
        break;
      case 35: 
        i6 = SchemaUtil.i((List)localUnsafe.getObject(paramT, l1));
        i2 = i5;
        if (i6 <= 0) {
          break label2677;
        }
        if (this.k) {
          localUnsafe.putInt(paramT, i1, i6);
        }
        i1 = CodedOutputStream.h(i7);
        i3 = CodedOutputStream.j(i6);
        i2 = i6;
        i1 = i1 + i3 + i2;
        break;
      case 34: 
        i1 = SchemaUtil.c(i7, a(paramT, l1), false);
        break;
      case 33: 
        i1 = SchemaUtil.g(i7, a(paramT, l1), false);
        break;
      case 32: 
        i1 = SchemaUtil.i(i7, a(paramT, l1), false);
        break;
      case 31: 
        i1 = SchemaUtil.h(i7, a(paramT, l1), false);
        break;
      case 30: 
        i1 = SchemaUtil.d(i7, a(paramT, l1), false);
        break;
      case 29: 
        i1 = SchemaUtil.f(i7, a(paramT, l1), false);
        break;
      case 28: 
        i1 = SchemaUtil.b(i7, a(paramT, l1));
        break;
      case 27: 
        i1 = SchemaUtil.a(i7, a(paramT, l1), a(i4));
        break;
      case 26: 
        i1 = SchemaUtil.a(i7, a(paramT, l1));
        break;
      case 25: 
        i1 = SchemaUtil.j(i7, a(paramT, l1), false);
        break;
      case 24: 
        i1 = SchemaUtil.h(i7, a(paramT, l1), false);
        break;
      case 23: 
        i1 = SchemaUtil.i(i7, a(paramT, l1), false);
        break;
      case 22: 
        i1 = SchemaUtil.e(i7, a(paramT, l1), false);
        break;
      case 21: 
        i1 = SchemaUtil.b(i7, a(paramT, l1), false);
        break;
      case 20: 
        i1 = SchemaUtil.a(i7, a(paramT, l1), false);
        break;
      case 19: 
        i1 = SchemaUtil.h(i7, a(paramT, l1), false);
        break;
      case 18: 
        i1 = SchemaUtil.i(i7, a(paramT, l1), false);
      }
      for (;;)
      {
        i2 = i5 + i1;
        break;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.d(i7, (MessageLite)UnsafeUtil.f(paramT, l1), a(i4));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.h(i7, UnsafeUtil.b(paramT, l1));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.j(i7, UnsafeUtil.a(paramT, l1));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.j(i7, 0L);
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.l(i7, 0);
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.m(i7, UnsafeUtil.a(paramT, l1));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.i(i7, UnsafeUtil.a(paramT, l1));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = CodedOutputStream.c(i7, (ByteString)UnsafeUtil.f(paramT, l1));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        i1 = SchemaUtil.a(i7, UnsafeUtil.f(paramT, l1), a(i4));
        continue;
        i2 = i5;
        if (!a(paramT, i4)) {
          break;
        }
        localObject = UnsafeUtil.f(paramT, l1);
        if ((localObject instanceof ByteString))
        {
          i1 = CodedOutputStream.c(i7, (ByteString)localObject);
        }
        else
        {
          i1 = CodedOutputStream.b(i7, (String)localObject);
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.b(i7, true);
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.k(i7, 0);
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.i(i7, 0L);
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.h(i7, UnsafeUtil.a(paramT, l1));
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.g(i7, UnsafeUtil.b(paramT, l1));
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.f(i7, UnsafeUtil.b(paramT, l1));
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.b(i7, 0.0F);
          continue;
          i2 = i5;
          if (!a(paramT, i4)) {
            break;
          }
          i1 = CodedOutputStream.b(i7, 0.0D);
        }
      }
      label2677:
      i4 += 3;
    }
    return i5 + a(this.q, paramT);
  }
  
  private static <T> float h(T paramT, long paramLong)
  {
    return ((Float)UnsafeUtil.f(paramT, paramLong)).floatValue();
  }
  
  private static boolean h(int paramInt)
  {
    return (paramInt & 0x10000000) != 0;
  }
  
  private static <T> int i(T paramT, long paramLong)
  {
    return ((Integer)UnsafeUtil.f(paramT, paramLong)).intValue();
  }
  
  private static boolean i(int paramInt)
  {
    return (paramInt & 0x20000000) != 0;
  }
  
  private static long j(int paramInt)
  {
    return paramInt & 0xFFFFF;
  }
  
  private static <T> long j(T paramT, long paramLong)
  {
    return ((Long)UnsafeUtil.f(paramT, paramLong)).longValue();
  }
  
  private int k(int paramInt)
  {
    if ((paramInt >= this.e) && (paramInt <= this.f)) {
      return b(paramInt, 0);
    }
    return -1;
  }
  
  private static <T> boolean k(T paramT, long paramLong)
  {
    return ((Boolean)UnsafeUtil.f(paramT, paramLong)).booleanValue();
  }
  
  public int a(T paramT)
  {
    int i4 = this.c.length;
    int i3 = 0;
    for (int i2 = 0; i3 < i4; i2 = i1)
    {
      i1 = e(i3);
      int i5 = d(i3);
      long l1 = j(i1);
      int i6 = g(i1);
      i1 = 37;
      Object localObject;
      switch (i6)
      {
      default: 
        i1 = i2;
        break;
      case 68: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        localObject = UnsafeUtil.f(paramT, l1);
        i1 = i2 * 53;
        i2 = localObject.hashCode();
        break;
      case 67: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(j(paramT, l1));
        break;
      case 66: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 65: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(j(paramT, l1));
        break;
      case 64: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 63: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 62: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 61: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = UnsafeUtil.f(paramT, l1).hashCode();
        break;
      case 60: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        localObject = UnsafeUtil.f(paramT, l1);
        i1 = i2 * 53;
        i2 = localObject.hashCode();
        break;
      case 59: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = ((String)UnsafeUtil.f(paramT, l1)).hashCode();
        break;
      case 58: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(k(paramT, l1));
        break;
      case 57: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 56: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(j(paramT, l1));
        break;
      case 55: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = i(paramT, l1);
        break;
      case 54: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(j(paramT, l1));
        break;
      case 53: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(j(paramT, l1));
        break;
      case 52: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Float.floatToIntBits(h(paramT, l1));
        break;
      case 51: 
        i1 = i2;
        if (!c(paramT, i5, i3)) {
          break label1281;
        }
        i1 = i2 * 53;
        i2 = Internal.a(Double.doubleToLongBits(g(paramT, l1)));
        break;
      case 50: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.f(paramT, l1).hashCode();
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.f(paramT, l1).hashCode();
        break;
      case 17: 
        localObject = UnsafeUtil.f(paramT, l1);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        break;
      case 16: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.b(paramT, l1));
        break;
      case 15: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 14: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.b(paramT, l1));
        break;
      case 13: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 12: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 11: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 10: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.f(paramT, l1).hashCode();
        break;
      case 9: 
        localObject = UnsafeUtil.f(paramT, l1);
        if (localObject != null) {
          i1 = localObject.hashCode();
        }
        i1 = i2 * 53 + i1;
        break;
      case 8: 
        i1 = i2 * 53;
        i2 = ((String)UnsafeUtil.f(paramT, l1)).hashCode();
        break;
      case 7: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.c(paramT, l1));
        break;
      case 6: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 5: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.b(paramT, l1));
        break;
      case 4: 
        i1 = i2 * 53;
        i2 = UnsafeUtil.a(paramT, l1);
        break;
      case 3: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.b(paramT, l1));
        break;
      case 2: 
        i1 = i2 * 53;
        i2 = Internal.a(UnsafeUtil.b(paramT, l1));
        break;
      case 1: 
        i1 = i2 * 53;
        i2 = Float.floatToIntBits(UnsafeUtil.d(paramT, l1));
        break;
      }
      i1 = i2 * 53;
      i2 = Internal.a(Double.doubleToLongBits(UnsafeUtil.e(paramT, l1)));
      i1 += i2;
      label1281:
      i3 += 3;
    }
    i2 = i2 * 53 + this.q.b(paramT).hashCode();
    int i1 = i2;
    if (this.h) {
      i1 = i2 * 53 + this.r.a(paramT).hashCode();
    }
    return i1;
  }
  
  int a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ArrayDecoders.Registers paramRegisters)
  {
    int i6 = paramInt2;
    int i4 = paramInt3;
    ArrayDecoders.Registers localRegisters = paramRegisters;
    Unsafe localUnsafe = b;
    int i5 = -1;
    int i7 = 0;
    int i3 = 0;
    int i1 = 0;
    int i2 = -1;
    Object localObject1;
    int i10;
    int i8;
    int i11;
    int i12;
    long l1;
    for (;;)
    {
      localObject1 = this;
      T ? = paramT;
      Object localObject2 = paramArrayOfByte;
      if (paramInt1 >= i6) {
        break label1691;
      }
      i3 = paramInt1 + 1;
      paramInt1 = localObject2[paramInt1];
      if (paramInt1 < 0)
      {
        i3 = ArrayDecoders.a(paramInt1, (byte[])localObject2, i3, localRegisters);
        paramInt1 = localRegisters.a;
      }
      i6 = paramInt1 >>> 3;
      i10 = paramInt1 & 0x7;
      if (i6 > i5) {
        i5 = ((MessageSchema)localObject1).a(i6, i7 / 3);
      } else {
        i5 = ((MessageSchema)localObject1).k(i6);
      }
      if (i5 == -1)
      {
        i5 = i3;
        i7 = paramInt1;
        i3 = i1;
        i1 = i2;
        paramInt1 = i4;
        i8 = 0;
        i4 = i5;
        i2 = i7;
        i5 = i8;
        break label1561;
      }
      i11 = localObject1.c[(i5 + 1)];
      i12 = g(i11);
      l1 = j(i11);
      if (i12 <= 17)
      {
        i4 = localObject1.c[(i5 + 2)];
        i7 = 1 << (i4 >>> 20);
        i4 &= 0xFFFFF;
        if (i4 != i2)
        {
          if (i2 != -1) {
            localUnsafe.putInt(?, i2, i1);
          }
          i1 = localUnsafe.getInt(?, i4);
          i2 = i4;
          i4 = i1;
        }
        else
        {
          i4 = i1;
        }
        switch (i12)
        {
        default: 
          break;
        case 17: 
          if (i10 == 3)
          {
            i1 = ArrayDecoders.a(((MessageSchema)localObject1).a(i5), paramArrayOfByte, i3, paramInt2, i6 << 3 | 0x4, paramRegisters);
            if ((i4 & i7) == 0) {
              localUnsafe.putObject(?, l1, localRegisters.c);
            } else {
              localUnsafe.putObject(?, l1, Internal.a(localUnsafe.getObject(?, l1), localRegisters.c));
            }
            i4 |= i7;
          }
          break;
        case 16: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.b(paramArrayOfByte, i3, localRegisters);
            localUnsafe.putLong(paramT, l1, CodedInputStream.a(localRegisters.b));
          }
          break;
        case 15: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.a(paramArrayOfByte, i3, localRegisters);
            localUnsafe.putInt(?, l1, CodedInputStream.e(localRegisters.a));
          }
          break;
        case 12: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.a(paramArrayOfByte, i3, localRegisters);
            i3 = localRegisters.a;
            localObject1 = ((MessageSchema)localObject1).c(i5);
            if ((localObject1 != null) && (!((Internal.EnumVerifier)localObject1).a(i3)))
            {
              c(paramT).a(paramInt1, Long.valueOf(i3));
              break label1099;
            }
            localUnsafe.putInt(?, l1, i3);
          }
          break;
        case 10: 
          if (i10 == 2)
          {
            i1 = ArrayDecoders.e(paramArrayOfByte, i3, localRegisters);
            localUnsafe.putObject(?, l1, localRegisters.c);
          }
          break;
        case 9: 
          if (i10 == 2)
          {
            i1 = ArrayDecoders.a(((MessageSchema)localObject1).a(i5), paramArrayOfByte, i3, paramInt2, localRegisters);
            if ((i4 & i7) == 0) {
              localUnsafe.putObject(?, l1, localRegisters.c);
            } else {
              localUnsafe.putObject(?, l1, Internal.a(localUnsafe.getObject(?, l1), localRegisters.c));
            }
          }
          break;
        case 8: 
          localObject1 = paramArrayOfByte;
          if (i10 == 2)
          {
            if ((i11 & 0x20000000) == 0) {
              i1 = ArrayDecoders.c((byte[])localObject1, i3, localRegisters);
            } else {
              i1 = ArrayDecoders.d((byte[])localObject1, i3, localRegisters);
            }
            localUnsafe.putObject(?, l1, localRegisters.c);
          }
          break;
        case 7: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.b(paramArrayOfByte, i3, localRegisters);
            boolean bool;
            if (localRegisters.b != 0L) {
              bool = true;
            } else {
              bool = false;
            }
            UnsafeUtil.a(?, l1, bool);
          }
          break;
        case 6: 
        case 13: 
          if (i10 == 5)
          {
            localUnsafe.putInt(?, l1, ArrayDecoders.a(paramArrayOfByte, i3));
            i1 = i3 + 4;
            i4 |= i7;
            i7 = i5;
            i3 = paramInt1;
            i5 = i6;
            i6 = paramInt2;
            paramInt1 = i1;
            i1 = i4;
          }
          break;
        case 5: 
        case 14: 
          if (i10 == 1) {
            localUnsafe.putLong(paramT, l1, ArrayDecoders.b(paramArrayOfByte, i3));
          }
          break;
        case 4: 
        case 11: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.a(paramArrayOfByte, i3, localRegisters);
            localUnsafe.putInt(?, l1, localRegisters.a);
          }
          break;
        case 2: 
        case 3: 
          if (i10 == 0)
          {
            i1 = ArrayDecoders.b(paramArrayOfByte, i3, localRegisters);
            localUnsafe.putLong(paramT, l1, localRegisters.b);
            i7 = i4 | i7;
            i4 = i1;
            i3 = paramInt1;
            paramInt1 = i6;
            i6 = paramInt2;
            i1 = i7;
            i7 = i5;
            i5 = paramInt1;
            paramInt1 = i4;
            i4 = paramInt3;
          }
          break;
        case 1: 
          i1 = i3;
          if (i10 == 5)
          {
            UnsafeUtil.a(?, l1, ArrayDecoders.d(paramArrayOfByte, i1));
            i1 += 4;
          }
          break;
        case 0: 
          if (i10 == 1)
          {
            UnsafeUtil.a(?, l1, ArrayDecoders.c(paramArrayOfByte, i3));
            i1 = i3 + 8;
            i4 |= i7;
            label1099:
            i7 = i5;
            i3 = paramInt1;
            i5 = i6;
            paramInt1 = i1;
            i1 = i4;
            break label1279;
          }
          i8 = paramInt3;
          i7 = i4;
          i1 = i2;
          i2 = paramInt1;
          paramInt1 = i8;
          i4 = i3;
          i3 = i7;
          break;
        }
      }
      else
      {
        i8 = i6;
        if (i12 != 27) {
          break label1293;
        }
        if (i10 != 2) {
          break;
        }
        Internal.ProtobufList localProtobufList = (Internal.ProtobufList)localUnsafe.getObject(?, l1);
        localObject2 = localProtobufList;
        if (!localProtobufList.a())
        {
          i4 = localProtobufList.size();
          if (i4 == 0) {
            i4 = 10;
          } else {
            i4 *= 2;
          }
          localObject2 = localProtobufList.e(i4);
          localUnsafe.putObject(?, l1, localObject2);
        }
        i4 = ArrayDecoders.a(((MessageSchema)localObject1).a(i5), paramInt1, paramArrayOfByte, i3, paramInt2, (Internal.ProtobufList)localObject2, paramRegisters);
        i3 = paramInt1;
        i7 = i5;
        i5 = i8;
        paramInt1 = i4;
        label1279:
        i4 = paramInt3;
        i6 = paramInt2;
      }
    }
    break label1453;
    label1293:
    i4 = i5;
    i7 = i1;
    if (i12 <= 49)
    {
      i5 = a(paramT, paramArrayOfByte, i3, paramInt2, paramInt1, i8, i10, i4, i11, i12, l1, paramRegisters);
      i1 = i5;
      if (i5 == i3) {
        break label1531;
      }
      i1 = i5;
      label1351:
      i3 = paramInt3;
      localRegisters = paramRegisters;
      i5 = i8;
      i8 = i4;
      i6 = i7;
      i4 = i3;
      i3 = paramInt1;
      i7 = i8;
      paramInt1 = i1;
    }
    for (;;)
    {
      i8 = paramInt2;
      i1 = i6;
      i6 = i8;
      break;
      int i9 = i3;
      if (i12 == 50)
      {
        if (i10 == 2)
        {
          i3 = a(paramT, paramArrayOfByte, i9, paramInt2, i4, l1, paramRegisters);
          i1 = i3;
          if (i3 == i9) {
            break label1531;
          }
          i1 = i3;
          break label1351;
        }
        label1453:
        i7 = i1;
        i1 = i2;
        i2 = paramInt3;
        i8 = paramInt1;
        paramInt1 = i2;
        i4 = i3;
        i2 = i8;
        i3 = i7;
        break label1561;
      }
      i3 = a(paramT, paramArrayOfByte, i9, paramInt2, paramInt1, i8, i10, i11, i12, l1, i4, paramRegisters);
      i1 = i3;
      if (i3 != i9)
      {
        i1 = i3;
        break label1351;
      }
      label1531:
      i8 = i1;
      i9 = paramInt1;
      paramInt1 = paramInt3;
      i3 = i7;
      i5 = i4;
      i1 = i2;
      i2 = i9;
      i4 = i8;
      label1561:
      if ((i2 == paramInt1) && (paramInt1 != 0))
      {
        paramArrayOfByte = this;
        paramInt3 = i1;
        i1 = i3;
        i3 = i2;
        break label1708;
      }
      if ((this.h) && (paramRegisters.d != ExtensionRegistryLite.d())) {
        i4 = ArrayDecoders.a(i2, paramArrayOfByte, i4, paramInt2, paramT, this.g, this.q, paramRegisters);
      } else {
        i4 = ArrayDecoders.a(i2, paramArrayOfByte, i4, paramInt2, c(paramT), paramRegisters);
      }
      localRegisters = paramRegisters;
      i7 = i5;
      i9 = i3;
      i8 = paramInt1;
      paramInt1 = i4;
      i5 = i6;
      i3 = i2;
      i6 = i9;
      i2 = i1;
      i4 = i8;
    }
    label1691:
    paramInt3 = i4;
    paramArrayOfByte = (byte[])localObject1;
    i4 = paramInt1;
    paramInt1 = paramInt3;
    paramInt3 = i2;
    label1708:
    if (paramInt3 != -1) {
      localUnsafe.putInt(paramT, paramInt3, i1);
    }
    paramRegisters = paramT;
    paramT = null;
    paramInt3 = paramArrayOfByte.m;
    while (paramInt3 < paramArrayOfByte.n)
    {
      paramT = (UnknownFieldSetLite)paramArrayOfByte.a(paramRegisters, paramArrayOfByte.l[paramInt3], paramT, paramArrayOfByte.q);
      paramInt3 += 1;
    }
    if (paramT != null) {
      paramArrayOfByte.q.b(paramRegisters, paramT);
    }
    if (paramInt1 == 0)
    {
      if (i4 == paramInt2) {
        return i4;
      }
      throw InvalidProtocolBufferException.parseFailure();
    }
    if ((i4 <= paramInt2) && (i3 == paramInt1)) {
      return i4;
    }
    paramT = InvalidProtocolBufferException.parseFailure();
    for (;;)
    {
      throw paramT;
    }
  }
  
  public T a()
  {
    return this.o.a(this.g);
  }
  
  public void a(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (paramExtensionRegistryLite != null)
    {
      a(this.q, this.r, paramT, paramReader, paramExtensionRegistryLite);
      return;
    }
    throw new NullPointerException();
  }
  
  public void a(T paramT, Writer paramWriter)
  {
    if (paramWriter.a() == Writer.FieldOrder.DESCENDING)
    {
      d(paramT, paramWriter);
      return;
    }
    if (this.j)
    {
      c(paramT, paramWriter);
      return;
    }
    b(paramT, paramWriter);
  }
  
  public void a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters)
  {
    if (this.j)
    {
      b(paramT, paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
      return;
    }
    a(paramT, paramArrayOfByte, paramInt1, paramInt2, 0, paramRegisters);
  }
  
  public boolean a(T paramT1, T paramT2)
  {
    int i2 = this.c.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (!a(paramT1, paramT2, i1)) {
        return false;
      }
      i1 += 3;
    }
    if (!this.q.b(paramT1).equals(this.q.b(paramT2))) {
      return false;
    }
    if (this.h) {
      return this.r.a(paramT1).equals(this.r.a(paramT2));
    }
    return true;
  }
  
  public int b(T paramT)
  {
    if (this.j) {
      return g(paramT);
    }
    return f(paramT);
  }
  
  public void b(T paramT1, T paramT2)
  {
    if (paramT2 != null)
    {
      int i1 = 0;
      while (i1 < this.c.length)
      {
        b(paramT1, paramT2, i1);
        i1 += 3;
      }
      if (!this.j)
      {
        SchemaUtil.a(this.q, paramT1, paramT2);
        if (this.h) {
          SchemaUtil.a(this.r, paramT1, paramT2);
        }
      }
      return;
    }
    paramT1 = new NullPointerException();
    for (;;)
    {
      throw paramT1;
    }
  }
  
  public void d(T paramT)
  {
    int i1 = this.m;
    int i2;
    for (;;)
    {
      i2 = this.n;
      if (i1 >= i2) {
        break;
      }
      long l1 = j(e(this.l[i1]));
      Object localObject = UnsafeUtil.f(paramT, l1);
      if (localObject != null) {
        UnsafeUtil.a(paramT, l1, this.s.d(localObject));
      }
      i1 += 1;
    }
    int i3 = this.l.length;
    i1 = i2;
    while (i1 < i3)
    {
      this.p.b(paramT, this.l[i1]);
      i1 += 1;
    }
    this.q.d(paramT);
    if (this.h) {
      this.r.c(paramT);
    }
  }
  
  public final boolean e(T paramT)
  {
    int i1 = 0;
    int i2 = -1;
    int i3 = 0;
    while (i1 < this.m)
    {
      int i8 = this.l[i1];
      int i9 = d(i8);
      int i10 = e(i8);
      int i4;
      int i5;
      if (!this.j)
      {
        i4 = this.c[(i8 + 2)];
        int i6 = 0xFFFFF & i4;
        int i7 = 1 << (i4 >>> 20);
        i4 = i2;
        i5 = i7;
        if (i6 != i2)
        {
          i3 = b.getInt(paramT, i6);
          i4 = i6;
          i5 = i7;
        }
      }
      else
      {
        i5 = 0;
        i4 = i2;
      }
      if ((h(i10)) && (!a(paramT, i8, i3, i5))) {
        return false;
      }
      i2 = g(i10);
      if ((i2 != 9) && (i2 != 17))
      {
        if (i2 != 27) {
          if ((i2 != 60) && (i2 != 68))
          {
            if (i2 != 49)
            {
              if ((i2 != 50) || (b(paramT, i10, i8))) {
                break label278;
              }
              return false;
            }
          }
          else
          {
            if ((!c(paramT, i9, i8)) || (a(paramT, i10, a(i8)))) {
              break label278;
            }
            return false;
          }
        }
        if (!a(paramT, i10, i8)) {
          return false;
        }
      }
      else if ((a(paramT, i8, i3, i5)) && (!a(paramT, i10, a(i8))))
      {
        return false;
      }
      label278:
      i1 += 1;
      i2 = i4;
    }
    return (!this.h) || (this.r.a(paramT).k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageSchema
 * JD-Core Version:    0.7.0.1
 */