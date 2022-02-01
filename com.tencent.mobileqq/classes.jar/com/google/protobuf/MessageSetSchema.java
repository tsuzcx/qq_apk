package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

final class MessageSetSchema<T>
  implements Schema<T>
{
  private final MessageLite a;
  private final UnknownFieldSchema<?, ?> b;
  private final boolean c;
  private final ExtensionSchema<?> d;
  
  private MessageSetSchema(UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MessageLite paramMessageLite)
  {
    this.b = paramUnknownFieldSchema;
    this.c = paramExtensionSchema.a(paramMessageLite);
    this.d = paramExtensionSchema;
    this.a = paramMessageLite;
  }
  
  private <UT, UB> int a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT)
  {
    return paramUnknownFieldSchema.e(paramUnknownFieldSchema.b(paramT));
  }
  
  static <T> MessageSetSchema<T> a(UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MessageLite paramMessageLite)
  {
    return new MessageSetSchema(paramUnknownFieldSchema, paramExtensionSchema, paramMessageLite);
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, ExtensionSchema<ET> paramExtensionSchema, T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    Object localObject = paramUnknownFieldSchema.c(paramT);
    FieldSet localFieldSet = paramExtensionSchema.b(paramT);
    try
    {
      boolean bool;
      do
      {
        int i = paramReader.b();
        if (i == 2147483647)
        {
          paramUnknownFieldSchema.b(paramT, localObject);
          return;
        }
        bool = a(paramReader, paramExtensionRegistryLite, paramExtensionSchema, localFieldSet, paramUnknownFieldSchema, localObject);
      } while (bool);
      paramUnknownFieldSchema.b(paramT, localObject);
      return;
    }
    finally
    {
      paramUnknownFieldSchema.b(paramT, localObject);
    }
    for (;;)
    {
      throw paramExtensionSchema;
    }
  }
  
  private <UT, UB> void a(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT, Writer paramWriter)
  {
    paramUnknownFieldSchema.b(paramUnknownFieldSchema.b(paramT), paramWriter);
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean a(Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite, ExtensionSchema<ET> paramExtensionSchema, FieldSet<ET> paramFieldSet, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, UB paramUB)
  {
    int i = paramReader.c();
    if (i != WireFormat.a)
    {
      if (WireFormat.a(i) == 2)
      {
        localObject = paramExtensionSchema.a(paramExtensionRegistryLite, this.a, WireFormat.b(i));
        if (localObject != null)
        {
          paramExtensionSchema.a(paramReader, localObject, paramExtensionRegistryLite, paramFieldSet);
          return true;
        }
        return paramUnknownFieldSchema.a(paramUB, paramReader);
      }
      return paramReader.d();
    }
    Object localObject = null;
    ByteString localByteString = null;
    i = 0;
    do
    {
      for (;;)
      {
        if (paramReader.b() == 2147483647) {
          break label183;
        }
        int j = paramReader.c();
        if (j == WireFormat.c)
        {
          i = paramReader.p();
          localObject = paramExtensionSchema.a(paramExtensionRegistryLite, this.a, i);
        }
        else
        {
          if (j != WireFormat.d) {
            break;
          }
          if (localObject != null) {
            paramExtensionSchema.a(paramReader, localObject, paramExtensionRegistryLite, paramFieldSet);
          } else {
            localByteString = paramReader.o();
          }
        }
      }
    } while (paramReader.d());
    label183:
    if (paramReader.c() == WireFormat.b)
    {
      if (localByteString != null)
      {
        if (localObject != null)
        {
          paramExtensionSchema.a(localByteString, localObject, paramExtensionRegistryLite, paramFieldSet);
          return true;
        }
        paramUnknownFieldSchema.a(paramUB, i, localByteString);
      }
      return true;
    }
    paramReader = InvalidProtocolBufferException.invalidEndTag();
    for (;;)
    {
      throw paramReader;
    }
  }
  
  public int a(T paramT)
  {
    int j = this.b.b(paramT).hashCode();
    int i = j;
    if (this.c) {
      i = j * 53 + this.d.a(paramT).hashCode();
    }
    return i;
  }
  
  public T a()
  {
    return this.a.newBuilderForType().buildPartial();
  }
  
  public void a(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(this.b, this.d, paramT, paramReader, paramExtensionRegistryLite);
  }
  
  public void a(T paramT, Writer paramWriter)
  {
    Iterator localIterator = this.d.a(paramT).i();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)localEntry.getKey();
      if ((localFieldDescriptorLite.h() == WireFormat.JavaType.MESSAGE) && (!localFieldDescriptorLite.p()) && (!localFieldDescriptorLite.q()))
      {
        if ((localEntry instanceof LazyField.LazyEntry)) {
          paramWriter.a(localFieldDescriptorLite.f(), ((LazyField.LazyEntry)localEntry).a().c());
        } else {
          paramWriter.a(localFieldDescriptorLite.f(), localEntry.getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    a(this.b, paramT, paramWriter);
  }
  
  public void a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters)
  {
    Object localObject3 = (GeneratedMessageLite)paramT;
    Object localObject2 = ((GeneratedMessageLite)localObject3).a;
    Object localObject1 = localObject2;
    if (localObject2 == UnknownFieldSetLite.a())
    {
      localObject1 = UnknownFieldSetLite.b();
      ((GeneratedMessageLite)localObject3).a = ((UnknownFieldSetLite)localObject1);
    }
    localObject3 = ((GeneratedMessageLite.ExtendableMessage)paramT).e();
    paramT = null;
    while (paramInt1 < paramInt2)
    {
      paramInt1 = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
      int i = paramRegisters.a;
      if (i != WireFormat.a)
      {
        if (WireFormat.a(i) == 2)
        {
          paramT = (GeneratedMessageLite.GeneratedExtension)this.d.a(paramRegisters.d, this.a, WireFormat.b(i));
          if (paramT != null)
          {
            paramInt1 = ArrayDecoders.a(Protobuf.a().a(paramT.b().getClass()), paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
            ((FieldSet)localObject3).a(paramT.b, paramRegisters.c);
          }
          else
          {
            paramInt1 = ArrayDecoders.a(i, paramArrayOfByte, paramInt1, paramInt2, (UnknownFieldSetLite)localObject1, paramRegisters);
          }
        }
        else
        {
          paramInt1 = ArrayDecoders.a(i, paramArrayOfByte, paramInt1, paramInt2, paramRegisters);
        }
      }
      else
      {
        int j = 0;
        localObject2 = null;
        for (;;)
        {
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          i = ArrayDecoders.a(paramArrayOfByte, paramInt1, paramRegisters);
          paramInt1 = paramRegisters.a;
          int k = WireFormat.b(paramInt1);
          int m = WireFormat.a(paramInt1);
          if (k != 2)
          {
            if (k == 3)
            {
              if (paramT != null)
              {
                paramInt1 = ArrayDecoders.a(Protobuf.a().a(paramT.b().getClass()), paramArrayOfByte, i, paramInt2, paramRegisters);
                ((FieldSet)localObject3).a(paramT.b, paramRegisters.c);
                continue;
              }
              if (m == 2)
              {
                paramInt1 = ArrayDecoders.e(paramArrayOfByte, i, paramRegisters);
                localObject2 = (ByteString)paramRegisters.c;
              }
            }
          }
          else if (m == 0)
          {
            paramInt1 = ArrayDecoders.a(paramArrayOfByte, i, paramRegisters);
            j = paramRegisters.a;
            paramT = (GeneratedMessageLite.GeneratedExtension)this.d.a(paramRegisters.d, this.a, j);
            continue;
          }
          if (paramInt1 == WireFormat.b) {
            break;
          }
          paramInt1 = ArrayDecoders.a(paramInt1, paramArrayOfByte, i, paramInt2, paramRegisters);
        }
        if (localObject2 != null) {
          ((UnknownFieldSetLite)localObject1).a(WireFormat.a(j, 2), localObject2);
        }
        paramInt1 = i;
      }
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    paramT = InvalidProtocolBufferException.parseFailure();
    for (;;)
    {
      throw paramT;
    }
  }
  
  public boolean a(T paramT1, T paramT2)
  {
    if (!this.b.b(paramT1).equals(this.b.b(paramT2))) {
      return false;
    }
    if (this.c) {
      return this.d.a(paramT1).equals(this.d.a(paramT2));
    }
    return true;
  }
  
  public int b(T paramT)
  {
    int j = a(this.b, paramT) + 0;
    int i = j;
    if (this.c) {
      i = j + this.d.a(paramT).m();
    }
    return i;
  }
  
  public void b(T paramT1, T paramT2)
  {
    SchemaUtil.a(this.b, paramT1, paramT2);
    if (this.c) {
      SchemaUtil.a(this.d, paramT1, paramT2);
    }
  }
  
  public void d(T paramT)
  {
    this.b.d(paramT);
    this.d.c(paramT);
  }
  
  public final boolean e(T paramT)
  {
    return this.d.a(paramT).k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageSetSchema
 * JD-Core Version:    0.7.0.1
 */