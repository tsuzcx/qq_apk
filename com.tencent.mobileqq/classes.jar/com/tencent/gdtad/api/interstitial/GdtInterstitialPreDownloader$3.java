package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;

class GdtInterstitialPreDownloader$3
  implements GdtArkPreDownloadTask.Listener
{
  GdtInterstitialPreDownloader$3(GdtInterstitialPreDownloader paramGdtInterstitialPreDownloader) {}
  
  public void a(GdtArkApp paramGdtArkApp)
  {
    GdtLog.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramGdtArkApp.a, paramGdtArkApp.b, paramGdtArkApp.c }));
    GdtAnalysisHelperForInterstitial.a(BaseApplication.getContext(), GdtInterstitialPreDownloader.b(GdtInterstitialPreDownloader.a()), 0, -2147483648);
  }
  
  public void a(GdtArkApp paramGdtArkApp, int paramInt)
  {
    GdtLog.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramGdtArkApp.a, paramGdtArkApp.b, paramGdtArkApp.c, Integer.valueOf(paramInt) }));
  }
  
  public void a(GdtArkApp paramGdtArkApp, int paramInt1, int paramInt2)
  {
    GdtLog.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramGdtArkApp.a, paramGdtArkApp.b, paramGdtArkApp.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    GdtAnalysisHelperForInterstitial.a(BaseApplication.getContext(), GdtInterstitialPreDownloader.b(GdtInterstitialPreDownloader.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */