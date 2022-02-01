package com.tencent.mobileqq.apollo.persistence.api;

import com.tencent.mobileqq.apollo.model.AioPushData;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloActionTag;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.model.ApolloRecommendAction;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;

@Service(process={"all"})
public abstract interface IApolloDaoManagerService
  extends IRuntimeService
{
  public abstract void bulkSaveOrUpdateApolloActionData(List<ApolloActionData> paramList);
  
  public abstract void bulkSaveOrUpdateApolloBaseInfos(List<ApolloBaseInfo> paramList);
  
  public abstract void delFavAction(ApolloFavActionData paramApolloFavActionData);
  
  public abstract void delFavActionList(List<ApolloFavActionData> paramList);
  
  public abstract ApolloActionData findActionById(int paramInt);
  
  public abstract ApolloActionData findActionInCache(int paramInt);
  
  public abstract ApolloFavActionData findFavActionById(long paramLong);
  
  public abstract ApolloGameData findGameById(int paramInt);
  
  public abstract List<ApolloActionData> getActionByPackageId(int paramInt);
  
  public abstract List<ApolloActionTag> getActionTagList();
  
  public abstract ApolloBaseInfo getApolloBaseInfo(String paramString);
  
  public abstract ApolloBaseInfo getApolloBaseInfoFromCache(String paramString);
  
  public abstract ConcurrentHashMap<Integer, String> getApolloGameVer();
  
  public abstract ApolloPandora getApolloPandora(String paramString, boolean paramBoolean);
  
  public abstract List<ApolloBattleGameInfo> getBattleGameList(int paramInt);
  
  public abstract List<ApolloActionData> getFavActionList();
  
  public abstract List<ApolloFavActionData> getFavPackageActionList();
  
  public abstract List<ApolloActionData> getHideActionList();
  
  public abstract List<ApolloActionData> getNotFeeTypeActionList(int paramInt);
  
  public abstract List<ApolloActionPackageData> getPackageActionDataById(int paramInt);
  
  public abstract List<ApolloActionPackage> getPackageInfoBySession(int paramInt);
  
  public abstract List<ApolloRecommendAction> getRecommendList();
  
  public abstract boolean hasAioPushData(AioPushData paramAioPushData);
  
  public abstract void insertFavActionPackageData(ApolloFavActionData paramApolloFavActionData);
  
  public abstract void insertObtainedActionData(ApolloObtainedActionData paramApolloObtainedActionData);
  
  public abstract boolean isObtainActionById(int paramInt);
  
  public abstract void removeAllActionTag();
  
  public abstract void removeAllRecommendActionList();
  
  public abstract void saveActionTag(List<ApolloActionTag> paramList);
  
  public abstract void saveObtainedActionList(JSONArray paramJSONArray);
  
  public abstract void saveOrUpdateApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo);
  
  public abstract void saveOrUpdateApolloPandora(ApolloPandora paramApolloPandora);
  
  public abstract void saveRecommendActionList(List<ApolloRecommendAction> paramList);
  
  public abstract void updateBattleGameInfo(int paramInt, List<ApolloBattleGameInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService
 * JD-Core Version:    0.7.0.1
 */