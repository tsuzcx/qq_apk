package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloadTask;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.statistics.b.a;
import com.tencent.ad.tangram.statistics.canvas.AdRefreshCallback;
import com.tencent.ad.tangram.statistics.canvas.AdReport;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public class AdAppDownloadManager
  implements IAdDownloader.Callback
{
  public static final int DOWNLOAD_CANCELED = 4;
  public static final int DOWNLOAD_ERROR = 5;
  public static final int DOWNLOAD_FINISHED = 3;
  public static final int DOWNLOAD_ING = 8;
  public static final int DOWNLOAD_INSTALL_SUCCESS = 6;
  public static final int DOWNLOAD_NONE = 0;
  public static final int DOWNLOAD_PAUSED = 2;
  public static final int DOWNLOAD_STARTED = 1;
  public static final int DOWNLOAD_UNINSTALL_SUCCESS = 7;
  private static final int MAX_TRY = 3;
  private static final String TAG = "AdAppDownloadManager";
  public Ad ad;
  private ArrayList<AdRefreshCallback> adRefreshCallbacks = new ArrayList();
  private AdAppDownloadManager.b appDataDownloadCallbacks = null;
  private boolean autodownload = false;
  private WeakReference<AdAppDownloadManager.a> dataCallbackWeakReference = null;
  private ArrayList<AdAppDownloadManager.d> downloadStatusCallbacks = new ArrayList();
  private g downloaderWrapper = null;
  private volatile boolean initialized;
  private boolean isLoadingAppData;
  private CopyOnWriteArrayList<h> mBtnUIPresenterList = new CopyOnWriteArrayList();
  private volatile AdAppBtnData mCgdtAppBtnData;
  private AdAppDownloadManager.c mClickLoadAppJob = null;
  private WeakReference<Context> mContext;
  private Runnable mLoadAppJob = new AdAppDownloadManager.2(this);
  private boolean mStartedDownload = false;
  private Runnable mWiFiDelayJob = new AdAppDownloadManager.1(this);
  public String sourceId;
  
  private void callAdRefreshCallback()
  {
    this.adRefreshCallbacks.add(AdReport.getAdReportAdapter());
    int i = 0;
    while (i < this.adRefreshCallbacks.size())
    {
      if (this.adRefreshCallbacks.get(i) != null) {
        ((AdRefreshCallback)this.adRefreshCallbacks.get(i)).onAdRefresh(this.ad);
      }
      i += 1;
    }
  }
  
  private void callAppDataDownloadCallback()
  {
    AdAppDownloadManager.b localb = this.appDataDownloadCallbacks;
    if (localb != null) {
      localb.onLoadSuccess();
    }
  }
  
  private void dealDownloadInstalled(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onActivityResume already installed. ");
    ((StringBuilder)localObject).append(paramString);
    AdLog.w("AdAppDownloadManager", ((StringBuilder)localObject).toString());
    paramString = this.mBtnUIPresenterList.iterator();
    while (paramString.hasNext())
    {
      localObject = (h)paramString.next();
      if (!(localObject instanceof e)) {
        return;
      }
      ((e)localObject).installSucceedUpdateUI(this.mCgdtAppBtnData);
    }
  }
  
  private void fetchAppData()
  {
    AdLog.d("AdAppDownloadManager", "going fetch AppData");
    if ((!this.isLoadingAppData) && (this.mCgdtAppBtnData == null))
    {
      WeakReference localWeakReference = this.mContext;
      if ((localWeakReference != null) && (AdNet.isNetValid((Context)localWeakReference.get())))
      {
        this.isLoadingAppData = true;
        AdThreadManager.INSTANCE.post(this.mLoadAppJob, 4);
      }
    }
  }
  
  private h findPresenter(String paramString)
  {
    Object localObject = this.mBtnUIPresenterList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return null;
      }
      int i = 0;
      while (i < this.mBtnUIPresenterList.size())
      {
        localObject = (h)this.mBtnUIPresenterList.get(i);
        if (localObject == null) {
          return null;
        }
        if ((TextUtils.isEmpty(paramString)) && ((localObject instanceof a))) {
          return localObject;
        }
        if ((!TextUtils.isEmpty(paramString)) && ((localObject instanceof e)) && (TextUtils.equals(paramString, ((e)this.mBtnUIPresenterList.get(i)).data.id))) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void firstAutoDownloadReport()
  {
    if ((this.autodownload) && (this.mContext != null) && (this.mCgdtAppBtnData != null)) {
      dealPkgExist(new AdAppDownloadManager.7(this));
    }
  }
  
  private void initAutoRefreshUICallback()
  {
    registerDownloadListener();
    this.appDataDownloadCallbacks = new AdAppDownloadManager.3(this);
  }
  
  private void reprtAppDataLoad(boolean paramBoolean, long paramLong)
  {
    b.a locala = new b.a();
    locala.context = this.mContext;
    locala.ad = this.ad;
    landing_page_collect_data.LandingPageCollectData localLandingPageCollectData = locala.data;
    int i;
    if (paramBoolean) {
      i = 36;
    } else {
      i = 37;
    }
    localLandingPageCollectData.landing_page_action_type = i;
    locala.data.landing_error_code = 0;
    locala.data.latency_ms = paramLong;
    b.report(locala);
  }
  
  private void setmCgdtAppBtnData(AdAppBtnData paramAdAppBtnData)
  {
    try
    {
      if (this.mCgdtAppBtnData == null)
      {
        this.mCgdtAppBtnData = paramAdAppBtnData;
        AdDownloadTask.setDownloadUrl(this.mCgdtAppBtnData.apkUrlhttp);
      }
      return;
    }
    finally
    {
      paramAdAppBtnData = finally;
      throw paramAdAppBtnData;
    }
  }
  
  private void syncDownloadBtnUI(int paramInt)
  {
    callDownloadStatusCallbacks();
    Object localObject1 = this.mBtnUIPresenterList;
    if (localObject1 != null)
    {
      if (((CopyOnWriteArrayList)localObject1).size() == 0) {
        return;
      }
      localObject1 = this.mBtnUIPresenterList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        h localh = (h)((Iterator)localObject1).next();
        if ((localh instanceof e))
        {
          Object localObject2 = (e)localh;
          if (((e)localObject2).data != null)
          {
            if (!(findPresenter(((e)localObject2).data.id) instanceof e)) {
              return;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("syncDownloadBtnUI :");
            ((StringBuilder)localObject2).append(paramInt);
            AdLog.i("AdCanvasAppBtnUIAdapter", ((StringBuilder)localObject2).toString());
            localh.initDownloadApp(paramInt);
            continue;
          }
        }
        AdLog.e("AdCanvasAppBtnUIAdapter", "syncDownloadBtnUI failed");
      }
    }
  }
  
  public void callDownloadStatusCallbacks()
  {
    Iterator localIterator = this.downloadStatusCallbacks.iterator();
    while (localIterator.hasNext())
    {
      AdAppDownloadManager.d locald = (AdAppDownloadManager.d)localIterator.next();
      if ((locald != null) && (this.mContext != null) && (this.mCgdtAppBtnData != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDownloadStatus");
        localStringBuilder.append(this.mCgdtAppBtnData.cState);
        AdLog.i("AdAppDownloadManager", localStringBuilder.toString());
        locald.getDownloadStatus(this.mCgdtAppBtnData.cState);
      }
      else
      {
        AdLog.i("AdAppDownloadManager", " no data");
      }
    }
  }
  
  public void dealPkgExist(AdAppDownloadManager.e parame)
  {
    AdThreadManager.INSTANCE.post(new AdAppDownloadManager.5(this, parame), 5);
  }
  
  public void fetchAppDataByOnClick(String paramString)
  {
    if (this.mClickLoadAppJob == null) {
      this.mClickLoadAppJob = new AdAppDownloadManager.c(this, paramString);
    }
    paramString = this.mContext;
    if ((paramString != null) && (AdNet.isNetValid((Context)paramString.get())) && (!this.isLoadingAppData))
    {
      this.isLoadingAppData = true;
      AdThreadManager.INSTANCE.post(this.mClickLoadAppJob, 4);
    }
  }
  
  public void fetchDownloadStatus(AdAppDownloadManager.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.downloadStatusCallbacks.add(paramd);
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    if (paramContext == null) {
      return 0;
    }
    g localg = this.downloaderWrapper;
    if (localg != null) {
      i = localg.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
    }
    return i;
  }
  
  public g getDownloader()
  {
    return this.downloaderWrapper;
  }
  
  public AdAppBtnData getGdtAppBtnData()
  {
    return this.mCgdtAppBtnData;
  }
  
  public boolean hasStartedDownload()
  {
    return this.mStartedDownload;
  }
  
  public void init(Context paramContext, boolean paramBoolean, Ad paramAd, String paramString)
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
      this.initialized = true;
      this.mContext = new WeakReference(paramContext);
      this.autodownload = paramBoolean;
      this.ad = paramAd;
      this.sourceId = paramString;
      setDownloader();
      initAutoRefreshUICallback();
      fetchAppData();
      callAdRefreshCallback();
      if (AdNet.isWifiConnected(paramContext)) {
        AdThreadManager.INSTANCE.postDelayed(this.mWiFiDelayJob, 3, 1000L);
      }
      return;
    }
    finally {}
  }
  
  public void initDownloadAction(boolean paramBoolean)
  {
    try
    {
      if ((this.mCgdtAppBtnData != null) && (this.mContext != null))
      {
        if (this.mContext.get() == null) {
          return;
        }
        String str = this.mCgdtAppBtnData.packageName;
        if (AdAppUtil.isInstalled((Context)this.mContext.get(), str))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("App already installed ");
          localStringBuilder.append(str);
          AdLog.i("AdAppDownloadManager", localStringBuilder.toString());
          this.mCgdtAppBtnData.cState = 6;
          syncDownloadBtnUI(6);
          return;
        }
        dealPkgExist(new AdAppDownloadManager.4(this, paramBoolean));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdAppDownloadManager", "initDownloadAction: ", localThrowable);
    }
  }
  
  public void installDownload(String paramString)
  {
    if (this.downloaderWrapper != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      g localg = this.downloaderWrapper;
      localg.installDownload(localg.getDownloadInfoByUrl(paramString));
    }
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    int i = -1;
    if (paramContext == null) {
      return -1;
    }
    g localg = this.downloaderWrapper;
    if (localg != null) {
      i = localg.isPkgDownloadPaused(paramContext, paramString1, paramString2);
    }
    return i;
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    int i = -1;
    if (paramContext == null) {
      return -1;
    }
    g localg = this.downloaderWrapper;
    if (localg != null) {
      i = localg.isPkgDownloading(paramContext, paramString1, paramString2);
    }
    return i;
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    g localg = this.downloaderWrapper;
    boolean bool1 = bool2;
    if (localg != null)
    {
      bool1 = bool2;
      if (localg.isPkgExist(paramContext, paramString1, paramString2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onActivityResume()
  {
    dealPkgExist(new AdAppDownloadManager.6(this));
  }
  
  public void onDestroy()
  {
    AdLog.i("AdCanvasAppBtnUIAdapter", "onDestroy resetStaticVariables");
    unregisterDownloadListener();
    this.isLoadingAppData = false;
    this.mStartedDownload = false;
    Object localObject = this.mBtnUIPresenterList;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    localObject = this.adRefreshCallbacks;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    this.appDataDownloadCallbacks = null;
    this.dataCallbackWeakReference = null;
    this.downloadStatusCallbacks.clear();
    this.initialized = false;
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    Object localObject = this.mBtnUIPresenterList;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.mBtnUIPresenterList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        if (localh == null) {
          return;
        }
        localh.onDownloadProgressUpdate(paramList, paramList1);
      }
    }
  }
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString)
  {
    Object localObject = this.mBtnUIPresenterList;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.mBtnUIPresenterList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        if (localh == null) {
          return;
        }
        localh.onDownloadStatusChanged(paramInt1, paramInt2, paramPair, paramString);
      }
    }
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    g localg = this.downloaderWrapper;
    if (localg != null) {
      localg.pauseDownload(paramString1, paramString2);
    }
  }
  
  public void registerDownloadListener()
  {
    AdLog.d("AdAppDownloadManager", "registerDownloadListener: ");
    g localg = this.downloaderWrapper;
    if (localg != null) {
      localg.registerListener(AdCanvasDownloadListener.getDownloadListener(this));
    }
  }
  
  public void removePresenter(h paramh)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.mBtnUIPresenterList;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.remove(paramh);
    }
  }
  
  public void setAppBtnUIPresenter(h paramh)
  {
    if (!this.mBtnUIPresenterList.contains(paramh))
    {
      this.mBtnUIPresenterList.add(paramh);
      callAppDataDownloadCallback();
    }
  }
  
  public void setAppDataCallback(WeakReference<AdAppDownloadManager.a> paramWeakReference)
  {
    if (this.dataCallbackWeakReference == null) {
      this.dataCallbackWeakReference = paramWeakReference;
    }
  }
  
  public void setDownloader()
  {
    if (this.downloaderWrapper == null) {
      this.downloaderWrapper = new g(AdDownloader.getDownloader());
    }
  }
  
  public void setStartedDownload(boolean paramBoolean)
  {
    this.mStartedDownload = paramBoolean;
  }
  
  public void startDownload()
  {
    if (this.mCgdtAppBtnData == null) {
      return;
    }
    this.mStartedDownload = true;
    AdAppBtnData localAdAppBtnData = this.mCgdtAppBtnData;
    Object localObject = this.ad;
    if (localObject != null) {
      localObject = ((Ad)localObject).getVia();
    } else {
      localObject = null;
    }
    localAdAppBtnData.via = ((String)localObject);
    if (this.downloaderWrapper != null)
    {
      localObject = this.mContext;
      if ((localObject != null) && ((((WeakReference)localObject).get() instanceof Activity))) {
        this.downloaderWrapper.startRealDownload((Activity)this.mContext.get(), this.mCgdtAppBtnData);
      }
    }
    AdReport.downloadReport(this.ad, this.mCgdtAppBtnData.mGdtAd_appId, this.mCgdtAppBtnData.cProgerss, this.autodownload, this.mCgdtAppBtnData);
  }
  
  public void unregisterDownloadListener()
  {
    AdLog.d("AdAppDownloadManager", "unregisterDownloadListener");
    g localg = this.downloaderWrapper;
    if (localg != null) {
      localg.unregisterListener(AdCanvasDownloadListener.getDownloadListener(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */