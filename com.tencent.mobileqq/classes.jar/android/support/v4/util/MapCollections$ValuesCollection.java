package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection
  implements Collection<V>
{
  MapCollections$ValuesCollection(MapCollections paramMapCollections) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    this.this$0.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.colIndexOfValue(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.this$0.colGetSize() == 0;
  }
  
  public Iterator<V> iterator()
  {
    return new MapCollections.ArrayIterator(this.this$0, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = this.this$0.colIndexOfValue(paramObject);
    if (i >= 0)
    {
      this.this$0.colRemoveAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int j = this.this$0.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int k = j;
      int m = i;
      if (paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int j = this.this$0.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int k = j;
      int m = i;
      if (!paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public int size()
  {
    return this.this$0.colGetSize();
  }
  
  public Object[] toArray()
  {
    return this.this$0.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.this$0.toArrayHelper(paramArrayOfT, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.MapCollections.ValuesCollection
 * JD-Core Version:    0.7.0.1
 */