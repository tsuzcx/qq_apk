package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class Recreator$SavedStateProvider
  implements SavedStateRegistry.SavedStateProvider
{
  final Set<String> mClasses = new HashSet();
  
  Recreator$SavedStateProvider(SavedStateRegistry paramSavedStateRegistry)
  {
    paramSavedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
  }
  
  void add(String paramString)
  {
    this.mClasses.add(paramString);
  }
  
  @NonNull
  public Bundle saveState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("classes_to_restore", new ArrayList(this.mClasses));
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.savedstate.Recreator.SavedStateProvider
 * JD-Core Version:    0.7.0.1
 */