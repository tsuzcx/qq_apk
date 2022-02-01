package com.tencent.biz.pubaccount.weishi_new.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.WSPublicAccLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager;
import com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCModule;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.util.WSArkJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.AbsWSJumpAction;
import com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSJumpActionFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;
import java.util.Map;

public class WSManagerImpl
  implements IWSManager
{
  public void doAfterSyncMsg()
  {
    WSExpPolicyManager.a().a();
  }
  
  public boolean doJumpAction(String paramString, Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    paramString = WSJumpActionFactory.a(paramString);
    if (paramString != null) {
      return paramString.b(paramContext, paramMap, paramObject);
    }
    return false;
  }
  
  public void enterTrendsTabWs(Context paramContext, String paramString, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    WeishiActivityHelper.a(paramContext, paramString, paramBoolean, paramAppInfo, paramIntent);
  }
  
  public boolean enterWSOperationH5(Context paramContext, HashMap<String, String> paramHashMap)
  {
    return WeishiActivityHelper.a(paramContext, paramHashMap);
  }
  
  public void enterWSPublicAccount(Context paramContext, String paramString, boolean paramBoolean)
  {
    WeishiActivityHelper.a(paramContext, new WSPublicAccLaunchParams(paramString, 0, paramBoolean));
  }
  
  public boolean enterWSVerticalPlayerPageForMiniApp(Context paramContext, HashMap<String, String> paramHashMap)
  {
    return WSMiniAppHelper.a().a(paramContext, paramHashMap);
  }
  
  public QIPCModule getIPCModule()
  {
    return WSIPCModule.a();
  }
  
  public void handleArkJump(String paramString1, String paramString2)
  {
    WSArkJumpUtils.a(paramString1, paramString2);
  }
  
  public boolean isBeaconRealtimeSwitchOpen()
  {
    return WSReportEventConstants.b;
  }
  
  public boolean isFastClick()
  {
    return WeishiUtils.c();
  }
  
  public void openWeishi(Context paramContext, String paramString1, String paramString2)
  {
    WeishiScehmeUtil.a(paramContext, paramString1, paramString2);
  }
  
  public void preloadData()
  {
    WSRedDotPreloadManager.a().c();
  }
  
  public void setBeaconRealtimeSwitchOpen(boolean paramBoolean)
  {
    WSReportEventConstants.b = paramBoolean;
  }
  
  public void setWeishiLastFeedId(String paramString)
  {
    WeishiUtils.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.impl.WSManagerImpl
 * JD-Core Version:    0.7.0.1
 */