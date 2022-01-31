package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.interfaces.OnApolloGameListener;
import com.tencent.mobileqq.apollo.process.ui.CmGameUIManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import mqq.manager.WtloginManager;
import org.json.JSONObject;
import yrq;

public class CmGameMainManager
  implements OnApolloGameListener
{
  public CmGameStartChecker.StartCheckParam a;
  public CmGameInitParams a;
  private CmGameUIManager jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager;
  public ApolloPanel.GameMsgInfo a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public WeakReference a;
  public Set a;
  yrq jdField_a_of_type_Yrq = new yrq(this);
  public boolean a;
  private WeakReference b;
  
  public CmGameMainManager(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_JavaUtilSet = new TreeSet();
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null)
    {
      String str = localBaseChatPie.a().jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilSet.add(str);
      this.b = new WeakReference(localBaseChatPie);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo = new ApolloPanel.GameMsgInfo();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    paramActivity = new CmGameUIManager(paramActivity, paramStartCheckParam);
    paramActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager = paramActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private BaseChatPie a()
  {
    Object localObject = CmGameUtil.a();
    if (localObject != null)
    {
      localObject = (ApolloManager)((AppInterface)localObject).getManager(152);
      if (localObject != null)
      {
        localObject = ((ApolloManager)localObject).a();
        if (localObject != null) {
          return (BaseChatPie)((WeakReference)localObject).get();
        }
      }
    }
    return null;
  }
  
  public static CmGameMainManager a()
  {
    return CmGameUtil.a();
  }
  
  public static CmGameMainManager a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = a();
    }
    CmGameMainManager localCmGameMainManager;
    do
    {
      return localObject;
      localCmGameMainManager = a();
      if ((localCmGameMainManager == null) || (localCmGameMainManager.jdField_a_of_type_JavaUtilSet == null)) {
        break;
      }
      localObject = localCmGameMainManager;
    } while (localCmGameMainManager.jdField_a_of_type_JavaUtilSet.contains(paramString));
    return null;
  }
  
  public static void a(String paramString)
  {
    CmGameMainManager localCmGameMainManager = a();
    if (localCmGameMainManager != null) {
      localCmGameMainManager.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "onShare2Aio currentApolloGame:" + localCmGameMainManager + ",aioUin:" + paramString);
    }
  }
  
  public static void f()
  {
    CmGameMainManager localCmGameMainManager = a();
    if ((localCmGameMainManager != null) && (localCmGameMainManager.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", 3, 0, new String[] { localCmGameMainManager.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId + "" });
    }
  }
  
  public QQAppInterface a()
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return null;
    }
    return (QQAppInterface)localAppInterface;
  }
  
  public void a()
  {
    if (this.b == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.b.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.a() != null));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.a(paramActivity);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new JSONObject();
        localObject = ((JSONObject)localObject).getString("puin");
        AppInterface localAppInterface = CmGameUtil.a();
        if (localAppInterface == null) {
          break;
        }
        if (((PublicAccountDataManager)localAppInterface.getManager(55)).a(Long.valueOf(Long.parseLong((String)localObject))))
        {
          i = 1;
          paramString.put("is_follow", i);
          CmGameCmdChannel.a(((BaseChatPie)this.b.get()).a()).a(0, "cs.check_pubAccount_state.local", paramString.toString(), paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "CHECK_FOLLOW_STATE error:", paramString);
        return;
      }
      int i = 0;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "showCurrentGameView");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.a();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(18);
      return true;
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (paramActivity != null) && (paramActivity.getClass() != ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getClass()))
    {
      Intent localIntent = new Intent(paramActivity, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getClass());
      localIntent.addFlags(131072);
      paramActivity.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameMainManager", 2, new Object[] { "[resumeGameContext] from ", paramActivity, this.jdField_a_of_type_JavaLangRefWeakReference.get() });
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(21).sendToTarget();
  }
  
  public void b(String paramString)
  {
    Object localObject1;
    SessionInfo localSessionInfo;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localObject1 = CmGameUtil.a();
        if (!(localObject1 instanceof QQAppInterface)) {
          return;
        }
        localSessionInfo = new SessionInfo();
        localObject2 = a();
        if (localObject2 != null)
        {
          localSessionInfo = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          localQQAppInterface = (QQAppInterface)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameMainManager", 2, new Object[] { "[onJoinRoom],", paramString });
          }
          localJSONObject = new JSONObject(paramString);
          i = localJSONObject.optInt("retcode");
          if (i == 0) {
            break;
          }
          QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], retCode is 0, fail to joinroom, return. retCode:" + i);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], json error ", paramString);
        return;
      }
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType;
      localSessionInfo.b = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin;
      QLog.w("cmgame_process.CmGameMainManager", 1, "basechatpie is null.");
    }
    int i = localJSONObject.optInt("gameId");
    Object localObject2 = localJSONObject.optString("uin");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], uin is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.b();
    if (!((String)localObject2).equals(localQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameMainManager", 2, "[onJoinRoom], uin:" + (String)localObject2 + "jionroom, show JionRoom Tips");
      }
      localObject1 = null;
      paramString = (String)localObject1;
      if (localQQAppInterface != null)
      {
        paramString = (String)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionType != 1) {
            break label875;
          }
        }
      }
    }
    label862:
    label875:
    for (paramString = ContactUtils.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin, (String)localObject2);; paramString = null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = ((FriendsManager)localQQAppInterface.getManager(50)).a((String)localObject2);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Friends)localObject1).getFriendNick();; localObject1 = paramString)
      {
        paramString = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = ContactUtils.c(localQQAppInterface, (String)localObject2, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameMainManager", 2, "handleMessage MSG_CODE_JION_ROOM, nickName:" + paramString);
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = localObject2;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(26);
          paramString.obj = localObject1;
          paramString.sendToTarget();
        }
        try
        {
          paramString = (ApolloGameManager)localQQAppInterface.getManager(210);
          if (paramString != null)
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(Integer.valueOf(i));
            paramString.a("android.playgame", "apollo_aio_game.add_games_to_user_gamepanel", (ArrayList)localObject1);
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            long l;
            int j;
            QLog.e("cmgame_process.CmGameMainManager", 1, "errInfo->" + paramString.getMessage());
            continue;
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_e_of_type_JavaLangString = "厘米互动";
            paramString = "厘米互动";
            i = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_f_of_type_JavaLangString = ((JSONObject)localObject1).toString();
          return;
        }
        l = localJSONObject.optLong("roomId");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (0L != l)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = l;
        }
        j = localJSONObject.optInt("gameMode");
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "join_game", ApolloUtil.a(localSessionInfo, localQQAppInterface), 0, new String[] { "" + i, "", "", "" + l });
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_e_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.b = l;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.g = j;
        paramString = (ApolloDaoManager)localQQAppInterface.getManager(154);
        localObject1 = paramString.a(i);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ApolloGameData)localObject1).name)))
        {
          paramString = paramString.a(((ApolloGameData)localObject1).actionId);
          if (paramString == null) {
            break label862;
          }
        }
        for (paramString = paramString.actionName;; paramString = "厘米互动")
        {
          i = ((ApolloGameData)localObject1).actionId;
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_e_of_type_JavaLangString = ((ApolloGameData)localObject1).name;
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.d = paramString;
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_f_of_type_Int = i;
          paramString = localJSONObject.optString("extendInfo");
          localObject1 = new JSONObject();
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          ((JSONObject)localObject1).put("extendInfo", paramString);
          if (paramString.length() >= 100)
          {
            QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom],extendInfo is too long, extendInfo:" + paramString);
            return;
          }
        }
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject2 = new JSONObject();
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        try
        {
          int i = new JSONObject(paramString).getInt("gameId");
          paramString = ((ApolloDaoManager)((QQAppInterface)localObject1).getManager(154)).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
          if ((i != this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId) || ((paramString != null) && (paramString.needOpenKey != 1)))
          {
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameMainManager", 1, "ON_GET_OPEN_KEY error:", paramString);
          return;
        }
        if ((paramString == null) || (System.currentTimeMillis() - paramString.lastRequestOpenKey <= 3600000L)) {
          break;
        }
        localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        localObject1 = (WtloginManager)((QQAppInterface)localObject1).getManager(1);
        this.jdField_a_of_type_Yrq.jdField_a_of_type_Int = paramString.gameId;
        this.jdField_a_of_type_Yrq.b = paramInt;
        ((WtloginManager)localObject1).GetOpenKeyWithoutPasswd((String)localObject2, 16L, paramString.appId, this.jdField_a_of_type_Yrq);
        paramString.lastRequestOpenKey = System.currentTimeMillis();
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameMainManager", 2, "do get open key.");
      return;
    } while (paramString == null);
    ((JSONObject)localObject2).put("appId", paramString.appId);
    ((JSONObject)localObject2).put("gameId", paramString.gameId);
    ((JSONObject)localObject2).put("openKey", paramString.openKey);
    CmGameCmdChannel.a((QQAppInterface)localObject1).a(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(22).sendToTarget();
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("resp");
      if (paramString != null)
      {
        this.jdField_a_of_type_Boolean = true;
        paramString = paramString.optJSONObject("data");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("userInfo");
          if (paramString != null)
          {
            int i = paramString.optInt("remainPlays");
            if (this.b == null) {
              return;
            }
            paramString = (BaseChatPie)this.b.get();
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameMainManager", 2, "onStartGame, game coin count=" + i);
            }
            if (paramString != null) {
              ApolloGameUtil.a(paramString.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
            }
            if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null))
            {
              paramString.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.o();
              return;
            }
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameMainManager", 2, "onStartGame error " + paramString.toString());
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.c();
    }
  }
  
  public void d(String paramString)
  {
    if (this.b == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        paramString = (BaseChatPie)this.b.get();
      } while (((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString.a() == null)) || (paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      localQQAppInterface = paramString.a();
    } while (localQQAppInterface == null);
    ApolloGameUtil.a(localQQAppInterface, paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.b();
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(28);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = ApolloUtil.a(paramString, "roomId");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(23);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    this.jdField_a_of_type_JavaUtilSet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.a();
    }
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(19);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(20);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(19);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    b(paramString);
  }
  
  public void h(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.a(true);
    c(paramString);
    paramString = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      AppInterface localAppInterface = CmGameUtil.a();
      if (localAppInterface != null) {
        paramString.edit().putBoolean("is_ever_play_cmgame" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId + localAppInterface.getCurrentAccountUin(), true).commit();
      }
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(17);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void j(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    for (;;)
    {
      return;
      try
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localContext != null)
        {
          paramString = new JSONObject(paramString).getString("puin");
          Intent localIntent = new Intent(localContext, AccountDetailActivity.class);
          localIntent.putExtra("uin", paramString);
          localIntent.putExtra("report_src_param_type", "");
          localIntent.putExtra("report_src_param_name", "");
          localIntent.setFlags(67108864);
          localContext.startActivity(localIntent);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "ENTER_PUBACCOUNT_CARD error:", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameMainManager
 * JD-Core Version:    0.7.0.1
 */