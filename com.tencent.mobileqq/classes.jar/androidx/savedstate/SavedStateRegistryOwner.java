package androidx.savedstate;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public abstract interface SavedStateRegistryOwner
  extends LifecycleOwner
{
  @NonNull
  public abstract SavedStateRegistry getSavedStateRegistry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.savedstate.SavedStateRegistryOwner
 * JD-Core Version:    0.7.0.1
 */