package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.interfaces.OnApolloGameListener;
import com.tencent.mobileqq.apollo.process.ui.CmGameUIManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.TreeSet;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class CmGameMainManager
  implements OnApolloGameListener
{
  public ApolloGameMsgInfo a;
  public CmGameStartChecker.StartCheckParam a;
  public CmGameInitParams a;
  CmGameMainManager.OpenKeyObserver jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager$OpenKeyObserver = new CmGameMainManager.OpenKeyObserver(this);
  private CmGameUIManager jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public WeakReference<Context> a;
  public Set<String> a;
  public boolean a;
  private WeakReference<BaseChatPie> b;
  
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
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo = new ApolloGameMsgInfo();
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
      localObject = (ApolloManagerServiceImpl)((AppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if (localObject != null)
      {
        localObject = ((ApolloManagerServiceImpl)localObject).getGameChatPieRef();
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
    if ((localCmGameMainManager != null) && (localCmGameMainManager.jdField_a_of_type_JavaUtilSet != null)) {
      localCmGameMainManager.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "onShare2Aio currentApolloGame:" + localCmGameMainManager + ",aioUin:" + paramString);
    }
  }
  
  public static void i()
  {
    CmGameMainManager localCmGameMainManager = a();
    if ((localCmGameMainManager != null) && (localCmGameMainManager.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", 3, 0, new String[] { localCmGameMainManager.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + "" });
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
        if (((PublicAccountDataManager)localAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(Long.parseLong((String)localObject))))
        {
          i = 1;
          paramString.put("is_follow", i);
          CmGameCmdChannel.a((QQAppInterface)localAppInterface).a(0, "cs.check_pubAccount_state.local", paramString.toString(), paramInt);
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
    Object localObject2;
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
        localObject2 = new SessionInfo();
        localObject3 = a();
        if (localObject3 != null)
        {
          localObject2 = ((BaseChatPie)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
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
      ((SessionInfo)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType;
      ((SessionInfo)localObject2).b = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin;
      QLog.w("cmgame_process.CmGameMainManager", 1, "basechatpie is null.");
    }
    int i = localJSONObject.optInt("gameId");
    Object localObject3 = localJSONObject.optString("uin");
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], uin is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.init();
    if (!((String)localObject3).equals(localQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameMainManager", 2, "[onJoinRoom], uin:" + (String)localObject3 + "jionroom, show JionRoom Tips");
      }
      localObject1 = null;
      paramString = (String)localObject1;
      if (localQQAppInterface != null)
      {
        paramString = (String)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionType != 1) {
            break label817;
          }
        }
      }
    }
    label808:
    label817:
    for (paramString = ContactUtils.d(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin, (String)localObject3);; paramString = null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject3);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Friends)localObject1).getFriendNick();; localObject1 = paramString)
      {
        paramString = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = ContactUtils.d(localQQAppInterface, (String)localObject3, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameMainManager", 2, "handleMessage MSG_CODE_JION_ROOM, nickName:" + paramString);
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = localObject3;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(26);
          paramString.obj = localObject1;
          paramString.sendToTarget();
        }
        long l = localJSONObject.optLong("roomId");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (0L != l)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = l;
        }
        int j = localJSONObject.optInt("gameMode");
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "join_game", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionTypeByContext((SessionInfo)localObject2, localQQAppInterface), 0, new String[] { "" + i, "", "", "" + l });
        this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.gameId = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.roomId = l;
        this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.gameMode = j;
        localObject2 = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).findGameById(i);
        paramString = HardCodeUtil.a(2131702159);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ApolloGameData)localObject1).name)))
        {
          localObject2 = ((ApolloDaoManagerServiceImpl)localObject2).findActionById(((ApolloGameData)localObject1).actionId);
          if (localObject2 == null) {
            break label808;
          }
          paramString = ((ApolloActionData)localObject2).actionName;
        }
        for (;;)
        {
          i = ((ApolloGameData)localObject1).actionId;
          this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.gameName = ((ApolloGameData)localObject1).name;
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.actionName = paramString;
            this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.actionId = i;
            paramString = localJSONObject.optString("extendInfo");
            localObject1 = new JSONObject();
            if (TextUtils.isEmpty(paramString)) {
              return;
            }
            ((JSONObject)localObject1).put("extendInfo", paramString);
            if (paramString.length() < 100) {
              break;
            }
            QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom],extendInfo is too long, extendInfo:" + paramString);
            return;
            this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.gameName = HardCodeUtil.a(2131702160);
            i = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo.gameExtendJson = ((JSONObject)localObject1).toString();
          return;
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
          paramString = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
          if ((i != this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) || ((paramString != null) && (paramString.needOpenKey != 1)))
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
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager$OpenKeyObserver.jdField_a_of_type_Int = paramString.gameId;
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager$OpenKeyObserver.b = paramInt;
        ((WtloginManager)localObject1).getOpenKeyWithoutPasswd((String)localObject2, 16L, paramString.appId, this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameMainManager$OpenKeyObserver);
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
            if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null))
            {
              paramString.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.m();
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
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.e();
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
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.f();
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
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.d();
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = ApolloUtilImpl.getJsonLongValue(paramString, "roomId");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(23);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.c();
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
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.b();
    }
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
        paramString.edit().putBoolean("is_ever_play_cmgame" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + localAppInterface.getCurrentAccountUin(), true).commit();
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
  
  public void j()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameMsgInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    this.jdField_a_of_type_JavaUtilSet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.b();
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameUIManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameMainManager
 * JD-Core Version:    0.7.0.1
 */