package com.tencent.gdtad.util;

import android.content.Context;
import com.tencent.ad.tangram.AdBuilder;
import com.tencent.ad.tangram.AdBuilderAdapter;
import com.tencent.ad.tangram.AdManagerForQQ;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.analysis.AdUinAdapter;
import com.tencent.ad.tangram.device.AdDeviceInfoV2;
import com.tencent.ad.tangram.device.AdDeviceInfoV2Adapter;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapter;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
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
import com.tencent.ad.tangram.statistics.canvas.AdReport;
import com.tencent.ad.tangram.statistics.canvas.AdReportAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.video.AdVideo;
import com.tencent.ad.tangram.video.AdVideoAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.views.AdUISettings;
import com.tencent.ad.tangram.views.AdUISettingsAdapter;
import com.tencent.ad.tangram.views.canvas.AdCanvas;
import com.tencent.ad.tangram.views.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.gdtad.adapter.GdtActivityLifecycleManager;
import com.tencent.gdtad.adapter.GdtAdBuilderAdapter;
import com.tencent.gdtad.adapter.GdtBrowserAdapter;
import com.tencent.gdtad.adapter.GdtCanvasAdapter;
import com.tencent.gdtad.adapter.GdtDeviceInfoV2Adapter;
import com.tencent.gdtad.adapter.GdtDownloadListenerAdapter;
import com.tencent.gdtad.adapter.GdtDownloaderAdapter;
import com.tencent.gdtad.adapter.GdtDownloaderAdapterV2;
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
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter;
import com.tencent.gdtad.adapter.GdtTimeAdapter;
import com.tencent.gdtad.adapter.GdtToastAdapter;
import com.tencent.gdtad.adapter.GdtUISettingsAdapter;
import com.tencent.gdtad.adapter.GdtUinAdapter;
import com.tencent.gdtad.adapter.GdtVersionAdapter;
import com.tencent.gdtad.adapter.GdtVideoAdapter;
import com.tencent.gdtad.adapter.GdtVideoCeilingAdapter;
import com.tencent.gdtad.adapter.GdtVideoSpliceAdapter;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.web.GdtLandingPageConfig;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

public final class GdtManager
{
  private static volatile GdtManager a;
  private AdUinAdapter A = new GdtUinAdapter();
  private AdDownloaderAdapterV2 B = new GdtDownloaderAdapterV2();
  private AdDeviceInfoV2Adapter C = new GdtDeviceInfoV2Adapter();
  private AdUISettingsAdapter D = new GdtUISettingsAdapter();
  private AdVideoAdapter E = new GdtVideoAdapter();
  private volatile boolean b = false;
  private AdIPCManager.Adapter c = new GdtIPCAdapter();
  private AdLogAdapter d = new GdtLogAdapter();
  private AdProcessManagerAdapter e = new GdtProcessManagerAdapter();
  private AdThreadManagerAdapter f = new GdtThreadManagerAdapter();
  private AdBrowserAdapter g = new GdtBrowserAdapter();
  private AdCanvasAdapter h = new GdtCanvasAdapter();
  private AdVideoCeilingAdapter i = new GdtVideoCeilingAdapter();
  private AdQQMINIProgramAdapter j = new GdtQQMINIProgramAdapter();
  private AdVideoSpliceAdapter k = new GdtVideoSpliceAdapter();
  private AdToastAdapter l = new GdtToastAdapter();
  private AdProgressDialogAdapter m = new GdtProgressDialogAdapter();
  private AdImageViewAdapter n = new GdtImageViewBuilderAdapter();
  private AdDownloaderAdapter o = new GdtDownloaderAdapter();
  private AdReportAdapter p = new GdtReportAdapter();
  private AdVersionAdapter q = new GdtVersionAdapter();
  private AdCanvasDownloadListenerAdapter r = new GdtDownloadListenerAdapter();
  private AdOfflineAdapter s = new GdtOfflineAdapter();
  private AdHalfScreenAdapter t = new GdtHalfScreenAdapter();
  private AdTAIDAdapter u = new GdtTAIDAdapter();
  private AdLocationAdapter v = new GdtLocationAdapter();
  private AdBuilderAdapter w = new GdtAdBuilderAdapter();
  private AdTimeAdapter x = new GdtTimeAdapter();
  private AdQQReminderAdapter y = new GdtQQReminderAdapter();
  private IAdDownloader.Callback z = new GdtPreDownloadListenerAdapter();
  
