package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
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
    if (this.mRestored)
    {
      Bundle localBundle = this.mRestoredState;
      if (localBundle != null)
      {
        localBundle = localBundle.getBundle(paramString);
        this.mRestoredState.remove(paramString);
        if (this.mRestoredState.isEmpty()) {
          this.mRestoredState = null;
        }
        return localBundle;
      }
      return null;
    }
    throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
  }
  
  @MainThread
  public boolean isRestored()
  {
    return this.mRestored;
  }
  
  @MainThread
  void performRestore(@NonNull Lifecycle paramLifecycle, @Nullable Bundle paramBundle)
  {
    if (!this.mRestored)
    {
      if (paramBundle != null) {
        this.mRestoredState = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
      }
      paramLifecycle.addObserver(new SavedStateRegistry.1(this));
      this.mRestored = true;
      return;
    }
    throw new IllegalStateException("SavedStateRegistry was already restored.");
  }
  
  @MainThread
  void performSave(@NonNull Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Object localObject = this.mRestoredState;
    if (localObject != null) {
      localBundle.putAll((Bundle)localObject);
    }
    localObject = this.mComponents.iteratorWithAdditions();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localBundle.putBundle((String)localEntry.getKey(), ((SavedStateRegistry.SavedStateProvider)localEntry.getValue()).saveState());
    }
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
  }
  
  @MainThread
  public void registerSavedStateProvider(@NonNull String paramString, @NonNull SavedStateRegistry.SavedStateProvider paramSavedStateProvider)
  {
    if ((SavedStateRegistry.SavedStateProvider)this.mComponents.putIfAbsent(paramString, paramSavedStateProvider) == null) {
      return;
    }
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
  }
  
  @MainThread
  public void runOnNextRecreation(@NonNull Class<? extends SavedStateRegistry.AutoRecreated> paramClass)
  {
    if (this.mAllowingSavingState)
    {
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Class");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(localStringBuilder.toString(), localNoSuchMethodException);
      }
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  @MainThread
  public void unregisterSavedStateProvider(@NonNull String paramString)
  {
    this.mComponents.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.savedstate.SavedStateRegistry
 * JD-Core Version:    0.7.0.1
 */