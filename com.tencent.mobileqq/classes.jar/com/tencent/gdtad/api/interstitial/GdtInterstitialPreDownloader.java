package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import java.lang.ref.WeakReference;

public final class GdtInterstitialPreDownloader
{
  private static volatile GdtInterstitialPreDownloader jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader;
  private volatile long jdField_a_of_type_Long = -2147483648L;
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new GdtInterstitialPreDownloader.2(this);
  private GdtArkPreDownloadTask.Listener jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$Listener = new GdtInterstitialPreDownloader.3(this);
  private volatile GdtArkPreDownloadTask jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask;
  
  public static GdtInterstitialPreDownloader a()
  {
    if (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader == null) {
        jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader = new GdtInterstitialPreDownloader();
      }
      return jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask != null) {
      return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask.a();
    }
    return -2147483648;
  }
  
  public void a()
  {
    GdtLog.b("GdtInterstitialPreDownloader", "preDownloadImpl");
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask == null) {
      synchronized (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialPreDownloader)
      {
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask == null)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask = new GdtArkPreDownloadTask(new WeakReference(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$Listener), GdtInterstitialManager.a().a(), -2147483648L);
          GdtReporterForAnalysis.a(BaseApplicationImpl.getApplication());
        }
        return;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = new WeakReference(paramContext);
    AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialPreDownloader.1(this, paramContext), 4, 300000L);
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtInterstitialPreDownloader", String.format("preDownload", new Object[0]));
    paramContext = new Bundle();
    paramContext.putString("IPC_ACTION", "ipc_interstitial_predownload");
    paramContext.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
    AdIPCManager.INSTANCE.send(BaseApplicationImpl.getContext(), new AdIPCManager.Params(paramContext), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader
 * JD-Core Version:    0.7.0.1
 */