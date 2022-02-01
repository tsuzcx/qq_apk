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
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.TreeSet;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class amyv
  implements amzu
{
  public amri a;
  amyw jdField_a_of_type_Amyw = new amyw(this);
  private anaf jdField_a_of_type_Anaf;
  private bkys jdField_a_of_type_Bkys;
  public CmGameStartChecker.StartCheckParam a;
  public CmGameInitParams a;
  public WeakReference<Context> a;
  public Set<String> a;
  public boolean a;
  private WeakReference<BaseChatPie> b;
  
  public amyv(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_JavaUtilSet = new TreeSet();
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null)
    {
      String str = localBaseChatPie.getSessionInfo().curFriendUin;
      this.jdField_a_of_type_JavaUtilSet.add(str);
      this.b = new WeakReference(localBaseChatPie);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Amri = new amri();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    paramActivity = new anaf(paramActivity, paramStartCheckParam);
    paramActivity.a(this);
    this.jdField_a_of_type_Anaf = paramActivity;
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this.jdField_a_of_type_Anaf);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static amyv a()
  {
    return amwn.a();
  }
  
  public static amyv a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = a();
    }
    amyv localamyv;
    do
    {
      return localObject;
      localamyv = a();
      if ((localamyv == null) || (localamyv.jdField_a_of_type_JavaUtilSet == null)) {
        break;
      }
      localObject = localamyv;
    } while (localamyv.jdField_a_of_type_JavaUtilSet.contains(paramString));
    return null;
  }
  
  private BaseChatPie a()
  {
    Object localObject = amwn.a();
    if (localObject != null)
    {
      localObject = (amme)((AppInterface)localObject).getManager(QQManagerFactory.APOLLO_MANAGER);
      if (localObject != null)
      {
        localObject = ((amme)localObject).a();
        if (localObject != null) {
          return (BaseChatPie)((WeakReference)localObject).get();
        }
      }
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    amyv localamyv = a();
    if ((localamyv != null) && (localamyv.jdField_a_of_type_JavaUtilSet != null)) {
      localamyv.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "onShare2Aio currentApolloGame:" + localamyv + ",aioUin:" + paramString);
    }
  }
  
  public static void i()
  {
    amyv localamyv = a();
    if ((localamyv != null) && (localamyv.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", 3, 0, new String[] { localamyv.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + "" });
    }
  }
  
  public QQAppInterface a()
  {
    AppInterface localAppInterface = amwn.a();
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
    } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.getUIHandler() != null));
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.a(paramActivity);
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
        AppInterface localAppInterface = amwn.a();
        if (localAppInterface == null) {
          break;
        }
        if (((aoan)localAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(Long.parseLong((String)localObject))))
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
    if (this.jdField_a_of_type_Bkys != null)
    {
      this.jdField_a_of_type_Bkys.sendEmptyMessage(18);
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
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    this.jdField_a_of_type_Bkys.obtainMessage(21).sendToTarget();
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
        localObject1 = amwn.a();
        if (!(localObject1 instanceof QQAppInterface)) {
          return;
        }
        localObject2 = new SessionInfo();
        localObject3 = a();
        if (localObject3 != null)
        {
          localObject2 = ((BaseChatPie)localObject3).sessionInfo;
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
      ((SessionInfo)localObject2).curType = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType;
      ((SessionInfo)localObject2).troopUin = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin;
      QLog.w("cmgame_process.CmGameMainManager", 1, "basechatpie is null.");
    }
    int i = localJSONObject.optInt("gameId");
    Object localObject3 = localJSONObject.optString("uin");
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], uin is null");
      return;
    }
    this.jdField_a_of_type_Amri.b();
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
            break label804;
          }
        }
      }
    }
    label795:
    label804:
    for (paramString = ContactUtils.getTroopMemberNameWithoutRemark(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin, (String)localObject3);; paramString = null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = ((anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject3);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Friends)localObject1).getFriendNick();; localObject1 = paramString)
      {
        paramString = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = ContactUtils.getBuddyNickName(localQQAppInterface, (String)localObject3, true);
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
          paramString = this.jdField_a_of_type_Bkys.obtainMessage(26);
          paramString.obj = localObject1;
          paramString.sendToTarget();
        }
        long l = localJSONObject.optLong("roomId");
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (0L != l)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = l;
        }
        int j = localJSONObject.optInt("gameMode");
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "join_game", ApolloUtil.a((SessionInfo)localObject2, localQQAppInterface), 0, new String[] { "" + i, "", "", "" + l });
        this.jdField_a_of_type_Amri.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_Amri.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Amri.jdField_c_of_type_Int = j;
        localObject2 = (ankc)localQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
        localObject1 = ((ankc)localObject2).a(i);
        paramString = anvx.a(2131701604);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ApolloGameData)localObject1).name)))
        {
          localObject2 = ((ankc)localObject2).a(((ApolloGameData)localObject1).actionId);
          if (localObject2 == null) {
            break label795;
          }
          paramString = ((ApolloActionData)localObject2).actionName;
        }
        for (;;)
        {
          i = ((ApolloGameData)localObject1).actionId;
          this.jdField_a_of_type_Amri.jdField_b_of_type_JavaLangString = ((ApolloGameData)localObject1).name;
          for (;;)
          {
            this.jdField_a_of_type_Amri.jdField_a_of_type_JavaLangString = paramString;
            this.jdField_a_of_type_Amri.jdField_b_of_type_Int = i;
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
            this.jdField_a_of_type_Amri.jdField_b_of_type_JavaLangString = anvx.a(2131701605);
            i = 0;
          }
          this.jdField_a_of_type_Amri.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).toString();
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
          paramString = ((ankc)((QQAppInterface)localObject1).getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
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
        this.jdField_a_of_type_Amyw.jdField_a_of_type_Int = paramString.gameId;
        this.jdField_a_of_type_Amyw.jdField_b_of_type_Int = paramInt;
        ((WtloginManager)localObject1).getOpenKeyWithoutPasswd((String)localObject2, 16L, paramString.appId, this.jdField_a_of_type_Amyw);
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
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    this.jdField_a_of_type_Bkys.obtainMessage(22).sendToTarget();
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
              ApolloGameUtil.a(paramString.app, i);
            }
            if ((paramString != null) && (paramString.mApolloPanel != null))
            {
              paramString.mApolloPanel.p();
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
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.e();
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
      } while (((paramString != null) && (paramString.app != null) && (paramString.getUIHandler() == null)) || (paramString == null) || (paramString.sessionInfo == null));
      localQQAppInterface = paramString.getApp();
    } while (localQQAppInterface == null);
    ApolloGameUtil.a(localQQAppInterface, paramString.sessionInfo.curFriendUin);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.f();
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage(28);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.d();
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = ApolloUtil.a(paramString, "roomId");
    }
    Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage(23);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.c();
    }
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    this.jdField_a_of_type_Bkys.removeMessages(19);
    this.jdField_a_of_type_Bkys.removeMessages(20);
    Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage(19);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    b(paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Anaf != null) {
      this.jdField_a_of_type_Anaf.b();
    }
  }
  
  public void h(String paramString)
  {
    this.jdField_a_of_type_Anaf.a(true);
    c(paramString);
    paramString = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      AppInterface localAppInterface = amwn.a();
      if (localAppInterface != null) {
        paramString.edit().putBoolean("is_ever_play_cmgame" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + localAppInterface.getCurrentAccountUin(), true).commit();
      }
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Bkys == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage(17);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = null;
    this.jdField_a_of_type_Amri = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    this.jdField_a_of_type_JavaUtilSet = null;
    if (this.jdField_a_of_type_Anaf != null)
    {
      this.jdField_a_of_type_Anaf.b();
      this.jdField_a_of_type_Anaf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyv
 * JD-Core Version:    0.7.0.1
 */