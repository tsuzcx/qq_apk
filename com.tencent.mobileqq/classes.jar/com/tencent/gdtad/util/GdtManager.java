package com.tencent.gdtad.util;

import android.content.Context;
import com.tencent.ad.tangram.AdBuilder;
import com.tencent.ad.tangram.AdBuilderAdapter;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.analysis.AdUinAdapter;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.report.AdReport;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.resource.AdResource;
import com.tencent.ad.tangram.canvas.resource.AdResourceAdapter;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapter;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.net.AdConnectivityManager;
import com.tencent.ad.tangram.net.AdTime;
import com.tencent.ad.tangram.net.AdTimeAdapter;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;
import com.tencent.ad.tangram.preorder.AdAppPreOrderDownloadListener;
import com.tencent.ad.tangram.preorder.AdQQReminderAdapter;
import com.tencent.ad.tangram.preorder.AdQQReminderManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.gdtad.adapter.GdtActivityLifecycleManager;
import com.tencent.gdtad.adapter.GdtAdBuilderAdapter;
import com.tencent.gdtad.adapter.GdtAnalysisAdapter;
import com.tencent.gdtad.adapter.GdtBrowserAdapter;
import com.tencent.gdtad.adapter.GdtCanvasAdapter;
import com.tencent.gdtad.adapter.GdtDownloadListenerAdapter;
import com.tencent.gdtad.adapter.GdtDownloaderAdapter;
import com.tencent.gdtad.adapter.GdtHalfScreenAdapter;
import com.tencent.gdtad.adapter.GdtIPCAdapter;
import com.tencent.gdtad.adapter.GdtImageViewBuilderAdapter;
import com.tencent.gdtad.adapter.GdtLocationAdapter;
import com.tencent.gdtad.adapter.GdtLogAdapter;
import com.tencent.gdtad.adapter.GdtOfflineAdapter;
import com.tencent.gdtad.adapter.GdtPreDownloadListenerAdapter;
import com.tencent.gdtad.adapter.GdtProcessManagerAdapter;
import com.tencent.gdtad.adapter.GdtProgressDialogAdapter;
import com.tencent.gdtad.adapter.GdtQQMINIProgramAdapter;
import com.tencent.gdtad.adapter.GdtQQReminderAdapter;
import com.tencent.gdtad.adapter.GdtReportAdapter;
import com.tencent.gdtad.adapter.GdtResourceAdapter;
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter;
import com.tencent.gdtad.adapter.GdtTimeAdapter;
import com.tencent.gdtad.adapter.GdtToastAdapter;
import com.tencent.gdtad.adapter.GdtUinAdapter;
import com.tencent.gdtad.adapter.GdtVersionAdapter;
import com.tencent.gdtad.adapter.GdtVideoCeilingAdapter;
import com.tencent.gdtad.adapter.GdtVideoSpliceAdapter;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.web.GdtLandingPageConfig;
import java.lang.ref.WeakReference;

