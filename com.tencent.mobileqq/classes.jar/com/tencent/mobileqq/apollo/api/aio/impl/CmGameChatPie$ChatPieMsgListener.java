package com.tencent.mobileqq.apollo.api.aio.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.DefaultMsgUIHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.TopGameInfo;
import com.tencent.mobileqq.apollo.lightGame.RobotDataUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

class CmGameChatPie$ChatPieMsgListener
  extends CmGameTempSessionHandler.DefaultMsgUIHandler
{
  private WeakReference<CmGameChatPie> a;
  
  CmGameChatPie$ChatPieMsgListener(CmGameChatPie paramCmGameChatPie)
  {
    this.a = new WeakReference(paramCmGameChatPie);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onPushPlaymateExitAio] friendUin:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    CmGameChatPie localCmGameChatPie;
    do
    {
      return;
      localCmGameChatPie = (CmGameChatPie)this.a.get();
    } while ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(localCmGameChatPie.b())));
    localCmGameChatPie.a(paramString, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "", 3);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.b()))) {
      return;
    }
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      localCmGameChatPie.u(bool);
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onQueryUserStatus] friendUin:" + paramString + ",status:" + paramInt1 + ",lastTs:" + paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (!localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.11(this, localCmGameChatPie, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.9(this, localCmGameChatPie, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt, List<MessageForApollo> paramList)
  {
    super.a(paramString, paramInt, paramList);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        if (CmGameChatPie.a(localCmGameChatPie) != null) {
          CmGameChatPie.a(localCmGameChatPie).dismiss();
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      localQQAppInterface = localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite msgs == null || msgs.isEmpty()");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameChatPie", 2, new Object[] { "onAcceptMyInvite friendUin:", paramString, " msgs.size:", Integer.valueOf(paramList.size()) });
    }
    if (CmGameChatPie.a(localCmGameChatPie))
    {
      QLog.e("CmGameChatPie", 1, "onAcceptMyInvite chatPie.mStoped");
      return;
    }
    paramString = (MessageForApollo)paramList.get(0);
    paramString = new CmGameStartChecker.StartCheckParam(paramString.gameId, paramString.isSend(), "message", paramString.roomId, 1, 0, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localQQAppInterface, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, CmGameChatPie.c(localCmGameChatPie), paramString.gameName);
    paramString.mTempAIOUin = localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localCmGameChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    CmGameChatPie.O = true;
  }
  
  public void a(String paramString, CmGameChatPie.UserInfo paramUserInfo)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.1(this, localCmGameChatPie, paramString, paramUserInfo));
  }
  
  public void a(String paramString, CmGameTempSessionHandler.TopGameInfo paramTopGameInfo)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localCmGameChatPie.a(paramTopGameInfo);
  }
  
  public void a(String paramString, List<ApolloGameData> paramList)
  {
    super.a(paramString, paramList);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localCmGameChatPie.b(paramList);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    paramString = (CmGameChatPie)this.a.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    paramString.u(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId createSuccess:false");
          ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.7(this, localCmGameChatPie));
          return;
        }
      } while (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (CmGameChatPie.a(localCmGameChatPie) != paramInt2) {
        break label221;
      }
      if (!RobotDataUtil.a(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (CmGameChatPie.a(localCmGameChatPie) == null);
    String str = CmGameChatPie.a(localCmGameChatPie).a();
    if (CmGameChatPie.d(localCmGameChatPie) == paramInt2)
    {
      CmGameSessionUtil.a(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramLong, paramInt1);
      localCmGameChatPie.c(paramLong);
      return;
    }
    localCmGameChatPie.a(paramInt1, paramLong);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.8(this, localCmGameChatPie, paramInt1, paramLong, str), 1500L);
    return;
    ((IApolloManagerService)localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
    return;
    label221:
    QLog.e("CmGameTemp_CmGameChatPie", 1, "onCreateRoomId chatPie.mCreateRoomReqCode != reqCode, reqCode:" + paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean, paramString, paramInt, paramLong);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      localCmGameChatPie.a(paramInt, paramLong);
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.2(this, localCmGameChatPie, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super.a(paramBoolean, paramString1, paramInt, paramLong, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameChatPie", 2, "[onCheckRobotModeRsp] friendUin:" + paramString1 + ",gameId:" + paramInt + ",roomId:" + paramLong);
    }
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
      return;
    }
    long l = System.currentTimeMillis() - CmGameSessionUtil.jdField_a_of_type_Long;
    if (l > 1500L)
    {
      localCmGameChatPie.a(paramInt, paramLong, paramString2);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CmGameChatPie.ChatPieMsgListener.12(this, localCmGameChatPie, paramInt, paramLong, paramString2), 1500L - l);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong)
  {
    super.a(paramBoolean1, paramBoolean2, paramString, paramInt, paramLong);
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!paramBoolean1));
      if (CmGameChatPie.a(localCmGameChatPie))
      {
        QLog.e("CmGameTemp_CmGameChatPie", 1, "onOneMoreGameRspFinish chatPie.mStoped");
        return;
      }
    } while ((!paramBoolean2) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (CmGameChatPie.a(localCmGameChatPie) == null));
    paramString = new CmGameStartChecker.StartCheckParam(CmGameChatPie.a(localCmGameChatPie).jdField_a_of_type_Int, true, "message", CmGameChatPie.a(localCmGameChatPie).jdField_a_of_type_Long, 1, 0, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, CmGameChatPie.c(localCmGameChatPie), null);
    paramString.mTempAIOUin = localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramString.mTempAIONickName = localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    paramString.disableMinGame = true;
    ApolloGameUtil.a(localCmGameChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
    CmGameChatPie.O = true;
    CmGameSessionUtil.b(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void b(String paramString)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.3(this, localCmGameChatPie, paramString));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (!paramBoolean) {
      CmGameSessionUtil.a(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
    }
    if (CmGameChatPie.a(localCmGameChatPie))
    {
      QLog.e("CmGameTemp_CmGameChatPie", 1, "onPushOneMoreGameMsgRsp chatPie.mStoped");
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.10(this, paramBoolean, localCmGameChatPie, paramInt, paramLong));
  }
  
  public void c(String paramString)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.4(this, localCmGameChatPie, paramString));
  }
  
  public void d(String paramString)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.5(this, localCmGameChatPie, paramString));
  }
  
  public void e(String paramString)
  {
    CmGameChatPie localCmGameChatPie = (CmGameChatPie)this.a.get();
    if ((localCmGameChatPie == null) || (localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equals(localCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.ChatPieMsgListener.6(this, localCmGameChatPie, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.ChatPieMsgListener
 * JD-Core Version:    0.7.0.1
 */