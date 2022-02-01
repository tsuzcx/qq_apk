package com.tencent.biz.pubaccount.weishi_new.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.util.WSArkJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;

public class WSManagerImpl
  implements IWSManager
{
  public void enterTrendsTabWs(Context paramContext, String paramString, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent)
  {
    WeishiActivityHelper.a(paramContext, paramBoolean, paramAppInfo, paramIntent);
  }
  
  public void enterWSPublicAccount(Context paramContext, String paramString, boolean paramBoolean)
  {
    WeishiActivityHelper.a(paramContext, paramString, 0, paramBoolean);
  }
  
  public boolean enterWSVerticalPlayerPageForMiniApp(Context paramContext, HashMap<String, String> paramHashMap)
  {
    return WSMiniAppHelper.a().a(paramContext, paramHashMap);
  }
  
  public void handleArkJump(String paramString1, String paramString2)
  {
    WSArkJumpUtils.a(paramString1, paramString2);
  }
  
  public boolean isBeaconRealtimeSwitchOpen()
  {
    return WSReportEventConstants.b;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.impl.WSManagerImpl
 * JD-Core Version:    0.7.0.1
 */