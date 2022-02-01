package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class DescriptorMessageInfoFactory
  implements MessageInfoFactory
{
  private static final DescriptorMessageInfoFactory a = new DescriptorMessageInfoFactory();
  private static final Set<String> b = new HashSet(Arrays.asList(new String[] { "cached_size", "serialized_size", "class" }));
  private static DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer c = new DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer();
  
  private static FieldInfo a(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor, DescriptorMessageInfoFactory.OneofState paramOneofState, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier)
  {
    paramOneofState = paramOneofState.a(paramClass, paramFieldDescriptor.w());
    FieldType localFieldType = b(paramFieldDescriptor);
    paramClass = a(paramClass, paramFieldDescriptor, localFieldType);
    return FieldInfo.a(paramFieldDescriptor.f(), localFieldType, paramOneofState, paramClass, paramBoolean, paramEnumVerifier);
  }
  
  private static MessageInfo a(Class<?> paramClass, Descriptors.Descriptor paramDescriptor)
  {
    int i = DescriptorMessageInfoFactory.3.a[paramDescriptor.d().j().ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return c(paramClass, paramDescriptor);
      }
      paramClass = new StringBuilder();
      paramClass.append("Unsupported syntax: ");
      paramClass.append(paramDescriptor.d().j());
      throw new IllegalArgumentException(paramClass.toString());
    }
    return b(paramClass, paramDescriptor);
  }
  
  private static Class<?> a(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor, FieldType paramFieldType)
  {
    switch (DescriptorMessageInfoFactory.3.b[paramFieldType.getJavaType().ordinal()])
    {
    default: 
      paramClass = new StringBuilder();
      paramClass.append("Invalid type for oneof: ");
      paramClass.append(paramFieldType);
      throw new IllegalArgumentException(paramClass.toString());
    case 9: 
      return c(paramClass, paramFieldDescriptor);
    case 8: 
      return String.class;
    case 7: 
      return Long.class;
    case 5: 
    case 6: 
      return Integer.class;
    case 4: 
      return Float.class;
    case 3: 
      return Double.class;
    case 2: 
      return ByteString.class;
    }
    return Boolean.class;
  }
  
  static String a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.GROUP) {
      paramFieldDescriptor = paramFieldDescriptor.y().b();
    } else {
      paramFieldDescriptor = paramFieldDescriptor.b();
    }
    String str;
    if (b.contains(paramFieldDescriptor)) {
      str = "__";
    } else {
      str = "_";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramFieldDescriptor));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private static Field a(Class<?> paramClass, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bitField");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    return b(paramClass, localStringBuilder.toString());
  }
  
  private static Field a(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return b(paramClass, a(paramFieldDescriptor));
  }
  
  private static boolean a(Descriptors.Descriptor paramDescriptor)
  {
    return c.a(paramDescriptor);
  }
  
  private static FieldType b(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    switch (DescriptorMessageInfoFactory.3.c[paramFieldDescriptor.i().ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported field type: ");
      localStringBuilder.append(paramFieldDescriptor.i());
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 18: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.UINT64;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.UINT64_LIST_PACKED;
      }
      return FieldType.UINT64_LIST;
    case 17: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.UINT32;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.UINT32_LIST_PACKED;
      }
      return FieldType.UINT32_LIST;
    case 16: 
      if (paramFieldDescriptor.p()) {
        return FieldType.STRING_LIST;
      }
      return FieldType.STRING;
    case 15: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.SINT64;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.SINT64_LIST_PACKED;
      }
      return FieldType.SINT64_LIST;
    case 14: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.SINT32;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.SINT32_LIST_PACKED;
      }
      return FieldType.SINT32_LIST;
    case 13: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.SFIXED64;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.SFIXED64_LIST_PACKED;
      }
      return FieldType.SFIXED64_LIST;
    case 12: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.SFIXED32;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.SFIXED32_LIST_PACKED;
      }
      return FieldType.SFIXED32_LIST;
    case 11: 
      if (paramFieldDescriptor.m()) {
        return FieldType.MAP;
      }
      if (paramFieldDescriptor.p()) {
        return FieldType.MESSAGE_LIST;
      }
      return FieldType.MESSAGE;
    case 10: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.INT64;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.INT64_LIST_PACKED;
      }
      return FieldType.INT64_LIST;
    case 9: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.INT32;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.INT32_LIST_PACKED;
      }
      return FieldType.INT32_LIST;
    case 8: 
      if (paramFieldDescriptor.p()) {
        return FieldType.GROUP_LIST;
      }
      return FieldType.GROUP;
    case 7: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.FLOAT;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.FLOAT_LIST_PACKED;
      }
      return FieldType.FLOAT_LIST;
    case 6: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.FIXED64;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.FIXED64_LIST_PACKED;
      }
      return FieldType.FIXED64_LIST;
    case 5: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.FIXED32;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.FIXED32_LIST_PACKED;
      }
      return FieldType.FIXED32_LIST;
    case 4: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.ENUM;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.ENUM_LIST_PACKED;
      }
      return FieldType.ENUM_LIST;
    case 3: 
      if (!paramFieldDescriptor.p()) {
        return FieldType.DOUBLE;
      }
      if (paramFieldDescriptor.q()) {
        return FieldType.DOUBLE_LIST_PACKED;
      }
      return FieldType.DOUBLE_LIST;
    case 2: 
      if (paramFieldDescriptor.p()) {
        return FieldType.BYTES_LIST;
      }
      return FieldType.BYTES;
    }
    if (!paramFieldDescriptor.p()) {
      return FieldType.BOOL;
    }
    if (paramFieldDescriptor.q()) {
      return FieldType.BOOL_LIST_PACKED;
    }
    return FieldType.BOOL_LIST;
  }
  
  private static StructuralMessageInfo b(Class<?> paramClass, Descriptors.Descriptor paramDescriptor)
  {
    List localList = paramDescriptor.f();
    StructuralMessageInfo.Builder localBuilder = StructuralMessageInfo.a(localList.size());
    localBuilder.a(c(paramClass));
    localBuilder.a(ProtoSyntax.PROTO2);
    localBuilder.a(paramDescriptor.e().getMessageSetWireFormat());
    DescriptorMessageInfoFactory.OneofState localOneofState = new DescriptorMessageInfoFactory.OneofState(null);
    int m = 0;
    paramDescriptor = null;
    int j = 0;
    int k = 0;
    int i = 1;
    while (j < localList.size())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)localList.get(j);
      boolean bool = localFieldDescriptor.d().f().getJavaStringCheckUtf8();
      Object localObject1;
      if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.ENUM) {
        localObject1 = new DescriptorMessageInfoFactory.1(localFieldDescriptor);
      } else {
        localObject1 = null;
      }
      if (localFieldDescriptor.w() != null)
      {
        localBuilder.a(a(paramClass, localFieldDescriptor, localOneofState, bool, (Internal.EnumVerifier)localObject1));
      }
      else
      {
        Field localField = a(paramClass, localFieldDescriptor);
        int n = localFieldDescriptor.f();
        FieldType localFieldType = b(localFieldDescriptor);
        if (localFieldDescriptor.m())
        {
          localObject2 = localFieldDescriptor.y().b(2);
          if (((Descriptors.FieldDescriptor)localObject2).g() == Descriptors.FieldDescriptor.JavaType.ENUM) {
            localObject1 = new DescriptorMessageInfoFactory.2((Descriptors.FieldDescriptor)localObject2);
          }
          localBuilder.a(FieldInfo.a(localField, n, SchemaUtil.a(paramClass, localFieldDescriptor.b()), (Internal.EnumVerifier)localObject1));
          break label495;
        }
        if (localFieldDescriptor.p())
        {
          if (localObject1 != null)
          {
            if (localFieldDescriptor.q())
            {
              localBuilder.a(FieldInfo.a(localField, n, localFieldType, (Internal.EnumVerifier)localObject1, b(paramClass, localFieldDescriptor)));
              break label495;
            }
            localBuilder.a(FieldInfo.a(localField, n, localFieldType, (Internal.EnumVerifier)localObject1));
            break label495;
          }
          if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
          {
            localBuilder.a(FieldInfo.a(localField, n, localFieldType, d(paramClass, localFieldDescriptor)));
            break label495;
          }
          if (localFieldDescriptor.q())
          {
            localBuilder.a(FieldInfo.a(localField, n, localFieldType, b(paramClass, localFieldDescriptor)));
            break label495;
          }
          localBuilder.a(FieldInfo.a(localField, n, localFieldType, bool));
          break label495;
        }
        Object localObject2 = paramDescriptor;
        if (paramDescriptor == null) {
          localObject2 = a(paramClass, k);
        }
        if (localFieldDescriptor.n())
        {
          localBuilder.a(FieldInfo.b(localField, n, localFieldType, (Field)localObject2, i, bool, (Internal.EnumVerifier)localObject1));
          paramDescriptor = (Descriptors.Descriptor)localObject2;
        }
        else
        {
          localBuilder.a(FieldInfo.a(localField, n, localFieldType, (Field)localObject2, i, bool, (Internal.EnumVerifier)localObject1));
          paramDescriptor = (Descriptors.Descriptor)localObject2;
        }
      }
      i <<= 1;
      if (i == 0)
      {
        k += 1;
        paramDescriptor = null;
        i = 1;
      }
      label495:
      j += 1;
    }
    paramClass = new ArrayList();
    i = 0;
    while (i < localList.size())
    {
      paramDescriptor = (Descriptors.FieldDescriptor)localList.get(i);
      if ((paramDescriptor.n()) || ((paramDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) && (a(paramDescriptor.y())))) {
        paramClass.add(Integer.valueOf(paramDescriptor.f()));
      }
      i += 1;
    }
    paramDescriptor = new int[paramClass.size()];
    i = m;
    while (i < paramClass.size())
    {
      paramDescriptor[i] = ((Integer)paramClass.get(i)).intValue();
      i += 1;
    }
    localBuilder.a(paramDescriptor);
    return localBuilder.a();
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 1);
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      char c1 = paramString.charAt(j);
      if (c1 == '_') {}
      for (;;)
      {
        i = 1;
        break label104;
        if (!Character.isDigit(c1)) {
          break;
        }
        localStringBuilder.append(c1);
      }
      if (i != 0)
      {
        localStringBuilder.append(Character.toUpperCase(c1));
        i = 0;
      }
      else if (j == 0)
      {
        localStringBuilder.append(Character.toLowerCase(c1));
      }
      else
      {
        localStringBuilder.append(c1);
      }
      label104:
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static Field b(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return b(paramClass, c(paramFieldDescriptor));
  }
  
  private static Field b(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject = paramClass.getDeclaredField(paramString);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label8:
      break label8;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to find field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" in message class ");
    ((StringBuilder)localObject).append(paramClass.getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static Message c(Class<?> paramClass)
  {
    try
    {
      Message localMessage = (Message)paramClass.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
      return localMessage;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to get default instance for message class ");
      localStringBuilder.append(paramClass.getName());
      throw new IllegalArgumentException(localStringBuilder.toString(), localException);
    }
  }
  
  private static StructuralMessageInfo c(Class<?> paramClass, Descriptors.Descriptor paramDescriptor)
  {
    paramDescriptor = paramDescriptor.f();
    StructuralMessageInfo.Builder localBuilder = StructuralMessageInfo.a(paramDescriptor.size());
    localBuilder.a(c(paramClass));
    localBuilder.a(ProtoSyntax.PROTO3);
    DescriptorMessageInfoFactory.OneofState localOneofState = new DescriptorMessageInfoFactory.OneofState(null);
    int i = 0;
    while (i < paramDescriptor.size())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)paramDescriptor.get(i);
      if (localFieldDescriptor.w() != null) {
        localBuilder.a(a(paramClass, localFieldDescriptor, localOneofState, true, null));
      } else if (localFieldDescriptor.m()) {
        localBuilder.a(FieldInfo.a(a(paramClass, localFieldDescriptor), localFieldDescriptor.f(), SchemaUtil.a(paramClass, localFieldDescriptor.b()), null));
      } else if ((localFieldDescriptor.p()) && (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
        localBuilder.a(FieldInfo.a(a(paramClass, localFieldDescriptor), localFieldDescriptor.f(), b(localFieldDescriptor), d(paramClass, localFieldDescriptor)));
      } else if (localFieldDescriptor.q()) {
        localBuilder.a(FieldInfo.a(a(paramClass, localFieldDescriptor), localFieldDescriptor.f(), b(localFieldDescriptor), b(paramClass, localFieldDescriptor)));
      } else {
        localBuilder.a(FieldInfo.a(a(paramClass, localFieldDescriptor), localFieldDescriptor.f(), b(localFieldDescriptor), true));
      }
      i += 1;
    }
    return localBuilder.a();
  }
  
  private static Class<?> c(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    try
    {
      if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.GROUP) {
        paramFieldDescriptor = paramFieldDescriptor.y().b();
      } else {
        paramFieldDescriptor = paramFieldDescriptor.b();
      }
      paramClass = paramClass.getDeclaredMethod(c(paramFieldDescriptor), new Class[0]).getReturnType();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  private static String c(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramFieldDescriptor.b()));
    localStringBuilder.append("MemoizedSerializedSize");
    return localStringBuilder.toString();
  }
  
  private static String c(String paramString)
  {
    paramString = b(paramString);
    StringBuilder localStringBuilder = new StringBuilder("get");
    localStringBuilder.append(Character.toUpperCase(paramString.charAt(0)));
    localStringBuilder.append(paramString.substring(1, paramString.length()));
    return localStringBuilder.toString();
  }
  
  private static Descriptors.Descriptor d(Class<?> paramClass)
  {
    return c(paramClass).getDescriptorForType();
  }
  
  private static Class<?> d(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    try
    {
      if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.GROUP) {
        paramFieldDescriptor = paramFieldDescriptor.y().b();
      } else {
        paramFieldDescriptor = paramFieldDescriptor.b();
      }
      paramClass = paramClass.getDeclaredMethod(c(paramFieldDescriptor), new Class[] { Integer.TYPE }).getReturnType();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  public boolean a(Class<?> paramClass)
  {
    return GeneratedMessageV3.class.isAssignableFrom(paramClass);
  }
  
  public MessageInfo b(Class<?> paramClass)
  {
    if (GeneratedMessageV3.class.isAssignableFrom(paramClass)) {
      return a(paramClass, d(paramClass));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported message type: ");
    localStringBuilder.append(paramClass.getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorMessageInfoFactory
 * JD-Core Version:    0.7.0.1
 */