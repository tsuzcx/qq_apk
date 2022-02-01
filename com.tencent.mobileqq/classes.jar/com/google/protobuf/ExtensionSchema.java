package com.google.protobuf;

import java.util.Map.Entry;

abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>>
{
  abstract int a(Map.Entry<?, ?> paramEntry);
  
  abstract FieldSet<T> a(Object paramObject);
  
  abstract Object a(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt);
  
  abstract <UT, UB> UB a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema);
  
  abstract void a(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet);
  
  abstract void a(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet);
  
  abstract void a(Writer paramWriter, Map.Entry<?, ?> paramEntry);
  
  abstract void a(Object paramObject, FieldSet<T> paramFieldSet);
  
  abstract boolean a(MessageLite paramMessageLite);
  
  abstract FieldSet<T> b(Object paramObject);
  
  abstract void c(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionSchema
 * JD-Core Version:    0.7.0.1
 */