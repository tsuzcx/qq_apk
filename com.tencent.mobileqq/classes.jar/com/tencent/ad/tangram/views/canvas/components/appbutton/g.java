package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;

public class g
{
  private IAdDownloader mDownloader;
  
  public g(IAdDownloader paramIAdDownloader)
  {
    this.mDownloader = paramIAdDownloader;
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
    }
    return 0;
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.getDownloadInfoByUrl(paramString);
    }
    return null;
  }
  
  public void installDownload(Object paramObject)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.installDownload(paramObject);
    }
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgDownloadPaused(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgDownloading(paramContext, paramString1, paramString2);
    }
    return -1;
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      return localIAdDownloader.isPkgExist(paramContext, paramString1, paramString2);
    }
    return false;
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.pauseDownload(paramString1, paramString2);
    }
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.registerListener(paramCallback);
    }
  }
  
  public void startRealDownload(Activity paramActivity, AdAppBtnData paramAdAppBtnData, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    IAdDownloader localIAdDownloader = this.mDownloader;
    if (localIAdDownloader != null) {
      localIAdDownloader.unregisterListener(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.g
 * JD-Core Version:    0.7.0.1
 */