package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter
{
  private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> b = GeneratedMessage.ExtendableMessage.access$600(this.a).i();
  private Map.Entry<Descriptors.FieldDescriptor, Object> c;
  private final boolean d;
  
  private GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage.ExtendableMessage paramExtendableMessage, boolean paramBoolean)
  {
    if (this.b.hasNext()) {
      this.c = ((Map.Entry)this.b.next());
    }
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionWriter
 * JD-Core Version:    0.7.0.1
 */