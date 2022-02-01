package com.tencent.biz.pubaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountHandler
  extends QRouteApi
{
  public static final String CMD_PUBLICACCOUNT_SVC_SEND_LBS = "PubAccountSvc.ReportLbs";
  public static final String CMD_PUBLICACCOUNT_WEATHER_INFO = "QQWeatherReport.getWeatherInfo";
  public static final String KEY_AIO_TIME = "aio_time";
  public static final String KEY_LIST_TIME = "list_time";
  public static final String KEY_LOCATION_TIME = "location_time";
  public static final String KEY_LOC_LAT = "loc_lat";
  public static final String KEY_LOC_LNG = "loc_lng";
  public static final String MAIN_ACTION = "Pb_account_lifeservice";
  public static final int WEATHER_TYPE_AD = 1;
  public static final int WEATHER_TYPE_CHECK = 2;
  public static final int WEATHER_TYPE_OFFLINE = -1;
  public static final int WEATHER_TYPE_SWITCH = 4;
  public static final int WEATHER_TYPE_UNKOWN = 0;
  
  public abstract void clearPublicAccountSeq();
  
  public abstract void clearWeatherInfoListener();
  
  public abstract void getAIOHistoryMsg(String paramString, long paramLong, int paramInt);
  
  public abstract int getRecommendList(Object paramObject);
  
  public abstract int getUserFollowList();
  
  public abstract void getWeatherInfo(Context paramContext, int paramInt, IPublicAccountHandler.IWeatherInfoListener paramIWeatherInfoListener);
  
  public abstract boolean isNeedUpdate();
  
  public abstract Object newPublicAccountCheckUpdateItem();
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void onFollowPublicAccount(Object paramObject);
  
  public abstract void onReceivePushMessage(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void onUnfollowPublicAccount(Object paramObject);
  
  public abstract void reportClickPublicAccountEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void reportClickPublicAccountEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract void sendLBSInfo(String paramString1, double paramDouble1, double paramDouble2, String paramString2);
  
  public abstract void sendLocRequest(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setLocalIp(String paramString);
  
  public abstract void setNotNeedUpdate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */