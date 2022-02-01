package com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor
  extends GeneratedMessageV3.FieldAccessorTable.RepeatedFieldAccessor
{
  private final Method k = GeneratedMessageV3.access$1000(this.a, "newBuilder", new Class[0]);
  private final Method l;
  
  GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    super(paramFieldDescriptor, paramString, paramClass, paramClass1);
    paramFieldDescriptor = new StringBuilder();
    paramFieldDescriptor.append("get");
    paramFieldDescriptor.append(paramString);
    paramFieldDescriptor.append("Builder");
    this.l = GeneratedMessageV3.access$1000(paramClass1, paramFieldDescriptor.toString(), new Class[] { Integer.TYPE });
  }
  
  private Object a(Object paramObject)
  {
    if (this.a.isInstance(paramObject)) {
      return paramObject;
    }
    return ((Message.Builder)GeneratedMessageV3.access$1100(this.k, null, new Object[0])).mergeFrom((Message)paramObject).build();
  }
  
  public Message.Builder a()
  {
    return (Message.Builder)GeneratedMessageV3.access$1100(this.k, null, new Object[0]);
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, int paramInt, Object paramObject)
  {
    super.a(paramBuilder, paramInt, a(paramObject));
  }
  
  public Message.Builder b(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    return (Message.Builder)GeneratedMessageV3.access$1100(this.l, paramBuilder, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void b(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    super.b(paramBuilder, a(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.RepeatedMessageFieldAccessor
 * JD-Core Version:    0.7.0.1
 */