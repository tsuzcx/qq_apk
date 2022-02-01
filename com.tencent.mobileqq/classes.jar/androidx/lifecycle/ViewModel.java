package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ViewModel
{
  @Nullable
  private final Map<String, Object> mBagOfTags = new HashMap();
  private volatile boolean mCleared = false;
  
  private static void closeWithRuntimeException(Object paramObject)
  {
    if ((paramObject instanceof Closeable)) {}
    try
    {
      ((Closeable)paramObject).close();
      return;
    }
    catch (IOException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
  }
  
  @MainThread
  final void clear()
  {
    this.mCleared = true;
    if (this.mBagOfTags != null) {
      synchronized (this.mBagOfTags)
      {
        Iterator localIterator = this.mBagOfTags.values().iterator();
        if (localIterator.hasNext()) {
          closeWithRuntimeException(localIterator.next());
        }
      }
    }
    onCleared();
  }
  
  <T> T getTag(String paramString)
  {
    if (this.mBagOfTags == null) {
      return null;
    }
    synchronized (this.mBagOfTags)
    {
      paramString = this.mBagOfTags.get(paramString);
      return paramString;
    }
  }
  
  protected void onCleared() {}
  
  <T> T setTagIfAbsent(String paramString, T paramT)
  {
    for (;;)
    {
      Object localObject;
      synchronized (this.mBagOfTags)
      {
        localObject = this.mBagOfTags.get(paramString);
        if (localObject == null) {
          this.mBagOfTags.put(paramString, paramT);
        }
        if (localObject == null)
        {
          if (this.mCleared) {
            closeWithRuntimeException(paramT);
          }
          return paramT;
        }
      }
      paramT = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModel
 * JD-Core Version:    0.7.0.1
 */