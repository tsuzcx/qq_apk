package com.tencent.biz.pubaccount.weishi_new.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IWSManager
  extends QRouteApi
{
  public abstract void enterTrendsTabWs(Context paramContext, String paramString, boolean paramBoolean, BusinessInfoCheckUpdate.AppInfo paramAppInfo, Intent paramIntent);
  
  public abstract void enterWSPublicAccount(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract boolean enterWSVerticalPlayerPageForMiniApp(Context paramContext, HashMap<String, String> paramHashMap);
  
  public abstract void handleArkJump(String paramString1, String paramString2);
  
  public abstract boolean isBeaconRealtimeSwitchOpen();
  
  public abstract void openWeishi(Context paramContext, String paramString1, String paramString2);
  
  public abstract void preloadData();
  
  public abstract void setBeaconRealtimeSwitchOpen(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.IWSManager
 * JD-Core Version:    0.7.0.1
 */