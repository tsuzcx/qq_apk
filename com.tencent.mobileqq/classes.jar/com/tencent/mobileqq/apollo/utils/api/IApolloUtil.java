package com.tencent.mobileqq.apollo.utils.api;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadTask;
import javax.net.ssl.SSLContext;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IApolloUtil
  extends QRouteApi
{
  public static final String APOLLO_JSON_PATH = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json";
  
  public abstract void checkApolloUrl(DownloadTask paramDownloadTask);
  
  public abstract boolean checkPreloadOnSettingMe(AppRuntime paramAppRuntime, View paramView);
  
  public abstract void checkWrapApolloDownload(DownloadTask paramDownloadTask);
  
  public abstract String checkWrapApolloUrl(String paramString);
  
  public abstract void deleteApolloResource(boolean paramBoolean, AppRuntime paramAppRuntime);
  
  public abstract String getApolloImageUrl(String paramString);
  
  public abstract int getApolloPanelJsonVer(int paramInt);
  
  public abstract AppRuntime getAppInterface();
  
  public abstract String getBoxFloatUrl(int paramInt1, int paramInt2);
  
  public abstract URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2);
  
  public abstract URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean);
  
  public abstract URLDrawable getDrawable(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2);
  
  public abstract URLDrawable getDrawable(boolean paramBoolean1, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean2);
  
  public abstract String getEmoticonPanelFromEntrance();
  
  public abstract int getJsonIntValue(String paramString1, String paramString2);
  
  public abstract int getReportSessionType(int paramInt);
  
  public abstract int getReportUserResult(int paramInt);
  
  public abstract SSLContext getSLLContext();
  
  public abstract String getStoreTabUrl(String paramString, boolean paramBoolean);
  
  public abstract int getTraceDownloadErrCode(int paramInt);
  
  public abstract boolean isApolloProxyEnable();
  
  public abstract boolean isFemale(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void onEmoticonNewIconShown(int paramInt);
  
  public abstract void onNewEmoticonClick(int paramInt);
  
  public abstract void onPopupGuideShown();
  
  public abstract void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface);
  
  public abstract void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt);
  
  public abstract void openWebViewActivity(Context paramContext, String paramString);
  
  public abstract void playApolloEmoticonAction(AppRuntime paramAppRuntime, Object paramObject, MessageRecord paramMessageRecord, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void playShareMsgAction(AppRuntime paramAppRuntime, Object paramObject, MessageRecord paramMessageRecord, int paramInt1, int paramInt2);
  
  public abstract void replaceCmshow3dResource(String paramString);
  
  public abstract void reportCrash(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void reportTraceResourceSpanDesc(String paramString);
  
  public abstract void setApolloProxyEnable(boolean paramBoolean);
  
  public abstract boolean shouldShowNewIcon(int paramInt);
  
  public abstract boolean shouldShowPopupGuide();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloUtil
 * JD-Core Version:    0.7.0.1
 */