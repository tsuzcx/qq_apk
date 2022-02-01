package com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessageV3$FieldAccessorTable$SingularMessageFieldAccessor
  extends GeneratedMessageV3.FieldAccessorTable.SingularFieldAccessor
{
  private final Method m = GeneratedMessageV3.access$1000(this.a, "newBuilder", new Class[0]);
  private final Method n;
  
  GeneratedMessageV3$FieldAccessorTable$SingularMessageFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString1, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1, String paramString2)
  {
    super(paramFieldDescriptor, paramString1, paramClass, paramClass1, paramString2);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString1);
    paramFieldDescriptor.append("Builder");
    this.n = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[0]);
  }
  
  private Object a(Object paramObject)
  {
    if (this.a.isInstance(paramObject)) {
      return paramObject;
    }
    return ((Message.Builder)GeneratedMessageV3.access$1100(this.m, null, new Object[0])).mergeFrom((Message)paramObject).buildPartial();
  }
  
  public Message.Builder a()
  {
    return (Message.Builder)GeneratedMessageV3.access$1100(this.m, null, new Object[0]);
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    super.a(paramBuilder, a(paramObject));
  }
  
  public Message.Builder e(GeneratedMessageV3.Builder paramBuilder)
  {
    return (Message.Builder)GeneratedMessageV3.access$1100(this.n, paramBuilder, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.SingularMessageFieldAccessor
 * JD-Core Version:    0.7.0.1
 */