package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class SafeIterableMap$IteratorWithAdditions
  implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>>
{
  private boolean mBeforeStart = true;
  private SafeIterableMap.Entry<K, V> mCurrent;
  
  SafeIterableMap$IteratorWithAdditions(SafeIterableMap paramSafeIterableMap) {}
  
  public boolean hasNext()
  {
    if (this.mBeforeStart) {
      if (this.this$0.mStart == null) {}
    }
    while ((this.mCurrent != null) && (this.mCurrent.mNext != null))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public Map.Entry<K, V> next()
  {
    if (this.mBeforeStart)
    {
      this.mBeforeStart = false;
      this.mCurrent = this.this$0.mStart;
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
 * Qualified Name:     androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions
 * JD-Core Version:    0.7.0.1
 */