package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public class e
  extends h
{
  public static final String TAG = "AdCanvasAppBtnUIAdapter";
  public boolean addToDownloadCallbacks;
  private String btnTitle;
  public c data;
  private boolean firstClick = true;
  private AdAppDownloadManager mAdAppDownloadManager;
  private f mAdProgressButton;
  public boolean resumeDownload = false;
  
  public e(c paramc, String paramString, f paramf, AdAppDownloadManager paramAdAppDownloadManager, boolean paramBoolean)
  {
    this.mAdProgressButton = paramf;
    this.mAdAppDownloadManager = paramAdAppDownloadManager;
    this.btnTitle = paramString;
    this.data = paramc;
    this.addToDownloadCallbacks = paramBoolean;
    if (this.data.canShowProgress) {
      this.firstClick = false;
    }
  }
  
  private void dealDownloadInstalled(AdAppBtnData paramAdAppBtnData, Context paramContext)
  {
    installSucceedUpdateUI(paramAdAppBtnData);
    launchApp(paramContext, paramAdAppBtnData.packageName);
  }
  
  private void firstClickInitDownloadApp()
  {
    if (this.mAdProgressButton.getContext() != null)
    {
      Object localObject = this.mAdAppDownloadManager;
      if (localObject != null)
      {
        if (!((AdAppDownloadManager)localObject).getGdtAppBtnData().isValid()) {
          return;
        }
        localObject = this.mAdAppDownloadManager.getGdtAppBtnData();
        Context localContext = this.mAdProgressButton.getContext();
        this.mAdAppDownloadManager.dealPkgExist(new e.6(this, localContext, (AdAppBtnData)localObject));
      }
    }
  }
  
  private void installDownload(AdAppBtnData paramAdAppBtnData)
  {
    AdAppDownloadManager localAdAppDownloadManager = this.mAdAppDownloadManager;
    if (localAdAppDownloadManager != null) {
      localAdAppDownloadManager.installDownload(paramAdAppBtnData.apkUrlhttp);
    }
  }
  
  private void launchApp(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.mAdAppDownloadManager.sourceId)) {
      localBundle.putString(AdDownloadConstants.KEY_REF_ID, this.mAdAppDownloadManager.sourceId);
    }
    localBundle.putString(AdDownloadConstants.KEY, AdDownloadConstants.SRC_AD);
    AdAppUtil.launch(paramContext, paramString, localBundle);
  }
  
  private void pauseDownload(AdAppBtnData paramAdAppBtnData)
  {
    this.resumeDownload = false;
    this.mAdAppDownloadManager.pauseDownload(paramAdAppBtnData.packageName, paramAdAppBtnData.apkUrlhttp);
    pauseDownload();
    reportForPaused();
  }
  
  private void pauseDownloadUi(AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new e.1(this, paramAdAppBtnData, paramInt), 0);
  }
  
  private void restartDownload(AdAppBtnData paramAdAppBtnData)
  {
    if (this.mAdProgressButton != null)
    {
      this.mAdAppDownloadManager.startDownload();
      startDownload(0);
    }
  }
  
  private void resumeDownload(AdAppBtnData paramAdAppBtnData)
  {
    this.resumeDownload = true;
    if ((this.mAdProgressButton != null) && ((paramAdAppBtnData.cState == 2) || (paramAdAppBtnData.cState == 1)))
    {
      this.mAdAppDownloadManager.startDownload();
      startDownload(paramAdAppBtnData.cProgerss);
    }
  }
  
  private void startDownload()
  {
    this.mAdAppDownloadManager.startDownload();
    startDownload(0);
  }
  
  private void uninstallSucceedUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    resetDownloadStateUi(paramAdAppBtnData);
  }
  
  public void finishDownloadUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.3(this, paramAdAppBtnData), 0);
  }
  
  public void initDownloadApp(int paramInt)
  {
    try
    {
      if ((this.mAdAppDownloadManager != null) && (this.mAdAppDownloadManager.getGdtAppBtnData() != null))
      {
        if (!this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) {
          return;
        }
        AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
        if (paramInt != 0)
        {
          if (paramInt != 1) {
            if (paramInt != 2)
            {
              if (paramInt != 3)
              {
                if (paramInt != 6)
                {
                  if (paramInt == 8) {}
                }
                else {
                  installSucceedUpdateUI(localAdAppBtnData);
                }
              }
              else {
                finishDownloadUpdateUI(localAdAppBtnData);
              }
            }
            else
            {
              pauseDownloadUi(localAdAppBtnData, 100);
              return;
            }
          }
          startDownload(localAdAppBtnData.cProgerss);
          return;
        }
        resetDownloadStateUi(localAdAppBtnData);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "initDownloadApp: ", localThrowable);
    }
  }
  
  void installSucceedUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.4(this, paramAdAppBtnData), 0);
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList.size() != 0))
    {
      if (paramList1.size() == 0) {
        return;
      }
      int i = 0;
      while ((i < paramList.size()) && (paramList.get(i) != null) && (paramList1.get(i) != null))
      {
        Object localObject = this.mAdAppDownloadManager;
        if (localObject == null) {
          break;
        }
        if (((AdAppDownloadManager)localObject).getGdtAppBtnData() == null) {
          return;
        }
        localObject = this.mAdAppDownloadManager.getGdtAppBtnData();
        if ((AdDownloader.isCurrentPkgTask((Pair)paramList1.get(i), localObject)) && ((this.data.canShowProgress) || (this.addToDownloadCallbacks)))
        {
          ((AdAppBtnData)localObject).cState = 8;
          updateBtnProgressUI((AdAppBtnData)localObject, AdDownloader.getProgress(paramList.get(i)));
        }
        i += 1;
      }
    }
  }
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString)
  {
    if ((paramPair != null) && (!TextUtils.isEmpty((CharSequence)paramPair.first)) && (!TextUtils.isEmpty((CharSequence)paramPair.second)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = this.mAdAppDownloadManager;
      if (localObject != null)
      {
        if (((AdAppDownloadManager)localObject).getGdtAppBtnData() == null) {
          return;
        }
        localObject = this.mAdAppDownloadManager.getGdtAppBtnData();
        switch (paramInt1)
        {
        default: 
        case 7: 
          if ((paramString.equals(((AdAppBtnData)localObject).mGdtAd_appId)) && (((String)paramPair.second).equals(((AdAppBtnData)localObject).packageName)))
          {
            uninstallSucceedUpdateUI((AdAppBtnData)localObject);
            return;
          }
          break;
        case 6: 
          if ((paramString.equals(((AdAppBtnData)localObject).mGdtAd_appId)) && (((String)paramPair.second).equals(((AdAppBtnData)localObject).packageName)))
          {
            installSucceedUpdateUI((AdAppBtnData)localObject);
            return;
          }
          break;
        case 5: 
          if (AdDownloader.isCurrentPkgTask(paramPair, localObject))
          {
            ((AdAppBtnData)localObject).cState = 5;
            return;
          }
          break;
        case 4: 
          if ((AdDownloader.isCurrentPkgTask(paramPair, localObject)) && (this.data.canShowProgress))
          {
            resetDownloadStateUi((AdAppBtnData)localObject);
            return;
          }
          break;
        case 3: 
          if (AdDownloader.isCurrentPkgTask(paramPair, localObject))
          {
            finishDownloadUpdateUI((AdAppBtnData)localObject);
            return;
          }
          break;
        case 2: 
          if ((AdDownloader.isCurrentPkgTask(paramPair, localObject)) && ((this.data.canShowProgress) || (this.addToDownloadCallbacks))) {
            pauseDownloadUi((AdAppBtnData)localObject, paramInt2);
          }
          break;
        }
      }
    }
  }
  
  public void pauseDownload()
  {
    super.pauseDownload();
    Object localObject = this.mAdAppDownloadManager;
    if ((localObject != null) && (((AdAppDownloadManager)localObject).getGdtAppBtnData().isValid()) && (this.mAdProgressButton.getContext() != null))
    {
      localObject = this.mAdAppDownloadManager;
      if (localObject == null) {
        return;
      }
      localObject = ((AdAppDownloadManager)localObject).getGdtAppBtnData();
      ((AdAppBtnData)localObject).cState = 2;
      AdLog.i("AdCanvasAppBtnUIAdapter", "pauseDownload ");
      pauseDownloadUi((AdAppBtnData)localObject, ((AdAppBtnData)localObject).cProgerss);
    }
  }
  
  public void reportForPaused()
  {
    Object localObject1 = this.mAdAppDownloadManager;
    if ((localObject1 != null) && (((AdAppDownloadManager)localObject1).ad != null))
    {
      localObject1 = this.mAdProgressButton;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((f)localObject1).getContext();
      } else {
        localObject1 = null;
      }
      WeakReference localWeakReference = new WeakReference(localObject1);
      AdAppDownloadManager localAdAppDownloadManager = this.mAdAppDownloadManager;
      localObject1 = localObject2;
      if (localAdAppDownloadManager != null) {
        localObject1 = localAdAppDownloadManager.ad;
      }
      com.tencent.ad.tangram.statistics.c.reportAsync(localWeakReference, (Ad)localObject1, 238);
      return;
    }
    AdLog.e("AdCanvasAppBtnUIAdapter", "reportForPaused ad == null:");
  }
  
  void resetDownloadStateUi(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.5(this, paramAdAppBtnData), 0);
  }
  
  public void startDownload(int paramInt)
  {
    Object localObject = this.mAdAppDownloadManager;
    if ((localObject != null) && (((AdAppDownloadManager)localObject).getGdtAppBtnData().isValid()) && (this.mAdProgressButton.getContext() != null))
    {
      localObject = this.mAdAppDownloadManager;
      if (localObject == null) {
        return;
      }
      localObject = ((AdAppDownloadManager)localObject).getGdtAppBtnData();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload ");
      localStringBuilder.append(paramInt);
      AdLog.i("AdCanvasAppBtnUIAdapter", localStringBuilder.toString());
      updateBtnProgressUI((AdAppBtnData)localObject, paramInt);
      this.resumeDownload = true;
    }
  }
  
  public void updateBtnProgressUI(AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new e.2(this, paramAdAppBtnData, paramInt), 0);
  }
  
  public void updateUIByClick(String paramString, AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    if (this.mAdAppDownloadManager == null)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick mAdAppDownloadManager == null");
      return;
    }
    if (paramAdAppBtnData == null)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick cgdtAppBtnData == null");
      if (this.resumeDownload)
      {
        this.mAdProgressButton.setText("继续");
        this.mAdProgressButton.setProgress(0);
      }
      else
      {
        this.mAdProgressButton.setText("下载中, 0%");
        this.mAdProgressButton.setProgress(0);
        this.mAdAppDownloadManager.fetchAppDataByOnClick(paramString);
      }
      this.resumeDownload ^= true;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateUIByClick firstClick");
    localStringBuilder.append(this.firstClick);
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cState:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" hasStartedDownload");
    localStringBuilder.append(this.mAdAppDownloadManager.hasStartedDownload());
    AdLog.e("AdCanvasAppBtnUIAdapter", localStringBuilder.toString());
    if (this.firstClick)
    {
      paramString = this.mAdAppDownloadManager;
      if ((paramString != null) && (paramString.hasStartedDownload()))
      {
        firstClickInitDownloadApp();
        this.firstClick = false;
        return;
      }
    }
    this.firstClick = false;
    paramString = this.data;
    if (paramString != null) {
      paramString.canShowProgress = true;
    }
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              if (paramInt != 8) {
                return;
              }
              pauseDownload(paramAdAppBtnData);
              return;
            }
            launchApp(this.mAdProgressButton.getContext(), paramAdAppBtnData.packageName);
            return;
          }
          restartDownload(paramAdAppBtnData);
          return;
        }
        installDownload(paramAdAppBtnData);
        return;
      }
      resumeDownload(paramAdAppBtnData);
      return;
    }
    startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.e
 * JD-Core Version:    0.7.0.1
 */