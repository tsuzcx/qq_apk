package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map.Entry;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry
{
  private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
  boolean mAllowingSavingState = true;
  private SafeIterableMap<String, SavedStateRegistry.SavedStateProvider> mComponents = new SafeIterableMap();
  private Recreator.SavedStateProvider mRecreatorProvider;
  private boolean mRestored;
  @Nullable
  private Bundle mRestoredState;
  
  @MainThread
  @Nullable
  public Bundle consumeRestoredStateForKey(@NonNull String paramString)
  {
    if (!this.mRestored) {
      throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }
    if (this.mRestoredState != null)
    {
      Bundle localBundle = this.mRestoredState.getBundle(paramString);
      this.mRestoredState.remove(paramString);
      if (this.mRestoredState.isEmpty()) {
        this.mRestoredState = null;
      }
      return localBundle;
    }
    return null;
  }
  
  @MainThread
  public boolean isRestored()
  {
    return this.mRestored;
  }
  
  @MainThread
  void performRestore(@NonNull Lifecycle paramLifecycle, @Nullable Bundle paramBundle)
  {
    if (this.mRestored) {
      throw new IllegalStateException("SavedStateRegistry was already restored.");
    }
    if (paramBundle != null) {
      this.mRestoredState = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    }
    paramLifecycle.addObserver(new SavedStateRegistry.1(this));
    this.mRestored = true;
  }
  
  @MainThread
  void performSave(@NonNull Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (this.mRestoredState != null) {
      localBundle.putAll(this.mRestoredState);
    }
    SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mComponents.iteratorWithAdditions();
    while (localIteratorWithAdditions.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIteratorWithAdditions.next();
      localBundle.putBundle((String)localEntry.getKey(), ((SavedStateRegistry.SavedStateProvider)localEntry.getValue()).saveState());
    }
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
  }
  
  @MainThread
  public void registerSavedStateProvider(@NonNull String paramString, @NonNull SavedStateRegistry.SavedStateProvider paramSavedStateProvider)
  {
    if ((SavedStateRegistry.SavedStateProvider)this.mComponents.putIfAbsent(paramString, paramSavedStateProvider) != null) {
      throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }
  }
  
  @MainThread
  public void runOnNextRecreation(@NonNull Class<? extends SavedStateRegistry.AutoRecreated> paramClass)
  {
    if (!this.mAllowingSavingState) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mRecreatorProvider == null) {
      this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
    }
    try
    {
      paramClass.getDeclaredConstructor(new Class[0]);
      this.mRecreatorProvider.add(paramClass.getName());
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalArgumentException("Class" + paramClass.getSimpleName() + " must have default constructor in order to be automatically recreated", localNoSuchMethodException);
    }
  }
  
  @MainThread
  public void unregisterSavedStateProvider(@NonNull String paramString)
  {
    this.mComponents.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.savedstate.SavedStateRegistry
 * JD-Core Version:    0.7.0.1
 */