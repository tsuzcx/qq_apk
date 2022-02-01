package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor
  implements GeneratedMessageV3.FieldAccessorTable.FieldAccessor
{
  private final Descriptors.FieldDescriptor a;
  private final Message b;
  
  GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor(Descriptors.FieldDescriptor paramFieldDescriptor, String paramString, Class<? extends GeneratedMessageV3> paramClass, Class<? extends GeneratedMessageV3.Builder> paramClass1)
  {
    this.a = paramFieldDescriptor;
    this.b = e((GeneratedMessageV3)GeneratedMessageV3.access$1100(GeneratedMessageV3.access$1000(paramClass, "getDefaultInstance", new Class[0]), null, new Object[0])).g();
  }
  
  private Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    if (this.b.getClass().isInstance(paramMessage)) {
      return paramMessage;
    }
    return this.b.toBuilder().mergeFrom(paramMessage).build();
  }
  
  private MapField<?, ?> e(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return paramGeneratedMessageV3.internalGetMapField(this.a.f());
  }
  
  private MapField<?, ?> f(GeneratedMessageV3.Builder paramBuilder)
  {
    return paramBuilder.internalGetMapField(this.a.f());
  }
  
  private MapField<?, ?> g(GeneratedMessageV3.Builder paramBuilder)
  {
    return paramBuilder.internalGetMutableMapField(this.a.f());
  }
  
  public Message.Builder a()
  {
    return this.b.newBuilderForType();
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < c(paramBuilder))
    {
      localArrayList.add(a(paramBuilder, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    return f(paramBuilder).e().get(paramInt);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < d(paramGeneratedMessageV3))
    {
      localArrayList.add(a(paramGeneratedMessageV3, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessageV3 paramGeneratedMessageV3, int paramInt)
  {
    return e(paramGeneratedMessageV3).e().get(paramInt);
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, int paramInt, Object paramObject)
  {
    g(paramBuilder).f().set(paramInt, a((Message)paramObject));
  }
  
  public void a(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    d(paramBuilder);
    paramObject = ((List)paramObject).iterator();
    while (paramObject.hasNext()) {
      b(paramBuilder, paramObject.next());
    }
  }
  
  public Message.Builder b(GeneratedMessageV3.Builder paramBuilder, int paramInt)
  {
    throw new UnsupportedOperationException("Nested builder not supported for map fields.");
  }
  
  public Object b(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return a(paramGeneratedMessageV3);
  }
  
  public void b(GeneratedMessageV3.Builder paramBuilder, Object paramObject)
  {
    g(paramBuilder).f().add(a((Message)paramObject));
  }
  
  public boolean b(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
  }
  
  public int c(GeneratedMessageV3.Builder paramBuilder)
  {
    return f(paramBuilder).e().size();
  }
  
  public boolean c(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
  }
  
  public int d(GeneratedMessageV3 paramGeneratedMessageV3)
  {
    return e(paramGeneratedMessageV3).e().size();
  }
  
  public void d(GeneratedMessageV3.Builder paramBuilder)
  {
    g(paramBuilder).f().clear();
  }
  
  public Message.Builder e(GeneratedMessageV3.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("Nested builder not supported for map fields.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.FieldAccessorTable.MapFieldAccessor
 * JD-Core Version:    0.7.0.1
 */