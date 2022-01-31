package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.IRequestHandler;
import com.tencent.mobileqq.apollo.aioChannel.ChannelConst;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.RedPacketInfo;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation;
import com.tencent.mobileqq.apollo.utils.ApolloGameShare;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import yxm;
import yxn;
import yxo;

public class CmGameSubProcessHandler
  implements ApolloCmdChannel.IRequestHandler
{
  private int jdField_a_of_type_Int;
  private ApolloGameInvitation jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation;
  private ApolloGameShare jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private int b;
  
  public CmGameSubProcessHandler(int paramInt, Activity paramActivity)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameInvitation = new ApolloGameInvitation(CmGameUtil.a(), paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare = new ApolloGameShare(paramActivity, CmGameUtil.a());
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  private void a(long paramLong, int paramInt, CmGameLauncher.RedPacketInfo paramRedPacketInfo)
  {
    ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.callbackFromRequest(paramLong, paramInt, "cs.get_redPacket_result.local", paramRedPacketInfo.a());
      paramRedPacketInfo.jdField_b_of_type_Int = 0;
      paramRedPacketInfo.jdField_a_of_type_Boolean = false;
      return;
    }
    QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[notifyRedPacketResult] cmdChannel is null");
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
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!ChannelConst.a(paramString1)) && (a(paramString1))) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "ssoCmdRule, [game],cmd:" + paramString1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString2);
        ((JSONObject)localObject2).put("from", "cmshow_game_" + this.jdField_a_of_type_Int);
        if ("apollo_router_game.apollo_user_rankinglist_linkcmd_custom_ranking".equals(paramString1))
        {
          paramString2 = CmGameUtil.a(this.jdField_a_of_type_Int);
          if ((paramString2 == null) || (paramString2.a() == null) || (TextUtils.isEmpty(paramString2.a().sessionUin))) {
            continue;
          }
          if (((JSONObject)localObject2).optInt("rankType", 0) != 0)
          {
            ((JSONObject)localObject2).put("rankType", ApolloUtil.e(paramString2.a().sessionType));
            ((JSONObject)localObject2).put("sessionId", Integer.parseInt(paramString2.a().sessionUin));
            paramString2 = CmGameUtil.a();
            if (paramString2 != null)
            {
              localObject1 = (TicketManager)paramString2.getManager(2);
              if (localObject1 != null)
              {
                localObject1 = ((TicketManager)localObject1).getSkey(paramString2.getCurrentAccountUin());
                paramString2 = (String)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramString2 = "";
                }
                ((JSONObject)localObject2).put("skey", paramString2);
              }
            }
          }
        }
        paramString2 = null;
        Object localObject1 = ((JSONObject)localObject2).toString();
        if ("apollo_router_game.game_ad_linkcmd_get_ad".equals(paramString1))
        {
          paramString2 = a((String)localObject1);
          bool = true;
          localObject2 = CmGameUtil.a();
          if (localObject2 == null) {
            break;
          }
          ((CmGameSSoHandler)localObject2).a(paramString1, (String)localObject1, paramLong, 4, bool, paramString2);
          break;
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[isSSoRequest] lancher or sessionUin is null");
          continue;
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
      }
      boolean bool = false;
    }
    return true;
  }
  
  private byte[] a(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
      Object localObject2 = new qq_ad_get.QQAdGet.UserInfo();
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(l);
      localQQAdGet.user_info.set((MessageMicro)localObject2);
      paramString = new JSONObject(paramString);
      localObject2 = new ArrayList();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set(paramString.optString("posid"));
      localPositionInfo.ad_count.set(paramString.optInt("count", 1));
      ((List)localObject2).add(localPositionInfo);
      localQQAdGet.position_info.set((List)localObject2);
      localObject1 = GdtDeviceUtil.a((Context)localObject1);
      localQQAdGet.device_info.set((MessageMicro)localObject1);
      localObject1 = new qq_ad_get.QQAdGet.ContextInfo();
      ((qq_ad_get.QQAdGet.ContextInfo)localObject1).article_id.set(paramString.optInt("game_id"));
      localQQAdGet.context_info.set((MessageMicro)localObject1);
      paramString = localQQAdGet.toByteArray();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "getAdPacket error:", paramString);
    }
    return null;
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
  
  private void b(long paramLong, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localObject == null) {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[hanldeGetRedPacketResult] luncher is null");
    }
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    for (;;)
    {
      int i;
      try
      {
        i = new JSONObject(paramString).optInt("score");
        ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int = i;
        if ((((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Int <= 0) || (((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int < ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Int)) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[hanldeGetRedPacketResult] score:" + ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int + "info.grabState:" + ((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_Int);
        }
        if (((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_Int == 3)
        {
          a(paramLong, 0, (CmGameLauncher.RedPacketInfo)localObject);
          if (!"0".equals(((CmGameLauncher.RedPacketInfo)localObject).jdField_f_of_type_JavaLangString)) {
            break label429;
          }
          QWalletTools.a(((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_JavaLangString, ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Long, ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_JavaLangString), bool1, false, this.jdField_a_of_type_Int);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_Int == 0)
      {
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          QWalletTools.a(CmGameUtil.a(), ((CmGameLauncher.RedPacketInfo)localObject).g + "", this.jdField_a_of_type_Int + "", i + "", new CmGameSubProcessHandler.1(this, null, paramLong));
        }
        ((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_Int = 1;
        return;
      }
      ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Boolean = true;
      return;
      label345:
      a(paramLong, 0, (CmGameLauncher.RedPacketInfo)localObject);
      if ("0".equals(((CmGameLauncher.RedPacketInfo)localObject).jdField_f_of_type_JavaLangString)) {}
      for (bool1 = bool2;; bool1 = false)
      {
        QWalletTools.a(((CmGameLauncher.RedPacketInfo)localObject).jdField_b_of_type_JavaLangString, ((CmGameLauncher.RedPacketInfo)localObject).jdField_a_of_type_Long, ((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_Int + "", Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject).jdField_d_of_type_JavaLangString), bool1, false, this.jdField_a_of_type_Int);
        return;
      }
      label429:
      bool1 = false;
    }
  }
  
  private void c()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      CmGameUtil.a(this.jdField_a_of_type_Int, localActivity);
    }
  }
  
  private void c(long paramLong, String paramString)
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localCmGameLauncher == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = new JSONObject(paramString).optInt("score");
        paramString = localCmGameLauncher.a();
        if (paramString != null)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "gameScore:" + i + ",target:" + paramString.jdField_a_of_type_Int);
          if ((paramString.jdField_a_of_type_Int > 0) && (i >= paramString.jdField_a_of_type_Int) && (paramString.jdField_b_of_type_Int == 0))
          {
            QWalletTools.a(CmGameUtil.a(), paramString.g + "", this.jdField_a_of_type_Int + "", i + "", new CmGameSubProcessHandler.2(this, null, paramLong));
            paramString.jdField_b_of_type_Int = 1;
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void c(String paramString)
  {
    ThreadManager.getUIHandler().post(new yxm(this, paramString));
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
    ThreadManager.getUIHandler().post(new yxn(this, paramString));
  }
  
  private void e(String paramString)
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
          localCmGameLauncher.c = 0;
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
            ThreadManager.getUIHandler().post(new yxo(this));
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
  
  private void f(String paramString)
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
  
  private void g(String paramString)
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
      f(paramString2);
    }
    for (;;)
    {
      return new HandleResult();
      if ("cs.make_room_min.local".equals(paramString1)) {
        c();
      } else if ("cs.close_room.local".equals(paramString1)) {
        d();
      } else if ("cs.report_data_2_compass.local".equals(paramString1)) {
        g(paramString2);
      } else if ("cs.invite_friends.local".equals(paramString1)) {
        e(paramString2);
      } else if ("cs.share_game_result.local".equals(paramString1)) {
        d(paramString2);
      } else if ("cs.share_pic.local".equals(paramString1)) {
        c(paramString2);
      } else if ("cs.first_frame_drawn.local".equals(paramString1)) {
        b();
      } else if ("cs.apolloGameWebMessage.local".equals(paramString1)) {
        ApolloGameBasicEventUtil.a(paramString2);
      } else if ("cs.openWebViewWithoutUrl.local".equals(paramString1)) {
        a(paramLong, paramString2);
      } else if ("cs.share_game_in_ark.local".equals(paramString1)) {
        ApolloGameBasicEventUtil.a(this.jdField_a_of_type_Int, paramString2, a());
      } else if ("cs.enter_pubAccount_card.local".equals(paramString1)) {
        b(paramString2);
      } else if ("cs.game_update_score.local".equals(paramString1)) {
        c(paramLong, paramString2);
      } else if ("cs.get_redPacket_result.local".equals(paramString1)) {
        b(paramLong, paramString2);
      } else if ("cs.fetch_cloud_signature.local".equals(paramString1)) {
        a(paramString2, paramLong);
      } else if ("cs.closeWebview.local".equals(paramString1)) {
        a(paramString2);
      }
    }
  }
  
  public void a() {}
  
  public void a(long paramLong, String paramString)
  {
    int i = this.jdField_b_of_type_Int;
    if (ApolloGameBasicEventUtil.a(a(), paramString, this.jdField_a_of_type_Int, i)) {}
    try
    {
      paramString = new JSONObject();
      paramString.put("taskId", i);
      ApolloCmdChannel localApolloCmdChannel = CmGameUtil.a();
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(paramLong, 0, "cs.openWebViewWithoutUrl.local", paramString.toString());
        this.jdField_b_of_type_Int += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      paramString = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (paramString != null) {
        paramString.a(i);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("now");
      }
      catch (Throwable paramString)
      {
        try
        {
          j = paramString.optInt("delta");
          paramString = ApolloGameInterfaceProxy.a(i, j, (CmGameInitParams)localObject);
          localObject = CmGameUtil.a();
          if (localObject == null) {
            break;
          }
          ((ApolloCmdChannel)localObject).callbackFromRequest(paramLong, 0, "cs.fetch_cloud_signature.local", paramString);
          return;
        }
        catch (Throwable paramString)
        {
          int i;
          int j;
          break label85;
        }
        paramString = paramString;
        i = 0;
      }
      label85:
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "get cloud errInfo->", paramString);
      j = 0;
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public void b(String paramString)
  {
    Activity localActivity = a();
    if ((TextUtils.isEmpty(paramString)) || (localActivity == null)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("puin");
      Intent localIntent = new Intent(localActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("report_src_param_type", "");
      localIntent.putExtra("report_src_param_name", "");
      localIntent.setFlags(67108864);
      localActivity.startActivityForResult(localIntent, 9999);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "ENTER_PUBACCOUNT_CARD error:", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler
 * JD-Core Version:    0.7.0.1
 */