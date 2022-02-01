package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

class SafeIterableMap$IteratorWithAdditions
  implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>>
{
  private boolean mBeforeStart = true;
  private SafeIterableMap.Entry<K, V> mCurrent;
  
  private SafeIterableMap$IteratorWithAdditions(SafeIterableMap paramSafeIterableMap) {}
  
  public boolean hasNext()
  {
    if (this.mBeforeStart) {
      return SafeIterableMap.access$100(this.this$0) != null;
    }
    SafeIterableMap.Entry localEntry = this.mCurrent;
    return (localEntry != null) && (localEntry.mNext != null);
  }
  
  public Map.Entry<K, V> next()
  {
    SafeIterableMap.Entry localEntry;
    if (this.mBeforeStart)
    {
      this.mBeforeStart = false;
      localEntry = SafeIterableMap.access$100(this.this$0);
    }
    for (;;)
    {
      this.mCurrent = localEntry;
      break;
      localEntry = this.mCurrent;
      if (localEntry != null) {
        localEntry = localEntry.mNext;
      } else {
        localEntry = null;
      }
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
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.IteratorWithAdditions
 * JD-Core Version:    0.7.0.1
 */