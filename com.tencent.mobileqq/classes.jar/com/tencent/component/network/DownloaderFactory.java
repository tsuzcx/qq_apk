package com.tencent.component.network;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.downloader.impl.ImageDownloaderInitializer;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.component.network.module.base.inter.Log;
import com.tencent.component.network.module.common.DnsService;
import java.util.concurrent.Executor;

public class DownloaderFactory
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static volatile DownloaderFactory mInstance = null;
  private Downloader mCommonDownloader;
  private Downloader mImageDownloader;
  private FileHandler mImageFileHandler = new DownloaderFactory.1(this);
  private PortConfigStrategy mPortConfig;
  protected IPStrategy pBackupIPConfig;
  protected IPStrategy pDirectIPConfig;
  
  private DownloaderFactory(Context paramContext)
  {
    Global.init(paramContext.getApplicationContext());
  }
  
  public static Downloader createDownloader(String paramString)
  {
    return createDownloader(paramString, null, null);
  }
  
  public static Downloader createDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.getContext() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    DnsService.getInstance().setThreadPoolExecutor(paramExecutor2);
    paramString = new DownloaderImpl(Global.getContext(), paramString, 2);
    paramString.setExecutor(paramExecutor1);
    return paramString;
  }
  
  public static Downloader createImageDownloader(String paramString)
  {
    return createImageDownloader(paramString, null, null);
  }
  
  public static Downloader createImageDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.getContext() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    DnsService.getInstance().setThreadPoolExecutor(paramExecutor2);
    paramString = new DownloaderImpl(Global.getContext(), paramString, 1);
    paramString.setExecutor(paramExecutor1);
    ImageDownloaderInitializer.initImageDownloader(paramString);
    return paramString;
  }
  
  public static DownloaderFactory getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    synchronized (INSTANCE_LOCK)
    {
      if (mInstance == null) {
        mInstance = new DownloaderFactory(paramContext);
      }
      return mInstance;
    }
  }
  
  public static void init(IDownloadConfig paramIDownloadConfig, Log paramLog)
  {
    Config.setConfig(paramIDownloadConfig);
    QDLog.setLog(paramLog);
  }
  
  public IPStrategy getBackupIpStrategy()
  {
    return this.pBackupIPConfig;
  }
  
  public Downloader getCommonDownloader()
  {
    if (this.mCommonDownloader != null) {
      return this.mCommonDownloader;
    }
    try
    {
      if (this.mCommonDownloader != null)
      {
        Downloader localDownloader = this.mCommonDownloader;
        return localDownloader;
      }
    }
    finally {}
    DownloaderImpl localDownloaderImpl = new DownloaderImpl(Global.getContext(), "common", 2);
    localDownloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.GENERATOR_DESPITE_HASH);
    localDownloaderImpl.enableResumeTransfer();
    this.mCommonDownloader = localDownloaderImpl;
    return localDownloaderImpl;
  }
  
  public IPStrategy getDirectIpStrategy()
  {
    return this.pDirectIPConfig;
  }
  
  public Downloader getImageDownloader()
  {
    if (this.mImageDownloader != null) {
      return this.mImageDownloader;
    }
    try
    {
      if (this.mImageDownloader != null)
      {
        Downloader localDownloader = this.mImageDownloader;
        return localDownloader;
      }
    }
    finally {}
    DownloaderImpl localDownloaderImpl = new DownloaderImpl(Global.getContext(), "image", 1);
    localDownloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.GENERATOR_DESPITE_HASH);
    localDownloaderImpl.setFileHandler(this.mImageFileHandler);
    localDownloaderImpl.enableResumeTransfer();
    localDownloaderImpl.setContentHandler(new DownloaderFactory.2(this));
    this.mImageDownloader = localDownloaderImpl;
    return localDownloaderImpl;
  }
  
  public PortConfigStrategy getPortStrategy()
  {
    return this.mPortConfig;
  }
  
  public void setBackupIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pBackupIPConfig = paramIPStrategy;
  }
  
  public void setDirectIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pDirectIPConfig = paramIPStrategy;
  }
  
  public void setPortStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.mPortConfig = paramPortConfigStrategy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */