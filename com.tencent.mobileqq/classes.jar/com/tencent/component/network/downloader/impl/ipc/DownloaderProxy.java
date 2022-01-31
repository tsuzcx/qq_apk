package com.tencent.component.network.downloader.impl.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.MultiHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DownloaderProxy
  extends Downloader
{
  private static final String TAG = "RemoteDownloader";
  private Messenger mClientMessenger;
  private ServiceConnection mConnection = new DownloaderProxy.1(this);
  private DownloaderProxy.DownloadHandler mHandler;
  private final MultiHashMap<String, Const.SimpleRequest> mPendingRequests = new MultiHashMap();
  private Messenger mServiceMessenger;
  private int mType = 2;
  private final List<Const.SimpleRequest> mWaitingRequest = new ArrayList();
  
  public DownloaderProxy(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString);
    this.mType = paramInt;
    init();
  }
  
  private boolean addPendingRequest(String arg1, String paramString2, Const.SimpleRequest paramSimpleRequest)
  {
    boolean bool = false;
    if (paramSimpleRequest == null) {
      return false;
    }
    synchronized (this.mPendingRequests)
    {
      int i = this.mPendingRequests.sizeOf(paramString2);
      this.mPendingRequests.add(paramString2, paramSimpleRequest);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  private Collection<Const.SimpleRequest> collectPendingRequest(String paramString, boolean paramBoolean, Collection<Const.SimpleRequest> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.mPendingRequests.remove(paramString); paramCollection != null; paramString = (HashSet)this.mPendingRequests.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  private void doRequestDownload(String paramString, String[] paramArrayOfString, Downloader.DownloadMode paramDownloadMode)
  {
    paramString = Const.obtainDownloadRequestMsg(paramString, paramArrayOfString, this.mType, paramDownloadMode, this.mClientMessenger);
    try
    {
      if (this.mServiceMessenger != null) {
        this.mServiceMessenger.send(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void init()
  {
    this.mHandler = new DownloaderProxy.DownloadHandler(this, Looper.getMainLooper());
    this.mClientMessenger = new Messenger(this.mHandler);
    startService();
  }
  
  private void notifyDownloadCanceled(Collection<Const.SimpleRequest> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramCollection.next();
        if (localSimpleRequest != null)
        {
          Downloader.DownloadListener localDownloadListener = localSimpleRequest.listener;
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadCanceled(localSimpleRequest.url);
          }
        }
      }
    }
  }
  
  private void notifyDownloadFailed(Collection<Const.SimpleRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramCollection.next();
        if (localSimpleRequest != null)
        {
          Downloader.DownloadListener localDownloadListener = localSimpleRequest.listener;
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadFailed(localSimpleRequest.url, paramDownloadResult);
          }
        }
      }
    }
  }
  
  private void notifyDownloadProgress(Collection<Const.SimpleRequest> paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramCollection.next();
        if (localSimpleRequest != null)
        {
          Downloader.DownloadListener localDownloadListener = localSimpleRequest.listener;
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadProgress(localSimpleRequest.url, paramLong, paramFloat);
          }
        }
      }
    }
  }
  
  private void notifyDownloadSucceed(Collection<Const.SimpleRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramCollection.next();
        if (localSimpleRequest != null)
        {
          Downloader.DownloadListener localDownloadListener = localSimpleRequest.listener;
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadSucceed(localSimpleRequest.url, paramDownloadResult);
          }
        }
      }
    }
  }
  
  private boolean removePendingRequest(String paramString, Const.SimpleRequest paramSimpleRequest, Collection<Const.SimpleRequest> paramCollection)
  {
    boolean bool2 = false;
    if (paramSimpleRequest == null) {
      return false;
    }
    synchronized (this.mPendingRequests)
    {
      int i = this.mPendingRequests.sizeOf(paramString);
      if (paramCollection != null) {
        paramCollection.clear();
      }
      if ((this.mPendingRequests.remove(paramString, paramSimpleRequest)) && (paramCollection != null)) {
        paramCollection.add(paramSimpleRequest);
      }
      boolean bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (this.mPendingRequests.sizeOf(paramString) == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private void startService()
  {
    Intent localIntent;
    if (this.mServiceMessenger == null)
    {
      localIntent = new Intent();
      localIntent.setComponent(new ComponentName(this.mContext, "com.tencent.component.network.downloader.impl.ipc.DownloadSerice"));
    }
    try
    {
      this.mContext.bindService(localIntent, this.mConnection, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      QDLog.e("RemoteDownloader", "exception when bind download service!!!", localThrowable);
    }
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    Const.SimpleRequest localSimpleRequest = new Const.SimpleRequest();
    localSimpleRequest.url = paramString;
    localSimpleRequest.listener = paramDownloadListener;
    paramDownloadListener = new ArrayList();
    if (removePendingRequest(paramString, localSimpleRequest, paramDownloadListener))
    {
      paramString = Const.obtainDownloadCancelMsg(paramString, this.mType, this.mClientMessenger);
      if (this.mServiceMessenger == null) {}
    }
    try
    {
      this.mServiceMessenger.send(paramString);
      notifyDownloadCanceled(paramDownloadListener);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    Const.SimpleRequest localSimpleRequest = new Const.SimpleRequest();
    localSimpleRequest.url = paramString;
    localSimpleRequest.listener = paramDownloadListener;
    paramDownloadListener = new ArrayList();
    if (removePendingRequest(paramString, localSimpleRequest, paramDownloadListener))
    {
      paramString = Const.obtainDownloadCancelMsg(paramString, this.mType, this.mClientMessenger);
      if (this.mServiceMessenger == null) {}
    }
    try
    {
      this.mServiceMessenger.send(paramString);
      notifyDownloadCanceled(paramDownloadListener);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void cancelAll() {}
  
  public void cleanCache()
  {
    Message localMessage = Const.obtainCleanCacheMsg("", this.mType, this.mClientMessenger);
    if (this.mServiceMessenger != null) {}
    try
    {
      this.mServiceMessenger.send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void cleanCache(String paramString)
  {
    if (!Utils.checkUrl(paramString)) {}
    do
    {
      return;
      paramString = Const.obtainCleanCacheMsg(paramString, this.mType, this.mClientMessenger);
    } while (this.mServiceMessenger == null);
    try
    {
      this.mServiceMessenger.send(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean download(DownloadRequest arg1, boolean paramBoolean)
  {
    paramBoolean = true;
    int i = 0;
    String str = ???.getUrl();
    String[] arrayOfString = ???.getPaths();
    if ((!Utils.checkUrl(str)) || (arrayOfString == null)) {
      paramBoolean = false;
    }
    do
    {
      return paramBoolean;
      Const.SimpleRequest localSimpleRequest1 = new Const.SimpleRequest();
      localSimpleRequest1.url = str;
      int j = arrayOfString.length;
      while (i < j)
      {
        localSimpleRequest1.addDstPath(arrayOfString[i]);
        i += 1;
      }
      localSimpleRequest1.listener = ???.getListener();
      localSimpleRequest1.mode = ???.mode;
      if (this.mServiceMessenger == null) {
        synchronized (this.mWaitingRequest)
        {
          this.mWaitingRequest.add(localSimpleRequest1);
          startService();
          return true;
        }
      }
    } while (!addPendingRequest(str, str, localSimpleRequest2));
    doRequestDownload(str, arrayOfString, ???.mode);
    return true;
  }
  
  public void uninit()
  {
    if ((this.mServiceMessenger != null) && (this.mConnection != null)) {
      this.mContext.unbindService(this.mConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxy
 * JD-Core Version:    0.7.0.1
 */