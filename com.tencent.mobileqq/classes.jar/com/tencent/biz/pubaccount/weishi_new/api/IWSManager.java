package com.tencent.biz.pubaccount.weishi_new.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IWSManager
  extends QRouteApi
{
  public static final String IPC_MODULE_NAME = "WSIPCModule";
  
  public abstract void doAfterSyncMsg();
  
  public abstract boolean doJumpAction(String paramString, Context paramContext, Map<String, String> paramMap, Object paramObject);
  
  public abstract void enterTrendsTabWs(Context paramContext, String paramString, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent);
  
  public abstract boolean enterWSOperationH5(Context paramContext, HashMap<String, String> paramHashMap);
  
  public abstract void enterWSPublicAccount(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract boolean enterWSVerticalPlayerPageForMiniApp(Context paramContext, HashMap<String, String> paramHashMap);
  
  public abstract QIPCModule getIPCModule();
  
  public abstract void handleArkJump(String paramString1, String paramString2);
  
  public abstract boolean isBeaconRealtimeSwitchOpen();
  
  public abstract boolean isFastClick();
  
  public abstract void openWeishi(Context paramContext, String paramString1, String paramString2);
  
  public abstract void preloadData();
  
  public abstract void setBeaconRealtimeSwitchOpen(boolean paramBoolean);
  
  public abstract void setWeishiLastFeedId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.IWSManager
 * JD-Core Version:    0.7.0.1
 */