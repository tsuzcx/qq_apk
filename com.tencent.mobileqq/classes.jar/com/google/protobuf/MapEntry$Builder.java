package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapEntry$Builder<K, V>
  extends AbstractMessage.Builder<Builder<K, V>>
{
  private final MapEntry.Metadata<K, V> a;
  private K b;
  private V c;
  private boolean d;
  private boolean e;
  
  private MapEntry$Builder(MapEntry.Metadata<K, V> paramMetadata)
  {
    this(paramMetadata, paramMetadata.d, paramMetadata.f, false, false);
  }
  
  private MapEntry$Builder(MapEntry.Metadata<K, V> paramMetadata, K paramK, V paramV, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramMetadata;
    this.b = paramK;
    this.c = paramV;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  private void b(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.a.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong FieldDescriptor \"");
    localStringBuilder.append(paramFieldDescriptor.c());
    localStringBuilder.append("\" used in message \"");
    localStringBuilder.append(this.a.a.c());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public Builder<K, V> a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    b(paramFieldDescriptor);
    if (paramFieldDescriptor.f() == 1)
    {
      c();
      return this;
    }
    d();
    return this;
  }
  
  public Builder<K, V> a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    b(paramFieldDescriptor);
    if (paramFieldDescriptor.f() == 1)
    {
      a(paramObject);
      return this;
    }
    Object localObject;
    if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.ENUM)
    {
      localObject = Integer.valueOf(((Descriptors.EnumValueDescriptor)paramObject).getNumber());
    }
    else
    {
      localObject = paramObject;
      if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.MESSAGE)
      {
        localObject = paramObject;
        if (paramObject != null)
        {
          localObject = paramObject;
          if (!this.a.f.getClass().isInstance(paramObject)) {
            localObject = ((Message)this.a.f).toBuilder().mergeFrom((Message)paramObject).build();
          }
        }
      }
    }
    b(localObject);
    return this;
  }
  
  public Builder<K, V> a(UnknownFieldSet paramUnknownFieldSet)
  {
    return this;
  }
  
  public Builder<K, V> a(K paramK)
  {
    this.b = paramK;
    this.d = true;
    return this;
  }
  
  public K a()
  {
    return this.b;
  }
  
  public Builder<K, V> b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    throw new RuntimeException("There is no repeated field in a map entry message.");
  }
  
  public Builder<K, V> b(V paramV)
  {
    this.c = paramV;
    this.e = true;
    return this;
  }
  
  public V b()
  {
    return this.c;
  }
  
  public Builder<K, V> c()
  {
    this.b = this.a.d;
    this.d = false;
    return this;
  }
  
  public Builder<K, V> d()
  {
    this.c = this.a.f;
    this.e = false;
    return this;
  }
  
  public MapEntry<K, V> e()
  {
    MapEntry localMapEntry = f();
    if (localMapEntry.isInitialized()) {
      return localMapEntry;
    }
    throw newUninitializedMessageException(localMapEntry);
  }
  
  public MapEntry<K, V> f()
  {
    return new MapEntry(this.a, this.b, this.c, null);
  }
  
  public MapEntry<K, V> g()
  {
    MapEntry.Metadata localMetadata = this.a;
    return new MapEntry(localMetadata, localMetadata.d, this.a.f, null);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = this.a.a.f().iterator();
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
    return this.a.a;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    b(paramFieldDescriptor);
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
  
  public UnknownFieldSet getUnknownFields()
  {
    return UnknownFieldSet.b();
  }
  
  public Builder<K, V> h()
  {
    return new Builder(this.a, this.b, this.c, this.d, this.e);
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    b(paramFieldDescriptor);
    if (paramFieldDescriptor.f() == 1) {
      return this.d;
    }
    return this.e;
  }
  
  public boolean isInitialized()
  {
    return MapEntry.a(this.a, this.c);
  }
  
  public Message.Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    b(paramFieldDescriptor);
    if ((paramFieldDescriptor.f() == 2) && (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
      return ((Message)this.c).newBuilderForType();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(paramFieldDescriptor.c());
    localStringBuilder.append("\" is not a message value field.");
    throw new RuntimeException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapEntry.Builder
 * JD-Core Version:    0.7.0.1
 */