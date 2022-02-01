package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl$LoaderViewModel
  extends ViewModel
{
  private static final ViewModelProvider.Factory FACTORY = new LoaderManagerImpl.LoaderViewModel.1();
  private boolean mCreatingLoader = false;
  private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
  
  @NonNull
  static LoaderViewModel getInstance(ViewModelStore paramViewModelStore)
  {
    return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, FACTORY).get(LoaderViewModel.class);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("    ");
      localObject = ((StringBuilder)localObject).toString();
      int i = 0;
      while (i < this.mLoaders.size())
      {
        LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  void finishCreatingLoader()
  {
    this.mCreatingLoader = false;
  }
  
  <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int paramInt)
  {
    return (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
  }
  
  boolean hasRunningLoaders()
  {
    int j = this.mLoaders.size();
    int i = 0;
    while (i < j)
    {
      if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).isCallbackWaitingForData()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean isCreatingLoader()
  {
    return this.mCreatingLoader;
  }
  
  void markForRedelivery()
  {
    int j = this.mLoaders.size();
    int i = 0;
    while (i < j)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).markForRedelivery();
      i += 1;
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    int j = this.mLoaders.size();
    int i = 0;
    while (i < j)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).destroy(true);
      i += 1;
    }
    this.mLoaders.clear();
  }
  
  void putLoader(int paramInt, @NonNull LoaderManagerImpl.LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramInt, paramLoaderInfo);
  }
  
  void removeLoader(int paramInt)
  {
    this.mLoaders.remove(paramInt);
  }
  
  void startCreatingLoader()
  {
    this.mCreatingLoader = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.loader.app.LoaderManagerImpl.LoaderViewModel
 * JD-Core Version:    0.7.0.1
 */