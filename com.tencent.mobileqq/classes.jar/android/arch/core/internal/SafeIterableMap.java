package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SafeIterableMap<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private SafeIterableMap.Entry<K, V> mEnd;
  private WeakHashMap<SafeIterableMap.SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap();
  private int mSize = 0;
  private SafeIterableMap.Entry<K, V> mStart;
  
  public Iterator<Map.Entry<K, V>> descendingIterator()
  {
    SafeIterableMap.DescendingIterator localDescendingIterator = new SafeIterableMap.DescendingIterator(this.mEnd, this.mStart);
    this.mIterators.put(localDescendingIterator, Boolean.valueOf(false));
    return localDescendingIterator;
  }
  
  public Map.Entry<K, V> eldest()
  {
    return this.mStart;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof SafeIterableMap));
      localObject1 = (SafeIterableMap)paramObject;
      bool1 = bool2;
    } while (size() != ((SafeIterableMap)localObject1).size());
    paramObject = iterator();
    Object localObject1 = ((SafeIterableMap)localObject1).iterator();
    for (;;)
    {
      if ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        Object localObject2 = ((Iterator)localObject1).next();
        if (localEntry == null)
        {
          bool1 = bool2;
          if (localObject2 != null) {
            break;
          }
        }
        if ((localEntry != null) && (!localEntry.equals(localObject2))) {
          return false;
        }
      }
    }
    if ((!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext())) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  protected SafeIterableMap.Entry<K, V> get(K paramK)
  {
    for (SafeIterableMap.Entry localEntry = this.mStart;; localEntry = localEntry.mNext) {
      if ((localEntry == null) || (localEntry.mKey.equals(paramK))) {
        return localEntry;
      }
    }
  }
  
  @NonNull
  public Iterator<Map.Entry<K, V>> iterator()
  {
    SafeIterableMap.AscendingIterator localAscendingIterator = new SafeIterableMap.AscendingIterator(this.mStart, this.mEnd);
    this.mIterators.put(localAscendingIterator, Boolean.valueOf(false));
    return localAscendingIterator;
  }
  
  public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions()
  {
    SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions(this, null);
    this.mIterators.put(localIteratorWithAdditions, Boolean.valueOf(false));
    return localIteratorWithAdditions;
  }
  
  public Map.Entry<K, V> newest()
  {
    return this.mEnd;
  }
  
  protected SafeIterableMap.Entry<K, V> put(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new SafeIterableMap.Entry(paramK, paramV);
    this.mSize += 1;
    if (this.mEnd == null)
    {
      this.mStart = paramK;
      this.mEnd = this.mStart;
      return paramK;
    }
    this.mEnd.mNext = paramK;
    paramK.mPrevious = this.mEnd;
    this.mEnd = paramK;
    return paramK;
  }
  
  public V putIfAbsent(@NonNull K paramK, @NonNull V paramV)
  {
    SafeIterableMap.Entry localEntry = get(paramK);
    if (localEntry != null) {
      return localEntry.mValue;
    }
    put(paramK, paramV);
    return null;
  }
  
  public V remove(@NonNull K paramK)
  {
    paramK = get(paramK);
    if (paramK == null) {
      return null;
    }
    this.mSize -= 1;
    if (!this.mIterators.isEmpty())
    {
      Iterator localIterator = this.mIterators.keySet().iterator();
      while (localIterator.hasNext()) {
        ((SafeIterableMap.SupportRemove)localIterator.next()).supportRemove(paramK);
      }
    }
    if (paramK.mPrevious != null)
    {
      paramK.mPrevious.mNext = paramK.mNext;
      if (paramK.mNext == null) {
        break label134;
      }
      paramK.mNext.mPrevious = paramK.mPrevious;
    }
    for (;;)
    {
      paramK.mNext = null;
      paramK.mPrevious = null;
      return paramK.mValue;
      this.mStart = paramK.mNext;
      break;
      label134:
      this.mEnd = paramK.mPrevious;
    }
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap
 * JD-Core Version:    0.7.0.1
 */