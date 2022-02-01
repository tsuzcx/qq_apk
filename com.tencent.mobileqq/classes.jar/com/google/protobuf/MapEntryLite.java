package com.google.protobuf;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class MapEntryLite<K, V>
{
  private final MapEntryLite.Metadata<K, V> a;
  
  static <K, V> int a(MapEntryLite.Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    return FieldSet.a(paramMetadata.c, 1, paramK) + FieldSet.a(paramMetadata.e, 2, paramV);
  }
  
  static <T> T a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, WireFormat.FieldType paramFieldType, T paramT)
  {
    int i = MapEntryLite.1.a[paramFieldType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return FieldSet.a(paramCodedInputStream, paramFieldType, true);
        }
        throw new RuntimeException("Groups are not allowed in maps.");
      }
      return Integer.valueOf(paramCodedInputStream.n());
    }
    paramFieldType = ((MessageLite)paramT).toBuilder();
    paramCodedInputStream.a(paramFieldType, paramExtensionRegistryLite);
    return paramFieldType.buildPartial();
  }
  
  static <K, V> Map.Entry<K, V> a(CodedInputStream paramCodedInputStream, MapEntryLite.Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    Object localObject2 = paramMetadata.d;
    Object localObject1 = paramMetadata.f;
    int i;
    do
    {
      for (;;)
      {
        i = paramCodedInputStream.a();
        if (i == 0) {
          break label94;
        }
        if (i == WireFormat.a(1, paramMetadata.c.getWireType()))
        {
          localObject2 = a(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.c, localObject2);
        }
        else
        {
          if (i != WireFormat.a(2, paramMetadata.e.getWireType())) {
            break;
          }
          localObject1 = a(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.e, localObject1);
        }
      }
    } while (paramCodedInputStream.b(i));
    label94:
    return new AbstractMap.SimpleImmutableEntry(localObject2, localObject1);
  }
  
  static <K, V> void a(CodedOutputStream paramCodedOutputStream, MapEntryLite.Metadata<K, V> paramMetadata, K paramK, V paramV)
  {
    FieldSet.a(paramCodedOutputStream, paramMetadata.c, 1, paramK);
    FieldSet.a(paramCodedOutputStream, paramMetadata.e, 2, paramV);
  }
  
  public int a(int paramInt, K paramK, V paramV)
  {
    return CodedOutputStream.h(paramInt) + CodedOutputStream.o(a(this.a, paramK, paramV));
  }
  
  MapEntryLite.Metadata<K, V> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapEntryLite
 * JD-Core Version:    0.7.0.1
 */