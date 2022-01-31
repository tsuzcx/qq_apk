package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  FragmentActivity mActivity;
  boolean mCreatingLoader;
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  final SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.mWho = paramString;
    this.mActivity = paramFragmentActivity;
    this.mStarted = paramBoolean;
  }
  
  private LoaderManagerImpl.LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.mCreatingLoader = true;
      paramBundle = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(paramBundle);
      return paramBundle;
    }
    finally
    {
      this.mCreatingLoader = false;
    }
  }
  
  private LoaderManagerImpl.LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderManagerImpl.LoaderInfo localLoaderInfo = new LoaderManagerImpl.LoaderInfo(this, paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localLoaderInfo;
  }
  
  public void destroyLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "destroyLoader in " + this + " of " + paramInt);
    }
    int i = this.mLoaders.indexOfKey(paramInt);
    LoaderManagerImpl.LoaderInfo localLoaderInfo;
    if (i >= 0)
    {
      localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      localLoaderInfo.destroy();
    }
    paramInt = this.mInactiveLoaders.indexOfKey(paramInt);
    if (paramInt >= 0)
    {
      localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(paramInt);
      this.mInactiveLoaders.removeAt(paramInt);
      localLoaderInfo.destroy();
    }
    if ((this.mActivity != null) && (!hasRunningLoaders())) {
      this.mActivity.mFragments.startPendingDeferredFragments();
    }
  }
  
  void doDestroy()
  {
    if (!this.mRetaining)
    {
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "Destroying Active in " + this);
      }
      i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).destroy();
        i -= 1;
      }
      this.mLoaders.clear();
    }
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Destroying Inactive in " + this);
    }
    int i = this.mInactiveLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy();
      i -= 1;
    }
    this.mInactiveLoaders.clear();
  }
  
  void doReportNextStart()
  {
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true;
      i -= 1;
    }
  }
  
  void doReportStart()
  {
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
      i -= 1;
    }
  }
  
  void doRetain()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Retaining in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doRetain when not started: " + this, localRuntimeException);
      }
    }
    for (;;)
    {
      return;
      this.mRetaining = true;
      this.mStarted = false;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).retain();
        i -= 1;
      }
    }
  }
  
  void doStart()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Starting in " + this);
    }
    if (this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doStart when already started: " + this, localRuntimeException);
      }
    }
    for (;;)
    {
      return;
      this.mStarted = true;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).start();
        i -= 1;
      }
    }
  }
  
  void doStop()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Stopping in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doStop when not started: " + this, localRuntimeException);
      }
      return;
    }
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).stop();
      i -= 1;
    }
    this.mStarted = false;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    LoaderManagerImpl.LoaderInfo localLoaderInfo;
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.mLoaders.size())
      {
        localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.mInactiveLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.mInactiveLoaders.size())
      {
        localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "Finished Retaining in " + this);
      }
      this.mRetaining = false;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
        i -= 1;
      }
    }
  }
  
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    if (localLoaderInfo != null)
    {
      if (localLoaderInfo.mPendingLoader != null) {
        return localLoaderInfo.mPendingLoader.mLoader;
      }
      return localLoaderInfo.mLoader;
    }
    return null;
  }
  
  public boolean hasRunningLoaders()
  {
    int j = this.mLoaders.size();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
      if ((localLoaderInfo.mStarted) && (!localLoaderInfo.mDeliveredData)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "initLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo == null)
    {
      paramLoaderCallbacks = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks);
      paramBundle = paramLoaderCallbacks;
      if (DEBUG)
      {
        paramBundle = paramLoaderCallbacks;
        if (QLog.isDevelopLevel()) {
          QLog.d("LoaderManager", 4, "  Created new loader " + paramLoaderCallbacks);
        }
      }
    }
    for (paramBundle = paramLoaderCallbacks;; paramBundle = localLoaderInfo)
    {
      if ((paramBundle.mHaveData) && (this.mStarted)) {
        paramBundle.callOnLoadFinished(paramBundle.mLoader, paramBundle.mData);
      }
      return paramBundle.mLoader;
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Re-using existing loader " + localLoaderInfo);
      }
      localLoaderInfo.mCallbacks = paramLoaderCallbacks;
    }
  }
  
  void installLoader(LoaderManagerImpl.LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted) {
      paramLoaderInfo.start();
    }
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo1 = (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "restartLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo1 != null)
    {
      LoaderManagerImpl.LoaderInfo localLoaderInfo2 = (LoaderManagerImpl.LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (localLoaderInfo2 == null) {
        break label339;
      }
      if (!localLoaderInfo1.mHaveData) {
        break label187;
      }
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Removing last inactive loader: " + localLoaderInfo1);
      }
      localLoaderInfo2.mDeliveredData = false;
      localLoaderInfo2.destroy();
      localLoaderInfo1.mLoader.abandon();
      this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
    }
    for (;;)
    {
      return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks).mLoader;
      label187:
      if (!localLoaderInfo1.mStarted)
      {
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Current loader is stopped; replacing");
        }
        this.mLoaders.put(paramInt, null);
        localLoaderInfo1.destroy();
      }
      else
      {
        if (localLoaderInfo1.mPendingLoader != null)
        {
          if ((DEBUG) && (QLog.isDevelopLevel())) {
            QLog.d("LoaderManager", 4, "  Removing pending loader: " + localLoaderInfo1.mPendingLoader);
          }
          localLoaderInfo1.mPendingLoader.destroy();
          localLoaderInfo1.mPendingLoader = null;
        }
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Enqueuing as new pending loader");
        }
        localLoaderInfo1.mPendingLoader = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
        return localLoaderInfo1.mPendingLoader.mLoader;
        label339:
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Making last loader inactive: " + localLoaderInfo1);
        }
        localLoaderInfo1.mLoader.abandon();
        this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void updateActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */