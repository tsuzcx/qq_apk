package com.google.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int a;
  private List<SmallSortedMap<K, V>.Entry> b;
  private Map<K, V> c;
  private boolean d;
  private volatile SmallSortedMap<K, V>.EntrySet e;
  private Map<K, V> f;
  private volatile SmallSortedMap<K, V>.DescendingEntrySet g;
  
  private SmallSortedMap(int paramInt)
  {
    this.a = paramInt;
    this.b = Collections.emptyList();
    this.c = Collections.emptyMap();
    this.f = Collections.emptyMap();
  }
  
  private int a(K paramK)
  {
    int j = this.b.size() - 1;
    if (j >= 0)
    {
      i = paramK.compareTo(((SmallSortedMap.Entry)this.b.get(j)).a());
      if (i > 0) {
        return -(j + 2);
      }
      if (i == 0) {
        return j;
      }
    }
    int i = 0;
    while (i <= j)
    {
      int k = (i + j) / 2;
      int m = paramK.compareTo(((SmallSortedMap.Entry)this.b.get(k)).a());
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return k;
      }
    }
    return -(i + 1);
  }
  
  static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> a(int paramInt)
  {
    return new SmallSortedMap.1(paramInt);
  }
  
  private V c(int paramInt)
  {
    g();
    Object localObject = ((SmallSortedMap.Entry)this.b.remove(paramInt)).getValue();
    if (!this.c.isEmpty())
    {
      Iterator localIterator = h().entrySet().iterator();
      this.b.add(new SmallSortedMap.Entry(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }
  
  private void g()
  {
    if (!this.d) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private SortedMap<K, V> h()
  {
    g();
    if ((this.c.isEmpty()) && (!(this.c instanceof TreeMap)))
    {
      this.c = new TreeMap();
      this.f = ((TreeMap)this.c).descendingMap();
    }
    return (SortedMap)this.c;
  }
  
  private void i()
  {
    g();
    if ((this.b.isEmpty()) && (!(this.b instanceof ArrayList))) {
      this.b = new ArrayList(this.a);
    }
  }
  
  public V a(K paramK, V paramV)
  {
    g();
    int i = a(paramK);
    if (i >= 0) {
      return ((SmallSortedMap.Entry)this.b.get(i)).setValue(paramV);
    }
    i();
    i = -(i + 1);
    if (i >= this.a) {
      return h().put(paramK, paramV);
    }
    int j = this.b.size();
    int k = this.a;
    if (j == k)
    {
      SmallSortedMap.Entry localEntry = (SmallSortedMap.Entry)this.b.remove(k - 1);
      h().put(localEntry.a(), localEntry.getValue());
    }
    this.b.add(i, new SmallSortedMap.Entry(this, paramK, paramV));
    return null;
  }
  
  public void a()
  {
    if (!this.d)
    {
      Map localMap;
      if (this.c.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.c);
      }
      this.c = localMap;
      if (this.f.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.f);
      }
      this.f = localMap;
      this.d = true;
    }
  }
  
  public Map.Entry<K, V> b(int paramInt)
  {
    return (Map.Entry)this.b.get(paramInt);
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public void clear()
  {
    g();
    if (!this.b.isEmpty()) {
      this.b.clear();
    }
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (a(paramObject) >= 0) || (this.c.containsKey(paramObject));
  }
  
  public int d()
  {
    return this.c.size();
  }
  
  public Iterable<Map.Entry<K, V>> e()
  {
    if (this.c.isEmpty()) {
      return SmallSortedMap.EmptySet.a();
    }
    return this.c.entrySet();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.e == null) {
      this.e = new SmallSortedMap.EntrySet(this, null);
    }
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SmallSortedMap)) {
      return super.equals(paramObject);
    }
    paramObject = (SmallSortedMap)paramObject;
    int j = size();
    if (j != paramObject.size()) {
      return false;
    }
    int k = c();
    if (k != paramObject.c()) {
      return entrySet().equals(paramObject.entrySet());
    }
    int i = 0;
    while (i < k)
    {
      if (!b(i).equals(paramObject.b(i))) {
        return false;
      }
      i += 1;
    }
    if (k != j) {
      return this.c.equals(paramObject.c);
    }
    return true;
  }
  
  Set<Map.Entry<K, V>> f()
  {
    if (this.g == null) {
      this.g = new SmallSortedMap.DescendingEntrySet(this, null);
    }
    return this.g;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = a(paramObject);
    if (i >= 0) {
      return ((SmallSortedMap.Entry)this.b.get(i)).getValue();
    }
    return this.c.get(paramObject);
  }
  
  public int hashCode()
  {
    int k = c();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((SmallSortedMap.Entry)this.b.get(j)).hashCode();
      j += 1;
    }
    j = i;
    if (d() > 0) {
      j = i + this.c.hashCode();
    }
    return j;
  }
  
  public V remove(Object paramObject)
  {
    g();
    paramObject = (Comparable)paramObject;
    int i = a(paramObject);
    if (i >= 0) {
      return c(i);
    }
    if (this.c.isEmpty()) {
      return null;
    }
    return this.c.remove(paramObject);
  }
  
  public int size()
  {
    return this.b.size() + this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap
 * JD-Core Version:    0.7.0.1
 */