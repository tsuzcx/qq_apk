package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.AutoRecreated;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import java.util.Set;

final class SavedStateHandleController$OnRecreation
  implements SavedStateRegistry.AutoRecreated
{
  public void onRecreated(@NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    if ((paramSavedStateRegistryOwner instanceof ViewModelStoreOwner))
    {
      ViewModelStore localViewModelStore = ((ViewModelStoreOwner)paramSavedStateRegistryOwner).getViewModelStore();
      SavedStateRegistry localSavedStateRegistry = paramSavedStateRegistryOwner.getSavedStateRegistry();
      Iterator localIterator = localViewModelStore.keys().iterator();
      while (localIterator.hasNext()) {
        SavedStateHandleController.attachHandleIfNeeded(localViewModelStore.get((String)localIterator.next()), localSavedStateRegistry, paramSavedStateRegistryOwner.getLifecycle());
      }
      if (!localViewModelStore.keys().isEmpty()) {
        localSavedStateRegistry.runOnNextRecreation(OnRecreation.class);
      }
      return;
    }
    paramSavedStateRegistryOwner = new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
    for (;;)
    {
      throw paramSavedStateRegistryOwner;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController.OnRecreation
 * JD-Core Version:    0.7.0.1
 */