package com.tencent.mobileqq.apollo.api.uitls;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.widget.AnimationTextView;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IApolloUtil
  extends QRouteApi
{
  public abstract void addDebugMenu(View paramView, QQAppInterface paramQQAppInterface, QQCustomMenu paramQQCustomMenu);
  
  public abstract void checkApolloUrl(DownloadTask paramDownloadTask);
  
  public abstract boolean checkPreloadOnSettingMe(QQAppInterface paramQQAppInterface, View paramView);
  
  public abstract void checkWrapApolloDownload(DownloadTask paramDownloadTask);
  
  public abstract String checkWrapApolloUrl(String paramString);
  
  public abstract void deleteApolloResource(boolean paramBoolean, QQAppInterface paramQQAppInterface);
  
  public abstract String getApolloDescMsg(MessageForApollo paramMessageForApollo);
  
  public abstract String getApolloImageUrl(String paramString);
  
  public abstract int getApolloPanelJsonVer(int paramInt);
  
  public abstract AppRuntime getAppInterface();
  
  public abstract String getBoxFloatUrl(int paramInt1, int paramInt2);
  
  public abstract URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2);
  
  public abstract URLDrawable getDrawable(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean);
  
  public abstract URLDrawable getDrawable(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2);
  
  public abstract URLDrawable getDrawable(boolean paramBoolean1, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2, boolean paramBoolean2);
  
  public abstract int getJsonIntValue(String paramString1, String paramString2);
  
  public abstract String getMsgTranDec(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo);
  
  public abstract QQAppInterface getQQApp();
  
  public abstract int getReportSessionTypeByContext(SessionInfo paramSessionInfo, AppInterface paramAppInterface);
  
  public abstract int getReportSessiontype(int paramInt);
  
  public abstract int getReportUserResult(int paramInt);
  
  public abstract String getStoreTabUrl(String paramString, boolean paramBoolean);
  
  public abstract int getTraceDownloadErrCode(int paramInt);
  
  public abstract void importDebugFile(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface);
  
  public abstract boolean isApolloProxyEnable();
  
  public abstract boolean isFemale(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void onEmoticonNewIconShown(int paramInt);
  
  public abstract void onNewEmoticonClick(int paramInt);
  
  public abstract void onPopupGuideShown();
  
  public abstract void openApolloGameCenter(Context paramContext);
  
  public abstract void openApolloGameCity(Context paramContext, int paramInt, Intent paramIntent);
  
  public abstract void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface);
  
  public abstract void openApolloStore(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt);
  
  public abstract void openWebViewActivity(Context paramContext, String paramString);
  
  public abstract void playApolloEmoticonAction(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, AnimationTextView paramAnimationTextView, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void playShareMsgAction(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, int paramInt1, int paramInt2);
  
  public abstract void replaceCmshow3dResource(String paramString);
  
  public abstract void reportCrash(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void reportTraceResourceSpanDesc(String paramString);
  
  public abstract void setApolloProxyEnable(boolean paramBoolean);
  
  public abstract void setReaded(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt);
  
  public abstract boolean shouldShowNewIcon(int paramInt);
  
  public abstract boolean shouldShowPopupGuide();
  
  public abstract String wrapLogUin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.IApolloUtil
 * JD-Core Version:    0.7.0.1
 */