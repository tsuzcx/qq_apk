package com.tencent.biz.qqcircle;

import android.app.Application;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StGPSV2;
import java.lang.ref.WeakReference;

public class QCircleGpsHelper
{
  private static volatile QCircleGpsHelper a;
  private boolean b;
  private FeedCloudMeta.StGPSV2 c;
  
  public static QCircleGpsHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleGpsHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c(SosoLbsInfo paramSosoLbsInfo)
  {
    this.b = true;
    this.c = new FeedCloudMeta.StGPSV2();
    this.c.lat.set(a(paramSosoLbsInfo));
    this.c.lon.set(b(paramSosoLbsInfo));
  }
  
  protected int a(SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      if ((QCircleApplication.isRDMVersion()) && (QCirclePluginGlobalInfo.j() != null) && (!TextUtils.isEmpty(QCirclePluginGlobalInfo.j().latitude)))
      {
        int i = Integer.parseInt(QCirclePluginGlobalInfo.j().latitude);
        return i;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLatitude exception:");
      localStringBuilder.append(localNumberFormatException.toString());
      QLog.d("QCircleGpsHelper", 1, localStringBuilder.toString());
    }
    return Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
  }
  
  public void a(QCircleGpsHelper.IGetGpsInfoListener paramIGetGpsInfoListener)
  {
    QLog.d("QCircleGpsHelper", 1, "getLocationNow");
    QCircleHostLbsHelper.startLocation(new QCircleGpsHelper.2(this, "qqcircle", true, new WeakReference(paramIGetGpsInfoListener)));
  }
  
  protected int b(SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      if ((QCircleApplication.isRDMVersion()) && (QCirclePluginGlobalInfo.j() != null) && (!TextUtils.isEmpty(QCirclePluginGlobalInfo.j().longitude)))
      {
        int i = Integer.parseInt(QCirclePluginGlobalInfo.j().longitude);
        return i;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLongitude exception:");
      localStringBuilder.append(localNumberFormatException.toString());
      QLog.d("QCircleGpsHelper", 1, localStringBuilder.toString());
    }
    return Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool;
      if (QCircleApplication.APP.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkHasGpsPermission result:");
      localStringBuilder.append(bool);
      QLog.d("QCircleGpsHelper", 1, localStringBuilder.toString());
      return bool;
    }
    return true;
  }
  
  public void c()
  {
    this.b = false;
    if (b())
    {
      SosoLbsInfo localSosoLbsInfo = QCircleHostLbsHelper.getCachedLbsInfo("qqcircle");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        c(localSosoLbsInfo);
        QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from cache");
        return;
      }
      QLog.d("QCircleGpsHelper", 1, "preGetLocation get GpsInfo from request");
      QCircleHostLbsHelper.startLocation(new QCircleGpsHelper.1(this, "qqcircle", true));
    }
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public FeedCloudMeta.StGPSV2 e()
  {
    if (this.b) {
      return this.c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGpsHelper
 * JD-Core Version:    0.7.0.1
 */