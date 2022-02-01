package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    LoaderManagerImpl.DEBUG = paramBoolean;
  }
  
  @NonNull
  public static <T extends LifecycleOwner,  extends ViewModelStoreOwner> LoaderManager getInstance(@NonNull T paramT)
  {
    return new LoaderManagerImpl(paramT, ((ViewModelStoreOwner)paramT).getViewModelStore());
  }
  
  @MainThread
  public abstract void destroyLoader(int paramInt);
  
  @Deprecated
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @Nullable
  public abstract <D> Loader<D> getLoader(int paramInt);
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  @MainThread
  @NonNull
  public abstract <D> Loader<D> initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks);
  
  public abstract void markForRedelivery();
  
  @MainThread
  @NonNull
  public abstract <D> Loader<D> restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.app.LoaderManager
 * JD-Core Version:    0.7.0.1
 */