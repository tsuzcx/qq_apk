package androidx.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class MapCollections$MapIterator
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int mEnd;
  boolean mEntryValid = false;
  int mIndex;
  
  MapCollections$MapIterator(MapCollections paramMapCollections)
  {
    this.mEnd = (paramMapCollections.colGetSize() - 1);
    this.mIndex = -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this.mEntryValid)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (ContainerHelpers.equal(paramObject.getKey(), this.this$0.colGetEntry(this.mIndex, 0)))
      {
        bool1 = bool2;
        if (ContainerHelpers.equal(paramObject.getValue(), this.this$0.colGetEntry(this.mIndex, 1))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public K getKey()
  {
    if (this.mEntryValid) {
      return this.this$0.colGetEntry(this.mIndex, 0);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public V getValue()
  {
    if (this.mEntryValid) {
      return this.this$0.colGetEntry(this.mIndex, 1);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public boolean hasNext()
  {
    return this.mIndex < this.mEnd;
  }
  
  public int hashCode()
  {
    if (this.mEntryValid)
    {
      Object localObject1 = this.this$0;
      int i = this.mIndex;
      int j = 0;
      localObject1 = ((MapCollections)localObject1).colGetEntry(i, 0);
      Object localObject2 = this.this$0.colGetEntry(this.mIndex, 1);
      if (localObject1 == null) {
        i = 0;
      } else {
        i = localObject1.hashCode();
      }
      if (localObject2 != null) {
        j = localObject2.hashCode();
      }
      return i ^ j;
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public Map.Entry<K, V> next()
  {
    if (hasNext())
    {
      this.mIndex += 1;
      this.mEntryValid = true;
      return this;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (this.mEntryValid)
    {
      this.this$0.colRemoveAt(this.mIndex);
      this.mIndex -= 1;
      this.mEnd -= 1;
      this.mEntryValid = false;
      return;
    }
    throw new IllegalStateException();
  }
  
  public V setValue(V paramV)
  {
    if (this.mEntryValid) {
      return this.this$0.colSetValue(this.mIndex, paramV);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.collection.MapCollections.MapIterator
 * JD-Core Version:    0.7.0.1
 */