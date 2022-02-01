package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  @NonNull
  private final LifecycleOwner mLifecycleOwner;
  @NonNull
  private final LoaderManagerImpl.LoaderViewModel mLoaderViewModel;
  
  LoaderManagerImpl(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull ViewModelStore paramViewModelStore)
  {
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mLoaderViewModel = LoaderManagerImpl.LoaderViewModel.getInstance(paramViewModelStore);
  }
  
  @MainThread
  @NonNull
  private <D> Loader<D> createAndInstallLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks, @Nullable Loader<D> paramLoader)
  {
    Loader localLoader;
    try
    {
      this.mLoaderViewModel.startCreatingLoader();
      localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (localLoader == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.mLoaderViewModel.finishCreatingLoader();
    }
    if ((localLoader.getClass().isMemberClass()) && (!Modifier.isStatic(localLoader.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + localLoader);
    }
    paramBundle = new LoaderManagerImpl.LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
    if (DEBUG) {
      Log.v("LoaderManager", "  Created new loader " + paramBundle);
    }
    this.mLoaderViewModel.putLoader(paramInt, paramBundle);
    this.mLoaderViewModel.finishCreatingLoader();
    return paramBundle.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }
  
  @MainThread
  public void destroyLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null)
    {
      localLoaderInfo.destroy(true);
      this.mLoaderViewModel.removeLoader(paramInt);
    }
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null) {
      return localLoaderInfo.getLoader();
    }
    return null;
  }
  
  public boolean hasRunningLoaders()
  {
    return this.mLoaderViewModel.hasRunningLoaders();
  }
  
  @MainThread
  @NonNull
  public <D> Loader<D> initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (DEBUG) {
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo == null) {
      return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, null);
    }
    if (DEBUG) {
      Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
    }
    return localLoaderInfo.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }
  
  public void markForRedelivery()
  {
    this.mLoaderViewModel.markForRedelivery();
  }
  
  @MainThread
  @NonNull
  public <D> Loader<D> restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    Loader localLoader = null;
    if (localLoaderInfo != null) {
      localLoader = localLoaderInfo.destroy(false);
    }
    return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, localLoader);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mLifecycleOwner, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */