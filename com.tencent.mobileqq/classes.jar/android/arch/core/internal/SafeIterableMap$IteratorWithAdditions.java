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
    boolean bool2 = false;
    if (this.mBeforeStart)
    {
      if (SafeIterableMap.access$100(this.this$0) != null) {
        return true;
      }
    }
    else
    {
      boolean bool1 = bool2;
      if (this.mCurrent != null)
      {
        bool1 = bool2;
        if (this.mCurrent.mNext != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public Map.Entry<K, V> next()
  {
    if (this.mBeforeStart)
    {
      this.mBeforeStart = false;
      this.mCurrent = SafeIterableMap.access$100(this.this$0);
      return this.mCurrent;
    }
    if (this.mCurrent != null) {}
    for (SafeIterableMap.Entry localEntry = this.mCurrent.mNext;; localEntry = null)
    {
      this.mCurrent = localEntry;
      break;
    }
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry<K, V> paramEntry)
  {
    if (paramEntry == this.mCurrent)
    {
      this.mCurrent = this.mCurrent.mPrevious;
      if (this.mCurrent != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.mBeforeStart = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.IteratorWithAdditions
 * JD-Core Version:    0.7.0.1
 */