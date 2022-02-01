package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessageV3$ExtendableMessage$ExtensionWriter
{
  private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> b = GeneratedMessageV3.ExtendableMessage.access$600(this.a).i();
  private Map.Entry<Descriptors.FieldDescriptor, Object> c;
  private final boolean d;
  
  private GeneratedMessageV3$ExtendableMessage$ExtensionWriter(GeneratedMessageV3.ExtendableMessage paramExtendableMessage, boolean paramBoolean)
  {
    if (this.b.hasNext()) {
      this.c = ((Map.Entry)this.b.next());
    }
    this.d = paramBoolean;
  }
  
  public void a(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    for (;;)
    {
      Object localObject = this.c;
      if ((localObject == null) || (((Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey()).f() >= paramInt)) {
        break;
      }
      localObject = (Descriptors.FieldDescriptor)this.c.getKey();
      if ((this.d) && (((Descriptors.FieldDescriptor)localObject).h() == WireFormat.JavaType.MESSAGE) && (!((Descriptors.FieldDescriptor)localObject).p()))
      {
        if ((this.c instanceof LazyField.LazyEntry)) {
          paramCodedOutputStream.b(((Descriptors.FieldDescriptor)localObject).f(), ((LazyField.LazyEntry)this.c).a().c());
        } else {
          paramCodedOutputStream.b(((Descriptors.FieldDescriptor)localObject).f(), (Message)this.c.getValue());
        }
      }
      else {
        FieldSet.a((FieldSet.FieldDescriptorLite)localObject, this.c.getValue(), paramCodedOutputStream);
      }
      if (this.b.hasNext()) {
        this.c = ((Map.Entry)this.b.next());
      } else {
        this.c = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.ExtendableMessage.ExtensionWriter
 * JD-Core Version:    0.7.0.1
 */