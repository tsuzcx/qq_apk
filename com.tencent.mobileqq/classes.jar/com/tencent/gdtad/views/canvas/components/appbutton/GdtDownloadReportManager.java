package com.tencent.gdtad.views.canvas.components.appbutton;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.security.MessageDigest;
import java.util.concurrent.ConcurrentHashMap;

public class GdtDownloadReportManager
  implements AdRefreshCallback
{
  private static volatile GdtDownloadReportManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager;
  private AdAppBtnData jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasComponentsAppbuttonAdAppBtnData;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new GdtDownloadReportManager.1(this);
  private final String jdField_a_of_type_JavaLangString = "GdtDownloadReportManager";
  private ConcurrentHashMap<String, GdtAd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GdtAd> b = new ConcurrentHashMap();
  
  private GdtDownloadReportManager()
  {
    a();
  }
  
  public static GdtDownloadReportManager a()
  {
    if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager == null) {
        jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager = new GdtDownloadReportManager();
      }
      return jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    Object localObject1 = null;
    try
    {
      paramString = BaseApplicationImpl.getApplication().getApplicationContext().getPackageManager().getPackageInfo(paramString, 64).signatures;
      Object localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).update(paramString[0].toByteArray());
      localObject2 = AdHexUtil.bytes2HexString(((MessageDigest)localObject2).digest());
      paramString = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString = ((String)localObject2).toUpperCase();
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void a()
  {
    GdtLog.a("GdtDownloadReportManager", "registerDownloadListener: ");
    DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    this.b.remove(paramString);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtAd paramGdtAd)
  {
    if ((paramDownloadInfo == null) || (paramGdtAd == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramGdtAd.getAppPackageName())) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramGdtAd.getAppId()))) {}
    while ((!paramDownloadInfo.e.equals(paramGdtAd.getAppPackageName())) || (!paramDownloadInfo.c.equals(paramGdtAd.getAppId()))) {
      return false;
    }
    return true;
  }
  
  public void a(GdtAd paramGdtAd, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (!paramBoolean) {
        break label23;
      }
      GdtTraceReporter.a(paramGdtAd, 269);
    }
    for (;;)
    {
      GdtTraceReporter.a(paramGdtAd, 272);
      return;
      label23:
      GdtTraceReporter.a(paramGdtAd, 268);
    }
  }
  
  public void a(String paramString, GdtAd paramGdtAd, AdAppBtnData paramAdAppBtnData)
  {
    if (TextUtils.isEmpty(paramString))
    {
      GdtLog.d("GdtDownloadReportManager", "appId isEmpty");
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramGdtAd);
    }
    this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasComponentsAppbuttonAdAppBtnData = paramAdAppBtnData;
  }
  
  public void onAdRefresh(Ad paramAd)
  {
    if ((paramAd instanceof GdtAd)) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)paramAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager
 * JD-Core Version:    0.7.0.1
 */