package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper
{
  private volatile Context mContext;
  private final Set<OnContextAvailableListener> mListeners = new CopyOnWriteArraySet();
  
  public void addOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener)
  {
    if (this.mContext != null) {
      paramOnContextAvailableListener.onContextAvailable(this.mContext);
    }
    this.mListeners.add(paramOnContextAvailableListener);
  }
  
  public void clearAvailableContext()
  {
    this.mContext = null;
  }
  
  public void dispatchOnContextAvailable(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnContextAvailableListener)localIterator.next()).onContextAvailable(paramContext);
    }
  }
  
  @Nullable
  public Context peekAvailableContext()
  {
    return this.mContext;
  }
  
  public void removeOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener)
  {
    this.mListeners.remove(paramOnContextAvailableListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.contextaware.ContextAwareHelper
 * JD-Core Version:    0.7.0.1
 */