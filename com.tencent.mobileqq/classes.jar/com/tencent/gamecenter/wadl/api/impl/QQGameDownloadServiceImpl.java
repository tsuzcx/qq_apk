package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQGameDownloadServiceImpl
  implements IQQGameDownloadService, WadlCmdListener
{
  private static final String TAG = "Wadl_QQGameDownloadServiceImpl";
  private volatile AtomicBoolean isRelease = new AtomicBoolean(false);
  private WadlProxyServiceManager mWadlProxyServiceManager;
  public final int quicChannelDefault = 1;
  public final int quicOff = 0;
  public final int quicOpen = 1;
  
  private void launchService()
  {
    this.mWadlProxyServiceManager.a(0);
  }
  
  public void deleteDownload(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deleteDownload from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appID=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    ((Bundle)localObject).putString("appId", paramString);
    ((Bundle)localObject).putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void deleteResDownload(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDeleteResAction resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteResAction");
    ((Bundle)localObject).putString("resId", paramString);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doAppSystemReceiver(String paramString1, String paramString2)
  {
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive system receiver cmd=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",packageName=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    ((Bundle)localObject).putString("packageName", paramString2);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doDownloadAction(WadlParams paramWadlParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadAction wadlParams=");
    ((StringBuilder)localObject).append(paramWadlParams);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    ((Bundle)localObject).putString("appId", paramWadlParams.e);
    ((Bundle)localObject).putInt("actionFrom", paramWadlParams.h);
    ((Bundle)localObject).putParcelable("download_wadl_params", paramWadlParams);
    if (paramWadlParams.b)
    {
      this.mWadlProxyServiceManager.a((Bundle)localObject);
      return;
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).checkGameDownload(paramWadlParams, (Bundle)localObject);
  }
  
  public void doInstallAction(WadlParams paramWadlParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doInstallAction：");
    ((StringBuilder)localObject).append(paramWadlParams);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    ((Bundle)localObject).putParcelable("download_wadl_params", paramWadlParams);
    ((Bundle)localObject).putString("appId", paramWadlParams.e);
    ((Bundle)localObject).putInt("actionFrom", paramWadlParams.h);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doPauseAction(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPauseAction from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    ((Bundle)localObject).putString("appId", paramString);
    ((Bundle)localObject).putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doPauseResAction(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPauseResAction resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseResAction");
    ((Bundle)localObject).putString("resId", paramString);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doQueryAction(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQueryAction:");
    Object localObject;
    if (paramArrayList != null) {
      localObject = paramArrayList.toString();
    } else {
      localObject = "empty";
    }
    localStringBuilder.append((String)localObject);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    if ((!this.isRelease.get()) && (paramArrayList != null))
    {
      if (paramArrayList.size() < 1) {
        return;
      }
      launchService();
      localObject = new Bundle();
      ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
      ((Bundle)localObject).putStringArrayList("appIdLis", paramArrayList);
      this.mWadlProxyServiceManager.a((Bundle)localObject);
    }
  }
  
  public void doQueryActionByVia(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doQueryActionByVia via=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    ((Bundle)localObject).putString("via", paramString);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doQueryAllRes()
  {
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, "doQueryAllTask");
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllRes");
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doQueryAllTask()
  {
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, "doQueryAllTask");
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAllTask");
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doResumeAction(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doResumeAction from=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",appId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    ((Bundle)localObject).putString("appId", paramString);
    ((Bundle)localObject).putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doResumeResAction(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doResumeResAction resId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeResAction");
    ((Bundle)localObject).putString("resId", paramString);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12829");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdRsp cmd=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",ret=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, ((StringBuilder)localObject).toString());
    Bundle localBundle;
    WadlParams localWadlParams;
    if ("12829".equals(paramString))
    {
      localBundle = paramIntent.getExtras();
      localWadlParams = (WadlParams)localBundle.getParcelable("download_wadl_params");
      if (localWadlParams == null) {
        return;
      }
      j = 0;
      k = 0;
      i = j;
      if (paramLong == 0L)
      {
        i = j;
        if (paramJSONObject != null)
        {
          i = k;
          try
          {
            paramIntent = paramJSONObject.optString("appid", "");
            i = k;
            paramString = paramJSONObject.optString("channel_id", "");
            i = k;
            str3 = paramJSONObject.optString("legal_url", "");
            i = k;
            str2 = paramJSONObject.optString("pkg_name", "");
            i = k;
            str1 = paramJSONObject.optString("app_name", "");
            i = k;
            localObject = paramJSONObject.optString("app_icon", "");
            i = k;
            str5 = paramJSONObject.optString("version_code");
            i = k;
            str4 = paramJSONObject.optString("sign_code", "");
            i = k;
            boolean bool = TextUtils.isEmpty(str5);
            if (!bool) {
              i = k;
            }
          }
          catch (Throwable paramIntent)
          {
            String str3;
            String str2;
            String str1;
            String str5;
            String str4;
            label261:
            QLog.e("Wadl_QQGameDownloadServiceImpl", 1, "onCmdRsp checkDownload parse exception", paramIntent);
          }
        }
      }
    }
    try
    {
      j = Integer.parseInt(str5);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label261;
    }
    int j = 0;
    int i = k;
    if (TextUtils.isEmpty(paramIntent))
    {
      i = k;
      paramIntent = localWadlParams.e;
    }
    i = k;
    localWadlParams.e = paramIntent;
    i = k;
    if (!TextUtils.isEmpty(str3))
    {
      paramIntent = str3;
    }
    else
    {
      i = k;
      paramIntent = localWadlParams.k;
    }
    i = k;
    localWadlParams.k = paramIntent;
    i = k;
    if (!TextUtils.isEmpty(str2))
    {
      paramIntent = str2;
    }
    else
    {
      i = k;
      paramIntent = localWadlParams.m;
    }
    i = k;
    localWadlParams.m = paramIntent;
    if (j <= 0)
    {
      i = k;
      j = localWadlParams.l;
    }
    i = k;
    localWadlParams.l = j;
    i = k;
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = str1;
    }
    else
    {
      i = k;
      paramIntent = localWadlParams.u;
    }
    i = k;
    localWadlParams.u = paramIntent;
    i = k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramIntent = (Intent)localObject;
    }
    else
    {
      i = k;
      paramIntent = localWadlParams.v;
    }
    i = k;
    localWadlParams.v = paramIntent;
    i = k;
    if (!TextUtils.isEmpty(paramString))
    {
      paramIntent = paramString;
    }
    else
    {
      i = k;
      paramIntent = localWadlParams.i;
    }
    i = k;
    localWadlParams.i = paramIntent;
    i = k;
    localWadlParams.f = str4;
    i = k;
    j = paramJSONObject.optInt("quic_flag", 0);
    i = j;
    int k = paramJSONObject.optInt("quic_channel_num", 1);
    i = k;
    break label586;
    k = 1;
    j = i;
    i = k;
    label586:
    if (TextUtils.isEmpty(localWadlParams.u)) {
      localWadlParams.u = localWadlParams.m;
    }
    k = 1;
    if (j == 1)
    {
      localWadlParams.c(256);
      if (i < 1) {
        i = k;
      }
      localWadlParams.D = i;
    }
    else
    {
      localWadlParams.b(256);
    }
    localBundle.putParcelable("download_wadl_params", localWadlParams);
    GameCenterSpUtils.a("WADL_SP_GROUP_APPINFO", localWadlParams.m, localWadlParams.e);
    if (!this.isRelease.get()) {
      this.mWadlProxyServiceManager.a(localBundle);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate appRuntime=");
    localStringBuilder.append(paramAppRuntime);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    this.mWadlProxyServiceManager = new WadlProxyServiceManager();
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  public void onDestroy()
  {
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, "onDestroy");
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
    this.mWadlProxyServiceManager.d();
    this.isRelease.set(true);
  }
  
  public void registerResCallBack(WadlResCallBack paramWadlResCallBack)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerResCallBack callback=");
    localStringBuilder.append(paramWadlResCallBack);
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    if (this.isRelease.get()) {
      return;
    }
    this.mWadlProxyServiceManager.a(paramWadlResCallBack);
  }
  
  public void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerWadlServiceCallBack callback=");
    localStringBuilder.append(paramWadlProxyServiceCallBackInterface);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    if (this.isRelease.get()) {
      return;
    }
    this.mWadlProxyServiceManager.a(paramWadlProxyServiceCallBackInterface);
  }
  
  public void unRegisterResCallBack(WadlResCallBack paramWadlResCallBack)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerResCallBack callback=");
    localStringBuilder.append(paramWadlResCallBack);
    QLog.i("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    this.mWadlProxyServiceManager.b(paramWadlResCallBack);
  }
  
  public void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterWadlServiceCallBack callback=");
    localStringBuilder.append(paramWadlProxyServiceCallBackInterface);
    QLog.d("Wadl_QQGameDownloadServiceImpl", 1, localStringBuilder.toString());
    this.mWadlProxyServiceManager.b(paramWadlProxyServiceCallBackInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */