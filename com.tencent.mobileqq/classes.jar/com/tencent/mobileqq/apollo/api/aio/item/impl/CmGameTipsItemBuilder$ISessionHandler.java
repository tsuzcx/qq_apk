package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.DefaultMsgUIHandler;
import com.tencent.mobileqq.apollo.lightGame.RobotDataUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CmGameTipsItemBuilder$ISessionHandler
  extends CmGameTempSessionHandler.DefaultMsgUIHandler
{
  public int a;
  private WeakReference<CmGameTipsItemBuilder> a;
  
  public CmGameTipsItemBuilder$ISessionHandler(CmGameTipsItemBuilder paramCmGameTipsItemBuilder)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameTipsItemBuilder);
  }
  
  public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
      return;
    }
    CmGameTipsItemBuilder localCmGameTipsItemBuilder = (CmGameTipsItemBuilder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localCmGameTipsItemBuilder == null) || (localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((IApolloDaoManagerService)localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      CmGameSessionUtil.a(localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      CmGameTipsItemBuilder.a(localCmGameTipsItemBuilder).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localCmGameTipsItemBuilder, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      CmGameTipsItemBuilder.a(localCmGameTipsItemBuilder).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localCmGameTipsItemBuilder, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    CmGameTipsItemBuilder.a(localCmGameTipsItemBuilder).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localCmGameTipsItemBuilder));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    CmGameTipsItemBuilder localCmGameTipsItemBuilder = (CmGameTipsItemBuilder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCmGameTipsItemBuilder == null) {
      break label17;
    }
    label17:
    while (localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId createSuccess:false");
      return;
    }
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    ApolloGameMsgInfo localApolloGameMsgInfo = new ApolloGameMsgInfo();
    Object localObject = (IApolloDaoManagerService)localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    String str = HardCodeUtil.a(2131702182);
    ApolloGameData localApolloGameData = ((IApolloDaoManagerService)localObject).findGameById(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((IApolloDaoManagerService)localObject).findActionById(localApolloGameData.actionId);
      if (localObject == null) {
        break label304;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label304:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localApolloGameMsgInfo.gameName = localApolloGameData.name;
      for (;;)
      {
        localApolloGameMsgInfo.actionName = str;
        localApolloGameMsgInfo.actionId = paramInt2;
        localApolloGameMsgInfo.roomId = paramLong;
        localApolloGameMsgInfo.gameId = paramInt1;
        localApolloGameMsgInfo.msgType = 3;
        localApolloGameMsgInfo.gameStatus = 0;
        if ((localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        CmGameSessionUtil.a(localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localApolloGameMsgInfo);
        if (!RobotDataUtil.a(localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          break;
        }
        ((IApolloManagerService)localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().b(localCmGameTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramInt1, paramLong);
        return;
        localApolloGameMsgInfo.gameName = HardCodeUtil.a(2131702183);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.CmGameTipsItemBuilder.ISessionHandler
 * JD-Core Version:    0.7.0.1
 */