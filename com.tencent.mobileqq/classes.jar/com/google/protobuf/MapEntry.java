package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class MapEntry<K, V>
  extends AbstractMessage
{
  private final K a;
  private final V b;
  private final MapEntry.Metadata<K, V> c;
  private volatile int d = -1;
  
  private MapEntry(Descriptors.Descriptor paramDescriptor, WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    this.a = paramK;
    this.b = paramV;
    this.c = new MapEntry.Metadata(paramDescriptor, this, paramFieldType1, paramFieldType2);
  }
  
  private MapEntry(MapEntry.Metadata<K, V> paramMetadata, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      this.c = paramMetadata;
      paramMetadata = MapEntryLite.a(paramCodedInputStream, paramMetadata, paramExtensionRegistryLite);
      this.a = paramMetadata.getKey();
      this.b = paramMetadata.getValue();
      return;
    }
    catch (IOException paramMetadata)
    {
      throw new InvalidProtocolBufferException(paramMetadata).setUnfinishedMessage(this);
    }
    catch (InvalidProtocolBufferException paramMetadata)
    {
      throw paramMetadata.setUnfinishedMessage(this);
    }
  }
  
  private MapEntry(MapEntry.Metadata paramMetadata, K paramK, V paramV)
  {
    this.a = paramK;
    this.b = paramV;
    this.c = paramMetadata;
  }
  
  public static <K, V> MapEntry<K, V> a(Descriptors.Descriptor paramDescriptor, WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV)
  {
    return new MapEntry(paramDescriptor, paramFieldType1, paramK, paramFieldType2, paramV);
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.c.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong FieldDescriptor \"");
    localStringBuilder.append(paramFieldDescriptor.c());
    localStringBuilder.append("\" used in message \"");
    localStringBuilder.append(this.c.a.c());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private static <V> boolean b(MapEntry.Metadata paramMetadata, V paramV)
  {
    if (paramMetadata.e.getJavaType() == WireFormat.JavaType.MESSAGE) {
      return ((MessageLite)paramV).isInitialized();
    }
    return true;
  }
  
  public K a()
  {
    return this.a;
  }
  
  public V b()
  {
    return this.b;
  }
  
  public MapEntry.Builder<K, V> c()
  {
    return new MapEntry.Builder(this.c, null);
  }
  
  public MapEntry.Builder<K, V> d()
  {
    return new MapEntry.Builder(this.c, this.a, this.b, true, true, null);
  }
  
  public MapEntry<K, V> e()
  {
    MapEntry.Metadata localMetadata = this.c;
    return new MapEntry(localMetadata, localMetadata.d, this.c.f);
  }
  
  final MapEntry.Metadata<K, V> f()
  {
    return this.c;
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = this.c.a.f().iterator();
    while (localIterator.hasNext())
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)localIterator.next();
      if (hasField(localFieldDescriptor)) {
        localTreeMap.put(localFieldDescriptor, getField(localFieldDescriptor));
      }
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return this.c.a;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    a(paramFieldDescriptor);
    Object localObject1;
    if (paramFieldDescriptor.f() == 1) {
      localObject1 = a();
    } else {
      localObject1 = b();
    }
    Object localObject2 = localObject1;
    if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.ENUM) {
      localObject2 = paramFieldDescriptor.z().b(((Integer)localObject1).intValue());
    }
    return localObject2;
  }
  
  public Parser<MapEntry<K, V>> getParserForType()
  {
    return this.c.b;
  }
  
  public int getSerializedSize()
  {
    if (this.d != -1) {
      return this.d;
    }
    int i = MapEntryLite.a(this.c, this.a, this.b);
    this.d = i;
    return i;
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    return UnknownFieldSet.b();
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    a(paramFieldDescriptor);
    return true;
  }
  
  public boolean isInitialized()
  {
    return b(this.c, this.b);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    MapEntryLite.a(paramCodedOutputStream, this.c, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapEntry
 * JD-Core Version:    0.7.0.1
 */