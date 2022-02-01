package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface ContextAware
{
  public abstract void addOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener);
  
  @Nullable
  public abstract Context peekAvailableContext();
  
  public abstract void removeOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.contextaware.ContextAware
 * JD-Core Version:    0.7.0.1
 */