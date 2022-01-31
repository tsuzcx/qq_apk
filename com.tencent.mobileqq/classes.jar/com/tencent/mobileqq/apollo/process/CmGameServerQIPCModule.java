package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import yqa;
import yqb;
import yqc;
import yqd;

public class CmGameServerQIPCModule
  extends QIPCModule
{
  public static boolean a;
  public static boolean b;
  private CmGameLifeCycleMgr a;
  
  public CmGameServerQIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr = new CmGameLifeCycleMgr();
  }
  
  public static CmGameServerQIPCModule a()
  {
    return yqd.a();
  }
  
  public static void a()
  {
    CmGameServerQIPCModule localCmGameServerQIPCModule = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCServerHelper.getInstance().register(localCmGameServerQIPCModule);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a();
    }
    QLog.w("cmgame_process.CmGameServerQIPCModule", 1, "no running game.");
    return -1;
  }
  
  public CmGameLifeCycle a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a(paramInt);
    }
    return null;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "onCall main server action=" + paramString);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {}
    label543:
    label546:
    for (;;)
    {
      return null;
      if ("action_chanel_req".equals(paramString))
      {
        CmGameCmdChannel.a((QQAppInterface)localAppRuntime).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
        return null;
      }
      int i;
      if ("action_get_accountInfo".equals(paramString))
      {
        i = paramBundle.getInt("type");
        paramString = paramBundle.getString("uin");
        CmGameCmdChannel.a((QQAppInterface)localAppRuntime).a(paramInt, paramString, i);
        return null;
      }
      if ("action_loadyoutu".equals(paramString))
      {
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString == null) || (!(paramString instanceof QQAppInterface))) {
          break label543;
        }
      }
      for (paramString = (QQAppInterface)paramString;; paramString = null)
      {
        if (paramString == null) {
          break label546;
        }
        paramString = new ReadInJoyCameraCaptureSoManager(paramString, BaseApplicationImpl.getContext());
        b = true;
        paramString.a(new yqa(this, paramInt));
        paramString.a();
        return null;
        if ("onGameCheckStart".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONGAMECHECKSTART" });
          }
          if (paramBundle == null) {
            break;
          }
          paramString = CmGameUtil.a();
          if (!(paramString instanceof QQAppInterface)) {
            break;
          }
          paramString = (QQAppInterface)paramString;
          paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if ((paramBundle == null) || (paramBundle.game == null)) {
            break;
          }
          ApolloGameUtil.a(paramString, paramBundle.game.gameId);
          return null;
        }
        if ("onDownloadGameResDown".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
          }
          if (paramBundle == null) {
            break;
          }
          paramString = CmGameUtil.a();
          if (!(paramString instanceof QQAppInterface)) {
            break;
          }
          paramString = (QQAppInterface)paramString;
          paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if ((paramBundle == null) || (paramBundle.game == null)) {
            break;
          }
          ThreadManager.post(new yqb(this, paramString, paramBundle), 5, null, true);
          return null;
        }
        if ("game_activity_lifecycle".equals(paramString))
        {
          paramInt = paramBundle.getInt("gameId");
          i = paramBundle.getInt("status");
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a(paramInt, i);
          return null;
        }
        if (!"action_get_action_data".equals(paramString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA params:" + paramBundle });
        }
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
        for (paramString = (QQAppInterface)paramString; paramString != null; paramString = null)
        {
          ThreadManager.post(new yqc(this, paramString, paramBundle.getString("reqData"), paramInt), 5, null, true);
          return null;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */