package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class ExtensionSchemaLite
  extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor>
{
  int a(Map.Entry<?, ?> paramEntry)
  {
    return ((GeneratedMessageLite.ExtensionDescriptor)paramEntry.getKey()).f();
  }
  
  FieldSet<GeneratedMessageLite.ExtensionDescriptor> a(Object paramObject)
  {
    return ((GeneratedMessageLite.ExtendableMessage)paramObject).c;
  }
  
  Object a(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt)
  {
    return paramExtensionRegistryLite.a(paramMessageLite, paramInt);
  }
  
  <UT, UB> UB a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema)
  {
    GeneratedMessageLite.GeneratedExtension localGeneratedExtension = (GeneratedMessageLite.GeneratedExtension)paramObject;
    int i = localGeneratedExtension.a();
    if ((localGeneratedExtension.b.p()) && (localGeneratedExtension.b.q()))
    {
      switch (ExtensionSchemaLite.1.a[localGeneratedExtension.d().ordinal()])
      {
      default: 
        paramReader = new StringBuilder();
        paramReader.append("Type cannot be packed: ");
        paramReader.append(localGeneratedExtension.b.j());
        throw new IllegalStateException(paramReader.toString());
      case 14: 
        paramObject = new ArrayList();
        paramReader.m(paramObject);
        paramUB = SchemaUtil.a(i, paramObject, localGeneratedExtension.b.a(), paramUB, paramUnknownFieldSchema);
        paramReader = paramObject;
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
      paramFieldSet.a(localGeneratedExtension.b, paramReader);
      return paramUB;
    }
    paramObject = null;
    if (localGeneratedExtension.d() == WireFormat.FieldType.ENUM)
    {
      int j = paramReader.i();
      if (localGeneratedExtension.b.a().findValueByNumber(j) == null) {
        return SchemaUtil.a(i, j, paramUB, paramUnknownFieldSchema);
      }
      paramReader = Integer.valueOf(j);
    }
    else
    {
      switch (ExtensionSchemaLite.1.a[localGeneratedExtension.d().ordinal()])
      {
      default: 
        paramReader = paramObject;
        break;
      case 18: 
        paramReader = paramReader.a(localGeneratedExtension.b().getClass(), paramExtensionRegistryLite);
        break;
      case 17: 
        paramReader = paramReader.b(localGeneratedExtension.b().getClass(), paramExtensionRegistryLite);
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
    if (localGeneratedExtension.e())
    {
      paramFieldSet.b(localGeneratedExtension.b, paramReader);
      return paramUB;
    }
    i = ExtensionSchemaLite.1.a[localGeneratedExtension.d().ordinal()];
    if ((i != 17) && (i != 18))
    {
      paramObject = paramReader;
    }
    else
    {
      paramExtensionRegistryLite = paramFieldSet.b(localGeneratedExtension.b);
      paramObject = paramReader;
      if (paramExtensionRegistryLite != null) {
        paramObject = Internal.a(paramExtensionRegistryLite, paramReader);
      }
    }
    paramFieldSet.a(localGeneratedExtension.b, paramObject);
    return paramUB;
  }
  
  void a(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
  {
    paramObject = (GeneratedMessageLite.GeneratedExtension)paramObject;
    MessageLite localMessageLite = paramObject.b().newBuilderForType().buildPartial();
    paramByteString = BinaryReader.a(ByteBuffer.wrap(paramByteString.toByteArray()), true);
    Protobuf.a().a(localMessageLite, paramByteString, paramExtensionRegistryLite);
    paramFieldSet.a(paramObject.b, localMessageLite);
    if (paramByteString.b() == 2147483647) {
      return;
    }
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  void a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
  {
    paramObject = (GeneratedMessageLite.GeneratedExtension)paramObject;
    paramReader = paramReader.a(paramObject.b().getClass(), paramExtensionRegistryLite);
    paramFieldSet.a(paramObject.b, paramReader);
  }
  
  void a(Writer paramWriter, Map.Entry<?, ?> paramEntry)
  {
    GeneratedMessageLite.ExtensionDescriptor localExtensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor)paramEntry.getKey();
    if (localExtensionDescriptor.p())
    {
      List localList;
      switch (ExtensionSchemaLite.1.a[localExtensionDescriptor.j().ordinal()])
      {
      default: 
        return;
      case 18: 
        localList = (List)paramEntry.getValue();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        SchemaUtil.a(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, Protobuf.a().a(localList.get(0).getClass()));
        return;
      case 17: 
        localList = (List)paramEntry.getValue();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        SchemaUtil.b(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, Protobuf.a().a(localList.get(0).getClass()));
        return;
      case 16: 
        SchemaUtil.a(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 15: 
        SchemaUtil.b(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter);
        return;
      case 14: 
        SchemaUtil.h(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 13: 
        SchemaUtil.e(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 12: 
        SchemaUtil.j(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 11: 
        SchemaUtil.g(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 10: 
        SchemaUtil.l(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 9: 
        SchemaUtil.i(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 8: 
        SchemaUtil.n(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 7: 
        SchemaUtil.k(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 6: 
        SchemaUtil.f(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 5: 
        SchemaUtil.h(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 4: 
        SchemaUtil.d(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 3: 
        SchemaUtil.c(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 2: 
        SchemaUtil.b(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      case 1: 
        SchemaUtil.a(localExtensionDescriptor.f(), (List)paramEntry.getValue(), paramWriter, localExtensionDescriptor.q());
        return;
      }
    }
    else
    {
      switch (ExtensionSchemaLite.1.a[localExtensionDescriptor.j().ordinal()])
      {
      default: 
        return;
      case 18: 
        paramWriter.a(localExtensionDescriptor.f(), paramEntry.getValue(), Protobuf.a().a(paramEntry.getValue().getClass()));
        return;
      case 17: 
        paramWriter.b(localExtensionDescriptor.f(), paramEntry.getValue(), Protobuf.a().a(paramEntry.getValue().getClass()));
        return;
      case 16: 
        paramWriter.a(localExtensionDescriptor.f(), (String)paramEntry.getValue());
        return;
      case 15: 
        paramWriter.a(localExtensionDescriptor.f(), (ByteString)paramEntry.getValue());
        return;
      case 14: 
        paramWriter.e(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 13: 
        paramWriter.d(localExtensionDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
        return;
      case 12: 
        paramWriter.f(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 11: 
        paramWriter.b(localExtensionDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
        return;
      case 10: 
        paramWriter.a(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 9: 
        paramWriter.d(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 8: 
        paramWriter.a(localExtensionDescriptor.f(), ((Boolean)paramEntry.getValue()).booleanValue());
        return;
      case 7: 
        paramWriter.g(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 6: 
        paramWriter.e(localExtensionDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
        return;
      case 5: 
        paramWriter.e(localExtensionDescriptor.f(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case 4: 
        paramWriter.c(localExtensionDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
        return;
      case 3: 
        paramWriter.a(localExtensionDescriptor.f(), ((Long)paramEntry.getValue()).longValue());
        return;
      case 2: 
        paramWriter.a(localExtensionDescriptor.f(), ((Float)paramEntry.getValue()).floatValue());
        return;
      }
      paramWriter.a(localExtensionDescriptor.f(), ((Double)paramEntry.getValue()).doubleValue());
    }
  }
  
  void a(Object paramObject, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet)
  {
    ((GeneratedMessageLite.ExtendableMessage)paramObject).c = paramFieldSet;
  }
  
  boolean a(MessageLite paramMessageLite)
  {
    return paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage;
  }
  
  FieldSet<GeneratedMessageLite.ExtensionDescriptor> b(Object paramObject)
  {
    return ((GeneratedMessageLite.ExtendableMessage)paramObject).e();
  }
  
  void c(Object paramObject)
  {
    a(paramObject).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionSchemaLite
 * JD-Core Version:    0.7.0.1
 */