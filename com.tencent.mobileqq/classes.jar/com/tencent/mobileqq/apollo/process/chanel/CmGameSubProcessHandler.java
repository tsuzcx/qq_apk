package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.IRequestHandler;
import com.tencent.mobileqq.apollo.aioChannel.ChannelConst;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import yrd;
import yre;
import yrf;

public class CmGameSubProcessHandler
  implements ApolloCmdChannel.IRequestHandler
{
  private int jdField_a_of_type_Int;
  private ApolloGameInvitation jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation;
  private ApolloGameShare jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  
  public CmGameSubProcessHandler(int paramInt, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation = new ApolloGameInvitation(CmGameUtil.a(), paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare = new ApolloGameShare(paramActivity, CmGameUtil.a());
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new yrd(this, paramString));
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_JavaUtilRegexPattern == null)
        {
          Object localObject = CmGameUtil.a();
          if (localObject != null)
          {
            localObject = ((CmGameManager)localObject).a(this.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "isValidSsoCmd cmd:" + paramString + ", rule: " + (String)localObject);
            }
            this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile((String)localObject);
          }
        }
      } while (this.jdField_a_of_type_JavaUtilRegexPattern == null);
      bool2 = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches();
      bool1 = bool2;
    } while (bool2);
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "ssoCmdRule,fail to match sso cmd, cmd:" + paramString + ", gameId: " + this.jdField_a_of_type_Int);
    return bool2;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!ChannelConst.a(paramString1)) && (a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "ssoCmdRule, [game],cmd:" + paramString1);
      }
      try
      {
        paramString2 = new JSONObject(paramString2);
        paramString2.put("from", "cmshow_game_" + paramString2.optInt("gameId"));
        paramString2 = paramString2.toString();
        CmGameSSoHandler localCmGameSSoHandler = CmGameUtil.a();
        if (localCmGameSSoHandler != null) {
          localCmGameSSoHandler.a(paramString1, paramString2, paramLong, 4);
        }
        return true;
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[onFirstFrameDrawn]");
    }
    Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        Activity localActivity = ((CmGameLauncher)localObject).a();
        if ((localActivity instanceof ApolloGameActivity)) {
          ((ApolloGameActivity)localActivity).a(0L);
        }
        localObject = ((CmGameLauncher)localObject).a();
      } while (localObject == null);
      l = ((CmGameStartChecker.StartCheckParam)localObject).startT;
    } while (l <= 0L);
    long l = System.currentTimeMillis() - l;
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "cost:" + l);
    if (l > 20000L)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "sth must be wrong because it's too long.");
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "start_game_time_cost", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int), String.valueOf(l) });
    ((CmGameStartChecker.StartCheckParam)localObject).startT = -1L;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new yre(this, paramString));
  }
  
  private void c()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      CmGameUtil.a(this.jdField_a_of_type_Int, localActivity);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation == null) {}
    for (;;)
    {
      return;
      String str = "";
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        str = new JSONObject(paramString).optString("wording");
        CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
        if (localCmGameLauncher != null)
        {
          ApolloPanel.GameMsgInfo localGameMsgInfo2 = localCmGameLauncher.a();
          ApolloPanel.GameMsgInfo localGameMsgInfo1;
          if ((localGameMsgInfo2 != null) && (localGameMsgInfo2.b != 0L))
          {
            localGameMsgInfo1 = localGameMsgInfo2;
            if (localGameMsgInfo2.jdField_e_of_type_Int != 0) {}
          }
          else
          {
            localGameMsgInfo1 = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation.a(paramString);
          }
          if (localGameMsgInfo1 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation.a(localGameMsgInfo1);
            this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation.a(str);
            ThreadManager.getUIHandler().post(new yrf(this));
            paramString = localCmGameLauncher.a();
            if (paramString != null)
            {
              VipUtils.a(null, "cmshow", "Apollo", "clk_invite", 0, 0, new String[] { paramString.mGameName });
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[inviteFriends], errInfo->" + paramString.getMessage());
      }
    }
  }
  
  private void d()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void d(String paramString)
  {
    CmGameLauncher localCmGameLauncher;
    ApolloPanel.GameMsgInfo localGameMsgInfo;
    try
    {
      localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (localCmGameLauncher == null) {
        return;
      }
      localGameMsgInfo = localCmGameLauncher.a();
      paramString = new JSONObject(paramString);
      i = paramString.optInt("retcode");
      if (i != 0)
      {
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onJoinRoom], retCode is 0, fail to joinroom, return. retCode:" + i);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
      return;
    }
    int i = paramString.optInt("gameId");
    localGameMsgInfo.b();
    long l = paramString.optLong("roomId");
    int j = paramString.optInt("gameMode");
    localGameMsgInfo.jdField_e_of_type_Int = i;
    localGameMsgInfo.b = l;
    localGameMsgInfo.g = j;
    localGameMsgInfo.jdField_f_of_type_JavaLangString = paramString.optString("extendInfo");
    paramString = localCmGameLauncher.a();
    if (paramString != null)
    {
      paramString.mRoomId = l;
      localGameMsgInfo.jdField_e_of_type_JavaLangString = paramString.mChineseName;
      localGameMsgInfo.jdField_f_of_type_Int = paramString.mActionId;
    }
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "save game msginfo.");
  }
  
  private void e(String paramString)
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if (localAppInterface != null) {
      ApolloGameBasicEventUtil.a(localAppInterface, paramString);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleCmd], cmd:", paramString1 });
    }
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if ((localCmGameLauncher == null) || (localCmGameLauncher.a() == null)) {
      return new HandleResult();
    }
    if (localCmGameLauncher.a().getLuaState() != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "abandon it, not the same jsState.");
      }
      return new HandleResult();
    }
    if (a(paramString1, paramString2, paramLong)) {
      return new HandleResult();
    }
    if ("cs.join_room.local".equals(paramString1)) {
      d(paramString2);
    }
    for (;;)
    {
      return new HandleResult();
      if ("cs.make_room_min.local".equals(paramString1)) {
        c();
      } else if ("cs.close_room.local".equals(paramString1)) {
        d();
      } else if ("cs.report_data_2_compass.local".equals(paramString1)) {
        e(paramString2);
      } else if ("cs.invite_friends.local".equals(paramString1)) {
        c(paramString2);
      } else if ("cs.share_game_result.local".equals(paramString1)) {
        b(paramString2);
      } else if ("cs.share_pic.local".equals(paramString1)) {
        a(paramString2);
      } else if ("cs.first_frame_drawn.local".equals(paramString1)) {
        b();
      } else if ("cs.apolloGameWebMessage.local".equals(paramString1)) {
        ApolloGameBasicEventUtil.a(paramString2);
      } else if ("cs.openWebViewWithoutUrl.local".equals(paramString1)) {
        ApolloGameBasicEventUtil.a(a(), paramString2);
      } else if ("cs.share_game_in_ark.local".equals(paramString1)) {
        ApolloGameBasicEventUtil.a(this.jdField_a_of_type_Int, paramString2, a());
      }
    }
  }
  
  public void a() {}
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler
 * JD-Core Version:    0.7.0.1
 */