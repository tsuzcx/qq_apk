package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxUtil;
import com.tencent.mobileqq.activity.recent.gamemsgbox.IGameMsgCallback;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameContactFetchListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.ILoadGameListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameTabData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class GameMsgBoxManagerImpl
  implements IGameMsgBoxManager
{
  public static final int MAX_COUNT = 200;
  private static final String TAG = "GameMsgBoxManagerImpl";
  private AppInterface mApp;
  private EntityManager mEntityMgr;
  private Map<String, GameBoxRecentUser> mGameRecentUserCache = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<RecentUser>> notOpenSyncMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<RecentUser> openSyncRecentUserList = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<RecentGameTabData> titles = new CopyOnWriteArrayList();
  
  private void sortTitles()
  {
    if (!this.titles.isEmpty())
    {
      Object[] arrayOfObject = this.titles.toArray();
      Arrays.sort(arrayOfObject);
      int i = 0;
      while (i < arrayOfObject.length)
      {
        this.titles.set(i, (RecentGameTabData)arrayOfObject[i]);
        i += 1;
      }
    }
  }
  
  private void updateGameUsrInfoItem(GameBoxRecentUser paramGameBoxRecentUser)
  {
    if (paramGameBoxRecentUser != null)
    {
      if (TextUtils.isEmpty(paramGameBoxRecentUser.mConvertUin)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateGameUsrInfoItem], roleId:");
      localStringBuilder.append(paramGameBoxRecentUser.mFromRoleId);
      QLog.i("GameMsgBoxManagerImpl", 1, localStringBuilder.toString());
      this.mGameRecentUserCache.put(paramGameBoxRecentUser.mConvertUin, paramGameBoxRecentUser);
      updateEntity(paramGameBoxRecentUser);
    }
  }
  
  private int updateRecentUserMap(int paramInt, RecentUser paramRecentUser, GameDetailInfo paramGameDetailInfo, GameSwitchConfig paramGameSwitchConfig)
  {
    if (paramGameSwitchConfig.mSyncSwitch == 1)
    {
      if (paramInt >= 200) {
        return paramInt;
      }
      this.openSyncRecentUserList.add(paramRecentUser);
      return paramInt + 1;
    }
    if (this.notOpenSyncMap.containsKey(paramGameDetailInfo.c))
    {
      ((List)this.notOpenSyncMap.get(paramGameDetailInfo.c)).add(paramRecentUser);
      return paramInt;
    }
    paramGameSwitchConfig = new ArrayList();
    paramGameSwitchConfig.add(paramRecentUser);
    this.notOpenSyncMap.put(paramGameDetailInfo.c, paramGameSwitchConfig);
    return paramInt;
  }
  
  private void updateTabTitle(Set<String> paramSet, GameDetailInfo paramGameDetailInfo, GameSwitchConfig paramGameSwitchConfig)
  {
    if (!paramSet.contains(paramGameDetailInfo.c))
    {
      RecentGameTabData localRecentGameTabData = new RecentGameTabData();
      localRecentGameTabData.a = paramGameDetailInfo;
      localRecentGameTabData.b = paramGameSwitchConfig;
      paramSet.add(paramGameDetailInfo.c);
      if (QLog.isColorLevel())
      {
        paramSet = new StringBuilder();
        paramSet.append("add tab title, ");
        paramSet.append(paramGameDetailInfo.toString());
        QLog.d("GameMsgBoxManagerImpl", 2, paramSet.toString());
      }
      this.titles.add(localRecentGameTabData);
    }
  }
  
  public void asyncFindGameBoxRecentUserInfo(String paramString, ILoadGameListener<GameBoxRecentUser> paramILoadGameListener)
  {
    if (paramILoadGameListener == null)
    {
      QLog.e("GameMsgBoxManagerImpl", 1, "asyncFindGameBoxRecentUserInfo listener is null.");
      return;
    }
    GameBoxRecentUser localGameBoxRecentUser = (GameBoxRecentUser)this.mGameRecentUserCache.get(paramString);
    if (localGameBoxRecentUser != null)
    {
      paramILoadGameListener.a(localGameBoxRecentUser);
      return;
    }
    ThreadManagerV2.excute(new GameMsgBoxManagerImpl.3(this, paramString, paramILoadGameListener), 32, null, false);
  }
  
  public void fetchRecentGameContacts(boolean paramBoolean, IGameContactFetchListener paramIGameContactFetchListener)
  {
    ThreadManagerV2.excute(new GameMsgBoxManagerImpl.1(this, paramBoolean, paramIGameContactFetchListener), 16, null, false);
  }
  
  public GameBoxRecentUser findGameBoxRecentUserInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (GameBoxRecentUser)this.mGameRecentUserCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    QLog.i("GameMsgBoxManagerImpl", 1, "try to read from db");
    localObject = this.mEntityMgr.find(GameBoxRecentUser.class, paramString);
    if (localObject != null)
    {
      localObject = (GameBoxRecentUser)localObject;
      this.mGameRecentUserCache.put(paramString, localObject);
      return localObject;
    }
    QLog.i("GameMsgBoxManagerImpl", 1, "fail to find usrinfo from db.");
    return null;
  }
  
  public GameDetailInfo findGameDetailInfoByConvertUin(String paramString)
  {
    GameBoxRecentUser localGameBoxRecentUser = findGameBoxRecentUserInfo(paramString);
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface == null) {
      return null;
    }
    if (localGameBoxRecentUser != null) {
      return ((IGameMsgManagerService)localAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(localGameBoxRecentUser.mToRoleId);
    }
    paramString = ((IGameMsgManagerService)localAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoByUin(paramString);
    if (paramString != null) {
      return ((IGameMsgManagerService)this.mApp.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(paramString.e());
    }
    return null;
  }
  
  @Nullable
  public List<RecentUser> getAllOpenSyncRecentUserList()
  {
    return this.openSyncRecentUserList;
  }
  
  public ArrayList<String> getAppidsInGameBox()
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = getGameMsgBoxSp();
    if (!localSharedPreferences.contains("size")) {
      return null;
    }
    int i = 0;
    int j = localSharedPreferences.getInt("size", 0);
    if (j == 0) {
      return null;
    }
    while (i < j)
    {
      localArrayList.add(String.valueOf(localSharedPreferences.getLong(String.valueOf(i), 0L)));
      i += 1;
    }
    return localArrayList;
  }
  
  public IGameMsgCallback getCallback()
  {
    return GameMsgBoxUtil.a;
  }
  
  public List<RecentGameTabData> getGameBoxTabDataList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getGameMsgBoxRecentUsers();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return localArrayList;
      }
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.mApp.getRuntimeService(IGameMsgManagerService.class, "");
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameDetailInfo localGameDetailInfo = findGameDetailInfoByConvertUin(((RecentUser)((Iterator)localObject).next()).uin);
        if ((localGameDetailInfo != null) && (!TextUtils.isEmpty(localGameDetailInfo.c)))
        {
          GameSwitchConfig localGameSwitchConfig = localIGameMsgManagerService.findGameSwitchConfig(localGameDetailInfo.c);
          if (localGameSwitchConfig == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GameMsgBoxManagerImpl", 2, "getGameBoxTabDataList switchConfig is null.");
            }
          }
          else if (!localHashSet.contains(localGameDetailInfo.c))
          {
            RecentGameTabData localRecentGameTabData = new RecentGameTabData();
            localRecentGameTabData.a = localGameDetailInfo;
            localRecentGameTabData.b = localGameSwitchConfig;
            localHashSet.add(localGameDetailInfo.c);
            localArrayList.add(localRecentGameTabData);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<RecentUser> getGameMsgBoxRecentUsers()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i = 0;
    localObject = ((RecentUserProxy)localObject).a(true, false);
    while (i < ((List)localObject).size())
    {
      RecentUser localRecentUser = (RecentUser)((List)localObject).get(i);
      if (localRecentUser.getType() == 10007) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMsgBoxRecentUsers() called with: outList = [");
      ((StringBuilder)localObject).append(localArrayList);
      ((StringBuilder)localObject).append("]");
      QLog.d("GameMsgBoxManagerImpl", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public SharedPreferences getGameMsgBoxSp()
  {
    return BaseApplication.getContext().getSharedPreferences("gameBoxAppid", 0);
  }
  
  @Nullable
  public List<RecentUser> getNotOpenSyncRecentUserList(String paramString)
  {
    if (this.notOpenSyncMap.containsKey(paramString)) {
      return (List)this.notOpenSyncMap.get(paramString);
    }
    return null;
  }
  
  @Nullable
  public List<RecentGameTabData> getTitles()
  {
    return this.titles;
  }
  
  public int getUnreadCount(String paramString)
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface == null) {
      return 0;
    }
    return ((IConversationFacade)localAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(paramString, 10007);
  }
  
  public boolean isGameInGameBox(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = findGameDetailInfoByConvertUin(paramString);
    if (paramBaseQQAppInterface == null) {
      return false;
    }
    paramString = getGameMsgBoxSp();
    if (paramString.contains("size"))
    {
      if (paramString.getInt("size", 0) == 0) {
        return true;
      }
      int i = 0;
      while (i < paramString.getInt("size", 0))
      {
        if (paramString.getLong(String.valueOf(i), 0L) == Long.parseLong(paramBaseQQAppInterface.c)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public boolean isGameInGameBox(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    SharedPreferences localSharedPreferences = getGameMsgBoxSp();
    if (localSharedPreferences.contains("size"))
    {
      if (localSharedPreferences.getInt("size", 0) == 0) {
        return true;
      }
      int i = 0;
      while (i < localSharedPreferences.getInt("size", 0))
      {
        if (localSharedPreferences.getLong(String.valueOf(i), 0L) == Long.parseLong(paramString)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public boolean isInLimitOfTheFrequency(long paramLong)
  {
    return System.currentTimeMillis() - paramLong < 86400000L;
  }
  
  public boolean isShowGameBoxTips()
  {
    return ((Boolean)BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_game_msg_box_tips", Boolean.valueOf(true))).booleanValue();
  }
  
  public boolean isShowGameMsgUpgradingToast()
  {
    return ((Boolean)BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_game_msg_box_toast", Boolean.valueOf(false))).booleanValue();
  }
  
  protected boolean isShowRedPoint(String paramString)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    String str = this.mApp.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_game_msg_box_tab_red_point_config_");
    localStringBuilder.append(paramString);
    return ((Boolean)BaseSharedPreUtil.a(localBaseApplication, str, localStringBuilder.toString(), Boolean.valueOf(true))).booleanValue();
  }
  
  protected void loadRemoteGameSessionList(IGameMsgManagerService paramIGameMsgManagerService, IGameContactFetchListener paramIGameContactFetchListener)
  {
    if (paramIGameMsgManagerService == null) {
      return;
    }
    paramIGameMsgManagerService.getRemoteGameSessionList(new GameMsgBoxManagerImpl.2(this, paramIGameMsgManagerService, paramIGameContactFetchListener));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.mEntityMgr = this.mApp.getEntityManagerFactory().createEntityManager();
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void saveOrUpdateGameRecentUserInfoArrays(ArrayList<GameBoxRecentUser> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[saveOrUpdateGameUsrInfoArrays], size:");
        ((StringBuilder)localObject).append(paramArrayList.size());
        QLog.d("GameMsgBoxManagerImpl", 2, ((StringBuilder)localObject).toString());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (GameBoxRecentUser)paramArrayList.next();
        if (localObject != null)
        {
          if ((GameBoxRecentUser)this.mGameRecentUserCache.get(((GameBoxRecentUser)localObject).mConvertUin) == null) {
            ((GameBoxRecentUser)localObject).setStatus(1000);
          }
          updateGameUsrInfoItem((GameBoxRecentUser)localObject);
        }
      }
    }
  }
  
  public boolean shouldShowRedPoint(GameSwitchConfig paramGameSwitchConfig)
  {
    if (paramGameSwitchConfig != null)
    {
      if (TextUtils.isEmpty(paramGameSwitchConfig.mAppId)) {
        return false;
      }
      if (paramGameSwitchConfig.mSyncSwitch != 1)
      {
        if (paramGameSwitchConfig.mBlockSwitch != 0) {
          return false;
        }
        return isShowRedPoint(paramGameSwitchConfig.mAppId);
      }
    }
    return false;
  }
  
  public RecentUser syncGetLastRecentUser(String paramString)
  {
    paramString = syncGetRecentUserList(paramString);
    if (!paramString.isEmpty()) {
      return (RecentUser)paramString.get(0);
    }
    return null;
  }
  
  public List<RecentUser> syncGetRecentUserList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((IGameMsgBoxRuntimeService)this.mApp.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getGameRecentUser().iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      GameDetailInfo localGameDetailInfo = findGameDetailInfoByConvertUin(localRecentUser.uin);
      if ((localGameDetailInfo != null) && (localGameDetailInfo.c != null) && (localGameDetailInfo.c.equals(paramString))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void syncLoadRecentGameContacts(boolean paramBoolean, IGameContactFetchListener paramIGameContactFetchListener)
  {
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GameMsgBoxManagerImpl", 2, "mApp not QQApp.");
      }
      return;
    }
    if ((paramBoolean) && (!((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isFirstLaunchNew()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgBoxManagerImpl", 2, "no isFirstLaunch. game contacts not fetch again.");
      }
      paramIGameContactFetchListener = getGameMsgBoxRecentUsers();
      if ((paramIGameContactFetchListener != null) && (!paramIGameContactFetchListener.isEmpty())) {
        ((IGameMsgBoxRuntimeService)this.mApp.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).buildGameBox();
      }
      return;
    }
    if (isInLimitOfTheFrequency(((Long)BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_game_msg_box_last_fetch_time", Long.valueOf(0L))).longValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgBoxManagerImpl", 2, "limitOfTheFrequency game contacts not fetch again.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxManagerImpl", 2, "fetch recent game contacts.");
    }
    loadRemoteGameSessionList((IGameMsgManagerService)this.mApp.getRuntimeService(IGameMsgManagerService.class, ""), paramIGameContactFetchListener);
  }
  
  protected boolean timeInToday(long paramLong)
  {
    boolean bool2 = false;
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      int i = localCalendar.get(1);
      int j = localCalendar.get(2);
      int k = localCalendar.get(5);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      int m = localCalendar.get(1);
      int n = localCalendar.get(2);
      int i1 = localCalendar.get(5);
      boolean bool1 = bool2;
      if (i == m)
      {
        bool1 = bool2;
        if (j + 1 == n + 1)
        {
          bool1 = bool2;
          if (k == i1) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      QLog.e("GameMsgBoxManagerImpl", 2, localException, new Object[0]);
    }
    return false;
  }
  
  public void tryUpdateGameMsgInfoFromRecentUser()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mGameRecentUserCache.isEmpty())
    {
      ThreadManagerV2.excute(new GameMsgBoxManagerImpl.4(this, localArrayList), 32, null, false);
      return;
    }
    ThreadManagerV2.excute(new GameMsgBoxManagerImpl.5(this, localArrayList), 32, null, false);
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.mEntityMgr.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityMgr.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEntityMgr.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.e("GameMsgBoxManagerImpl", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void updateGameMsgBoxRecentUsers()
  {
    this.notOpenSyncMap.clear();
    this.openSyncRecentUserList.clear();
    this.titles.clear();
    Object localObject1 = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i = 0;
    Object localObject2 = ((RecentUserProxy)localObject1).a(true, false);
    localObject1 = (IGameMsgManagerService)this.mApp.getRuntimeService(IGameMsgManagerService.class, "");
    HashSet localHashSet = new HashSet();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (RecentUser)((Iterator)localObject2).next();
      if (((RecentUser)localObject3).getType() == 10007)
      {
        GameDetailInfo localGameDetailInfo = findGameDetailInfoByConvertUin(((RecentUser)localObject3).uin);
        if ((localGameDetailInfo != null) && (!TextUtils.isEmpty(localGameDetailInfo.c)))
        {
          GameSwitchConfig localGameSwitchConfig = ((IGameMsgManagerService)localObject1).findGameSwitchConfig(localGameDetailInfo.c);
          if ((localGameSwitchConfig != null) && (localGameSwitchConfig.mBlockSwitch == 0) && (isGameInGameBox((BaseQQAppInterface)this.mApp, ((RecentUser)localObject3).uin)))
          {
            updateTabTitle(localHashSet, localGameDetailInfo, localGameSwitchConfig);
            i = updateRecentUserMap(i, (RecentUser)localObject3, localGameDetailInfo, localGameSwitchConfig);
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("info is valid, info = ");
          ((StringBuilder)localObject3).append(localGameDetailInfo);
          QLog.d("GameMsgBoxManagerImpl", 1, ((StringBuilder)localObject3).toString());
        }
      }
    }
    sortTitles();
  }
  
  public void updateIsTop(String paramString, int paramInt, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    paramString = localRecentUserProxy.b(paramString, paramInt);
    long l;
    if (paramBoolean) {
      l = System.currentTimeMillis() / 1000L;
    } else {
      l = 0L;
    }
    paramString.showUpTime = l;
    localRecentUserProxy.b(paramString);
  }
  
  public void updateRedPointShowState(boolean paramBoolean, String paramString)
  {
    if (isShowRedPoint(paramString) == paramBoolean) {
      return;
    }
    BaseApplication localBaseApplication = this.mApp.getApp();
    String str = this.mApp.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_game_msg_box_tab_red_point_config_");
    localStringBuilder.append(paramString);
    BaseSharedPreUtil.a(localBaseApplication, str, true, localStringBuilder.toString(), Boolean.valueOf(paramBoolean));
  }
  
  public void updateShowGameBoxTips(boolean paramBoolean)
  {
    BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), true, "key_game_msg_box_tips", Boolean.valueOf(paramBoolean));
  }
  
  public void updateShowGameMsgUpgradingToast(boolean paramBoolean)
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface == null) {
      return;
    }
    if ((paramBoolean) && (((Boolean)BaseSharedPreUtil.a(localAppInterface.getApp(), this.mApp.getCurrentAccountUin(), "key_game_msg_box_toast_record", Boolean.valueOf(false))).booleanValue())) {
      return;
    }
    BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), true, "key_game_msg_box_toast", Boolean.valueOf(paramBoolean));
    BaseSharedPreUtil.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), true, "key_game_msg_box_toast_record", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl
 * JD-Core Version:    0.7.0.1
 */