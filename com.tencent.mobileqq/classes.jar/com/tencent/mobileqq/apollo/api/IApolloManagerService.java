package com.tencent.mobileqq.apollo.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Collection;
import java.util.HashMap;
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
  
  public abstract void bulkUpdateUserDress();
  
  public abstract void checkActionJsonInterval();
  
  public abstract void decodeApolloBubblePushData(byte[] paramArrayOfByte);
  
  @Deprecated
  public abstract ApolloBaseInfo getApolloBaseInfo(String paramString);
  
  public abstract int getApolloStatus(String paramString);
  
  public abstract int getApolloUserStatus();
  
  public abstract int getCmShowStatus(String paramString);
  
  public abstract boolean getConfigInitDone();
  
  public abstract String getPetBrandClickActionUrl(JSONObject paramJSONObject);
  
  public abstract int getPetCategory(JSONObject paramJSONObject);
  
  public abstract String getPetClickActionUrl(JSONObject paramJSONObject);
  
  public abstract String getPetId(String paramString);
  
  public abstract JSONObject getPetInfo(int paramInt);
  
  public abstract SharedPreferences getStandUpSp();
  
  public abstract String getTabActionAvatar();
  
  public abstract int getWhiteListStatus();
  
  public abstract void initApolloConfig();
  
  public abstract void initCmShowBaseScript(boolean paramBoolean);
  
  public abstract boolean is3dAvailable();
  
  public abstract boolean isApolloSupport(Context paramContext);
  
  public abstract boolean isApolloSupport(Context paramContext, Boolean paramBoolean);
  
  public abstract boolean isHardwareSupport(Context paramContext);
  
  public abstract boolean isInActionDownloadList(int paramInt);
  
  public abstract boolean isInActionPlayList(long paramLong);
  
  public abstract boolean isInitDone();
  
  public abstract void notify3dFlagUpdate(int paramInt1, int paramInt2);
  
  public abstract void onDestroy();
  
  public abstract int queryApolloSwitchSet(String paramString);
  
  public abstract int queryStatusInConfig(String paramString1, String paramString2);
  
  public abstract boolean removeFromActionDownloadList(int paramInt);
  
  public abstract boolean removeFromActionPlayList(long paramLong);
  
  public abstract void requestTianshuAdv();
  
  @Deprecated
  public abstract void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo);
  
  public abstract void sendActionMessage(BaseAIOContext paramBaseAIOContext, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  
  public abstract void setActionDownloadList(Collection<Integer> paramCollection);
  
  public abstract void setActionPlayList(Collection<Long> paramCollection);
  
  public abstract void setApolloEngineLockEnable(boolean paramBoolean);
  
  public abstract void setConfigInitDone(boolean paramBoolean);
  
  public abstract void setOpenType(int paramInt);
  
  public abstract void setUinForReload(String paramString);
  
  public abstract void setUserActionId(HashMap<Integer, Bundle> paramHashMap);
  
  public abstract void updateLastShopTabInfo(String paramString);
  
  public abstract void updateUserFlag(int paramInt1, int paramInt2);
  
  public abstract void updateWhiteList(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloManagerService
 * JD-Core Version:    0.7.0.1
 */