public final class GdtManager
{
  private static volatile GdtManager jdField_a_of_type_ComTencentGdtadUtilGdtManager;
  private AdBuilderAdapter jdField_a_of_type_ComTencentAdTangramAdBuilderAdapter = new GdtAdBuilderAdapter();
  private AdAnalysisAdapter jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter = new GdtAnalysisAdapter();
  private AdUinAdapter jdField_a_of_type_ComTencentAdTangramAnalysisAdUinAdapter = new GdtUinAdapter();
  private AdCanvasAdapter jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter = new GdtCanvasAdapter();
  private AdCanvasDownloadListenerAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter = new GdtDownloadListenerAdapter();
  private AdReportAdapter jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter = new GdtReportAdapter();
  private AdResourceAdapter jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter = new GdtResourceAdapter();
  private AdTAIDAdapter jdField_a_of_type_ComTencentAdTangramDeviceAdTAIDAdapter = new GdtTAIDAdapter();
  private AdProgressDialogAdapter jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter = new GdtProgressDialogAdapter();
  private AdDownloaderAdapter jdField_a_of_type_ComTencentAdTangramDownloaderAdDownloaderAdapter = new GdtDownloaderAdapter();
  private IAdDownloader.Callback jdField_a_of_type_ComTencentAdTangramDownloaderIAdDownloader$Callback = new GdtPreDownloadListenerAdapter();
  private AdHalfScreenAdapter jdField_a_of_type_ComTencentAdTangramHalfScreenAdHalfScreenAdapter = new GdtHalfScreenAdapter();
  private AdImageViewAdapter jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter = new GdtImageViewBuilderAdapter();
  private AdIPCManager.Adapter jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter = new GdtIPCAdapter();
  private AdLocationAdapter jdField_a_of_type_ComTencentAdTangramLbsAdLocationAdapter = new GdtLocationAdapter();
  private AdLogAdapter jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter = new GdtLogAdapter();
  private AdQQMINIProgramAdapter jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter = new GdtQQMINIProgramAdapter();
  private AdTimeAdapter jdField_a_of_type_ComTencentAdTangramNetAdTimeAdapter = new GdtTimeAdapter();
  private AdOfflineAdapter jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter = new GdtOfflineAdapter();
  private AdQQReminderAdapter jdField_a_of_type_ComTencentAdTangramPreorderAdQQReminderAdapter = new GdtQQReminderAdapter();
  private AdProcessManagerAdapter jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter = new GdtProcessManagerAdapter();
  private AdThreadManagerAdapter jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter = new GdtThreadManagerAdapter();
  private AdToastAdapter jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter = new GdtToastAdapter();
  private AdVersionAdapter jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter = new GdtVersionAdapter();
  private AdVideoCeilingAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter = new GdtVideoCeilingAdapter();
  private AdVideoSpliceAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter = new GdtVideoSpliceAdapter();
  private AdBrowserAdapter jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter = new GdtBrowserAdapter();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static GdtManager a()
  {
    if (jdField_a_of_type_ComTencentGdtadUtilGdtManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadUtilGdtManager == null) {
        jdField_a_of_type_ComTencentGdtadUtilGdtManager = new GdtManager();
      }
      return jdField_a_of_type_ComTencentGdtadUtilGdtManager;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    GdtLandingPageConfig.a().a(paramContext);
  }
  
  private void b(Context paramContext)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtManager.1(this, paramContext), 0, 1000L);
    AdConnectivityManager.getInstance().init(paramContext);
    GdtActivityLifecycleManager.a().a();
  }
  
  private void b(Context paramContext, GdtManager.Params paramParams)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter));
    AdLog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter));
    AdAnalysis.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter));
    AdProcessManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter));
    AdThreadManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter));
    AdBrowser.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter));
    AdCanvas.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter));
    AdVideoCeiling.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter));
    AdQQMINIProgram.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter));
    AdVideoSplice.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter));
    AdToast.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter));
    AdProgressDialog.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter));
    AdImageViewBuilder.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter));
    AdDownloader.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDownloaderAdDownloaderAdapter));
    AdReport.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter));
    AdResource.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter));
    AdVersion.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter));
    AdCanvasDownloadListener.setAdapter(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter);
    AdOffline.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter));
    AdHalfScreen.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramHalfScreenAdHalfScreenAdapter));
    AdTAID.getInstance().setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDeviceAdTAIDAdapter));
    AdLocationManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLbsAdLocationAdapter));
    AdBuilder.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramAdBuilderAdapter));
    AdTime.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramNetAdTimeAdapter));
    AdQQReminderManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramPreorderAdQQReminderAdapter));
    AdAppPreOrderDownloadListener.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDownloaderIAdDownloader$Callback));
    AdUin.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramAnalysisAdUinAdapter));
  }
  
  private void c(Context paramContext, GdtManager.Params paramParams)
  {
    AdSettingsUtil.INSTANCE.init(paramContext);
  }
  
  private void d(Context paramContext, GdtManager.Params paramParams)
  {
    GdtDeviceInfoHelper.a(paramContext);
  }
  
  private void e(Context paramContext, GdtManager.Params paramParams)
  {
    GdtInterstitialManager.a().a();
  }
  
  private void f(Context paramContext, GdtManager.Params paramParams)
  {
    AdExposureListHolder.getInstance().init(paramContext);
  }
  
  public AdIPCManager.Adapter a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter;
  }
  
  public void a(Context paramContext, GdtManager.Params paramParams)
  {
    GdtLog.b("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_Boolean = true;
    b(paramContext, paramParams);
    c(paramContext, paramParams);
    d(paramContext, paramParams);
    e(paramContext, paramParams);
    f(paramContext, paramParams);
    a(paramContext);
    b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtManager
 * JD-Core Version:    0.7.0.1
 */