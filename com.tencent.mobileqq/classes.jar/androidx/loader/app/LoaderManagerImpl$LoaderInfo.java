package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.content.Loader;
import androidx.loader.content.Loader.OnLoadCompleteListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderManagerImpl$LoaderInfo<D>
  extends MutableLiveData<D>
  implements Loader.OnLoadCompleteListener<D>
{
  @Nullable
  private final Bundle mArgs;
  private final int mId;
  private LifecycleOwner mLifecycleOwner;
  @NonNull
  private final Loader<D> mLoader;
  private LoaderManagerImpl.LoaderObserver<D> mObserver;
  private Loader<D> mPriorLoader;
  
  LoaderManagerImpl$LoaderInfo(int paramInt, @Nullable Bundle paramBundle, @NonNull Loader<D> paramLoader1, @Nullable Loader<D> paramLoader2)
  {
    this.mId = paramInt;
    this.mArgs = paramBundle;
    this.mLoader = paramLoader1;
    this.mPriorLoader = paramLoader2;
    this.mLoader.registerListener(paramInt, this);
  }
  
  @MainThread
  Loader<D> destroy(boolean paramBoolean)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Destroying: " + this);
    }
    this.mLoader.cancelLoad();
    this.mLoader.abandon();
    LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
    if (localLoaderObserver != null)
    {
      removeObserver(localLoaderObserver);
      if (paramBoolean) {
        localLoaderObserver.reset();
      }
    }
    this.mLoader.unregisterListener(this);
    if (((localLoaderObserver != null) && (!localLoaderObserver.hasDeliveredData())) || (paramBoolean))
    {
      this.mLoader.reset();
      return this.mPriorLoader;
    }
    return this.mLoader;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.mArgs);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.mLoader);
    this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mObserver != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.mObserver);
      this.mObserver.dump(paramString + "  ", paramPrintWriter);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mData=");
    paramPrintWriter.println(getLoader().dataToString(getValue()));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.println(hasActiveObservers());
  }
  
  @NonNull
  Loader<D> getLoader()
  {
    return this.mLoader;
  }
  
  boolean isCallbackWaitingForData()
  {
    if (!hasActiveObservers()) {}
    while ((this.mObserver == null) || (this.mObserver.hasDeliveredData())) {
      return false;
    }
    return true;
  }
  
  void markForRedelivery()
  {
    LifecycleOwner localLifecycleOwner = this.mLifecycleOwner;
    LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
    if ((localLifecycleOwner != null) && (localLoaderObserver != null))
    {
      super.removeObserver(localLoaderObserver);
      observe(localLifecycleOwner, localLoaderObserver);
    }
  }
  
  public void onActive()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Starting: " + this);
    }
    this.mLoader.startLoading();
  }
  
  public void onInactive()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    this.mLoader.stopLoading();
  }
  
  public void onLoadComplete(@NonNull Loader<D> paramLoader, @Nullable D paramD)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadComplete: " + this);
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setValue(paramD);
      return;
    }
    if (LoaderManagerImpl.DEBUG) {
      Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
    }
    postValue(paramD);
  }
  
  public void removeObserver(@NonNull Observer<? super D> paramObserver)
  {
    super.removeObserver(paramObserver);
    this.mLifecycleOwner = null;
    this.mObserver = null;
  }
  
  @MainThread
  @NonNull
  Loader<D> setCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    paramLoaderCallbacks = new LoaderManagerImpl.LoaderObserver(this.mLoader, paramLoaderCallbacks);
    observe(paramLifecycleOwner, paramLoaderCallbacks);
    if (this.mObserver != null) {
      removeObserver(this.mObserver);
    }
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mObserver = paramLoaderCallbacks;
    return this.mLoader;
  }
  
  public void setValue(D paramD)
  {
    super.setValue(paramD);
    if (this.mPriorLoader != null)
    {
      this.mPriorLoader.reset();
      this.mPriorLoader = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.app.LoaderManagerImpl.LoaderInfo
 * JD-Core Version:    0.7.0.1
 */