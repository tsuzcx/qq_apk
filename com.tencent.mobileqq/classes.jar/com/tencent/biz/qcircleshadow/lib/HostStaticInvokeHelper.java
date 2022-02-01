package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Typeface;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.theme.TextHook;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HostStaticInvokeHelper
{
  private static final String TAG = "HostStaticInvokeHelper";
  
  public static void addNetwortChangedObserver(HostStaticInvokeHelper.NetworkChangedObserver paramNetworkChangedObserver)
  {
    paramNetworkChangedObserver = new HostStaticInvokeHelper.2(paramNetworkChangedObserver);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(paramNetworkChangedObserver);
  }
  
  public static String getDeviceInfoBSSID()
  {
    Object localObject1 = (WifiManager)MobileQQ.sMobileQQ.getSystemService("wifi");
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject1 = ((WifiManager)localObject1).getConnectionInfo();
        if (localObject1 == null) {
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        for (;;)
        {
          localObject2 = null;
        }
        String str = localObject2.getBSSID();
        if ((!"N/A".equals(str)) && (!"00:00:00:00:00:00".equals(str)))
        {
          localObject2 = str;
          if (!"FF:FF:FF:FF:FF:FF".equalsIgnoreCase(str)) {
            continue;
          }
        }
      }
    }
    return null;
  }
  
  public static String[] getMimeType(String paramString)
  {
    return MimeHelper.getMimeType(paramString);
  }
  
  public static String getPluginQua()
  {
    return QCircleShadow.a().a();
  }
  
  public static String getQCircleSchemeFromJumpUtil(String paramString1, String paramString2)
  {
    return QCircleServiceImpl.getJumpApi().getQCircleSchemeFromJumpUtil(paramString1, paramString2);
  }
  
  public static long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static Typeface getSystemDefaultFont()
  {
    return TextHook.getInstance().getSystemDefaultFont();
  }
  
  public static Bundle getTroopProfileExtra(String paramString)
  {
    return QCircleServiceImpl.getQQService().getTroopProfileExtra(paramString);
  }
  
  public static String insertMtypeByMsfSdkUtils(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static void installQFlutter(FlutterInstallCallBack paramFlutterInstallCallBack)
  {
    QCircleServiceImpl.getQQService().installQFlutter(paramFlutterInstallCallBack);
  }
  
  public static boolean isLowPerfDevice()
  {
    return DeviceInfoUtils.b();
  }
  
  public static void nativeSetMaxPhotoFrameCount(int paramInt)
  {
    QCircleServiceImpl.getQQService().nativeSetMaxPhotoFrameCount(paramInt);
  }
  
  public static void redPointHandlerSendRedpointReq(boolean paramBoolean1, boolean paramBoolean2)
  {
    IRedTouchServer localIRedTouchServer = (IRedTouchServer)QCircleServiceImpl.getAppRunTime().getRuntimeService(IRedTouchServer.class, "");
    if (localIRedTouchServer != null)
    {
      QLog.i("HostStaticInvokeHelper", 1, "redPointHandlerSendRedpointReq");
      localIRedTouchServer.sendRedpointReq(paramBoolean1, paramBoolean2, 0);
    }
  }
  
  public static void registerNetworkMonitorReceiver()
  {
    NetworkMonitorReceiver.getInstance().registerReceiver();
  }
  
  public static void sendQCircleAccountIdentityRequest(AccountIdentityCallBack paramAccountIdentityCallBack)
  {
    QCircleServiceImpl.getQQService().sendQCircleAccountIdentityRequest(paramAccountIdentityCallBack);
  }
  
  public static void summitHighPriortyJob(HostStaticInvokeHelper.InvokeNormalCallBack paramInvokeNormalCallBack)
  {
    PriorityThreadPool.getDefault().submit(new HostStaticInvokeHelper.1(paramInvokeNormalCallBack), PriorityThreadPool.Priority.HIGH);
  }
  
  public static boolean validateVideoType(String paramString)
  {
    return MimeHelper.validateVideoType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper
 * JD-Core Version:    0.7.0.1
 */