package com.tencent.mobileqq.apollo.game.api.impl;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager;
import com.tencent.mobileqq.apollo.game.CmGameConnManager;
import com.tencent.mobileqq.apollo.game.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloPanelBubbleData;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollo.STGameLogin.STGameConfInfo;
import com.tencent.pb.apollo.STGameLogin.STGameLoginRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class ApolloGameManagerImpl
  implements IApolloGameManager
{
  public static final String DEFAULT_SSO_CMD_RULES = "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
  public static final int DEFAULT_VAL = -1;
  public static final int GAME_UPDATE_TIME_INTERVAL_AT_LEAST = 600;
  public static final int MSG_CODE_DO_BULK_REQ = 5893;
  public static final int MSG_CODE_FOR_SINGLE_REQ = 5892;
  public static final int MSG_CODE_UPDATE_GAME_STATUS = 5891;
  public static final int QUERY_TIME_SLICE = 180;
  public static int REQ_GAME_LIST_FAILED = 3;
  public static int REQ_GAME_LIST_SEND = 1;
  public static int REQ_GAME_LIST_SUCC = 2;
  public static String REQ_KEY = "REQ_GAME_KEY";
  public static String REQ_VAL = "REQ_GAME_VAL";
  public static final String SENGMSG_TAG = "cmgame.sendmsg";
  public static final String SP_GAME_JSON_LAST_UPDATE_IN_SEC = "game_json_last_update_in_sec";
  private Map<Integer, MessageForApollo> gameLoadingMsgs = new HashMap();
  private QQAppInterface mApp;
  public ApolloAioBubblePush mBubblePush;
  public AtomicBoolean mCanTry;
  private CmGameAudioManager mCmGameAudioManager;
  private CmGameConnManager mCmGameConnManager;
  private long mCreateTime;
  public int mCurrentBubbleGameId = -1;
  private ApolloPanelBubbleData mCurrentPanelBubbleGame = new ApolloPanelBubbleData(-1, -1);
  private CmGameTempSessionHandler mGameTempMsgHandler;
  private int mLastGameJsonUpdateTime = 0;
  private ApolloGameManagerImpl.ApolloNetInfoHandler mNetInfoHandler;
  protected SharedPreferences mSp;
  
  public static SharedPreferences getReqSp()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "noLogin";
    }
    localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(REQ_KEY);
    localStringBuilder.append((String)localObject1);
    return ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static int getValFromSP(String paramString)
  {
    SharedPreferences localSharedPreferences = getReqSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt(paramString, -1);
    }
    return -1;
  }
  
  private boolean isReqUsrGameListSend()
  {
    SharedPreferences localSharedPreferences = getReqSp();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(REQ_VAL, -1) == REQ_GAME_LIST_SEND);
  }
  
  private void setReqUsrGameListSend()
  {
    getReqSp().edit().putInt(REQ_VAL, REQ_GAME_LIST_SEND).apply();
  }
  
  private void setReqUsrGameListSuccess()
  {
    getReqSp().edit().putInt(REQ_VAL, REQ_GAME_LIST_SUCC).apply();
  }
  
  public CmGameAudioManager getCmGameAudioManager()
  {
    try
    {
      if (this.mCmGameAudioManager == null) {
        this.mCmGameAudioManager = new CmGameAudioManager(this.mApp);
      }
      CmGameAudioManager localCmGameAudioManager = this.mCmGameAudioManager;
      return localCmGameAudioManager;
    }
    finally {}
  }
  
  public CmGameConnManager getCmGameConnManager()
  {
    try
    {
      if (this.mCmGameConnManager == null) {
        this.mCmGameConnManager = new CmGameConnManager(this.mApp);
      }
      CmGameConnManager localCmGameConnManager = this.mCmGameConnManager;
      return localCmGameConnManager;
    }
    finally {}
  }
  
  public ApolloPanelBubbleData getCurrentPanelBubbleGame()
  {
    return this.mCurrentPanelBubbleGame;
  }
  
  public MessageForApollo getGameMsgById(int paramInt)
  {
    return (MessageForApollo)this.gameLoadingMsgs.get(Integer.valueOf(paramInt));
  }
  
  public CmGameTempSessionHandler getGameTempMsgHandler()
  {
    if (this.mGameTempMsgHandler == null) {
      this.mGameTempMsgHandler = new CmGameTempSessionHandler(this.mApp);
    }
    return this.mGameTempMsgHandler;
  }
  
  public boolean isGameAudioManagerCreated()
  {
    return this.mCmGameAudioManager != null;
  }
  
  public void onAddOrDelGame()
  {
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null)
    {
      ((ApolloResManagerImpl)localQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).notifyJsonDone();
      return;
    }
    QLog.e("ApolloGameManager", 1, "[onAddOrDelGame] error, appRuntime is null!");
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)paramAppRuntime);
      this.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
      this.mLastGameJsonUpdateTime = getValFromSP("game_json_last_update_in_sec");
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("mCreateTime:");
        paramAppRuntime.append(this.mCreateTime);
        QLog.d("ApolloGameManager", 2, new Object[] { paramAppRuntime.toString(), ",gameJsonUpdateT:", Integer.valueOf(this.mLastGameJsonUpdateTime) });
      }
      this.mCanTry = new AtomicBoolean(false);
      this.mBubblePush = new ApolloAioBubblePush();
      new IntentFilter().addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.mNetInfoHandler = new ApolloGameManagerImpl.ApolloNetInfoHandler(null);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.mNetInfoHandler);
      return;
    }
    throw new RuntimeException("can not create ApolloGameManager without QQAppInterface!!");
  }
  
  public void onDestroy()
  {
    this.mCurrentBubbleGameId = -1;
    Object localObject = this.mGameTempMsgHandler;
    if (localObject != null) {
      ((CmGameTempSessionHandler)localObject).a();
    }
    localObject = this.mCmGameConnManager;
    if (localObject != null)
    {
      ((CmGameConnManager)localObject).e();
      this.mCmGameConnManager = null;
    }
    localObject = this.mCmGameAudioManager;
    if (localObject != null)
    {
      ((CmGameAudioManager)localObject).b();
      this.mCmGameAudioManager = null;
    }
    try
    {
      if (this.mNetInfoHandler != null)
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.mNetInfoHandler);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
  
  public void onGameLoginRespFromSvr(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.mApp != null) && (paramLong == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr ret:", Long.valueOf(paramLong) });
      }
      try
      {
        Object localObject = new STGameLogin.STGameLoginRsp();
        ((STGameLogin.STGameLoginRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((STGameLogin.STGameLoginRsp)localObject).game_conf_info.get();
        localObject = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get roam list:");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr:", localStringBuilder.toString() });
        }
        ((ApolloDaoManagerServiceImpl)localObject).updateGameInfoList(parseSTGameConfInfoList(paramArrayOfByte));
        setReqUsrGameListSuccess();
        onGetGameList();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloGameManager", 1, "onGameLoginRespFromSvr Exception:", paramArrayOfByte);
        return;
      }
    }
    QLog.e("ApolloGameManager", 1, new Object[] { "[onGameLoginRespFromSvr] app is null or ret is :", Long.valueOf(paramLong) });
  }
  
  public void onGetGameList()
  {
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null)
    {
      ((ApolloResManagerImpl)localQQAppInterface.getRuntimeService(IApolloResManager.class, "all")).notifyJsonDone();
      return;
    }
    QLog.e("ApolloGameManager", 1, "[onGetGameList] error, appRuntime is null!");
  }
  
  @Deprecated
  public void onGetGameStatus(int paramInt1, int paramInt2, String paramString, Object paramObject) {}
  
  public List<ApolloGameData> parseSTGameConfInfoList(List<STGameLogin.STGameConfInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get gameData list:");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      int j = paramList.size();
      boolean bool = true;
      if (i >= j) {
        break;
      }
      STGameLogin.STGameConfInfo localSTGameConfInfo = (STGameLogin.STGameConfInfo)paramList.get(i);
      ApolloGameData localApolloGameData = new ApolloGameData();
      localApolloGameData.gameId = localSTGameConfInfo.game_id.get();
      localApolloGameData.actionId = localSTGameConfInfo.action_id.get();
      localApolloGameData.appId = localSTGameConfInfo.appid.get();
      localApolloGameData.developerName = localSTGameConfInfo.ep_name.get();
      localApolloGameData.minVer = localSTGameConfInfo.g_start_ver.get();
      localApolloGameData.maxVer = localSTGameConfInfo.g_end_ver.get();
      localApolloGameData.name = localSTGameConfInfo.game_name.get();
      localApolloGameData.hasOwnArk = localSTGameConfInfo.has_own_ark.get();
      if (localSTGameConfInfo.isfeatured.get() != 1) {
        bool = false;
      }
      localApolloGameData.isFeatured = bool;
      localApolloGameData.isShow = localSTGameConfInfo.is_show_onpanel.get();
      localApolloGameData.listCoverUrl = localSTGameConfInfo.list_cover_url.get();
      localApolloGameData.logoUrl = localSTGameConfInfo.logo_url.get();
      localApolloGameData.needOpenKey = localSTGameConfInfo.need_open_key.get();
      localApolloGameData.officialAccountUin = String.valueOf(localSTGameConfInfo.puin.get());
      localApolloGameData.screenMode = localSTGameConfInfo.screen_mode.get();
      localApolloGameData.viewMode = localSTGameConfInfo.view_mode.get();
      localArrayList.add(localApolloGameData);
      localStringBuilder.append(localApolloGameData.toString());
      localStringBuilder.append(",");
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "parseSTGameConfInfoList:", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  public void reqUsrGameList()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[reqUsrGameList]");
    }
    if (this.mApp == null) {
      return;
    }
    setReqUsrGameListSend();
    ((ApolloExtensionHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a();
  }
  
  public void resetReqUsrGameList()
  {
    SharedPreferences localSharedPreferences = getReqSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(REQ_VAL, -1).apply();
    }
  }
  
  public void setCurrentPanelBubbleGame(int paramInt1, int paramInt2)
  {
    ApolloPanelBubbleData localApolloPanelBubbleData = this.mCurrentPanelBubbleGame;
    localApolloPanelBubbleData.gameId = paramInt1;
    localApolloPanelBubbleData.from = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl
 * JD-Core Version:    0.7.0.1
 */