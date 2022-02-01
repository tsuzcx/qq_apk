package androidx.loader.app;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.loader.content.Loader;
import java.io.PrintWriter;

class LoaderManagerImpl$LoaderObserver<D>
  implements Observer<D>
{
  @NonNull
  private final LoaderManager.LoaderCallbacks<D> mCallback;
  private boolean mDeliveredData = false;
  @NonNull
  private final Loader<D> mLoader;
  
  LoaderManagerImpl$LoaderObserver(@NonNull Loader<D> paramLoader, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    this.mLoader = paramLoader;
    this.mCallback = paramLoaderCallbacks;
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mDeliveredData=");
    paramPrintWriter.println(this.mDeliveredData);
  }
  
  boolean hasDeliveredData()
  {
    return this.mDeliveredData;
  }
  
  public void onChanged(@Nullable D paramD)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(paramD));
    }
    this.mCallback.onLoadFinished(this.mLoader, paramD);
    this.mDeliveredData = true;
  }
  
  @MainThread
  void reset()
  {
    if (this.mDeliveredData)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Resetting: " + this.mLoader);
      }
      this.mCallback.onLoaderReset(this.mLoader);
    }
  }
  
  public String toString()
  {
    return this.mCallback.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.app.LoaderManagerImpl.LoaderObserver
 * JD-Core Version:    0.7.0.1
 */