package com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor
  extends GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor
{
  private final Method m;
  private final Method n;
  private final Method o;
  
  GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString1, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1, String paramString2)
  {
    super(paramFieldDescriptor, paramString1, paramClass, paramClass1, paramString2);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString1);
    paramFieldDescriptor.append("Bytes");
    this.m = GeneratedMessageV3.access$1000(paramClass, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString1);
    paramFieldDescriptor.append("Bytes");
    this.n = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("set");
    paramFieldDescriptor.append(paramString1);
    paramFieldDescriptor.append("Bytes");
    this.o = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { ByteString.class });
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    if ((paramObject instanceof ByteString))
    {
      GeneratedMessageV3.access$1100(this.o, paramBuilder, new Object[] { paramObject });
      return;
    }
    super.a(paramBuilder, paramObject);
  }
  
  public Object b(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return GeneratedMessageV3.access$1100(this.m, paramGeneratedMessageV3, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularStringFieldAccessor
 * JD-Core Version:    0.7.0.1
 */