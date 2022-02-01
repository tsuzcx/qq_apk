package com.google.protobuf;

final class ArrayDecoders
{
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ArrayDecoders.Registers paramRegisters)
  {
    if (WireFormat.b(paramInt1) != 0)
    {
      int i = WireFormat.a(paramInt1);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5) {
                return paramInt2 + 4;
              }
              throw InvalidProtocolBufferException.invalidTag();
            }
            int j = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            for (;;)
            {
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              i = a(paramArrayOfByte, paramInt2, paramRegisters);
              paramInt1 = paramRegisters.a;
              if (paramInt1 == j) {
                break;
              }
              paramInt2 = a(paramInt1, paramArrayOfByte, i, paramInt3, paramRegisters);
            }
            if ((i <= paramInt3) && (paramInt1 == j)) {
              return i;
            }
            throw InvalidProtocolBufferException.parseFailure();
          }
          return a(paramArrayOfByte, paramInt2, paramRegisters) + paramRegisters.a;
        }
        return paramInt2 + 8;
      }
      return b(paramArrayOfByte, paramInt2, paramRegisters);
    }
    paramArrayOfByte = InvalidProtocolBufferException.invalidTag();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, GeneratedMessageLite.ExtendableMessage<?, ?> paramExtendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> paramGeneratedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> paramUnknownFieldSchema, ArrayDecoders.Registers paramRegisters)
  {
    FieldSet localFieldSet = paramExtendableMessage.c;
    paramInt1 >>>= 3;
    boolean bool = paramGeneratedExtension.b.p();
    IntArrayList localIntArrayList = null;
    if ((bool) && (paramGeneratedExtension.b.q()))
    {
      switch (ArrayDecoders.1.a[paramGeneratedExtension.d().ordinal()])
      {
      default: 
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Type cannot be packed: ");
        paramArrayOfByte.append(paramGeneratedExtension.b.j());
        throw new IllegalStateException(paramArrayOfByte.toString());
      case 14: 
        localIntArrayList = new IntArrayList();
        paramInt2 = a(paramArrayOfByte, paramInt2, localIntArrayList, paramRegisters);
        paramRegisters = paramExtendableMessage.a;
        paramArrayOfByte = paramRegisters;
        if (paramRegisters == UnknownFieldSetLite.a()) {
          paramArrayOfByte = null;
        }
        paramArrayOfByte = (UnknownFieldSetLite)SchemaUtil.a(paramInt1, localIntArrayList, paramGeneratedExtension.b.a(), paramArrayOfByte, paramUnknownFieldSchema);
        if (paramArrayOfByte != null) {
          paramExtendableMessage.a = paramArrayOfByte;
        }
        localFieldSet.a(paramGeneratedExtension.b, localIntArrayList);
        return paramInt2;
      case 13: 
        paramExtendableMessage = new LongArrayList();
        paramInt1 = i(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 12: 
        paramExtendableMessage = new IntArrayList();
        paramInt1 = h(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 11: 
        paramExtendableMessage = new BooleanArrayList();
        paramInt1 = g(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 9: 
      case 10: 
        paramExtendableMessage = new IntArrayList();
        paramInt1 = c(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 7: 
      case 8: 
        paramExtendableMessage = new LongArrayList();
        paramInt1 = d(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 5: 
      case 6: 
        paramExtendableMessage = new IntArrayList();
        paramInt1 = a(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 3: 
      case 4: 
        paramExtendableMessage = new LongArrayList();
        paramInt1 = b(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      case 2: 
        paramExtendableMessage = new FloatArrayList();
        paramInt1 = e(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
        localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
        return paramInt1;
      }
      paramExtendableMessage = new DoubleArrayList();
      paramInt1 = f(paramArrayOfByte, paramInt2, paramExtendableMessage, paramRegisters);
      localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
      return paramInt1;
    }
    if (paramGeneratedExtension.d() == WireFormat.FieldType.ENUM)
    {
      paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramGeneratedExtension.b.a().findValueByNumber(paramRegisters.a) == null)
      {
        paramGeneratedExtension = paramExtendableMessage.a;
        paramArrayOfByte = paramGeneratedExtension;
        if (paramGeneratedExtension == UnknownFieldSetLite.a())
        {
          paramArrayOfByte = UnknownFieldSetLite.b();
          paramExtendableMessage.a = paramArrayOfByte;
        }
        SchemaUtil.a(paramInt1, paramRegisters.a, paramArrayOfByte, paramUnknownFieldSchema);
        return paramInt2;
      }
      paramArrayOfByte = Integer.valueOf(paramRegisters.a);
    }
    else
    {
      switch (ArrayDecoders.1.a[paramGeneratedExtension.d().ordinal()])
      {
      default: 
        paramArrayOfByte = localIntArrayList;
      }
    }
    for (;;)
    {
      break;
      paramInt2 = a(Protobuf.a().a(paramGeneratedExtension.b().getClass()), paramArrayOfByte, paramInt2, paramInt3, paramRegisters);
      paramArrayOfByte = paramRegisters.c;
      continue;
      paramInt2 = a(Protobuf.a().a(paramGeneratedExtension.b().getClass()), paramArrayOfByte, paramInt2, paramInt3, paramInt1 << 3 | 0x4, paramRegisters);
      paramArrayOfByte = paramRegisters.c;
      continue;
      paramInt2 = c(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = paramRegisters.c;
      continue;
      paramInt2 = e(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = paramRegisters.c;
      continue;
      throw new IllegalStateException("Shouldn't reach here.");
      paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = Long.valueOf(CodedInputStream.a(paramRegisters.b));
      continue;
      paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = Integer.valueOf(CodedInputStream.e(paramRegisters.a));
      continue;
      paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramRegisters.b != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayOfByte = Boolean.valueOf(bool);
      continue;
      paramArrayOfByte = Integer.valueOf(a(paramArrayOfByte, paramInt2));
      break label1014;
      paramArrayOfByte = Long.valueOf(b(paramArrayOfByte, paramInt2));
      break label1030;
      paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = Integer.valueOf(paramRegisters.a);
      continue;
      paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
      paramArrayOfByte = Long.valueOf(paramRegisters.b);
      continue;
      paramArrayOfByte = Float.valueOf(d(paramArrayOfByte, paramInt2));
      label1014:
      paramInt2 += 4;
      continue;
      paramArrayOfByte = Double.valueOf(c(paramArrayOfByte, paramInt2));
      label1030:
      paramInt2 += 8;
    }
    if (paramGeneratedExtension.e())
    {
      localFieldSet.b(paramGeneratedExtension.b, paramArrayOfByte);
      return paramInt2;
    }
    paramInt1 = ArrayDecoders.1.a[paramGeneratedExtension.d().ordinal()];
    if ((paramInt1 != 17) && (paramInt1 != 18))
    {
      paramExtendableMessage = paramArrayOfByte;
    }
    else
    {
      paramUnknownFieldSchema = localFieldSet.b(paramGeneratedExtension.b);
      paramExtendableMessage = paramArrayOfByte;
      if (paramUnknownFieldSchema != null) {
        paramExtendableMessage = Internal.a(paramUnknownFieldSchema, paramArrayOfByte);
      }
    }
    localFieldSet.a(paramGeneratedExtension.b, paramExtendableMessage);
    return paramInt2;
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
    paramProtobufList.d(paramRegisters.a);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = a(paramArrayOfByte, i, paramRegisters);
      paramProtobufList.d(paramRegisters.a);
    }
    return paramInt2;
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, UnknownFieldSetLite paramUnknownFieldSetLite, ArrayDecoders.Registers paramRegisters)
  {
    if (WireFormat.b(paramInt1) != 0)
    {
      int i = WireFormat.a(paramInt1);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5)
              {
                paramUnknownFieldSetLite.a(paramInt1, Integer.valueOf(a(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw InvalidProtocolBufferException.invalidTag();
            }
            UnknownFieldSetLite localUnknownFieldSetLite = UnknownFieldSetLite.b();
            int k = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            int j;
            for (;;)
            {
              j = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              j = a(paramArrayOfByte, paramInt2, paramRegisters);
              paramInt2 = paramRegisters.a;
              if (paramInt2 == k)
              {
                i = paramInt2;
                break;
              }
              j = a(paramInt2, paramArrayOfByte, j, paramInt3, localUnknownFieldSetLite, paramRegisters);
              i = paramInt2;
              paramInt2 = j;
            }
            if ((j <= paramInt3) && (i == k))
            {
              paramUnknownFieldSetLite.a(paramInt1, localUnknownFieldSetLite);
              return j;
            }
            throw InvalidProtocolBufferException.parseFailure();
          }
          paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
          paramInt3 = paramRegisters.a;
          if (paramInt3 >= 0)
          {
            if (paramInt3 <= paramArrayOfByte.length - paramInt2)
            {
              if (paramInt3 == 0) {
                paramUnknownFieldSetLite.a(paramInt1, ByteString.EMPTY);
              } else {
                paramUnknownFieldSetLite.a(paramInt1, ByteString.copyFrom(paramArrayOfByte, paramInt2, paramInt3));
              }
              return paramInt2 + paramInt3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
          }
          throw InvalidProtocolBufferException.negativeSize();
        }
        paramUnknownFieldSetLite.a(paramInt1, Long.valueOf(b(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
      paramUnknownFieldSetLite.a(paramInt1, Long.valueOf(paramRegisters.b));
      return paramInt2;
    }
    paramArrayOfByte = InvalidProtocolBufferException.invalidTag();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Object paramObject, MessageLite paramMessageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> paramUnknownFieldSchema, ArrayDecoders.Registers paramRegisters)
  {
    paramMessageLite = paramRegisters.d.a(paramMessageLite, paramInt1 >>> 3);
    if (paramMessageLite == null) {
      return a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, MessageSchema.c(paramObject), paramRegisters);
    }
    paramObject = (GeneratedMessageLite.ExtendableMessage)paramObject;
    paramObject.e();
    return a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramObject, paramMessageLite, paramUnknownFieldSchema, paramRegisters);
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, ArrayDecoders.Registers paramRegisters)
  {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramRegisters.a = (i | paramInt2 << 7);
      return paramInt1;
    }
    i |= (paramInt2 & 0x7F) << 7;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      paramRegisters.a = (i | paramInt1 << 14);
      return paramInt2;
    }
    paramInt1 = i | (paramInt1 & 0x7F) << 14;
    int j = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramRegisters.a = (paramInt1 | paramInt2 << 21);
      return j;
    }
    i = paramInt1 | (paramInt2 & 0x7F) << 21;
    paramInt1 = j + 1;
    j = paramArrayOfByte[j];
    if (j >= 0)
    {
      paramRegisters.a = (i | j << 28);
      return paramInt1;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0) {
        break;
      }
      paramInt1 = paramInt2;
    }
    paramRegisters.a = (i | (j & 0x7F) << 28);
    return paramInt2;
  }
  
  static int a(long paramLong, byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    int k = paramInt + 1;
    int j = paramArrayOfByte[paramInt];
    paramLong = paramLong & 0x7F | (j & 0x7F) << 7;
    int i = 7;
    paramInt = k;
    while (j < 0)
    {
      j = paramArrayOfByte[paramInt];
      i += 7;
      paramLong |= (j & 0x7F) << i;
      paramInt += 1;
    }
    paramRegisters.b = paramLong;
    return paramInt;
  }
  
  static int a(Schema<?> paramSchema, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramInt2 = a(paramSchema, paramArrayOfByte, paramInt2, paramInt3, paramRegisters);
    paramProtobufList.add(paramRegisters.c);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = a(paramSchema, paramArrayOfByte, i, paramInt3, paramRegisters);
      paramProtobufList.add(paramRegisters.c);
    }
    return paramInt2;
  }
  
  static int a(Schema paramSchema, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ArrayDecoders.Registers paramRegisters)
  {
    paramSchema = (MessageSchema)paramSchema;
    Object localObject = paramSchema.a();
    paramInt1 = paramSchema.a(localObject, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramRegisters);
    paramSchema.d(localObject);
    paramRegisters.c = localObject;
    return paramInt1;
  }
  
  static int a(Schema paramSchema, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters)
  {
    int j = paramInt1 + 1;
    int k = paramArrayOfByte[paramInt1];
    paramInt1 = j;
    int i = k;
    if (k < 0)
    {
      paramInt1 = a(k, paramArrayOfByte, j, paramRegisters);
      i = paramRegisters.a;
    }
    if ((i >= 0) && (i <= paramInt2 - paramInt1))
    {
      Object localObject = paramSchema.a();
      paramInt2 = i + paramInt1;
      paramSchema.a(localObject, paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
      paramSchema.d(localObject);
      paramRegisters.c = localObject;
      return paramInt2;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      paramRegisters.a = paramInt;
      return i;
    }
    return a(paramInt, paramArrayOfByte, i, paramRegisters);
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
      paramProtobufList.d(paramRegisters.a);
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
    paramProtobufList.a(paramRegisters.b);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = b(paramArrayOfByte, i, paramRegisters);
      paramProtobufList.a(paramRegisters.b);
    }
    return paramInt2;
  }
  
  static int b(Schema paramSchema, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    int i = paramInt1 & 0xFFFFFFF8 | 0x4;
    paramInt2 = a(paramSchema, paramArrayOfByte, paramInt2, paramInt3, i, paramRegisters);
    paramProtobufList.add(paramRegisters.c);
    while (paramInt2 < paramInt3)
    {
      int j = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = a(paramSchema, paramArrayOfByte, j, paramInt3, i, paramRegisters);
      paramProtobufList.add(paramRegisters.c);
    }
    return paramInt2;
  }
  
  static int b(byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l >= 0L)
    {
      paramRegisters.b = l;
      return i;
    }
    return a(l, paramArrayOfByte, i, paramRegisters);
  }
  
  static int b(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramInt = b(paramArrayOfByte, paramInt, paramRegisters);
      paramProtobufList.a(paramRegisters.b);
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static long b(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  static double c(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(b(paramArrayOfByte, paramInt));
  }
  
  static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramProtobufList.d(a(paramArrayOfByte, paramInt2));
    paramInt2 += 4;
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramProtobufList.d(a(paramArrayOfByte, i));
      paramInt2 = i + 4;
    }
    return paramInt2;
  }
  
  static int c(byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a;
    if (i >= 0)
    {
      if (i == 0)
      {
        paramRegisters.c = "";
        return paramInt;
      }
      paramRegisters.c = new String(paramArrayOfByte, paramInt, i, Internal.a);
      return paramInt + i;
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  static int c(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramProtobufList.d(a(paramArrayOfByte, paramInt));
      paramInt += 4;
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static float d(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(a(paramArrayOfByte, paramInt));
  }
  
  static int d(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramProtobufList.a(b(paramArrayOfByte, paramInt2));
    paramInt2 += 8;
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramProtobufList.a(b(paramArrayOfByte, i));
      paramInt2 = i + 8;
    }
    return paramInt2;
  }
  
  static int d(byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a;
    if (i >= 0)
    {
      if (i == 0)
      {
        paramRegisters.c = "";
        return paramInt;
      }
      paramRegisters.c = Utf8.b(paramArrayOfByte, paramInt, i);
      return paramInt + i;
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  static int d(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramProtobufList.a(b(paramArrayOfByte, paramInt));
      paramInt += 8;
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (FloatArrayList)paramProtobufList;
    paramProtobufList.a(d(paramArrayOfByte, paramInt2));
    paramInt2 += 4;
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramProtobufList.a(d(paramArrayOfByte, i));
      paramInt2 = i + 4;
    }
    return paramInt2;
  }
  
  static int e(byte[] paramArrayOfByte, int paramInt, ArrayDecoders.Registers paramRegisters)
  {
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a;
    if (i >= 0)
    {
      if (i <= paramArrayOfByte.length - paramInt)
      {
        if (i == 0)
        {
          paramRegisters.c = ByteString.EMPTY;
          return paramInt;
        }
        paramRegisters.c = ByteString.copyFrom(paramArrayOfByte, paramInt, i);
        return paramInt + i;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  static int e(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (FloatArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramProtobufList.a(d(paramArrayOfByte, paramInt));
      paramInt += 4;
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (DoubleArrayList)paramProtobufList;
    paramProtobufList.a(c(paramArrayOfByte, paramInt2));
    paramInt2 += 8;
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramProtobufList.a(c(paramArrayOfByte, i));
      paramInt2 = i + 8;
    }
    return paramInt2;
  }
  
  static int f(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (DoubleArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramProtobufList.a(c(paramArrayOfByte, paramInt));
      paramInt += 8;
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int g(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (BooleanArrayList)paramProtobufList;
    paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
    boolean bool;
    if (paramRegisters.b != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramProtobufList.a(bool);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = b(paramArrayOfByte, i, paramRegisters);
      if (paramRegisters.b != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramProtobufList.a(bool);
    }
    return paramInt2;
  }
  
  static int g(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (BooleanArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramInt = b(paramArrayOfByte, paramInt, paramRegisters);
      boolean bool;
      if (paramRegisters.b != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramProtobufList.a(bool);
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int h(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
    paramProtobufList.d(CodedInputStream.e(paramRegisters.a));
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = a(paramArrayOfByte, i, paramRegisters);
      paramProtobufList.d(CodedInputStream.e(paramRegisters.a));
    }
    return paramInt2;
  }
  
  static int h(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (IntArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
      paramProtobufList.d(CodedInputStream.e(paramRegisters.a));
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int i(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramInt2 = b(paramArrayOfByte, paramInt2, paramRegisters);
    paramProtobufList.a(CodedInputStream.a(paramRegisters.b));
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramRegisters);
      if (paramInt1 != paramRegisters.a) {
        return paramInt2;
      }
      paramInt2 = b(paramArrayOfByte, i, paramRegisters);
      paramProtobufList.a(CodedInputStream.a(paramRegisters.b));
    }
    return paramInt2;
  }
  
  static int i(byte[] paramArrayOfByte, int paramInt, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramProtobufList = (LongArrayList)paramProtobufList;
    paramInt = a(paramArrayOfByte, paramInt, paramRegisters);
    int i = paramRegisters.a + paramInt;
    while (paramInt < i)
    {
      paramInt = b(paramArrayOfByte, paramInt, paramRegisters);
      paramProtobufList.a(CodedInputStream.a(paramRegisters.b));
    }
    if (paramInt == i) {
      return paramInt;
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int j(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
    int j = paramRegisters.a;
    if (j >= 0)
    {
      int i;
      if (j == 0)
      {
        paramProtobufList.add("");
      }
      else
      {
        paramProtobufList.add(new String(paramArrayOfByte, paramInt2, j, Internal.a));
        i = paramInt2;
        paramInt2 = j;
      }
      for (;;)
      {
        for (paramInt2 = i + paramInt2;; paramInt2 = i)
        {
          if (paramInt2 >= paramInt3) {
            break label167;
          }
          i = a(paramArrayOfByte, paramInt2, paramRegisters);
          if (paramInt1 != paramRegisters.a) {
            return paramInt2;
          }
          i = a(paramArrayOfByte, i, paramRegisters);
          paramInt2 = paramRegisters.a;
          if (paramInt2 < 0) {
            break label163;
          }
          if (paramInt2 != 0) {
            break;
          }
          paramProtobufList.add("");
        }
        paramProtobufList.add(new String(paramArrayOfByte, i, paramInt2, Internal.a));
      }
      label163:
      throw InvalidProtocolBufferException.negativeSize();
      label167:
      return paramInt2;
    }
    paramArrayOfByte = InvalidProtocolBufferException.negativeSize();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int k(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
    int j = paramRegisters.a;
    if (j >= 0)
    {
      int i;
      if (j == 0)
      {
        paramProtobufList.add("");
      }
      else
      {
        i = paramInt2 + j;
        if (!Utf8.a(paramArrayOfByte, paramInt2, i)) {
          break label199;
        }
        paramProtobufList.add(new String(paramArrayOfByte, paramInt2, j, Internal.a));
        paramInt2 = i;
      }
      while (paramInt2 < paramInt3)
      {
        i = a(paramArrayOfByte, paramInt2, paramRegisters);
        if (paramInt1 != paramRegisters.a) {
          return paramInt2;
        }
        paramInt2 = a(paramArrayOfByte, i, paramRegisters);
        j = paramRegisters.a;
        if (j >= 0)
        {
          if (j == 0)
          {
            paramProtobufList.add("");
          }
          else
          {
            i = paramInt2 + j;
            if (Utf8.a(paramArrayOfByte, paramInt2, i))
            {
              paramProtobufList.add(new String(paramArrayOfByte, paramInt2, j, Internal.a));
              paramInt2 = i;
            }
            else
            {
              throw InvalidProtocolBufferException.invalidUtf8();
            }
          }
        }
        else {
          throw InvalidProtocolBufferException.negativeSize();
        }
      }
      return paramInt2;
      label199:
      throw InvalidProtocolBufferException.invalidUtf8();
    }
    paramArrayOfByte = InvalidProtocolBufferException.negativeSize();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  static int l(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Internal.ProtobufList<?> paramProtobufList, ArrayDecoders.Registers paramRegisters)
  {
    paramInt2 = a(paramArrayOfByte, paramInt2, paramRegisters);
    int j = paramRegisters.a;
    if (j >= 0)
    {
      if (j <= paramArrayOfByte.length - paramInt2)
      {
        int i;
        if (j == 0)
        {
          paramProtobufList.add(ByteString.EMPTY);
        }
        else
        {
          paramProtobufList.add(ByteString.copyFrom(paramArrayOfByte, paramInt2, j));
          i = paramInt2;
          paramInt2 = j;
        }
        for (;;)
        {
          for (paramInt2 = i + paramInt2;; paramInt2 = i)
          {
            if (paramInt2 >= paramInt3) {
              break label175;
            }
            i = a(paramArrayOfByte, paramInt2, paramRegisters);
            if (paramInt1 != paramRegisters.a) {
              return paramInt2;
            }
            i = a(paramArrayOfByte, i, paramRegisters);
            paramInt2 = paramRegisters.a;
            if (paramInt2 < 0) {
              break label171;
            }
            if (paramInt2 > paramArrayOfByte.length - i) {
              break label167;
            }
            if (paramInt2 != 0) {
              break;
            }
            paramProtobufList.add(ByteString.EMPTY);
          }
          paramProtobufList.add(ByteString.copyFrom(paramArrayOfByte, i, paramInt2));
        }
        label167:
        throw InvalidProtocolBufferException.truncatedMessage();
        label171:
        throw InvalidProtocolBufferException.negativeSize();
        label175:
        return paramInt2;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    paramArrayOfByte = InvalidProtocolBufferException.negativeSize();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ArrayDecoders
 * JD-Core Version:    0.7.0.1
 */