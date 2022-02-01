package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class ExtensionSchemaFull
  extends ExtensionSchema<Descriptors.FieldDescriptor>
{
  private static final long a = ;
  
  private static <T> long a()
  {
    try
    {
      long l = UnsafeUtil.a(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
      return l;
    }
    catch (Throwable localThrowable)
    {
      label13:
      break label13;
    }
    throw new IllegalStateException("Unable to lookup extension field offset");
  }
  
  int a(Map.Entry<?, ?> paramEntry)
  {
    return ((Descriptors.FieldDescriptor)paramEntry.getKey()).f();
  }
  
  public FieldSet<Descriptors.FieldDescriptor> a(Object paramObject)
  {
    return (FieldSet)UnsafeUtil.f(paramObject, a);
  }
  
  Object a(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt)
  {
    return ((ExtensionRegistry)paramExtensionRegistryLite).a(((Message)paramMessageLite).getDescriptorForType(), paramInt);
  }
  
  <UT, UB> UB a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    ExtensionRegistry.ExtensionInfo localExtensionInfo = (ExtensionRegistry.ExtensionInfo)paramObject;
    int i = localExtensionInfo.a.f();
    int j;
    if ((localExtensionInfo.a.p()) && (localExtensionInfo.a.q()))
    {
      switch (ExtensionSchemaFull.1.a[localExtensionInfo.a.j().ordinal()])
      {
      default: 
        paramReader = new StringBuilder();
        paramReader.append("Type cannot be packed: ");
        paramReader.append(localExtensionInfo.a.j());
        throw new IllegalStateException(paramReader.toString());
      case 14: 
        paramObject = new ArrayList();
        paramReader.m(paramObject);
        paramReader = new ArrayList();
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          j = ((Integer)paramObject.next()).intValue();
          paramExtensionRegistryLite = localExtensionInfo.a.z().a(j);
          if (paramExtensionRegistryLite != null) {
            paramReader.add(paramExtensionRegistryLite);
          } else {
            paramUB = SchemaUtil.a(i, j, paramUB, paramUnknownFieldSchema);
          }
        }
        break;
      case 13: 
        paramObject = new ArrayList();
        paramReader.q(paramObject);
        paramReader = paramObject;
        break;
      case 12: 
        paramObject = new ArrayList();
        paramReader.p(paramObject);
        paramReader = paramObject;
        break;
      case 11: 
        paramObject = new ArrayList();
        paramReader.o(paramObject);
        paramReader = paramObject;
        break;
      case 10: 
        paramObject = new ArrayList();
        paramReader.n(paramObject);
        paramReader = paramObject;
        break;
      case 9: 
        paramObject = new ArrayList();
        paramReader.l(paramObject);
        paramReader = paramObject;
        break;
      case 8: 
        paramObject = new ArrayList();
        paramReader.h(paramObject);
        paramReader = paramObject;
        break;
      case 7: 
        paramObject = new ArrayList();
        paramReader.g(paramObject);
        paramReader = paramObject;
        break;
      case 6: 
        paramObject = new ArrayList();
        paramReader.f(paramObject);
        paramReader = paramObject;
        break;
      case 5: 
        paramObject = new ArrayList();
        paramReader.e(paramObject);
        paramReader = paramObject;
        break;
      case 4: 
        paramObject = new ArrayList();
        paramReader.c(paramObject);
        paramReader = paramObject;
        break;
      case 3: 
        paramObject = new ArrayList();
        paramReader.d(paramObject);
        paramReader = paramObject;
        break;
      case 2: 
        paramObject = new ArrayList();
        paramReader.b(paramObject);
        paramReader = paramObject;
        break;
      case 1: 
        paramObject = new ArrayList();
        paramReader.a(paramObject);
        paramReader = paramObject;
      }
      paramFieldSet.a(localExtensionInfo.a, paramReader);
      return paramUB;
    }
    paramObject = null;
    if (localExtensionInfo.a.j() == WireFormat.FieldType.ENUM)
    {
      j = paramReader.i();
      paramObject = localExtensionInfo.a.z().a(j);
      paramReader = paramObject;
      if (paramObject == null) {
        return SchemaUtil.a(i, j, paramUB, paramUnknownFieldSchema);
      }
    }
    else
    {
      switch (ExtensionSchemaFull.1.a[localExtensionInfo.a.j().ordinal()])
      {
      default: 
        paramReader = paramObject;
        break;
      case 18: 
        paramReader = paramReader.a(localExtensionInfo.b.getClass(), paramExtensionRegistryLite);
        break;
      case 17: 
        paramReader = paramReader.b(localExtensionInfo.b.getClass(), paramExtensionRegistryLite);
        break;
      case 16: 
        paramReader = paramReader.m();
        break;
      case 15: 
        paramReader = paramReader.o();
        break;
      case 14: 
        throw new IllegalStateException("Shouldn't reach here.");
      case 13: 
        paramReader = Long.valueOf(paramReader.u());
        break;
      case 12: 
        paramReader = Integer.valueOf(paramReader.t());
        break;
      case 11: 
        paramReader = Long.valueOf(paramReader.s());
        break;
      case 10: 
        paramReader = Integer.valueOf(paramReader.r());
        break;
      case 9: 
        paramReader = Integer.valueOf(paramReader.p());
        break;
      case 8: 
        paramReader = Boolean.valueOf(paramReader.l());
        break;
      case 7: 
        paramReader = Integer.valueOf(paramReader.k());
        break;
      case 6: 
        paramReader = Long.valueOf(paramReader.j());
        break;
      case 5: 
        paramReader = Integer.valueOf(paramReader.i());
        break;
      case 4: 
        paramReader = Long.valueOf(paramReader.g());
        break;
      case 3: 
        paramReader = Long.valueOf(paramReader.h());
        break;
      case 2: 
        paramReader = Float.valueOf(paramReader.f());
        break;
      case 1: 
        paramReader = Double.valueOf(paramReader.e());
      }
    }
    if (localExtensionInfo.a.p())
    {
      paramFieldSet.b(localExtensionInfo.a, paramReader);
      return paramUB;
    }
    i = ExtensionSchemaFull.1.a[localExtensionInfo.a.j().ordinal()];
    if ((i != 17) && (i != 18))
    {
      paramObject = paramReader;
    }
    else
    {
      paramExtensionRegistryLite = paramFieldSet.b(localExtensionInfo.a);
      paramObject = paramReader;
      if (paramExtensionRegistryLite != null) {
        paramObject = Internal.a(paramExtensionRegistryLite, paramReader);
      }
    }
    paramFieldSet.a(localExtensionInfo.a, paramObject);
    return paramUB;
  }
  
  void a(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet)
  {
    paramObject = (ExtensionRegistry.ExtensionInfo)paramObject;
    Message localMessage = paramObject.b.newBuilderForType().buildPartial();
    if (ExtensionRegistryLite.c())
    {
      paramByteString = BinaryReader.a(ByteBuffer.wrap(paramByteString.toByteArray()), true);
      Protobuf.a().a(localMessage, paramByteString, paramExtensionRegistryLite);
      paramFieldSet.a(paramObject.a, localMessage);
      if (paramByteString.b() == 2147483647) {
        return;
      }
      throw InvalidProtocolBufferException.invalidEndTag();
    }
    paramFieldSet.a(paramObject.a, new LazyField(paramObject.b, paramExtensionRegistryLite, paramByteString));
  }
  
  void a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet)
  {
    paramObject = (ExtensionRegistry.ExtensionInfo)paramObject;
    if (ExtensionRegistryLite.c())
    {
      paramReader = paramReader.a(paramObject.b.getClass(), paramExtensionRegistryLite);
      paramFieldSet.a(paramObject.a, paramReader);
      return;
    }
    paramFieldSet.a(paramObject.a, new LazyField(paramObject.b, paramExtensionRegistryLite, paramReader.o()));
  }
  
  void a(Writer paramWriter, Map.Entry<?, ?> paramEntry)
  {
    Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)paramEntry.getKey();
    if (localFieldDescriptor.p())
    {
      switch (ExtensionSchemaFull.1.a[localFieldDescriptor.j().ordinal()])
      {
      default: 
        return;
      case 18: 
        SchemaUtil.c(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 17: 
        SchemaUtil.d(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 16: 
        SchemaUtil.a(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 15: 
        SchemaUtil.b(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 14: 
        Object localObject = (List)paramEntry.getValue();
        paramEntry = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramEntry.add(Integer.valueOf(((Descriptors.EnumValueDescriptor)((Iterator)localObject).next()).getNumber()));
        }
        SchemaUtil.h(localFieldDescriptor.f(), paramEntry, paramWriter, localFieldDescriptor.q());
        return;
      case 13: 
        SchemaUtil.e(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 12: 
        SchemaUtil.j(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 11: 
        SchemaUtil.g(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 10: 
        SchemaUtil.l(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 9: 
        SchemaUtil.i(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 8: 
        SchemaUtil.n(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 7: 
        SchemaUtil.k(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 6: 
        SchemaUtil.f(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 5: 
        SchemaUtil.h(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 4: 
        SchemaUtil.d(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 3: 
        SchemaUtil.c(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      case 2: 
        SchemaUtil.b(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
        return;
      }
      SchemaUtil.a(localFieldDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localFieldDescriptor.q());
      return;
    }
    switch (ExtensionSchemaFull.1.a[localFieldDescriptor.j().ordinal()])
    {
    default: 
      return;
    case 18: 
      paramWriter.b(localFieldDescriptor.f(), paramEntry.getValue());
      return;
    case 17: 
      paramWriter.c(localFieldDescriptor.f(), paramEntry.getValue());
      return;
    case 16: 
      paramWriter.a(localFieldDescriptor.f(), (String)paramEntry.getValue());
      return;
    case 15: 
      paramWriter.a(localFieldDescriptor.f(), (ByteString)paramEntry.getValue());
      return;
    case 14: 
      paramWriter.e(localFieldDescriptor.f(), ((Descriptors.EnumValueDescriptor)paramEntry.getValue()).getNumber());
      return;
    case 13: 
      paramWriter.d(localFieldDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
      return;
    case 12: 
      paramWriter.f(localFieldDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
      return;
    case 11: 
      paramWriter.b(localFieldDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
      return;
    case 10: 
      paramWriter.a(localFieldDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
      return;
    case 9: 
      paramWriter.d(localFieldDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
      return;
    case 8: 
      paramWriter.a(localFieldDescriptor.f(), ((Boolean)paramEntry.getValue()).booleanValue());
      return;
    case 7: 
      paramWriter.g(localFieldDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
      return;
    case 6: 
      paramWriter.e(localFieldDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
      return;
    case 5: 
      paramWriter.e(localFieldDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
      return;
    case 4: 
      paramWriter.c(localFieldDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
      return;
    case 3: 
      paramWriter.a(localFieldDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
      return;
    case 2: 
      paramWriter.a(localFieldDescriptor.f(), ((Float)paramEntry.getValue()).floatValue());
      return;
    }
    paramWriter.a(localFieldDescriptor.f(), ((Double)paramEntry.getValue()).doubleValue());
  }
  
  void a(Object paramObject, FieldSet<Descriptors.FieldDescriptor> paramFieldSet)
  {
    UnsafeUtil.a(paramObject, a, paramFieldSet);
  }
  
  boolean a(MessageLite paramMessageLite)
  {
    return paramMessageLite instanceof GeneratedMessageV3.ExtendableMessage;
  }
  
  FieldSet<Descriptors.FieldDescriptor> b(Object paramObject)
  {
    FieldSet localFieldSet2 = a(paramObject);
    FieldSet localFieldSet1 = localFieldSet2;
    if (localFieldSet2.e())
    {
      localFieldSet1 = localFieldSet2.f();
      a(paramObject, localFieldSet1);
    }
    return localFieldSet1;
  }
  
  void c(Object paramObject)
  {
    a(paramObject).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionSchemaFull
 * JD-Core Version:    0.7.0.1
 */