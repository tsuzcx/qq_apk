package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ShortcutInfoCompatSaver<T>
{
  @AnyThread
  public abstract T addShortcuts(List<ShortcutInfoCompat> paramList);
  
  @WorkerThread
  public List<ShortcutInfoCompat> getShortcuts()
  {
    return new ArrayList();
  }
  
  @AnyThread
  public abstract T removeAllShortcuts();
  
  @AnyThread
  public abstract T removeShortcuts(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutInfoCompatSaver
 * JD-Core Version:    0.7.0.1
 */