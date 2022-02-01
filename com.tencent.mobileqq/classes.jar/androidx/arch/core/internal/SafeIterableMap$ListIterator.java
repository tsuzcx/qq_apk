package androidx.arch.core.internal;

import androidx.annotation.NonNull;
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
    if ((this.mNext == this.mExpectedEnd) || (this.mExpectedEnd == null)) {
      return null;
    }
    return forward(this.mNext);
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
    if (this.mExpectedEnd == paramEntry) {
      this.mExpectedEnd = backward(this.mExpectedEnd);
    }
    if (this.mNext == paramEntry) {
      this.mNext = nextNode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.arch.core.internal.SafeIterableMap.ListIterator
 * JD-Core Version:    0.7.0.1
 */