package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Typeface;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.flutter.api.IQFlutterInstallService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HostStaticInvokeHelper
{
  private static final String TAG = "HostStaticInvokeHelper";
  
  public static void addNetwortChangedObserver(HostStaticInvokeHelper.NetworkChangedObserver paramNetworkChangedObserver)
  {
    paramNetworkChangedObserver = new HostStaticInvokeHelper.4(paramNetworkChangedObserver);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(paramNetworkChangedObserver);
  }
  
  public static String getDeviceInfoBSSID()
  {
    Object localObject = (WifiManager)MobileQQ.sMobileQQ.getSystemService("wifi");
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    localObject = null;
    if (localObject == null) {
      return null;
    }
    localObject = ((WifiInfo)localObject).getBSSID();
    if ((!"N/A".equals(localObject)) && (!"00:00:00:00:00:00".equals(localObject)))
    {
      if ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase((String)localObject)) {
        return null;
      }
      return localObject;
    }
    return null;
  }
  
  public static String[] getMimeType(String paramString)
  {
    return MimeHelper.getMimeType(paramString);
  }
  
  public static String getPluginQua()
  {
    return QUA.getQUA3();
  }
  
  public static String getQCircleSchemeFromJumpUtil(String paramString1, String paramString2)
  {
    return ((IJumpUtil)QRoute.api(IJumpUtil.class)).getCircleScheme(paramString1, paramString2);
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
    return TroopInfoUIUtil.a(paramString, "", 0);
  }
  
  public static String insertMtypeByMsfSdkUtils(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static void installQFlutter(FlutterInstallCallBack paramFlutterInstallCallBack)
  {
    if ((QCircleServiceImpl.getAppRunTime() instanceof BaseQQAppInterface)) {
      ((IQFlutterInstallService)QCircleServiceImpl.getAppRunTime().getRuntimeService(IQFlutterInstallService.class, "all")).install(new HostStaticInvokeHelper.2(paramFlutterInstallCallBack));
    }
  }
  
  public static void nativeSetMaxPhotoFrameCount(int paramInt)
  {
    VideoSourceHelper.nativeSetMaxPhotoFrameCount(paramInt);
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
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null)
    {
      if (localAppRuntime.getApp() == null) {
        return;
      }
      LoginVerifyServlet.b(localAppRuntime, new HostStaticInvokeHelper.1(paramAccountIdentityCallBack));
    }
  }
  
  public static void summitHighPriortyJob(HostStaticInvokeHelper.InvokeNormalCallBack paramInvokeNormalCallBack)
  {
    PriorityThreadPool.getDefault().submit(new HostStaticInvokeHelper.3(paramInvokeNormalCallBack), PriorityThreadPool.Priority.HIGH);
  }
  
  public static boolean validateVideoType(String paramString)
  {
    return MimeHelper.validateVideoType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper
 * JD-Core Version:    0.7.0.1
 */