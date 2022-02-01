package com.google.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class MessageReflection
{
  static int a(Message paramMessage, Map<Descriptors.FieldDescriptor, Object> paramMap)
  {
    boolean bool = paramMessage.getDescriptorForType().e().getMessageSetWireFormat();
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    int j;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localFieldDescriptor.u()) && (localFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!localFieldDescriptor.p())) {
        j = CodedOutputStream.d(localFieldDescriptor.f(), (Message)localObject);
      } else {
        j = FieldSet.c(localFieldDescriptor, localObject);
      }
      i += j;
    }
    paramMessage = paramMessage.getUnknownFields();
    if (bool) {
      j = paramMessage.e();
    } else {
      j = paramMessage.getSerializedSize();
    }
    return i + j;
  }
  
  private static String a(String paramString, Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    if (paramFieldDescriptor.u())
    {
      paramString.append('(');
      paramString.append(paramFieldDescriptor.c());
      paramString.append(')');
    }
    else
    {
      paramString.append(paramFieldDescriptor.b());
    }
    if (paramInt != -1)
    {
      paramString.append('[');
      paramString.append(paramInt);
      paramString.append(']');
    }
    paramString.append('.');
    return paramString.toString();
  }
  
  static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  private static void a(ByteString paramByteString, ExtensionRegistry.ExtensionInfo paramExtensionInfo, ExtensionRegistryLite paramExtensionRegistryLite, MessageReflection.MergeTarget paramMergeTarget)
  {
    Descriptors.FieldDescriptor localFieldDescriptor = paramExtensionInfo.a;
    if ((!paramMergeTarget.b(localFieldDescriptor)) && (!ExtensionRegistryLite.c()))
    {
      paramMergeTarget.a(localFieldDescriptor, new LazyField(paramExtensionInfo.b, paramExtensionRegistryLite, paramByteString));
      return;
    }
    paramMergeTarget.a(localFieldDescriptor, paramMergeTarget.a(paramByteString, paramExtensionRegistryLite, localFieldDescriptor, paramExtensionInfo.b));
  }
  
  private static void a(CodedInputStream paramCodedInputStream, ExtensionRegistry.ExtensionInfo paramExtensionInfo, ExtensionRegistryLite paramExtensionRegistryLite, MessageReflection.MergeTarget paramMergeTarget)
  {
    Descriptors.FieldDescriptor localFieldDescriptor = paramExtensionInfo.a;
    paramMergeTarget.a(localFieldDescriptor, paramMergeTarget.b(paramCodedInputStream, paramExtensionRegistryLite, localFieldDescriptor, paramExtensionInfo.b));
  }
  
  private static void a(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.Descriptor paramDescriptor, MessageReflection.MergeTarget paramMergeTarget)
  {
    int i = 0;
    ByteString localByteString = null;
    Object localObject = localByteString;
    int j;
    do
    {
      for (;;)
      {
        j = paramCodedInputStream.a();
        if (j == 0) {
          break label138;
        }
        if (j == WireFormat.c)
        {
          j = paramCodedInputStream.m();
          i = j;
          if (j != 0)
          {
            i = j;
            if ((paramExtensionRegistryLite instanceof ExtensionRegistry))
            {
              localObject = paramMergeTarget.a((ExtensionRegistry)paramExtensionRegistryLite, paramDescriptor, j);
              i = j;
            }
          }
        }
        else
        {
          if (j != WireFormat.d) {
            break;
          }
          if ((i != 0) && (localObject != null) && (ExtensionRegistryLite.c()))
          {
            a(paramCodedInputStream, (ExtensionRegistry.ExtensionInfo)localObject, paramExtensionRegistryLite, paramMergeTarget);
            localByteString = null;
          }
          else
          {
            localByteString = paramCodedInputStream.l();
          }
        }
      }
    } while (paramCodedInputStream.b(j));
    label138:
    paramCodedInputStream.a(WireFormat.b);
    if ((localByteString != null) && (i != 0))
    {
      if (localObject != null)
      {
        a(localByteString, (ExtensionRegistry.ExtensionInfo)localObject, paramExtensionRegistryLite, paramMergeTarget);
        return;
      }
      if ((localByteString != null) && (paramBuilder != null)) {
        paramBuilder.a(i, UnknownFieldSet.Field.a().a(localByteString).a());
      }
    }
  }
  
  static void a(Message paramMessage, Map<Descriptors.FieldDescriptor, Object> paramMap, CodedOutputStream paramCodedOutputStream, boolean paramBoolean)
  {
    boolean bool = paramMessage.getDescriptorForType().e().getMessageSetWireFormat();
    Object localObject1 = paramMap;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new TreeMap(paramMap);
      paramMap = paramMessage.getDescriptorForType().f().iterator();
      while (paramMap.hasNext())
      {
        localObject2 = (Descriptors.FieldDescriptor)paramMap.next();
        if ((((Descriptors.FieldDescriptor)localObject2).n()) && (!((Map)localObject1).containsKey(localObject2))) {
          ((Map)localObject1).put(localObject2, paramMessage.getField((Descriptors.FieldDescriptor)localObject2));
        }
      }
    }
    paramMap = ((Map)localObject1).entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (Map.Entry)paramMap.next();
      localObject1 = (Descriptors.FieldDescriptor)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((bool) && (((Descriptors.FieldDescriptor)localObject1).u()) && (((Descriptors.FieldDescriptor)localObject1).i() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!((Descriptors.FieldDescriptor)localObject1).p())) {
        paramCodedOutputStream.b(((Descriptors.FieldDescriptor)localObject1).f(), (Message)localObject2);
      } else {
        FieldSet.a((FieldSet.FieldDescriptorLite)localObject1, localObject2, paramCodedOutputStream);
      }
    }
    paramMessage = paramMessage.getUnknownFields();
    if (bool)
    {
      paramMessage.a(paramCodedOutputStream);
      return;
    }
    paramMessage.writeTo(paramCodedOutputStream);
  }
  
  private static void a(MessageOrBuilder paramMessageOrBuilder, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramMessageOrBuilder.getDescriptorForType().f().iterator();
    Descriptors.FieldDescriptor localFieldDescriptor;
    Object localObject;
    while (localIterator.hasNext())
    {
      localFieldDescriptor = (Descriptors.FieldDescriptor)localIterator.next();
      if ((localFieldDescriptor.n()) && (!paramMessageOrBuilder.hasField(localFieldDescriptor)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(localFieldDescriptor.b());
        paramList.add(((StringBuilder)localObject).toString());
      }
    }
    localIterator = paramMessageOrBuilder.getAllFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        if (localFieldDescriptor.p())
        {
          int i = 0;
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a((MessageOrBuilder)((Iterator)localObject).next(), a(paramString, localFieldDescriptor, i), paramList);
            i += 1;
          }
        }
        else if (paramMessageOrBuilder.hasField(localFieldDescriptor))
        {
          a((MessageOrBuilder)localObject, a(paramString, localFieldDescriptor, -1), paramList);
        }
      }
    }
  }
  
  static boolean a(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.Descriptor paramDescriptor, MessageReflection.MergeTarget paramMergeTarget, int paramInt)
  {
    if ((paramDescriptor.e().getMessageSetWireFormat()) && (paramInt == WireFormat.a))
    {
      a(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, paramDescriptor, paramMergeTarget);
      return true;
    }
    int i = WireFormat.a(paramInt);
    int k = WireFormat.b(paramInt);
    boolean bool = paramDescriptor.a(k);
    Object localObject2 = null;
    if (bool)
    {
      if ((paramExtensionRegistryLite instanceof ExtensionRegistry))
      {
        localObject1 = paramMergeTarget.a((ExtensionRegistry)paramExtensionRegistryLite, paramDescriptor, k);
        if (localObject1 != null)
        {
          paramDescriptor = ((ExtensionRegistry.ExtensionInfo)localObject1).a;
          localObject1 = ((ExtensionRegistry.ExtensionInfo)localObject1).b;
          if ((localObject1 == null) && (paramDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE))
          {
            paramCodedInputStream = new StringBuilder();
            paramCodedInputStream.append("Message-typed extension lacked default instance: ");
            paramCodedInputStream.append(paramDescriptor.c());
            throw new IllegalStateException(paramCodedInputStream.toString());
          }
          break label193;
        }
      }
    }
    else if (paramMergeTarget.a() == MessageReflection.MergeTarget.ContainerType.MESSAGE)
    {
      paramDescriptor = paramDescriptor.b(k);
      localObject1 = null;
      break label193;
    }
    Object localObject1 = null;
    paramDescriptor = localObject2;
    label193:
    int j = 0;
    if (paramDescriptor == null) {}
    do
    {
      i = 0;
      j = 1;
      break;
      if (i == FieldSet.a(paramDescriptor.j(), false))
      {
        i = 0;
        break;
      }
    } while ((!paramDescriptor.r()) || (i != FieldSet.a(paramDescriptor.j(), true)));
    i = 1;
    if (j != 0)
    {
      if (paramBuilder != null) {
        return paramBuilder.a(paramInt, paramCodedInputStream);
      }
      return paramCodedInputStream.b(paramInt);
    }
    if (i != 0)
    {
      paramInt = paramCodedInputStream.c(paramCodedInputStream.s());
      if (paramDescriptor.j() == WireFormat.FieldType.ENUM) {
        while (paramCodedInputStream.x() > 0)
        {
          i = paramCodedInputStream.n();
          if (paramDescriptor.d().k())
          {
            paramMergeTarget.b(paramDescriptor, paramDescriptor.z().b(i));
          }
          else
          {
            paramExtensionRegistryLite = paramDescriptor.z().a(i);
            if (paramExtensionRegistryLite == null)
            {
              if (paramBuilder != null) {
                paramBuilder.a(k, i);
              }
            }
            else {
              paramMergeTarget.b(paramDescriptor, paramExtensionRegistryLite);
            }
          }
        }
      }
      while (paramCodedInputStream.x() > 0) {
        paramMergeTarget.b(paramDescriptor, WireFormat.a(paramCodedInputStream, paramDescriptor.j(), paramMergeTarget.c(paramDescriptor)));
      }
      paramCodedInputStream.d(paramInt);
      return true;
    }
    paramInt = MessageReflection.1.a[paramDescriptor.i().ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramCodedInputStream = WireFormat.a(paramCodedInputStream, paramDescriptor.j(), paramMergeTarget.c(paramDescriptor));
        }
        else
        {
          paramInt = paramCodedInputStream.n();
          if (paramDescriptor.d().k())
          {
            paramCodedInputStream = paramDescriptor.z().b(paramInt);
          }
          else
          {
            paramCodedInputStream = paramDescriptor.z().a(paramInt);
            if (paramCodedInputStream == null)
            {
              if (paramBuilder != null) {
                paramBuilder.a(k, paramInt);
              }
              return true;
            }
          }
        }
      }
      else {
        paramCodedInputStream = paramMergeTarget.b(paramCodedInputStream, paramExtensionRegistryLite, paramDescriptor, (Message)localObject1);
      }
    }
    else {
      paramCodedInputStream = paramMergeTarget.a(paramCodedInputStream, paramExtensionRegistryLite, paramDescriptor, (Message)localObject1);
    }
    if (paramDescriptor.p())
    {
      paramMergeTarget.b(paramDescriptor, paramCodedInputStream);
      return true;
    }
    paramMergeTarget.a(paramDescriptor, paramCodedInputStream);
    return true;
  }
  
  static boolean a(MessageOrBuilder paramMessageOrBuilder)
  {
    Object localObject = paramMessageOrBuilder.getDescriptorForType().f().iterator();
    Descriptors.FieldDescriptor localFieldDescriptor;
    while (((Iterator)localObject).hasNext())
    {
      localFieldDescriptor = (Descriptors.FieldDescriptor)((Iterator)localObject).next();
      if ((localFieldDescriptor.n()) && (!paramMessageOrBuilder.hasField(localFieldDescriptor))) {
        return false;
      }
    }
    paramMessageOrBuilder = paramMessageOrBuilder.getAllFields().entrySet().iterator();
    for (;;)
    {
      if (paramMessageOrBuilder.hasNext())
      {
        localObject = (Map.Entry)paramMessageOrBuilder.next();
        localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
        if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          if (localFieldDescriptor.p())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((Message)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((Message)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  static List<String> b(MessageOrBuilder paramMessageOrBuilder)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramMessageOrBuilder, "", localArrayList);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageReflection
 * JD-Core Version:    0.7.0.1
 */