package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public final class GdtInterstitialPreDownloader
{
  private static volatile GdtInterstitialPreDownloader a;
  private volatile GdtArkPreDownloadTask b;
  private volatile long c = -2147483648L;
  private AdIPCManager.Callback d = new GdtInterstitialPreDownloader.2(this);
  private GdtArkPreDownloadTask.Listener e = new GdtInterstitialPreDownloader.3(this);
  
  public static GdtInterstitialPreDownloader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtInterstitialPreDownloader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    GdtLog.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.b == null) {
      synchronized (a)
      {
        if (this.b == null)
        {
          this.c = System.currentTimeMillis();
          this.b = new GdtArkPreDownloadTask(new WeakReference(this.e), GdtInterstitialManager.a().d(), -2147483648L);
          GdtAnalysisHelperForInterstitial.a(BaseApplication.getContext());
        }
        return;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    new WeakReference(paramContext);
    AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialPreDownloader.1(this), 4, 300000L);
  }
  
  public int b()
  {
    if (this.b != null) {
      return this.b.a();
    }
    return -2147483648;
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
    AdIPCManager.INSTANCE.send(BaseApplication.getContext(), new AdIPCManager.Params(paramContext), new WeakReference(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader
 * JD-Core Version:    0.7.0.1
 */