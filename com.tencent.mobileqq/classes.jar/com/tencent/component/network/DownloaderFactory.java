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
import pje;
import pjf;

public class DownloaderFactory
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static volatile DownloaderFactory mInstance = null;
  private Downloader mCommonDownloader;
  private Downloader mImageDownloader;
  private FileHandler mImageFileHandler = new pje(this);
  private PortConfigStrategy mPortConfig;
  protected IPStrategy pBackupIPConfig;
  protected IPStrategy pDirectIPConfig;
  
  private DownloaderFactory(Context paramContext)
  {
    Global.a(paramContext.getApplicationContext());
  }
  
  public static Downloader createDownloader(String paramString)
  {
    return createDownloader(paramString, null, null);
  }
  
  public static Downloader createDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    DnsService.a().a(paramExecutor2);
    paramString = new DownloaderImpl(Global.a(), paramString, 2);
    paramString.setExecutor(paramExecutor1);
    return paramString;
  }
  
  public static Downloader createImageDownloader(String paramString)
  {
    return createImageDownloader(paramString, null, null);
  }
  
  public static Downloader createImageDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    DnsService.a().a(paramExecutor2);
    paramString = new DownloaderImpl(Global.a(), paramString, 1);
    paramString.setExecutor(paramExecutor1);
    ImageDownloaderInitializer.a(paramString);
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
    Config.a(paramIDownloadConfig);
    QDLog.a(paramLog);
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
    DownloaderImpl localDownloaderImpl = new DownloaderImpl(Global.a(), "common", 2);
    localDownloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.b);
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
    DownloaderImpl localDownloaderImpl = new DownloaderImpl(Global.a(), "image", 1);
    localDownloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.b);
    localDownloaderImpl.setFileHandler(this.mImageFileHandler);
    localDownloaderImpl.enableResumeTransfer();
    localDownloaderImpl.setContentHandler(new pjf(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */