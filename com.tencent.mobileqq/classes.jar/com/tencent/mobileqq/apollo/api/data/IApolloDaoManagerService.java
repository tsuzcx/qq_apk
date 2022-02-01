package com.tencent.mobileqq.apollo.api.data;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRankData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRoamData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameScoreData;
import com.tencent.mobileqq.apollo.api.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloRecommendAction;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.IApolloTagActionDataListener;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.IApolloTagDataListener;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionTag;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;

@Service(process={"all"})
public abstract interface IApolloDaoManagerService
  extends IRuntimeService
{
  public abstract void bulkSaveOrUpdateApolloActionData(List<ApolloActionData> paramList);
  
  public abstract void delFavAction(ApolloFavActionData paramApolloFavActionData);
  
  public abstract void delFavActionList(List<ApolloFavActionData> paramList);
  
  public abstract ApolloActionData findActionById(int paramInt);
  
  public abstract ApolloActionData findActionInCache(int paramInt);
  
  public abstract ApolloFavActionData findFavActionById(long paramLong);
  
  public abstract ApolloGameData findGameById(int paramInt);
  
  public abstract List<ApolloActionData> getActionByPackageId(int paramInt);
  
  public abstract void getActionIdListByPkgIdAndTagName(int paramInt, String paramString, ApolloTagActionViewBinder.IApolloTagActionDataListener paramIApolloTagActionDataListener);
  
  public abstract List<ApolloActionTag> getActionTagList();
  
  public abstract ConcurrentHashMap<Integer, String> getApolloGameVer();
  
  public abstract List<ApolloBattleGameInfo> getBattleGameList(int paramInt);
  
  public abstract List<ApolloActionData> getFavActionList();
  
  public abstract List<ApolloFavActionData> getFavPackageActionList();
  
  public abstract List<ApolloActionData> getHideActionList();
  
  public abstract List<ApolloActionData> getNotFeeTypeActionList(int paramInt);
  
  public abstract List<ApolloActionPackageData> getPackageActionDataById(int paramInt);
  
  public abstract List<ApolloActionPackage> getPackageInfoBySession(SessionInfo paramSessionInfo);
  
  public abstract List<ApolloGameRankData> getRankData(int paramInt);
  
  public abstract List<ApolloRecommendAction> getRecommendList();
  
  public abstract void getTagListByPkgId(int paramInt, ApolloTagActionViewBinder.IApolloTagDataListener paramIApolloTagDataListener);
  
  public abstract boolean hasAioPushData(AioPushData paramAioPushData);
  
  public abstract void insertFavActionPackageData(ApolloFavActionData paramApolloFavActionData);
  
  public abstract void insertObtainedActionData(ApolloObtainedActionData paramApolloObtainedActionData);
  
  public abstract boolean isObtainActionById(int paramInt);
  
  public abstract void removeAllActionTag();
  
  public abstract void removeAllGameRoamData();
  
  public abstract void removeAllRecommendActionList();
  
  public abstract void saveActionTag(List<ApolloActionTag> paramList);
  
  public abstract void saveGameRoamData(ArrayList<ApolloGameRoamData> paramArrayList);
  
  public abstract void saveObtainedActionList(JSONArray paramJSONArray);
  
  public abstract void saveRecommendActionList(List<ApolloRecommendAction> paramList);
  
  public abstract void updateBattleGameInfo(int paramInt, List<ApolloBattleGameInfo> paramList);
  
  public abstract void updateGameRank(EntityManager paramEntityManager, List<ApolloGameRankData> paramList);
  
  public abstract void updateGameScore(EntityManager paramEntityManager, List<ApolloGameScoreData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService
 * JD-Core Version:    0.7.0.1
 */