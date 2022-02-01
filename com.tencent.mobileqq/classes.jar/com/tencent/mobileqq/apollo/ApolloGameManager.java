package com.tencent.mobileqq.apollo;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRoamData;
import com.tencent.mobileqq.apollo.api.model.ApolloPanelBubbleData;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.task.OnAddOrDeleGameListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollo.STGameLogin.STGameConfInfo;
import com.tencent.pb.apollo.STGameLogin.STGameList;
import com.tencent.pb.apollo.STGameLogin.STGameLoginRsp;
import com.tencent.pb.apollo.STGameLogin.STGameTagInfo;
import com.tencent.pb.apollo.STGameLogin.STGetGameConfRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_game_status.STCMGameMessage.STGameCancel;
import tencent.im.apollo_game_status.STCMGameMessage.STGameInvalid;
import tencent.im.apollo_game_status.STCMGameMessage.STGameJoinRoom;
import tencent.im.apollo_game_status.STCMGameMessage.STGameOver;
import tencent.im.apollo_game_status.STCMGameMessage.STGameQuitRoom;
import tencent.im.apollo_game_status.STCMGameMessage.STGameStart;
import tencent.im.apollo_game_status.STCMGameMessage.STMsgComm;
import tencent.im.apollo_game_status.STCMGameMessage.STScoreInfo;

