package com.tencent.mobileqq.bless.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

@QAPI(process={""})
public abstract interface IBlessApi
  extends QRouteApi
{
  public abstract void clearEditingWordings(AppInterface paramAppInterface);
  
  public abstract void clearUinListToSend(AppInterface paramAppInterface);
  
  public abstract Object createShortVideoUploadInfo(Object paramObject1, Object paramObject2);
  
  public abstract int getAvailableSendCount(AppInterface paramAppInterface);
  
  public abstract int getAvailableUinCount(AppInterface paramAppInterface);
  
  public abstract String getBlessJsApiPlugin_ACTION_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_BLESS_NUM_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_BLESS_TYPE_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_CALLBACK_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_FILE_PATH_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_MD5_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_NICK_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_THUMB_PATH_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_URL_StringValue();
  
  public abstract String getBlessJsApiPlugin_PARAM_PTV_UUID_StringValue();
  
  public abstract int getBlessManager_TYPE_PIC_Value();
  
  public abstract int getBlessManager_TYPE_PTV_Value();
  
  public abstract int getBlessManager_TYPE_TEXT_Value();
  
  public abstract int getBlessManager_TYPE_UNKNOW_Value();
  
  public abstract int getBlessManager_UPDATE_MSGTAB_NUM_Value();
  
  public abstract Object getBlessReportParams(AppInterface paramAppInterface, int paramInt1, int paramInt2);
  
  public abstract void getEncodeQualityParamForSendTask(Intent paramIntent);
  
  public abstract Object getPtvMessage(AppInterface paramAppInterface);
  
  public abstract String getPtvUrlByUuid(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract int getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();
  
  public abstract int getTotalSendLimit(AppInterface paramAppInterface);
  
  public abstract int getTotalUinLimit(AppInterface paramAppInterface);
  
  public abstract ArrayList<String> getUinListToSend(AppInterface paramAppInterface);
  
  public abstract int getWebAvailableSendCount(AppInterface paramAppInterface);
  
  public abstract int getWebAvailableUinCount(AppInterface paramAppInterface);
  
  public abstract int getWebTotalSendLimit(AppInterface paramAppInterface);
  
  public abstract int getWebTotalUinLimit(AppInterface paramAppInterface);
  
  public abstract void gotoSplashActivity(Activity paramActivity, boolean paramBoolean);
  
  public abstract boolean isSearchable(AppInterface paramAppInterface);
  
  public abstract boolean isUinBlessed(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isUinListToSendChangedOnMem(AppInterface paramAppInterface);
  
  public abstract boolean isVideoSoLibLoaded();
  
  public abstract boolean isWebUinSended(AppInterface paramAppInterface, String paramString);
  
  public abstract void launchForShortVideoBusiManager(Object paramObject, AppInterface paramAppInterface);
  
  public abstract void loadShortVideoSo(AppInterface paramAppInterface);
  
  public abstract void openWebBlessActivity(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void preConnect(AppInterface paramAppInterface);
  
  public abstract void realStartEncode(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Object paramObject);
  
  public abstract void reportSendResult(AppInterface paramAppInterface, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract void saveSendWording(AppInterface paramAppInterface, String paramString);
  
  public abstract void saveUinListToSend(AppInterface paramAppInterface, List<String> paramList);
  
  public abstract void sendBlessMsg(AppInterface paramAppInterface, Object paramObject1, ArrayList<String> paramArrayList, Object paramObject2);
  
  public abstract void sendBlessTextMsg(AppInterface paramAppInterface, String paramString, ArrayList<String> paramArrayList, Object paramObject);
  
  public abstract void setCodecParam(int paramInt1, int paramInt2);
  
  public abstract void setPtvMessage(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void setUinListToSendChangedOnMen(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract boolean stopSendingShortVideo(AppInterface paramAppInterface, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bless.api.IBlessApi
 * JD-Core Version:    0.7.0.1
 */