package com.tencent.mobileqq.apollo.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.impl.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.api.listener.Save3DFaceListener;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameConnManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={"all"})
public abstract interface IApolloManagerService
  extends IRuntimeService
{
  public static final int MSG_TYPE_CHECK_DPC_SWITCH = 4098;
  public static final int MSG_TYPE_QUERY_APOLLO_INFO = 4096;
  public static final int MSG_TYPE_SEND_QUERY_UIN = 4097;
  
  public abstract boolean addToActionDownloadList(int paramInt);
  
  public abstract boolean addToActionPlayList(long paramLong);
  
  public abstract void addToBulkPullMap(String paramString, int paramInt);
  
  public abstract void bulkSaveOrUpdateApolloBaseInfos(List<ApolloBaseInfo> paramList);
  
  public abstract void bulkUpdateUserDress();
  
  public abstract void checkActionJsonInterval();
  
  public abstract void checkApolloPanelJsonCfg(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void clearBubble(String paramString);
  
  public abstract void decodeApolloBubblePushData(byte[] paramArrayOfByte);
  
  public abstract void downloadJson(int paramInt);
  
  public abstract void downloadResAndPanel(List<ApolloActionData> paramList, String paramString);
  
  public abstract ApolloBaseInfo getApolloBaseInfo(String paramString);
  
  public abstract ApolloBaseInfo getApolloBaseInfoFromCache(String paramString);
  
  public abstract String getApolloGameLocalVersion(int paramInt);
  
  public abstract ApolloPandora getApolloPandora(String paramString, boolean paramBoolean);
  
  public abstract ApolloPanelManager getApolloPanelManager();
  
  public abstract long getApolloResLocalTimestamp(int paramInt1, int paramInt2);
  
  public abstract int getApolloStatus(String paramString);
  
  public abstract int getApolloUserStatus(AppRuntime paramAppRuntime);
  
  public abstract BubbleProducer getBubbleProducer();
  
  public abstract CmGameAudioManager getCmGameAudioManager();
  
  public abstract CmGameConnManager getCmGameConnManager();
  
  public abstract int getCmShowStatus(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract boolean getConfigInitDone();
  
  public abstract CmGameTempSessionHandler getGameTempMsgHandler();
  
  public abstract String getPetBrandClickActionUrl(JSONObject paramJSONObject);
  
  public abstract int getPetCategory(JSONObject paramJSONObject);
  
  public abstract String getPetClickActionUrl(JSONObject paramJSONObject);
  
  public abstract String getPetId(String paramString);
  
  public abstract JSONObject getPetInfo(int paramInt);
  
  public abstract SharedPreferences getStandUpSp();
  
  public abstract int getWhiteListStatus(AppRuntime paramAppRuntime);
  
  public abstract void handleCMSPlayerGetFrame(String paramString, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback);
  
  public abstract void initApolloConfig();
  
  public abstract void initCmShowBaseScript(boolean paramBoolean);
  
  public abstract boolean is3dAvailable(QQAppInterface paramQQAppInterface);
  
  public abstract boolean is765GuideShowed();
  
  public abstract boolean is780GuideShowed();
  
  public abstract boolean isApolloFuncOpen(Context paramContext);
  
  public abstract boolean isApolloFuncOpen(Context paramContext, Boolean paramBoolean);
  
  public abstract boolean isApolloGameWhiteUser(String paramString);
  
  public abstract boolean isApolloSupport(Context paramContext);
  
  public abstract boolean isHardwareSupport(Context paramContext);
  
  public abstract boolean isInActionDownloadList(int paramInt);
  
  public abstract boolean isInActionPlayList(long paramLong);
  
  public abstract boolean isInitDone();
  
  public abstract boolean isMiniAppPlayed();
  
  public abstract boolean isPlusWhiteList();
  
  public abstract void notify3dFlagUpdate(int paramInt1, int paramInt2);
  
  public abstract void onAddOrDelGame();
  
  public abstract void onDestroy();
  
  public abstract boolean parseActionPanelJSon();
  
  public abstract void predownloadForGameCenter(String paramString);
  
  public abstract int queryApolloSwitchSet(String paramString);
  
  public abstract int queryStatusInConfig(QQAppInterface paramQQAppInterface, String paramString1, String paramString2);
  
  public abstract void removeAllS2CPushItem();
  
  public abstract boolean removeFromActionDownloadList(int paramInt);
  
  public abstract boolean removeFromActionPlayList(long paramLong);
  
  public abstract void requestTianshuAdv();
  
  public abstract void save3DFace(String paramString, Save3DFaceListener paramSave3DFaceListener);
  
  public abstract void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo);
  
  public abstract void saveOrUpdateApolloPandora(ApolloPandora paramApolloPandora);
  
  public abstract void setActionDownloadList(Collection<Integer> paramCollection);
  
  public abstract void setActionPlayList(Collection<Long> paramCollection);
  
  public abstract void setApolloEngineLockEnable(boolean paramBoolean);
  
  public abstract void setApolloGameChatPie(WeakReference<BaseChatPie> paramWeakReference);
  
  public abstract void setCapsuleHadStolenAsync(String paramString);
  
  public abstract void setClickIgnore(boolean paramBoolean);
  
  public abstract void setConfigInitDone(boolean paramBoolean);
  
  public abstract void setGetPlusStatus(boolean paramBoolean);
  
  public abstract void setNeedShowWorldCup(boolean paramBoolean);
  
  public abstract void setOpenType(int paramInt);
  
  public abstract void setUinForReload(String paramString);
  
  public abstract void setUserActionId(HashMap<Integer, Bundle> paramHashMap);
  
  public abstract void updateLastShopTabInfo(String paramString);
  
  public abstract void updateUserDress(List<ApolloBaseInfo> paramList);
  
  public abstract void updateUserFlag(int paramInt1, int paramInt2);
  
  public abstract void updateWhiteList(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloManagerService
 * JD-Core Version:    0.7.0.1
 */