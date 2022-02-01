package androidx.arch.core.internal;

class SafeIterableMap$AscendingIterator<K, V>
  extends SafeIterableMap.ListIterator<K, V>
{
  SafeIterableMap$AscendingIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2)
  {
    super(paramEntry1, paramEntry2);
  }
  
  SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry)
  {
    return paramEntry.mPrevious;
  }
  
  SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry)
  {
    return paramEntry.mNext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.arch.core.internal.SafeIterableMap.AscendingIterator
 * JD-Core Version:    0.7.0.1
 */