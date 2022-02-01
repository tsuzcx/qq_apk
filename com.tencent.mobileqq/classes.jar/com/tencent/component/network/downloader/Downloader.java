package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class Downloader
{
  protected Context mContext = null;
  protected IPStrategy pBackupIPConfig;
  protected ContentHandler pContentHandler;
  protected IPStrategy pDirectIPConfig;
  protected Downloader.DownloadMode pDownloadMode = Downloader.DownloadMode.FastMode;
  protected ReportHandler pExternalReportHandler;
  protected PriorityThreadPool pExternalThreadPool;
  protected FileHandler pFileHandler;
  protected boolean pHttpsIpDirectEnable = false;
  protected KeepAliveStrategy pKeepAliveStrategy;
  protected int pMaxConnection = 0;
  protected int pMaxConnectionPerRoute = 0;
  protected Proxy pMobileProxy;
  protected String pName;
  protected Downloader.NetworkFlowStatistics pNetworkFlowStatistics;
  protected PortConfigStrategy pPortConfigStrategy;
  protected DownloadPreprocessStrategy pProcessStrategy;
  protected ReportHandler pReportHandler;
  protected ResumeTransfer pResumeTransfer;
  protected FileCacheService pTmpFileCache;
  protected UrlKeyGenerator pUrlKeyGenerator;
  
  public Downloader(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.pName = paramString;
    this.pTmpFileCache = CacheManager.getTmpFileCacheService(this.mContext);
  }
  
  public abstract void abort(String paramString, Downloader.DownloadListener paramDownloadListener);
  
  public abstract void cancel(String paramString, Downloader.DownloadListener paramDownloadListener);
  
  public abstract void cancelAll();
  
  public abstract void cleanCache();
  
  public abstract void cleanCache(String paramString);
  
  public abstract boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean);
  
  public final boolean download(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, true, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, paramString2, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, new String[] { paramString2 }, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode)
  {
    return download(paramString, paramArrayOfString, paramBoolean1, paramBoolean2, paramDownloadListener, paramDownloadMode, null);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener, Downloader.DownloadMode paramDownloadMode, DownloadRequest.OnResponseDataListener paramOnResponseDataListener)
  {
    if ((Utils.checkUrl(paramString)) && (paramArrayOfString != null))
    {
      paramString = new DownloadRequest(paramString, paramArrayOfString, paramBoolean1, paramDownloadListener);
      paramString.mode = paramDownloadMode;
      paramString.onResponseDataListener = paramOnResponseDataListener;
      return download(paramString, paramBoolean2);
    }
    return false;
  }
  
  public void enableResumeTransfer()
  {
    enableResumeTransfer(false);
  }
  
  public void enableResumeTransfer(boolean paramBoolean)
  {
    enableResumeTransfer(paramBoolean, null, false);
  }
  
  public void enableResumeTransfer(boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    Object localObject = this.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tmp_");
    localStringBuilder.append(Utils.getCurrentProcessName(this.mContext));
    localStringBuilder.append("_");
    localStringBuilder.append(this.pName);
    localObject = new QzoneResumeTransfer((Context)localObject, localStringBuilder.toString(), this.pTmpFileCache, true);
    ((QzoneResumeTransfer)localObject).mForceEnable = paramBoolean1;
    ((QzoneResumeTransfer)localObject).setUrlKeyGenerator(this.pUrlKeyGenerator);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      ((QzoneResumeTransfer)localObject).setSupportDomains(paramArrayOfString, paramBoolean2);
    }
    this.pResumeTransfer = ((ResumeTransfer)localObject);
  }
  
  protected String generateStorageName(String paramString)
  {
    paramString = generateUrlKey(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return UUID.randomUUID().toString();
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public String generateUrlKey(String paramString)
  {
    Object localObject = this.pUrlKeyGenerator;
    if (localObject == null) {
      localObject = paramString;
    } else {
      localObject = ((UrlKeyGenerator)localObject).doGenerate(paramString);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
    return localObject;
  }
  
  public KeepAliveStrategy getKeepAliveStrategy()
  {
    return this.pKeepAliveStrategy;
  }
  
  public Proxy getMobileProxy()
  {
    return this.pMobileProxy;
  }
  
  public DownloadPreprocessStrategy getPreprocessStrategy()
  {
    return this.pProcessStrategy;
  }
  
  public abstract void preConnectHost(ArrayList<String> paramArrayList, String paramString);
  
  public void setBackupIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pBackupIPConfig = paramIPStrategy;
    DownloaderFactory.getInstance(this.mContext).setBackupIPConfigStrategy(paramIPStrategy);
  }
  
  public void setContentHandler(ContentHandler paramContentHandler)
  {
    this.pContentHandler = paramContentHandler;
  }
  
  public void setDirectIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pDirectIPConfig = paramIPStrategy;
    DownloaderFactory.getInstance(this.mContext).setDirectIPConfigStrategy(paramIPStrategy);
  }
  
  public void setDownloadMode(Downloader.DownloadMode paramDownloadMode)
  {
    this.pDownloadMode = paramDownloadMode;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    if (paramExecutor == null)
    {
      this.pExternalThreadPool = null;
      return;
    }
    this.pExternalThreadPool = new PriorityThreadPool(paramExecutor);
  }
  
  public void setExternalReportHandler(ReportHandler paramReportHandler)
  {
    this.pExternalReportHandler = paramReportHandler;
  }
  
  public void setFileHandler(FileHandler paramFileHandler)
  {
    this.pFileHandler = paramFileHandler;
  }
  
  public void setHttpConnectionParam(int paramInt1, int paramInt2)
  {
    this.pMaxConnectionPerRoute = paramInt1;
    this.pMaxConnection = paramInt2;
  }
  
  public void setHttpsIpDirectEnable(boolean paramBoolean)
  {
    this.pHttpsIpDirectEnable = paramBoolean;
  }
  
  public void setKeepAliveStrategy(KeepAliveStrategy paramKeepAliveStrategy)
  {
    this.pKeepAliveStrategy = paramKeepAliveStrategy;
  }
  
  public void setMobileProxy(Proxy paramProxy)
  {
    this.pMobileProxy = paramProxy;
  }
  
  public void setNetworkFlowStatistics(Downloader.NetworkFlowStatistics paramNetworkFlowStatistics)
  {
    this.pNetworkFlowStatistics = paramNetworkFlowStatistics;
  }
  
  public void setPortConfigStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.pPortConfigStrategy = paramPortConfigStrategy;
    DownloaderFactory.getInstance(this.mContext).setPortStrategy(this.pPortConfigStrategy);
  }
  
  public void setPreprocessStrategy(DownloadPreprocessStrategy paramDownloadPreprocessStrategy)
  {
    this.pProcessStrategy = paramDownloadPreprocessStrategy;
  }
  
  @Deprecated
  public void setReportHandler(ReportHandler paramReportHandler)
  {
    this.pReportHandler = paramReportHandler;
  }
  
  public void setUrlKeyGenerator(UrlKeyGenerator paramUrlKeyGenerator)
  {
    this.pUrlKeyGenerator = paramUrlKeyGenerator;
    paramUrlKeyGenerator = this.pResumeTransfer;
    if (paramUrlKeyGenerator != null) {
      paramUrlKeyGenerator.setUrlKeyGenerator(this.pUrlKeyGenerator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader
 * JD-Core Version:    0.7.0.1
 */