public class ApolloGameManager
  implements Handler.Callback, Manager
{
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static int d;
  public int a;
  private long jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  private ApolloGameArkHandler jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler;
  private ApolloGameManager.ApolloNetInfoHandler jdField_a_of_type_ComTencentMobileqqApolloApolloGameManager$ApolloNetInfoHandler;
  private ApolloPanelBubbleData jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPanelBubbleData = new ApolloPanelBubbleData(-1, -1);
  public ApolloAioBubblePush a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloGameManager.1(this);
  public WeakReference<OnAddOrDeleGameListener> a;
  private Map<Integer, MessageForApollo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean a;
  private long jdField_b_of_type_Long = 600L;
  private WeakReference<XListView> jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference<ChatAdapter1> c;
  private int e = 0;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    d = 3;
    jdField_a_of_type_JavaLangString = "REQ_GAME_KEY";
    jdField_b_of_type_JavaLangString = "REQ_GAME_VAL";
  }
  
  public ApolloGameManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "mCreateTime:" + this.jdField_a_of_type_Long, ",gameJsonUpdateT:", Integer.valueOf(this.e) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush = new ApolloAioBubblePush();
    new IntentFilter().addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler = new ApolloGameArkHandler(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameManager$ApolloNetInfoHandler = new ApolloGameManager.ApolloNetInfoHandler(null);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameManager$ApolloNetInfoHandler);
  }
  
  public static int a(String paramString)
  {
    int i = -1;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, -1);
    }
    return i;
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString + str1, 0);
  }
  
  private void a(List<MessageForApollo> paramList, String paramString)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray;
      MessageForApollo localMessageForApollo;
      for (;;)
      {
        Object localObject;
        JSONObject localJSONObject;
        try
        {
          if (paramList.size() == 0) {
            return;
          }
          localJSONArray = new JSONArray();
          localObject = new JSONObject();
          localMessageForApollo = (MessageForApollo)paramList.get(0);
          ((JSONObject)localObject).put("aioType", localMessageForApollo.istroop);
          ((JSONObject)localObject).put("friendUin", localMessageForApollo.frienduin);
          ((JSONObject)localObject).put("from", paramString);
          ((JSONObject)localObject).put("roomId", localMessageForApollo.roomId);
          ((JSONObject)localObject).put("gameId", localMessageForApollo.gameId);
          ((JSONObject)localObject).put("gameMode", localMessageForApollo.mGameMode);
          ((JSONObject)localObject).put("extendInfo", localMessageForApollo.gameExtendJson);
          paramString = ((JSONObject)localObject).toString();
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (MessageForApollo)paramList.next();
          localJSONObject = new JSONObject();
          localJSONObject.put("gameId", ((MessageForApollo)localObject).gameId);
          localJSONObject.put("roomId", Long.toString(((MessageForApollo)localObject).roomId));
          if (0L == ((MessageForApollo)localObject).roomId) {
            QLog.w("ApolloGameManager", 1, "roomId is 0. gameId:" + localMessageForApollo.gameId + ",gameMode:" + localMessageForApollo.mGameMode);
          }
          localJSONObject.put("gameMode", ((MessageForApollo)localObject).mGameMode);
          localJSONArray.put(localJSONObject);
          if (((MessageForApollo)localObject).istroop != 0) {
            break label394;
          }
          if (((MessageForApollo)localObject).isSend())
          {
            l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localJSONObject.put("sessionId", l);
            if (!((MessageForApollo)localObject).isSend()) {
              continue;
            }
            localJSONObject.put("toUin", Long.parseLong(((MessageForApollo)localObject).frienduin));
            continue;
          }
          long l = Long.parseLong(((MessageForApollo)localObject).frienduin);
        }
        catch (Exception paramList)
        {
          QLog.e("ApolloGameManager", 1, "[MSG_CODE_DO_BULK_REQ], errInfo->" + paramList.getMessage());
          return;
        }
        continue;
        label394:
        localJSONObject.put("sessionId", Long.parseLong(((MessageForApollo)localObject).frienduin));
      }
      paramList = new JSONObject();
      paramList.put("roomList", localJSONArray);
      paramList.put("aioType", ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForApollo.istroop, localMessageForApollo.frienduin));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("apollo_aio_game.get_game_room_state", paramList.toString(), paramString);
      }
    }
  }
  
  public static boolean a()
  {
    SharedPreferences localSharedPreferences = a();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(jdField_b_of_type_JavaLangString, -1) == jdField_c_of_type_Int);
  }
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(jdField_b_of_type_JavaLangString, -1).apply();
    }
  }
  
  public static boolean b()
  {
    SharedPreferences localSharedPreferences = a();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(jdField_b_of_type_JavaLangString, -1) == jdField_b_of_type_Int);
  }
  
  public static void c()
  {
    a().edit().putInt(jdField_b_of_type_JavaLangString, jdField_c_of_type_Int).apply();
  }
  
  public static void d()
  {
    a().edit().putInt(jdField_b_of_type_JavaLangString, jdField_b_of_type_Int).apply();
  }
  
  public ApolloGameArkHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler;
  }
  
  public MessageForApollo a(int paramInt)
  {
    return (MessageForApollo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public List<ApolloGameData> a(List<STGameLogin.STGameConfInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get gameData list:");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
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
      if (localSTGameConfInfo.isfeatured.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localApolloGameData.isFeatured = bool;
        localApolloGameData.isShow = localSTGameConfInfo.is_show_onpanel.get();
        localApolloGameData.listCoverUrl = localSTGameConfInfo.list_cover_url.get();
        localApolloGameData.logoUrl = localSTGameConfInfo.logo_url.get();
        localApolloGameData.needOpenKey = localSTGameConfInfo.need_open_key.get();
        localApolloGameData.officialAccountUin = String.valueOf(localSTGameConfInfo.puin.get());
        localApolloGameData.screenMode = localSTGameConfInfo.screen_mode.get();
        localApolloGameData.viewMode = localSTGameConfInfo.view_mode.get();
        localArrayList.add(localApolloGameData);
        localStringBuilder.append(localApolloGameData.toString()).append(",");
        i += 1;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "parseSTGameConfInfoList:", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPanelBubbleData.gameId = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloPanelBubbleData.from = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, apollo_game_status.STCMGameMessage paramSTCMGameMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (paramSTCMGameMessage == null) {
      try
      {
        QLog.e("ApolloGameManager", 1, "[onGetGameStatus], errInfo->null == gameStatus");
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameManager", 1, "[onGetGameStatus],errInfo->" + paramString.getMessage());
        return;
      }
    }
    MessageForApollo localMessageForApollo = new MessageForApollo();
    Object localObject1 = (apollo_game_status.STCMGameMessage.STMsgComm)paramSTCMGameMessage.msg_comm.get();
    localMessageForApollo.gameStatusStamp = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint64_time_stamp.get();
    localMessageForApollo.roomId = Long.parseLong(((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).str_room_id.get());
    localMessageForApollo.gameId = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_game_id.get();
    localMessageForApollo.mGameMode = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_play_model.get();
    localMessageForApollo.commInfo = new String(((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).str_game_comm_info.get().toByteArray());
    Object localObject2 = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).rpt_uint32_uin_list.get();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        localMessageForApollo.playerList.add(Long.valueOf(Utils.a(localInteger.intValue())));
      }
    }
    localMessageForApollo.roomVol = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_room_vol.get();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "[onGetGameStatus], mGameMode:", Integer.valueOf(localMessageForApollo.mGameMode), ",roomId:", Long.valueOf(localMessageForApollo.roomId), ",gameId:", Integer.valueOf(localMessageForApollo.gameId), ",aioType:", Integer.valueOf(paramInt2), ",friendUin:", paramString, ",from:", Integer.valueOf(paramInt1), ", gameStatusStamp:", Long.valueOf(localMessageForApollo.gameStatusStamp), "roomVol:", Integer.valueOf(localMessageForApollo.roomVol), ",playerSize:", Integer.valueOf(localMessageForApollo.playerList.size()) });
    }
    int i = paramSTCMGameMessage.uint32_msg_cmd.get();
    localMessageForApollo.gameStatus = i;
    switch (i)
    {
    case 1: 
      label476:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "apolloMsg.gameArkInfo:", localMessageForApollo.gameArkInfo });
      }
      localMessageForApollo.frienduin = paramString;
      localMessageForApollo.istroop = paramInt2;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5891, localMessageForApollo).sendToTarget();
      }
      break;
    }
    label543:
    while ((!TextUtils.isEmpty(paramSTCMGameMessage)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      paramInt2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramInt2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(false);
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        paramInt1 = paramInt2;
        if (((HotChatManager)localObject1).b(paramString)) {
          paramInt1 = 3;
        }
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramSTCMGameMessage, paramInt1, 0, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(localMessageForApollo.gameStatus), "", Long.toString(localMessageForApollo.roomId) });
      return;
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameJoinRoom)paramSTCMGameMessage.msg_0x01.get()).str_game_join_info.get().toByteArray());
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[START]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameStart)paramSTCMGameMessage.msg_0x03.get()).str_game_start_info.get().toByteArray());
      break label476;
      paramSTCMGameMessage = (apollo_game_status.STCMGameMessage.STGameQuitRoom)paramSTCMGameMessage.msg_0x02.get();
      i = paramSTCMGameMessage.uint32_room_vol.get();
      localMessageForApollo.gameArkInfo = new String(paramSTCMGameMessage.str_game_quit_info.get().toByteArray());
      if (!QLog.isColorLevel()) {
        break label476;
      }
      QLog.d("ApolloGameManager", 2, new Object[] { "[QUIT], roomVol:", Integer.valueOf(i), ",playerSize:", Integer.valueOf(localMessageForApollo.playerList.size()) });
      break label476;
      paramSTCMGameMessage = (apollo_game_status.STCMGameMessage.STGameOver)paramSTCMGameMessage.msg_0x04.get();
      localMessageForApollo.gameArkInfo = new String(paramSTCMGameMessage.str_game_over_info.get().toByteArray());
      localMessageForApollo.overType = paramSTCMGameMessage.uint32_over_type.get();
      localObject1 = paramSTCMGameMessage.rpt_msg_winner_info.get();
      localMessageForApollo.winnerList.clear();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label476;
      }
      localObject2 = (apollo_game_status.STCMGameMessage.STScoreInfo)((List)localObject1).get(0);
      paramSTCMGameMessage = ((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).str_wording.get();
      long l = Utils.a(((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).uint32_winner.get());
      localMessageForApollo.winRecord = paramSTCMGameMessage;
      localMessageForApollo.winnerUin = l;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (apollo_game_status.STCMGameMessage.STScoreInfo)((Iterator)localObject1).next();
        localMessageForApollo.winnerList.add(Long.valueOf(Utils.a(((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).uint32_winner.get())));
      }
      if (!QLog.isColorLevel()) {
        break label476;
      }
      QLog.d("ApolloGameManager", 2, "[OVER.OneWinner], winRecord:" + paramSTCMGameMessage + ",winUin:" + l);
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[INVALID]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameInvalid)paramSTCMGameMessage.msg_0x05.get()).str_game_invlid_info.get().toByteArray());
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[CANCEL]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameCancel)paramSTCMGameMessage.msg_0x06.get()).str_game_cancel_info.get().toByteArray());
      break label476;
      do
      {
        if (paramInt1 != 1) {
          break label543;
        }
        paramSTCMGameMessage = "pull_game_status";
        break label543;
        break;
        paramSTCMGameMessage = "";
      } while (paramInt1 != 0);
      paramSTCMGameMessage = "get_push_status";
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).queryApolloSwitchSet("gameSwitch") != 1) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "[bulkPullGameStatus], from:", Integer.valueOf(paramInt1), ",friendUin:", paramString, ",aioType:", Integer.valueOf(paramInt2) });
      }
      if ((1 == paramInt1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    } while (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5893);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5893, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }).sendToTarget();
  }
  
  public void a(int paramInt, List<apollo_game_status.STCMGameMessage> paramList, String paramString)
  {
    if (paramInt != 0) {
      QLog.w("ApolloGameManager", 1, "[onStatusRespFromPull], ret != 0, ret:" + paramInt);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "pull from svr, list.size:" + paramList.size());
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramInt = localJSONObject.optInt("aioType");
        paramString = localJSONObject.optString("friendUin");
        localJSONObject.optString("from");
        if (paramList.size() <= 0) {
          continue;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a(1, paramInt, paramString, (apollo_game_status.STCMGameMessage)paramList.next());
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloGameManager", 1, "[onStatusRespFromPull], errInfo->" + paramList.getMessage());
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3) {}
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramLong != 0L))
    {
      QLog.e("ApolloGameManager", 1, new Object[] { "[onGameLoginRespFromSvr] app is null or ret is :", Long.valueOf(paramLong) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr ret:", Long.valueOf(paramLong) });
    }
    for (;;)
    {
      Object localObject1;
      int m;
      int j;
      int k;
      try
      {
        localObject1 = new STGameLogin.STGameLoginRsp();
        ((STGameLogin.STGameLoginRsp)localObject1).mergeFrom(paramArrayOfByte);
        Object localObject2 = ((STGameLogin.STGameLoginRsp)localObject1).game_list.get();
        List localList1 = ((STGameLogin.STGameLoginRsp)localObject1).game_tag_info.get();
        List localList2 = ((STGameLogin.STGameLoginRsp)localObject1).game_conf_info.get();
        paramLong = ((STGameLogin.STGameLoginRsp)localObject1).svr_ts.get();
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        i = 0;
        paramArrayOfByte = null;
        long l = NetConnInfoCenter.getServerTime();
        ConcurrentHashMap localConcurrentHashMap = localApolloDaoManagerServiceImpl.getTabGameRoamList();
        m = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get roam list:");
        ArrayList localArrayList = new ArrayList();
        j = 0;
        Object localObject3;
        if (j < ((List)localObject2).size())
        {
          localObject3 = (STGameLogin.STGameList)((List)localObject2).get(j);
          localObject1 = new ApolloGameRoamData();
          ((ApolloGameRoamData)localObject1).gameId = ((STGameLogin.STGameList)localObject3).game_id.get();
          ((ApolloGameRoamData)localObject1).type = ((STGameLogin.STGameList)localObject3).tab.get();
          localArrayList.add(localObject1);
          localStringBuilder.append("gameId:").append(((ApolloGameRoamData)localObject1).gameId).append(" type:").append(((ApolloGameRoamData)localObject1).type).append(",");
          if ((i != 0) || (((ApolloGameRoamData)localObject1).type != 1) || (l - paramLong >= 604800000L) || (localApolloDaoManagerServiceImpl.findGameById(((ApolloGameRoamData)localObject1).gameId) == null)) {
            break label992;
          }
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
          paramArrayOfByte.putBoolean("aio_game_bubble", true);
          paramArrayOfByte.putInt("aio_bubble_recommend_game_id", ((ApolloGameRoamData)localObject1).gameId);
          paramArrayOfByte.commit();
          if (!QLog.isColorLevel()) {
            break label995;
          }
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr save recommend game id=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
          break label995;
        }
        localStringBuilder.append("\r\n").append("tagInfo:");
        k = 0;
        j = 0;
        i = m;
        if (k < localList1.size())
        {
          localObject1 = (STGameLogin.STGameTagInfo)localList1.get(k);
          m = 0;
          if (m >= localArrayList.size()) {
            break label1022;
          }
          if (((STGameLogin.STGameTagInfo)localObject1).game_id.get() != ((ApolloGameRoamData)localArrayList.get(m)).gameId) {
            break label989;
          }
          localObject2 = (ApolloGameRoamData)localArrayList.get(m);
          ((ApolloGameRoamData)localObject2).tagUrl = ((STGameLogin.STGameTagInfo)localObject1).tag_url.get();
          ((ApolloGameRoamData)localObject2).tagType = ((STGameLogin.STGameTagInfo)localObject1).tag_type.get();
          ((ApolloGameRoamData)localObject2).tagBegTs = ((STGameLogin.STGameTagInfo)localObject1).tag_beg_ts.get();
          ((ApolloGameRoamData)localObject2).tagEndTs = ((STGameLogin.STGameTagInfo)localObject1).tag_end_ts.get();
          localStringBuilder.append("gameId:").append(((ApolloGameRoamData)localObject2).gameId).append("tagUrl:").append(((ApolloGameRoamData)localObject2).tagUrl).append(",tagEndTs:").append(((ApolloGameRoamData)localObject2).tagEndTs).append(",");
          j += 1;
          localObject3 = (ApolloGameRoamData)localConcurrentHashMap.get(Integer.valueOf(((ApolloGameRoamData)localObject2).gameId));
          if ((TextUtils.isEmpty(((ApolloGameRoamData)localObject2).tagUrl)) || ((localObject3 != null) && (((ApolloGameRoamData)localObject3).tagUrl.equals(((ApolloGameRoamData)localObject2).tagUrl)) && (((ApolloGameRoamData)localObject3).tagBegTs == ((ApolloGameRoamData)localObject2).tagBegTs) && (((ApolloGameRoamData)localObject3).tagEndTs == ((ApolloGameRoamData)localObject2).tagEndTs))) {
            break label986;
          }
          if (!QLog.isColorLevel()) {
            break label1010;
          }
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr has new tag gameId:", Integer.valueOf(((ApolloGameRoamData)localObject2).gameId) });
          break label1010;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr:", localStringBuilder.toString() });
        }
        localObject1 = a(localList2);
        if (paramArrayOfByte != null)
        {
          localArrayList.remove(paramArrayOfByte);
          if (TextUtils.isEmpty(paramArrayOfByte.tagUrl)) {
            break label983;
          }
          j = 0;
          localArrayList.add(j, paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr recommend data:", Integer.valueOf(paramArrayOfByte.gameId), ", will insert:", Integer.valueOf(j) });
          }
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (localApolloDaoManagerServiceImpl.packageList != null) {
            bool1 = true;
          }
        }
        localApolloDaoManagerServiceImpl.updateGamePackageInfo(bool1);
        localApolloDaoManagerServiceImpl.removeAllGameRoamData();
        localApolloDaoManagerServiceImpl.saveGameRoamData(localArrayList);
        localApolloDaoManagerServiceImpl.updateGameInfoList((List)localObject1);
        ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        c();
        ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).onGetGameList();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloGameManager", 1, "onGameLoginRespFromSvr Exception:", paramArrayOfByte);
        return;
      }
      label983:
      continue;
      label986:
      break label1013;
      label989:
      break label1013;
      label992:
      break label1001;
      label995:
      int i = 1;
      paramArrayOfByte = (byte[])localObject1;
      label1001:
      j += 1;
      continue;
      label1010:
      i = 1;
      label1013:
      m += 1;
      continue;
      label1022:
      k += 1;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramLong != 0L)) {
      QLog.e("ApolloGameManager", 1, new Object[] { "[onGameLoginRespFromSvr] app is null or ret is :", Long.valueOf(paramLong) });
    }
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "onGameListDetailRespFromSvr ret:", Long.valueOf(paramLong) });
      }
      try
      {
        STGameLogin.STGetGameConfRsp localSTGetGameConfRsp = new STGameLogin.STGetGameConfRsp();
        localSTGetGameConfRsp.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = a(localSTGetGameConfRsp.game_conf_info.get());
        ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateGameInfoList(paramArrayOfByte);
        i = paramBundle.getInt("key_get_game_detail_from", 0);
        if (i == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameManager", 2, new Object[] { "onGameListDetailRespFromSvr get data when start game size:", Integer.valueOf(paramArrayOfByte.size()) });
          }
          ApolloGameUtil.c();
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloGameManager", 1, "Exception:", paramArrayOfByte);
        return;
      }
    } while ((i != 1) && (i != 2));
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(paramArrayOfByte, paramBundle);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramIntent != null) && (paramIntent.hasExtra("launchApolloGame")) && (paramIntent.getBooleanExtra("launchApolloGame", false)))
    {
      int i = paramIntent.getIntExtra("gameId", -1);
      int j = paramIntent.getIntExtra("gameMode", 0);
      int k = paramIntent.getIntExtra("enter", -1);
      String str1 = paramIntent.getStringExtra("gameName");
      String str2 = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[launchApolloGame] start launchGame:gameId = " + i + ";gameMode = " + j + ";friendUin = " + str2);
      }
      paramIntent.putExtra("launchApolloGame", false);
      if (BaseActivity.sTopActivity != null)
      {
        paramIntent = new CmGameStartChecker.StartCheckParam(i, true, "launch", 0L, k, j, paramInt, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, str2), str2, 205, str1);
        ApolloGameUtil.a(BaseActivity.sTopActivity, paramIntent);
      }
    }
  }
  
  public void a(MessageForApollo paramMessageForApollo, String paramString)
  {
    if ((paramMessageForApollo != null) && (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo, this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5892, new Object[] { paramString, paramMessageForApollo }).sendToTarget();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[pullSingleMsg], roomId:" + paramMessageForApollo.roomId + ",from:" + paramString);
      }
    }
  }
  
  public void a(XListView paramXListView, ChatAdapter1 paramChatAdapter1)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramXListView);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramChatAdapter1);
  }
  
  public void a(String paramString1, String paramString2, ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[addOrDelGame2Svr], cmd:" + paramString2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    do
    {
      do
      {
        return;
        for (;;)
        {
          Integer localInteger;
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("cmd", paramString2);
            localJSONObject.put("from", paramString1);
            localJSONArray = new JSONArray();
            paramArrayList = paramArrayList.iterator();
            if (!paramArrayList.hasNext()) {
              break;
            }
            localInteger = (Integer)paramArrayList.next();
            if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString2)) && (!ApolloGameUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInteger.intValue())))
            {
              localJSONArray.put(localInteger);
              continue;
            }
            if (!"apollo_aio_game.del_games_from_user_gamepanel".equals(paramString2)) {
              continue;
            }
          }
          catch (Exception paramString1)
          {
            QLog.i("ApolloGameManager", 1, "[addOrDelGame2Svr], errInfo->" + paramString1.getMessage());
            return;
          }
          if (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInteger.intValue())) {
            localJSONArray.put(localInteger);
          }
        }
        if (localJSONArray.length() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "list is empty, return now.");
        }
      } while ((!"android.web".equals(paramString1)) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
      paramString1 = (OnAddOrDeleGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString1 == null);
    ApolloGameUtil.a(paramString1, -1L, paramString2);
    return;
    localJSONObject.put("gameIdList", localJSONArray);
    paramString1 = localJSONObject.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[addOrDelGame2Svr], reqStr:" + paramString1);
    }
    ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramString2, paramString1, -1L, 1);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[reqUsrGameList]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    d();
    ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 5891: 
    case 5892: 
      for (;;)
      {
        return true;
        if (!(paramMessage.obj instanceof MessageForApollo)) {
          return true;
        }
        paramMessage = (MessageForApollo)paramMessage.obj;
        ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this.jdField_b_of_type_JavaLangRefWeakReference, this.jdField_c_of_type_JavaLangRefWeakReference);
        continue;
        localObject = (Object[])paramMessage.obj;
        if ((localObject != null) && (localObject.length >= 2))
        {
          paramMessage = (String)localObject[0];
          localObject = (MessageForApollo)localObject[1];
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject);
          a(localArrayList, paramMessage);
        }
      }
    }
    ApolloSoLoaderImpl.loadSo("AIO");
    for (;;)
    {
      int i;
      try
      {
        if ((!b()) && (!a())) {
          e();
        }
        paramMessage = (Object[])paramMessage.obj;
        i = ((Integer)paramMessage[0]).intValue();
        int j = ((Integer)paramMessage[1]).intValue();
        if (j == 1036) {
          return false;
        }
        localObject = (String)paramMessage[2];
        paramMessage = null;
        if ((1 != i) && (3 != i)) {
          break label281;
        }
        paramMessage = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (String)localObject, j, i);
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break;
        }
        a(paramMessage, "aio");
      }
      catch (Throwable paramMessage)
      {
        QLog.e("ApolloGameManager", 1, paramMessage, new Object[0]);
      }
      break;
      label281:
      if (2 == i) {
        paramMessage = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Int = -1;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameManager$ApolloNetInfoHandler != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameManager$ApolloNetInfoHandler);
      }
      ApolloSoLoaderImpl.removeFileObserver();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameManager
 * JD-Core Version:    0.7.0.1
 */