  public static GdtManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Context paramContext)
  {
    GdtLandingPageConfig.a().a(paramContext);
  }
  
  private void b(Context paramContext)
  {
    AdThreadManager.INSTANCE.postDelayed(new GdtManager.1(this, paramContext), 0, 1000L);
    AdConnectivityManager.getInstance().init(paramContext);
    GdtActivityLifecycleManager.a().b();
  }
  
  private void b(Context paramContext, GdtManager.Params paramParams)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(this.c));
    AdLog.setAdapter(new WeakReference(this.d));
    AdProcessManager.INSTANCE.setAdapter(new WeakReference(this.e));
    AdThreadManager.INSTANCE.setAdapter(new WeakReference(this.f));
    AdBrowser.setAdapter(new WeakReference(this.g));
    AdCanvas.setAdapter(new WeakReference(this.h));
    AdVideoCeiling.setAdapter(new WeakReference(this.i));
    AdQQMINIProgram.setAdapter(new WeakReference(this.j));
    AdVideoSplice.setAdapter(new WeakReference(this.k));
    AdToast.setAdapter(new WeakReference(this.l));
    AdProgressDialog.INSTANCE.setAdapter(new WeakReference(this.m));
    AdImageViewBuilder.setAdapter(new WeakReference(this.n));
    AdDownloader.setAdapter(new WeakReference(this.o));
    AdReport.setAdapter(new WeakReference(this.p));
    AdVersion.INSTANCE.setAdapter(new WeakReference(this.q));
    AdCanvasDownloadListener.setAdapter(this.r);
    AdOffline.INSTANCE.setAdapter(new WeakReference(this.s));
    AdHalfScreen.setAdapter(new WeakReference(this.t));
    AdTAID.getInstance().setAdapter(new WeakReference(this.u));
    AdLocationManager.INSTANCE.setAdapter(new WeakReference(this.v));
    AdBuilder.INSTANCE.setAdapter(new WeakReference(this.w));
    AdTime.INSTANCE.setAdapter(new WeakReference(this.x));
    AdQQReminderManager.INSTANCE.setAdapter(new WeakReference(this.y));
    AdAppPreOrderDownloadListener.setAdapter(new WeakReference(this.z));
    AdUin.INSTANCE.setAdapter(new WeakReference(this.A));
    AdDownloaderV2.INSTANCE.setAdapter(new WeakReference(this.B));
    AdDeviceInfoV2.getInstance().setAdapter(new WeakReference(this.C));
    AdUISettings.INSTANCE.setAdapter(new WeakReference(this.D));
    AdVideo.INSTANCE.setAdapter(new WeakReference(this.E));
  }
  
  private void c(Context paramContext, GdtManager.Params paramParams)
  {
    GdtDeviceInfoHelper.a(paramContext);
  }
  
  private void d(Context paramContext, GdtManager.Params paramParams)
  {
    ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).init(paramContext);
  }
  
  private void e(Context paramContext, GdtManager.Params paramParams)
  {
    AdExposureListHolder.getInstance().init(paramContext);
  }
  
  @Deprecated
  public void a(Context paramContext, GdtManager.Params paramParams)
  {
    GdtLog.b("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.b) }));
    if (this.b) {
      return;
    }
    try
    {
      if (this.b) {
        return;
      }
      this.b = true;
      b(paramContext, paramParams);
      AdManagerForQQ.INSTANCE.init(new WeakReference(paramContext));
      c(paramContext, paramParams);
      d(paramContext, paramParams);
      e(paramContext, paramParams);
      a(paramContext);
      b(paramContext);
      return;
    }
    finally {}
  }
  
  public AdIPCManager.Adapter b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtManager
 * JD-Core Version:    0.7.0.1
 */