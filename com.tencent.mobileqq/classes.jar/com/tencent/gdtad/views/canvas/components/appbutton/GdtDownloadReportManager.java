package com.tencent.gdtad.views.canvas.components.appbutton;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.canvas.AdRefreshCallback;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
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
  private static volatile GdtDownloadReportManager b;
  private final String a = "GdtDownloadReportManager";
  private GdtAd c;
  private AdAppBtnData d;
  private ConcurrentHashMap<String, GdtAd> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GdtAd> f = new ConcurrentHashMap();
  private DownloadListener g = new GdtDownloadReportManager.1(this);
  
  private GdtDownloadReportManager()
  {
    b();
  }
  
  public static GdtDownloadReportManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new GdtDownloadReportManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(String paramString)
  {
    this.e.remove(paramString);
    this.f.remove(paramString);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtAd paramGdtAd)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDownloadInfo != null)
    {
      bool1 = bool2;
      if (paramGdtAd != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramDownloadInfo.e))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramGdtAd.getAppPackageName()))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramDownloadInfo.c))
            {
              if (TextUtils.isEmpty(paramGdtAd.getAppId())) {
                return false;
              }
              bool1 = bool2;
              if (paramDownloadInfo.e.equals(paramGdtAd.getAppPackageName()))
              {
                bool1 = bool2;
                if (paramDownloadInfo.c.equals(paramGdtAd.getAppId())) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private String b(String paramString)
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
  
  private void b()
  {
    GdtLog.a("GdtDownloadReportManager", "registerDownloadListener: ");
    DownloadManagerV2.a().a(this.g);
  }
  
  public void a(GdtAd paramGdtAd, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (paramBoolean) {
        GdtTraceReporter.a(paramGdtAd, 269);
      } else {
        GdtTraceReporter.a(paramGdtAd, 268);
      }
      GdtTraceReporter.a(paramGdtAd, 272);
    }
  }
  
  public void a(String paramString, GdtAd paramGdtAd, AdAppBtnData paramAdAppBtnData)
  {
    if (TextUtils.isEmpty(paramString))
    {
      GdtLog.d("GdtDownloadReportManager", "appId isEmpty");
      return;
    }
    if (!this.e.containsKey(paramString)) {
      this.e.put(paramString, paramGdtAd);
    }
    this.d = paramAdAppBtnData;
  }
  
  public void onAdRefresh(Ad paramAd)
  {
    if ((paramAd instanceof GdtAd)) {
      this.c = ((GdtAd)paramAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager
 * JD-Core Version:    0.7.0.1
 */