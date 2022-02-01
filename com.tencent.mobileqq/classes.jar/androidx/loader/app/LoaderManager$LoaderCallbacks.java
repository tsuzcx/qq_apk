package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;

public abstract interface LoaderManager$LoaderCallbacks<D>
{
  @MainThread
  @NonNull
  public abstract Loader<D> onCreateLoader(int paramInt, @Nullable Bundle paramBundle);
  
  @MainThread
  public abstract void onLoadFinished(@NonNull Loader<D> paramLoader, D paramD);
  
  @MainThread
  public abstract void onLoaderReset(@NonNull Loader<D> paramLoader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.app.LoaderManager.LoaderCallbacks
 * JD-Core Version:    0.7.0.1
 */