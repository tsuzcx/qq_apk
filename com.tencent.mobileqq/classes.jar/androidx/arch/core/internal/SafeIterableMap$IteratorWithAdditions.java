package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

class SafeIterableMap$IteratorWithAdditions
  implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>>
{
  private boolean mBeforeStart = true;
  private SafeIterableMap.Entry<K, V> mCurrent;
  
  SafeIterableMap$IteratorWithAdditions(SafeIterableMap paramSafeIterableMap) {}
  
  public boolean hasNext()
  {
    if (this.mBeforeStart) {
      return this.this$0.mStart != null;
    }
    SafeIterableMap.Entry localEntry = this.mCurrent;
    return (localEntry != null) && (localEntry.mNext != null);
  }
  
  public Map.Entry<K, V> next()
  {
    if (this.mBeforeStart)
    {
      this.mBeforeStart = false;
      this.mCurrent = this.this$0.mStart;
    }
    else
    {
      SafeIterableMap.Entry localEntry = this.mCurrent;
      if (localEntry != null) {
        localEntry = localEntry.mNext;
      } else {
        localEntry = null;
      }
      this.mCurrent = localEntry;
    }
    return this.mCurrent;
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry<K, V> paramEntry)
  {
    SafeIterableMap.Entry localEntry = this.mCurrent;
    if (paramEntry == localEntry)
    {
      this.mCurrent = localEntry.mPrevious;
      boolean bool;
      if (this.mCurrent == null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mBeforeStart = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions
 * JD-Core Version:    0.7.0.1
 */