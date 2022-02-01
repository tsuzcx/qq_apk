package com.tencent.aelight.camera.ae.play;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEPlayMaterialDownloadWrap
{
  private static final String TAG = "AEPlayMaterialDownloadWrap";
  private final Map<String, AEMaterialDownloader.MaterialDownloadListener> downloadingMap = new HashMap();
  private String finalDownloadId = "";
  private WeakReference<VideoStoryCapturePartManager> mPartManager;
  private final Map<String, List<IProgressObserver>> observerMap = new HashMap();
  
  private void addDownloadListener(String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    synchronized (this.downloadingMap)
    {
      this.downloadingMap.put(paramString, paramMaterialDownloadListener);
      return;
    }
  }
  
  private void deleteDownloadListener(String paramString)
  {
    synchronized (this.downloadingMap)
    {
      this.downloadingMap.remove(paramString);
      return;
    }
  }
  
  public static AEPlayMaterialDownloadWrap getInstance()
  {
    return AEPlayMaterialDownloadWrap.InstanceHolder.multiDownloadManager;
  }
  
  private boolean isListenerExits(String paramString)
  {
    for (;;)
    {
      synchronized (this.downloadingMap)
      {
        if (this.downloadingMap.get(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void addProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    if (paramIProgressObserver != null) {
      try
      {
        List localList = (List)this.observerMap.get(paramString);
        Object localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        if (!((List)localObject).contains(paramIProgressObserver))
        {
          ((List)localObject).add(paramIProgressObserver);
          this.observerMap.put(paramString, localObject);
        }
      }
      finally {}
    }
  }
  
  public void clearObserver()
  {
    this.mPartManager = null;
    this.observerMap.clear();
  }
  
  public Map<String, AEMaterialDownloader.MaterialDownloadListener> getDownloadingMap()
  {
    return this.downloadingMap;
  }
  
  public String getFinalDownloadId()
  {
    return this.finalDownloadId;
  }
  
  public void notifyDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    try
    {
      String str = paramAEMaterialMetaData.m;
      List localList = (List)this.observerMap.get(str);
      if ((this.finalDownloadId != null) && (this.finalDownloadId.equals(str)) && (paramBoolean) && (paramAEMaterialMetaData.equals(AEPlayShowGridAdapter.selectedMaterial))) {
        ThreadManager.getUIHandler().post(new AEPlayMaterialDownloadWrap.2(this, paramAEMaterialMetaData));
      }
      if (localList == null)
      {
        this.observerMap.remove(str);
        return;
      }
      paramAEMaterialMetaData = localList.iterator();
      while (paramAEMaterialMetaData.hasNext()) {
        ((IProgressObserver)paramAEMaterialMetaData.next()).onDownloadFinish(str, paramBoolean);
      }
      this.observerMap.remove(str);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAEMaterialMetaData;
    }
  }
  
  public void notifyDownloadProgress(String paramString, int paramInt)
  {
    try
    {
      Object localObject = (List)this.observerMap.get(paramString);
      if (localObject == null)
      {
        this.observerMap.remove(paramString);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IProgressObserver)((Iterator)localObject).next()).onProgressUpdate(paramString, paramInt);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void removeProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    try
    {
      List localList = (List)this.observerMap.get(paramString);
      if ((localList != null) && (localList.size() > 1))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if ((IProgressObserver)localIterator.next() == paramIProgressObserver) {
            localIterator.remove();
          }
        }
      }
      if ((localList == null) || (localList.size() < 1)) {
        this.observerMap.remove(paramString);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void startDownload(VideoStoryCapturePartManager paramVideoStoryCapturePartManager, @NonNull AEMaterialManager paramAEMaterialManager, @NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (isListenerExits(paramAEMaterialMetaData.m)) {
      return;
    }
    WeakReference localWeakReference = this.mPartManager;
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      this.mPartManager = new WeakReference(paramVideoStoryCapturePartManager);
    }
    paramVideoStoryCapturePartManager = new AEPlayMaterialDownloadWrap.DownloadProcessListener(null);
    addDownloadListener(paramAEMaterialMetaData.m, paramVideoStoryCapturePartManager);
    this.finalDownloadId = paramAEMaterialMetaData.m;
    ThreadManager.excute(new AEPlayMaterialDownloadWrap.1(this, paramAEMaterialManager, paramAEMaterialMetaData, paramVideoStoryCapturePartManager), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayMaterialDownloadWrap
 * JD-Core Version:    0.7.0.1
 */