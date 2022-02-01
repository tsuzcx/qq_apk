package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.OnMainBundleLoadListener;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PatchBundleTask
  implements OnMainBundleLoadListener
{
  private static final String TAG = "PatchBundleTask";
  private static final SparseArray<WeakReference<PatchBundleTask>> sTaskMap = new SparseArray();
  private PatchBundleConfig.SubBundleConfig mCurrentBundleConfig;
  private volatile boolean mEngineReady;
  private WeakReference<HippyEngineContext> mHippyEngineContextRef;
  private int mInstanceId;
  private final HashMap<String, PatchBundleTask.OnLoadPatchBundleListener> mLoadBundleListeners = new HashMap();
  private PatchBundleTask.OnLoadPatchBundleListener mLoadPatchListener = new PatchBundleTask.6(this);
  private final List<PatchBundleTask.LoadTaskItem> mLoadTasks = new ArrayList();
  private final HashSet<String> mLoadedBundlePaths = new HashSet();
  private String mModuleName;
  private HashMap<String, PatchBundleConfig.SSOListConfig> mPreloadSSOMap = new HashMap();
  private volatile boolean mTaskRunning;
  
  public PatchBundleTask(String paramString)
  {
    this.mModuleName = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init moduleName:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" this:");
    localStringBuilder.append(this);
    QLog.i("PatchBundleTask", 1, localStringBuilder.toString());
  }
  
  private void checkDownloadBundle(String paramString)
  {
    ??? = new File(PatchUtils.getBundleFilePath(paramString));
    if (((File)???).exists()) {
      synchronized (this.mLoadTasks)
      {
        this.mLoadTasks.add(new PatchBundleTask.LoadTaskItem(paramString));
        ??? = this.mCurrentBundleConfig;
        if (??? == null) {
          return;
        }
        paramString = (PatchBundleConfig.BundleConfigItem)((PatchBundleConfig.SubBundleConfig)???).mSubConfigs.get(paramString);
        int i = 0;
        if ((paramString == null) || (i >= paramString.mPreLoadList.size())) {
          return;
        }
        checkDownloadBundle((String)paramString.mPreLoadList.get(i));
        i += 1;
      }
    }
    DownloaderInterface localDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
    if (localDownloaderInterface == null)
    {
      QLog.e("PatchBundleTask", 1, "checkDownloadBundle downloader == null");
      return;
    }
    DownloadTask localDownloadTask = new DownloadTask(paramString, (File)???);
    localDownloadTask.p = true;
    localDownloadTask.n = true;
    localDownloadTask.f = "hippy_patch";
    localDownloadTask.b = 1;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    localDownloaderInterface.startDownload(localDownloadTask, new PatchBundleTask.5(this, (File)???, paramString), null);
  }
  
  private void checkLoadBundleTask()
  {
    Object localObject = this.mHippyEngineContextRef;
    if (localObject != null) {
      localObject = (HippyEngineContext)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (this.mEngineReady))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkLoadBundleTask mLoadPatchFiles.size():");
        ((StringBuilder)localObject).append(this.mLoadTasks.size());
        QLog.d("PatchBundleTask", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.mLoadTasks.isEmpty())
      {
        if (!this.mPreloadSSOMap.isEmpty())
        {
          PatchUtils.dispatchSSOData2Page(this.mModuleName, new ArrayList(this.mPreloadSSOMap.values()));
          this.mPreloadSSOMap.clear();
        }
        if (!this.mTaskRunning)
        {
          loadBundleInner();
          return;
        }
        QLog.i("PatchBundleTask", 1, " task is running");
      }
      return;
    }
    QLog.i("PatchBundleTask", 1, "loadPatch hippyEngineContext == null || mDestroy");
  }
  
  private void downloadPrefectBundle(String paramString)
  {
    Object localObject2 = new File(PatchUtils.getBundleFilePath(paramString));
    if (!((File)localObject2).exists())
    {
      localObject1 = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
      if (localObject1 == null)
      {
        QLog.e("PatchBundleTask", 1, "downloadPrefectBundle downloader == null");
        return;
      }
      localObject2 = new DownloadTask(paramString, (File)localObject2);
      ((DownloadTask)localObject2).p = true;
      ((DownloadTask)localObject2).n = true;
      ((DownloadTask)localObject2).f = "hippy_patch";
      ((DownloadTask)localObject2).b = 1;
      ((DownloadTask)localObject2).q = true;
      ((DownloadTask)localObject2).r = true;
      ((DownloaderInterface)localObject1).startDownload((DownloadTask)localObject2, new PatchBundleTask.4(this, paramString), null);
      return;
    }
    Object localObject1 = this.mCurrentBundleConfig;
    if (localObject1 != null)
    {
      paramString = (PatchBundleConfig.BundleConfigItem)((PatchBundleConfig.SubBundleConfig)localObject1).mSubConfigs.get(paramString);
      int i = 0;
      while ((paramString != null) && (i < paramString.mPreLoadList.size()))
      {
        downloadPrefectBundle((String)paramString.mPreLoadList.get(i));
        i += 1;
      }
    }
  }
  
  public static PatchBundleTask getPatchTask(HippyEngineContext paramHippyEngineContext)
  {
    if (paramHippyEngineContext == null) {
      return null;
    }
    paramHippyEngineContext = (WeakReference)sTaskMap.get(paramHippyEngineContext.hashCode());
    if (paramHippyEngineContext != null) {
      return (PatchBundleTask)paramHippyEngineContext.get();
    }
    return null;
  }
  
  private void handlePreloadSSO(PatchBundleConfig.SSOListConfig paramSSOListConfig)
  {
    paramSSOListConfig.loadCache();
    if (this.mEngineReady)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramSSOListConfig);
      PatchUtils.dispatchSSOData2Page(this.mModuleName, localArrayList);
    }
    else if (!TextUtils.isEmpty(paramSSOListConfig.mRsp))
    {
      this.mPreloadSSOMap.put(paramSSOListConfig.mKey, paramSSOListConfig);
    }
    int i;
    if (!TextUtils.isEmpty(paramSSOListConfig.mRsp)) {
      i = paramSSOListConfig.mRsp.hashCode();
    } else {
      i = 0;
    }
    paramSSOListConfig.handleSSOConfigData(new PatchBundleTask.3(this, i, paramSSOListConfig));
  }
  
  public static boolean isRunPatch(HippyEngineContext paramHippyEngineContext)
  {
    return getPatchTask(paramHippyEngineContext) != null;
  }
  
  private void loadBundleInner()
  {
    if (!this.mLoadTasks.isEmpty())
    {
      this.mTaskRunning = true;
      synchronized (this.mLoadTasks)
      {
        PatchBundleTask.LoadTaskItem localLoadTaskItem = (PatchBundleTask.LoadTaskItem)this.mLoadTasks.remove(0);
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkLoadBundleTask url:");
          ((StringBuilder)localObject2).append(localLoadTaskItem.mUrl);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(localLoadTaskItem.mFilePath);
          QLog.i("PatchBundleTask", 2, ((StringBuilder)localObject2).toString());
        }
        if (!this.mLoadedBundlePaths.contains(localLoadTaskItem.mFilePath))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadBundleInner url:");
            ((StringBuilder)localObject2).append(localLoadTaskItem.mUrl);
            ((StringBuilder)localObject2).append(" ");
            ((StringBuilder)localObject2).append(localLoadTaskItem.mFilePath);
            QLog.i("PatchBundleTask", 2, ((StringBuilder)localObject2).toString());
          }
          this.mLoadedBundlePaths.add(localLoadTaskItem.mFilePath);
          loadJsBundle(localLoadTaskItem, this.mLoadPatchListener);
        }
        else
        {
          localObject2 = (PatchBundleTask.OnLoadPatchBundleListener)this.mLoadBundleListeners.get(localLoadTaskItem.mUrl);
          if (localObject2 != null)
          {
            ((PatchBundleTask.OnLoadPatchBundleListener)localObject2).onLoad(localLoadTaskItem.mUrl, 0, "loaded");
            this.mLoadBundleListeners.remove(localLoadTaskItem.mUrl);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkLoadBundleTask duplicate bundle path:");
          ((StringBuilder)localObject2).append(localLoadTaskItem.mFilePath);
          QLog.i("PatchBundleTask", 1, ((StringBuilder)localObject2).toString());
          loadBundleInner();
        }
        return;
      }
    }
    this.mTaskRunning = false;
  }
  
  private void loadJsBundle(PatchBundleTask.LoadTaskItem paramLoadTaskItem, PatchBundleTask.OnLoadPatchBundleListener paramOnLoadPatchBundleListener)
  {
    Object localObject1 = this.mHippyEngineContextRef;
    if (localObject1 != null) {
      localObject1 = (HippyEngineContext)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (this.mEngineReady))
    {
      File localFile = new File(paramLoadTaskItem.mFilePath);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadJsBundle file:");
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(paramLoadTaskItem.mUrl);
        QLog.d("PatchBundleTask", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new HippyFileBundleLoader(localFile.getAbsolutePath(), true, localFile.getName());
      HippyRootView localHippyRootView = ((HippyEngineContext)localObject1).getInstance(this.mInstanceId);
      if (localHippyRootView != null)
      {
        paramLoadTaskItem = new PatchBundleTask.7(this, localFile, paramLoadTaskItem, paramOnLoadPatchBundleListener);
        ((HippyEngineContext)localObject1).getBridgeManager().a(this.mInstanceId, (HippyBundleLoader)localObject2, paramLoadTaskItem, localHippyRootView);
      }
      return;
    }
    QLog.e("PatchBundleTask", 1, "loadPatch hippyEngineContext == null || mDestroy");
  }
  
  public boolean isConfigTask(String paramString)
  {
    PatchBundleConfig.SubBundleConfig localSubBundleConfig = this.mCurrentBundleConfig;
    return (localSubBundleConfig != null) && (localSubBundleConfig.mSubConfigs.get(paramString) != null);
  }
  
  public void onDestroy(String paramString, HippyQQEngine paramHippyQQEngine)
  {
    paramHippyQQEngine = new StringBuilder();
    paramHippyQQEngine.append("onDestroy moduleName:");
    paramHippyQQEngine.append(paramString);
    QLog.i("PatchBundleTask", 1, paramHippyQQEngine.toString());
    paramString = this.mHippyEngineContextRef;
    if ((paramString != null) && (paramString.get() != null)) {
      sTaskMap.remove(((HippyEngineContext)this.mHippyEngineContextRef.get()).hashCode());
    }
    paramString = this.mHippyEngineContextRef;
    if (paramString != null) {
      PatchBundleDataHandlerImpl.onHippyTaskDestroy((HippyEngineContext)paramString.get());
    }
    this.mEngineReady = false;
    this.mHippyEngineContextRef = null;
    this.mLoadedBundlePaths.clear();
    this.mLoadBundleListeners.clear();
  }
  
  public void onMainBundleLoadResult(int paramInt1, String paramString, HippyEngineContext paramHippyEngineContext, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMainBundleLoadResult result:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" moduleName:");
      localStringBuilder.append(paramString);
      QLog.d("PatchBundleTask", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == HippyEngine.ModuleLoadStatus.STATUS_OK.value()) && (paramHippyEngineContext != null))
    {
      sTaskMap.put(paramHippyEngineContext.hashCode(), new WeakReference(this));
      this.mHippyEngineContextRef = new WeakReference(paramHippyEngineContext);
      this.mInstanceId = paramInt2;
      this.mEngineReady = true;
      checkLoadBundleTask();
      return;
    }
    this.mEngineReady = false;
  }
  
  public void onStart()
  {
    if (TextUtils.isEmpty(this.mModuleName)) {
      return;
    }
    Object localObject = PatchBundleDataHandlerImpl.getBundleConfig();
    if (!((PatchBundleConfig)localObject).isSwitchOpen())
    {
      QLog.i("PatchBundleTask", 1, "onStart !patchBundleConfig.isSwitchOpen()");
      return;
    }
    localObject = (PatchBundleConfig.SubBundleConfig)((PatchBundleConfig)localObject).getSubBundleConfig().get(this.mModuleName);
    if ((localObject != null) && (!((PatchBundleConfig.SubBundleConfig)localObject).mSubConfigs.isEmpty()))
    {
      this.mCurrentBundleConfig = ((PatchBundleConfig.SubBundleConfig)localObject);
      int i = UpdateSetting.getInstance().getModuleVersion(this.mModuleName);
      if (!((PatchBundleConfig.SubBundleConfig)localObject).mSupportVersions.contains(String.valueOf(i)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStart no support version:");
        ((StringBuilder)localObject).append(i);
        QLog.i("PatchBundleTask", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStart preload this:");
      ((StringBuilder)localObject).append(this);
      QLog.i("PatchBundleTask", 1, ((StringBuilder)localObject).toString());
      patchBundleLoop(this.mModuleName, null);
      return;
    }
    QLog.i("PatchBundleTask", 1, "onStart no need patch bundle");
  }
  
  public void patchBundleLoop(String paramString, PatchBundleTask.OnLoadPatchBundleListener paramOnLoadPatchBundleListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.mCurrentBundleConfig;
    if (localObject == null) {
      return;
    }
    localObject = (PatchBundleConfig.BundleConfigItem)((PatchBundleConfig.SubBundleConfig)localObject).mSubConfigs.get(paramString);
    if (localObject == null)
    {
      this.mLoadBundleListeners.put(paramString, paramOnLoadPatchBundleListener);
      QLog.e("PatchBundleTask", 1, new Object[] { "patchBundleLoop no found url:", paramString, "new single task" });
      checkDownloadBundle(paramString);
      checkLoadBundleTask();
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("patchBundleLoop preload this:");
      localStringBuilder.append(this);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString);
      QLog.i("PatchBundleTask", 1, localStringBuilder.toString());
    }
    if (this.mLoadedBundlePaths.contains(PatchUtils.getBundleFilePath(paramString)))
    {
      if (paramOnLoadPatchBundleListener != null) {
        paramOnLoadPatchBundleListener.onLoad(paramString, 0, "loaded");
      }
      return;
    }
    this.mLoadBundleListeners.put(paramString, paramOnLoadPatchBundleListener);
    ThreadManagerV2.postImmediately(new PatchBundleTask.1(this, paramString, (PatchBundleConfig.BundleConfigItem)localObject), null, false);
    ThreadManagerV2.postImmediately(new PatchBundleTask.2(this, (PatchBundleConfig.BundleConfigItem)localObject), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask
 * JD-Core Version:    0.7.0.1
 */