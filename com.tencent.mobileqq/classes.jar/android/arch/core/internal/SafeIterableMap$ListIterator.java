package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class SafeIterableMap$ListIterator<K, V>
  implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>>
{
  SafeIterableMap.Entry<K, V> mExpectedEnd;
  SafeIterableMap.Entry<K, V> mNext;
  
  SafeIterableMap$ListIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2)
  {
    this.mExpectedEnd = paramEntry2;
    this.mNext = paramEntry1;
  }
  
  private SafeIterableMap.Entry<K, V> nextNode()
  {
    SafeIterableMap.Entry localEntry1 = this.mNext;
    SafeIterableMap.Entry localEntry2 = this.mExpectedEnd;
    if ((localEntry1 != localEntry2) && (localEntry2 != null)) {
      return forward(localEntry1);
    }
    return null;
  }
  
  abstract SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry);
  
  abstract SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry);
  
  public boolean hasNext()
  {
    return this.mNext != null;
  }
  
  public Map.Entry<K, V> next()
  {
    SafeIterableMap.Entry localEntry = this.mNext;
    this.mNext = nextNode();
    return localEntry;
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry<K, V> paramEntry)
  {
    if ((this.mExpectedEnd == paramEntry) && (paramEntry == this.mNext))
    {
      this.mNext = null;
      this.mExpectedEnd = null;
    }
    SafeIterableMap.Entry localEntry = this.mExpectedEnd;
    if (localEntry == paramEntry) {
      this.mExpectedEnd = backward(localEntry);
    }
    if (this.mNext == paramEntry) {
      this.mNext = nextNode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.ListIterator
 * JD-Core Version:    0.7.0.1
 */