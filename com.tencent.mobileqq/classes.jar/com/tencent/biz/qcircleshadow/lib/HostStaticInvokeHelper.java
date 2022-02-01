package com.tencent.biz.qcircleshadow.lib;

import amsw;
import amzu;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import atjn;
import bbon;
import bnxs;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.AppRuntime;

public class HostStaticInvokeHelper
{
  private static final String TAG = "HostStaticInvokeHelper";
  
  public static void addNetwortChangedObserver(HostStaticInvokeHelper.NetworkChangedObserver paramNetworkChangedObserver)
  {
    paramNetworkChangedObserver = new HostStaticInvokeHelper.4(paramNetworkChangedObserver);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(paramNetworkChangedObserver);
  }
  
  private static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof AppInterface)) {
        return (AppInterface)localObject;
      }
    }
    return null;
  }
  
  public static String getNickName(String paramString)
  {
    Friends localFriends = ((amsw)getAppInterface().getManager(51)).e(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (!TextUtils.isEmpty(localFriends.getFriendNick())) {
        str = localFriends.getFriendNick();
      }
    }
    return str;
  }
  
  public static String getQCircleSchemeFromJumpUtil(String paramString1, String paramString2)
  {
    return bnxs.a(paramString1, paramString2);
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
    return TroopInfoActivity.a(paramString, 0);
  }
  
  public static String insertMtypeByMsfSdkUtils(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static void installQFlutter(HostStaticInvokeHelper.FlutterInstallCallBack paramFlutterInstallCallBack)
  {
    try
    {
      QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
      if (localQQAppInterface == null) {
        return;
      }
      atjn.a(localQQAppInterface, new HostStaticInvokeHelper.2(paramFlutterInstallCallBack));
      return;
    }
    catch (Exception paramFlutterInstallCallBack)
    {
      QLog.e("HostStaticInvokeHelper", 1, "[preloadFlutter] ", paramFlutterInstallCallBack);
    }
  }
  
  public static void redPointHandlerSendRedpointReq(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getAppInterface();
    if (localObject != null)
    {
      localObject = (amzu)((AppInterface)localObject).getBusinessHandler(87);
      if (localObject != null)
      {
        QLog.i("HostStaticInvokeHelper", 1, "redPointHandlerSendRedpointReq");
        ((amzu)localObject).a(paramBoolean1, paramBoolean2, 0);
      }
    }
  }
  
  public static void registerNetworkMonitorReceiver()
  {
    NetworkMonitorReceiver.getInstance().registerReceiver();
  }
  
  public static void sendQCircleAccountIdentityRequest(HostStaticInvokeHelper.AccountIdentityCallBack paramAccountIdentityCallBack)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bbon.b((QQAppInterface)localAppRuntime, new HostStaticInvokeHelper.1(paramAccountIdentityCallBack));
    }
  }
  
  public static void summitHighPriortyJob(HostStaticInvokeHelper.InvokeNormalCallBack paramInvokeNormalCallBack)
  {
    PriorityThreadPool.getDefault().submit(new HostStaticInvokeHelper.3(paramInvokeNormalCallBack), PriorityThreadPool.Priority.HIGH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper
 * JD-Core Version:    0.7.0.1
 */