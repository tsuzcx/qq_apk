package com.google.protobuf;

final class GeneratedMessageLite$ExtensionDescriptor
  implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
{
  final Internal.EnumLiteMap<?> a;
  final int b;
  final WireFormat.FieldType c;
  final boolean d;
  final boolean e;
  
  public int a(ExtensionDescriptor paramExtensionDescriptor)
  {
    return this.b - paramExtensionDescriptor.b;
  }
  
  public Internal.EnumLiteMap<?> a()
  {
    return this.a;
  }
  
  public MessageLite.Builder a(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
  {
    return ((GeneratedMessageLite.Builder)paramBuilder).a((GeneratedMessageLite)paramMessageLite);
  }
  
  public int f()
  {
    return this.b;
  }
  
  public WireFormat.JavaType h()
  {
    return this.c.getJavaType();
  }
  
  public WireFormat.FieldType j()
  {
    return this.c;
  }
  
  public boolean p()
  {
    return this.d;
  }
  
  public boolean q()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor
 * JD-Core Version:    0.7.0.1
 */