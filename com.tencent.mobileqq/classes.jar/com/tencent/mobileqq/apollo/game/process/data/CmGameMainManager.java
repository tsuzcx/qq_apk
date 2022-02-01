package com.tencent.mobileqq.apollo.game.process.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.game.process.interfaces.OnApolloGameListener;
import com.tencent.mobileqq.apollo.game.process.ui.CmGameUIManager;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class CmGameMainManager
  implements OnApolloGameListener
{
  public CmGameInitParams a;
  CmGameMainManager.OpenKeyObserver jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager$OpenKeyObserver;
  private CmGameUIManager jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiCmGameUIManager;
  public StartCheckParam a;
  public boolean a;
  
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
    CmGameUIManager localCmGameUIManager = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiCmGameUIManager;
    if (localCmGameUIManager != null) {
      localCmGameUIManager.b();
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
        if (localAppInterface != null)
        {
          if (!((IPublicAccountDataManager)localAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong((String)localObject)))) {
            break label117;
          }
          i = 1;
          paramString.put("is_follow", i);
          CmGameCmdChannel.a((QQAppInterface)localAppInterface).a(0, "cs.check_pubAccount_state.local", paramString.toString(), paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "CHECK_FOLLOW_STATE error:", paramString);
      }
      return;
      label117:
      int i = 0;
    }
  }
  
  public void b()
  {
    CmGameUIManager localCmGameUIManager = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiCmGameUIManager;
    if (localCmGameUIManager != null) {
      localCmGameUIManager.c();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject2 = new JSONObject();
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).getInt("gameId");
        paramString = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId);
        int j = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId;
        if (i == j)
        {
          if ((paramString == null) || (paramString.needOpenKey == 1)) {
            break label274;
          }
          continue;
          if (System.currentTimeMillis() - paramString.lastRequestOpenKey > 3600000L)
          {
            localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
            localObject1 = (WtloginManager)((QQAppInterface)localObject1).getManager(1);
            this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager$OpenKeyObserver.a = paramString.gameId;
            this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager$OpenKeyObserver.b = paramInt;
            ((WtloginManager)localObject1).getOpenKeyWithoutPasswd((String)localObject2, 16L, paramString.appId, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameMainManager$OpenKeyObserver);
            paramString.lastRequestOpenKey = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("cmgame_process.CmGameMainManager", 2, "do get open key.");
            return;
          }
          ((JSONObject)localObject2).put("appId", paramString.appId);
          ((JSONObject)localObject2).put("gameId", paramString.gameId);
          ((JSONObject)localObject2).put("openKey", paramString.openKey);
          CmGameCmdChannel.a((AppInterface)localObject1).a(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
          return;
        }
        CmGameCmdChannel.a((AppInterface)localObject1).a(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "ON_GET_OPEN_KEY error:", paramString);
        return;
      }
      label274:
      if (paramString == null) {}
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams = null;
    CmGameUIManager localCmGameUIManager = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiCmGameUIManager;
    if (localCmGameUIManager != null) {
      localCmGameUIManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameMainManager
 * JD-Core Version:    0.7.0.1
 */