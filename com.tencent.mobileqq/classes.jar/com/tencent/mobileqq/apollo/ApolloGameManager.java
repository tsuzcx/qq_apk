package com.tencent.mobileqq.apollo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.task.OnAddOrDeleGameListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
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
import yjs;
import yju;
import yjv;
import yjw;

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
  protected BroadcastReceiver a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private ApolloGameArkHandler jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler;
  public ApolloGameObserver a;
  public ApolloAioBubblePush a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new yjs(this);
  public WeakReference a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicBoolean a;
  private yjv jdField_a_of_type_Yjv;
  private long jdField_b_of_type_Long = 600L;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference c;
  private int e = a("game_json_last_update_in_sec");
  
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
    h();
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush = new ApolloAioBubblePush();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameObserver = new ApolloGameObserver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameObserver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yjw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      }
      for (;;)
      {
        CmGameServerQIPCModule.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler = new ApolloGameArkHandler(paramQQAppInterface);
        this.jdField_a_of_type_Yjv = new yjv(null);
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Yjv);
        return;
        QLog.e("ApolloGameManager", 1, "[ApolloGameManager] app is null");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloGameManager", 1, localThrowable, new Object[] { "[ApolloGameManager]" });
      }
    }
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
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private void a(List paramList, String paramString)
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
            break label395;
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
        label395:
        localJSONObject.put("sessionId", Long.parseLong(((MessageForApollo)localObject).frienduin));
      }
      paramList = new JSONObject();
      paramList.put("roomList", localJSONArray);
      paramList.put("aioType", ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForApollo.istroop, localMessageForApollo.frienduin));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a("apollo_aio_game.get_game_room_state", paramList.toString(), paramString);
      }
    }
  }
  
  public static boolean a()
  {
    SharedPreferences localSharedPreferences = a();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(jdField_b_of_type_JavaLangString, -1) == jdField_c_of_type_Int);
  }
  
  private boolean a(ArrayList paramArrayList, List paramList)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if ((paramList != null) && (paramList.size() > 0)) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
          bool1 = bool2;
        } while (paramList == null);
        bool1 = bool2;
      } while (paramList.size() == 0);
      bool1 = bool2;
    } while (paramArrayList.size() != paramList.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label125;
      }
      bool1 = bool2;
      if (((ApolloGameRoamData)paramArrayList.get(i)).gameId != ((ApolloGameRoamData)paramList.get(i)).gameId) {
        break;
      }
      i += 1;
    }
    label125:
    return false;
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
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameObserver);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5894).sendToTarget();
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      i = -2;
      j = i;
      if (i == -2)
      {
        localStringBuilder = new StringBuilder().append(ApolloConstant.jdField_a_of_type_JavaLangString).append("/game/").append(String.valueOf(paramInt1));
        if ((paramInt2 != 2) && (paramInt2 != 1)) {
          break label176;
        }
      }
    }
    label176:
    for (Object localObject = "/gameConfig.json";; localObject = "/appConfig.json")
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break label204;
      }
      try
      {
        localObject = new JSONObject(FileUtils.a((File)localObject));
        if (!((JSONObject)localObject).has("viewMode")) {
          break label204;
        }
        j = ((JSONObject)localObject).optInt("viewMode") - 1;
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt1, Integer.valueOf(j));
        return j;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameManager", 1, localThrowable, new Object[] { "[getGameViewMode]" });
      }
      i = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1, Integer.valueOf(-2))).intValue();
      break;
    }
    label204:
    return -1;
  }
  
  public ApolloGameArkHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler;
  }
  
  public MessageForApollo a(int paramInt)
  {
    return (MessageForApollo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
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
      paramInt2 = ApolloUtil.b(paramInt2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
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
    if (ApolloManager.c("gameSwitch") != 1) {}
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
  
  public void a(int paramInt, List paramList, String paramString)
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
  
  /* Error */
  public void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 799	com/tencent/mobileqq/apollo/ApolloGameManager:c	()V
    //   3: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 98
    //   11: iconst_2
    //   12: new 100	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 801
    //   22: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 803
    //   32: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 668	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lconst_0
    //   46: lload_1
    //   47: lcmp
    //   48: ifeq +38 -> 86
    //   51: ldc2_w 804
    //   54: lload_1
    //   55: lcmp
    //   56: ifeq +30 -> 86
    //   59: ldc 98
    //   61: iconst_1
    //   62: new 100	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 807
    //   72: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: lload_1
    //   76: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 369	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: return
    //   86: new 293	org/json/JSONObject
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 463	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   94: astore 12
    //   96: aload 12
    //   98: ldc_w 809
    //   101: invokevirtual 813	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnonnull +677 -> 783
    //   109: aload 12
    //   111: ldc_w 815
    //   114: invokevirtual 813	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   117: astore_3
    //   118: aload_3
    //   119: ldc_w 817
    //   122: invokevirtual 820	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   125: lstore 7
    //   127: aload_3
    //   128: ldc_w 822
    //   131: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   134: istore 4
    //   136: iload 4
    //   138: i2l
    //   139: aload_0
    //   140: getfield 68	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_b_of_type_Long	J
    //   143: lcmp
    //   144: ifle +10 -> 154
    //   147: aload_0
    //   148: iload 4
    //   150: i2l
    //   151: putfield 68	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_b_of_type_Long	J
    //   154: iconst_2
    //   155: invokestatic 824	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(I)I
    //   158: i2l
    //   159: lstore 9
    //   161: lload 7
    //   163: lload 9
    //   165: lcmp
    //   166: ifeq +26 -> 192
    //   169: aload_0
    //   170: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: bipush 115
    //   175: invokevirtual 401	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   178: checkcast 826	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler
    //   181: ifnull +11 -> 192
    //   184: aload_0
    //   185: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   188: iconst_2
    //   189: invokestatic 829	com/tencent/mobileqq/app/utils/ApolloContentUpdateHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   192: ldc 98
    //   194: iconst_1
    //   195: new 100	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 831
    //   205: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: lload 9
    //   210: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc_w 833
    //   216: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lload 7
    //   221: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: ldc_w 835
    //   227: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload 4
    //   232: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc_w 837
    //   238: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 68	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_b_of_type_Long	J
    //   245: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 840	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: ldc2_w 804
    //   257: lload_1
    //   258: lcmp
    //   259: ifeq -174 -> 85
    //   262: invokestatic 799	com/tencent/mobileqq/apollo/ApolloGameManager:c	()V
    //   265: aload_3
    //   266: ldc_w 842
    //   269: invokevirtual 820	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   272: lstore_1
    //   273: ldc 98
    //   275: iconst_1
    //   276: new 100	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 844
    //   286: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: lload_1
    //   290: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 840	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: new 411	java/util/ArrayList
    //   302: dup
    //   303: invokespecial 845	java/util/ArrayList:<init>	()V
    //   306: astore 12
    //   308: aload_3
    //   309: ldc_w 847
    //   312: invokevirtual 851	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   315: astore 13
    //   317: invokestatic 81	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   320: lstore 7
    //   322: aload_0
    //   323: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   326: sipush 154
    //   329: invokevirtual 855	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   332: checkcast 857	com/tencent/mobileqq/apollo/utils/ApolloDaoManager
    //   335: astore_3
    //   336: iconst_0
    //   337: istore 5
    //   339: iconst_0
    //   340: istore 4
    //   342: iload 4
    //   344: aload 13
    //   346: invokevirtual 860	org/json/JSONArray:length	()I
    //   349: if_icmpge +240 -> 589
    //   352: new 415	com/tencent/mobileqq/data/ApolloGameRoamData
    //   355: dup
    //   356: invokespecial 861	com/tencent/mobileqq/data/ApolloGameRoamData:<init>	()V
    //   359: astore 14
    //   361: aload 13
    //   363: iload 4
    //   365: invokevirtual 865	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   368: astore 15
    //   370: aload 14
    //   372: aload 15
    //   374: ldc_w 328
    //   377: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: putfield 416	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   383: aload 14
    //   385: aload 15
    //   387: ldc_w 867
    //   390: invokevirtual 472	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   393: putfield 870	com/tencent/mobileqq/data/ApolloGameRoamData:type	I
    //   396: iload 5
    //   398: istore 6
    //   400: aload 14
    //   402: getfield 870	com/tencent/mobileqq/data/ApolloGameRoamData:type	I
    //   405: iconst_1
    //   406: if_icmpne +162 -> 568
    //   409: iload 5
    //   411: istore 6
    //   413: lload 7
    //   415: lload_1
    //   416: lsub
    //   417: ldc2_w 871
    //   420: lcmp
    //   421: ifge +147 -> 568
    //   424: iload 5
    //   426: istore 6
    //   428: aload_3
    //   429: aload 14
    //   431: getfield 416	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   434: invokevirtual 875	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(I)Lcom/tencent/mobileqq/data/ApolloGameData;
    //   437: ifnull +131 -> 568
    //   440: iconst_1
    //   441: istore 6
    //   443: aload_0
    //   444: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   447: invokevirtual 878	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   450: new 100	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 880
    //   460: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   467: invokevirtual 882	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   470: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: iconst_0
    //   477: invokevirtual 885	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   480: invokeinterface 270 1 0
    //   485: astore 15
    //   487: aload 15
    //   489: ldc_w 887
    //   492: iconst_1
    //   493: invokeinterface 891 3 0
    //   498: pop
    //   499: aload 15
    //   501: ldc_w 893
    //   504: aload 14
    //   506: getfield 416	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   509: invokeinterface 276 3 0
    //   514: pop
    //   515: aload 15
    //   517: invokeinterface 279 1 0
    //   522: pop
    //   523: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +30 -> 556
    //   529: ldc 98
    //   531: iconst_2
    //   532: iconst_2
    //   533: anewarray 4	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: ldc_w 895
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: aload 14
    //   546: getfield 416	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   549: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   552: aastore
    //   553: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   556: aload_0
    //   557: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   560: aload 14
    //   562: getfield 416	com/tencent/mobileqq/data/ApolloGameRoamData:gameId	I
    //   565: invokestatic 896	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   568: aload 12
    //   570: aload 14
    //   572: invokevirtual 897	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   575: pop
    //   576: iload 4
    //   578: iconst_1
    //   579: iadd
    //   580: istore 4
    //   582: iload 6
    //   584: istore 5
    //   586: goto -244 -> 342
    //   589: iload 5
    //   591: ifeq +104 -> 695
    //   594: aload_3
    //   595: getfield 899	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   598: ifnull +97 -> 695
    //   601: aload_3
    //   602: getfield 899	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   605: astore 13
    //   607: aload 13
    //   609: monitorenter
    //   610: aload_3
    //   611: getfield 899	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   614: invokeinterface 345 1 0
    //   619: astore 15
    //   621: aload 15
    //   623: invokeinterface 350 1 0
    //   628: ifeq +64 -> 692
    //   631: aload 15
    //   633: invokeinterface 354 1 0
    //   638: checkcast 901	com/tencent/mobileqq/data/ApolloActionPackage
    //   641: astore 14
    //   643: aload 14
    //   645: getfield 904	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   648: bipush 100
    //   650: if_icmpne -29 -> 621
    //   653: aload 14
    //   655: getfield 908	com/tencent/mobileqq/data/ApolloActionPackage:isUpdate	Z
    //   658: ifne -37 -> 621
    //   661: new 411	java/util/ArrayList
    //   664: dup
    //   665: invokespecial 845	java/util/ArrayList:<init>	()V
    //   668: astore 15
    //   670: aload 14
    //   672: iconst_1
    //   673: putfield 908	com/tencent/mobileqq/data/ApolloActionPackage:isUpdate	Z
    //   676: aload 15
    //   678: aload 14
    //   680: invokeinterface 591 2 0
    //   685: pop
    //   686: aload_3
    //   687: aload 15
    //   689: invokevirtual 911	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	(Ljava/util/List;)V
    //   692: aload 13
    //   694: monitorexit
    //   695: aload_0
    //   696: aload 12
    //   698: aload_3
    //   699: invokevirtual 913	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:g	()Ljava/util/List;
    //   702: invokespecial 915	com/tencent/mobileqq/apollo/ApolloGameManager:a	(Ljava/util/ArrayList;Ljava/util/List;)Z
    //   705: istore 11
    //   707: aload_3
    //   708: invokevirtual 917	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:e	()V
    //   711: aload_3
    //   712: aload 12
    //   714: invokevirtual 920	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	(Ljava/util/ArrayList;)V
    //   717: aload_0
    //   718: getfield 127	com/tencent/mobileqq/apollo/ApolloGameManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   721: lload_1
    //   722: invokestatic 923	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)V
    //   725: iload 11
    //   727: ifeq -642 -> 85
    //   730: invokestatic 927	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   733: new 929	yjt
    //   736: dup
    //   737: aload_0
    //   738: invokespecial 930	yjt:<init>	(Lcom/tencent/mobileqq/apollo/ApolloGameManager;)V
    //   741: invokevirtual 936	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   744: pop
    //   745: return
    //   746: astore_3
    //   747: ldc 98
    //   749: iconst_1
    //   750: new 100	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 938
    //   760: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_3
    //   764: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   767: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: return
    //   777: astore_3
    //   778: aload 13
    //   780: monitorexit
    //   781: aload_3
    //   782: athrow
    //   783: goto -665 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	786	0	this	ApolloGameManager
    //   0	786	1	paramLong	long
    //   0	786	3	paramString	String
    //   134	447	4	i	int
    //   337	253	5	j	int
    //   398	185	6	k	int
    //   125	289	7	l1	long
    //   159	50	9	l2	long
    //   705	21	11	bool	boolean
    //   94	619	12	localObject1	Object
    //   359	320	14	localObject3	Object
    //   368	320	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   86	105	746	java/lang/Exception
    //   109	118	746	java/lang/Exception
    //   118	154	746	java/lang/Exception
    //   154	161	746	java/lang/Exception
    //   169	192	746	java/lang/Exception
    //   192	254	746	java/lang/Exception
    //   262	336	746	java/lang/Exception
    //   342	396	746	java/lang/Exception
    //   400	409	746	java/lang/Exception
    //   428	440	746	java/lang/Exception
    //   443	556	746	java/lang/Exception
    //   556	568	746	java/lang/Exception
    //   568	576	746	java/lang/Exception
    //   594	610	746	java/lang/Exception
    //   695	725	746	java/lang/Exception
    //   730	745	746	java/lang/Exception
    //   781	783	746	java/lang/Exception
    //   610	621	777	finally
    //   621	692	777	finally
    //   692	695	777	finally
    //   778	781	777	finally
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[onAddOrDelRespFromSvr], ret:" + paramLong + ",cmd:" + paramString1 + ",resp:" + paramString2 + ",reqData:" + paramString3);
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        paramString3 = new JSONObject(paramString3);
        JSONArray localJSONArray = paramString3.optJSONArray("gameIdList");
        paramString3 = paramString3.optString("from");
        if (("android.web".equals(paramString3)) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
        {
          localObject = (OnAddOrDeleGameListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ApolloGameUtil.a((OnAddOrDeleGameListener)localObject, paramLong, paramString1);
          }
        }
        if (0L != paramLong)
        {
          QLog.i("ApolloGameManager", 1, "fail to add or del, ret:" + paramLong);
          return;
        }
        localObject = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
          localApolloGameRoamData.gameId = localJSONArray.getInt(i);
          ((ArrayList)localObject).add(localApolloGameRoamData);
          i += 1;
          continue;
        }
        paramLong = new JSONObject(paramString2).getJSONObject("data").optLong("timeStamp");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "ts:" + paramLong);
        }
        paramString2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        if ("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1))
        {
          paramString2.b((ArrayList)localObject);
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit();
          paramString1.putBoolean("is_add_new_game" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            paramString2 = (ApolloGameRoamData)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            if (paramString2 != null)
            {
              paramString1.putInt("new_added_game_id" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2.gameId);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameManager", 2, new Object[] { "[onAddOrDelRespFromSvr] game id=", Integer.valueOf(paramString2.gameId) });
              }
            }
          }
          paramString1.commit();
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
          ThreadManager.getUIHandler().post(new yju(this));
          i = -1;
          if (!"android.web".equals(paramString3)) {
            break label648;
          }
          i = 1;
          if (-1 == i) {
            break;
          }
          paramString1 = ((ArrayList)localObject).iterator();
          if (!paramString1.hasNext()) {
            break;
          }
          paramString2 = (ApolloGameRoamData)paramString1.next();
          if (paramString2 == null) {
            continue;
          }
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "add_game", i, 0, new String[] { Integer.toString(paramString2.gameId) });
          continue;
        }
        if (!"apollo_aio_game.del_games_from_user_gamepanel".equals(paramString1)) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloGameManager", 1, "[onAddOrDelRespFromSvr], errInfo->" + paramString1.getMessage());
        return;
      }
      paramString2.a((ArrayList)localObject);
      continue;
      label648:
      if ("android.playgame".equals(paramString3))
      {
        i = 0;
      }
      else
      {
        boolean bool = "android.wechat".equals(paramString3);
        if (bool) {
          i = 2;
        }
      }
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramIntent != null) && (paramIntent.hasExtra("launchApolloGame")) && (paramIntent.getBooleanExtra("launchApolloGame", false)))
    {
      int i = paramIntent.getIntExtra("gameId", -1);
      int j = paramIntent.getIntExtra("gameMode", 0);
      int k = paramIntent.getIntExtra("enter", -1);
      String str = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[launchApolloGame] start launchGame:gameId = " + i + ";gameMode = " + j + ";friendUin = " + str);
      }
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      paramIntent.putExtra("launchApolloGame", false);
      if (BaseActivity.sTopActivity != null)
      {
        paramIntent = new CmGameStartChecker.StartCheckParam(i, true, "launch", 0L, k, j, paramInt, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, str), str, 205);
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
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList)
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
              ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localInteger.intValue());
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
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramString2, paramString1, -1L, 1);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[reqUsrGameList]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    try
    {
      Object localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(str)) {
        break label222;
      }
      d();
      VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (((ApolloManager)localObject).b(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "[reqUsrGameList] old command");
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_user_gamepanel_gamelist_v2");
        ((JSONObject)localObject).put("from", "android.aio");
        ((JSONObject)localObject).put("timeStamp", ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        localObject = ((JSONObject)localObject).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "[reqUsrGameList], reqStr:" + (String)localObject);
        }
        localVasExtensionHandler.a("apollo_aio_game.get_user_gamepanel_gamelist_v2", (String)localObject, -1L, 2);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("ApolloGameManager", 1, "[reqUsrGameList], errInfo->" + localException.getMessage());
      return;
    }
    localException.b();
    return;
    label222:
    QLog.e("ApolloGameManager", 1, "uin empty");
  }
  
  public void f()
  {
    int i = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000.0D) - this.e;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "[tryUpdateGameJson], gameJsonUpdate Interval:", Integer.valueOf(i), ",mGameJsonUpdateInterval:", Long.valueOf(this.jdField_b_of_type_Long) });
    }
    if (i < this.jdField_b_of_type_Long) {
      return;
    }
    QLog.i("ApolloGameManager", 1, "Time is up, try to send a requst to update game json.");
    ThreadManager.remove(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
          } while (!(paramMessage.obj instanceof MessageForApollo));
          paramMessage = (MessageForApollo)paramMessage.obj;
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this.jdField_b_of_type_JavaLangRefWeakReference, this.jdField_c_of_type_JavaLangRefWeakReference);
          return true;
          localObject = (Object[])paramMessage.obj;
        } while ((localObject == null) || (localObject.length < 2));
        paramMessage = (String)localObject[0];
        Object localObject = (MessageForApollo)localObject[1];
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        a(localArrayList, paramMessage);
        return true;
        ApolloSoLoader.a("AIO");
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
            localObject = (String)paramMessage[2];
            paramMessage = null;
            if ((1 == i) || (3 == i))
            {
              paramMessage = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (String)localObject, j, i);
              if ((paramMessage == null) || (paramMessage.size() <= 0)) {
                break;
              }
              a(paramMessage, "aio");
              return true;
            }
          }
          catch (Throwable paramMessage)
          {
            QLog.e("ApolloGameManager", 1, paramMessage, new Object[0]);
            return true;
          }
          if (2 == i) {
            paramMessage = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Long);
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      paramMessage = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean("force_parse_gamejson_once7.6.3", false));
    paramMessage.c();
    QLog.i("ApolloGameManager", 1, "force to parse game json once!!!");
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Int = -1;
    g();
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      if (this.jdField_a_of_type_Yjv != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Yjv);
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameManager
 * JD-Core Version:    0.7.0.1
 */