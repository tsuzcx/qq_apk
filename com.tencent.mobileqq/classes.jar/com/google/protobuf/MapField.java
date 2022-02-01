package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapField<K, V>
  implements MutabilityOracle
{
  private volatile boolean b;
  private volatile MapField.StorageMode c;
  private MapField.MutatabilityAwareMap<K, V> d;
  private List<Message> e;
  private final MapField.Converter<K, V> f;
  
  private MapField(MapEntry<K, V> paramMapEntry, MapField.StorageMode paramStorageMode, Map<K, V> paramMap)
  {
    this(new MapField.ImmutableMessageConverter(paramMapEntry), paramStorageMode, paramMap);
  }
  
  private MapField(MapField.Converter<K, V> paramConverter, MapField.StorageMode paramStorageMode, Map<K, V> paramMap)
  {
    this.f = paramConverter;
    this.b = true;
    this.c = paramStorageMode;
    this.d = new MapField.MutatabilityAwareMap(this, paramMap);
    this.e = null;
  }
  
  private MapField.MutatabilityAwareMap<K, V> a(List<Message> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((Message)paramList.next(), localLinkedHashMap);
    }
    return new MapField.MutatabilityAwareMap(this, localLinkedHashMap);
  }
  
  public static <K, V> MapField<K, V> a(MapEntry<K, V> paramMapEntry)
  {
    return new MapField(paramMapEntry, MapField.StorageMode.MAP, Collections.emptyMap());
  }
  
  private Message a(K paramK, V paramV)
  {
    return this.f.a(paramK, paramV);
  }
  
  private List<Message> a(MapField.MutatabilityAwareMap<K, V> paramMutatabilityAwareMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMutatabilityAwareMap = paramMutatabilityAwareMap.entrySet().iterator();
    while (paramMutatabilityAwareMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMutatabilityAwareMap.next();
      localArrayList.add(a(localEntry.getKey(), localEntry.getValue()));
    }
    return localArrayList;
  }
  
  private void a(Message paramMessage, Map<K, V> paramMap)
  {
    this.f.a(paramMessage, paramMap);
  }
  
  public static <K, V> MapField<K, V> b(MapEntry<K, V> paramMapEntry)
  {
    return new MapField(paramMapEntry, MapField.StorageMode.MAP, new LinkedHashMap());
  }
  
  public Map<K, V> a()
  {
    if (this.c == MapField.StorageMode.LIST) {
      try
      {
        if (this.c == MapField.StorageMode.LIST)
        {
          this.d = a(this.e);
          this.c = MapField.StorageMode.BOTH;
        }
      }
      finally {}
    }
    return Collections.unmodifiableMap(this.d);
  }
  
  public void a(MapField<K, V> paramMapField)
  {
    b().putAll(MapFieldLite.copy(paramMapField.a()));
  }
  
  public Map<K, V> b()
  {
    if (this.c != MapField.StorageMode.MAP)
    {
      if (this.c == MapField.StorageMode.LIST) {
        this.d = a(this.e);
      }
      this.e = null;
      this.c = MapField.StorageMode.MAP;
    }
    return this.d;
  }
  
  public void c()
  {
    this.d = new MapField.MutatabilityAwareMap(this, new LinkedHashMap());
    this.c = MapField.StorageMode.MAP;
  }
  
  public MapField<K, V> d()
  {
    return new MapField(this.f, MapField.StorageMode.MAP, MapFieldLite.copy(a()));
  }
  
  List<Message> e()
  {
    if (this.c == MapField.StorageMode.MAP) {
      try
      {
        if (this.c == MapField.StorageMode.MAP)
        {
          this.e = a(this.d);
          this.c = MapField.StorageMode.BOTH;
        }
      }
      finally {}
    }
    return Collections.unmodifiableList(this.e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MapField)) {
      return false;
    }
    paramObject = (MapField)paramObject;
    return MapFieldLite.equals(a(), paramObject.a());
  }
  
  List<Message> f()
  {
    if (this.c != MapField.StorageMode.LIST)
    {
      if (this.c == MapField.StorageMode.MAP) {
        this.e = a(this.d);
      }
      this.d = null;
      this.c = MapField.StorageMode.LIST;
    }
    return this.e;
  }
  
  Message g()
  {
    return this.f.a();
  }
  
  public void h()
  {
    this.b = false;
  }
  
  public int hashCode()
  {
    return MapFieldLite.calculateHashCodeForMap(a());
  }
  
  public boolean i()
  {
    return this.b;
  }
  
  public void j()
  {
    if (i()) {
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField
 * JD-Core Version:    0.7.0.1
 */