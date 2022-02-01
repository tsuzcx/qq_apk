package androidx.arch.core.internal;

class SafeIterableMap$DescendingIterator<K, V>
  extends SafeIterableMap.ListIterator<K, V>
{
  SafeIterableMap$DescendingIterator(SafeIterableMap.Entry<K, V> paramEntry1, SafeIterableMap.Entry<K, V> paramEntry2)
  {
    super(paramEntry1, paramEntry2);
  }
  
  SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> paramEntry)
  {
    return paramEntry.mNext;
  }
  
  SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> paramEntry)
  {
    return paramEntry.mPrevious;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.arch.core.internal.SafeIterableMap.DescendingIterator
 * JD-Core Version:    0.7.0.1
 */