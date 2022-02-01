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
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class QQGameDownloadServiceImpl
  implements IQQGameDownloadService, WadlCmdListener
{
  private static final String TAG = "QQGameDownloadServiceImpl";
  private volatile AtomicBoolean isRelease = new AtomicBoolean(false);
  private WadlProxyServiceManager mWadlProxyServiceManager = new WadlProxyServiceManager();
  public final int quicChannelDefault = 1;
  public final int quicOff = 0;
  public final int quicOpen = 1;
  
  public QQGameDownloadServiceImpl()
  {
    WLog.c("QQGameDownloadServiceImpl", "new instance");
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  private void launchService()
  {
    this.mWadlProxyServiceManager.a(0);
  }
  
  public void deleteDownload(int paramInt, String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "deleteDownload from=" + paramInt + ",appID=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void deleteResDownload(String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "doDeleteResAction resId=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDeleteResAction");
    localBundle.putString("resId", paramString);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doAppSystemReceiver(String paramString1, String paramString2)
  {
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    WLog.c("QQGameDownloadServiceImpl", "receive system receiver cmd=" + paramString1 + ",packageName=" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", paramString1);
    localBundle.putString("packageName", paramString2);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doDownloadAction(WadlParams paramWadlParams)
  {
    WLog.c("QQGameDownloadServiceImpl", "doDownloadAction wadlParams=" + paramWadlParams);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doDownloadAction");
    localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
    localBundle.putInt("actionFrom", paramWadlParams.d);
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    if (paramWadlParams.jdField_a_of_type_Boolean)
    {
      this.mWadlProxyServiceManager.a(localBundle);
      return;
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).checkGameDownload(paramWadlParams, localBundle);
  }
  
  public void doInstallAction(WadlParams paramWadlParams)
  {
    WLog.c("QQGameDownloadServiceImpl", "doInstallAction：" + paramWadlParams);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doInstallAction");
    localBundle.putParcelable("download_wadl_params", paramWadlParams);
    localBundle.putString("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
    localBundle.putInt("actionFrom", paramWadlParams.d);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doPauseAction(int paramInt, String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "doPauseAction from=" + paramInt + ",appId=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doPauseResAction(String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "doPauseResAction resId=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doPauseResAction");
    localBundle.putString("resId", paramString);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doQueryAction(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("doQueryAction:");
    if (paramArrayList != null) {}
    for (Object localObject = paramArrayList.toString();; localObject = "empty")
    {
      WLog.c("QQGameDownloadServiceImpl", (String)localObject);
      if ((!this.isRelease.get()) && (paramArrayList != null) && (paramArrayList.size() >= 1)) {
        break;
      }
      return;
    }
    launchService();
    localObject = new Bundle();
    ((Bundle)localObject).putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryAction");
    ((Bundle)localObject).putStringArrayList("appIdLis", paramArrayList);
    this.mWadlProxyServiceManager.a((Bundle)localObject);
  }
  
  public void doQueryActionByVia(String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "doQueryActionByVia via=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doQueryActionByVia");
    localBundle.putString("via", paramString);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doQueryAllRes()
  {
    WLog.c("QQGameDownloadServiceImpl", "doQueryAllTask");
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
    WLog.c("QQGameDownloadServiceImpl", "doQueryAllTask");
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
    WLog.c("QQGameDownloadServiceImpl", "doResumeAction from=" + paramInt + ",appId=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeAction");
    localBundle.putString("appId", paramString);
    localBundle.putInt("actionFrom", paramInt);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public void doResumeResAction(String paramString)
  {
    WLog.c("QQGameDownloadServiceImpl", "doResumeResAction resId=" + paramString);
    if (this.isRelease.get()) {
      return;
    }
    launchService();
    Bundle localBundle = new Bundle();
    localBundle.putString("WADL.REMOTE_NOTIFY_CMD_NAME", "doResumeResAction");
    localBundle.putString("resId", paramString);
    this.mWadlProxyServiceManager.a(localBundle);
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12829");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    WLog.c("QQGameDownloadServiceImpl", "onCmdRsp cmd=" + paramString + ",ret=" + paramLong);
    Bundle localBundle;
    WadlParams localWadlParams;
    if ("12829".equals(paramString))
    {
      localBundle = paramIntent.getExtras();
      localWadlParams = (WadlParams)localBundle.getParcelable("download_wadl_params");
      if (localWadlParams != null) {
        break label66;
      }
    }
    for (;;)
    {
      return;
      label66:
      int m = 0;
      int n = 0;
      int k = 1;
      int j = k;
      int i = n;
      if (paramLong == 0L)
      {
        j = k;
        i = n;
        if (paramJSONObject != null) {
          i = m;
        }
      }
      try
      {
        paramIntent = paramJSONObject.optString("appid", "");
        i = m;
        paramString = paramJSONObject.optString("channel_id", "");
        i = m;
        str4 = paramJSONObject.optString("legal_url", "");
        i = m;
        str3 = paramJSONObject.optString("pkg_name", "");
        i = m;
        str2 = paramJSONObject.optString("app_name", "");
        i = m;
        str1 = paramJSONObject.optString("app_icon", "");
        i = m;
        str6 = paramJSONObject.optString("version_code");
        i = m;
        str5 = paramJSONObject.optString("sign_code", "");
        n = 0;
        i = m;
        boolean bool = TextUtils.isEmpty(str6);
        j = n;
        if (!bool) {
          i = m;
        }
      }
      catch (Throwable paramIntent)
      {
        try
        {
          String str4;
          String str3;
          String str2;
          String str1;
          String str6;
          String str5;
          j = Integer.parseInt(str6);
          i = m;
          if (!TextUtils.isEmpty(paramIntent))
          {
            label277:
            i = m;
            localWadlParams.jdField_a_of_type_JavaLangString = paramIntent;
            i = m;
            if (TextUtils.isEmpty(str4)) {
              break label592;
            }
            paramIntent = str4;
            label302:
            i = m;
            localWadlParams.jdField_e_of_type_JavaLangString = paramIntent;
            i = m;
            if (TextUtils.isEmpty(str3)) {
              break label605;
            }
            paramIntent = str3;
            label327:
            i = m;
            localWadlParams.f = paramIntent;
            if (j <= 0) {
              break label618;
            }
            label342:
            i = m;
            localWadlParams.jdField_e_of_type_Int = j;
            i = m;
            if (TextUtils.isEmpty(str2)) {
              break label632;
            }
            paramIntent = str2;
            label368:
            i = m;
            localWadlParams.j = paramIntent;
            i = m;
            if (TextUtils.isEmpty(str1)) {
              break label645;
            }
            paramIntent = str1;
            label393:
            i = m;
            localWadlParams.k = paramIntent;
            i = m;
            if (TextUtils.isEmpty(paramString)) {
              break label658;
            }
            paramIntent = paramString;
            label416:
            i = m;
            localWadlParams.c = paramIntent;
            i = m;
            localWadlParams.b = str5;
            i = m;
            j = paramJSONObject.optInt("quic_flag", 0);
            i = j;
            m = paramJSONObject.optInt("quic_channel_num", 1);
            k = m;
            i = j;
            j = k;
            label479:
            if (TextUtils.isEmpty(localWadlParams.j)) {
              localWadlParams.j = localWadlParams.f;
            }
            if (i != 1) {
              break label688;
            }
            localWadlParams.b(256);
            i = j;
            if (j < 1) {
              i = 1;
            }
            localWadlParams.i = i;
          }
          for (;;)
          {
            localBundle.putParcelable("download_wadl_params", localWadlParams);
            GameCenterSpUtils.a("WADL_SP_GROUP_APPINFO", localWadlParams.f, localWadlParams.jdField_a_of_type_JavaLangString);
            if (this.isRelease.get()) {
              break;
            }
            this.mWadlProxyServiceManager.a(localBundle);
            return;
            i = m;
            paramIntent = localWadlParams.jdField_a_of_type_JavaLangString;
            break label277;
            label592:
            i = m;
            paramIntent = localWadlParams.jdField_e_of_type_JavaLangString;
            break label302;
            label605:
            i = m;
            paramIntent = localWadlParams.f;
            break label327;
            label618:
            i = m;
            j = localWadlParams.jdField_e_of_type_Int;
            break label342;
            label632:
            i = m;
            paramIntent = localWadlParams.j;
            break label368;
            label645:
            i = m;
            paramIntent = localWadlParams.k;
            break label393;
            label658:
            i = m;
            paramIntent = localWadlParams.c;
            break label416;
            paramIntent = paramIntent;
            WLog.a("QQGameDownloadServiceImpl", "onCmdRsp checkDownload parse exception", paramIntent);
            j = k;
            break label479;
            label688:
            localWadlParams.a(256);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            j = n;
          }
        }
      }
    }
  }
  
  public void registerResCallBack(WadlResCallBack paramWadlResCallBack)
  {
    WLog.c("QQGameDownloadServiceImpl", "registerResCallBack callback=" + paramWadlResCallBack);
    if (this.isRelease.get()) {
      return;
    }
    this.mWadlProxyServiceManager.a(paramWadlResCallBack);
  }
  
  public void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    WLog.c("QQGameDownloadServiceImpl", "registerWadlServiceCallBack callback=" + paramWadlProxyServiceCallBackInterface);
    if (this.isRelease.get()) {
      return;
    }
    this.mWadlProxyServiceManager.a(paramWadlProxyServiceCallBackInterface);
  }
  
  public void release()
  {
    this.mWadlProxyServiceManager.c();
    this.isRelease.set(true);
  }
  
  public void unRegisterResCallBack(WadlResCallBack paramWadlResCallBack)
  {
    WLog.c("QQGameDownloadServiceImpl", "registerResCallBack callback=" + paramWadlResCallBack);
    this.mWadlProxyServiceManager.b(paramWadlResCallBack);
  }
  
  public void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    WLog.c("QQGameDownloadServiceImpl", "unRegisterWadlServiceCallBack callback=" + paramWadlProxyServiceCallBackInterface);
    this.mWadlProxyServiceManager.b(paramWadlProxyServiceCallBackInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */